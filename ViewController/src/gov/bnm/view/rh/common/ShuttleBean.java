package gov.bnm.view.rh.common;

import oracle.adf.view.rich.component.rich.data.RichTable;

public class ShuttleBean implements IShuttleBean {
    
    private RichTable t1;
    private RichTable t2;
    private RichTable t3;
    private RichTable t4;
    private RichTable t5;
    private RichTable t6;
    private RichTable t7;
    private RichTable t8;
    private RichTable t9;
    private RichTable t10;
    private RichTable t11;
    private RichTable t12;
    private RichTable t13;
    private RichTable t14;
    private RichTable t15;
    private RichTable t16;

    // Relavant Act Start
    public void addRelavantAct() {
        IShuttleInfo userInfo = new ShuttleInfo();
        userInfo.addRelavantActInfo(this);
    }

    public void removeRelavantAct() {
        IShuttleInfo userInfo = new ShuttleInfo();
        userInfo.removeRelavantActInfo(this);
    }
    // Relavant Act End

    // Issuring Department Start
    public void addIssuringDepartment() {
        IShuttleInfo userInfo = new ShuttleInfo();
        userInfo.addIssuringDepartmentInfo(this);
    }

    public void removeIssuringDepartment() {
        IShuttleInfo userInfo = new ShuttleInfo();
        userInfo.removeIssuringDepartmentInfo(this);
    }
    // IssuringDepartment End
    
    public void addDepartment() {
        IShuttleInfo userInfo = new ShuttleInfo();
        userInfo.addDepPolInfo(this);
    }

    public void removeDepartment() {
        IShuttleInfo userInfo = new ShuttleInfo();
        userInfo.removeDepPolInfo(this);
    }

    public void addAuthors() {
        IShuttleInfo userInfo = new ShuttleInfo();
        userInfo.addAuthPolInfo(this);
    }

    public void removeAuthors() {
        IShuttleInfo userInfo = new ShuttleInfo();
        userInfo.removeAuthPolInfo(this);
    }

    public void addSectors() {
        IShuttleInfo userInfo = new ShuttleInfo();
        userInfo.addSecPolInfo(this);
    }

    public void removeSectors() {
        IShuttleInfo userInfo = new ShuttleInfo();
        userInfo.removeSecPolInfo(this);
    }

    public void addInstitutiontype() {
        IShuttleInfo userInfo = new ShuttleInfo();
        userInfo.addInstPolInfo(this);
    }

    public void removeInstitutiontype() {
        IShuttleInfo userInfo = new ShuttleInfo();
        userInfo.removeInstPolInfo(this);
    }

    public void addOrganization() {
        IShuttleInfo userInfo = new ShuttleInfo();
        userInfo.addOrgPolInfo(this);
    }

    public void removeOrganization() {
        IShuttleInfo userInfo = new ShuttleInfo();
        userInfo.removeOrgPolInfo(this);
    }

    public void addSuperseeded() {
        IShuttleInfo userInfo = new ShuttleInfo();
        userInfo.addSusPolInfo(this);
    }

    public void removeSuperseeded() {
        IShuttleInfo userInfo = new ShuttleInfo();
        userInfo.removeSusPolInfo(this);
    }

    public void addCategory() {
        IShuttleInfo userInfo = new ShuttleInfo();
        userInfo.addCatPolInfo(this);
    }

    public void removeCategory() {
        IShuttleInfo userInfo = new ShuttleInfo();
        userInfo.removeCatPolInfo(this);
    }

    public void setT1(RichTable t1) {
        this.t1 = t1;
    }

    public RichTable getT1() {
        return t1;
    }

    public void setT2(RichTable t2) {
        this.t2 = t2;
    }

    public RichTable getT2() {
        return t2;
    }

    public void setT3(RichTable t3) {
        this.t3 = t3;
    }

    public RichTable getT3() {
        return t3;
    }

    public void setT4(RichTable t4) {
        this.t4 = t4;
    }

    public RichTable getT4() {
        return t4;
    }

    public void setT5(RichTable t5) {
        this.t5 = t5;
    }

    public RichTable getT5() {
        return t5;
    }

    public void setT6(RichTable t6) {
        this.t6 = t6;
    }

    public RichTable getT6() {
        return t6;
    }

    public void setT7(RichTable t7) {
        this.t7 = t7;
    }

    public RichTable getT7() {
        return t7;
    }

    public void setT8(RichTable t8) {
        this.t8 = t8;
    }

    public RichTable getT8() {
        return t8;
    }

    public void setT9(RichTable t9) {
        this.t9 = t9;
    }

    public RichTable getT9() {
        return t9;
    }

    public void setT10(RichTable t10) {
        this.t10 = t10;
    }

    public RichTable getT10() {
        return t10;
    }

    public void setT11(RichTable t11) {
        this.t11 = t11;
    }

    public RichTable getT11() {
        return t11;
    }

    public void setT12(RichTable t12) {
        this.t12 = t12;
    }

    public RichTable getT12() {
        return t12;
    }

    public void setT13(RichTable t13) {
        this.t13 = t13;
    }

    public RichTable getT13() {
        return t13;
    }

    public void setT14(RichTable t14) {
        this.t14 = t14;
    }

    public RichTable getT14() {
        return t14;
    }
    
    public void setT15(RichTable t15) {
        this.t15 = t15;
    }

    public RichTable getT15() {
        return t15;
    }
    
    public void setT16(RichTable t16) {
        this.t16 = t16;
    }

    public RichTable getT16() {
        return t16;
    }
}
