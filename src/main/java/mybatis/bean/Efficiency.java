package mybatis.bean;


import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


//提质增效实体类
public class Efficiency {
    //效能表主键id
    private String id;

    private Date date;
//设备利用率
    private Double utilizationOfEqu;
//材料利用率
    private Double utilizationOfRatio;
//进度管理效能
    private Integer progressManageEff;
//场地规划效能
    private Integer sitePlanEff;
//生态环保效能
    private Integer effOfEcoProtection;
//人均产值
    private Integer perCapitaOutput;


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getUtilizationOfEqu() {
        return utilizationOfEqu;
    }

    public void setUtilizationOfEqu(Double utilizationOfEqu) {
        this.utilizationOfEqu = utilizationOfEqu;
    }

    public Double getUtilizationOfRatio() {
        return utilizationOfRatio;
    }

    public void setUtilizationOfRatio(Double utilizationOfRatio) {
        this.utilizationOfRatio = utilizationOfRatio;
    }

    public Integer getProgressManageEff() {
        return progressManageEff;
    }

    public void setProgressManageEff(Integer progressManageEff) {
        this.progressManageEff = progressManageEff;
    }

    public Integer getSitePlanEff() {
        return sitePlanEff;
    }

    public void setSitePlanEff(Integer sitePlanEff) {
        this.sitePlanEff = sitePlanEff;
    }

    public Integer getEffOfEcoProtection() {
        return effOfEcoProtection;
    }

    public void setEffOfEcoProtection(Integer effOfEcoProtection) {
        this.effOfEcoProtection = effOfEcoProtection;
    }

    public Integer getPerCapitaOutput() {
        return perCapitaOutput;
    }

    public void setPerCapitaOutput(Integer perCapitaOutput) {
        this.perCapitaOutput = perCapitaOutput;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}