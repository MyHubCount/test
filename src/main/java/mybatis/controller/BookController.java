package mybatis.controller;


import com.github.pagehelper.PageInfo;
import mybatis.bean.Book;
import mybatis.bean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import mybatis.service.impl.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookServieImpl bookServie;

    @RequestMapping("/getBookPop")
    @ResponseBody
    public Map<String, Object> getBookPop(int id) {
        Map<String, Object> result = new HashMap<>();
        PageInfo roleInfo = bookServie.getBookPop(id);
        result.put("total", roleInfo.getTotal());
        result.put("rows", roleInfo.getList());
        return result;
    }

    @GetMapping("test")
    public Boolean test(){
        return true;
    }


}
