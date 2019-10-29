package gov.bnm.view.rh.backingBeans;

import gov.bnm.rh.views.AttachedfileSupportDocViewObjRowImpl;
import gov.bnm.rh.views.EnquiryfaqForEnqPolicyViewObjRowImpl;
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

import gov.bnm.view.rh.utils.PopUpUtils;
import gov.bnm.view.rh.utils.RandomGuidUtil;


import gov.view.common.utils.UtilCommon;

import java.io.OutputStream;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.RichDialog;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputFile;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectItem;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.input.RichSelectOneRadio;
import oracle.adf.view.rich.component.rich.layout.RichPanelFormLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelStretchLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelTabbed;
import oracle.adf.view.rich.component.rich.layout.RichShowDetailItem;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.component.rich.nav.RichCommandLink;
import oracle.adf.view.rich.component.rich.output.RichOutputFormatted;
import oracle.adf.view.rich.component.rich.output.RichOutputText;

import oracle.adf.view.rich.component.rich.output.RichSpacer;

import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.adf.view.rich.event.DialogEvent;

import oracle.binding.BindingContainer;

import oracle.binding.OperationBinding;

import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;

import oracle.jbo.ViewObject;


import org.apache.log4j.Logger;
import org.apache.myfaces.trinidad.component.UIXIterator;
import org.apache.myfaces.trinidad.event.DisclosureEvent;
import org.apache.myfaces.trinidad.event.SelectionEvent;
import org.apache.myfaces.trinidad.model.UploadedFile;

public class PolicyPreface {

    static Logger log = Logger.getLogger(PolicyPreface.class);
    private RichOutputText ot1;
    private RichTable t2;
    private RichTable t1;
    private RichTable t3;
    private RichTable t4;
    private RichTable t5;
    private RichTable t6;
    private RichTable t7;
    private RichPanelGroupLayout pgl1;
    private RichPanelGroupLayout pgl2;
    private RichShowDetailItem sdi1;
    private RichPanelFormLayout pfl1;
    private RichOutputText ot21;
    private UIXIterator i2;
    private RichCommandLink cl6;
    private RichSpacer s1;
    private RichOutputText ot2;
    private RichOutputFormatted of1;
    private RichSpacer s2;
    private RichOutputText ot3;
    private RichOutputText ot4;
    private RichSpacer s3;
    private RichOutputText ot5;
    private RichOutputFormatted of2;
    private RichSpacer s4;
    private RichOutputText ot6;
    private RichOutputFormatted of3;
    private RichOutputText ot7;
    private RichCommandButton cb2;
    private RichSpacer s6;
    private RichOutputText ot8;
    private RichSpacer s7;
    private RichOutputText ot9;

    private RichSpacer s8;
    private RichOutputText ot10;
    private RichSpacer s9;
    private RichOutputText ot11;
    private RichSpacer s10;
    private RichOutputText ot12;
    private RichTable t14;
    private RichShowDetailItem sdi2;
    private RichShowDetailItem sdi5;
    private RichShowDetailItem sdi3;
    private RichShowDetailItem sdi4;
    private RichPanelStretchLayout psl2;
    private RichPanelFormLayout pfl2;
    private RichCommandLink cl2;
    private RichPanelStretchLayout psl3;
    private RichInputDate id1;
    private RichPanelStretchLayout psl4;
    private RichOutputText ot18;
    private RichPanelGroupLayout pgl3;
    private RichOutputText ot19;
    private RichCommandButton cb1;
    private RichInputDate id2;
    private RichPanelGroupLayout pgl4;
    private RichOutputText ot38;
    private RichInputDate id3;
    private RichCommandLink cl8;
    private RichPanelFormLayout pfl4;
    private RichSelectOneChoice soc1;
    private RichOutputText ot41;
    private RichPanelGroupLayout pgl5;
    private RichCommandButton cb3;
    private RichCommandButton cb4;
    private RichInputText it2;
    private RichCommandButton cb5;
    private RichCommandButton cb6;
    private boolean requestStatus = false;
    private RichPopup p1;
    private RichDialog d1;
    private RichOutputText ot52;
    private RichPanelTabbed pt1;
    private RichPanelFormLayout pfl6;
    private String currentDate;
    private RichInputText it1;
    private RichSelectOneRadio sor1;
    private RichSelectItem si2;
    private RichSelectItem si3;
    private RichSelectItem si4;
    private RichSelectItem si5;
    private RichPanelGroupLayout pgl7;
    private RichCommandButton cb7;
    private RichCommandButton cb8;
    private RichPanelFormLayout pfl7;
    private RichPanelGroupLayout pgl8;
    private RichCommandButton cb9;
    private RichCommandButton cb10;
    private boolean addEnqStatus = false;
    private boolean viewEnqStatus = false;
    private UISelectItems si1;
    private RichInputFile if1;
    private UploadedFile queUploadedFile;
    private RichOutputText ot58;
    private RichOutputText ot65;
    private RichPanelGroupLayout pgl10;

    public void setOt1(RichOutputText ot1) {
        this.ot1 = ot1;
    }

    public RichOutputText getOt1() {
        return ot1;
    }

    public void onOpenPolOthFileSelected(ActionEvent actionEvent) {
        BindingContainer bindings = ADFUtils.getBindingContainer();
        RichCommandLink comp = (RichCommandLink)actionEvent.getComponent();
        Key rowKey = (Key)comp.getAttributes().get("rowKey");
        log.info("rowKey::" + rowKey);
        DCIteratorBinding iterBindings =
            (DCIteratorBinding)bindings.get("AttachedfileEx1View1Iterator");
        FileUploadUtils.partialTableRefresh(rowKey, getT14());

        RowSetIterator empRSIter = iterBindings.getRowSetIterator();
        Row currentRow = empRSIter.getRow(rowKey);
        //file name and Download buttion getter
        FileUploadUtils.setOpenFileName(BaseUtil.getStr(currentRow.getAttribute("filenameStore")),
                                        BaseUtil.getStr(currentRow.getAttribute("filenameOrig")),
                                        getCb2().getClientId(FacesContext.getCurrentInstance()));
    }

