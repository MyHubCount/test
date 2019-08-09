package mybatis.controller;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import mybatis.LogExampleOther;
import mybatis.bean.Student;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import mybatis.service.impl.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentController {

@Autowired
private  StudentServiceImpl StudentServiceImpl;

//    public static final Logger log = LoggerFactory.getLogger(StudentController.class);
    private static final Logger log = LoggerFactory.getLogger(LogExampleOther.class);





    @GetMapping("/findAll/{pageNum}/{pageSize}")
    Page findAll(@PathVariable Integer pageNum, @PathVariable Integer pageSize) {
        log.info("接收到数据：" + pageNum + "->" + pageSize);
        pageNum = pageNum == null? 1 : pageNum;
        pageSize= pageSize == null? 1 : pageSize;
        //对于该startPage方法后面的第一个查询会被分页,accounts会被分页
        PageHelper.startPage(pageNum, pageSize);
        List<Student> Student = StudentServiceImpl.findAll();
//      PageInfo pageInfo = new PageInfo(accounts);
        return (Page)Student;
    }

    //查询学生列表（初始化页面和查询时候调用此方法，支持模糊查询和分页）
    @RequestMapping("/getUserList")
    @ResponseBody
    public Map<String, Object> getStudentList(String name, String school, String grade, int offset, int limit) {

        log.info("接收到数据：" + name + "->" + grade);
       System.out.print("获取前台传来的下拉框的值"+grade);
        Map<String, Object> result = new HashMap<>();
        PageInfo roleInfo = StudentServiceImpl.getStudentList(name,school,grade,offset,limit);
        result.put("total", roleInfo.getTotal());
        result.put("rows", roleInfo.getList());
        return result;
    }



    //点击“统计”字段，调动此方法，读取数据显示到弹窗上面
    //该方法采用前台分页（client），方便后台按照特定方式取数据。
    @RequestMapping("/getUserListForPop")
    @ResponseBody
    public List<Student> getUserListForPop(String name,  String school) {
        List<Student> result = StudentServiceImpl.getUserListForPop(name,school);
        return result;
    }



    @RequestMapping("/queryStudentById")
    @ResponseBody
    public  Student queryStudentById(@RequestParam("id") int id ){
      return   StudentServiceImpl.queryStudentById(id);
    }


@RequestMapping("/add")
@ResponseBody
public  void   addStudent(@RequestBody Student student){
        StudentServiceImpl.addStudent(student);
}


    @RequestMapping("/update")
    @ResponseBody
    public  void   updateStudent(@RequestBody Student student){
        StudentServiceImpl.updateStudent(student);
    }

    @RequestMapping("/updateSex")
    public  void   updateSex(@RequestParam(value = "ids[]") int[] ids,@RequestParam(value = "sex") String sex){
        System.out.println("前台传入的ids数组="+ids);
        System.out.println("前台传入的性别是"+sex);
        StudentServiceImpl.updateSex(ids,sex);
    }



}
