package gov.bnm.view.rh.common;

import gov.bnm.view.rh.utils.BaseUtil;
import gov.bnm.view.rh.utils.JSFUtils;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;

import javax.faces.FacesException;
import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItems;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.data.RichColumn;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.nav.RichCommandLink;
import oracle.adf.view.rich.component.rich.nav.RichGoLink;
import oracle.adf.view.rich.component.rich.output.RichSpacer;

import oracle.jbo.uicli.binding.JUCtrlHierNodeBinding;

import org.apache.myfaces.trinidad.component.UIXIterator;
import org.apache.myfaces.trinidad.component.UIXSwitcher;
import org.apache.myfaces.trinidad.component.UIXValue;
import org.apache.myfaces.trinidad.model.CollectionModel;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;

public class ExcelBean {

    public void exportToExcel(FacesContext facesContext,
                              OutputStream os) throws IOException,
                                                      NoSuchMethodException,
                                                      IllegalAccessException,
                                                      InvocationTargetException {
        // get exporter attributes from viewScope (these values will define the behavior of exporter)
        Map<String, Object> vs = ADFContext.getCurrent().getViewScope();
        String exportedId = (String)vs.get("exporter.exportedId");
        String thStyle = (String)vs.get("exporter.thStyle");
        String tdStyle = (String)vs.get("exporter.tdStyle");
        String footerStyle = (String)vs.get("exporter.footerStyle");
        boolean showHiddenCols =
            "true".equals(vs.get("exporter.showHiddenColumns"));
        boolean forceColWidth =
            "true".equals(vs.get("exporter.forceColumnWidth"));
        boolean hideFooter = "true".equals(vs.get("exporter.hideFooter"));
        boolean hasFooter = false;
        int maxRowSpan = 1;

        // get the table from absoulte path

        RichTable table = (RichTable)JSFUtils.findComponentInRoot(exportedId);
        // store visible columns in a sorted set (using the property displayIndex)
        TreeSet<RichColumn> cols =
            new TreeSet<RichColumn>(new RichColumnComparator());
        for (UIComponent c : table.getChildren()) {
            if (c instanceof RichColumn) {
                RichColumn col = (RichColumn)c;
                boolean forceRenderedCol =
                    "true".equals(col.getAttributes().get("exporter.forceRendered"));
                boolean renderedCol =
                    !"false".equals(col.getAttributes().get("exporter.rendered"));
                if (forceRenderedCol ||
                    (renderedCol && (showHiddenCols || (col.isRendered() &&
                                                        col.isVisible())))) {
                    cols.add(col);
                    if (col.getFooter() != null)
                        hasFooter = true;
                    maxRowSpan = Math.max(maxRowSpan, getRowSpan(col));
                }
            }
        }
        OutputStreamWriter w = new OutputStreamWriter(os);
        w.append("<table>");
        for (int i = 1; i <= maxRowSpan; i++) {
            w.append("<tr>");
            for (RichColumn col : cols)
                renderHeader(facesContext, w, col, thStyle, forceColWidth,
                             maxRowSpan, i, 1);
            w.append("</tr>");
        }

        ELContext elContext = facesContext.getELContext();
        ExpressionFactory expressionFactory =
            facesContext.getApplication().getExpressionFactory();
        if (StringUtils.isNotBlank(table.getVarStatus())) {
            String el = String.format("#{%s}", table.getVarStatus());
            ValueExpression exp =
                expressionFactory.createValueExpression(elContext, el,
                                                        Object.class);
            Method m =
                UIXIterator.class.getDeclaredMethod("createVarStatusMap",
                                                    new Class[0]);
            m.setAccessible(true);
            Object varStatus = m.invoke(table, new Object[0]);
            exp.setValue(elContext, varStatus);
        }

        CollectionModel model = (CollectionModel)table.getValue();
        int rowcount = model.getRowCount();
        for (int i = 0; i < rowcount; i++) {
            model.setRowIndex(i);
            JUCtrlHierNodeBinding r =
                (JUCtrlHierNodeBinding)model.getRowData();
            if (StringUtils.isNotBlank(table.getVar())) {
                String el = String.format("#{%s}", table.getVar());
                ValueExpression exp =
                    expressionFactory.createValueExpression(elContext, el,
                                                            Object.class);
                exp.setValue(elContext, r);
            }
            w.append("<tr>");
            for (RichColumn col : cols)
                renderRows(facesContext, w, col, tdStyle, forceColWidth);
            w.append("</tr>");
        }

        if (!hideFooter && hasFooter) {
            w.append("<tr>");
            for (RichColumn col : cols)
                renderFooter(facesContext, w, col, footerStyle, forceColWidth);
            w.append("</tr>");
        }

        w.append("</table>");
        w.close();
    }

