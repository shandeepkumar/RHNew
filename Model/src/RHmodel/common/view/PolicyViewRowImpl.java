package RHmodel.common.view;

import java.sql.Timestamp;

import oracle.jbo.Row;
import oracle.jbo.RowIterator;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Tue Mar 11 04:27:41 GMT 2014
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class PolicyViewRowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        itemId {
            public Object get(PolicyViewRowImpl obj) {
                return obj.getitemId();
            }

            public void put(PolicyViewRowImpl obj, Object value) {
                obj.setitemId((String)value);
            }
        },
        policyId {
            public Object get(PolicyViewRowImpl obj) {
                return obj.getpolicyId();
            }

            public void put(PolicyViewRowImpl obj, Object value) {
                obj.setpolicyId((String)value);
            }
        },
        GuidelineTitle {
            public Object get(PolicyViewRowImpl obj) {
                return obj.getGuidelineTitle();
            }

            public void put(PolicyViewRowImpl obj, Object value) {
                obj.setGuidelineTitle((String)value);
            }
        },
        CategoryofDocument {
            public Object get(PolicyViewRowImpl obj) {
                return obj.getCategoryofDocument();
            }

            public void put(PolicyViewRowImpl obj, Object value) {
                obj.setCategoryofDocument((String)value);
            }
        },
        Applicability {
            public Object get(PolicyViewRowImpl obj) {
                return obj.getApplicability();
            }

            public void put(PolicyViewRowImpl obj, Object value) {
                obj.setApplicability((String)value);
            }
        },
        EffectiveDate {
            public Object get(PolicyViewRowImpl obj) {
                return obj.getEffectiveDate();
            }

            public void put(PolicyViewRowImpl obj, Object value) {
                obj.setEffectiveDate((String)value);
            }
        },
        IssuingDepartment {
            public Object get(PolicyViewRowImpl obj) {
                return obj.getIssuingDepartment();
            }

            public void put(PolicyViewRowImpl obj, Object value) {
                obj.setIssuingDepartment((String)value);
            }
        },
        PolicyURL {
            public Object get(PolicyViewRowImpl obj) {
                return obj.getPolicyURL();
            }

            public void put(PolicyViewRowImpl obj, Object value) {
                obj.setPolicyURL((String)value);
            }
        },
        Author {
            public Object get(PolicyViewRowImpl obj) {
                return obj.getAuthor();
            }

            public void put(PolicyViewRowImpl obj, Object value) {
                obj.setAuthor((String)value);
            }
        },
        Summary {
            public Object get(PolicyViewRowImpl obj) {
                return obj.getSummary();
            }

            public void put(PolicyViewRowImpl obj, Object value) {
                obj.setSummary((String)value);
            }
        },
        Classification {
            public Object get(PolicyViewRowImpl obj) {
                return obj.getClassification();
            }

            public void put(PolicyViewRowImpl obj, Object value) {
                obj.setClassification((String)value);
            }
        },
        ApplicabilityManualEntry {
            public Object get(PolicyViewRowImpl obj) {
                return obj.getApplicabilityManualEntry();
            }

            public void put(PolicyViewRowImpl obj, Object value) {
                obj.setApplicabilityManualEntry((String)value);
            }
        },
        DisplayInWhatsNew {
            public Object get(PolicyViewRowImpl obj) {
                return obj.getDisplayInWhatsNew();
            }

            public void put(PolicyViewRowImpl obj, Object value) {
                obj.setDisplayInWhatsNew((Boolean)value);
            }
        },
        ExpiryDate {
            public Object get(PolicyViewRowImpl obj) {
                return obj.getExpiryDate();
            }

            public void put(PolicyViewRowImpl obj, Object value) {
                obj.setExpiryDate((Timestamp)value);
            }
        },
        CreatedDate {
            public Object get(PolicyViewRowImpl obj) {
                return obj.getCreatedDate();
            }

            public void put(PolicyViewRowImpl obj, Object value) {
                obj.setCreatedDate((Timestamp)value);
            }
        },
        LastUpdated {
            public Object get(PolicyViewRowImpl obj) {
                return obj.getLastUpdated();
            }

            public void put(PolicyViewRowImpl obj, Object value) {
                obj.setLastUpdated((Timestamp)value);
            }
        },
        ownerDepartmentId {
            public Object get(PolicyViewRowImpl obj) {
                return obj.getownerDepartmentId();
            }

            public void put(PolicyViewRowImpl obj, Object value) {
                obj.setownerDepartmentId((String)value);
            }
        },
        keywords {
            public Object get(PolicyViewRowImpl obj) {
                return obj.getkeywords();
            }

            public void put(PolicyViewRowImpl obj, Object value) {
                obj.setkeywords((String)value);
            }
        },
        partitionTypeId {
            public Object get(PolicyViewRowImpl obj) {
                return obj.getpartitionTypeId();
            }

            public void put(PolicyViewRowImpl obj, Object value) {
                obj.setpartitionTypeId((Integer)value);
            }
        },
        system {
            public Object get(PolicyViewRowImpl obj) {
                return obj.getsystem();
            }

            public void put(PolicyViewRowImpl obj, Object value) {
                obj.setsystem((String)value);
            }
        },
        TOCItem {
            public Object get(PolicyViewRowImpl obj) {
                return obj.getTOCItem();
            }

            public void put(PolicyViewRowImpl obj, Object value) {
                obj.setTOCItem((String)value);
            }
        },
        PublishedURL {
            public Object get(PolicyViewRowImpl obj) {
                return obj.getPublishedURL();
            }

            public void put(PolicyViewRowImpl obj, Object value) {
                obj.setPublishedURL((String)value);
            }
        },
        isActive {
            public Object get(PolicyViewRowImpl obj) {
                return obj.getisActive();
            }

            public void put(PolicyViewRowImpl obj, Object value) {
                obj.setisActive((Boolean)value);
            }
        },
        AmendmentTitle {
            public Object get(PolicyViewRowImpl obj) {
                return obj.getAmendmentTitle();
            }

            public void put(PolicyViewRowImpl obj, Object value) {
                obj.setAmendmentTitle((String)value);
            }
        },
        AmendmentEffectiveDate {
            public Object get(PolicyViewRowImpl obj) {
                return obj.getAmendmentEffectiveDate();
            }

            public void put(PolicyViewRowImpl obj, Object value) {
                obj.setAmendmentEffectiveDate((String)value);
            }
        },
        AmendmentIssuanceDate {
            public Object get(PolicyViewRowImpl obj) {
                return obj.getAmendmentIssuanceDate();
            }

            public void put(PolicyViewRowImpl obj, Object value) {
                obj.setAmendmentIssuanceDate((Timestamp)value);
            }
        },
        AmendmentHighlights {
            public Object get(PolicyViewRowImpl obj) {
                return obj.getAmendmentHighlights();
            }

            public void put(PolicyViewRowImpl obj, Object value) {
                obj.setAmendmentHighlights((String)value);
            }
        },
        AmendmentAffectedChapters {
            public Object get(PolicyViewRowImpl obj) {
                return obj.getAmendmentAffectedChapters();
            }

            public void put(PolicyViewRowImpl obj, Object value) {
                obj.setAmendmentAffectedChapters((String)value);
            }
        },
        RefNum {
            public Object get(PolicyViewRowImpl obj) {
                return obj.getRefNum();
            }

            public void put(PolicyViewRowImpl obj, Object value) {
                obj.setRefNum((String)value);
            }
        },
        WorkflowFlag {
            public Object get(PolicyViewRowImpl obj) {
                return obj.getWorkflowFlag();
            }

            public void put(PolicyViewRowImpl obj, Object value) {
                obj.setWorkflowFlag((Integer)value);
            }
        },
        FilteringType {
            public Object get(PolicyViewRowImpl obj) {
                return obj.getFilteringType();
            }

            public void put(PolicyViewRowImpl obj, Object value) {
                obj.setFilteringType((Integer)value);
            }
        },
        DurationExpiryDate {
            public Object get(PolicyViewRowImpl obj) {
                return obj.getDurationExpiryDate();
            }

            public void put(PolicyViewRowImpl obj, Object value) {
                obj.setDurationExpiryDate((String)value);
            }
        },
        SenderEmail {
            public Object get(PolicyViewRowImpl obj) {
                return obj.getSenderEmail();
            }

            public void put(PolicyViewRowImpl obj, Object value) {
                obj.setSenderEmail((String)value);
            }
        },
        EmailFlag {
            public Object get(PolicyViewRowImpl obj) {
                return obj.getEmailFlag();
            }

            public void put(PolicyViewRowImpl obj, Object value) {
                obj.setEmailFlag((Boolean)value);
            }
        },
        NewIssuanceDate {
            public Object get(PolicyViewRowImpl obj) {
                return obj.getNewIssuanceDate();
            }

            public void put(PolicyViewRowImpl obj, Object value) {
                obj.setNewIssuanceDate((Timestamp)value);
            }
        },
        EnquiryfaqView {
            public Object get(PolicyViewRowImpl obj) {
                return obj.getEnquiryfaqView();
            }

            public void put(PolicyViewRowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        },
        PolicydepartmentpartitionView {
            public Object get(PolicyViewRowImpl obj) {
                return obj.getPolicydepartmentpartitionView();
            }

            public void put(PolicyViewRowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        },
        PolicyinstitutiontypepartitionView {
            public Object get(PolicyViewRowImpl obj) {
                return obj.getPolicyinstitutiontypepartitionView();
            }

            public void put(PolicyViewRowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        },
        AttachedfileView {
            public Object get(PolicyViewRowImpl obj) {
                return obj.getAttachedfileView();
            }

            public void put(PolicyViewRowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        };
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(PolicyViewRowImpl object);

        public abstract void put(PolicyViewRowImpl object, Object value);

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
    public static final int ITEMID = AttributesEnum.itemId.index();
    public static final int POLICYID = AttributesEnum.policyId.index();
    public static final int GUIDELINETITLE =
        AttributesEnum.GuidelineTitle.index();
    public static final int CATEGORYOFDOCUMENT =
        AttributesEnum.CategoryofDocument.index();
    public static final int APPLICABILITY =
        AttributesEnum.Applicability.index();
    public static final int EFFECTIVEDATE =
        AttributesEnum.EffectiveDate.index();
    public static final int ISSUINGDEPARTMENT =
        AttributesEnum.IssuingDepartment.index();
    public static final int POLICYURL = AttributesEnum.PolicyURL.index();
    public static final int AUTHOR = AttributesEnum.Author.index();
    public static final int SUMMARY = AttributesEnum.Summary.index();
    public static final int CLASSIFICATION =
        AttributesEnum.Classification.index();
    public static final int APPLICABILITYMANUALENTRY =
        AttributesEnum.ApplicabilityManualEntry.index();
    public static final int DISPLAYINWHATSNEW =
        AttributesEnum.DisplayInWhatsNew.index();
    public static final int EXPIRYDATE = AttributesEnum.ExpiryDate.index();
    public static final int CREATEDDATE = AttributesEnum.CreatedDate.index();
    public static final int LASTUPDATED = AttributesEnum.LastUpdated.index();
    public static final int OWNERDEPARTMENTID =
        AttributesEnum.ownerDepartmentId.index();
    public static final int KEYWORDS = AttributesEnum.keywords.index();
    public static final int PARTITIONTYPEID =
        AttributesEnum.partitionTypeId.index();
    public static final int SYSTEM = AttributesEnum.system.index();
    public static final int TOCITEM = AttributesEnum.TOCItem.index();
    public static final int PUBLISHEDURL = AttributesEnum.PublishedURL.index();
    public static final int ISACTIVE = AttributesEnum.isActive.index();
    public static final int AMENDMENTTITLE =
        AttributesEnum.AmendmentTitle.index();
    public static final int AMENDMENTEFFECTIVEDATE =
        AttributesEnum.AmendmentEffectiveDate.index();
    public static final int AMENDMENTISSUANCEDATE =
        AttributesEnum.AmendmentIssuanceDate.index();
    public static final int AMENDMENTHIGHLIGHTS =
        AttributesEnum.AmendmentHighlights.index();
    public static final int AMENDMENTAFFECTEDCHAPTERS =
        AttributesEnum.AmendmentAffectedChapters.index();
    public static final int REFNUM = AttributesEnum.RefNum.index();
    public static final int WORKFLOWFLAG = AttributesEnum.WorkflowFlag.index();
    public static final int FILTERINGTYPE =
        AttributesEnum.FilteringType.index();
    public static final int DURATIONEXPIRYDATE =
        AttributesEnum.DurationExpiryDate.index();
    public static final int SENDEREMAIL = AttributesEnum.SenderEmail.index();
    public static final int EMAILFLAG = AttributesEnum.EmailFlag.index();
    public static final int NEWISSUANCEDATE =
        AttributesEnum.NewIssuanceDate.index();
    public static final int ENQUIRYFAQVIEW =
        AttributesEnum.EnquiryfaqView.index();
    public static final int POLICYDEPARTMENTPARTITIONVIEW =
        AttributesEnum.PolicydepartmentpartitionView.index();
    public static final int POLICYINSTITUTIONTYPEPARTITIONVIEW =
        AttributesEnum.PolicyinstitutiontypepartitionView.index();
    public static final int ATTACHEDFILEVIEW =
        AttributesEnum.AttachedfileView.index();

    /**
     * This is the default constructor (do not remove).
     */
    public PolicyViewRowImpl() {
    }

    /**
     * Gets Policy entity object.
     * @return the Policy
     */
    public EntityImpl getPolicy() {
        return (EntityImpl)getEntity(0);
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
     * Gets the attribute value for policyId using the alias name policyId.
     * @return the policyId
     */
    public String getpolicyId() {
        return (String)getAttributeInternal(POLICYID);
    }

    /**
     * Sets <code>value</code> as attribute value for policyId using the alias name policyId.
     * @param value value to set the policyId
     */
    public void setpolicyId(String value) {
        setAttributeInternal(POLICYID, value);
    }

    /**
     * Gets the attribute value for GuidelineTitle using the alias name GuidelineTitle.
     * @return the GuidelineTitle
     */
    public String getGuidelineTitle() {
        return (String)getAttributeInternal(GUIDELINETITLE);
    }

    /**
     * Sets <code>value</code> as attribute value for GuidelineTitle using the alias name GuidelineTitle.
     * @param value value to set the GuidelineTitle
     */
    public void setGuidelineTitle(String value) {
        setAttributeInternal(GUIDELINETITLE, value);
    }

    /**
     * Gets the attribute value for CategoryofDocument using the alias name CategoryofDocument.
     * @return the CategoryofDocument
     */
    public String getCategoryofDocument() {
        return (String)getAttributeInternal(CATEGORYOFDOCUMENT);
    }

    /**
     * Sets <code>value</code> as attribute value for CategoryofDocument using the alias name CategoryofDocument.
     * @param value value to set the CategoryofDocument
     */
    public void setCategoryofDocument(String value) {
        setAttributeInternal(CATEGORYOFDOCUMENT, value);
    }

    /**
     * Gets the attribute value for Applicability using the alias name Applicability.
     * @return the Applicability
     */
    public String getApplicability() {
        return (String)getAttributeInternal(APPLICABILITY);
    }

    /**
     * Sets <code>value</code> as attribute value for Applicability using the alias name Applicability.
     * @param value value to set the Applicability
     */
    public void setApplicability(String value) {
        setAttributeInternal(APPLICABILITY, value);
    }

    /**
     * Gets the attribute value for EffectiveDate using the alias name EffectiveDate.
     * @return the EffectiveDate
     */
    public String getEffectiveDate() {
        return (String)getAttributeInternal(EFFECTIVEDATE);
    }

    /**
     * Sets <code>value</code> as attribute value for EffectiveDate using the alias name EffectiveDate.
     * @param value value to set the EffectiveDate
     */
    public void setEffectiveDate(String value) {
        setAttributeInternal(EFFECTIVEDATE, value);
    }

    /**
     * Gets the attribute value for IssuingDepartment using the alias name IssuingDepartment.
     * @return the IssuingDepartment
     */
    public String getIssuingDepartment() {
        return (String)getAttributeInternal(ISSUINGDEPARTMENT);
    }

    /**
     * Sets <code>value</code> as attribute value for IssuingDepartment using the alias name IssuingDepartment.
     * @param value value to set the IssuingDepartment
     */
    public void setIssuingDepartment(String value) {
        setAttributeInternal(ISSUINGDEPARTMENT, value);
    }

    /**
     * Gets the attribute value for PolicyURL using the alias name PolicyURL.
     * @return the PolicyURL
     */
    public String getPolicyURL() {
        return (String)getAttributeInternal(POLICYURL);
    }

    /**
     * Sets <code>value</code> as attribute value for PolicyURL using the alias name PolicyURL.
     * @param value value to set the PolicyURL
     */
    public void setPolicyURL(String value) {
        setAttributeInternal(POLICYURL, value);
    }

    /**
     * Gets the attribute value for Author using the alias name Author.
     * @return the Author
     */
    public String getAuthor() {
        return (String)getAttributeInternal(AUTHOR);
    }

    /**
     * Sets <code>value</code> as attribute value for Author using the alias name Author.
     * @param value value to set the Author
     */
    public void setAuthor(String value) {
        setAttributeInternal(AUTHOR, value);
    }

    /**
     * Gets the attribute value for Summary using the alias name Summary.
     * @return the Summary
     */
    public String getSummary() {
        return (String)getAttributeInternal(SUMMARY);
    }

    /**
     * Sets <code>value</code> as attribute value for Summary using the alias name Summary.
     * @param value value to set the Summary
     */
    public void setSummary(String value) {
        setAttributeInternal(SUMMARY, value);
    }

    /**
     * Gets the attribute value for Classification using the alias name Classification.
     * @return the Classification
     */
    public String getClassification() {
        return (String)getAttributeInternal(CLASSIFICATION);
    }

    /**
     * Sets <code>value</code> as attribute value for Classification using the alias name Classification.
     * @param value value to set the Classification
     */
    public void setClassification(String value) {
        setAttributeInternal(CLASSIFICATION, value);
    }

    /**
     * Gets the attribute value for ApplicabilityManualEntry using the alias name ApplicabilityManualEntry.
     * @return the ApplicabilityManualEntry
     */
    public String getApplicabilityManualEntry() {
        return (String)getAttributeInternal(APPLICABILITYMANUALENTRY);
    }

    /**
     * Sets <code>value</code> as attribute value for ApplicabilityManualEntry using the alias name ApplicabilityManualEntry.
     * @param value value to set the ApplicabilityManualEntry
     */
    public void setApplicabilityManualEntry(String value) {
        setAttributeInternal(APPLICABILITYMANUALENTRY, value);
    }

    /**
     * Gets the attribute value for DisplayInWhatsNew using the alias name DisplayInWhatsNew.
     * @return the DisplayInWhatsNew
     */
    public Boolean getDisplayInWhatsNew() {
        return (Boolean)getAttributeInternal(DISPLAYINWHATSNEW);
    }

    /**
     * Sets <code>value</code> as attribute value for DisplayInWhatsNew using the alias name DisplayInWhatsNew.
     * @param value value to set the DisplayInWhatsNew
     */
    public void setDisplayInWhatsNew(Boolean value) {
        setAttributeInternal(DISPLAYINWHATSNEW, value);
    }

    /**
     * Gets the attribute value for ExpiryDate using the alias name ExpiryDate.
     * @return the ExpiryDate
     */
    public Timestamp getExpiryDate() {
        return (Timestamp)getAttributeInternal(EXPIRYDATE);
    }

    /**
     * Sets <code>value</code> as attribute value for ExpiryDate using the alias name ExpiryDate.
     * @param value value to set the ExpiryDate
     */
    public void setExpiryDate(Timestamp value) {
        setAttributeInternal(EXPIRYDATE, value);
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
     * Gets the attribute value for ownerDepartmentId using the alias name ownerDepartmentId.
     * @return the ownerDepartmentId
     */
    public String getownerDepartmentId() {
        return (String)getAttributeInternal(OWNERDEPARTMENTID);
    }

    /**
     * Sets <code>value</code> as attribute value for ownerDepartmentId using the alias name ownerDepartmentId.
     * @param value value to set the ownerDepartmentId
     */
    public void setownerDepartmentId(String value) {
        setAttributeInternal(OWNERDEPARTMENTID, value);
    }

    /**
     * Gets the attribute value for keywords using the alias name keywords.
     * @return the keywords
     */
    public String getkeywords() {
        return (String)getAttributeInternal(KEYWORDS);
    }

    /**
     * Sets <code>value</code> as attribute value for keywords using the alias name keywords.
     * @param value value to set the keywords
     */
    public void setkeywords(String value) {
        setAttributeInternal(KEYWORDS, value);
    }

    /**
     * Gets the attribute value for partitionTypeId using the alias name partitionTypeId.
     * @return the partitionTypeId
     */
    public Integer getpartitionTypeId() {
        return (Integer)getAttributeInternal(PARTITIONTYPEID);
    }

    /**
     * Sets <code>value</code> as attribute value for partitionTypeId using the alias name partitionTypeId.
     * @param value value to set the partitionTypeId
     */
    public void setpartitionTypeId(Integer value) {
        setAttributeInternal(PARTITIONTYPEID, value);
    }

    /**
     * Gets the attribute value for system using the alias name system.
     * @return the system
     */
    public String getsystem() {
        return (String)getAttributeInternal(SYSTEM);
    }

    /**
     * Sets <code>value</code> as attribute value for system using the alias name system.
     * @param value value to set the system
     */
    public void setsystem(String value) {
        setAttributeInternal(SYSTEM, value);
    }

    /**
     * Gets the attribute value for TOCItem using the alias name TOCItem.
     * @return the TOCItem
     */
    public String getTOCItem() {
        return (String)getAttributeInternal(TOCITEM);
    }

    /**
     * Sets <code>value</code> as attribute value for TOCItem using the alias name TOCItem.
     * @param value value to set the TOCItem
     */
    public void setTOCItem(String value) {
        setAttributeInternal(TOCITEM, value);
    }

    /**
     * Gets the attribute value for PublishedURL using the alias name PublishedURL.
     * @return the PublishedURL
     */
    public String getPublishedURL() {
        return (String)getAttributeInternal(PUBLISHEDURL);
    }

    /**
     * Sets <code>value</code> as attribute value for PublishedURL using the alias name PublishedURL.
     * @param value value to set the PublishedURL
     */
    public void setPublishedURL(String value) {
        setAttributeInternal(PUBLISHEDURL, value);
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
     * Gets the attribute value for AmendmentTitle using the alias name AmendmentTitle.
     * @return the AmendmentTitle
     */
    public String getAmendmentTitle() {
        return (String)getAttributeInternal(AMENDMENTTITLE);
    }

    /**
     * Sets <code>value</code> as attribute value for AmendmentTitle using the alias name AmendmentTitle.
     * @param value value to set the AmendmentTitle
     */
    public void setAmendmentTitle(String value) {
        setAttributeInternal(AMENDMENTTITLE, value);
    }

    /**
     * Gets the attribute value for AmendmentEffectiveDate using the alias name AmendmentEffectiveDate.
     * @return the AmendmentEffectiveDate
     */
    public String getAmendmentEffectiveDate() {
        return (String)getAttributeInternal(AMENDMENTEFFECTIVEDATE);
    }

    /**
     * Sets <code>value</code> as attribute value for AmendmentEffectiveDate using the alias name AmendmentEffectiveDate.
     * @param value value to set the AmendmentEffectiveDate
     */
    public void setAmendmentEffectiveDate(String value) {
        setAttributeInternal(AMENDMENTEFFECTIVEDATE, value);
    }

    /**
     * Gets the attribute value for AmendmentIssuanceDate using the alias name AmendmentIssuanceDate.
     * @return the AmendmentIssuanceDate
     */
    public Timestamp getAmendmentIssuanceDate() {
        return (Timestamp)getAttributeInternal(AMENDMENTISSUANCEDATE);
    }

    /**
     * Sets <code>value</code> as attribute value for AmendmentIssuanceDate using the alias name AmendmentIssuanceDate.
     * @param value value to set the AmendmentIssuanceDate
     */
    public void setAmendmentIssuanceDate(Timestamp value) {
        setAttributeInternal(AMENDMENTISSUANCEDATE, value);
    }

    /**
     * Gets the attribute value for AmendmentHighlights using the alias name AmendmentHighlights.
     * @return the AmendmentHighlights
     */
    public String getAmendmentHighlights() {
        return (String)getAttributeInternal(AMENDMENTHIGHLIGHTS);
    }

    /**
     * Sets <code>value</code> as attribute value for AmendmentHighlights using the alias name AmendmentHighlights.
     * @param value value to set the AmendmentHighlights
     */
    public void setAmendmentHighlights(String value) {
        setAttributeInternal(AMENDMENTHIGHLIGHTS, value);
    }

    /**
     * Gets the attribute value for AmendmentAffectedChapters using the alias name AmendmentAffectedChapters.
     * @return the AmendmentAffectedChapters
     */
    public String getAmendmentAffectedChapters() {
        return (String)getAttributeInternal(AMENDMENTAFFECTEDCHAPTERS);
    }

    /**
     * Sets <code>value</code> as attribute value for AmendmentAffectedChapters using the alias name AmendmentAffectedChapters.
     * @param value value to set the AmendmentAffectedChapters
     */
    public void setAmendmentAffectedChapters(String value) {
        setAttributeInternal(AMENDMENTAFFECTEDCHAPTERS, value);
    }

    /**
     * Gets the attribute value for RefNum using the alias name RefNum.
     * @return the RefNum
     */
    public String getRefNum() {
        return (String)getAttributeInternal(REFNUM);
    }

    /**
     * Sets <code>value</code> as attribute value for RefNum using the alias name RefNum.
     * @param value value to set the RefNum
     */
    public void setRefNum(String value) {
        setAttributeInternal(REFNUM, value);
    }

    /**
     * Gets the attribute value for WorkflowFlag using the alias name WorkflowFlag.
     * @return the WorkflowFlag
     */
    public Integer getWorkflowFlag() {
        return (Integer)getAttributeInternal(WORKFLOWFLAG);
    }

    /**
     * Sets <code>value</code> as attribute value for WorkflowFlag using the alias name WorkflowFlag.
     * @param value value to set the WorkflowFlag
     */
    public void setWorkflowFlag(Integer value) {
        setAttributeInternal(WORKFLOWFLAG, value);
    }

    /**
     * Gets the attribute value for FilteringType using the alias name FilteringType.
     * @return the FilteringType
     */
    public Integer getFilteringType() {
        return (Integer)getAttributeInternal(FILTERINGTYPE);
    }

    /**
     * Sets <code>value</code> as attribute value for FilteringType using the alias name FilteringType.
     * @param value value to set the FilteringType
     */
    public void setFilteringType(Integer value) {
        setAttributeInternal(FILTERINGTYPE, value);
    }

    /**
     * Gets the attribute value for DurationExpiryDate using the alias name DurationExpiryDate.
     * @return the DurationExpiryDate
     */
    public String getDurationExpiryDate() {
        return (String)getAttributeInternal(DURATIONEXPIRYDATE);
    }

    /**
     * Sets <code>value</code> as attribute value for DurationExpiryDate using the alias name DurationExpiryDate.
     * @param value value to set the DurationExpiryDate
     */
    public void setDurationExpiryDate(String value) {
        setAttributeInternal(DURATIONEXPIRYDATE, value);
    }

    /**
     * Gets the attribute value for SenderEmail using the alias name SenderEmail.
     * @return the SenderEmail
     */
    public String getSenderEmail() {
        return (String)getAttributeInternal(SENDEREMAIL);
    }

    /**
     * Sets <code>value</code> as attribute value for SenderEmail using the alias name SenderEmail.
     * @param value value to set the SenderEmail
     */
    public void setSenderEmail(String value) {
        setAttributeInternal(SENDEREMAIL, value);
    }

    /**
     * Gets the attribute value for EmailFlag using the alias name EmailFlag.
     * @return the EmailFlag
     */
    public Boolean getEmailFlag() {
        return (Boolean)getAttributeInternal(EMAILFLAG);
    }

    /**
     * Sets <code>value</code> as attribute value for EmailFlag using the alias name EmailFlag.
     * @param value value to set the EmailFlag
     */
    public void setEmailFlag(Boolean value) {
        setAttributeInternal(EMAILFLAG, value);
    }

    /**
     * Gets the attribute value for NewIssuanceDate using the alias name NewIssuanceDate.
     * @return the NewIssuanceDate
     */
    public Timestamp getNewIssuanceDate() {
        return (Timestamp)getAttributeInternal(NEWISSUANCEDATE);
    }

    /**
     * Sets <code>value</code> as attribute value for NewIssuanceDate using the alias name NewIssuanceDate.
     * @param value value to set the NewIssuanceDate
     */
    public void setNewIssuanceDate(Timestamp value) {
        setAttributeInternal(NEWISSUANCEDATE, value);
    }

    /**
     * Gets the associated <code>Row</code> using master-detail link EnquiryfaqView.
     */
    public Row getEnquiryfaqView() {
        return (Row)getAttributeInternal(ENQUIRYFAQVIEW);
    }

    /**
     * Sets the master-detail link EnquiryfaqView between this object and <code>value</code>.
     */
    public void setEnquiryfaqView(Row value) {
        setAttributeInternal(ENQUIRYFAQVIEW, value);
    }

    /**
     * Gets the associated <code>RowIterator</code> using master-detail link PolicydepartmentpartitionView.
     */
    public RowIterator getPolicydepartmentpartitionView() {
        return (RowIterator)getAttributeInternal(POLICYDEPARTMENTPARTITIONVIEW);
    }

    /**
     * Gets the associated <code>Row</code> using master-detail link PolicyinstitutiontypepartitionView.
     */
    public Row getPolicyinstitutiontypepartitionView() {
        return (Row)getAttributeInternal(POLICYINSTITUTIONTYPEPARTITIONVIEW);
    }

    /**
     * Sets the master-detail link PolicyinstitutiontypepartitionView between this object and <code>value</code>.
     */
    public void setPolicyinstitutiontypepartitionView(Row value) {
        setAttributeInternal(POLICYINSTITUTIONTYPEPARTITIONVIEW, value);
    }

    /**
     * Gets the associated <code>RowIterator</code> using master-detail link AttachedfileView.
     */
    public RowIterator getAttachedfileView() {
        return (RowIterator)getAttributeInternal(ATTACHEDFILEVIEW);
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
