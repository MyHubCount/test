package mybatis.controller;

import mybatis.service.impl.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
@Controller
@RequestMapping("/count_passenger")
public class TestController {
    @Autowired
    TestService testService;
    @RequestMapping("/list")
    @ResponseBody
    public List<Map<String,Object>> get(){
        List<Map<String,Object>> list =  testService.get();
        return list;
    }

}
