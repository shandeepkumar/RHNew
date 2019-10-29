package gov.bnm.view.rh.backingBeans;

import gov.bnm.rh.views.EnquiryfaqForEnqPendingViewObjRowImpl;
import gov.bnm.rh.views.EnquiryfaqForEnqViewObjRowImpl;
import gov.bnm.view.rh.constant.Constants;
import gov.bnm.view.rh.session.RHSession;
import gov.bnm.view.rh.utils.ADFUtils;

import gov.bnm.view.rh.utils.BaseUtil;
import gov.bnm.view.rh.utils.CommonRHUtil;
import gov.bnm.view.rh.utils.DateUtils;
import gov.bnm.view.rh.utils.EmailUtils;
import gov.bnm.view.rh.utils.FileUploadUtils;
import gov.bnm.view.rh.utils.JSFUtils;

import java.io.OutputStream;

import javax.faces.context.FacesContext;

import javax.faces.event.ActionEvent;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputFile;
import oracle.adf.view.rich.component.rich.input.RichTextEditor;
import oracle.adf.view.rich.component.rich.layout.RichPanelFormLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelLabelAndMessage;
import oracle.adf.view.rich.component.rich.layout.RichPanelStretchLayout;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.component.rich.nav.RichCommandLink;
import oracle.adf.view.rich.component.rich.output.RichOutputFormatted;
import oracle.adf.view.rich.component.rich.output.RichOutputText;

import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewObject;

import org.apache.log4j.Logger;
import org.apache.myfaces.trinidad.model.UploadedFile;

public class EnquiryResponsePage {

    static Logger log = Logger.getLogger(EnquiryResponsePage.class);
    private RichPanelStretchLayout psl1;
    private RichPanelFormLayout pfl1;
    private RichPanelLabelAndMessage plam1;
    private RichOutputText ot1;
    private RichCommandButton cb1;
    private RichTextEditor rte1;
    private RichOutputText ot2;
    private RichOutputText ot3;
    private RichOutputFormatted of1;
    private RichPanelLabelAndMessage plam2;
    private RichCommandButton cb3;
    private RichInputFile if1;
    private RichTable t3;
    private UploadedFile ansUploadedFile;

