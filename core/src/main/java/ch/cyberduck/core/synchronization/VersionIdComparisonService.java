package ch.cyberduck.core.synchronization;

/*
 * Copyright (c) 2002-2022 iterate GmbH. All rights reserved.
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

import ch.cyberduck.core.Path;
import ch.cyberduck.core.PathAttributes;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class VersionIdComparisonService implements ComparisonService {
    private static final Logger log = LogManager.getLogger(VersionIdComparisonService.class.getName());

    @Override
    public Comparison compare(final Path.Type type, final PathAttributes local, final PathAttributes remote) {
        if(null != local.getVersionId() && null != remote.getVersionId()) {
            if(log.isDebugEnabled()) {
                log.debug(String.format("Compare local attributes %s with remote %s", local, remote));
            }
            // Version can be nullified in attributes from transfer status. In this case assume not equal even when revision is the same.
            if(StringUtils.equals(local.getVersionId(), remote.getVersionId())) {
                // No conflict. Proceed with overwrite
                if(log.isDebugEnabled()) {
                    log.debug(String.format("Equal versionId %s", remote.getVersionId()));
                }
                return Comparison.equal;
            }
            if(log.isDebugEnabled()) {
                log.debug(String.format("Local version id %s not equal remote %s", local.getVersionId(), remote.getVersionId()));
            }
            return Comparison.notequal;
        }
        return Comparison.unknown;
    }
}