    private void renderUIComponent(FacesContext facesContext,
                                   OutputStreamWriter w,
                                   UIComponent c) throws IOException {
        if ("true".equals(c.getAttributes().get("exporter.hidden")))
            return;
        for (UIComponent ch : c.getChildren())
            renderUIComponent(facesContext, w, ch);
        String translatorAttr =
            (String)c.getAttributes().get("exporter.translator");
        String[] translatorItems =
            StringUtils.isEmpty(translatorAttr) ? new String[0] :
            translatorAttr.split(";;");
        Map<String, String> translator =
            new HashMap<String, String>(translatorItems.length);
        for (String item : translatorItems) {
            String[] kv = item.split("::");
            if (kv.length == 0)
                continue;
            if (kv.length != 2)
                throw new FacesException("kv.length != 2");
            translator.put(kv[0], kv[1]);
        }

        // get both contentStyle and inlineStyle properties (if applicable)
        StringBuilder style = new StringBuilder();
        ValueExpression contentStyleVE = c.getValueExpression("contentStyle");
        if (contentStyleVE != null)
            style.append(StringUtils.defaultString((String)contentStyleVE.getValue(facesContext.getELContext())));
        else if (SafeReflection.hasMethod(c, "getContentStyle", null))
            style.append(StringUtils.defaultString((String)SafeReflection.invoke(c,
                                                                                 "getContentStyle",
                                                                                 null,
                                                                                 null)));
        ValueExpression inlineStyleVE = c.getValueExpression("inlineStyle");
        if (inlineStyleVE != null)
            style.append(StringUtils.defaultString((String)inlineStyleVE.getValue(facesContext.getELContext())));
        else if (SafeReflection.hasMethod(c, "getInlineStyle", null))
            style.append(StringUtils.defaultString((String)SafeReflection.invoke(c,
                                                                                 "getInlineStyle",
                                                                                 null,
                                                                                 null)));
        if (style.length() > 0)
            w.append(String.format("<span style='%s'>", style.toString()));

        if (c instanceof UIXSwitcher) {
            UIXSwitcher swt = (UIXSwitcher)c;
            renderUIComponent(facesContext, w,
                              swt.getFacet(swt.getFacetName()));
        } else if (c instanceof RichSelectOneChoice) {
            RichSelectOneChoice soc = (RichSelectOneChoice)c;
            Integer index = (Integer)soc.getValue();
            List<SelectItem> items = new ArrayList<SelectItem>();
            for (UIComponent ch : soc.getChildren())
                if (ch instanceof UISelectItems)
                    items.addAll((List<SelectItem>)((UISelectItems)ch).getValue());
            if (items.size() > 0) {
                String val = items.get(index).getLabel();
                w.append(StringEscapeUtils.escapeHtml(translator.containsKey(index) ?
                                                      translator.get(val) :
                                                      val));
            }
        } else if (c instanceof UIXValue) {
            UIXValue uix = (UIXValue)c;
            Object value = uix.getValue();
            String val = value != null ? value.toString() : null;
            System.out.println("uix.getId()::" + uix.getId());
            if (uix.getId().equals("ot56")) {
                val = "";
            }
            if (uix.getId().equals("ot55")) {
                val = "";
            }
            if (uix.getId().equals("ot60")) {
                String[] splitVal = val.split(",");
                int years = BaseUtil.getInt(splitVal[0]);
                int months = BaseUtil.getInt(splitVal[1]);
                int days = BaseUtil.getInt(splitVal[2]);
                if (days >= 0 && days <= 31) {
                    val = days + " Days";
                } else if (days >= -31 && days < 0) {
                    val = "( " + Math.abs(days) + " Days )";
                } else if (days < -31) {
                    val =
"( " + Math.abs(years) + " Years " + Math.abs(months) + " Months )";
                } else {
                    val = years + " Years " + months + " Months";
                }
            }
            if (uix.getId().equals("of10")) {
                val = val.replaceAll("\\<.*?\\>", "");
            }
            if (uix.getConverter() != null)
                val = uix.getConverter().getAsString(facesContext, c, value);
            if (val != null)
                w.append(StringEscapeUtils.escapeHtml(translator.containsKey(val) ?
                                                      translator.get(val) :
                                                      val));
        } else if (c instanceof RichCommandLink) {
            RichCommandLink commandLink = (RichCommandLink)c;
            if (commandLink.getText() != null)
                w.append(StringEscapeUtils.escapeHtml(translator.containsKey(commandLink.getText()) ?
                                                      translator.get(commandLink.getText()) :
                                                      commandLink.getText()));
        } else if (c instanceof RichGoLink) {
            RichGoLink goLink = (RichGoLink)c;
            if (goLink.getText() != null)
                w.append(String.format("<a href='%s'>%s</a>",
                                       goLink.getDestination(),
                                       StringEscapeUtils.escapeHtml(translator.containsKey(goLink.getText()) ?
                                                                    translator.get(goLink.getText()) :
                                                                    goLink.getText())));
        } else if (c instanceof RichSpacer)
            w.append("&nbsp;");
        if (style.length() > 0)
            w.append("</span>");
    }

