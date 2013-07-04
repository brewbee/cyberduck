package ch.cyberduck.ui.cocoa.threading;

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

import ch.cyberduck.core.exception.BackgroundException;
import ch.cyberduck.ui.action.Worker;
import ch.cyberduck.ui.cocoa.BrowserController;

import org.apache.log4j.Logger;

/**
 * @version $Id$
 */
public class WorkerBackgroundAction<T> extends BrowserBackgroundAction {
    private static Logger log = Logger.getLogger(WorkerBackgroundAction.class);

    private Worker<T> worker;

    private T result;

    public WorkerBackgroundAction(final BrowserController controller, final Worker<T> worker) {
        super(controller);
        this.worker = worker;
    }

    @Override
    public void run() throws BackgroundException {
        result = worker.run();
    }

    @Override
    public void cleanup() {
        if(null == result) {
            log.error(String.format("Null result for worker %s", this));
        }
        worker.cleanup(result);
    }

    @Override
    public String getActivity() {
        return worker.getActivity();
    }
}
