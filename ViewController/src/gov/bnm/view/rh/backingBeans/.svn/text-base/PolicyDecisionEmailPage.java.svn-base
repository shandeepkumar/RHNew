package gov.bnm.view.rh.backingBeans;

import gov.bnm.rh.views.PolicyViewRowImpl;
import gov.bnm.view.rh.constant.Constants;
import gov.bnm.view.rh.session.RHSession;
import gov.bnm.view.rh.utils.ADFUtils;
import gov.bnm.view.rh.utils.BaseUtil;
import gov.bnm.view.rh.utils.DateUtils;
import gov.bnm.view.rh.utils.EmailUtils;
import gov.bnm.view.rh.utils.JSFUtils;

import java.text.ParseException;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectItem;
import oracle.adf.view.rich.component.rich.input.RichSelectOneRadio;
import oracle.adf.view.rich.component.rich.layout.RichPanelFormLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelLabelAndMessage;
import oracle.adf.view.rich.component.rich.layout.RichPanelStretchLayout;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.component.rich.nav.RichCommandLink;
import oracle.adf.view.rich.component.rich.output.RichOutputText;
import oracle.adf.view.rich.component.rich.output.RichSpacer;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.ViewObject;

import org.apache.log4j.Logger;

public class PolicyDecisionEmailPage {
  static Logger log = Logger.getLogger(PolicyDecisionPage.class);
  private RichPanelStretchLayout psl1;
  private RichPanelFormLayout pfl1;
  private RichPanelLabelAndMessage plam1;
  private RichOutputText ot1;
  private RichInputText it1;
  private RichSelectOneRadio sor1;
  private RichOutputText ot2;
  private RichPanelGroupLayout pgl1;
  private RichPanelLabelAndMessage plam2;
  private RichOutputText ot3;
  private RichSpacer s2;
  private RichSelectItem si1;
  private RichSelectItem si2;
  private RichSpacer s3;
  private RichInputText it2;
  private RichSpacer s4;
  private RichPanelGroupLayout pgl2;
  private RichSpacer s5;
  private RichCommandButton cb3;
  private RichSpacer s6;
  private RichCommandButton cb4;
  private RichPanelFormLayout pfl2;
  private RichCommandButton cb1;
  private RichCommandLink cl1;
  private RichSpacer s1;
  private RichSpacer s8;

  public String closePage() {
    JSFUtils.closeWindow();
    return null;
  }

