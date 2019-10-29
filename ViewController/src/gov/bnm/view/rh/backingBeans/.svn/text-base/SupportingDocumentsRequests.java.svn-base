package gov.bnm.view.rh.backingBeans;

import gov.bnm.rh.views.RequestlistViewRowImpl;
import gov.bnm.view.rh.constant.Constants;
import gov.bnm.view.rh.session.RHSession;
import gov.bnm.view.rh.utils.ADFUtils;

import gov.bnm.view.rh.utils.BaseUtil;
import gov.bnm.view.rh.utils.DateUtils;
import gov.bnm.view.rh.utils.EmailUtils;
import gov.bnm.view.rh.utils.FileUploadUtils;
import gov.bnm.view.rh.utils.JSFUtils;

import java.io.OutputStream;

import javax.faces.context.FacesContext;

import javax.faces.event.ActionEvent;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectItem;
import oracle.adf.view.rich.component.rich.input.RichSelectOneRadio;
import oracle.adf.view.rich.component.rich.layout.RichPanelFormLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelLabelAndMessage;
import oracle.adf.view.rich.component.rich.layout.RichPanelStretchLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelTabbed;
import oracle.adf.view.rich.component.rich.layout.RichShowDetailItem;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.component.rich.nav.RichCommandLink;
import oracle.adf.view.rich.component.rich.output.RichOutputText;

import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;

import org.apache.log4j.Logger;

public class SupportingDocumentsRequests {
    static Logger log = Logger.getLogger(SupportingDocumentsRequests.class);
    private RichPanelStretchLayout psl1;
    private RichTable t1;
    private RichInputDate id1;
    private RichPanelGroupLayout pgl1;
    private RichInputDate id2;
    private RichPanelFormLayout pfl1;
    private RichPanelLabelAndMessage plam1;
    private RichOutputText ot6;
    private RichPanelLabelAndMessage plam2;
    private RichOutputText ot7;
    private RichPanelLabelAndMessage plam3;
    private RichOutputText ot8;
    private RichPanelLabelAndMessage plam4;
    private RichOutputText ot9;
    private RichPanelLabelAndMessage plam5;
    private RichOutputText ot10;
    private RichPanelLabelAndMessage plam6;
    private RichOutputText ot11;
    private RichSelectOneRadio sor1;
    private RichSelectItem si1;
    private RichSelectItem si2;
    private RichInputText it1;
    private RichPanelGroupLayout pgl2;
    private RichCommandButton cb1;
    private RichCommandButton cb2;
    private boolean decisionStatus = false;
    private RichCommandButton cb3;
    private RichPanelTabbed pt1;
    private RichShowDetailItem sdi1;

    public void onOpenSuppDocFileSelected(ActionEvent actionEvent) {
        BindingContainer bindings = ADFUtils.getBindingContainer();
        RichCommandLink comp = (RichCommandLink)actionEvent.getComponent();
        Key rowKey = (Key)comp.getAttributes().get("rowKey");
        log.info("rowKey::" + rowKey);
        DCIteratorBinding iterBindings =
            (DCIteratorBinding)bindings.get("RequestlistView1Iterator");
        FileUploadUtils.partialTableRefresh(rowKey, getT1());

        RowSetIterator empRSIter = iterBindings.getRowSetIterator();
        Row currentRow = empRSIter.getRow(rowKey);
        //file name and Download buttion getter
        log.info("suppDocfilenameStore::" +
                 currentRow.getAttribute("suppDocfilenameStore"));
        FileUploadUtils.setOpenFileName(BaseUtil.getStr(currentRow.getAttribute("suppDocfilenameStore")),
                                        BaseUtil.getStr(currentRow.getAttribute("suppDocfilenameOrig")),
                                        getCb3().getClientId(FacesContext.getCurrentInstance()));
    }

    public void setPsl1(RichPanelStretchLayout psl1) {
        this.psl1 = psl1;
    }

    public RichPanelStretchLayout getPsl1() {
        return psl1;
    }

    public void setT1(RichTable t1) {
        this.t1 = t1;
    }

    public RichTable getT1() {
        return t1;
    }

    public void setId1(RichInputDate id1) {
        this.id1 = id1;
    }

    public RichInputDate getId1() {
        return id1;
    }

    public void setPgl1(RichPanelGroupLayout pgl1) {
        this.pgl1 = pgl1;
    }

    public RichPanelGroupLayout getPgl1() {
        return pgl1;
    }

    public void setId2(RichInputDate id2) {
        this.id2 = id2;
    }