    public void onOpenPolPrefaceFileSelected(ActionEvent actionEvent) {
        BindingContainer bindings = ADFUtils.getBindingContainer();
        RichCommandLink comp = (RichCommandLink)actionEvent.getComponent();
        int rowKey = BaseUtil.getInt(comp.getAttributes().get("rowKey"));

        log.info("rowKey::" + rowKey);
        DCIteratorBinding iterBindings =
            (DCIteratorBinding)bindings.get("AttachedFileOnlyPdfViewObj1Iterator");

        RowSetIterator empRSIter = iterBindings.getRowSetIterator();
        Row currentRow = empRSIter.getRowAtRangeIndex(rowKey);

        FileUploadUtils.setOpenFileName(BaseUtil.getStr(currentRow.getAttribute("filenameStore")),
                                        BaseUtil.getStr(currentRow.getAttribute("filenameOrig")),
                                        getCb2().getClientId(FacesContext.getCurrentInstance()));
    }

    public void doDownload(FacesContext facesContext, OutputStream out) {
        try {
            FileUploadUtils.downloadFile(out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void setT2(RichTable t2) {
        this.t2 = t2;
    }

    public RichTable getT2() {
        return t2;
    }

    public void setT1(RichTable t1) {
        this.t1 = t1;
    }

    public RichTable getT1() {
        return t1;
    }

    public void setT3(RichTable t3) {
        this.t3 = t3;
    }

    public RichTable getT3() {
        return t3;
    }

    public void setT4(RichTable t4) {
        this.t4 = t4;
    }

    public RichTable getT4() {
        return t4;
    }

    public void setT5(RichTable t5) {
        this.t5 = t5;
    }

    public RichTable getT5() {
        return t5;
    }

    public void setT6(RichTable t6) {
        this.t6 = t6;
    }

    public RichTable getT6() {
        return t6;
    }

    public void setT7(RichTable t7) {
        this.t7 = t7;
    }

    public RichTable getT7() {
        return t7;
    }

    public void setPgl1(RichPanelGroupLayout pgl1) {
        this.pgl1 = pgl1;
    }

    public RichPanelGroupLayout getPgl1() {
        return pgl1;
    }

    public void setPgl2(RichPanelGroupLayout pgl2) {
        this.pgl2 = pgl2;
    }

    public RichPanelGroupLayout getPgl2() {
        return pgl2;
    }

    public void setSdi1(RichShowDetailItem sdi1) {
        this.sdi1 = sdi1;
    }

    public RichShowDetailItem getSdi1() {
        return sdi1;
    }

    public void setPfl1(RichPanelFormLayout pfl1) {
        this.pfl1 = pfl1;
    }

    public RichPanelFormLayout getPfl1() {
        return pfl1;
    }

    public void setOt21(RichOutputText ot21) {
        this.ot21 = ot21;
    }

    public RichOutputText getOt21() {
        return ot21;
    }

    public void setI2(UIXIterator i2) {
        this.i2 = i2;
    }

    public UIXIterator getI2() {
        return i2;
    }

    public void setCl6(RichCommandLink cl6) {
        this.cl6 = cl6;
    }

    public RichCommandLink getCl6() {
        return cl6;
    }

    public void setS1(RichSpacer s1) {
        this.s1 = s1;
    }

    public RichSpacer getS1() {
        return s1;
    }

    public void setOt2(RichOutputText ot2) {
        this.ot2 = ot2;
    }

    public RichOutputText getOt2() {
        return ot2;
    }

    public void setOf1(RichOutputFormatted of1) {
        this.of1 = of1;
    }

    public RichOutputFormatted getOf1() {
        return of1;
    }

    public void setS2(RichSpacer s2) {
        this.s2 = s2;
    }

    public RichSpacer getS2() {
        return s2;
    }

    public void setOt3(RichOutputText ot3) {
        this.ot3 = ot3;
    }

    public RichOutputText getOt3() {
        return ot3;
    }

    public void setOt4(RichOutputText ot4) {
        this.ot4 = ot4;
    }

    public RichOutputText getOt4() {
        return ot4;
    }

    public void setS3(RichSpacer s3) {
        this.s3 = s3;
    }

    public RichSpacer getS3() {
        return s3;
    }

    public void setOt5(RichOutputText ot5) {
        this.ot5 = ot5;
    }

    public RichOutputText getOt5() {
        return ot5;
    }

    public void setOf2(RichOutputFormatted of2) {
        this.of2 = of2;
    }

    public RichOutputFormatted getOf2() {
        return of2;
    }

    public void setS4(RichSpacer s4) {
        this.s4 = s4;
    }

    public RichSpacer getS4() {
        return s4;
    }

    public void setOt6(RichOutputText ot6) {
        this.ot6 = ot6;
    }

    public RichOutputText getOt6() {
        return ot6;
    }

    public void setOf3(RichOutputFormatted of3) {
        this.of3 = of3;
    }

    public RichOutputFormatted getOf3() {
        return of3;
    }


    public void setOt7(RichOutputText ot7) {
        this.ot7 = ot7;
    }

    public RichOutputText getOt7() {
        return ot7;
    }

    public void setCb2(RichCommandButton cb2) {
        this.cb2 = cb2;
    }

    public RichCommandButton getCb2() {
        return cb2;
    }

    public void setS6(RichSpacer s6) {
        this.s6 = s6;
    }

    public RichSpacer getS6() {
        return s6;
    }

    public void setOt8(RichOutputText ot8) {
        this.ot8 = ot8;
    }

    public RichOutputText getOt8() {
        return ot8;
    }


    public void setS7(RichSpacer s7) {
        this.s7 = s7;
    }

    public RichSpacer getS7() {
        return s7;
    }

    public void setOt9(RichOutputText ot9) {
        this.ot9 = ot9;
    }

    public RichOutputText getOt9() {
        return ot9;
    }

    public void setS8(RichSpacer s8) {
        this.s8 = s8;
    }

    public RichSpacer getS8() {
        return s8;
    }

    public void setOt10(RichOutputText ot10) {
        this.ot10 = ot10;
    }

    public RichOutputText getOt10() {
        return ot10;
    }

    public void setS9(RichSpacer s9) {
        this.s9 = s9;
    }

    public RichSpacer getS9() {
        return s9;
    }

    public void setOt11(RichOutputText ot11) {
        this.ot11 = ot11;
    }

    public RichOutputText getOt11() {
        return ot11;
    }

    public void setS10(RichSpacer s10) {
        this.s10 = s10;
    }

    public RichSpacer getS10() {
        return s10;
    }

    public void setOt12(RichOutputText ot12) {
        this.ot12 = ot12;
    }

    public RichOutputText getOt12() {
        return ot12;
    }

    public void setT14(RichTable t14) {
        this.t14 = t14;
    }

    public RichTable getT14() {
        return t14;
    }

    public void setSdi2(RichShowDetailItem sdi2) {
        this.sdi2 = sdi2;
    }

    public RichShowDetailItem getSdi2() {
        return sdi2;
    }

    public void setSdi5(RichShowDetailItem sdi5) {
        this.sdi5 = sdi5;
    }

    public RichShowDetailItem getSdi5() {
        return sdi5;
    }

    public void setSdi3(RichShowDetailItem sdi3) {
        this.sdi3 = sdi3;
    }

    public RichShowDetailItem getSdi3() {
        return sdi3;
    }

    public void setSdi4(RichShowDetailItem sdi4) {
        this.sdi4 = sdi4;
    }

    public RichShowDetailItem getSdi4() {
        return sdi4;
    }

    public void setPsl2(RichPanelStretchLayout psl2) {
        this.psl2 = psl2;
    }

    public RichPanelStretchLayout getPsl2() {
        return psl2;
    }

    public void setPfl2(RichPanelFormLayout pfl2) {
        this.pfl2 = pfl2;
    }

    public RichPanelFormLayout getPfl2() {
        return pfl2;
    }

    public void setCl2(RichCommandLink cl2) {
        this.cl2 = cl2;
    }

    public RichCommandLink getCl2() {
        return cl2;
    }

    public void setPsl3(RichPanelStretchLayout psl3) {
        this.psl3 = psl3;
    }

    public RichPanelStretchLayout getPsl3() {
        return psl3;
    }


    public void setId1(RichInputDate id1) {
        this.id1 = id1;
    }

    public RichInputDate getId1() {
        return id1;
    }

    public void setPsl4(RichPanelStretchLayout psl4) {
        this.psl4 = psl4;
    }

    public RichPanelStretchLayout getPsl4() {
        return psl4;
    }

    public void setOt18(RichOutputText ot18) {
        this.ot18 = ot18;
    }

    public RichOutputText getOt18() {
        return ot18;
    }

    public void setPgl3(RichPanelGroupLayout pgl3) {
        this.pgl3 = pgl3;
    }

    public RichPanelGroupLayout getPgl3() {
        return pgl3;
    }

    public void setOt19(RichOutputText ot19) {
        this.ot19 = ot19;
    }

    public RichOutputText getOt19() {
        return ot19;
    }

    public void setCb1(RichCommandButton cb1) {
        this.cb1 = cb1;
    }

    public RichCommandButton getCb1() {
        return cb1;
    }

    public void onOpenSuppDocFileSelected(ActionEvent actionEvent) {
        BindingContainer bindings = ADFUtils.getBindingContainer();
        RichCommandLink comp = (RichCommandLink)actionEvent.getComponent();
        Key rowKey = (Key)comp.getAttributes().get("rowKey");
        log.info("rowKey::" + rowKey);
        DCIteratorBinding iterBindings =
            (DCIteratorBinding)bindings.get("AttachedfileSupportDocViewObj1Iterator");
        FileUploadUtils.partialTableRefresh(rowKey, getT2());

        RowSetIterator empRSIter = iterBindings.getRowSetIterator();
        Row currentRow = empRSIter.getRow(rowKey);
        //file name and Download buttion getter
        log.info("filenameStore::" + currentRow.getAttribute("filenameStore"));
        FileUploadUtils.setOpenFileName(BaseUtil.getStr(currentRow.getAttribute("filenameStore")),
                                        BaseUtil.getStr(currentRow.getAttribute("filenameOrig")),
                                        getCb1().getClientId(FacesContext.getCurrentInstance()));
    }

    public void setId2(RichInputDate id2) {
        this.id2 = id2;
    }

    public RichInputDate getId2() {
        return id2;
    }

    public void setPgl4(RichPanelGroupLayout pgl4) {
        this.pgl4 = pgl4;
    }

    public RichPanelGroupLayout getPgl4() {
        return pgl4;
    }

    public void setOt38(RichOutputText ot38) {
        this.ot38 = ot38;
    }

    public RichOutputText getOt38() {
        return ot38;
    }

    public void setId3(RichInputDate id3) {
        this.id3 = id3;
    }

    public RichInputDate getId3() {
        return id3;
    }


    public void setCl8(RichCommandLink cl8) {
        this.cl8 = cl8;
    }

    public RichCommandLink getCl8() {
        return cl8;
    }


    public void setPfl4(RichPanelFormLayout pfl4) {
        this.pfl4 = pfl4;
    }

    public RichPanelFormLayout getPfl4() {
        return pfl4;
    }

    public void setSoc1(RichSelectOneChoice soc1) {
        this.soc1 = soc1;
    }

    public RichSelectOneChoice getSoc1() {
        return soc1;
    }


    public void setOt41(RichOutputText ot41) {
        this.ot41 = ot41;
    }

    public RichOutputText getOt41() {
        return ot41;
    }


    public void setPgl5(RichPanelGroupLayout pgl5) {
        this.pgl5 = pgl5;
    }

    public RichPanelGroupLayout getPgl5() {
        return pgl5;
    }

    public void setCb3(RichCommandButton cb3) {
        this.cb3 = cb3;
    }

    public RichCommandButton getCb3() {
        return cb3;
    }

    public void setCb4(RichCommandButton cb4) {
        this.cb4 = cb4;
    }

    public RichCommandButton getCb4() {
        return cb4;
    }

    public String getReqListForThisPolicy() {
        RHSession rhSession = (RHSession)JSFUtils.getFromSession("rhSession");
        String itemId = BaseUtil.getStr(rhSession.getFldPolicyId());
        String userid = BaseUtil.getStr(rhSession.getFldUserid());
        DCIteratorBinding reqListIter =
            ADFUtils.findIterator("RequestlistView1Iterator");
        ViewObject requestlistVO = reqListIter.getViewObject();
        requestlistVO.setWhereClause("itemId ='" + itemId +
                                     "' and requestorId ='" + userid +
                                     "' and typeOfReq ='" +
                                     Constants.RECORD_TYPE_SUPP_DOC + "'");
        requestlistVO.executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.getT4());
        return null;
    }

    public String getReqListForAllPolicies() {
        RHSession rhSession = (RHSession)JSFUtils.getFromSession("rhSession");
        String userid = BaseUtil.getStr(rhSession.getFldUserid());
        DCIteratorBinding reqListIter =
            ADFUtils.findIterator("RequestlistView1Iterator");
        ViewObject requestlistVO = reqListIter.getViewObject();
        requestlistVO.setWhereClause(" requestorId ='" + userid +
                                     "' and typeOfReq ='" +
                                     Constants.RECORD_TYPE_SUPP_DOC + "' ");
        requestlistVO.executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.getT4());
        return null;
    }

    public void setIt2(RichInputText it2) {
        this.it2 = it2;
    }

    public RichInputText getIt2() {
        return it2;
    }

    public void setCb5(RichCommandButton cb5) {
        this.cb5 = cb5;
    }

    public RichCommandButton getCb5() {
        return cb5;
    }

    public void setCb6(RichCommandButton cb6) {
        this.cb6 = cb6;
    }

    public RichCommandButton getCb6() {
        return cb6;
    }

    public String submitRequest() {
        if (this.getIt2().getValue() != null &&
            !this.getIt2().getValue().equals("")) {
            JSFUtils.setExpressionValue("#{bindings.Designation.inputValue}",
                                        this.getSoc1().getValue());
            String designation =
                BaseUtil.getStr(JSFUtils.resolveExpression("#{bindings.Designation.attributeValue}"));
            log.info("Designation :  " + designation);
            RHSession rhSession =
                (RHSession)JSFUtils.getFromSession("rhSession");
            String policyId = BaseUtil.getStr(rhSession.getFldPolicyId());
            String userid = BaseUtil.getStr(rhSession.getFldUserid());
            DCIteratorBinding suppDocIter =
                ADFUtils.findIterator("AttachedfileSupportDocViewObj1Iterator");
            AttachedfileSupportDocViewObjRowImpl suppDocRow =
                (AttachedfileSupportDocViewObjRowImpl)suppDocIter.getViewObject().getCurrentRow();
            DCIteratorBinding reqListIter =
                ADFUtils.findIterator("RequestlistView1Iterator");
            RequestlistViewRowImpl reqRow =
                (RequestlistViewRowImpl)reqListIter.getViewObject().createRow();
            reqRow.setrequestId(RandomGuidUtil.fnGuidWithTimestamp());
            reqRow.setitemId(policyId);
            reqRow.settypeOfReqId(BaseUtil.getStr(suppDocRow.getfileId()));
            reqRow.settypeOfReqName(BaseUtil.getStr(suppDocRow.getdocumentName()));
            reqRow.settypeOfReq(Constants.RECORD_TYPE_SUPP_DOC);
            reqRow.setrequestorId(userid);
            reqRow.setstatus(Constants.RECORD_STATUS_PENDING);
            reqRow.setcreateDate(DateUtils.getCurrentTimestamp());
            reqRow.setreasonForRequest(BaseUtil.getStr(this.getIt2().getValue()));
            reqRow.setDesignation(designation);
            setRequestStatus(false);
            String commitStatus = commitAction();
            if (Constants.STATUS_SUCCESS.equalsIgnoreCase(commitStatus)) {
                ADFUtils.showInfoMessage(Constants.REQUEST_HAS_SUBMITED);
            }
            EmailUtils.sendMailRequestForAccessSuppDocs(reqRow);
            this.getReqListForThisPolicy();
        } else {
            ADFUtils.showErrorMessage("Reason for Request");
        }
        return null;
    }

    public String cancelRequest() {
        setRequestStatus(false);
        return null;
    }

    public void setRequestStatus(boolean requestStatus) {
        this.requestStatus = requestStatus;
    }

    public boolean isRequestStatus() {
        return requestStatus;
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
            //ADFUtils.showInfoMessage(Constants.DATA_SAVE_SUCCESSFULLY);
            return Constants.STATUS_SUCCESS;
        }
        return null;
    }

