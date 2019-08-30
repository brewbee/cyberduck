package ch.cyberduck.core.storegate;

/*
 * Copyright (c) 2002-2019 iterate GmbH. All rights reserved.
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

import ch.cyberduck.core.AlphanumericRandomStringService;
import ch.cyberduck.core.Path;
import ch.cyberduck.core.transfer.TransferStatus;
import ch.cyberduck.test.IntegrationTest;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.EnumSet;

import static org.junit.Assert.assertNotEquals;

@Category(IntegrationTest.class)
public class StoregateAttributesFinderFeatureTest extends AbstractStoregateTest {

    @Test
    public void testFind() throws Exception {
        final StoregateIdProvider nodeid = new StoregateIdProvider(session).withCache(cache);
        final Path room = new StoregateDirectoryFeature(session, nodeid).mkdir(
            new Path(String.format("/Home/mduck/%s", new AlphanumericRandomStringService().random()),
                EnumSet.of(Path.Type.directory, Path.Type.volume)), null, new TransferStatus());
        final Path test = new StoregateTouchFeature(session, nodeid).touch(
            new Path(room, String.format("%s", new AlphanumericRandomStringService().random()), EnumSet.of(Path.Type.file)), new TransferStatus());
        assertNotEquals(0L, new StoregateAttributesFinderFeature(session, nodeid).find(test).getModificationDate());
    }
}
