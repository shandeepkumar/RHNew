package oracle.webcenter.portalapp.override;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import oracle.adf.view.page.editor.change.ComposerChangeManager;

import oracle.adf.view.rich.component.rich.layout.RichPanelTabbed;
import oracle.adf.view.rich.component.rich.layout.RichShowDetailItem;

import org.apache.myfaces.trinidad.change.AttributeComponentChange;
import org.apache.myfaces.trinidad.change.ComponentChange;

public class PortalComposerChangeManager extends ComposerChangeManager {
    /**
     * adf-config.xml still persist in session, @see
FilteredPersistenceChangeManager
     * We don't want this for the showDetailItem in the RichPanaelAccordion.
     *
     * @param context the FacesContext.
     * @param component the UIComponent.
     * @param change the ComponentChange.
     */
    @Override
    public void addComponentChange(FacesContext context, UIComponent component,
                                   ComponentChange change) {
        if (component instanceof RichShowDetailItem &&
            ((RichShowDetailItem)component).getParent() instanceof
            RichPanelTabbed && change instanceof AttributeComponentChange &&
            "disclosed".equals(((AttributeComponentChange)change).getAttributeName())) {
            System.out.println("ComponentChange; disclosed event on showDetailItem in a RichPanelAccordion, we don¿t persist.");
            return;
        }
        super.addComponentChange(context, component, change);
    }
}

