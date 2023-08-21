package ch.cyberduck.core.smb;

import ch.cyberduck.core.ConnectionCallback;
import ch.cyberduck.core.Path;
import ch.cyberduck.core.exception.BackgroundException;
import ch.cyberduck.core.features.Copy;
import ch.cyberduck.core.features.Directory;
import ch.cyberduck.core.io.StreamListener;
import ch.cyberduck.core.transfer.TransferStatus;

import java.text.MessageFormat;
import java.util.HashSet;
import java.util.Set;

import com.hierynomus.msdtyp.AccessMask;
import com.hierynomus.msfscc.FileAttributes;
import com.hierynomus.mssmb2.SMB2CreateDisposition;
import com.hierynomus.mssmb2.SMB2CreateOptions;
import com.hierynomus.mssmb2.SMB2ShareAccess;
import com.hierynomus.protocol.commons.buffer.Buffer.BufferException;
import com.hierynomus.protocol.transport.TransportException;
import com.hierynomus.smbj.common.SMBRuntimeException;
import com.hierynomus.smbj.share.File;

public class SMBCopyFeature implements Copy {

    private final SMBSession session;

    public SMBCopyFeature(SMBSession session) {
        this.session = session;
    }

    @Override
    public Path copy(Path source, Path target, TransferStatus status, ConnectionCallback prompt,
                     StreamListener listener) throws BackgroundException {
        try {
            if(source.isFile()) {
                copyFile(source, target);
            }
            else {
                copyDirectory(target);
            }
            return target;
        }
        catch(SMBRuntimeException e) {
            throw new SMBExceptionMappingService().map("Cannot copy {0}", e, source);
        }
    }

    private void copyDirectory(Path target) throws BackgroundException {
        if(!session.share.folderExists(target.toString())) {
            session.getFeature(Directory.class).mkdir(target, null);
        }

    }

    private void copyFile(Path source, Path target) throws BackgroundException {

        Set<SMB2ShareAccess> shareAccessSet = new HashSet<>();
        shareAccessSet.add(SMB2ShareAccess.FILE_SHARE_READ);
        shareAccessSet.add(SMB2ShareAccess.FILE_SHARE_WRITE);
        shareAccessSet.add(SMB2ShareAccess.FILE_SHARE_DELETE);

        Set<FileAttributes> fileAttributes = new HashSet<>();
        fileAttributes.add(FileAttributes.FILE_ATTRIBUTE_NORMAL);
        Set<SMB2CreateOptions> createOptions = new HashSet<>();
        SMB2CreateDisposition smb2CreateDisposition = SMB2CreateDisposition.FILE_OPEN_IF;

        Set<AccessMask> accessMask = new HashSet<>();
        accessMask.add(AccessMask.MAXIMUM_ALLOWED);

        createOptions.add(SMB2CreateOptions.FILE_NON_DIRECTORY_FILE);

        File sourceFile = session.share.openFile(SMBUtils.convertedAbsolutePath(source), accessMask, fileAttributes,
                shareAccessSet, smb2CreateDisposition, createOptions);

        File targetFile = session.share.openFile(SMBUtils.convertedAbsolutePath(target), accessMask, fileAttributes,
                shareAccessSet, smb2CreateDisposition, createOptions);

        try {
            sourceFile.remoteCopyTo(targetFile);
        }
        catch(TransportException | BufferException e) {
            throw new BackgroundException(e);
        }
        finally {
            sourceFile.close();
            targetFile.close();
        }

    }

}
