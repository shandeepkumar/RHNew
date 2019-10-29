package gov.bnm.view.rh.backingBeans;

import gov.bnm.rh.views.AttachedfileSupportDocViewObjRowImpl;
import gov.bnm.rh.views.EnquiryfaqForEnqPendingViewObjRowImpl;
import gov.bnm.rh.views.EnquiryfaqForEnqViewObjRowImpl;
import gov.bnm.rh.views.RequestlistViewRowImpl;
import gov.bnm.view.rh.constant.Constants;
import gov.bnm.view.rh.session.RHSession;
import gov.bnm.view.rh.utils.ADFUtils;

import gov.bnm.view.rh.utils.BaseUtil;
import gov.bnm.view.rh.utils.CommonRHUtil;
import gov.bnm.view.rh.utils.DateUtils;
import gov.bnm.view.rh.utils.EmailUtils;
import gov.bnm.view.rh.utils.FileUploadUtils;
import gov.bnm.view.rh.utils.JSFUtils;
import gov.bnm.view.rh.utils.RandomGuidUtil;

import gov.view.common.utils.UtilCommon;

import java.io.OutputStream;

import javax.faces.context.FacesContext;

import javax.faces.event.ActionEvent;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputFile;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichTextEditor;
import oracle.adf.view.rich.component.rich.layout.RichPanelFormLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelLabelAndMessage;
import oracle.adf.view.rich.component.rich.layout.RichPanelTabbed;
import oracle.adf.view.rich.component.rich.layout.RichShowDetailItem;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.component.rich.nav.RichCommandLink;
import oracle.adf.view.rich.component.rich.output.RichOutputFormatted;
import oracle.adf.view.rich.component.rich.output.RichOutputText;

import oracle.adf.view.rich.component.rich.output.RichSpacer;

import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.Key;
import oracle.jbo.Row;

import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewObject;

import org.apache.log4j.Logger;

import org.apache.myfaces.trinidad.event.SelectionEvent;
import org.apache.myfaces.trinidad.model.UploadedFile;

import utils.system;

public class EnquiriesPage {
    static Logger log = Logger.getLogger(EnquiriesPage.class);
    private RichOutputText ot1;
    private RichPanelFormLayout pfl1;
    private RichCommandButton cb1;
    private RichTextEditor rte1;
    private RichPanelFormLayout pfl2;
    private RichCommandButton cb2;
    private RichInputText it1;
    private RichOutputText ot20;
    private RichPanelLabelAndMessage plam2;
    private RichPanelLabelAndMessage plam5;
    private RichOutputText ot30;
    private RichOutputFormatted of1;
    private RichSpacer s4;
    private RichSpacer s14;
    private RichPanelTabbed pt2;
    private RichShowDetailItem sdi3;
    private RichPanelTabbed pt3;
    private RichShowDetailItem sdi4;
    private RichInputFile if1;
    private UploadedFile ansUploadedFile;
    private RichTable t3;
    private RichCommandButton cb3;
    private boolean pendingDetailsStatus = false;
    private boolean answeredDetailsStatus = false;
    private RichCommandButton cb4;
    private RichTextEditor rte2;
    
    public void setOt1(RichOutputText ot1) {
        this.ot1 = ot1;
    }

    public RichOutputText getOt1() {
        return ot1;
    }


    public void setPfl1(RichPanelFormLayout pfl1) {
        this.pfl1 = pfl1;
    }

    public RichPanelFormLayout getPfl1() {
        return pfl1;
    }

    public void setCb1(RichCommandButton cb1) {
        this.cb1 = cb1;
    }

    public RichCommandButton getCb1() {
        return cb1;
    }

