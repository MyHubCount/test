package mybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author: wangxin *
 * @Date: 2018/7/4 11:00
 * * @Description: *
 */
@Component
public class TimingRefresh {
    //        @Autowired
//        PersonalConfirmedListService personalConfirmedListService;
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Scheduled(cron = "${user.env.scheduled.jcTime}")
    public void timerRate() {
        System.out.println("10分钟执行： " + dateFormat.format(new Date()));

    }

//        public void timingRefresh() {
//            List<ConfirmedList> confirmedLists = unusedTicket();
//            for (ConfirmedList confirmedList : confirmedLists) {
//                //1.查询pnr
//                String pnr = confirmedList.getPnr();
//                //2.通过pnr查询确认单状态
//                String useStatus = null;
//                String status = null;
//                List<String> usedList = new ArrayList<>();
//                usedList.add("USED/FLOWN");
//                usedList.add("REFUNDED");
//                usedList.add("FIM EXCH");
//                usedList.add("VOID");
//                if (usedList.contains(useStatus)) {
//                    status = "已使用";
//                } else {
//                    status = "未使用";
//                }
//                Integer id = confirmedList.getId();
//                //3.更新状态
//                personalConfirmedListService.updateUseStatus(id, status);
//            }
//        }
//
//        //查询本地未使用的确认单
//        public List<ConfirmedList> unusedTicket() {
//            List<ConfirmedList> list = personalConfirmedListService.getUnusedTicket();
//            return list;
//        }
//
//        public List<Map<String, Object>> getPersonConfirmedList() {
//            List<Map<String, Object>> list = personalConfirmedListService.getPersonConfirmedList();
//            return list;
//        }
}




