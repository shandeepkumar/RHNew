package view.backing.jsff;

import gov.bnm.view.rh.utils.JSFUtils;

import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelStretchLayout;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.component.rich.output.RichOutputText;

public class PolicyAgingConfirmationSubmitPage {
  private RichPanelStretchLayout psl1;
  private RichOutputText ot1;
  private RichPanelGroupLayout pgl1;
  private RichCommandButton cb1;

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

  public void setCb1(RichCommandButton cb1) {
    this.cb1 = cb1;
  }

  public RichCommandButton getCb1() {
    return cb1;
  }
}
