package ch.cyberduck.core.io;

/*
 * Copyright (c) 2002-2015 David Kocher. All rights reserved.
 * http://cyberduck.io/
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * Bug fixes, suggestions and comments should be sent to:
 * feedback@cyberduck.io
 */

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

public final class Checksum {
    private static final Logger log = Logger.getLogger(Checksum.class);

    public final HashAlgorithm algorithm;
    public final String hash;

    public Checksum(final HashAlgorithm algorithm, final String hash) {
        this.algorithm = algorithm;
        this.hash = hash;
    }

    @Override
    public String toString() {
        return hash;
    }

    public static Checksum parse(final String hash) {
        if(StringUtils.isBlank(hash)) {
            return Checksum.NONE;
        }
        switch(hash.length()) {
            case 8:
                if(hash.matches("[a-fA-F0-9]{8}")) {
                    return new Checksum(HashAlgorithm.crc32, hash);
                }
                break;
            case 32:
                if(hash.matches("[a-fA-F0-9]{32}")) {
                    return new Checksum(HashAlgorithm.md5, hash);
                }
                break;
            case 40:
                if(hash.matches("[a-fA-F0-9]{40}")) {
                    return new Checksum(HashAlgorithm.sha1, hash);
                }
                break;
            case 64:
                if(hash.matches("[A-Fa-f0-9]{64}")) {
                    return new Checksum(HashAlgorithm.sha256, hash);
                }
                break;
            case 128:
                if(hash.matches("[A-Fa-f0-9]{128}")) {
                    return new Checksum(HashAlgorithm.sha512, hash);
                }
                break;
            default:
                log.warn(String.format("Failure to detect algorithm for checksum %s", hash));
        }
        return Checksum.NONE;
    }

    @Override
    public boolean equals(final Object o) {
        if(this == o) {
            return true;
        }
        if(o == null || getClass() != o.getClass()) {
            return false;
        }
        final Checksum checksum = (Checksum) o;
        if(algorithm != checksum.algorithm) {
            return false;
        }
        if(!StringUtils.equalsIgnoreCase(hash, checksum.hash)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = algorithm != null ? algorithm.hashCode() : 0;
        result = 31 * result + (hash != null ? hash.hashCode() : 0);
        return result;
    }

    public static final Checksum NONE = new Checksum(null, null);
}
