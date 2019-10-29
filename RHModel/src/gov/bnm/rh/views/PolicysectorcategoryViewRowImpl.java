package gov.bnm.rh.views;

import java.math.BigDecimal;

import java.sql.Timestamp;

import oracle.jbo.Row;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Fri Mar 14 04:01:21 GMT 2014
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class PolicysectorcategoryViewRowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        PolicyID {
            public Object get(PolicysectorcategoryViewRowImpl obj) {
                return obj.getPolicyID();
            }

            public void put(PolicysectorcategoryViewRowImpl obj,
                            Object value) {
                obj.setPolicyID((String)value);
            }
        },
        SectorID {
            public Object get(PolicysectorcategoryViewRowImpl obj) {
                return obj.getSectorID();
            }

            public void put(PolicysectorcategoryViewRowImpl obj,
                            Object value) {
                obj.setSectorID((BigDecimal)value);
            }
        },
        CategoryID {
            public Object get(PolicysectorcategoryViewRowImpl obj) {
                return obj.getCategoryID();
            }

            public void put(PolicysectorcategoryViewRowImpl obj,
                            Object value) {
                obj.setCategoryID((BigDecimal)value);
            }
        },
        CreatedDate {
            public Object get(PolicysectorcategoryViewRowImpl obj) {
                return obj.getCreatedDate();
            }

            public void put(PolicysectorcategoryViewRowImpl obj,
                            Object value) {
                obj.setCreatedDate((Timestamp)value);
            }
        },
        CategorieName {
            public Object get(PolicysectorcategoryViewRowImpl obj) {
                return obj.getCategorieName();
            }

            public void put(PolicysectorcategoryViewRowImpl obj,
                            Object value) {
                obj.setCategorieName((String)value);
            }
        },
        CategoriesView {
            public Object get(PolicysectorcategoryViewRowImpl obj) {
                return obj.getCategoriesView();
            }

            public void put(PolicysectorcategoryViewRowImpl obj,
                            Object value) {
                obj.setAttributeInternal(index(), value);
            }
        };
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(PolicysectorcategoryViewRowImpl object);

        public abstract void put(PolicysectorcategoryViewRowImpl object,
                                 Object value);

        public int index() {
            return AttributesEnum.firstIndex() + ordinal();
        }

        public static final int firstIndex() {
            return firstIndex;
        }

        public static int count() {
            return AttributesEnum.firstIndex() +
                AttributesEnum.staticValues().length;
        }

        public static final AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = AttributesEnum.values();
            }
            return vals;
        }
    }
    public static final int POLICYID = AttributesEnum.PolicyID.index();
    public static final int SECTORID = AttributesEnum.SectorID.index();
    public static final int CATEGORYID = AttributesEnum.CategoryID.index();
    public static final int CREATEDDATE = AttributesEnum.CreatedDate.index();
    public static final int CATEGORIENAME =
        AttributesEnum.CategorieName.index();
    public static final int CATEGORIESVIEW =
        AttributesEnum.CategoriesView.index();

    /**
     * This is the default constructor (do not remove).
     */
    public PolicysectorcategoryViewRowImpl() {
    }

    /**
     * Gets Policysectorcategory entity object.
     * @return the Policysectorcategory
     */
    public EntityImpl getPolicysectorcategory() {
        return (EntityImpl)getEntity(0);
    }

    /**
     * Gets the attribute value for PolicyID using the alias name PolicyID.
     * @return the PolicyID
     */
    public String getPolicyID() {
        return (String)getAttributeInternal(POLICYID);
    }

    /**
     * Sets <code>value</code> as attribute value for PolicyID using the alias name PolicyID.
     * @param value value to set the PolicyID
     */
    public void setPolicyID(String value) {
        setAttributeInternal(POLICYID, value);
    }

    /**
     * Gets the attribute value for SectorID using the alias name SectorID.
     * @return the SectorID
     */
    public BigDecimal getSectorID() {
        return (BigDecimal)getAttributeInternal(SECTORID);
    }

    /**
     * Sets <code>value</code> as attribute value for SectorID using the alias name SectorID.
     * @param value value to set the SectorID
     */
    public void setSectorID(BigDecimal value) {
        setAttributeInternal(SECTORID, value);
    }

    /**
     * Gets the attribute value for CategoryID using the alias name CategoryID.
     * @return the CategoryID
     */
    public BigDecimal getCategoryID() {
        return (BigDecimal)getAttributeInternal(CATEGORYID);
    }

    /**
     * Sets <code>value</code> as attribute value for CategoryID using the alias name CategoryID.
     * @param value value to set the CategoryID
     */
    public void setCategoryID(BigDecimal value) {
        setAttributeInternal(CATEGORYID, value);
    }

    /**
     * Gets the attribute value for CreatedDate using the alias name CreatedDate.
     * @return the CreatedDate
     */
    public Timestamp getCreatedDate() {
        return (Timestamp)getAttributeInternal(CREATEDDATE);
    }

    /**
     * Sets <code>value</code> as attribute value for CreatedDate using the alias name CreatedDate.
     * @param value value to set the CreatedDate
     */
    public void setCreatedDate(Timestamp value) {
        setAttributeInternal(CREATEDDATE, value);
    }

    /**
     * Gets the attribute value for the calculated attribute CategorieName.
     * @return the CategorieName
     */
    public String getCategorieName() {
        return (String)getAttributeInternal(CATEGORIENAME);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute CategorieName.
     * @param value value to set the  CategorieName
     */
    public void setCategorieName(String value) {
        setAttributeInternal(CATEGORIENAME, value);
    }

    /**
     * Gets the associated <code>Row</code> using master-detail link CategoriesView.
     */
    public Row getCategoriesView() {
        return (Row)getAttributeInternal(CATEGORIESVIEW);
    }

    /**
     * Sets the master-detail link CategoriesView between this object and <code>value</code>.
     */
    public void setCategoriesView(Row value) {
        setAttributeInternal(CATEGORIESVIEW, value);
    }

    /**
     * getAttrInvokeAccessor: generated method. Do not modify.
     * @param index the index identifying the attribute
     * @param attrDef the attribute

     * @return the attribute value
     * @throws Exception
     */
    protected Object getAttrInvokeAccessor(int index,
                                           AttributeDefImpl attrDef) throws Exception {
        if ((index >= AttributesEnum.firstIndex()) &&
            (index < AttributesEnum.count())) {
            return AttributesEnum.staticValues()[index -
                AttributesEnum.firstIndex()].get(this);
        }
        return super.getAttrInvokeAccessor(index, attrDef);
    }

    /**
     * setAttrInvokeAccessor: generated method. Do not modify.
     * @param index the index identifying the attribute
     * @param value the value to assign to the attribute
     * @param attrDef the attribute

     * @throws Exception
     */
    protected void setAttrInvokeAccessor(int index, Object value,
                                         AttributeDefImpl attrDef) throws Exception {
        if ((index >= AttributesEnum.firstIndex()) &&
            (index < AttributesEnum.count())) {
            AttributesEnum.staticValues()[index -
                AttributesEnum.firstIndex()].put(this, value);
            return;
        }
        super.setAttrInvokeAccessor(index, value, attrDef);
    }
}