    public void pendingEnquiryTableSelectionListener(SelectionEvent selectionEvent) {
        setPendingDetailsStatus(true);
        JSFUtils.invokeEL("#{bindings.EnquiryfaqForEnqPendingViewObj1.collectionModel.makeCurrent}",
                          new Class[] { SelectionEvent.class },
                          new Object[] { selectionEvent });
        // get the selected row , by this you can get any attribute of that row
        Row selectedRow =
            (Row)JSFUtils.evaluateEL("#{bindings.EnquiryfaqForEnqPendingViewObj1.currentRow}"); // get the current selected row
        try {
            String fldEnquiryFAQId =
                BaseUtil.getStr(selectedRow.getAttribute("EnquiryFAQId"));
            String itemId =
                BaseUtil.getStr(selectedRow.getAttribute("itemId"));
            AdfFacesContext.getCurrentInstance().getPageFlowScope().put("fldEnquiryFAQId",
                                                                        fldEnquiryFAQId);
            AdfFacesContext.getCurrentInstance().getPageFlowScope().put("itemid",
                                                                        itemId);
            DCIteratorBinding attQueIter =
                ADFUtils.findIterator("AttachedfileForEnqQueView1Iterator");
            ViewObject attQueVO = attQueIter.getViewObject();
            attQueVO.setNamedWhereClauseParam("bindEnqId", fldEnquiryFAQId);
            attQueVO.executeQuery();
            DCIteratorBinding attAnsIter =
                ADFUtils.findIterator("AttachedfileForEnqAnsView1Iterator");
            ViewObject attAnsVO = attAnsIter.getViewObject();
            attAnsVO.setNamedWhereClauseParam("bindEnqId", fldEnquiryFAQId);
            attAnsVO.executeQuery();
        } catch (Exception e) {
            log.info("Exception @notOperationTableSelectionListener .. " + e);
        }
    }

