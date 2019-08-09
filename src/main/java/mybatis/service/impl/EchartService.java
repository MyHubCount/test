package mybatis.service.impl;

import mybatis.bean.CountMonth;
import mybatis.bean.ManualIdCount;
import mybatis.dao.EchartMapper;
import mybatis.dao.OutputValueMapper;
import mybatis.dao.SecurityEventMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description TODO
 * @Author wx
 * @DATE 2019/7/16 11:30
 **/
@Service
public class EchartService {

    @Autowired
    EchartMapper echartMapper;

    @Autowired
    SecurityEventMapper securityEventMapper;

    @Autowired
    OutputValueMapper outputValueMapper;

    public Map<String, Object> echart() {

        List<Double> viewData = echartMapper.selectEchart();
        List<Double> viewData2 = echartMapper.selectEchart2();


        List<String> monthView = echartMapper.selectMonth();

        Map<String, Object> resultMap = new HashMap<>();

        resultMap.put("months", monthView);
        resultMap.put("datelist", viewData);

        resultMap.put("months", monthView);
        resultMap.put("datelist2", viewData2);

        return resultMap;
    }


    /* *
     * @Author wx
     * 测试 ： 书写安全防范折线图
     * @return java.util.Map<java.lang.String,java.lang.Object>
     * @Date 2019/7/23 13:58
     */
    public Map<String, Object> echart2(int proId, Integer[] manualId) {
        //拿到安全防范总数量的每个月的数据
        List<Integer> viewData = securityEventMapper.echart2(proId);
       //拿到单个子项目的数据
//        List<Integer> viewData2 = securityEventMapper.selectOneById(proId,manualId);
        //拿到月份
        List<String> monthView = securityEventMapper.selectMonth(proId);
//        //设置返回集合
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("datelist",viewData);
        resultMap.put("months", monthView);
//        resultMap.put("datelist2",viewData2);
        List<ManualIdCount> manualIdCounts = new ArrayList<>();
        for (int i = 0; i < manualId.length; i++) {
            List<CountMonth> countMonths = securityEventMapper.selectCount(proId, manualId[i]);
             //1.8新写法，同下面代码等效
//            List<String> months = countMonths.stream().map(CountMonth::getMmonth).collect(Collectors.toList());

            //将月份的数据重新装入到新的集合中
            List<String> months=new ArrayList<>();
            for (int j=0;j<countMonths.size();j++){
                months.add(countMonths.get(j).getMmonth());
            }
            //遍历集合，将为空的月份的设定次数为0.
            for (String m : monthView) {
                if (!months.contains(m)) {
                    countMonths.add(new CountMonth() {{
                        setMmonth(m);
                        setMcount(0);
                    }});
                }
            }
            //对集合重新排序
            Collections.sort(countMonths, new Comparator<CountMonth>() {
                @Override
                public int compare(CountMonth o1, CountMonth o2) {
                    //升序
                    return o1.getMmonth().compareTo(o2.getMmonth());
                }
            });
            //将集合中每个月的次数放置到新集合中
            List<Integer> viewData2 = countMonths.stream().map(CountMonth::getMcount).collect(Collectors.toList());

            //            int finalI = i;
//            //设定返回值
//            manualIdCounts.add(new ManualIdCount() {{
//                setManualId(manualId[finalI]);
//                setViewData(viewData2);
//            }});

            //创建对象,设定值
            ManualIdCount manualIdCount=new ManualIdCount();
            manualIdCount.setManualId(manualId[i]);
            manualIdCount.setViewData(viewData2);
            //将对象装入集合
            manualIdCounts.add(manualIdCount);

        }
        //循环结束，将集合放置到返回map中
        resultMap.put("manualIdCounts", manualIdCounts);
        return resultMap;
    }





   /* *
    * @Author wx
    * 实际进度  真实进度的折线图
    *  * @param proId :
    * @return java.util.Map<java.lang.String,java.lang.Object>
    * @Date 2019/7/25 11:37
    */
    public Map<String, Object> echart3(int proId){
        //查询月份
        List<String> monthView = outputValueMapper.selectMonth(proId);
        //查询真实进度
        List<Integer> viewData=outputValueMapper.selectRelSchedule(proId);
        //查询真实进度
        List<Integer> viewData2=outputValueMapper.selectExpSchedule(proId);

        //设置返回集合
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("months",monthView);
        resultMap.put("RelSchedule",viewData);
        resultMap.put("ExpSchedule",viewData2);

        return   resultMap;
    }




}