  public String submitDecision() {

    String status = BaseUtil.getStr(this.getSor1().getValue());
    boolean proceed = validateFields();
    log.info("status::" + status);
    if (proceed) {
      DCIteratorBinding polIter = ADFUtils.findIterator("PolicyView1Iterator");
      PolicyViewRowImpl row =
        (PolicyViewRowImpl)polIter.getViewObject().getCurrentRow();
      row.setLastUpdated(DateUtils.getCurrentTimestamp());
      row.setRecordStatus(status);

      if (status.equals(Constants.RECORD_STATUS_REJECTED)) {
        row.setReasonForRejection(BaseUtil.getStr(this.getIt1().getValue()));
        row.setisActive(false);
        EmailUtils.sendMailPolicyPublishRejection(row);
      } else {
        row.setisActive(true);
      }
      try {
        if (status.equals(Constants.RECORD_STATUS_ACTIVE)) {
          if (row.getDisplayInWhatsNew()) {
            int whatsNewMonths = BaseUtil.getInt(row.getWhatsNewMonths());
            try {
              row.setExpiryDate(DateUtils.getNextMonthTimeStamp(whatsNewMonths));
            } catch (ParseException e) {
              log.error("error:" + e.getMessage());
            }
          }
          long days =
            DateUtils.getTimeDifferent(DateUtils.getCurrentDateTime(),
                                       row.getNewIssuanceDate().toString());
          log.info("days::" + days);
          if (days == 1) {
            EmailUtils.sendMailPolicyPriorIssuance(row);
            row.setPriorPublishEmailFlag(true);
          } else if (days == 0) {
            EmailUtils.sendMailPolicyOnIssuance(row);
            row.setPublishedEmailFlag(true);
          }
        }
      } catch (ParseException e) {
        log.error("error:" + e.getMessage());
      }
      String returnStatus = this.commitAction();
      if ("save".equals(returnStatus)) {
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.getPfl1());
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.getPfl2());
      }

    }
    return null;
  }

  public boolean validateFields() {
    boolean status = true;
    if (this.getSor1().getValue() == null || this.getSor1().getValue().equals("")) {
      ADFUtils.showErrorMessage("Decision is mandatory.");
      status = false;
    } else if (this.getIt1().getValue() == null &&
               this.getSor1().getValue().equals(Constants.RECORD_STATUS_REJECTED)) {
      ADFUtils.showErrorMessage("Reason For Rejection is mandatory.");
      status = false;
    }
    return status;
  }

  private String commitAction() {
    BindingContainer bindings = ADFUtils.getBindingContainer();
    OperationBinding operationBinding = bindings.getOperationBinding("Commit");
    Object result = operationBinding.execute();
    if (!operationBinding.getErrors().isEmpty()) {
      ADFUtils.showInfoMessage(Constants.ERROR_MESSAGE_CONTACT);
      log.error(" ... " + operationBinding.getErrors());
      return "error";
    } else {
      return "save";
    }

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

  public void setOt2(RichOutputText ot2) {
    this.ot2 = ot2;
  }

  public RichOutputText getOt2() {
    return ot2;
  }

  public void setPgl1(RichPanelGroupLayout pgl1) {
    this.pgl1 = pgl1;
  }

  public RichPanelGroupLayout getPgl1() {
    return pgl1;
  }

  public void setPlam2(RichPanelLabelAndMessage plam2) {
    this.plam2 = plam2;
  }

  public RichPanelLabelAndMessage getPlam2() {
    return plam2;
  }

  public void setOt3(RichOutputText ot3) {
    this.ot3 = ot3;
  }

  public RichOutputText getOt3() {
    return ot3;
  }

  public void setS2(RichSpacer s2) {
    this.s2 = s2;
  }

  public RichSpacer getS2() {
    return s2;
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

  public void setS3(RichSpacer s3) {
    this.s3 = s3;
  }

  public RichSpacer getS3() {
    return s3;
  }

  public void setIt2(RichInputText it2) {
    this.it2 = it2;
  }

  public RichInputText getIt2() {
    return it2;
  }

  public void setS4(RichSpacer s4) {
    this.s4 = s4;
  }

  public RichSpacer getS4() {
    return s4;
  }

  public void setPgl2(RichPanelGroupLayout pgl2) {
    this.pgl2 = pgl2;
  }

  public RichPanelGroupLayout getPgl2() {
    return pgl2;
  }

  public void setS5(RichSpacer s5) {
    this.s5 = s5;
  }

  public RichSpacer getS5() {
    return s5;
  }

  public void setCb3(RichCommandButton cb3) {
    this.cb3 = cb3;
  }

  public RichCommandButton getCb3() {
    return cb3;
  }

  public void setS6(RichSpacer s6) {
    this.s6 = s6;
  }

  public RichSpacer getS6() {
    return s6;
  }

  public void setCb4(RichCommandButton cb4) {
    this.cb4 = cb4;
  }

  public RichCommandButton getCb4() {
    return cb4;
  }

  public void setPfl2(RichPanelFormLayout pfl2) {
    this.pfl2 = pfl2;
  }

  public RichPanelFormLayout getPfl2() {
    return pfl2;
  }

  public void setCb1(RichCommandButton cb1) {
    this.cb1 = cb1;
  }

  public RichCommandButton getCb1() {
    return cb1;
  }


  public void setCl1(RichCommandLink cl1) {
    this.cl1 = cl1;
  }

  public RichCommandLink getCl1() {
    return cl1;
  }


  public void setS1(RichSpacer s1) {
    this.s1 = s1;
  }

  public RichSpacer getS1() {
    return s1;
  }

  public void setS8(RichSpacer s8) {
    this.s8 = s8;
  }

  public RichSpacer getS8() {
    return s8;
  }
}
