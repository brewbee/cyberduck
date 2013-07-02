package ch.cyberduck.core.transfer.upload;

/*
 * Copyright (c) 2002-2013 David Kocher. All rights reserved.
 * http://cyberduck.ch/
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
 * Bug fixes, suggestions and comments should be sent to feedback@cyberduck.ch
 */

import ch.cyberduck.core.AttributedList;
import ch.cyberduck.core.Attributes;
import ch.cyberduck.core.Path;
import ch.cyberduck.core.PathAttributes;
import ch.cyberduck.core.Permission;
import ch.cyberduck.core.Preferences;
import ch.cyberduck.core.Session;
import ch.cyberduck.core.local.Local;
import ch.cyberduck.core.threading.BackgroundException;
import ch.cyberduck.core.transfer.TransferOptions;
import ch.cyberduck.core.transfer.TransferPathFilter;
import ch.cyberduck.core.transfer.TransferStatus;
import ch.cyberduck.core.transfer.symlink.SymlinkResolver;

import org.apache.log4j.Logger;

/**
 * @version $Id$
 */
public abstract class AbstractUploadFilter implements TransferPathFilter {
    private static final Logger log = Logger.getLogger(AbstractUploadFilter.class);

    private SymlinkResolver symlinkResolver;

    public AbstractUploadFilter(final SymlinkResolver symlinkResolver) {
        this.symlinkResolver = symlinkResolver;
    }

    @Override
    public boolean accept(final Session session, final Path file) throws BackgroundException {
        final PathAttributes attributes = file.attributes();
        if(attributes.isDirectory()) {
            // Do not attempt to create a directory that already exists
            if(file.exists()) {
                return false;
            }
        }
        if(attributes.isFile()) {
            if(!file.getLocal().exists()) {
                // Local file is no more here
                return false;
            }
            if(file.getLocal().attributes().isSymbolicLink()) {
                if(!symlinkResolver.resolve(file)) {
                    return symlinkResolver.include(file);
                }
            }
        }
        return true;
    }

    @Override
    public TransferStatus prepare(final Session session, final Path file) throws BackgroundException {
        final PathAttributes attributes = file.attributes();
        if(Preferences.instance().getBoolean("queue.upload.changePermissions")) {
            if(file.exists()) {
                // Do not overwrite permissions for existing file.
                if(file.getSession().isUnixPermissionsSupported()) {
                    file.readUnixPermission();
                }
                // Do not overwrite ACL for existing file.
                if(file.getSession().isAclSupported()) {
                    file.readAcl();
                }
            }
            else {
                if(file.getSession().isUnixPermissionsSupported()) {
                    if(Preferences.instance().getBoolean("queue.upload.permissions.useDefault")) {
                        if(attributes.isFile()) {
                            attributes.setPermission(new Permission(
                                    Preferences.instance().getInteger("queue.upload.permissions.file.default")));
                        }
                        else if(attributes.isDirectory()) {
                            attributes.setPermission(new Permission(
                                    Preferences.instance().getInteger("queue.upload.permissions.folder.default")));
                        }
                    }
                    else {
                        // Read permissions from local file
                        attributes.setPermission(file.getLocal().attributes().getPermission());
                    }
                }
                if(file.getSession().isAclSupported()) {
                    // ACL set on object creation with default from Preferences
                }
            }
        }
        final TransferStatus status = new TransferStatus();
        if(attributes.isFile()) {
            if(file.getLocal().attributes().isSymbolicLink()) {
                if(symlinkResolver.resolve(file)) {
                    // No file size increase for symbolic link to be created on the server
                }
                else {
                    // Will resolve the symbolic link when the file is requested.
                    final Local target = file.getLocal().getSymlinkTarget();
                    status.setLength(target.attributes().getSize());
                }
            }
            else {
                // Read file size from filesystem
                status.setLength(file.getLocal().attributes().getSize());
            }
        }
        if(attributes.isDirectory()) {
            if(!file.exists()) {
                file.getSession().cache().put(file.getReference(), AttributedList.<Path>emptyList());
            }
        }
        return status;
    }

    @Override
    public void complete(final Session session, final Path file, final TransferOptions options, final TransferStatus status) throws BackgroundException {
        if(log.isDebugEnabled()) {
            log.debug(String.format("Complete %s with status %s", file.getAbsolute(), status));
        }
        if(status.isComplete()) {
            if(file.getSession().isUnixPermissionsSupported()) {
                if(Preferences.instance().getBoolean("queue.upload.changePermissions")) {
                    Permission permission = file.attributes().getPermission();
                    if(!Permission.EMPTY.equals(permission)) {
                        file.writeUnixPermission(permission);
                    }
                }
            }
            if(file.getSession().isWriteTimestampSupported()) {
                if(Preferences.instance().getBoolean("queue.upload.preserveDate")) {
                    // Read timestamps from local file
                    final Attributes attributes = file.getLocal().attributes();
                    file.writeTimestamp(attributes.getCreationDate(),
                            attributes.getModificationDate(),
                            attributes.getAccessedDate());
                }
            }
        }
    }
}