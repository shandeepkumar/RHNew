package gov.bnm.rh.views;

import gov.bnm.rh.entities.PolicyImpl;

import java.math.BigDecimal;

import java.sql.Timestamp;

import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Fri Oct 25 13:51:20 SGT 2019
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class PolicyOpenConsultantViewRowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        ApplicabilityManualEntry {
            public Object get(PolicyOpenConsultantViewRowImpl obj) {
                return obj.getApplicabilityManualEntry();
            }

            public void put(PolicyOpenConsultantViewRowImpl obj,
                            Object value) {
                obj.setApplicabilityManualEntry((String)value);
            }
        }
        ,
        Classification {
            public Object get(PolicyOpenConsultantViewRowImpl obj) {
                return obj.getClassification();
            }

            public void put(PolicyOpenConsultantViewRowImpl obj,
                            Object value) {
                obj.setClassification((String)value);
            }
        }
        ,
        CreatedDate {
            public Object get(PolicyOpenConsultantViewRowImpl obj) {
                return obj.getCreatedDate();
            }

            public void put(PolicyOpenConsultantViewRowImpl obj,
                            Object value) {
                obj.setCreatedDate((Timestamp)value);
            }
        }
        ,
        DisplayInWhatsNew {
            public Object get(PolicyOpenConsultantViewRowImpl obj) {
                return obj.getDisplayInWhatsNew();
            }

            public void put(PolicyOpenConsultantViewRowImpl obj,
                            Object value) {
                obj.setDisplayInWhatsNew((Boolean)value);
            }
        }
        ,
        DocCategory {
            public Object get(PolicyOpenConsultantViewRowImpl obj) {
                return obj.getDocCategory();
            }

            public void put(PolicyOpenConsultantViewRowImpl obj,
                            Object value) {
                obj.setDocCategory((BigDecimal)value);
            }
        }
        ,
        EffectiveDate {
            public Object get(PolicyOpenConsultantViewRowImpl obj) {
                return obj.getEffectiveDate();
            }

            public void put(PolicyOpenConsultantViewRowImpl obj,
                            Object value) {
                obj.setEffectiveDate((String)value);
            }
        }
        ,
        ExpiryDate {
            public Object get(PolicyOpenConsultantViewRowImpl obj) {
                return obj.getExpiryDate();
            }

            public void put(PolicyOpenConsultantViewRowImpl obj,
                            Object value) {
                obj.setExpiryDate((Timestamp)value);
            }
        }
        ,
        FirstIssuanceDate {
            public Object get(PolicyOpenConsultantViewRowImpl obj) {
                return obj.getFirstIssuanceDate();
            }

            public void put(PolicyOpenConsultantViewRowImpl obj,
                            Object value) {
                obj.setFirstIssuanceDate((Timestamp)value);
            }
        }
        ,
        GuidelineTitle {
            public Object get(PolicyOpenConsultantViewRowImpl obj) {
                return obj.getGuidelineTitle();
            }

            public void put(PolicyOpenConsultantViewRowImpl obj,
                            Object value) {
                obj.setGuidelineTitle((String)value);
            }
        }
        ,
        Highlights {
            public Object get(PolicyOpenConsultantViewRowImpl obj) {
                return obj.getHighlights();
            }

            public void put(PolicyOpenConsultantViewRowImpl obj,
                            Object value) {
                obj.setHighlights((String)value);
            }
        }
        ,
        LastUpdated {
            public Object get(PolicyOpenConsultantViewRowImpl obj) {
                return obj.getLastUpdated();
            }

            public void put(PolicyOpenConsultantViewRowImpl obj,
                            Object value) {
                obj.setLastUpdated((Timestamp)value);
            }
        }
        ,
        NewEffectiveDate {
            public Object get(PolicyOpenConsultantViewRowImpl obj) {
                return obj.getNewEffectiveDate();
            }

            public void put(PolicyOpenConsultantViewRowImpl obj,
                            Object value) {
                obj.setNewEffectiveDate((Timestamp)value);
            }
        }
        ,
        NewIssuanceDate {
            public Object get(PolicyOpenConsultantViewRowImpl obj) {
                return obj.getNewIssuanceDate();
            }

            public void put(PolicyOpenConsultantViewRowImpl obj,
                            Object value) {
                obj.setNewIssuanceDate((Timestamp)value);
            }
        }
        ,
        PolicyURL {
            public Object get(PolicyOpenConsultantViewRowImpl obj) {
                return obj.getPolicyURL();
            }

            public void put(PolicyOpenConsultantViewRowImpl obj,
                            Object value) {
                obj.setPolicyURL((String)value);
            }
        }
        ,
        PriorPublishEmailFlag {
            public Object get(PolicyOpenConsultantViewRowImpl obj) {
                return obj.getPriorPublishEmailFlag();
            }

            public void put(PolicyOpenConsultantViewRowImpl obj,
                            Object value) {
                obj.setPriorPublishEmailFlag((Boolean)value);
            }
        }
        ,
        PublishToBNM {
            public Object get(PolicyOpenConsultantViewRowImpl obj) {
                return obj.getPublishToBNM();
            }

            public void put(PolicyOpenConsultantViewRowImpl obj,
                            Object value) {
                obj.setPublishToBNM((String)value);
            }
        }
        ,
        PublishedEmailFlag {
            public Object get(PolicyOpenConsultantViewRowImpl obj) {
                return obj.getPublishedEmailFlag();
            }

            public void put(PolicyOpenConsultantViewRowImpl obj,
                            Object value) {
                obj.setPublishedEmailFlag((Boolean)value);
            }
        }
        ,
        PublishedURL {
            public Object get(PolicyOpenConsultantViewRowImpl obj) {
                return obj.getPublishedURL();
            }

            public void put(PolicyOpenConsultantViewRowImpl obj,
                            Object value) {
                obj.setPublishedURL((String)value);
            }
        }
        ,
        ReasonForRejection {
            public Object get(PolicyOpenConsultantViewRowImpl obj) {
                return obj.getReasonForRejection();
            }

            public void put(PolicyOpenConsultantViewRowImpl obj,
                            Object value) {
                obj.setReasonForRejection((String)value);
            }
        }
        ,
        RecordStatus {
            public Object get(PolicyOpenConsultantViewRowImpl obj) {
                return obj.getRecordStatus();
            }

            public void put(PolicyOpenConsultantViewRowImpl obj,
                            Object value) {
                obj.setRecordStatus((String)value);
            }
        }
        ,
        RefNum {
            public Object get(PolicyOpenConsultantViewRowImpl obj) {
                return obj.getRefNum();
            }

            public void put(PolicyOpenConsultantViewRowImpl obj,
                            Object value) {
                obj.setRefNum((String)value);
            }
        }
        ,
        SectionInCharge {
            public Object get(PolicyOpenConsultantViewRowImpl obj) {
                return obj.getSectionInCharge();
            }

            public void put(PolicyOpenConsultantViewRowImpl obj,
                            Object value) {
                obj.setSectionInCharge((String)value);
            }
        }
        ,
        SenderEmail {
            public Object get(PolicyOpenConsultantViewRowImpl obj) {
                return obj.getSenderEmail();
            }

            public void put(PolicyOpenConsultantViewRowImpl obj,
                            Object value) {
                obj.setSenderEmail((String)value);
            }
        }
        ,
        Summary {
            public Object get(PolicyOpenConsultantViewRowImpl obj) {
                return obj.getSummary();
            }

            public void put(PolicyOpenConsultantViewRowImpl obj,
                            Object value) {
                obj.setSummary((String)value);
            }
        }
        ,
        WhatsNewMonths {
            public Object get(PolicyOpenConsultantViewRowImpl obj) {
                return obj.getWhatsNewMonths();
            }

            public void put(PolicyOpenConsultantViewRowImpl obj,
                            Object value) {
                obj.setWhatsNewMonths((BigDecimal)value);
            }
        }
        ,
        approverId {
            public Object get(PolicyOpenConsultantViewRowImpl obj) {
                return obj.getapproverId();
            }

            public void put(PolicyOpenConsultantViewRowImpl obj,
                            Object value) {
                obj.setapproverId((String)value);
            }
        }
        ,
        createdBy {
            public Object get(PolicyOpenConsultantViewRowImpl obj) {
                return obj.getcreatedBy();
            }

            public void put(PolicyOpenConsultantViewRowImpl obj,
                            Object value) {
                obj.setcreatedBy((String)value);
            }
        }
        ,
        isActive {
            public Object get(PolicyOpenConsultantViewRowImpl obj) {
                return obj.getisActive();
            }

            public void put(PolicyOpenConsultantViewRowImpl obj,
                            Object value) {
                obj.setisActive((Boolean)value);
            }
        }
        ,
        isAmendmentRecord {
            public Object get(PolicyOpenConsultantViewRowImpl obj) {
                return obj.getisAmendmentRecord();
            }

            public void put(PolicyOpenConsultantViewRowImpl obj,
                            Object value) {
                obj.setisAmendmentRecord((Boolean)value);
            }
        }
        ,
        itemId {
            public Object get(PolicyOpenConsultantViewRowImpl obj) {
                return obj.getitemId();
            }

            public void put(PolicyOpenConsultantViewRowImpl obj,
                            Object value) {
                obj.setitemId((String)value);
            }
        }
        ,
        keywords {
            public Object get(PolicyOpenConsultantViewRowImpl obj) {
                return obj.getkeywords();
            }

            public void put(PolicyOpenConsultantViewRowImpl obj,
                            Object value) {
                obj.setkeywords((String)value);
            }
        }
        ,
        partitionTypeId {
            public Object get(PolicyOpenConsultantViewRowImpl obj) {
                return obj.getpartitionTypeId();
            }

            public void put(PolicyOpenConsultantViewRowImpl obj,
                            Object value) {
                obj.setpartitionTypeId((Integer)value);
            }
        }
        ,
        policyId {
            public Object get(PolicyOpenConsultantViewRowImpl obj) {
                return obj.getpolicyId();
            }

            public void put(PolicyOpenConsultantViewRowImpl obj,
                            Object value) {
                obj.setpolicyId((String)value);
            }
        }
        ,
        system {
            public Object get(PolicyOpenConsultantViewRowImpl obj) {
                return obj.getsystem();
            }

            public void put(PolicyOpenConsultantViewRowImpl obj,
                            Object value) {
                obj.setsystem((String)value);
            }
        }
        ,
        updatedBy {
            public Object get(PolicyOpenConsultantViewRowImpl obj) {
                return obj.getupdatedBy();
            }

            public void put(PolicyOpenConsultantViewRowImpl obj,
                            Object value) {
                obj.setupdatedBy((String)value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(PolicyOpenConsultantViewRowImpl object);

        public abstract void put(PolicyOpenConsultantViewRowImpl object,
                                 Object value);

        public int index() {
            return AttributesEnum.firstIndex() + ordinal();
        }

        public static final int firstIndex() {
            return firstIndex;
        }

        public static int count() {
            return AttributesEnum.firstIndex() + AttributesEnum.staticValues().length;
        }

        public static final AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = AttributesEnum.values();
            }
            return vals;
        }
    }
    public static final int APPLICABILITYMANUALENTRY = AttributesEnum.ApplicabilityManualEntry.index();
    public static final int CLASSIFICATION = AttributesEnum.Classification.index();
    public static final int CREATEDDATE = AttributesEnum.CreatedDate.index();
    public static final int DISPLAYINWHATSNEW = AttributesEnum.DisplayInWhatsNew.index();
    public static final int DOCCATEGORY = AttributesEnum.DocCategory.index();
    public static final int EFFECTIVEDATE = AttributesEnum.EffectiveDate.index();
    public static final int EXPIRYDATE = AttributesEnum.ExpiryDate.index();
    public static final int FIRSTISSUANCEDATE = AttributesEnum.FirstIssuanceDate.index();
    public static final int GUIDELINETITLE = AttributesEnum.GuidelineTitle.index();
    public static final int HIGHLIGHTS = AttributesEnum.Highlights.index();
    public static final int LASTUPDATED = AttributesEnum.LastUpdated.index();
    public static final int NEWEFFECTIVEDATE = AttributesEnum.NewEffectiveDate.index();
    public static final int NEWISSUANCEDATE = AttributesEnum.NewIssuanceDate.index();
    public static final int POLICYURL = AttributesEnum.PolicyURL.index();
    public static final int PRIORPUBLISHEMAILFLAG = AttributesEnum.PriorPublishEmailFlag.index();
    public static final int PUBLISHTOBNM = AttributesEnum.PublishToBNM.index();
    public static final int PUBLISHEDEMAILFLAG = AttributesEnum.PublishedEmailFlag.index();
    public static final int PUBLISHEDURL = AttributesEnum.PublishedURL.index();
    public static final int REASONFORREJECTION = AttributesEnum.ReasonForRejection.index();
    public static final int RECORDSTATUS = AttributesEnum.RecordStatus.index();
    public static final int REFNUM = AttributesEnum.RefNum.index();
    public static final int SECTIONINCHARGE = AttributesEnum.SectionInCharge.index();
    public static final int SENDEREMAIL = AttributesEnum.SenderEmail.index();
    public static final int SUMMARY = AttributesEnum.Summary.index();
    public static final int WHATSNEWMONTHS = AttributesEnum.WhatsNewMonths.index();
    public static final int APPROVERID = AttributesEnum.approverId.index();
    public static final int CREATEDBY = AttributesEnum.createdBy.index();
    public static final int ISACTIVE = AttributesEnum.isActive.index();
    public static final int ISAMENDMENTRECORD = AttributesEnum.isAmendmentRecord.index();
    public static final int ITEMID = AttributesEnum.itemId.index();
    public static final int KEYWORDS = AttributesEnum.keywords.index();
    public static final int PARTITIONTYPEID = AttributesEnum.partitionTypeId.index();
    public static final int POLICYID = AttributesEnum.policyId.index();
    public static final int SYSTEM = AttributesEnum.system.index();
    public static final int UPDATEDBY = AttributesEnum.updatedBy.index();

    /**
     * This is the default constructor (do not remove).
     */
    public PolicyOpenConsultantViewRowImpl() {
    }

    /**
     * Gets Policy entity object.
     * @return the Policy
     */
    public PolicyImpl getPolicy() {
        return (PolicyImpl)getEntity(0);
    }

    /**
     * Gets the attribute value for ApplicabilityManualEntry using the alias name ApplicabilityManualEntry.
     * @return the ApplicabilityManualEntry
     */
    public String getApplicabilityManualEntry() {
        return (String) getAttributeInternal(APPLICABILITYMANUALENTRY);
    }

    /**
     * Sets <code>value</code> as attribute value for ApplicabilityManualEntry using the alias name ApplicabilityManualEntry.
     * @param value value to set the ApplicabilityManualEntry
     */
    public void setApplicabilityManualEntry(String value) {
        setAttributeInternal(APPLICABILITYMANUALENTRY, value);
    }

    /**
     * Gets the attribute value for Classification using the alias name Classification.
     * @return the Classification
     */
    public String getClassification() {
        return (String) getAttributeInternal(CLASSIFICATION);
    }

    /**
     * Sets <code>value</code> as attribute value for Classification using the alias name Classification.
     * @param value value to set the Classification
     */
    public void setClassification(String value) {
        setAttributeInternal(CLASSIFICATION, value);
    }

    /**
     * Gets the attribute value for CreatedDate using the alias name CreatedDate.
     * @return the CreatedDate
     */
    public Timestamp getCreatedDate() {
        return (Timestamp) getAttributeInternal(CREATEDDATE);
    }

    /**
     * Sets <code>value</code> as attribute value for CreatedDate using the alias name CreatedDate.
     * @param value value to set the CreatedDate
     */
    public void setCreatedDate(Timestamp value) {
        setAttributeInternal(CREATEDDATE, value);
    }

    /**
     * Gets the attribute value for DisplayInWhatsNew using the alias name DisplayInWhatsNew.
     * @return the DisplayInWhatsNew
     */
    public Boolean getDisplayInWhatsNew() {
        return (Boolean) getAttributeInternal(DISPLAYINWHATSNEW);
    }

    /**
     * Sets <code>value</code> as attribute value for DisplayInWhatsNew using the alias name DisplayInWhatsNew.
     * @param value value to set the DisplayInWhatsNew
     */
    public void setDisplayInWhatsNew(Boolean value) {
        setAttributeInternal(DISPLAYINWHATSNEW, value);
    }

    /**
     * Gets the attribute value for DocCategory using the alias name DocCategory.
     * @return the DocCategory
     */
    public BigDecimal getDocCategory() {
        return (BigDecimal) getAttributeInternal(DOCCATEGORY);
    }

    /**
     * Sets <code>value</code> as attribute value for DocCategory using the alias name DocCategory.
     * @param value value to set the DocCategory
     */
    public void setDocCategory(BigDecimal value) {
        setAttributeInternal(DOCCATEGORY, value);
    }

    /**
     * Gets the attribute value for EffectiveDate using the alias name EffectiveDate.
     * @return the EffectiveDate
     */
    public String getEffectiveDate() {
        return (String) getAttributeInternal(EFFECTIVEDATE);
    }

    /**
     * Sets <code>value</code> as attribute value for EffectiveDate using the alias name EffectiveDate.
     * @param value value to set the EffectiveDate
     */
    public void setEffectiveDate(String value) {
        setAttributeInternal(EFFECTIVEDATE, value);
    }

    /**
     * Gets the attribute value for ExpiryDate using the alias name ExpiryDate.
     * @return the ExpiryDate
     */
    public Timestamp getExpiryDate() {
        return (Timestamp) getAttributeInternal(EXPIRYDATE);
    }

    /**
     * Sets <code>value</code> as attribute value for ExpiryDate using the alias name ExpiryDate.
     * @param value value to set the ExpiryDate
     */
    public void setExpiryDate(Timestamp value) {
        setAttributeInternal(EXPIRYDATE, value);
    }

    /**
     * Gets the attribute value for FirstIssuanceDate using the alias name FirstIssuanceDate.
     * @return the FirstIssuanceDate
     */
    public Timestamp getFirstIssuanceDate() {
        return (Timestamp) getAttributeInternal(FIRSTISSUANCEDATE);
    }

    /**
     * Sets <code>value</code> as attribute value for FirstIssuanceDate using the alias name FirstIssuanceDate.
     * @param value value to set the FirstIssuanceDate
     */
    public void setFirstIssuanceDate(Timestamp value) {
        setAttributeInternal(FIRSTISSUANCEDATE, value);
    }

    /**
     * Gets the attribute value for GuidelineTitle using the alias name GuidelineTitle.
     * @return the GuidelineTitle
     */
    public String getGuidelineTitle() {
        return (String) getAttributeInternal(GUIDELINETITLE);
    }

    /**
     * Sets <code>value</code> as attribute value for GuidelineTitle using the alias name GuidelineTitle.
     * @param value value to set the GuidelineTitle
     */
    public void setGuidelineTitle(String value) {
        setAttributeInternal(GUIDELINETITLE, value);
    }

    /**
     * Gets the attribute value for Highlights using the alias name Highlights.
     * @return the Highlights
     */
    public String getHighlights() {
        return (String) getAttributeInternal(HIGHLIGHTS);
    }

    /**
     * Sets <code>value</code> as attribute value for Highlights using the alias name Highlights.
     * @param value value to set the Highlights
     */
    public void setHighlights(String value) {
        setAttributeInternal(HIGHLIGHTS, value);
    }

    /**
     * Gets the attribute value for LastUpdated using the alias name LastUpdated.
     * @return the LastUpdated
     */
    public Timestamp getLastUpdated() {
        return (Timestamp) getAttributeInternal(LASTUPDATED);
    }

    /**
     * Sets <code>value</code> as attribute value for LastUpdated using the alias name LastUpdated.
     * @param value value to set the LastUpdated
     */
    public void setLastUpdated(Timestamp value) {
        setAttributeInternal(LASTUPDATED, value);
    }

    /**
     * Gets the attribute value for NewEffectiveDate using the alias name NewEffectiveDate.
     * @return the NewEffectiveDate
     */
    public Timestamp getNewEffectiveDate() {
        return (Timestamp) getAttributeInternal(NEWEFFECTIVEDATE);
    }

    /**
     * Sets <code>value</code> as attribute value for NewEffectiveDate using the alias name NewEffectiveDate.
     * @param value value to set the NewEffectiveDate
     */
    public void setNewEffectiveDate(Timestamp value) {
        setAttributeInternal(NEWEFFECTIVEDATE, value);
    }

    /**
     * Gets the attribute value for NewIssuanceDate using the alias name NewIssuanceDate.
     * @return the NewIssuanceDate
     */
    public Timestamp getNewIssuanceDate() {
        return (Timestamp) getAttributeInternal(NEWISSUANCEDATE);
    }

    /**
     * Sets <code>value</code> as attribute value for NewIssuanceDate using the alias name NewIssuanceDate.
     * @param value value to set the NewIssuanceDate
     */
    public void setNewIssuanceDate(Timestamp value) {
        setAttributeInternal(NEWISSUANCEDATE, value);
    }

    /**
     * Gets the attribute value for PolicyURL using the alias name PolicyURL.
     * @return the PolicyURL
     */
    public String getPolicyURL() {
        return (String) getAttributeInternal(POLICYURL);
    }

    /**
     * Sets <code>value</code> as attribute value for PolicyURL using the alias name PolicyURL.
     * @param value value to set the PolicyURL
     */
    public void setPolicyURL(String value) {
        setAttributeInternal(POLICYURL, value);
    }

    /**
     * Gets the attribute value for PriorPublishEmailFlag using the alias name PriorPublishEmailFlag.
     * @return the PriorPublishEmailFlag
     */
    public Boolean getPriorPublishEmailFlag() {
        return (Boolean) getAttributeInternal(PRIORPUBLISHEMAILFLAG);
    }

    /**
     * Sets <code>value</code> as attribute value for PriorPublishEmailFlag using the alias name PriorPublishEmailFlag.
     * @param value value to set the PriorPublishEmailFlag
     */
    public void setPriorPublishEmailFlag(Boolean value) {
        setAttributeInternal(PRIORPUBLISHEMAILFLAG, value);
    }

    /**
     * Gets the attribute value for PublishToBNM using the alias name PublishToBNM.
     * @return the PublishToBNM
     */
    public String getPublishToBNM() {
        return (String) getAttributeInternal(PUBLISHTOBNM);
    }

    /**
     * Sets <code>value</code> as attribute value for PublishToBNM using the alias name PublishToBNM.
     * @param value value to set the PublishToBNM
     */
    public void setPublishToBNM(String value) {
        setAttributeInternal(PUBLISHTOBNM, value);
    }

    /**
     * Gets the attribute value for PublishedEmailFlag using the alias name PublishedEmailFlag.
     * @return the PublishedEmailFlag
     */
    public Boolean getPublishedEmailFlag() {
        return (Boolean) getAttributeInternal(PUBLISHEDEMAILFLAG);
    }

    /**
     * Sets <code>value</code> as attribute value for PublishedEmailFlag using the alias name PublishedEmailFlag.
     * @param value value to set the PublishedEmailFlag
     */
    public void setPublishedEmailFlag(Boolean value) {
        setAttributeInternal(PUBLISHEDEMAILFLAG, value);
    }

    /**
     * Gets the attribute value for PublishedURL using the alias name PublishedURL.
     * @return the PublishedURL
     */
    public String getPublishedURL() {
        return (String) getAttributeInternal(PUBLISHEDURL);
    }

    /**
     * Sets <code>value</code> as attribute value for PublishedURL using the alias name PublishedURL.
     * @param value value to set the PublishedURL
     */
    public void setPublishedURL(String value) {
        setAttributeInternal(PUBLISHEDURL, value);
    }

    /**
     * Gets the attribute value for ReasonForRejection using the alias name ReasonForRejection.
     * @return the ReasonForRejection
     */
    public String getReasonForRejection() {
        return (String) getAttributeInternal(REASONFORREJECTION);
    }

    /**
     * Sets <code>value</code> as attribute value for ReasonForRejection using the alias name ReasonForRejection.
     * @param value value to set the ReasonForRejection
     */
    public void setReasonForRejection(String value) {
        setAttributeInternal(REASONFORREJECTION, value);
    }

    /**
     * Gets the attribute value for RecordStatus using the alias name RecordStatus.
     * @return the RecordStatus
     */
    public String getRecordStatus() {
        return (String) getAttributeInternal(RECORDSTATUS);
    }

    /**
     * Sets <code>value</code> as attribute value for RecordStatus using the alias name RecordStatus.
     * @param value value to set the RecordStatus
     */
    public void setRecordStatus(String value) {
        setAttributeInternal(RECORDSTATUS, value);
    }

    /**
     * Gets the attribute value for RefNum using the alias name RefNum.
     * @return the RefNum
     */
    public String getRefNum() {
        return (String) getAttributeInternal(REFNUM);
    }

    /**
     * Sets <code>value</code> as attribute value for RefNum using the alias name RefNum.
     * @param value value to set the RefNum
     */
    public void setRefNum(String value) {
        setAttributeInternal(REFNUM, value);
    }

    /**
     * Gets the attribute value for SectionInCharge using the alias name SectionInCharge.
     * @return the SectionInCharge
     */
    public String getSectionInCharge() {
        return (String) getAttributeInternal(SECTIONINCHARGE);
    }

    /**
     * Sets <code>value</code> as attribute value for SectionInCharge using the alias name SectionInCharge.
     * @param value value to set the SectionInCharge
     */
    public void setSectionInCharge(String value) {
        setAttributeInternal(SECTIONINCHARGE, value);
    }

    /**
     * Gets the attribute value for SenderEmail using the alias name SenderEmail.
     * @return the SenderEmail
     */
    public String getSenderEmail() {
        return (String) getAttributeInternal(SENDEREMAIL);
    }

    /**
     * Sets <code>value</code> as attribute value for SenderEmail using the alias name SenderEmail.
     * @param value value to set the SenderEmail
     */
    public void setSenderEmail(String value) {
        setAttributeInternal(SENDEREMAIL, value);
    }

    /**
     * Gets the attribute value for Summary using the alias name Summary.
     * @return the Summary
     */
    public String getSummary() {
        return (String) getAttributeInternal(SUMMARY);
    }

    /**
     * Sets <code>value</code> as attribute value for Summary using the alias name Summary.
     * @param value value to set the Summary
     */
    public void setSummary(String value) {
        setAttributeInternal(SUMMARY, value);
    }

    /**
     * Gets the attribute value for WhatsNewMonths using the alias name WhatsNewMonths.
     * @return the WhatsNewMonths
     */
    public BigDecimal getWhatsNewMonths() {
        return (BigDecimal) getAttributeInternal(WHATSNEWMONTHS);
    }

    /**
     * Sets <code>value</code> as attribute value for WhatsNewMonths using the alias name WhatsNewMonths.
     * @param value value to set the WhatsNewMonths
     */
    public void setWhatsNewMonths(BigDecimal value) {
        setAttributeInternal(WHATSNEWMONTHS, value);
    }

    /**
     * Gets the attribute value for approverId using the alias name approverId.
     * @return the approverId
     */
    public String getapproverId() {
        return (String) getAttributeInternal(APPROVERID);
    }

    /**
     * Sets <code>value</code> as attribute value for approverId using the alias name approverId.
     * @param value value to set the approverId
     */
    public void setapproverId(String value) {
        setAttributeInternal(APPROVERID, value);
    }

    /**
     * Gets the attribute value for createdBy using the alias name createdBy.
     * @return the createdBy
     */
    public String getcreatedBy() {
        return (String) getAttributeInternal(CREATEDBY);
    }

    /**
     * Sets <code>value</code> as attribute value for createdBy using the alias name createdBy.
     * @param value value to set the createdBy
     */
    public void setcreatedBy(String value) {
        setAttributeInternal(CREATEDBY, value);
    }

    /**
     * Gets the attribute value for isActive using the alias name isActive.
     * @return the isActive
     */
    public Boolean getisActive() {
        return (Boolean) getAttributeInternal(ISACTIVE);
    }

    /**
     * Sets <code>value</code> as attribute value for isActive using the alias name isActive.
     * @param value value to set the isActive
     */
    public void setisActive(Boolean value) {
        setAttributeInternal(ISACTIVE, value);
    }

    /**
     * Gets the attribute value for isAmendmentRecord using the alias name isAmendmentRecord.
     * @return the isAmendmentRecord
     */
    public Boolean getisAmendmentRecord() {
        return (Boolean) getAttributeInternal(ISAMENDMENTRECORD);
    }

    /**
     * Sets <code>value</code> as attribute value for isAmendmentRecord using the alias name isAmendmentRecord.
     * @param value value to set the isAmendmentRecord
     */
    public void setisAmendmentRecord(Boolean value) {
        setAttributeInternal(ISAMENDMENTRECORD, value);
    }

    /**
     * Gets the attribute value for itemId using the alias name itemId.
     * @return the itemId
     */
    public String getitemId() {
        return (String) getAttributeInternal(ITEMID);
    }

    /**
     * Sets <code>value</code> as attribute value for itemId using the alias name itemId.
     * @param value value to set the itemId
     */
    public void setitemId(String value) {
        setAttributeInternal(ITEMID, value);
    }

    /**
     * Gets the attribute value for keywords using the alias name keywords.
     * @return the keywords
     */
    public String getkeywords() {
        return (String) getAttributeInternal(KEYWORDS);
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
        return (Integer) getAttributeInternal(PARTITIONTYPEID);
    }

    /**
     * Sets <code>value</code> as attribute value for partitionTypeId using the alias name partitionTypeId.
     * @param value value to set the partitionTypeId
     */
    public void setpartitionTypeId(Integer value) {
        setAttributeInternal(PARTITIONTYPEID, value);
    }

    /**
     * Gets the attribute value for policyId using the alias name policyId.
     * @return the policyId
     */
    public String getpolicyId() {
        return (String) getAttributeInternal(POLICYID);
    }

    /**
     * Sets <code>value</code> as attribute value for policyId using the alias name policyId.
     * @param value value to set the policyId
     */
    public void setpolicyId(String value) {
        setAttributeInternal(POLICYID, value);
    }

    /**
     * Gets the attribute value for system using the alias name system.
     * @return the system
     */
    public String getsystem() {
        return (String) getAttributeInternal(SYSTEM);
    }

    /**
     * Sets <code>value</code> as attribute value for system using the alias name system.
     * @param value value to set the system
     */
    public void setsystem(String value) {
        setAttributeInternal(SYSTEM, value);
    }

    /**
     * Gets the attribute value for updatedBy using the alias name updatedBy.
     * @return the updatedBy
     */
    public String getupdatedBy() {
        return (String) getAttributeInternal(UPDATEDBY);
    }

    /**
     * Sets <code>value</code> as attribute value for updatedBy using the alias name updatedBy.
     * @param value value to set the updatedBy
     */
    public void setupdatedBy(String value) {
        setAttributeInternal(UPDATEDBY, value);
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