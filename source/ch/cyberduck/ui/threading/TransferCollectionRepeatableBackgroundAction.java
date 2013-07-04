package ch.cyberduck.ui.threading;

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

import ch.cyberduck.core.Preferences;
import ch.cyberduck.core.ProgressListener;
import ch.cyberduck.core.Session;
import ch.cyberduck.core.TranscriptListener;
import ch.cyberduck.core.exception.BackgroundException;
import ch.cyberduck.core.threading.AlertCallback;
import ch.cyberduck.core.transfer.Transfer;
import ch.cyberduck.core.transfer.TransferCollection;
import ch.cyberduck.core.transfer.TransferOptions;
import ch.cyberduck.core.transfer.TransferPrompt;
import ch.cyberduck.ui.Controller;

import org.apache.log4j.Logger;

/**
 * @version $Id$
 */
public class TransferCollectionRepeatableBackgroundAction extends TransferRepeatableBackgroundAction {
    private static final Logger log = Logger.getLogger(TransferCollectionRepeatableBackgroundAction.class);

    public TransferCollectionRepeatableBackgroundAction(final Controller controller, final AlertCallback alert,
                                                        final ProgressListener progressListener, final TranscriptListener transcriptListener,
                                                        final Transfer transfer, final TransferPrompt prompt, final TransferOptions options) {
        super(controller, alert, progressListener, transcriptListener, transfer, prompt, options);
    }

    @Override
    public void finish() throws BackgroundException {
        if(log.isDebugEnabled()) {
            log.debug(String.format("Finish background action for transfer %s", transfer));
        }
        super.finish();
        for(Session s : transfer.getSessions()) {
            s.close();
            // We have our own session independent of any browser.
            s.cache().clear();
        }
    }

    @Override
    public void cleanup() {
        if(log.isDebugEnabled()) {
            log.debug(String.format("Cleanup background action for transfer %s", transfer));
        }
        super.cleanup();
        final TransferCollection collection = TransferCollection.defaultCollection();
        if(transfer.isComplete() && !transfer.isCanceled() && transfer.isReset()) {
            if(Preferences.instance().getBoolean("queue.removeItemWhenComplete")) {
                collection.remove(transfer);
            }
        }
        collection.save();
    }
}