    private void renderHeader(FacesContext facesContext, OutputStreamWriter w,
                              RichColumn col, String thStyle,
                              boolean forceColWidth, int maxRowSpan, int level,
                              int currentLevel) throws IOException {
        if (currentLevel < level) {
            for (UIComponent c : col.getChildren())
                if (c instanceof RichColumn)
                    renderHeader(facesContext, w, (RichColumn)c, thStyle,
                                 forceColWidth, maxRowSpan, level,
                                 currentLevel + 1);
            return;
        }

        ValueExpression alignVE = col.getValueExpression("align");
        String align =
            alignVE != null ? (String)alignVE.getValue(facesContext.getELContext()) :
            col.getAlign();
        ValueExpression widthVE = col.getValueExpression("width");
        String width =
            widthVE != null ? (String)widthVE.getValue(facesContext.getELContext()) :
            col.getWidth();

        w.append("<th");
        int rowSpan = maxRowSpan - Math.abs(getRowSpan(col) - level);
        if (rowSpan > 1)
            w.append(String.format(" rowspan='%s'", rowSpan));
        int colSpan = getColSpan(col);
        if (colSpan > 1)
            w.append(String.format(" colspan='%s'", colSpan));
        if (StringUtils.isNotBlank(thStyle))
            w.append(String.format(" style='%s'", thStyle));
        w.append(String.format(" align='%s'",
                               StringUtils.defaultString(align, "left")));
        if (forceColWidth && StringUtils.isNotBlank(width))
            w.append(String.format(" width='%s'", width));
        if (col.isHeaderNoWrap())
            w.append(" nowrap");
        w.append(">");
        w.append(StringUtils.defaultString(StringEscapeUtils.escapeHtml(col.getHeaderText())));
        w.append("</th>");
    }

    private void renderRows(FacesContext facesContext, OutputStreamWriter w,
                            RichColumn col, String tdStyle,
                            boolean forceColWidth) throws IOException {
        // if is a group of columns -> write its contained columns
        boolean isColumnGroup = false;
        for (UIComponent c : col.getChildren()) {
            if (c instanceof RichColumn) {
                renderRows(facesContext, w, (RichColumn)c, tdStyle,
                           forceColWidth);
                isColumnGroup = true;
            }
        }
        if (isColumnGroup)
            return;

        // if is not a group of columns -> write its components
        ValueExpression inlineStyleVE = col.getValueExpression("inlineStyle");
        String style =
            inlineStyleVE != null ? (String)inlineStyleVE.getValue(facesContext.getELContext()) :
            col.getInlineStyle();
        ValueExpression alignVE = col.getValueExpression("align");
        String align =
            alignVE != null ? (String)alignVE.getValue(facesContext.getELContext()) :
            col.getAlign();
        ValueExpression widthVE = col.getValueExpression("width");
        String width =
            widthVE != null ? (String)widthVE.getValue(facesContext.getELContext()) :
            col.getWidth();
        w.append("<td");
        if (StringUtils.isNotBlank(tdStyle) || StringUtils.isNotBlank(style))
            w.append(String.format(" style='%s;%s'",
                                   StringUtils.defaultString(tdStyle),
                                   StringUtils.defaultString(style)));
        if (StringUtils.isNotBlank(align))
            w.append(String.format(" align='%s'",
                                   StringUtils.defaultString(align)));
        if (forceColWidth && StringUtils.isNotBlank(width))
            w.append(String.format(" width='%s'", width));
        if (col.isNoWrap())
            w.append(" nowrap");
        w.append(">");
        for (UIComponent c : col.getChildren())
            renderUIComponent(facesContext, w, c);
        w.append("</td>");
    }

    private void renderFooter(FacesContext facesContext, OutputStreamWriter w,
                              RichColumn col, String footerStyle,
                              boolean forceColWidth) throws IOException {
        for (UIComponent c : col.getChildren()) {
            if (c instanceof RichColumn) {
                renderFooter(facesContext, w, (RichColumn)c, footerStyle,
                             forceColWidth);
                continue;
            }
            w.append("<td");
            if (StringUtils.isNotBlank(footerStyle))
                w.append(String.format(" style='%s'", footerStyle));
            w.append(String.format(" align='%s'",
                                   StringUtils.defaultString(col.getAlign(),
                                                             "left")));
            if (col.isHeaderNoWrap())
                w.append(" nowrap");
            w.append(">");
            if (col.getFooter() != null)
                renderUIComponent(facesContext, w, col.getFooter());
            w.append("</td>");
        }
    }

    private int getRowSpan(RichColumn col) {
        int rowSpan = 1;
        for (UIComponent c : col.getChildren())
            if (c instanceof RichColumn)
                rowSpan = Math.max(rowSpan, 1 + getRowSpan((RichColumn)c));
        return rowSpan;
    }

    private int getColSpan(RichColumn col) {
        int colSpan = 0;
        for (UIComponent c : col.getChildren())
            if (c instanceof RichColumn)
                colSpan += getColSpan((RichColumn)c);
        return Math.max(1, colSpan);
    }

    class RichColumnComparator implements Comparator {
        int direction;

        public RichColumnComparator() {
            direction = 1;
        }

        public RichColumnComparator(boolean asc) {
            direction = asc ? 1 : -1;
        }

        public int compare(Object o1, Object o2) {
            RichColumn c1 = (RichColumn)o1;
            RichColumn c2 = (RichColumn)o2;
            return direction *
                (c1.getDisplayIndex() < c2.getDisplayIndex() ? -1 : 1);
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }
    }
}
