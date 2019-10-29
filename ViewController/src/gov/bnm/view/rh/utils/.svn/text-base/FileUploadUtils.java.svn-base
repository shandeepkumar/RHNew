package gov.bnm.view.rh.utils;


import gov.bnm.view.rh.constant.Constants;
import gov.bnm.view.rh.session.RHSession;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import java.io.OutputStream;

import java.util.Properties;
import java.util.ArrayList;

import javax.faces.context.FacesContext;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.context.AdfFacesContext;


import oracle.jbo.Key;
import oracle.jbo.Row;

import oracle.jbo.RowSetIterator;

import org.apache.log4j.Logger;
import org.apache.myfaces.trinidad.event.SelectionEvent;
import org.apache.myfaces.trinidad.model.RowKeySet;
import org.apache.myfaces.trinidad.model.RowKeySetImpl;
import org.apache.myfaces.trinidad.model.UploadedFile;
import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;

public class FileUploadUtils {
    static Logger log = Logger.getLogger(FileUploadUtils.class);

    public static String[] fileExtension =
    { "DOC", "DOCX", "XLS", "XLSX", "PPT", "FILE", "PPS", "PDF", "GIF", "JPEG",
      "JPG", "TIF", "TIFF", "BMP", "TXT", "ZIP" };
    public static String[] fileExtensionLimited = { "DOC", "DOCX", "PDF" };
    public static String[] fileExtensionDoc = { "DOC", "DOCX" };
    public static String[] fileExtensionPdf = { "PDF" };

