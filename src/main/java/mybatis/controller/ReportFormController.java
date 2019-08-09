package mybatis.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybatis.bean.Student;
import mybatis.service.impl.StudentServiceImpl;
import mybatis.utlis.ExcelUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/ReportForm")
public class ReportFormController {

//	Resource(name = "reportService")
//    private ReportManager reportService;

    @Autowired
    private mybatis.service.impl.StudentServiceImpl StudentServiceImpl;
	 /**
     * 导出报表
     * @return
     */
    @RequestMapping(value = "/export")
    @ResponseBody
    public void export(HttpServletRequest request,HttpServletResponse response,@RequestParam(value="ids[]") int[] ids) throws Exception {

        System.out.println("前台传入的ids是="+ids);


        //获取数据
        //       List<PageData> list = reportService.bookList(page);

        //excel标题
        String[] title = {"序号","名称", "性别", "年龄", "学校", "班级","统计"};

        //设置文件名
        String flieName = "學生信息表" + System.currentTimeMillis() + ".xls";
        //设置表名
        String sheetName = "学生信息表";

        List<Student> list =  StudentServiceImpl.selectStudentById(ids);
        xxx(sheetName,title,list,flieName,response);


    }

    private void xxx(String sheetName,String[] title,List list,String flieName,HttpServletResponse response) throws Exception {
        HSSFWorkbook hssfWorkbook = ExcelUtil.getHSSFWorkbook(sheetName, title, list);

        this.setResponseHeader(response,flieName);
        OutputStream outputStream =response.getOutputStream();
        hssfWorkbook.write(outputStream);
        outputStream.flush();
        outputStream.close();
    }
    //发送响应流方法
    private  void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            try {
                fileName = new String(fileName.getBytes(),"ISO8859-1");
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            response.setContentType("application/octet-stream;charset=ISO8859-1");
            response.setHeader("Content-Disposition", "attachment;filename="+ fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }





}
