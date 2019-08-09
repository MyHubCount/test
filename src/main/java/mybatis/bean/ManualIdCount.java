package mybatis.bean;

import java.util.List;

/**
 * @Description TODO
 * @Author wx
 * @DATE 2019/7/23 15:20
 **/
public class ManualIdCount {
   private Integer manualId;
   private List<Integer> viewData;

    public Integer getManualId() {
        return manualId;
    }

    public void setManualId(Integer manualId) {
        this.manualId = manualId;
    }

    public List<Integer> getViewData() {
        return viewData;
    }

    public void setViewData(List<Integer> viewData) {
        this.viewData = viewData;
    }
}
