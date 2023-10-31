package ch.cyberduck.core.diagnostics;

/*
 * Copyright (c) 2002-2023 iterate GmbH. All rights reserved.
 * https://cyberduck.io/
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 */

import ch.cyberduck.core.CertificateStore;
import ch.cyberduck.core.CertificateStoreFactory;
import ch.cyberduck.core.DisabledCertificateIdentityCallback;
import ch.cyberduck.core.DisabledCertificateTrustCallback;
import ch.cyberduck.core.DisabledLoginCallback;
import ch.cyberduck.core.DisabledTranscriptListener;
import ch.cyberduck.core.Host;
import ch.cyberduck.core.HostUrlProvider;
import ch.cyberduck.core.http.HttpConnectionPoolBuilder;
import ch.cyberduck.core.proxy.ProxyFactory;
import ch.cyberduck.core.proxy.ProxyFinder;
import ch.cyberduck.core.ssl.DefaultTrustManagerHostnameCallback;
import ch.cyberduck.core.ssl.KeychainX509KeyManager;
import ch.cyberduck.core.ssl.KeychainX509TrustManager;
import ch.cyberduck.core.ssl.ThreadLocalHostnameDelegatingTrustManager;
import ch.cyberduck.core.ssl.X509KeyManager;
import ch.cyberduck.core.ssl.X509TrustManager;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.net.ssl.SSLException;
import java.io.IOException;
import java.net.SocketException;

public class HttpReachability implements Reachability {
    private static final Logger log = LogManager.getLogger(HttpReachability.class);

    private final ProxyFinder proxy;
    private final CertificateStore store;

    public HttpReachability() {
        this(ProxyFactory.get(), CertificateStoreFactory.get());
    }

    public HttpReachability(final ProxyFinder proxy, final CertificateStore store) {
        this.proxy = proxy;
        this.store = store;
    }

    @Override
    public boolean isReachable(final Host bookmark) {
        final X509TrustManager trust = new KeychainX509TrustManager(new DisabledCertificateTrustCallback(),
                new DefaultTrustManagerHostnameCallback(bookmark), store);
        final X509KeyManager key = new KeychainX509KeyManager(new DisabledCertificateIdentityCallback(), bookmark,
                store);
        final HttpConnectionPoolBuilder builder = new HttpConnectionPoolBuilder(bookmark,
                new ThreadLocalHostnameDelegatingTrustManager(trust, bookmark.getHostname()), key, Reachability.timeout, proxy);
        final HttpClientBuilder configuration = builder.build(proxy.find(new HostUrlProvider().get(bookmark)),
                new DisabledTranscriptListener(), new DisabledLoginCallback());
        try (CloseableHttpClient client = configuration.build()) {
            final HttpRequestBase resource = new HttpHead(new HostUrlProvider().withUsername(false).withPath(true).get(bookmark));
            client.execute(resource);
        }
        catch(ClientProtocolException e) {
            if(log.isWarnEnabled()) {
                log.warn(String.format("Ignore HTTP error response %s", e));
            }
        }
        catch(SSLException e) {
            if(log.isWarnEnabled()) {
                log.warn(String.format("Ignore SSL failure %s", e));
            }
            return true;
        }
        catch(SocketException e) {
            if(log.isWarnEnabled()) {
                log.warn(String.format("Failure %s opening socket for %s", e, bookmark));
            }
            return false;
        }
        catch(IOException e) {
            if(log.isWarnEnabled()) {
                log.warn(String.format("Generic failure %s for %s", e, bookmark));
            }
            return false;
        }
        // Ignore
        return true;
    }

    @Override
    public Monitor monitor(final Host bookmark, final Callback callback) {
        return Monitor.disabled;
    }
}
