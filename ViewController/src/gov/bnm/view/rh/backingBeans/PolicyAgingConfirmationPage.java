package gov.bnm.view.rh.backingBeans;

import gov.bnm.rh.views.PolicyViewRowImpl;

import gov.bnm.view.rh.constant.Constants;
import gov.bnm.view.rh.utils.ADFUtils;

import gov.bnm.view.rh.utils.BaseUtil;
import gov.bnm.view.rh.utils.DateUtils;

import gov.bnm.view.rh.utils.JSFUtils;

import java.sql.Timestamp;

import java.text.ParseException;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.RichDocument;
import oracle.adf.view.rich.component.rich.RichForm;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectItem;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelStretchLayout;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.component.rich.output.RichOutputFormatted;
import oracle.adf.view.rich.component.rich.output.RichOutputText;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import org.apache.log4j.Logger;

public class PolicyAgingConfirmationPage {

  static Logger log = Logger.getLogger(PolicyAgingConfirmationPage.class);
  private RichForm f1;
  private RichDocument d1;
  private RichPanelStretchLayout psl1;
  private RichOutputText ot1;
  private RichPanelGroupLayout pgl1;
  private RichOutputFormatted of1;
  private RichSelectOneChoice soc1;
  private RichSelectItem si1;
  private RichSelectItem si2;
  private RichSelectItem si3;
  private RichSelectItem si4;
  private RichSelectItem si5;
  private RichPanelGroupLayout pgl2;
  private RichCommandButton cb1;
  private RichCommandButton cb2;
  private RichInputText it1;

  public void setF1(RichForm f1) {
    this.f1 = f1;
  }

  public RichForm getF1() {
    return f1;
  }

  public void setD1(RichDocument d1) {
    this.d1 = d1;
  }

  public RichDocument getD1() {
    return d1;
  }

  public void setPsl1(RichPanelStretchLayout psl1) {
    this.psl1 = psl1;
  }

  public RichPanelStretchLayout getPsl1() {
    return psl1;
  }

  public void setOt1(RichOutputText ot1) {
    this.ot1 = ot1;
  }

  public RichOutputText getOt1() {
    return ot1;
  }


  public void setPgl1(RichPanelGroupLayout pgl1) {
    this.pgl1 = pgl1;
  }

  public RichPanelGroupLayout getPgl1() {
    return pgl1;
  }

  public void setOf1(RichOutputFormatted of1) {
    this.of1 = of1;
  }

  public RichOutputFormatted getOf1() {
    return of1;
  }

  public void setSoc1(RichSelectOneChoice soc1) {
    this.soc1 = soc1;
  }

  public RichSelectOneChoice getSoc1() {
    return soc1;
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

  public String confirmAging() {

    DCIteratorBinding policyIterator =
      ADFUtils.findIterator("PolicyView1Iterator");
    PolicyViewRowImpl rowPolicy =
      (PolicyViewRowImpl)policyIterator.getCurrentRow();
    rowPolicy.getNewIssuanceDate();
    int extendYears = BaseUtil.getInt(this.getSoc1().getValue());
    log.info("getSoc1::" + extendYears);
    try {
      Timestamp newIssuanceDate =
        DateUtils.getDateAfterAddYear(rowPolicy.getNewIssuanceDate(),
                                      extendYears);
      rowPolicy.setNewIssuanceDate(newIssuanceDate);
    } catch (ParseException e) {
      log.error("ParseException::" + e.getMessage());
      return null;
    }
    BindingContainer bindings = ADFUtils.getBindingContainer();
    OperationBinding operationBinding = bindings.getOperationBinding("Commit");
    Object result = operationBinding.execute();
    if (!operationBinding.getErrors().isEmpty()) {
      ADFUtils.showInfoMessage("Error on Data Save ");
      log.error(operationBinding.getErrors());
      return null;
    } else {
      if (extendYears == 0) {
        ADFUtils.showInfoMessage(Constants.NO_REVIEW);
      } else {
        ADFUtils.showInfoMessage(Constants.POLICY_EXTEND_SUCCESSFULLY);
      }
      return "submit";
    }


  }

  public String closePage() {
    JSFUtils.closeWindow();
    return null;
  }

  public void setIt1(RichInputText it1) {
    this.it1 = it1;
  }

  public RichInputText getIt1() {
    return it1;
  }


}