    public void answeredEnquiryTableSelectionListener(SelectionEvent selectionEvent) {
        setAnsweredDetailsStatus(true);
        JSFUtils.invokeEL("#{bindings.EnquiryfaqForEnqViewObj1.collectionModel.makeCurrent}",
                          new Class[] { SelectionEvent.class },
                          new Object[] { selectionEvent });
        // get the selected row , by this you can get any attribute of that row
        Row selectedRow =
            (Row)JSFUtils.evaluateEL("#{bindings.EnquiryfaqForEnqViewObj1.currentRow}"); // get the current selected row
        try {
            String fldEnquiryFAQId =
                BaseUtil.getStr(selectedRow.getAttribute("EnquiryFAQId"));
            String itemId =
                BaseUtil.getStr(selectedRow.getAttribute("itemId"));
            AdfFacesContext.getCurrentInstance().getPageFlowScope().put("fldEnquiryFAQId",
                                                                        fldEnquiryFAQId);
            AdfFacesContext.getCurrentInstance().getPageFlowScope().put("itemid",
                                                                        itemId);
            DCIteratorBinding attQueIter =
                ADFUtils.findIterator("AttachedfileForEnqQueView1Iterator");
            ViewObject attQueVO = attQueIter.getViewObject();
            attQueVO.setNamedWhereClauseParam("bindEnqId", fldEnquiryFAQId);
            attQueVO.executeQuery();
            DCIteratorBinding attAnsIter =
                ADFUtils.findIterator("AttachedfileForEnqAnsView1Iterator");
            ViewObject attAnsVO = attAnsIter.getViewObject();
            attAnsVO.setNamedWhereClauseParam("bindEnqId", fldEnquiryFAQId);
            attAnsVO.executeQuery();
            String Abstract11 =
                BaseUtil.getStr(selectedRow.getAttribute("Abstract11"));
                        log.info("abstract1 before::"+Abstract11);
            this.getRte2().setValue(UtilCommon.decryptSpecialChar(Abstract11));
//            selectedRow.setAttribute("Abstract11",
//                                     UtilCommon.decryptSpecialChar(Abstract11));
                        log.info("abstract1 after::"+this.getRte2().getValue());
        } catch (Exception e) {
            log.info("Exception @notOperationTableSelectionListener .. " + e);
        }
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
                ADFUtils.findIterator("EnquiryfaqForEnqPendingViewObj1Iterator");
            ViewObject enqVO = enqIter.getViewObject();
            EnquiryfaqForEnqPendingViewObjRowImpl enqRow =
                (EnquiryfaqForEnqPendingViewObjRowImpl)enqVO.getCurrentRow();

            enqRow.setupdateDate(DateUtils.getCurrentTimestamp());
            enqRow.setenquiryStatus(Constants.RECORD_STATUS_ANSWERED);
            enqRow.setapproverId(userid);
            enqRow.setupdatedBy(userid);
            enqRow.setAbstract11(abstractVal);
            enqRow.setOrigAbstract(abstractVal);
            enqRow.setrequiredResponseDate(DateUtils.getCurrentTimestamp());
            String commitStatus = commitAction();

            if (Constants.STATUS_SUCCESS.equalsIgnoreCase(commitStatus)) {
                ADFUtils.showInfoMessage(Constants.RESPONSE_HAS_SUBMITTED);
            }

            EmailUtils.sendMailResponseForEnquiry(enqRow);
            if (!departmentId.equals("ADMIN")) {
                enqVO.setWhereClause(" itemId IN ( SELECT itemId FROM PolicyDepartmentPartition WHERE departmentId ='" +
                                     departmentId + "' )");
            }
            enqVO.executeQuery();

        } else {
            ADFUtils.showErrorMessage("Answer is mandatory.");
        }
        return null;
    }

    public String promoteToFAQ() {
        RHSession rhSession = (RHSession)JSFUtils.getFromSession("rhSession");
        String userid = BaseUtil.getStr(rhSession.getFldUserid());
        String departmentId = BaseUtil.getStr(rhSession.getFldDepartmentId());
        DCIteratorBinding enqIter =
            ADFUtils.findIterator("EnquiryfaqForEnqViewObj1Iterator");
        ViewObject enqVO = enqIter.getViewObject();
        EnquiryfaqForEnqViewObjRowImpl row =
            (EnquiryfaqForEnqViewObjRowImpl)enqVO.getCurrentRow();
        row.setEnquiryOrFaq(Constants.RECORD_TYPE_FAQ);
        row.setupdatedBy(userid);
        row.setfaqStatus(Constants.RECORD_STATUS_ACTIVE);
        row.setdatePromoted(DateUtils.getCurrentTimestamp());
        row.setupdateDate(DateUtils.getCurrentTimestamp());
        row.setCurrentItemtype(Constants.RECORD_TYPE_FAQ);
        String commitStatus = commitAction();

        if (Constants.STATUS_SUCCESS.equalsIgnoreCase(commitStatus)) {
            ADFUtils.showInfoMessage(Constants.ENQUIRY_PROMOTED_FAQ);
        }

        if (!departmentId.equals("ADMIN")) {
            enqVO.setWhereClause(" enquiryStatus='ANSWERED' AND itemId IN ( SELECT itemId FROM PolicyDepartmentPartition WHERE departmentId ='" +
                                 departmentId + "' )");
        } else {
            enqVO.setWhereClause(" enquiryStatus='ANSWERED' ");
        }
        enqVO.executeQuery();
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
            return Constants.STATUS_SUCCESS;
        }
        return null;
    }

    public void setRte1(RichTextEditor rte1) {
        this.rte1 = rte1;
    }

    public RichTextEditor getRte1() {
        return rte1;
    }

    public void setPfl2(RichPanelFormLayout pfl2) {
        this.pfl2 = pfl2;
    }

    public RichPanelFormLayout getPfl2() {
        return pfl2;
    }

    public void setCb2(RichCommandButton cb2) {
        this.cb2 = cb2;
    }

    public RichCommandButton getCb2() {
        return cb2;
    }

    public void setIt1(RichInputText it1) {
        this.it1 = it1;
    }

    public RichInputText getIt1() {
        return it1;
    }

    public void setOt20(RichOutputText ot20) {
        this.ot20 = ot20;
    }

    public RichOutputText getOt20() {
        return ot20;
    }

    public void setPlam2(RichPanelLabelAndMessage plam2) {
        this.plam2 = plam2;
    }

    public RichPanelLabelAndMessage getPlam2() {
        return plam2;
    }

    public void setPlam5(RichPanelLabelAndMessage plam5) {
        this.plam5 = plam5;
    }

    public RichPanelLabelAndMessage getPlam5() {
        return plam5;
    }

    public void setOt30(RichOutputText ot30) {
        this.ot30 = ot30;
    }

    public RichOutputText getOt30() {
        return ot30;
    }

    public void setOf1(RichOutputFormatted of1) {
        this.of1 = of1;
    }

    public RichOutputFormatted getOf1() {
        return of1;
    }

    public void setS4(RichSpacer s4) {
        this.s4 = s4;
    }

    public RichSpacer getS4() {
        return s4;
    }

    public void setS14(RichSpacer s14) {
        this.s14 = s14;
    }

    public RichSpacer getS14() {
        return s14;
    }

    public void setPt2(RichPanelTabbed pt2) {
        this.pt2 = pt2;
    }

    public RichPanelTabbed getPt2() {
        return pt2;
    }

    public void setSdi3(RichShowDetailItem sdi3) {
        this.sdi3 = sdi3;
    }

    public RichShowDetailItem getSdi3() {
        return sdi3;
    }

    public void setPt3(RichPanelTabbed pt3) {
        this.pt3 = pt3;
    }

    public RichPanelTabbed getPt3() {
        return pt3;
    }

    public void setSdi4(RichShowDetailItem sdi4) {
        this.sdi4 = sdi4;
    }

    public RichShowDetailItem getSdi4() {
        return sdi4;
    }

    public void setIf1(RichInputFile if1) {
        this.if1 = if1;
    }

    public RichInputFile getIf1() {
        return if1;
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
        setPendingDetailsStatus(true);
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
        setPendingDetailsStatus(true);
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
        setPendingDetailsStatus(true);
    }

    public void onOpenAnsQueFileSelected(ActionEvent actionEvent) {
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
                                        getCb4().getClientId(FacesContext.getCurrentInstance()));
        setAnsweredDetailsStatus(true);
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
                                        getCb4().getClientId(FacesContext.getCurrentInstance()));
        setAnsweredDetailsStatus(true);
    }

    public UploadedFile getAnsUploadedFile() {
        return ansUploadedFile;
    }

    public void setT3(RichTable t3) {
        this.t3 = t3;
    }

    public RichTable getT3() {
        return t3;
    }

    public void setCb3(RichCommandButton cb3) {
        this.cb3 = cb3;
    }

    public RichCommandButton getCb3() {
        return cb3;
    }

    public void doDownload(FacesContext facesContext, OutputStream out) {
        try {
            FileUploadUtils.downloadFile(out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setPendingDetailsStatus(boolean pendingDetailsStatus) {
        this.pendingDetailsStatus = pendingDetailsStatus;
    }

    public boolean isPendingDetailsStatus() {
        return pendingDetailsStatus;
    }

    public void setAnsweredDetailsStatus(boolean answeredDetailsStatus) {
        this.answeredDetailsStatus = answeredDetailsStatus;
    }

    public boolean isAnsweredDetailsStatus() {
        return answeredDetailsStatus;
    }

    public void setCb4(RichCommandButton cb4) {
        this.cb4 = cb4;
    }

    public RichCommandButton getCb4() {
        return cb4;
    }

    public void setRte2(RichTextEditor rte2) {
        this.rte2 = rte2;
    }

    public RichTextEditor getRte2() {
        return rte2;
    }
}
