package gov.bnm.rh.views.searchfn;

import gov.bnm.rh.entities.PolicycategoriespartitionImpl;

import java.math.BigDecimal;

import java.sql.Timestamp;

import oracle.jbo.Row;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Tue Apr 29 17:39:18 SGT 2014
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class PolicyPartitionCompViewObjRowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        CategoryID {
            public Object get(PolicyPartitionCompViewObjRowImpl obj) {
                return obj.getCategoryID();
            }

            public void put(PolicyPartitionCompViewObjRowImpl obj,
                            Object value) {
                obj.setCategoryID((BigDecimal)value);
            }
        }
        ,
        itemId {
            public Object get(PolicyPartitionCompViewObjRowImpl obj) {
                return obj.getitemId();
            }

            public void put(PolicyPartitionCompViewObjRowImpl obj,
                            Object value) {
                obj.setitemId((String)value);
            }
        }
        ,
        NewIssuanceDate {
            public Object get(PolicyPartitionCompViewObjRowImpl obj) {
                return obj.getNewIssuanceDate();
            }

            public void put(PolicyPartitionCompViewObjRowImpl obj,
                            Object value) {
                obj.setNewIssuanceDate((Timestamp)value);
            }
        }
        ,
        GuidelineTitle {
            public Object get(PolicyPartitionCompViewObjRowImpl obj) {
                return obj.getGuidelineTitle();
            }

            public void put(PolicyPartitionCompViewObjRowImpl obj,
                            Object value) {
                obj.setGuidelineTitle((String)value);
            }
        }
        ,
        Sectors {
            public Object get(PolicyPartitionCompViewObjRowImpl obj) {
                return obj.getSectors();
            }

            public void put(PolicyPartitionCompViewObjRowImpl obj,
                            Object value) {
                obj.setSectors((String)value);
            }
        }
        ,
        AttachmentId {
            public Object get(PolicyPartitionCompViewObjRowImpl obj) {
                return obj.getAttachmentId();
            }

            public void put(PolicyPartitionCompViewObjRowImpl obj,
                            Object value) {
                obj.setAttachmentId((String)value);
            }
        }
        ,
        IssuringDepartment {
            public Object get(PolicyPartitionCompViewObjRowImpl obj) {
                return obj.getIssuringDepartment();
            }

            public void put(PolicyPartitionCompViewObjRowImpl obj,
                            Object value) {
                obj.setIssuringDepartment((String)value);
            }
        }
        ,
        NewEffectiveDate {
            public Object get(PolicyPartitionCompViewObjRowImpl obj) {
                return obj.getNewEffectiveDate();
            }

            public void put(PolicyPartitionCompViewObjRowImpl obj,
                            Object value) {
                obj.setNewEffectiveDate((String)value);
            }
        }
        ,
        RelavantAct {
            public Object get(PolicyPartitionCompViewObjRowImpl obj) {
                return obj.getRelavantAct();
            }

            public void put(PolicyPartitionCompViewObjRowImpl obj,
                            Object value) {
                obj.setRelavantAct((String)value);
            }
        }
        ,
        PolicyView {
            public Object get(PolicyPartitionCompViewObjRowImpl obj) {
                return obj.getPolicyView();
            }

            public void put(PolicyPartitionCompViewObjRowImpl obj,
                            Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(PolicyPartitionCompViewObjRowImpl object);

        public abstract void put(PolicyPartitionCompViewObjRowImpl object,
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


    public static final int CATEGORYID = AttributesEnum.CategoryID.index();
    public static final int ITEMID = AttributesEnum.itemId.index();
    public static final int NEWISSUANCEDATE = AttributesEnum.NewIssuanceDate.index();
    public static final int GUIDELINETITLE = AttributesEnum.GuidelineTitle.index();
    public static final int SECTORS = AttributesEnum.Sectors.index();
    public static final int ATTACHMENTID = AttributesEnum.AttachmentId.index();
    public static final int ISSURINGDEPARTMENT = AttributesEnum.IssuringDepartment.index();
    public static final int NEWEFFECTIVEDATE = AttributesEnum.NewEffectiveDate.index();
    public static final int RELAVANTACT = AttributesEnum.RelavantAct.index();
    public static final int POLICYVIEW = AttributesEnum.PolicyView.index();

    /**
     * This is the default constructor (do not remove).
     */
    public PolicyPartitionCompViewObjRowImpl() {
    }

    /**
   * Gets Policycategoriespartition entity object.
   * @return the Policycategoriespartition
   */
  public PolicycategoriespartitionImpl getPolicycategoriespartition() {
    return (PolicycategoriespartitionImpl)getEntity(0);
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
     * Gets the attribute value for itemId using the alias name itemId.
     * @return the itemId
     */
    public String getitemId() {
        return (String)getAttributeInternal(ITEMID);
    }

    /**
     * Sets <code>value</code> as attribute value for itemId using the alias name itemId.
     * @param value value to set the itemId
     */
    public void setitemId(String value) {
        setAttributeInternal(ITEMID, value);
    }

  /**
   * Gets the attribute value for the calculated attribute NewIssuanceDate.
   * @return the NewIssuanceDate
   */
  public Timestamp getNewIssuanceDate() {
    return (Timestamp) getAttributeInternal(NEWISSUANCEDATE);
  }

  /**
   * Sets <code>value</code> as the attribute value for the calculated attribute NewIssuanceDate.
   * @param value value to set the  NewIssuanceDate
   */
  public void setNewIssuanceDate(Timestamp value) {
    setAttributeInternal(NEWISSUANCEDATE, value);
  }

  /**
   * Gets the attribute value for the calculated attribute GuidelineTitle.
   * @return the GuidelineTitle
   */
  public String getGuidelineTitle() {
    return (String) getAttributeInternal(GUIDELINETITLE);
  }

  /**
   * Sets <code>value</code> as the attribute value for the calculated attribute GuidelineTitle.
   * @param value value to set the  GuidelineTitle
   */
  public void setGuidelineTitle(String value) {
    setAttributeInternal(GUIDELINETITLE, value);
  }

  /**
   * Gets the attribute value for the calculated attribute Sectors.
   * @return the Sectors
   */
  public String getSectors() {
    return (String) getAttributeInternal(SECTORS);
  }

  /**
   * Sets <code>value</code> as the attribute value for the calculated attribute Sectors.
   * @param value value to set the  Sectors
   */
  public void setSectors(String value) {
    setAttributeInternal(SECTORS, value);
  }


    /**
     * Gets the attribute value for the calculated attribute AttachmentId.
     * @return the AttachmentId
     */
    public String getAttachmentId() {
        return (String) getAttributeInternal(ATTACHMENTID);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute AttachmentId.
     * @param value value to set the  AttachmentId
     */
    public void setAttachmentId(String value) {
        setAttributeInternal(ATTACHMENTID, value);
    }

    /**
     * Gets the attribute value for the calculated attribute IssuringDepartment.
     * @return the IssuringDepartment
     */
    public String getIssuringDepartment() {
        return (String) getAttributeInternal(ISSURINGDEPARTMENT);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute IssuringDepartment.
     * @param value value to set the  IssuringDepartment
     */
    public void setIssuringDepartment(String value) {
        setAttributeInternal(ISSURINGDEPARTMENT, value);
    }

    /**
     * Gets the attribute value for the calculated attribute NewEffectiveDate.
     * @return the NewEffectiveDate
     */
    public String getNewEffectiveDate() {
        return (String) getAttributeInternal(NEWEFFECTIVEDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute NewEffectiveDate.
     * @param value value to set the  NewEffectiveDate
     */
    public void setNewEffectiveDate(String value) {
        setAttributeInternal(NEWEFFECTIVEDATE, value);
    }

    /**
     * Gets the attribute value for the calculated attribute RelavantAct.
     * @return the RelavantAct
     */
    public String getRelavantAct() {
        return (String) getAttributeInternal(RELAVANTACT);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute RelavantAct.
     * @param value value to set the  RelavantAct
     */
    public void setRelavantAct(String value) {
        setAttributeInternal(RELAVANTACT, value);
    }

    /**
     * Gets the associated <code>Row</code> using master-detail link PolicyView.
     */
    public Row getPolicyView() {
        return (Row)getAttributeInternal(POLICYVIEW);
    }

    /**
     * Sets the master-detail link PolicyView between this object and <code>value</code>.
     */
    public void setPolicyView(Row value) {
        setAttributeInternal(POLICYVIEW, value);
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