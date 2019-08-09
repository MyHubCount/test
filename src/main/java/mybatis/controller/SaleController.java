package mybatis.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.*;
import mybatis.service.impl.SaleService;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/sale")
public class SaleController {

@Autowired
private  SaleService SaleService;


    @RequestMapping("/list")
    @ResponseBody
    public List<Map<String,Object>> get(){
        List<Map<String,Object>> list =  SaleService.get();
        return list;
    }


}
