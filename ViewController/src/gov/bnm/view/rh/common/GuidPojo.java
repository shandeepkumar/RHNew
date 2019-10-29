package gov.bnm.view.rh.common;

import gov.bnm.view.rh.utils.RandomGuidUtil;

public class GuidPojo {
    private String guid;

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getGuid() {
        guid = RandomGuidUtil.fnGuidWithTimestamp();
        return guid;
    }
}
