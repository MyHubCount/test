package mybatis.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import mybatis.bean.GetParams;
import mybatis.service.impl.EchartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author wx
 * @DATE 2019/7/16 11:28
 **/

@RestController
@RequestMapping("/echart")
public class EchartController {

    @Autowired
    EchartService echartService;

    @RequestMapping("echart")
    @ResponseBody
    public Map<String,Object> echart(){

        return  echartService.echart();
    }


    /*@RequestMapping("echart2")
    @ResponseBody
    public Map<String,Object> echart2(@RequestParam(value="proId",required=false) int proId,@RequestParam(value="manualId",required=false) int[] manualId){
        return  echartService.echart2(proId,manualId);
    }*/
    @PostMapping("echart2")
    public Map<String,Object> echart2(Integer proId,Integer[] manualId, HttpServletRequest request){

        return  echartService.echart2(proId,manualId);
    }



    @RequestMapping("echart3")
    @ResponseBody
    public Map<String,Object> echart3(@RequestParam("proId")int proId){
        return  echartService.echart3(proId);
    }


}
