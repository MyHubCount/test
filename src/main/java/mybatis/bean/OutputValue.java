package mybatis.bean;

import java.util.Date;

public class OutputValue {
    private String ovId;

    private String proId;

    private Date ovTime;

    private Integer realityOutputValue;

    private Integer expectOutputValue;

    private Integer realitySchedule;

    private Integer expectSchedule;

    public String getOvId() {
        return ovId;
    }

    public void setOvId(String ovId) {
        this.ovId = ovId == null ? null : ovId.trim();
    }

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId == null ? null : proId.trim();
    }

    public Date getOvTime() {
        return ovTime;
    }

    public void setOvTime(Date ovTime) {
        this.ovTime = ovTime;
    }

    public Integer getRealityOutputValue() {
        return realityOutputValue;
    }

    public void setRealityOutputValue(Integer realityOutputValue) {
        this.realityOutputValue = realityOutputValue;
    }

    public Integer getExpectOutputValue() {
        return expectOutputValue;
    }

    public void setExpectOutputValue(Integer expectOutputValue) {
        this.expectOutputValue = expectOutputValue;
    }

    public Integer getRealitySchedule() {
        return realitySchedule;
    }

    public void setRealitySchedule(Integer realitySchedule) {
        this.realitySchedule = realitySchedule;
    }

    public Integer getExpectSchedule() {
        return expectSchedule;
    }

    public void setExpectSchedule(Integer expectSchedule) {
        this.expectSchedule = expectSchedule;
    }
}