    public void doDownload(FacesContext facesContext, OutputStream out) {
        try {
            FileUploadUtils.downloadFile(out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onOpenEnqAnsFileSelected(ActionEvent actionEvent) {
        BindingContainer bindings = ADFUtils.getBindingContainer();
        RichCommandLink comp = (RichCommandLink)actionEvent.getComponent();
        int rowKey = BaseUtil.getInt(comp.getAttributes().get("rowKey"));

        log.info("rowKey::" + rowKey);
        DCIteratorBinding iterBindings =
            (DCIteratorBinding)bindings.get("AttachedfileForEnqAnsView1Iterator");

        RowSetIterator empRSIter = iterBindings.getRowSetIterator();
        Row currentRow = empRSIter.getRowAtRangeIndex(rowKey);

        FileUploadUtils.setOpenFileName(BaseUtil.getStr(currentRow.getAttribute("filenameStore")),
                                        BaseUtil.getStr(currentRow.getAttribute("filenameOrig")),
                                        getCb3().getClientId(FacesContext.getCurrentInstance()));
    }

    public void setAnsUploadedFile(UploadedFile ansUploadedFile) {
        String filename = BaseUtil.getStr(ansUploadedFile.getFilename());
        boolean fileUploadStatus = false;
        if (!filename.equals("") &&
            FileUploadUtils.checkFileExtension(filename)) {
            String fldEnquiryFAQId =
                BaseUtil.getStr(AdfFacesContext.getCurrentInstance().getPageFlowScope().get("fldEnquiryFAQId"));
            String itemid =
                BaseUtil.getStr(AdfFacesContext.getCurrentInstance().getPageFlowScope().get("itemid"));
            fileUploadStatus =
                    FileUploadUtils.setEnqUploadedFile(ansUploadedFile,
                                                       "AttachedfileForEnqAnsView1Iterator",
                                                       itemid, fldEnquiryFAQId,
                                                       Constants.ATTACHMENT_ENQUIRY_TYPE_ANSWER);
        } else {
            ADFUtils.showErrorMessage(Constants.INVALID_FILE_FORMAT);
        }
        if (fileUploadStatus) {
            ADFUtils.showInfoMessage(Constants.ATTACHMENT_SAVE_SUCCESSFULLY);
        } else {
            ADFUtils.showErrorMessage(Constants.ATTACHMENT_SAVE_ERROR);
        }
    }

    public void onOpenEnqQueFileSelected(ActionEvent actionEvent) {
        BindingContainer bindings = ADFUtils.getBindingContainer();
        RichCommandLink comp = (RichCommandLink)actionEvent.getComponent();
        int rowKey = BaseUtil.getInt(comp.getAttributes().get("rowKey"));

        log.info("rowKey::" + rowKey);
        DCIteratorBinding iterBindings =
            (DCIteratorBinding)bindings.get("AttachedfileForEnqQueView1Iterator");

        RowSetIterator empRSIter = iterBindings.getRowSetIterator();
        Row currentRow = empRSIter.getRowAtRangeIndex(rowKey);

        FileUploadUtils.setOpenFileName(BaseUtil.getStr(currentRow.getAttribute("filenameStore")),
                                        BaseUtil.getStr(currentRow.getAttribute("filenameOrig")),
                                        getCb3().getClientId(FacesContext.getCurrentInstance()));
    }

    public void onDeleteAnsFileSelected(ActionEvent actionEvent) {
        BindingContainer bindings = ADFUtils.getBindingContainer();
        log.info("bindings:" + bindings);
        RichCommandLink comp = (RichCommandLink)actionEvent.getComponent();

        Key rowKey = (Key)comp.getAttributes().get("rowKeyDelete");
        log.info("delete rowKey:::::: " + rowKey);

        DCIteratorBinding iterBindings =
            (DCIteratorBinding)bindings.get("AttachedfileForEnqAnsView1Iterator");
        FileUploadUtils.removeFromTable(iterBindings, rowKey);

        FileUploadUtils.partialTableRefresh(rowKey, getT3());
    }

    public void onOpenAnsFileSelected(ActionEvent actionEvent) {
        BindingContainer bindings = ADFUtils.getBindingContainer();
        RichCommandLink comp = (RichCommandLink)actionEvent.getComponent();
        Key rowKey = (Key)comp.getAttributes().get("rowKey");
        log.info("rowKey::" + rowKey);
        DCIteratorBinding iterBindings =
            (DCIteratorBinding)bindings.get("AttachedfileForEnqAnsView1Iterator");
        FileUploadUtils.partialTableRefresh(rowKey, getT3());

        RowSetIterator empRSIter = iterBindings.getRowSetIterator();
        Row currentRow = empRSIter.getRow(rowKey);
        //file name and Download buttion getter
        FileUploadUtils.setOpenFileName(BaseUtil.getStr(currentRow.getAttribute("filenameStore")),
                                        BaseUtil.getStr(currentRow.getAttribute("filenameOrig")),
                                        getCb3().getClientId(FacesContext.getCurrentInstance()));
    }

    public void setPsl1(RichPanelStretchLayout psl1) {
        this.psl1 = psl1;
    }

    public RichPanelStretchLayout getPsl1() {
        return psl1;
    }

    public void setPfl1(RichPanelFormLayout pfl1) {
        this.pfl1 = pfl1;
    }

    public RichPanelFormLayout getPfl1() {
        return pfl1;
    }


    public void setPlam1(RichPanelLabelAndMessage plam1) {
        this.plam1 = plam1;
    }

    public RichPanelLabelAndMessage getPlam1() {
        return plam1;
    }

    public void setOt1(RichOutputText ot1) {
        this.ot1 = ot1;
    }

    public RichOutputText getOt1() {
        return ot1;
    }

    public void setCb1(RichCommandButton cb1) {
        this.cb1 = cb1;
    }

    public RichCommandButton getCb1() {
        return cb1;
    }

    public String submitRequest() {
        if (this.getRte1().getValue() != null &&
            !this.getRte1().getValue().equals("")) {
            log.info("getValue::" + this.getRte1().getValue());
            String abstractVal =
                CommonRHUtil.alignHtml(BaseUtil.getStr(this.getRte1().getValue()));
            RHSession rhSession =
                (RHSession)JSFUtils.getFromSession("rhSession");
            String userid = BaseUtil.getStr(rhSession.getFldUserid());
            String departmentId =
                BaseUtil.getStr(rhSession.getFldDepartmentId());
            DCIteratorBinding enqIter =
                ADFUtils.findIterator("EnquiryfaqForEnqViewObj1Iterator");
            ViewObject enqVO = enqIter.getViewObject();
            EnquiryfaqForEnqViewObjRowImpl enqRow =
                (EnquiryfaqForEnqViewObjRowImpl)enqVO.getCurrentRow();

            enqRow.setupdateDate(DateUtils.getCurrentTimestamp());
            enqRow.setenquiryStatus(Constants.RECORD_STATUS_ANSWERED);
            enqRow.setapproverId(userid);
            enqRow.setupdatedBy(userid);
            enqRow.setAbstract11(abstractVal);
            enqRow.setOrigAbstract(abstractVal);
            commitAction();
            EmailUtils.sendMailResponseForEnquiry(enqRow);

        } else {
            ADFUtils.showErrorMessage("Answer is mandatory.");
        }
        return null;
    }

    private String commitAction() {
        BindingContainer bindings = ADFUtils.getBindingContainer();
        OperationBinding operationBinding =
            bindings.getOperationBinding("Commit");
        Object result = operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
            ADFUtils.showInfoMessage(Constants.ERROR_MESSAGE_CONTACT);
            log.error(" ... " + operationBinding.getErrors());
        } else {
            ADFUtils.showInfoMessage(Constants.DATA_SAVE_SUCCESSFULLY);
        }
        return null;
    }

    public void setRte1(RichTextEditor rte1) {
        this.rte1 = rte1;
    }

    public RichTextEditor getRte1() {
        return rte1;
    }

    public void setOt2(RichOutputText ot2) {
        this.ot2 = ot2;
    }

    public RichOutputText getOt2() {
        return ot2;
    }

    public void setOt3(RichOutputText ot3) {
        this.ot3 = ot3;
    }

    public RichOutputText getOt3() {
        return ot3;
    }

    public void setOf1(RichOutputFormatted of1) {
        this.of1 = of1;
    }

    public RichOutputFormatted getOf1() {
        return of1;
    }

    public void setPlam2(RichPanelLabelAndMessage plam2) {
        this.plam2 = plam2;
    }

    public RichPanelLabelAndMessage getPlam2() {
        return plam2;
    }

    public void setCb3(RichCommandButton cb3) {
        this.cb3 = cb3;
    }

    public RichCommandButton getCb3() {
        return cb3;
    }

    public void setIf1(RichInputFile if1) {
        this.if1 = if1;
    }

    public RichInputFile getIf1() {
        return if1;
    }

    public void setT3(RichTable t3) {
        this.t3 = t3;
    }

    public RichTable getT3() {
        return t3;
    }


    public UploadedFile getAnsUploadedFile() {
        return ansUploadedFile;
    }
}
