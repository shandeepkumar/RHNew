package gov.bnm.view.rh.common;

public interface IShuttleInfo {
    
    public String addDepPolInfo(IShuttleBean depPolBean);

    public String removeDepPolInfo(IShuttleBean depPolBean);

    public String addAuthPolInfo(IShuttleBean depPolBean);

    public String removeAuthPolInfo(IShuttleBean depPolBean);

    public String addSecPolInfo(IShuttleBean depPolBean);

    public String removeSecPolInfo(IShuttleBean depPolBean);

    public String addInstPolInfo(IShuttleBean depPolBean);

    public String removeInstPolInfo(IShuttleBean depPolBean);

    public String addOrgPolInfo(IShuttleBean depPolBean);

    public String removeOrgPolInfo(IShuttleBean depPolBean);

    public String addSusPolInfo(IShuttleBean depPolBean);

    public String removeSusPolInfo(IShuttleBean depPolBean);

    public String addCatPolInfo(IShuttleBean depPolBean);

    public String removeCatPolInfo(IShuttleBean depPolBean);
    
    public String addRelavantActInfo(IShuttleBean shuttleBean);

    public String removeRelavantActInfo(IShuttleBean shuttleBean);

    public String addIssuringDepartmentInfo(ShuttleBean depPolBean);
    
    public String removeIssuringDepartmentInfo(ShuttleBean depPolBean);
}
