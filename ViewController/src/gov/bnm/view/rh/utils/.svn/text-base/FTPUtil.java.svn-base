package gov.bnm.view.rh.utils;

import gov.bnm.email.Util.FileUtil;
import gov.bnm.email.property.PropertyFileConfigManager;

import gov.bnm.view.rh.session.RHSession;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


import java.net.SocketException;

import java.util.Properties;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.log4j.Logger;
import org.apache.myfaces.trinidad.model.UploadedFile;


public class FTPUtil {

    static Logger log = Logger.getLogger(FTPUtil.class);

    private static FTPUtil instance;
    RHSession rhSession = (RHSession)JSFUtils.getFromSession("rhSession");

    private FTPUtil() {
        // prevent instantiation
    }

    public static FTPUtil getInstance() {
        if (instance == null) {
            instance = new FTPUtil();
        }
        return instance;
    }

    public boolean transferFile(UploadedFile uploadedFile, String name,
                                boolean isBinary) throws SocketException,
                                                         IOException {
        return transferFile(uploadedFile, name, isBinary, null);
    }

    public boolean transferFile(UploadedFile uploadedFile, String name,
                                boolean isBinary,
                                String targetFolder) throws SocketException,
                                                            IOException {
        boolean returnVal = false;
        PropertyFileConfigManager propertyFileConfigManager =
            PropertyFileConfigManager.getInstance();
        Properties props = rhSession.getProps();

        String ftpServer = props.getProperty("ftp.server");
        int ftpPort = Integer.parseInt(props.getProperty("ftp.port"));
        String ftpUser = props.getProperty("ftp.user");
        String ftpPwd = props.getProperty("ftp.password");

        FTPClient ftp = new FTPClient();
        //ftp.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
        log.info("ftpServer::" + ftpServer);
        log.info("ftpPort::" + ftpPort);
        ftp.connect(ftpServer, ftpPort);
        log.info("getReplyCode::" + ftp.getReplyCode());
        try {

            if (!FTPReply.isPositiveCompletion(ftp.getReplyCode())) {
                ftp.disconnect();
                log.info("FTP server refused connection.");
            } else {
                if (!ftp.login(ftpUser, ftpPwd)) {
                    ftp.logout();
                } else {
                    if (isBinary) {
                        ftp.setFileType(FTP.BINARY_FILE_TYPE);
                    }
                    if (targetFolder != null) {
                        ftp.changeWorkingDirectory(targetFolder);
                        log.info("Change FTP working directory to : " +
                                 targetFolder);
                    }
                    log.info("Current FTP working directory is : " +
                             ftp.printWorkingDirectory());
                    InputStream in;
                    if (uploadedFile != null && uploadedFile.getLength() > 0) {
                        in = uploadedFile.getInputStream();
                        OutputStream out = ftp.storeFileStream(name);
                        log.info("uploadedFile Length : " +
                                 uploadedFile.getLength());
                        log.info("in Length : " + in.toString());
                        for (int bytes = 0; bytes < uploadedFile.getLength();
                             bytes++) {
                            out.write(in.read());
                        }
                        in.close();
                        out.close();
                        log.info("out Length : " + out.toString());
                        ftp.enterLocalPassiveMode();
                        returnVal = ftp.completePendingCommand();
                        if (returnVal) {
                            log.info("The file is uploaded successfully.");
                        }
                        // returnVal = ftp.storeFile(name, in);
                    }
                }
            }
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
        return returnVal;
    }

    public boolean deleteFile(String fileName,
                              String targetFolder) throws SocketException,
                                                          IOException {
        boolean returnVal = false;
        PropertyFileConfigManager propertyFileConfigManager =
            PropertyFileConfigManager.getInstance();
        Properties props = rhSession.getProps();

        String ftpServer = props.getProperty("ftp.server");
        int ftpPort = Integer.parseInt(props.getProperty("ftp.port"));
        String ftpUser = props.getProperty("ftp.user");
        String ftpPwd = props.getProperty("ftp.password");

        FTPClient ftp = new FTPClient();
        //ftp.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
        ftp.connect(ftpServer, ftpPort);

        try {

            if (!FTPReply.isPositiveCompletion(ftp.getReplyCode())) {
                ftp.disconnect();
                log.info("FTP server refused connection.");
            } else {
                if (!ftp.login(ftpUser, ftpPwd)) {
                    ftp.logout();
                } else {
                    if (targetFolder != null) {
                        ftp.changeWorkingDirectory(targetFolder);
                        log.info("Change FTP working directory to : " +
                                 targetFolder);
                    }
                    log.info("Current FTP working directory is : " +
                             ftp.printWorkingDirectory());

                    if (fileName != null && !fileName.equals("")) {
                        ftp.enterLocalPassiveMode();
                        returnVal = ftp.deleteFile(fileName);
                    }
                }
            }
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
        return returnVal;
    }

    public boolean downloadFile(String fileName, OutputStream out,
                                String targetFolder) throws SocketException,
                                                            IOException {
        boolean returnVal = false;
        PropertyFileConfigManager propertyFileConfigManager =
            PropertyFileConfigManager.getInstance();
        Properties props = rhSession.getProps();

        String ftpServer = props.getProperty("ftp.server");
        int ftpPort = Integer.parseInt(props.getProperty("ftp.port"));
        String ftpUser = props.getProperty("ftp.user");
        String ftpPwd = props.getProperty("ftp.password");

        FTPClient ftp = new FTPClient();
        //ftp.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
        ftp.connect(ftpServer, ftpPort);

        try {

            if (!FTPReply.isPositiveCompletion(ftp.getReplyCode())) {
                ftp.disconnect();
                log.info("FTP server refused connection.");
            } else {
                if (!ftp.login(ftpUser, ftpPwd)) {
                    ftp.logout();
                } else {
                    if (targetFolder != null) {
                        ftp.changeWorkingDirectory(targetFolder);
                        log.info("Change FTP working directory to : " +
                                 targetFolder);
                    }
                    log.info("Current FTP working directory is : " +
                             ftp.printWorkingDirectory());

                    if (fileName != null && !fileName.equals("")) {
                        ftp.enterLocalPassiveMode();
                        returnVal = ftp.retrieveFile(fileName, out);
                    }
                }
            }
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
        return returnVal;
    }
}