    public static boolean checkFileExtension(String fileName) {
        for (int i = 0; i < fileExtension.length; i++) {
            if (fileName.toUpperCase().endsWith(fileExtension[i])) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkFileExtensionForPolicy(String fileName) {
        for (int i = 0; i < fileExtensionLimited.length; i++) {
            if (fileName.toUpperCase().endsWith(fileExtensionLimited[i])) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkFileExtensionForDoc(String fileName) {
        for (int i = 0; i < fileExtensionDoc.length; i++) {
            if (fileName.toUpperCase().endsWith(fileExtensionDoc[i])) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkFileExtensionForPdf(String fileName) {
        for (int i = 0; i < fileExtensionPdf.length; i++) {
            if (fileName.toUpperCase().endsWith(fileExtensionPdf[i])) {
                return true;
            }
        }
        return false;
    }

    public static boolean setUploadedFile(UploadedFile uploadedFile,
                                          String fileIteratorName,
                                          String itemlistIteratorName,
                                          String type) {
        InputStream in;
        FileOutputStream out;
        //    PropertyFileConfigManager propertyFileConfigManager =
        //      PropertyFileConfigManager.getInstance();
        boolean fileUploadStatus = false;
        try {
            String fileId = RandomGuidUtil.fnGuidWithTimestamp();
            Row itemRow =
                ADFUtils.findIterator(itemlistIteratorName).getCurrentRow();
            String itemid = BaseUtil.getStr(itemRow.getAttribute("itemid"));
            RHSession rhSession =
                (RHSession)JSFUtils.getFromSession("rhSession");
            Properties props = rhSession.getProps();

            if (uploadedFile != null && uploadedFile.getLength() > 0) {

                fileUploadStatus =
                        FTPUtil.getInstance().transferFile(uploadedFile,
                                                           fileId + "_" +
                                                           uploadedFile.getFilename(),
                                                           true);
                //        out =
                //            new FileOutputStream(fileUploadLoc + "/" + fileId + "_" + uploadedFile.getFilename());
                //        in = uploadedFile.getInputStream();
                //        for (int bytes = 0; bytes < uploadedFile.getLength(); bytes++) {
                //          out.write(in.read());
                //        }
                //        in.close();
                //        out.close();
            }
            if (fileUploadStatus) {
                Row row =
                    ADFUtils.findIterator(fileIteratorName).getViewObject().createRow();
                row.setAttribute("fileId", fileId);
                row.setAttribute("filenameOrig", uploadedFile.getFilename());
                row.setAttribute("filenameStore",
                                 fileId + "_" + uploadedFile.getFilename());
                row.setAttribute("filePath", props.getProperty("ftp.server"));
                row.setAttribute("isSupportDocument", false);
                row.setAttribute("isRequiredAccess", false);
                row.setAttribute("type", type);
                row.setAttribute("itemId", itemid);
                row.setAttribute("orderDate", DateUtils.getCurrentTimestamp());
                ADFUtils.findIterator(fileIteratorName).getViewObject().insertRow(row);
            }
        } catch (IOException e) {
            log.info("e::" + e.getMessage());
            e.printStackTrace();
        }
        return fileUploadStatus;
    }

    public static boolean setEnqUploadedFile(UploadedFile uploadedFile,
                                          String fileIteratorName,
                                          String itemid,
                                             String enquiryFAQId,
                                          String enquiryType) {
        InputStream in;
        FileOutputStream out;
        //    PropertyFileConfigManager propertyFileConfigManager =
        //      PropertyFileConfigManager.getInstance();
        boolean fileUploadStatus = false;
        try {
            String fileId = RandomGuidUtil.fnGuidWithTimestamp();
            RHSession rhSession =
                (RHSession)JSFUtils.getFromSession("rhSession");
            Properties props = rhSession.getProps();

            if (uploadedFile != null && uploadedFile.getLength() > 0) {

                fileUploadStatus =
                        FTPUtil.getInstance().transferFile(uploadedFile,
                                                           fileId + "_" +
                                                           uploadedFile.getFilename(),
                                                           true);
                //        out =
                //            new FileOutputStream(fileUploadLoc + "/" + fileId + "_" + uploadedFile.getFilename());
                //        in = uploadedFile.getInputStream();
                //        for (int bytes = 0; bytes < uploadedFile.getLength(); bytes++) {
                //          out.write(in.read());
                //        }
                //        in.close();
                //        out.close();
            }
            if (fileUploadStatus) {
                Row row =
                    ADFUtils.findIterator(fileIteratorName).getViewObject().createRow();
                row.setAttribute("fileId", fileId);
                row.setAttribute("filenameOrig", uploadedFile.getFilename());
                row.setAttribute("filenameStore",
                                 fileId + "_" + uploadedFile.getFilename());
                row.setAttribute("filePath", props.getProperty("ftp.server"));
                row.setAttribute("isSupportDocument", false);
                row.setAttribute("isRequiredAccess", false);
                row.setAttribute("type", Constants.ATTACHMENT_TYPE_ENQUIRY);
                row.setAttribute("itemId", itemid);
                row.setAttribute("orderDate", DateUtils.getCurrentTimestamp());
                row.setAttribute("enquiryFAQId", enquiryFAQId);
                row.setAttribute("enquiryDocType", enquiryType);
                ADFUtils.findIterator(fileIteratorName).getViewObject().insertRow(row);
            }
        } catch (IOException e) {
            log.error("e::" + e.getMessage());
            e.printStackTrace();
        }
        return fileUploadStatus;
    }

    public static boolean setUploadedFile(UploadedFile uploadedFile,
                                          String fileId) {
        InputStream in;
        FileOutputStream out;
        boolean fileUploadStatus = false;
        try {
            if (uploadedFile != null && uploadedFile.getLength() > 0) {
                fileUploadStatus =
                        FTPUtil.getInstance().transferFile(uploadedFile,
                                                           fileId + "_" +
                                                           uploadedFile.getFilename(),
                                                           true);
                //        out =
                //            new FileOutputStream(fileUploadLoc + "/" + fileId + "_" + uploadedFile.getFilename());
                //        in = uploadedFile.getInputStream();
                //        for (int bytes = 0; bytes < uploadedFile.getLength(); bytes++) {
                //          out.write(in.read());
                //        }
                //        in.close();
                //        out.close();
            }
        } catch (IOException e) {
            log.info("e::" + e.getMessage());
            e.printStackTrace();
        }
        return fileUploadStatus;
    }

    public static String parseISToString(java.io.InputStream is) {
        java.io.DataInputStream din = new java.io.DataInputStream(is);
        StringBuffer sb = new StringBuffer();
        try {
            String line = null;
            while ((line = din.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (Exception ex) {
            ex.getMessage();
        } finally {
            try {
                is.close();
            } catch (Exception ex) {
            }
        }
        return sb.toString();
    }

    public static void removeFromTable(DCIteratorBinding iterBindings,
                                       Key rowKey) {
        RowSetIterator empRSIter = iterBindings.getRowSetIterator();
        Row currentRow = empRSIter.getRow(rowKey);
        //    PropertyFileConfigManager propertyFileConfigManager =
        //      PropertyFileConfigManager.getInstance();
        //    Properties props =
        //      propertyFileConfigManager.getConfigFile(FileUtil.EAPPS_LOCATION +
        //                                              FileUtil.EAPPS_PROP_FILE);
        //    String fileUploadLoc =
        //      BaseUtil.getStr(props.getProperty("rh_file_location"));
        try {
            boolean status =
                FTPUtil.getInstance().deleteFile(BaseUtil.getStr(currentRow.getAttribute("filenameStore")),
                                                 null);
            //      File file =
            //        new File(fileUploadLoc + "\\" + BaseUtil.getStr(currentRow.getAttribute("filenameStore")));
            //
            //      if (file.delete()) {
            if (status) {
                log.info(BaseUtil.getStr(currentRow.getAttribute("filenameStore")) +
                         " is deleted!");
            } else {
                log.info("Delete operation is failed.");
            }

        } catch (Exception e) {

            e.printStackTrace();

        }
        currentRow.remove();
    }

    public static void removePhysicalFile(String filenameStore) {
        //    PropertyFileConfigManager propertyFileConfigManager =
        //      PropertyFileConfigManager.getInstance();
        //    Properties props =
        //      propertyFileConfigManager.getConfigFile(FileUtil.EAPPS_LOCATION +
        //                                              FileUtil.EAPPS_PROP_FILE);
        //    String fileUploadLoc =
        //      BaseUtil.getStr(props.getProperty("rh_file_location"));
        try {
            //      File file =
            //        new File(fileUploadLoc + "\\" + BaseUtil.getStr(filenameStore));
            boolean status =
                FTPUtil.getInstance().deleteFile(BaseUtil.getStr(filenameStore),
                                                 null);
            //      if (file.delete()) {
            if (status) {
                log.info(filenameStore + " is deleted!");
            } else {
                log.info("Delete operation is failed.");
            }

        } catch (Exception e) {

            e.printStackTrace();

        }
    }

    public static void partialTableRefresh(Key rowKey, RichTable table) {
        //get the current selected RowKeySet from the table
        RowKeySet oldSelection = table.getSelectedRowKeys();
        //build an empty RowKeySet for the new selection
        RowKeySetImpl newSelection = new RowKeySetImpl();

        //RowKeySets contain List objects with key objects in them
        ArrayList list = new ArrayList();
        list.add(rowKey);
        newSelection.add(list);

        //create the selectionEvent and queue it
        SelectionEvent selectionEvent =
            new SelectionEvent(oldSelection, newSelection, table);
        selectionEvent.queue();

        //refresh the table
        AdfFacesContext.getCurrentInstance().addPartialTarget(table);
    }

    public static void setOpenFileName(Object filenameStore,
                                       Object filenameOrig, String clientId) {
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("filenameOrig",
                                                                    filenameOrig);
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("filenameStore",
                                                                    filenameStore);
        FacesContext context = FacesContext.getCurrentInstance();
        log.info(" pp filenameStore::" + filenameStore);
        ExtendedRenderKitService erks =
            Service.getService(context.getRenderKit(),
                               ExtendedRenderKitService.class);

        StringBuilder script = new StringBuilder();
        script.append("var exportCmd = AdfPage.PAGE.findComponentByAbsoluteId");
        script.append("('" + clientId + "');");

        script.append("var actionEvent = new AdfActionEvent(exportCmd);");
        script.append("actionEvent.forceFullSubmit();");
        script.append("actionEvent.noResponseExpected();");
        script.append("actionEvent.queue();");

        erks.addScript(context, script.toString());
    }

    public static void downloadFile(OutputStream out) throws IOException {
        Object fileName =
            AdfFacesContext.getCurrentInstance().getPageFlowScope().get("filenameStore");
        log.info("fileName::" + fileName);
        if (fileName != null) {
            //      PropertyFileConfigManager propertyFileConfigManager =
            //        PropertyFileConfigManager.getInstance();
            //      Properties props =
            //        propertyFileConfigManager.getConfigFile(FileUtil.EAPPS_LOCATION +
            //                                                FileUtil.EAPPS_PROP_FILE);
            //      String fileUploadLoc =
            //        BaseUtil.getStr(props.getProperty("rh_file_location"));
            //      log.info("Perform Download!!");
            //      File f = new File(fileUploadLoc + "\\" + BaseUtil.getStr(fileName));
            //      FileInputStream fis;
            //      byte[] b;
            try {
                boolean status =
                    FTPUtil.getInstance().downloadFile(BaseUtil.getStr(fileName),
                                                       out, null);
                //        fis = new FileInputStream(f);
                //
                //        int n;
                //        while ((n = fis.available()) > 0) {
                //          b = new byte[n];
                //          int result = fis.read(b);
                //          out.write(b, 0, b.length);
                //          if (result == -1)
                //            break;
                //        }
            } catch (IOException e) {
                e.printStackTrace();
            }
            out.flush();
        }
    }
}
