package gov.bnm.rh.views;

import java.sql.Timestamp;

import oracle.jbo.Row;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Jun 11 09:14:02 GMT 2014
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class EnquiryfaqForEnqViewObjRowImpl extends ViewRowImpl {
  /**
   * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
   */
  public enum AttributesEnum {
    Abstract11 {
      public Object get(EnquiryfaqForEnqViewObjRowImpl obj) {
        return obj.getAbstract11();
      }

      public void put(EnquiryfaqForEnqViewObjRowImpl obj, Object value) {
        obj.setAbstract11((String)value);
      }
    }
    ,
    AddField {
      public Object get(EnquiryfaqForEnqViewObjRowImpl obj) {
        return obj.getAddField();
      }

      public void put(EnquiryfaqForEnqViewObjRowImpl obj, Object value) {
        obj.setAddField((String)value);
      }
    }
    ,
    CreatedbyInstitutionId {
      public Object get(EnquiryfaqForEnqViewObjRowImpl obj) {
        return obj.getCreatedbyInstitutionId();
      }

      public void put(EnquiryfaqForEnqViewObjRowImpl obj, Object value) {
        obj.setCreatedbyInstitutionId((String)value);
      }
    }
    ,
    CurrentItemtype {
      public Object get(EnquiryfaqForEnqViewObjRowImpl obj) {
        return obj.getCurrentItemtype();
      }

      public void put(EnquiryfaqForEnqViewObjRowImpl obj, Object value) {
        obj.setCurrentItemtype((String)value);
      }
    }
    ,
    EnquirerBNMRole {
      public Object get(EnquiryfaqForEnqViewObjRowImpl obj) {
        return obj.getEnquirerBNMRole();
      }

      public void put(EnquiryfaqForEnqViewObjRowImpl obj, Object value) {
        obj.setEnquirerBNMRole((String)value);
      }
    }
    ,
    EnquirerFIRole {
      public Object get(EnquiryfaqForEnqViewObjRowImpl obj) {
        return obj.getEnquirerFIRole();
      }

      public void put(EnquiryfaqForEnqViewObjRowImpl obj, Object value) {
        obj.setEnquirerFIRole((String)value);
      }
    }
    ,
    EnquiryFAQId {
      public Object get(EnquiryfaqForEnqViewObjRowImpl obj) {
        return obj.getEnquiryFAQId();
      }

      public void put(EnquiryfaqForEnqViewObjRowImpl obj, Object value) {
        obj.setEnquiryFAQId((String)value);
      }
    }
    ,
    EnquiryOrFaq {
      public Object get(EnquiryfaqForEnqViewObjRowImpl obj) {
        return obj.getEnquiryOrFaq();
      }

      public void put(EnquiryfaqForEnqViewObjRowImpl obj, Object value) {
        obj.setEnquiryOrFaq((String)value);
      }
    }
    ,
    OrigAbstract {
      public Object get(EnquiryfaqForEnqViewObjRowImpl obj) {
        return obj.getOrigAbstract();
      }

      public void put(EnquiryfaqForEnqViewObjRowImpl obj, Object value) {
        obj.setOrigAbstract((String)value);
      }
    }
    ,
    OrigTitle {
      public Object get(EnquiryfaqForEnqViewObjRowImpl obj) {
        return obj.getOrigTitle();
      }

      public void put(EnquiryfaqForEnqViewObjRowImpl obj, Object value) {
        obj.setOrigTitle((String)value);
      }
    }
    ,
    OriginType {
      public Object get(EnquiryfaqForEnqViewObjRowImpl obj) {
        return obj.getOriginType();
      }

      public void put(EnquiryfaqForEnqViewObjRowImpl obj, Object value) {
        obj.setOriginType((String)value);
      }
    }
    ,
    OriginalItemtype {
      public Object get(EnquiryfaqForEnqViewObjRowImpl obj) {
        return obj.getOriginalItemtype();
      }

      public void put(EnquiryfaqForEnqViewObjRowImpl obj, Object value) {
        obj.setOriginalItemtype((String)value);
      }
    }
    ,
    Title {
      public Object get(EnquiryfaqForEnqViewObjRowImpl obj) {
        return obj.getTitle();
      }

      public void put(EnquiryfaqForEnqViewObjRowImpl obj, Object value) {
        obj.setTitle((String)value);
      }
    }
    ,
    approverId {
      public Object get(EnquiryfaqForEnqViewObjRowImpl obj) {
        return obj.getapproverId();
      }

      public void put(EnquiryfaqForEnqViewObjRowImpl obj, Object value) {
        obj.setapproverId((String)value);
      }
    }
    ,
    createDate {
      public Object get(EnquiryfaqForEnqViewObjRowImpl obj) {
        return obj.getcreateDate();
      }

      public void put(EnquiryfaqForEnqViewObjRowImpl obj, Object value) {
        obj.setcreateDate((Timestamp)value);
      }
    }
    ,
    createdBy {
      public Object get(EnquiryfaqForEnqViewObjRowImpl obj) {
        return obj.getcreatedBy();
      }

      public void put(EnquiryfaqForEnqViewObjRowImpl obj, Object value) {
        obj.setcreatedBy((String)value);
      }
    }
    ,
    datePromoted {
      public Object get(EnquiryfaqForEnqViewObjRowImpl obj) {
        return obj.getdatePromoted();
      }

      public void put(EnquiryfaqForEnqViewObjRowImpl obj, Object value) {
        obj.setdatePromoted((Timestamp)value);
      }
    }
    ,
    enquiryStatus {
      public Object get(EnquiryfaqForEnqViewObjRowImpl obj) {
        return obj.getenquiryStatus();
      }

      public void put(EnquiryfaqForEnqViewObjRowImpl obj, Object value) {
        obj.setenquiryStatus((String)value);
      }
    }
    ,
    faqStatus {
      public Object get(EnquiryfaqForEnqViewObjRowImpl obj) {
        return obj.getfaqStatus();
      }

      public void put(EnquiryfaqForEnqViewObjRowImpl obj, Object value) {
        obj.setfaqStatus((String)value);
      }
    }
    ,
    isInternalExternal {
      public Object get(EnquiryfaqForEnqViewObjRowImpl obj) {
        return obj.getisInternalExternal();
      }

      public void put(EnquiryfaqForEnqViewObjRowImpl obj, Object value) {
        obj.setisInternalExternal((String)value);
      }
    }
    ,
    itemId {
      public Object get(EnquiryfaqForEnqViewObjRowImpl obj) {
        return obj.getitemId();
      }

      public void put(EnquiryfaqForEnqViewObjRowImpl obj, Object value) {
        obj.setitemId((String)value);
      }
    }
    ,
    readCounter {
      public Object get(EnquiryfaqForEnqViewObjRowImpl obj) {
        return obj.getreadCounter();
      }

      public void put(EnquiryfaqForEnqViewObjRowImpl obj, Object value) {
        obj.setreadCounter((Integer)value);
      }
    }
    ,
    requiredResponseDate {
      public Object get(EnquiryfaqForEnqViewObjRowImpl obj) {
        return obj.getrequiredResponseDate();
      }

      public void put(EnquiryfaqForEnqViewObjRowImpl obj, Object value) {
        obj.setrequiredResponseDate((Timestamp)value);
      }
    }
    ,
    sharingOption {
      public Object get(EnquiryfaqForEnqViewObjRowImpl obj) {
        return obj.getsharingOption();
      }

      public void put(EnquiryfaqForEnqViewObjRowImpl obj, Object value) {
        obj.setsharingOption((String)value);
      }
    }
    ,
    updateDate {
      public Object get(EnquiryfaqForEnqViewObjRowImpl obj) {
        return obj.getupdateDate();
      }

      public void put(EnquiryfaqForEnqViewObjRowImpl obj, Object value) {
        obj.setupdateDate((Timestamp)value);
      }
    }
    ,
    updatedBy {
      public Object get(EnquiryfaqForEnqViewObjRowImpl obj) {
        return obj.getupdatedBy();
      }

      public void put(EnquiryfaqForEnqViewObjRowImpl obj, Object value) {
        obj.setupdatedBy((String)value);
      }
    }
    ,
    version {
      public Object get(EnquiryfaqForEnqViewObjRowImpl obj) {
        return obj.getversion();
      }

      public void put(EnquiryfaqForEnqViewObjRowImpl obj, Object value) {
        obj.setversion((Integer)value);
      }
    }
    ,
    IssuingDepartment {
      public Object get(EnquiryfaqForEnqViewObjRowImpl obj) {
        return obj.getIssuingDepartment();
      }

      public void put(EnquiryfaqForEnqViewObjRowImpl obj, Object value) {
        obj.setIssuingDepartment((String)value);
      }
    }
    ,
    PolicyTitle {
      public Object get(EnquiryfaqForEnqViewObjRowImpl obj) {
        return obj.getPolicyTitle();
      }

      public void put(EnquiryfaqForEnqViewObjRowImpl obj, Object value) {
        obj.setPolicyTitle((String)value);
      }
    }
    ,
    RefNo {
      public Object get(EnquiryfaqForEnqViewObjRowImpl obj) {
        return obj.getRefNo();
      }

      public void put(EnquiryfaqForEnqViewObjRowImpl obj, Object value) {
        obj.setRefNo((String)value);
      }
    }
    ,
    InternalUserName {
      public Object get(EnquiryfaqForEnqViewObjRowImpl obj) {
        return obj.getInternalUserName();
      }

      public void put(EnquiryfaqForEnqViewObjRowImpl obj, Object value) {
        obj.setInternalUserName((String)value);
      }
    }
    ,
    InternalUserDepName {
      public Object get(EnquiryfaqForEnqViewObjRowImpl obj) {
        return obj.getInternalUserDepName();
      }

      public void put(EnquiryfaqForEnqViewObjRowImpl obj, Object value) {
        obj.setInternalUserDepName((String)value);
      }
    }
    ,
    ExternalUserName {
      public Object get(EnquiryfaqForEnqViewObjRowImpl obj) {
        return obj.getExternalUserName();
      }

      public void put(EnquiryfaqForEnqViewObjRowImpl obj, Object value) {
        obj.setExternalUserName((String)value);
      }
    }
    ,
    ExternalUserOrgName {
      public Object get(EnquiryfaqForEnqViewObjRowImpl obj) {
        return obj.getExternalUserOrgName();
      }

      public void put(EnquiryfaqForEnqViewObjRowImpl obj, Object value) {
        obj.setExternalUserOrgName((String)value);
      }
    }
    ,
    RespondedBy {
      public Object get(EnquiryfaqForEnqViewObjRowImpl obj) {
        return obj.getRespondedBy();
      }

      public void put(EnquiryfaqForEnqViewObjRowImpl obj, Object value) {
        obj.setRespondedBy((String)value);
      }
    }
    ,
    PolicyView {
      public Object get(EnquiryfaqForEnqViewObjRowImpl obj) {
        return obj.getPolicyView();
      }

      public void put(EnquiryfaqForEnqViewObjRowImpl obj, Object value) {
        obj.setAttributeInternal(index(), value);
      }
    }
    ,
    InternaluserView {
      public Object get(EnquiryfaqForEnqViewObjRowImpl obj) {
        return obj.getInternaluserView();
      }

      public void put(EnquiryfaqForEnqViewObjRowImpl obj, Object value) {
        obj.setAttributeInternal(index(), value);
      }
    }
    ,
    ExternaluserView {
      public Object get(EnquiryfaqForEnqViewObjRowImpl obj) {
        return obj.getExternaluserView();
      }

      public void put(EnquiryfaqForEnqViewObjRowImpl obj, Object value) {
        obj.setAttributeInternal(index(), value);
      }
    }
    ,
    InternaluserApprovView {
      public Object get(EnquiryfaqForEnqViewObjRowImpl obj) {
        return obj.getInternaluserApprovView();
      }

      public void put(EnquiryfaqForEnqViewObjRowImpl obj, Object value) {
        obj.setAttributeInternal(index(), value);
      }
    }
    ;
    private static AttributesEnum[] vals = null;
    private static final int firstIndex = 0;

    public abstract Object get(EnquiryfaqForEnqViewObjRowImpl object);

    public abstract void put(EnquiryfaqForEnqViewObjRowImpl object,
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


  public static final int ABSTRACT11 = AttributesEnum.Abstract11.index();
  public static final int ADDFIELD = AttributesEnum.AddField.index();
  public static final int CREATEDBYINSTITUTIONID = AttributesEnum.CreatedbyInstitutionId.index();
  public static final int CURRENTITEMTYPE = AttributesEnum.CurrentItemtype.index();
  public static final int ENQUIRERBNMROLE = AttributesEnum.EnquirerBNMRole.index();
  public static final int ENQUIRERFIROLE = AttributesEnum.EnquirerFIRole.index();
  public static final int ENQUIRYFAQID = AttributesEnum.EnquiryFAQId.index();
  public static final int ENQUIRYORFAQ = AttributesEnum.EnquiryOrFaq.index();
  public static final int ORIGABSTRACT = AttributesEnum.OrigAbstract.index();
  public static final int ORIGTITLE = AttributesEnum.OrigTitle.index();
  public static final int ORIGINTYPE = AttributesEnum.OriginType.index();
  public static final int ORIGINALITEMTYPE = AttributesEnum.OriginalItemtype.index();
  public static final int TITLE = AttributesEnum.Title.index();
  public static final int APPROVERID = AttributesEnum.approverId.index();
  public static final int CREATEDATE = AttributesEnum.createDate.index();
  public static final int CREATEDBY = AttributesEnum.createdBy.index();
  public static final int DATEPROMOTED = AttributesEnum.datePromoted.index();
  public static final int ENQUIRYSTATUS = AttributesEnum.enquiryStatus.index();
  public static final int FAQSTATUS = AttributesEnum.faqStatus.index();
  public static final int ISINTERNALEXTERNAL = AttributesEnum.isInternalExternal.index();
  public static final int ITEMID = AttributesEnum.itemId.index();
  public static final int READCOUNTER = AttributesEnum.readCounter.index();
  public static final int REQUIREDRESPONSEDATE = AttributesEnum.requiredResponseDate.index();
  public static final int SHARINGOPTION = AttributesEnum.sharingOption.index();
  public static final int UPDATEDATE = AttributesEnum.updateDate.index();
  public static final int UPDATEDBY = AttributesEnum.updatedBy.index();
  public static final int VERSION = AttributesEnum.version.index();
  public static final int ISSUINGDEPARTMENT = AttributesEnum.IssuingDepartment.index();
  public static final int POLICYTITLE = AttributesEnum.PolicyTitle.index();
  public static final int REFNO = AttributesEnum.RefNo.index();
  public static final int INTERNALUSERNAME = AttributesEnum.InternalUserName.index();
  public static final int INTERNALUSERDEPNAME = AttributesEnum.InternalUserDepName.index();
  public static final int EXTERNALUSERNAME = AttributesEnum.ExternalUserName.index();
  public static final int EXTERNALUSERORGNAME = AttributesEnum.ExternalUserOrgName.index();
  public static final int RESPONDEDBY = AttributesEnum.RespondedBy.index();
  public static final int POLICYVIEW = AttributesEnum.PolicyView.index();
  public static final int INTERNALUSERVIEW = AttributesEnum.InternaluserView.index();
  public static final int EXTERNALUSERVIEW = AttributesEnum.ExternaluserView.index();
  public static final int INTERNALUSERAPPROVVIEW = AttributesEnum.InternaluserApprovView.index();

  /**
   * This is the default constructor (do not remove).
   */
  public EnquiryfaqForEnqViewObjRowImpl() {
  }

  /**
   * Gets Enquiryfaq entity object.
   * @return the Enquiryfaq
   */
  public EntityImpl getEnquiryfaq() {
    return (EntityImpl)getEntity(0);
  }

  /**
   * Gets the attribute value for Abstract using the alias name Abstract11.
   * @return the Abstract
   */
  public String getAbstract11() {
    return (String) getAttributeInternal(ABSTRACT11);
  }

  /**
   * Sets <code>value</code> as attribute value for Abstract using the alias name Abstract11.
   * @param value value to set the Abstract
   */
  public void setAbstract11(String value) {
    setAttributeInternal(ABSTRACT11, value);
  }

  /**
   * Gets the attribute value for AddField using the alias name AddField.
   * @return the AddField
   */
  public String getAddField() {
    return (String) getAttributeInternal(ADDFIELD);
  }

  /**
   * Sets <code>value</code> as attribute value for AddField using the alias name AddField.
   * @param value value to set the AddField
   */
  public void setAddField(String value) {
    setAttributeInternal(ADDFIELD, value);
  }

  /**
   * Gets the attribute value for CreatedbyInstitutionId using the alias name CreatedbyInstitutionId.
   * @return the CreatedbyInstitutionId
   */
  public String getCreatedbyInstitutionId() {
    return (String) getAttributeInternal(CREATEDBYINSTITUTIONID);
  }

  /**
   * Sets <code>value</code> as attribute value for CreatedbyInstitutionId using the alias name CreatedbyInstitutionId.
   * @param value value to set the CreatedbyInstitutionId
   */
  public void setCreatedbyInstitutionId(String value) {
    setAttributeInternal(CREATEDBYINSTITUTIONID, value);
  }

  /**
   * Gets the attribute value for CurrentItemtype using the alias name CurrentItemtype.
   * @return the CurrentItemtype
   */
  public String getCurrentItemtype() {
    return (String) getAttributeInternal(CURRENTITEMTYPE);
  }

  /**
   * Sets <code>value</code> as attribute value for CurrentItemtype using the alias name CurrentItemtype.
   * @param value value to set the CurrentItemtype
   */
  public void setCurrentItemtype(String value) {
    setAttributeInternal(CURRENTITEMTYPE, value);
  }

  /**
   * Gets the attribute value for EnquirerBNMRole using the alias name EnquirerBNMRole.
   * @return the EnquirerBNMRole
   */
  public String getEnquirerBNMRole() {
    return (String) getAttributeInternal(ENQUIRERBNMROLE);
  }

  /**
   * Sets <code>value</code> as attribute value for EnquirerBNMRole using the alias name EnquirerBNMRole.
   * @param value value to set the EnquirerBNMRole
   */
  public void setEnquirerBNMRole(String value) {
    setAttributeInternal(ENQUIRERBNMROLE, value);
  }

  /**
   * Gets the attribute value for EnquirerFIRole using the alias name EnquirerFIRole.
   * @return the EnquirerFIRole
   */
  public String getEnquirerFIRole() {
    return (String) getAttributeInternal(ENQUIRERFIROLE);
  }

  /**
   * Sets <code>value</code> as attribute value for EnquirerFIRole using the alias name EnquirerFIRole.
   * @param value value to set the EnquirerFIRole
   */
  public void setEnquirerFIRole(String value) {
    setAttributeInternal(ENQUIRERFIROLE, value);
  }

  /**
   * Gets the attribute value for EnquiryFAQId using the alias name EnquiryFAQId.
   * @return the EnquiryFAQId
   */
  public String getEnquiryFAQId() {
    return (String) getAttributeInternal(ENQUIRYFAQID);
  }

  /**
   * Sets <code>value</code> as attribute value for EnquiryFAQId using the alias name EnquiryFAQId.
   * @param value value to set the EnquiryFAQId
   */
  public void setEnquiryFAQId(String value) {
    setAttributeInternal(ENQUIRYFAQID, value);
  }

  /**
   * Gets the attribute value for EnquiryOrFaq using the alias name EnquiryOrFaq.
   * @return the EnquiryOrFaq
   */
  public String getEnquiryOrFaq() {
    return (String) getAttributeInternal(ENQUIRYORFAQ);
  }

  /**
   * Sets <code>value</code> as attribute value for EnquiryOrFaq using the alias name EnquiryOrFaq.
   * @param value value to set the EnquiryOrFaq
   */
  public void setEnquiryOrFaq(String value) {
    setAttributeInternal(ENQUIRYORFAQ, value);
  }

  /**
   * Gets the attribute value for OrigAbstract using the alias name OrigAbstract.
   * @return the OrigAbstract
   */
  public String getOrigAbstract() {
    return (String) getAttributeInternal(ORIGABSTRACT);
  }

  /**
   * Sets <code>value</code> as attribute value for OrigAbstract using the alias name OrigAbstract.
   * @param value value to set the OrigAbstract
   */
  public void setOrigAbstract(String value) {
    setAttributeInternal(ORIGABSTRACT, value);
  }

  /**
   * Gets the attribute value for OrigTitle using the alias name OrigTitle.
   * @return the OrigTitle
   */
  public String getOrigTitle() {
    return (String) getAttributeInternal(ORIGTITLE);
  }

  /**
   * Sets <code>value</code> as attribute value for OrigTitle using the alias name OrigTitle.
   * @param value value to set the OrigTitle
   */
  public void setOrigTitle(String value) {
    setAttributeInternal(ORIGTITLE, value);
  }

  /**
   * Gets the attribute value for OriginType using the alias name OriginType.
   * @return the OriginType
   */
  public String getOriginType() {
    return (String) getAttributeInternal(ORIGINTYPE);
  }

  /**
   * Sets <code>value</code> as attribute value for OriginType using the alias name OriginType.
   * @param value value to set the OriginType
   */
  public void setOriginType(String value) {
    setAttributeInternal(ORIGINTYPE, value);
  }

  /**
   * Gets the attribute value for OriginalItemtype using the alias name OriginalItemtype.
   * @return the OriginalItemtype
   */
  public String getOriginalItemtype() {
    return (String) getAttributeInternal(ORIGINALITEMTYPE);
  }

  /**
   * Sets <code>value</code> as attribute value for OriginalItemtype using the alias name OriginalItemtype.
   * @param value value to set the OriginalItemtype
   */
  public void setOriginalItemtype(String value) {
    setAttributeInternal(ORIGINALITEMTYPE, value);
  }

  /**
   * Gets the attribute value for Title using the alias name Title.
   * @return the Title
   */
  public String getTitle() {
    return (String) getAttributeInternal(TITLE);
  }

  /**
   * Sets <code>value</code> as attribute value for Title using the alias name Title.
   * @param value value to set the Title
   */
  public void setTitle(String value) {
    setAttributeInternal(TITLE, value);
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
   * Gets the attribute value for createDate using the alias name createDate.
   * @return the createDate
   */
  public Timestamp getcreateDate() {
    return (Timestamp) getAttributeInternal(CREATEDATE);
  }

  /**
   * Sets <code>value</code> as attribute value for createDate using the alias name createDate.
   * @param value value to set the createDate
   */
  public void setcreateDate(Timestamp value) {
    setAttributeInternal(CREATEDATE, value);
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
   * Gets the attribute value for datePromoted using the alias name datePromoted.
   * @return the datePromoted
   */
  public Timestamp getdatePromoted() {
    return (Timestamp) getAttributeInternal(DATEPROMOTED);
  }

  /**
   * Sets <code>value</code> as attribute value for datePromoted using the alias name datePromoted.
   * @param value value to set the datePromoted
   */
  public void setdatePromoted(Timestamp value) {
    setAttributeInternal(DATEPROMOTED, value);
  }

  /**
   * Gets the attribute value for enquiryStatus using the alias name enquiryStatus.
   * @return the enquiryStatus
   */
  public String getenquiryStatus() {
    return (String) getAttributeInternal(ENQUIRYSTATUS);
  }

  /**
   * Sets <code>value</code> as attribute value for enquiryStatus using the alias name enquiryStatus.
   * @param value value to set the enquiryStatus
   */
  public void setenquiryStatus(String value) {
    setAttributeInternal(ENQUIRYSTATUS, value);
  }

  /**
   * Gets the attribute value for faqStatus using the alias name faqStatus.
   * @return the faqStatus
   */
  public String getfaqStatus() {
    return (String) getAttributeInternal(FAQSTATUS);
  }

  /**
   * Sets <code>value</code> as attribute value for faqStatus using the alias name faqStatus.
   * @param value value to set the faqStatus
   */
  public void setfaqStatus(String value) {
    setAttributeInternal(FAQSTATUS, value);
  }

  /**
   * Gets the attribute value for isInternalExternal using the alias name isInternalExternal.
   * @return the isInternalExternal
   */
  public String getisInternalExternal() {
    return (String) getAttributeInternal(ISINTERNALEXTERNAL);
  }

  /**
   * Sets <code>value</code> as attribute value for isInternalExternal using the alias name isInternalExternal.
   * @param value value to set the isInternalExternal
   */
  public void setisInternalExternal(String value) {
    setAttributeInternal(ISINTERNALEXTERNAL, value);
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
   * Gets the attribute value for readCounter using the alias name readCounter.
   * @return the readCounter
   */
  public Integer getreadCounter() {
    return (Integer) getAttributeInternal(READCOUNTER);
  }

  /**
   * Sets <code>value</code> as attribute value for readCounter using the alias name readCounter.
   * @param value value to set the readCounter
   */
  public void setreadCounter(Integer value) {
    setAttributeInternal(READCOUNTER, value);
  }

  /**
   * Gets the attribute value for requiredResponseDate using the alias name requiredResponseDate.
   * @return the requiredResponseDate
   */
  public Timestamp getrequiredResponseDate() {
    return (Timestamp) getAttributeInternal(REQUIREDRESPONSEDATE);
  }

  /**
   * Sets <code>value</code> as attribute value for requiredResponseDate using the alias name requiredResponseDate.
   * @param value value to set the requiredResponseDate
   */
  public void setrequiredResponseDate(Timestamp value) {
    setAttributeInternal(REQUIREDRESPONSEDATE, value);
  }

  /**
   * Gets the attribute value for sharingOption using the alias name sharingOption.
   * @return the sharingOption
   */
  public String getsharingOption() {
    return (String) getAttributeInternal(SHARINGOPTION);
  }

  /**
   * Sets <code>value</code> as attribute value for sharingOption using the alias name sharingOption.
   * @param value value to set the sharingOption
   */
  public void setsharingOption(String value) {
    setAttributeInternal(SHARINGOPTION, value);
  }

  /**
   * Gets the attribute value for updateDate using the alias name updateDate.
   * @return the updateDate
   */
  public Timestamp getupdateDate() {
    return (Timestamp) getAttributeInternal(UPDATEDATE);
  }

  /**
   * Sets <code>value</code> as attribute value for updateDate using the alias name updateDate.
   * @param value value to set the updateDate
   */
  public void setupdateDate(Timestamp value) {
    setAttributeInternal(UPDATEDATE, value);
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
   * Gets the attribute value for version using the alias name version.
   * @return the version
   */
  public Integer getversion() {
    return (Integer) getAttributeInternal(VERSION);
  }

  /**
   * Sets <code>value</code> as attribute value for version using the alias name version.
   * @param value value to set the version
   */
  public void setversion(Integer value) {
    setAttributeInternal(VERSION, value);
  }

  /**
   * Gets the attribute value for the calculated attribute IssuingDepartment.
   * @return the IssuingDepartment
   */
  public String getIssuingDepartment() {
    return (String) getAttributeInternal(ISSUINGDEPARTMENT);
  }

  /**
   * Sets <code>value</code> as the attribute value for the calculated attribute IssuingDepartment.
   * @param value value to set the  IssuingDepartment
   */
  public void setIssuingDepartment(String value) {
    setAttributeInternal(ISSUINGDEPARTMENT, value);
  }

  /**
   * Gets the attribute value for the calculated attribute PolicyTitle.
   * @return the PolicyTitle
   */
  public String getPolicyTitle() {
    return (String) getAttributeInternal(POLICYTITLE);
  }

  /**
   * Sets <code>value</code> as the attribute value for the calculated attribute PolicyTitle.
   * @param value value to set the  PolicyTitle
   */
  public void setPolicyTitle(String value) {
    setAttributeInternal(POLICYTITLE, value);
  }

  /**
   * Gets the attribute value for the calculated attribute RefNo.
   * @return the RefNo
   */
  public String getRefNo() {
    return (String) getAttributeInternal(REFNO);
  }

  /**
   * Sets <code>value</code> as the attribute value for the calculated attribute RefNo.
   * @param value value to set the  RefNo
   */
  public void setRefNo(String value) {
    setAttributeInternal(REFNO, value);
  }

  /**
   * Gets the attribute value for the calculated attribute InternalUserName.
   * @return the InternalUserName
   */
  public String getInternalUserName() {
    return (String) getAttributeInternal(INTERNALUSERNAME);
  }

  /**
   * Sets <code>value</code> as the attribute value for the calculated attribute InternalUserName.
   * @param value value to set the  InternalUserName
   */
  public void setInternalUserName(String value) {
    setAttributeInternal(INTERNALUSERNAME, value);
  }

  /**
   * Gets the attribute value for the calculated attribute InternalUserDepName.
   * @return the InternalUserDepName
   */
  public String getInternalUserDepName() {
    return (String) getAttributeInternal(INTERNALUSERDEPNAME);
  }

  /**
   * Sets <code>value</code> as the attribute value for the calculated attribute InternalUserDepName.
   * @param value value to set the  InternalUserDepName
   */
  public void setInternalUserDepName(String value) {
    setAttributeInternal(INTERNALUSERDEPNAME, value);
  }

  /**
   * Gets the attribute value for the calculated attribute ExternalUserName.
   * @return the ExternalUserName
   */
  public String getExternalUserName() {
    return (String) getAttributeInternal(EXTERNALUSERNAME);
  }

  /**
   * Sets <code>value</code> as the attribute value for the calculated attribute ExternalUserName.
   * @param value value to set the  ExternalUserName
   */
  public void setExternalUserName(String value) {
    setAttributeInternal(EXTERNALUSERNAME, value);
  }

  /**
   * Gets the attribute value for the calculated attribute ExternalUserOrgName.
   * @return the ExternalUserOrgName
   */
  public String getExternalUserOrgName() {
    return (String) getAttributeInternal(EXTERNALUSERORGNAME);
  }

  /**
   * Sets <code>value</code> as the attribute value for the calculated attribute ExternalUserOrgName.
   * @param value value to set the  ExternalUserOrgName
   */
  public void setExternalUserOrgName(String value) {
    setAttributeInternal(EXTERNALUSERORGNAME, value);
  }

  /**
   * Gets the attribute value for the calculated attribute RespondedBy.
   * @return the RespondedBy
   */
  public String getRespondedBy() {
    return (String) getAttributeInternal(RESPONDEDBY);
  }

  /**
   * Sets <code>value</code> as the attribute value for the calculated attribute RespondedBy.
   * @param value value to set the  RespondedBy
   */
  public void setRespondedBy(String value) {
    setAttributeInternal(RESPONDEDBY, value);
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
   * Gets the associated <code>Row</code> using master-detail link InternaluserView.
   */
  public Row getInternaluserView() {
    return (Row)getAttributeInternal(INTERNALUSERVIEW);
  }

  /**
   * Sets the master-detail link InternaluserView between this object and <code>value</code>.
   */
  public void setInternaluserView(Row value) {
    setAttributeInternal(INTERNALUSERVIEW, value);
  }

  /**
   * Gets the associated <code>Row</code> using master-detail link ExternaluserView.
   */
  public Row getExternaluserView() {
    return (Row)getAttributeInternal(EXTERNALUSERVIEW);
  }

  /**
   * Sets the master-detail link ExternaluserView between this object and <code>value</code>.
   */
  public void setExternaluserView(Row value) {
    setAttributeInternal(EXTERNALUSERVIEW, value);
  }

  /**
   * Gets the associated <code>Row</code> using master-detail link InternaluserApprovView.
   */
  public Row getInternaluserApprovView() {
    return (Row)getAttributeInternal(INTERNALUSERAPPROVVIEW);
  }

  /**
   * Sets the master-detail link InternaluserApprovView between this object and <code>value</code>.
   */
  public void setInternaluserApprovView(Row value) {
    setAttributeInternal(INTERNALUSERAPPROVVIEW, value);
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
