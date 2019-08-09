package mybatis.bean;

/**
 * @Description TODO
 * @Author wx
 * @DATE 2019/7/23 16:51
 **/
public class GetParams {
    private int proId;
    private int[] manualId;

    public int getProId() {
        return proId;
    }

    public void setProId(int proId) {
        this.proId = proId;
    }

    public int[] getManualId() {
        return manualId;
    }

    public void setManualId(int[] manualId) {
        this.manualId = manualId;
    }
}
