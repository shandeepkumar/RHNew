package gov.bnm.view.rh.backingBeans;

import gov.bnm.rh.views.RequestlistViewRowImpl;
import gov.bnm.view.rh.constant.Constants;
import gov.bnm.view.rh.session.RHSession;
import gov.bnm.view.rh.utils.ADFUtils;
import gov.bnm.view.rh.utils.BaseUtil;
import gov.bnm.view.rh.utils.DateUtils;
import gov.bnm.view.rh.utils.EmailUtils;
import gov.bnm.view.rh.utils.JSFUtils;

import gov.view.common.validation.ValidatorUtil;

import javax.faces.event.ValueChangeEvent;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectOneRadio;
import oracle.adf.view.rich.component.rich.layout.RichPanelFormLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelLabelAndMessage;
import oracle.adf.view.rich.component.rich.layout.RichPanelStretchLayout;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.component.rich.output.RichOutputText;

import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import org.apache.log4j.Logger;

public class SuppDocReqDecisionPage {
    static Logger log = Logger.getLogger(SuppDocReqDecisionPage.class);
    private RichPanelStretchLayout psl1;
    private RichPanelFormLayout pfl1;
    private RichPanelLabelAndMessage plam1;
    private RichOutputText ot1;
    private RichPanelLabelAndMessage plam2;
    private RichOutputText ot2;
    private RichPanelLabelAndMessage plam3;
    private RichOutputText ot3;
    private RichPanelLabelAndMessage plam4;
    private RichOutputText ot4;
    private RichPanelLabelAndMessage plam5;
    private RichOutputText ot5;
    private RichPanelLabelAndMessage plam6;
    private RichOutputText ot6;
    private RichPanelLabelAndMessage plam7;
    private RichOutputText ot7;
    private RichSelectOneRadio sor1;
    private RichInputText it1;
    private RichPanelGroupLayout pgl1;
    private RichCommandButton cb1;
    private RichCommandButton cb2;
    private RichOutputText ot8;
    private String decision;
    private RichOutputText ot9;
    private RichOutputText ot10;

    public String closePage() {
        JSFUtils.closeWindow();
        return null;
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

    public void setPlam2(RichPanelLabelAndMessage plam2) {
        this.plam2 = plam2;
    }

    public RichPanelLabelAndMessage getPlam2() {
        return plam2;
    }

    public void setOt2(RichOutputText ot2) {
        this.ot2 = ot2;
    }

    public RichOutputText getOt2() {
        return ot2;
    }

    public void setPlam3(RichPanelLabelAndMessage plam3) {
        this.plam3 = plam3;
    }

    public RichPanelLabelAndMessage getPlam3() {
        return plam3;
    }

    public void setOt3(RichOutputText ot3) {
        this.ot3 = ot3;
    }

    public RichOutputText getOt3() {
        return ot3;
    }

    public void setPlam4(RichPanelLabelAndMessage plam4) {
        this.plam4 = plam4;
    }

    public RichPanelLabelAndMessage getPlam4() {
        return plam4;
    }

    public void setOt4(RichOutputText ot4) {
        this.ot4 = ot4;
    }

    public RichOutputText getOt4() {
        return ot4;
    }

    public void setPlam5(RichPanelLabelAndMessage plam5) {
        this.plam5 = plam5;
    }

    public RichPanelLabelAndMessage getPlam5() {
        return plam5;
    }

    public void setOt5(RichOutputText ot5) {
        this.ot5 = ot5;
    }

    public RichOutputText getOt5() {
        return ot5;
    }

    public void setPlam6(RichPanelLabelAndMessage plam6) {
        this.plam6 = plam6;
    }

    public RichPanelLabelAndMessage getPlam6() {
        return plam6;
    }

    public void setOt6(RichOutputText ot6) {
        this.ot6 = ot6;
    }

    public RichOutputText getOt6() {
        return ot6;
    }

    public void setPlam7(RichPanelLabelAndMessage plam7) {
        this.plam7 = plam7;
    }

    public RichPanelLabelAndMessage getPlam7() {
        return plam7;
    }

    public void setOt7(RichOutputText ot7) {
        this.ot7 = ot7;
    }

    public RichOutputText getOt7() {
        return ot7;
    }

    public void setSor1(RichSelectOneRadio sor1) {
        this.sor1 = sor1;
    }

    public RichSelectOneRadio getSor1() {
        return sor1;
    }

    public void setIt1(RichInputText it1) {
        this.it1 = it1;
    }

    public RichInputText getIt1() {
        return it1;
    }

    public String submitDecision() {
        RHSession rhSession = (RHSession)JSFUtils.getFromSession("rhSession");
        DCIteratorBinding reqListIter =
            ADFUtils.findIterator("RequestlistView1Iterator");
        RequestlistViewRowImpl reqRow =
            (RequestlistViewRowImpl)reqListIter.getViewObject().getCurrentRow();
        reqRow.setupdateDate(DateUtils.getCurrentTimestamp());
        reqRow.setapproverId(rhSession.getFldUserid());
        reqRow.setstatus(BaseUtil.getStr(this.getSor1().getValue()));
        String commitStatus = this.commitAction();

        try {

            if (Constants.STATUS_SUCCESS.equalsIgnoreCase(commitStatus)) {
                if (ValidatorUtil.isNotNull(this.getSor1().getValue())) {
                    String decisionStatus =
                        this.getSor1().getValue().toString();
                    if (Constants.RECORD_STATUS_APPROVED.equalsIgnoreCase(decisionStatus)) {
                        ADFUtils.showInfoMessage(Constants.REQUEST_HAS_BEEN +
                                                 " " +
                                                 Constants.STATUS_APPROVED);
                    } else if (Constants.RECORD_STATUS_REJECTED.equalsIgnoreCase(decisionStatus)) {
                        ADFUtils.showInfoMessage(Constants.REQUEST_HAS_BEEN +
                                                 " " +
                                                 Constants.STATUS_REJECTED);
                    } else {
                        ADFUtils.showInfoMessage(Constants.DECISION_HAS_SUBMITED);
                    }
                }
            }
        } catch (Exception e) {
            log.error("Exception @submitDecision .. " + e);
        }
        EmailUtils.sendMailResponseForAccessSuppDocs(reqRow);
        return null;
    }

    public String cancelDecision() {
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

    public void setPgl1(RichPanelGroupLayout pgl1) {
        this.pgl1 = pgl1;
    }

    public RichPanelGroupLayout getPgl1() {
        return pgl1;
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

    public void setOt8(RichOutputText ot8) {
        this.ot8 = ot8;
    }

    public RichOutputText getOt8() {
        return ot8;
    }


    public void setDecision(String decision) {
        this.decision = decision;
    }

    public String getDecision() {
        return decision;
    }

    public void setOt9(RichOutputText ot9) {
        this.ot9 = ot9;
    }

    public RichOutputText getOt9() {
        return ot9;
    }

    public void setOt10(RichOutputText ot10) {
        this.ot10 = ot10;
    }

    public RichOutputText getOt10() {
        return ot10;
    }
}
