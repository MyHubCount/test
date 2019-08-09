package mybatis.bean;


import java.util.Date;


public class SecurityEvent {
    //安全防范主键id
    private String id;
   // 项目id
    private String proId;
   //所属安全类型id
    private Integer manualId;
   //安全类型名称
    private String manualName;
  //作业地点
    private String securityLocale;
  //操作人（数组）
    private String securityOperator;
  //作业内容
    private String assignmentContent;
  //GPS坐标
    private String gpsCoordinate;
  //创建时间
    private Date createTime;
   //创建人
    private String createUser;
   //创建状态
    private Boolean completeStatus;
  //作业时间
    private Date assignmentTime;

    //次数
    private int totalTimes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }

    public Integer getManualId() {
        return manualId;
    }

    public void setManualId(Integer manualId) {
        this.manualId = manualId;
    }

    public String getManualName() {
        return manualName;
    }

    public void setManualName(String manualName) {
        this.manualName = manualName;
    }

    public String getSecurityLocale() {
        return securityLocale;
    }

    public void setSecurityLocale(String securityLocale) {
        this.securityLocale = securityLocale;
    }

    public String getSecurityOperator() {
        return securityOperator;
    }

    public void setSecurityOperator(String securityOperator) {
        this.securityOperator = securityOperator;
    }

    public String getAssignmentContent() {
        return assignmentContent;
    }

    public void setAssignmentContent(String assignmentContent) {
        this.assignmentContent = assignmentContent;
    }

    public String getGpsCoordinate() {
        return gpsCoordinate;
    }

    public void setGpsCoordinate(String gpsCoordinate) {
        this.gpsCoordinate = gpsCoordinate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Boolean getCompleteStatus() {
        return completeStatus;
    }

    public void setCompleteStatus(Boolean completeStatus) {
        this.completeStatus = completeStatus;
    }

    public Date getAssignmentTime() {
        return assignmentTime;
    }

    public void setAssignmentTime(Date assignmentTime) {
        this.assignmentTime = assignmentTime;
    }

    public int getTotalTimes() {
        return totalTimes;
    }

    public void setTotalTimes(int totalTimes) {
        this.totalTimes = totalTimes;
    }
}