    private String rollbackAction() {
        BindingContainer bindings = ADFUtils.getBindingContainer();
        OperationBinding operationBinding =
            bindings.getOperationBinding("Rollback");
        Object result = operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
            ADFUtils.showInfoMessage(Constants.ERROR_MESSAGE_CONTACT);
            log.error(" ... " + operationBinding.getErrors());

        } else {
            //ADFUtils.showInfoMessage(Constants.DATA_SAVE_SUCCESSFULLY);
            return Constants.STATUS_SUCCESS;
        }
        return null;
    }

    public String requestForAccess() {
        setRequestStatus(true);
        return null;
    }

    public void setP1(RichPopup p1) {
        this.p1 = p1;
    }

    public RichPopup getP1() {
        return p1;
    }

    public void setD1(RichDialog d1) {
        this.d1 = d1;
    }

    public RichDialog getD1() {
        return d1;
    }

    public String openEnquiryTab() {
        this.getSdi5().setDisclosed(true);
        this.getSdi2().setDisclosed(false);
        this.getSdi1().setDisclosed(false);
        this.getSdi3().setDisclosed(false);
        this.getSdi4().setDisclosed(false);
        return null;
    }

    public void getEnqPopup(DialogEvent dialogEvent) {
        if (dialogEvent.getOutcome() == dialogEvent.getOutcome().yes) {
            this.getSdi5().setDisclosed(true);
            this.getSdi2().setDisclosed(false);
            this.getSdi1().setDisclosed(false);
            this.getSdi3().setDisclosed(false);
            this.getSdi4().setDisclosed(false);
            setAddEnqStatus(true);
            this.createEnquiryRow();
        } else {
            this.getSdi5().setDisclosed(false);
            this.getSdi2().setDisclosed(true);
            this.getSdi1().setDisclosed(false);
            this.getSdi3().setDisclosed(false);
            this.getSdi4().setDisclosed(false);
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.getPt1());
    }

    public String hidePopupP1() {
        PopUpUtils.showOrHidePopup(getP1(), false);
        return null;
    }

    public String showPopupP1() {
        PopUpUtils.showOrHidePopup(getP1(), true);
        return null;
    }

    public void onDisclosure(DisclosureEvent disclosureEvent) {

        RichShowDetailItem rsdi =
            (RichShowDetailItem)disclosureEvent.getSource();
        RHSession rhSession = (RHSession)JSFUtils.getFromSession("rhSession");
        boolean disclosed = rsdi.isDisclosed();
        if (disclosed) {
            //showPopupP1();
            rsdi.setDisclosed(!disclosed);
        }
    }

    public void prefaceOnDisclosure(DisclosureEvent disclosureEvent) {

        RichShowDetailItem rsdi =
            (RichShowDetailItem)disclosureEvent.getSource();
        boolean disclosed = rsdi.isDisclosed();
        log.info("prefaceOnDisclosure openTab::" +
                 AdfFacesContext.getCurrentInstance().getPageFlowScope().get("openTab"));
        log.info("disclosed:" + disclosed);
        if (disclosed) {
            AdfFacesContext.getCurrentInstance().getPageFlowScope().put("openTab",
                                                                        "Pre");
        }
        log.info("openTab::" +
                 AdfFacesContext.getCurrentInstance().getPageFlowScope().get("openTab"));
    }

    public void faqOnDisclosure(DisclosureEvent disclosureEvent) {

        RichShowDetailItem rsdi =
            (RichShowDetailItem)disclosureEvent.getSource();
        boolean disclosed = rsdi.isDisclosed();
        log.info("faqOnDisclosure openTab::" +
                 AdfFacesContext.getCurrentInstance().getPageFlowScope().get("openTab"));
        log.info("disclosed:" + disclosed);
        if (disclosed) {
            AdfFacesContext.getCurrentInstance().getPageFlowScope().put("openTab",
                                                                        "Faq");
        }
        log.info("openTab::" +
                 AdfFacesContext.getCurrentInstance().getPageFlowScope().get("openTab"));
    }

    public void enqOnDisclosure(DisclosureEvent disclosureEvent) {

        RichShowDetailItem rsdi =
            (RichShowDetailItem)disclosureEvent.getSource();
        boolean disclosed = rsdi.isDisclosed();
        log.info("faqOnDisclosure openTab::" +
                 AdfFacesContext.getCurrentInstance().getPageFlowScope().get("openTab"));
        log.info("disclosed:" + disclosed);
        if (disclosed) {
            AdfFacesContext.getCurrentInstance().getPageFlowScope().put("openTab",
                                                                        "Enq");
        }
        log.info("openTab::" +
                 AdfFacesContext.getCurrentInstance().getPageFlowScope().get("openTab"));
    }
    public void suppOnDisclosure(DisclosureEvent disclosureEvent) {

        RichShowDetailItem rsdi =
            (RichShowDetailItem)disclosureEvent.getSource();
        boolean disclosed = rsdi.isDisclosed();
        log.info("faqOnDisclosure openTab::" +
                 AdfFacesContext.getCurrentInstance().getPageFlowScope().get("openTab"));
        log.info("disclosed:" + disclosed);
        if (disclosed) {
            AdfFacesContext.getCurrentInstance().getPageFlowScope().put("openTab",
                                                                        "Supp");
        }
        log.info("openTab::" +
                 AdfFacesContext.getCurrentInstance().getPageFlowScope().get("openTab"));
    }
    public void amentOnDisclosure(DisclosureEvent disclosureEvent) {

        RichShowDetailItem rsdi =
            (RichShowDetailItem)disclosureEvent.getSource();
        boolean disclosed = rsdi.isDisclosed();
        log.info("faqOnDisclosure openTab::" +
                 AdfFacesContext.getCurrentInstance().getPageFlowScope().get("openTab"));
        log.info("disclosed:" + disclosed);
        if (disclosed) {
            AdfFacesContext.getCurrentInstance().getPageFlowScope().put("openTab",
                                                                        "Ament");
        }
        log.info("openTab::" +
                 AdfFacesContext.getCurrentInstance().getPageFlowScope().get("openTab"));
    }
    public String onPageLoad() {
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("openTab",
                                                                    "Pre");
        log.info("loadPageFlowScope openTab::" +
                 AdfFacesContext.getCurrentInstance().getPageFlowScope().get("openTab"));
        return Constants.STATUS_SUCCESS;
    }

    public void setOt52(RichOutputText ot52) {
        this.ot52 = ot52;
    }

    public RichOutputText getOt52() {
        return ot52;
    }

    public void setPt1(RichPanelTabbed pt1) {
        this.pt1 = pt1;
    }

    public RichPanelTabbed getPt1() {
        return pt1;
    }


    public void setPfl6(RichPanelFormLayout pfl6) {
        this.pfl6 = pfl6;
    }

    public RichPanelFormLayout getPfl6() {
        return pfl6;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public String getCurrentDate() {
        currentDate = DateUtils.getCurrentDate3();
        return currentDate;
    }

    public void setIt1(RichInputText it1) {
        this.it1 = it1;
    }

    public RichInputText getIt1() {
        return it1;
    }

    public void setSor1(RichSelectOneRadio sor1) {
        this.sor1 = sor1;
    }

    public RichSelectOneRadio getSor1() {
        return sor1;
    }

    public void setSi2(RichSelectItem si2) {
        this.si2 = si2;
    }

    public RichSelectItem getSi2() {
        return si2;
    }

    public void setSi3(RichSelectItem si3) {
        this.si3 = si3;
    }

    public RichSelectItem getSi3() {
        return si3;
    }

    public void setSi4(RichSelectItem si4) {
        this.si4 = si4;
    }

    public RichSelectItem getSi4() {
        return si4;
    }

    public void setSi5(RichSelectItem si5) {
        this.si5 = si5;
    }

    public RichSelectItem getSi5() {
        return si5;
    }

    public void setPgl7(RichPanelGroupLayout pgl7) {
        this.pgl7 = pgl7;
    }

    public RichPanelGroupLayout getPgl7() {
        return pgl7;
    }

    public void setCb7(RichCommandButton cb7) {
        this.cb7 = cb7;
    }

    public RichCommandButton getCb7() {
        return cb7;
    }

    public void setCb8(RichCommandButton cb8) {
        this.cb8 = cb8;
    }

    public RichCommandButton getCb8() {
        return cb8;
    }

    public void setPfl7(RichPanelFormLayout pfl7) {
        this.pfl7 = pfl7;
    }

    public RichPanelFormLayout getPfl7() {
        return pfl7;
    }

    public void setPgl8(RichPanelGroupLayout pgl8) {
        this.pgl8 = pgl8;
    }

    public RichPanelGroupLayout getPgl8() {
        return pgl8;
    }

    public void setCb9(RichCommandButton cb9) {
        this.cb9 = cb9;
    }

    public RichCommandButton getCb9() {
        return cb9;
    }

    public void setCb10(RichCommandButton cb10) {
        this.cb10 = cb10;
    }

    public RichCommandButton getCb10() {
        return cb10;
    }

    public void setAddEnqStatus(boolean addEnqStatus) {
        this.addEnqStatus = addEnqStatus;
    }

    public boolean isAddEnqStatus() {
        return addEnqStatus;
    }

    public void setViewEnqStatus(boolean viewEnqStatus) {
        this.viewEnqStatus = viewEnqStatus;
    }

    public boolean isViewEnqStatus() {
        return viewEnqStatus;
    }

    public String cancelAddEnquiry() {
        setAddEnqStatus(false);
        this.rollbackAction();
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("fldEnquiryFAQId",
                                                                    "");
        return null;
    }

    public void enquiryTableSelectionListener(SelectionEvent selectionEvent) {


        setAddEnqStatus(false);
        setViewEnqStatus(true);
        JSFUtils.invokeEL("#{bindings.EnquiryfaqForEnqPolicyViewObj1.collectionModel.makeCurrent}",
                          new Class[] { SelectionEvent.class },
                          new Object[] { selectionEvent });
        // get the selected row , by this you can get any attribute of that row
        Row selectedRow =
            (Row)JSFUtils.evaluateEL("#{bindings.EnquiryfaqForEnqPolicyViewObj1.currentRow}"); // get the current selected row
        try {
            String abstract11 =
                BaseUtil.getStr(selectedRow.getAttribute("Abstract11"));
            this.getOt65().setValue(UtilCommon.decryptSpecialChar(abstract11) );
            this.getOt58().setValue(selectedRow.getAttribute("Title"));
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.ot65);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.ot58);
            String fldEnquiryFAQId =
                BaseUtil.getStr(selectedRow.getAttribute("EnquiryFAQId"));
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
            this.cancelAddEnquiry();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.t3);
        } catch (Exception e) {
            log.info("Exception @notOperationTableSelectionListener .. " + e);
        }
    }

    public String submitAddEnquiry() {
        String title = BaseUtil.getStr(this.getIt1().getValue());
        if (this.getIt1().getValue() != null &&
            !this.getIt1().getValue().equals("") &&
            this.getSor1().getValue() != null &&
            !this.getSor1().getValue().equals("")) {
            RHSession rhSession =
                (RHSession)JSFUtils.getFromSession("rhSession");
            String itemId = BaseUtil.getStr(rhSession.getFldPolicyId());
            String userid = BaseUtil.getStr(rhSession.getFldUserid());
            String fldEnquiryFAQId =
                BaseUtil.getStr(AdfFacesContext.getCurrentInstance().getPageFlowScope().get("fldEnquiryFAQId"));
            String isInternalExternal =
                BaseUtil.getStr(rhSession.getIsInternalExternal());
            DCIteratorBinding enqIter =
                ADFUtils.findIterator("EnquiryfaqForEnqPolicyViewObj1Iterator");
            //            EnquiryfaqForEnqPolicyViewObjRowImpl row =
            //                (EnquiryfaqForEnqPolicyViewObjRowImpl)enqIter.getViewObject().createRow();
            EnquiryfaqForEnqPolicyViewObjRowImpl row =
                (EnquiryfaqForEnqPolicyViewObjRowImpl)enqIter.getCurrentRow();
            //row.setEnquiryFAQId(fldEnquiryFAQId);
            row.setOrigTitle(title);
            row.setTitle(title);
            row.setcreatedBy(userid);
            row.setenquiryStatus(Constants.RECORD_STATUS_PENDING);
            row.setsharingOption(BaseUtil.getStr(this.getSor1().getValue()));
            row.setisInternalExternal(isInternalExternal);
            if (rhSession.getIsInternalExternal().equals(Constants.IS_INTERNAL_OR_EXTERNAL_IN)) {
                row.setEnquirerBNMRole(rhSession.getFldUserType());
            } else {
                row.setEnquirerFIRole(rhSession.getFldUserType());
            }
            setAddEnqStatus(false);
            String commitStatus = this.commitAction();
            if (Constants.STATUS_SUCCESS.equalsIgnoreCase(commitStatus)) {
                ADFUtils.showInfoMessage(Constants.ENQUIRY_HAS_SENT);
            }
            EmailUtils.sendMailSubmitEnquiry(row);
            ViewObject polEnqVO = enqIter.getViewObject();
            polEnqVO.setNamedWhereClauseParam("bindItemId", itemId);
            polEnqVO.setWhereClause(" isInternalExternal ='" +
                                    isInternalExternal + "' ");
            polEnqVO.executeQuery();
            long enqSize = polEnqVO.getEstimatedRowCount();
            log.info("enqSize::" + enqSize);
            String enqIds = "";
            List enqList = new ArrayList();
            EnquiryfaqForEnqPolicyViewObjRowImpl enqRow = null;
            for (int i = 0; i < enqSize; i++) {
                if (i == 0) {
                    enqRow =
                            (EnquiryfaqForEnqPolicyViewObjRowImpl)polEnqVO.first();
                } else {
                    enqRow =
                            (EnquiryfaqForEnqPolicyViewObjRowImpl)polEnqVO.next();
                }
                String createdBy = enqRow.getcreatedBy();
                String sharingOption = enqRow.getsharingOption().trim();
                String enquiryFAQId = enqRow.getEnquiryFAQId();
                if (createdBy != null && userid.equals(createdBy)) {
                    enqIds += " '" + enquiryFAQId + "' ,";
                    enqList.add(enquiryFAQId);
                } else {
                    boolean isCeoOic = false;
                    String createdByDepId = "";
                    String createdByOrgId = "";
                    if ("IN".equals(isInternalExternal)) {
                        createdByDepId =
                                BaseUtil.getStr(CommonRHUtil.getUserDetails(createdBy).get("depId"));
                    } else {
                        createdByOrgId =
                                BaseUtil.getStr(CommonRHUtil.getUserDetails(createdBy).get("orgId"));
                        if (Constants.USER_ROLE_TYPE_ID_RH_CEO.equals(rhSession.getFldUserType()) ||
                            Constants.USER_ROLE_TYPE_ID_RH_OIC.equals(rhSession.getFldUserType())) {
                            isCeoOic = true;
                        }
                    }
                    if (sharingOption.equals("OIC_CEO") && isCeoOic &&
                        createdByOrgId.equals(rhSession.getFldOrgId())) {
                        enqIds += " '" + enquiryFAQId + "' ,";
                        enqList.add(enquiryFAQId);
                    } else if (sharingOption.equals("INST") &&
                               createdByOrgId.equals(rhSession.getFldOrgId())) {
                        enqIds += " '" + enquiryFAQId + "' ,";
                        enqList.add(enquiryFAQId);
                    } else if (sharingOption.equals("DEP")) {
                        if (createdByDepId.equals(rhSession.getFldDepartmentId())) {
                            enqIds += " '" + enquiryFAQId + "' ,";
                            enqList.add(enquiryFAQId);
                        }
                    } else if (sharingOption.equals("ALL") &&
                               "IN".equals(isInternalExternal)) {
                        enqIds += " '" + enquiryFAQId + "' ,";
                        enqList.add(enquiryFAQId);
                    }
                }
            }
            log.info("enqList.size()::" + enqList.size());
            if (enqSize > 0 && enqSize != enqList.size()) {
                enqIds = "(" + enqIds + ")";
                enqIds = enqIds.replace(",)", ")");
                ViewObject polEnqVO1 = enqIter.getViewObject();
                polEnqVO1.setNamedWhereClauseParam("bindItemId", itemId);
                if (enqList.size() == 0) {
                    polEnqVO1.setWhereClause(" EnquiryFAQId='' ");
                } else {
                    polEnqVO1.setWhereClause(" EnquiryFAQId IN " + enqIds);
                }
                polEnqVO1.executeQuery();
            }
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.getT3());
        } else {
            if (this.getIt1().getValue() == null ||
                this.getIt1().getValue().equals("")) {
                ADFUtils.showInfoMessage(" Question is mandatory.");
            } else if (this.getSor1().getValue() == null ||
                       this.getSor1().getValue().equals("")) {
                ADFUtils.showInfoMessage(" This enquiry may be shared with is mandatory.");
            }
            setAddEnqStatus(true);
        }
        return null;
    }

    public String addEnquiry() {
        DCIteratorBinding faqIter =
            ADFUtils.findIterator("EnquiryfaqForFaqView1Iterator");
        if (faqIter.getEstimatedRowCount() > 0) {
            showPopupP1();
        } else {
            this.getSdi5().setDisclosed(true);
            this.getSdi2().setDisclosed(false);
            this.getSdi1().setDisclosed(false);
            this.getSdi3().setDisclosed(false);
            this.getSdi4().setDisclosed(false);
            setAddEnqStatus(true);
            this.createEnquiryRow();
        }
        return null;
    }

    public void createEnquiryRow() {
        String fldEnquiryFAQId = RandomGuidUtil.fnGuidWithDate();
        RHSession rhSession = (RHSession)JSFUtils.getFromSession("rhSession");
        String itemId = BaseUtil.getStr(rhSession.getFldPolicyId());
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("fldEnquiryFAQId",
                                                                    fldEnquiryFAQId);
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("itemid",
                                                                    itemId);
        DCIteratorBinding enqIter =
            ADFUtils.findIterator("EnquiryfaqForEnqPolicyViewObj1Iterator");
        ViewObject vo = enqIter.getViewObject();
        EnquiryfaqForEnqPolicyViewObjRowImpl row =
            (EnquiryfaqForEnqPolicyViewObjRowImpl)vo.createRow();
        row.setEnquiryFAQId(fldEnquiryFAQId);
        row.setcreateDate(DateUtils.getCurrentTimestamp());
        row.setCreatedbyInstitutionId("");
        row.setitemId(itemId);
        row.setEnquiryOrFaq(Constants.RECORD_TYPE_ENQUIRY);
        row.setCurrentItemtype(Constants.RECORD_TYPE_ENQUIRY);
        row.setOriginType(Constants.RECORD_TYPE_ENQUIRY);
        row.setOriginalItemtype(Constants.RECORD_TYPE_ENQUIRY);
        vo.insertRow(row);
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
        this.getIt1().setValue("");
    }

    public void setSi1(UISelectItems si1) {
        this.si1 = si1;
    }

    public UISelectItems getSi1() {
        return si1;
    }

    public void setIf1(RichInputFile if1) {
        this.if1 = if1;
    }

    public RichInputFile getIf1() {
        return if1;
    }

    public void setQueUploadedFile(UploadedFile queUploadedFile) {

        String filename = BaseUtil.getStr(queUploadedFile.getFilename());
        boolean fileUploadStatus = false;
        if (!filename.equals("") &&
            FileUploadUtils.checkFileExtension(filename)) {
            String fldEnquiryFAQId =
                BaseUtil.getStr(AdfFacesContext.getCurrentInstance().getPageFlowScope().get("fldEnquiryFAQId"));
            String itemid =
                BaseUtil.getStr(AdfFacesContext.getCurrentInstance().getPageFlowScope().get("itemid"));
            fileUploadStatus =
                    FileUploadUtils.setEnqUploadedFile(queUploadedFile,
                                                       "AttachedfileForEnqQueView1Iterator",
                                                       itemid, fldEnquiryFAQId,
                                                       Constants.ATTACHMENT_ENQUIRY_TYPE_QUESTION);
        } else {
            ADFUtils.showErrorMessage(Constants.INVALID_FILE_FORMAT);
        }
        if (fileUploadStatus) {
            ADFUtils.showInfoMessage(Constants.ATTACHMENT_SAVE_SUCCESSFULLY);
        } else {
            ADFUtils.showErrorMessage(Constants.ATTACHMENT_SAVE_ERROR);
        }
    }

    public void onDeleteQueFileSelected(ActionEvent actionEvent) {
        BindingContainer bindings = ADFUtils.getBindingContainer();
        log.info("bindings:" + bindings);
        RichCommandLink comp = (RichCommandLink)actionEvent.getComponent();

        Key rowKey = (Key)comp.getAttributes().get("rowKeyDelete");
        log.info("delete rowKey:::::: " + rowKey);

        DCIteratorBinding iterBindings =
            (DCIteratorBinding)bindings.get("AttachedfileForEnqQueView1Iterator");
        FileUploadUtils.removeFromTable(iterBindings, rowKey);

        FileUploadUtils.partialTableRefresh(rowKey, getT5());
        setAddEnqStatus(true);
    }

    public void onOpenQueFileSelected(ActionEvent actionEvent) {
        BindingContainer bindings = ADFUtils.getBindingContainer();
        RichCommandLink comp = (RichCommandLink)actionEvent.getComponent();
        Key rowKey = (Key)comp.getAttributes().get("rowKey");
        log.info("rowKey::" + rowKey);
        DCIteratorBinding iterBindings =
            (DCIteratorBinding)bindings.get("AttachedfileForEnqQueView1Iterator");
        FileUploadUtils.partialTableRefresh(rowKey, getT5());

        RowSetIterator empRSIter = iterBindings.getRowSetIterator();
        Row currentRow = empRSIter.getRow(rowKey);
        //file name and Download buttion getter
        FileUploadUtils.setOpenFileName(BaseUtil.getStr(currentRow.getAttribute("filenameStore")),
                                        BaseUtil.getStr(currentRow.getAttribute("filenameOrig")),
                                        getCb10().getClientId(FacesContext.getCurrentInstance()));
        setAddEnqStatus(true);
    }

    public UploadedFile getQueUploadedFile() {
        return queUploadedFile;
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
                                        getCb10().getClientId(FacesContext.getCurrentInstance()));
        setViewEnqStatus(true);
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
                                        getCb10().getClientId(FacesContext.getCurrentInstance()));
        setViewEnqStatus(true);
    }


    public void setOt58(RichOutputText ot58) {
        this.ot58 = ot58;
    }

    public RichOutputText getOt58() {
        return ot58;
    }

    public void setOt65(RichOutputText ot65) {
        this.ot65 = ot65;
    }

    public RichOutputText getOt65() {
        return ot65;
    }

    public void setPgl10(RichPanelGroupLayout pgl10) {
        this.pgl10 = pgl10;
    }

    public RichPanelGroupLayout getPgl10() {
        return pgl10;
    }
}
