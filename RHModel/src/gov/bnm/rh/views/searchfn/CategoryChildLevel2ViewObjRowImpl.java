package gov.bnm.rh.views.searchfn;

import gov.bnm.rh.entities.CategoriesImpl;

import java.math.BigDecimal;

import java.sql.Timestamp;

import oracle.jbo.RowIterator;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed May 07 13:38:21 SGT 2014
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class CategoryChildLevel2ViewObjRowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        CategoryDescription {
            public Object get(CategoryChildLevel2ViewObjRowImpl obj) {
                return obj.getCategoryDescription();
            }

            public void put(CategoryChildLevel2ViewObjRowImpl obj,
                            Object value) {
                obj.setCategoryDescription((String)value);
            }
        }
        ,
        CategoryID {
            public Object get(CategoryChildLevel2ViewObjRowImpl obj) {
                return obj.getCategoryID();
            }

            public void put(CategoryChildLevel2ViewObjRowImpl obj,
                            Object value) {
                obj.setCategoryID((BigDecimal)value);
            }
        }
        ,
        CategoryName {
            public Object get(CategoryChildLevel2ViewObjRowImpl obj) {
                return obj.getCategoryName();
            }

            public void put(CategoryChildLevel2ViewObjRowImpl obj,
                            Object value) {
                obj.setCategoryName((String)value);
            }
        }
        ,
        CreatedDate {
            public Object get(CategoryChildLevel2ViewObjRowImpl obj) {
                return obj.getCreatedDate();
            }

            public void put(CategoryChildLevel2ViewObjRowImpl obj,
                            Object value) {
                obj.setCreatedDate((Timestamp)value);
            }
        }
        ,
        EntryID {
            public Object get(CategoryChildLevel2ViewObjRowImpl obj) {
                return obj.getEntryID();
            }

            public void put(CategoryChildLevel2ViewObjRowImpl obj,
                            Object value) {
                obj.setEntryID((Integer)value);
            }
        }
        ,
        LastUpdated {
            public Object get(CategoryChildLevel2ViewObjRowImpl obj) {
                return obj.getLastUpdated();
            }

            public void put(CategoryChildLevel2ViewObjRowImpl obj,
                            Object value) {
                obj.setLastUpdated((Timestamp)value);
            }
        }
        ,
        ParentNodeID {
            public Object get(CategoryChildLevel2ViewObjRowImpl obj) {
                return obj.getParentNodeID();
            }

            public void put(CategoryChildLevel2ViewObjRowImpl obj,
                            Object value) {
                obj.setParentNodeID((BigDecimal)value);
            }
        }
        ,
        isActive {
            public Object get(CategoryChildLevel2ViewObjRowImpl obj) {
                return obj.getisActive();
            }

            public void put(CategoryChildLevel2ViewObjRowImpl obj,
                            Object value) {
                obj.setisActive((Boolean)value);
            }
        }
        ,
        isAllowToPublish {
            public Object get(CategoryChildLevel2ViewObjRowImpl obj) {
                return obj.getisAllowToPublish();
            }

            public void put(CategoryChildLevel2ViewObjRowImpl obj,
                            Object value) {
                obj.setisAllowToPublish((Boolean)value);
            }
        }
        ,
        PolicyCount {
            public Object get(CategoryChildLevel2ViewObjRowImpl obj) {
                return obj.getPolicyCount();
            }

            public void put(CategoryChildLevel2ViewObjRowImpl obj,
                            Object value) {
                obj.setPolicyCount((Integer)value);
            }
        }
        ,
        PolicyCount1 {
            public Object get(CategoryChildLevel2ViewObjRowImpl obj) {
                return obj.getPolicyCount1();
            }

            public void put(CategoryChildLevel2ViewObjRowImpl obj,
                            Object value) {
                obj.setPolicyCount1((Integer)value);
            }
        }
        ,
        isCheckCategory {
            public Object get(CategoryChildLevel2ViewObjRowImpl obj) {
                return obj.getisCheckCategory();
            }

            public void put(CategoryChildLevel2ViewObjRowImpl obj,
                            Object value) {
                obj.setisCheckCategory((Boolean)value);
            }
        }
        ,
        CategoryChildLevel3ViewObj {
            public Object get(CategoryChildLevel2ViewObjRowImpl obj) {
                return obj.getCategoryChildLevel3ViewObj();
            }

            public void put(CategoryChildLevel2ViewObjRowImpl obj,
                            Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(CategoryChildLevel2ViewObjRowImpl object);

        public abstract void put(CategoryChildLevel2ViewObjRowImpl object,
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


    public static final int CATEGORYDESCRIPTION = AttributesEnum.CategoryDescription.index();
    public static final int CATEGORYID = AttributesEnum.CategoryID.index();
    public static final int CATEGORYNAME = AttributesEnum.CategoryName.index();
    public static final int CREATEDDATE = AttributesEnum.CreatedDate.index();
    public static final int ENTRYID = AttributesEnum.EntryID.index();
    public static final int LASTUPDATED = AttributesEnum.LastUpdated.index();
    public static final int PARENTNODEID = AttributesEnum.ParentNodeID.index();
    public static final int ISACTIVE = AttributesEnum.isActive.index();
    public static final int ISALLOWTOPUBLISH = AttributesEnum.isAllowToPublish.index();
    public static final int POLICYCOUNT = AttributesEnum.PolicyCount.index();
    public static final int POLICYCOUNT1 = AttributesEnum.PolicyCount1.index();
    public static final int ISCHECKCATEGORY = AttributesEnum.isCheckCategory.index();
    public static final int CATEGORYCHILDLEVEL3VIEWOBJ = AttributesEnum.CategoryChildLevel3ViewObj.index();

    /**
     * This is the default constructor (do not remove).
     */
    public CategoryChildLevel2ViewObjRowImpl() {
    }

    /**
     * Gets Categories entity object.
     * @return the Categories
     */
    public CategoriesImpl getCategories() {
        return (CategoriesImpl)getEntity(0);
    }

    /**
     * Gets the attribute value for CategoryDescription using the alias name CategoryDescription.
     * @return the CategoryDescription
     */
    public String getCategoryDescription() {
        return (String)getAttributeInternal(CATEGORYDESCRIPTION);
    }

    /**
     * Sets <code>value</code> as attribute value for CategoryDescription using the alias name CategoryDescription.
     * @param value value to set the CategoryDescription
     */
    public void setCategoryDescription(String value) {
        setAttributeInternal(CATEGORYDESCRIPTION, value);
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
     * Gets the attribute value for CategoryName using the alias name CategoryName.
     * @return the CategoryName
     */
    public String getCategoryName() {
        return (String)getAttributeInternal(CATEGORYNAME);
    }

    /**
     * Sets <code>value</code> as attribute value for CategoryName using the alias name CategoryName.
     * @param value value to set the CategoryName
     */
    public void setCategoryName(String value) {
        setAttributeInternal(CATEGORYNAME, value);
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
     * Gets the attribute value for EntryID using the alias name EntryID.
     * @return the EntryID
     */
    public Integer getEntryID() {
        return (Integer)getAttributeInternal(ENTRYID);
    }

    /**
     * Sets <code>value</code> as attribute value for EntryID using the alias name EntryID.
     * @param value value to set the EntryID
     */
    public void setEntryID(Integer value) {
        setAttributeInternal(ENTRYID, value);
    }

    /**
     * Gets the attribute value for LastUpdated using the alias name LastUpdated.
     * @return the LastUpdated
     */
    public Timestamp getLastUpdated() {
        return (Timestamp)getAttributeInternal(LASTUPDATED);
    }

    /**
     * Sets <code>value</code> as attribute value for LastUpdated using the alias name LastUpdated.
     * @param value value to set the LastUpdated
     */
    public void setLastUpdated(Timestamp value) {
        setAttributeInternal(LASTUPDATED, value);
    }

    /**
     * Gets the attribute value for ParentNodeID using the alias name ParentNodeID.
     * @return the ParentNodeID
     */
    public BigDecimal getParentNodeID() {
        return (BigDecimal)getAttributeInternal(PARENTNODEID);
    }

    /**
     * Sets <code>value</code> as attribute value for ParentNodeID using the alias name ParentNodeID.
     * @param value value to set the ParentNodeID
     */
    public void setParentNodeID(BigDecimal value) {
        setAttributeInternal(PARENTNODEID, value);
    }


    /**
     * Gets the attribute value for PolicyCount using the alias name PolicyCount.
     * @return the PolicyCount
     */
    public Integer getPolicyCount() {
        return (Integer) getAttributeInternal(POLICYCOUNT);
    }

    /**
     * Sets <code>value</code> as attribute value for PolicyCount using the alias name PolicyCount.
     * @param value value to set the PolicyCount
     */
    public void setPolicyCount(Integer value) {
        setAttributeInternal(POLICYCOUNT, value);
    }

    /**
     * Gets the attribute value for PolicyCount using the alias name PolicyCount1.
     * @return the PolicyCount
     */
    public Integer getPolicyCount1() {
        return (Integer) getAttributeInternal(POLICYCOUNT1);
    }

    /**
     * Sets <code>value</code> as attribute value for PolicyCount using the alias name PolicyCount1.
     * @param value value to set the PolicyCount
     */
    public void setPolicyCount1(Integer value) {
        setAttributeInternal(POLICYCOUNT1, value);
    }

    /**
     * Gets the attribute value for isActive using the alias name isActive.
     * @return the isActive
     */
    public Boolean getisActive() {
        return (Boolean)getAttributeInternal(ISACTIVE);
    }

    /**
     * Sets <code>value</code> as attribute value for isActive using the alias name isActive.
     * @param value value to set the isActive
     */
    public void setisActive(Boolean value) {
        setAttributeInternal(ISACTIVE, value);
    }

    /**
     * Gets the attribute value for isAllowToPublish using the alias name isAllowToPublish.
     * @return the isAllowToPublish
     */
    public Boolean getisAllowToPublish() {
        return (Boolean)getAttributeInternal(ISALLOWTOPUBLISH);
    }

    /**
     * Sets <code>value</code> as attribute value for isAllowToPublish using the alias name isAllowToPublish.
     * @param value value to set the isAllowToPublish
     */
    public void setisAllowToPublish(Boolean value) {
        setAttributeInternal(ISALLOWTOPUBLISH, value);
    }


    /**
     * Gets the attribute value for IS_CHECK_CATEGORY using the alias name isCheckCategory.
     * @return the IS_CHECK_CATEGORY
     */
    public Boolean getisCheckCategory() {
        return (Boolean)getAttributeInternal(ISCHECKCATEGORY);
    }

    /**
     * Sets <code>value</code> as attribute value for IS_CHECK_CATEGORY using the alias name isCheckCategory.
     * @param value value to set the IS_CHECK_CATEGORY
     */
    public void setisCheckCategory(Boolean value) {
        setAttributeInternal(ISCHECKCATEGORY, value);
    }

    /**
     * Gets the associated <code>RowIterator</code> using master-detail link CategoryChildLevel3ViewObj.
     */
    public RowIterator getCategoryChildLevel3ViewObj() {
        return (RowIterator)getAttributeInternal(CATEGORYCHILDLEVEL3VIEWOBJ);
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
        if ((index >= AttributesEnum.firstIndex()) && (index < AttributesEnum.count())) {
            return AttributesEnum.staticValues()[index - AttributesEnum.firstIndex()].get(this);
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
        if ((index >= AttributesEnum.firstIndex()) && (index < AttributesEnum.count())) {
            AttributesEnum.staticValues()[index - AttributesEnum.firstIndex()].put(this, value);
            return;
        }
        super.setAttrInvokeAccessor(index, value, attrDef);
    }
}