    public RichInputDate getId2() {
        return id2;
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

    public void setOt6(RichOutputText ot6) {
        this.ot6 = ot6;
    }

    public RichOutputText getOt6() {
        return ot6;
    }

    public void setPlam2(RichPanelLabelAndMessage plam2) {
        this.plam2 = plam2;
    }

    public RichPanelLabelAndMessage getPlam2() {
        return plam2;
    }

    public void setOt7(RichOutputText ot7) {
        this.ot7 = ot7;
    }

    public RichOutputText getOt7() {
        return ot7;
    }

    public void setPlam3(RichPanelLabelAndMessage plam3) {
        this.plam3 = plam3;
    }

    public RichPanelLabelAndMessage getPlam3() {
        return plam3;
    }

    public void setOt8(RichOutputText ot8) {
        this.ot8 = ot8;
    }

    public RichOutputText getOt8() {
        return ot8;
    }

    public void setPlam4(RichPanelLabelAndMessage plam4) {
        this.plam4 = plam4;
    }

    public RichPanelLabelAndMessage getPlam4() {
        return plam4;
    }

    public void setOt9(RichOutputText ot9) {
        this.ot9 = ot9;
    }

    public RichOutputText getOt9() {
        return ot9;
    }

    public void setPlam5(RichPanelLabelAndMessage plam5) {
        this.plam5 = plam5;
    }

    public RichPanelLabelAndMessage getPlam5() {
        return plam5;
    }

    public void setOt10(RichOutputText ot10) {
        this.ot10 = ot10;
    }

    public RichOutputText getOt10() {
        return ot10;
    }

    public void setPlam6(RichPanelLabelAndMessage plam6) {
        this.plam6 = plam6;
    }

    public RichPanelLabelAndMessage getPlam6() {
        return plam6;
    }

    public void setOt11(RichOutputText ot11) {
        this.ot11 = ot11;
    }

    public RichOutputText getOt11() {
        return ot11;
    }

    public void setSor1(RichSelectOneRadio sor1) {
        this.sor1 = sor1;
    }

    public RichSelectOneRadio getSor1() {
        return sor1;
    }

    public void setSi1(RichSelectItem si1) {
        this.si1 = si1;
    }

    public RichSelectItem getSi1() {
        return si1;
    }

    public void setSi2(RichSelectItem si2) {
        this.si2 = si2;
    }

    public RichSelectItem getSi2() {
        return si2;
    }

    public void setIt1(RichInputText it1) {
        this.it1 = it1;
    }

    public RichInputText getIt1() {
        return it1;
    }

    public void setPgl2(RichPanelGroupLayout pgl2) {
        this.pgl2 = pgl2;
    }

    public RichPanelGroupLayout getPgl2() {
        return pgl2;
    }

    public void setCb1(RichCommandButton cb1) {
        this.cb1 = cb1;
    }

    public RichCommandButton getCb1() {
        return cb1;
    }

    public void setCb2(RichCommandButton cb2) {
        this.cb2 = cb2;
    }

    public RichCommandButton getCb2() {
        return cb2;
    }

    public String submitDecision() {
        String status = BaseUtil.getStr(this.getSor1().getValue());
        if (!status.equals("")) {
            RHSession rhSession =
                (RHSession)JSFUtils.getFromSession("rhSession");
            DCIteratorBinding reqListIter =
                ADFUtils.findIterator("RequestlistView1Iterator");
            RequestlistViewRowImpl reqRow =
                (RequestlistViewRowImpl)reqListIter.getViewObject().getCurrentRow();
            reqRow.setupdateDate(DateUtils.getCurrentTimestamp());
            reqRow.setapproverId(rhSession.getFldUserid());
            reqRow.setstatus(status);
            setDecisionStatus(false);
            String commitStatus = this.commitAction();

            if (Constants.STATUS_SUCCESS.equalsIgnoreCase(commitStatus)) {
                if (Constants.RECORD_STATUS_APPROVED.equalsIgnoreCase(status)) {
                    ADFUtils.showInfoMessage(Constants.REQUEST_HAS_BEEN + " " +
                                             Constants.STATUS_APPROVED);
                } else if (Constants.RECORD_STATUS_REJECTED.equalsIgnoreCase(status)) {
                    ADFUtils.showInfoMessage(Constants.REQUEST_HAS_BEEN + " " +
                                             Constants.STATUS_REJECTED);
                } else {
                    ADFUtils.showInfoMessage(Constants.DECISION_HAS_SUBMITED);
                }
            }
            EmailUtils.sendMailResponseForAccessSuppDocs(reqRow);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.getT1());
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.getPfl1());

        } else {
            ADFUtils.showErrorMessage("Decision is mandatory.");
        }
        return null;
    }

    public String cancelDecision() {
        setDecisionStatus(false);
        return null;
    }

    public String viewRequestDetails() {
        setDecisionStatus(true);
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
            //ADFUtils.showInfoMessage(Constants.DATA_SAVE_SUCCESSFULLY);
            return Constants.STATUS_SUCCESS;
        }
        return null;
    }

    public void doDownload(FacesContext facesContext, OutputStream out) {
        try {
            FileUploadUtils.downloadFile(out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setDecisionStatus(boolean decisionStatus) {
        this.decisionStatus = decisionStatus;
    }

    public boolean isDecisionStatus() {
        return decisionStatus;
    }

    public void setCb3(RichCommandButton cb3) {
        this.cb3 = cb3;
    }

    public RichCommandButton getCb3() {
        return cb3;
    }

    public void setPt1(RichPanelTabbed pt1) {
        this.pt1 = pt1;
    }

    public RichPanelTabbed getPt1() {
        return pt1;
    }

    public void setSdi1(RichShowDetailItem sdi1) {
        this.sdi1 = sdi1;
    }

    public RichShowDetailItem getSdi1() {
        return sdi1;
    }
}
