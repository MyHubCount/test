package mybatis.service.impl;


import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import mybatis.bean.Book;
import mybatis.bean.Student;
import mybatis.dao.BookMapper;
import mybatis.utlis.RedisCache;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mybatis.dao.StudentMapper;

import java.util.*;

@Service
public class StudentServiceImpl {

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private BookMapper BookMapper;
    @Autowired
    private RedisCache redisCache;


    public List<Student> selectStudentById(int[] array) {

        List<Student> sutdentlist = studentMapper.selectStudentById();
        return sutdentlist;
    }

    //新增学生表（新增的同时，批量新增学生对应的书籍表）
    public void addStudent(Student student) {
        studentMapper.addStudent(student);
        int id = student.getId();
        //设置书籍字段的信息
        String bookName = "资治通鉴,增广贤文,伤寒论,论中国,曾国藩全集";
        String[] bookNames = bookName.split(",");
        System.out.println("此时书籍数组的长度是：" + bookNames.length);
        List<String> list1 = Arrays.asList(bookNames);
        System.out.println("此时书籍集合的长度是：" + list1.size());

        //动态添加
        List<Book> bookList = new ArrayList<>();
        for (int i = 0; i < list1.size(); i++) {
            Book book = new Book();
            book.setBookName(list1.get(i));
            book.setId(id);
            bookList.add(book);
        }

        BookMapper.add(bookList);

    }

    public void updateStudent(Student student) {
        studentMapper.updateStudent(student);
    }

    public List<Student> findAll() {
        return studentMapper.findAll();
    }


//    //查询学生列表（初始化页面和查询时候调用此方法，支持模糊查询和分页）
//    public PageInfo getStudentList(String name, String school, String grade, int offset, int limit) {
//        int pageNum = offset / limit + 1;
//        PageHelper.startPage(pageNum, limit);
//
//
//        //定义一个键
//        String key = "key";
//        //定义一个值
//        String value = (String) redisCache.get(key);
//        //接受的集合
//        List<Student> list;
//        if (value == null || value.equals(" ")) {
//            list = studentMapper.getStudentList(null, null, null);
//            //将数据设置到缓存redis中
//            redisCache.set(key, JSON.toJSONString(list));
//        } else {
//            list = JSON.parseArray(value, Student.class);
//        }
//        List<Student> newList = new ArrayList<>();
//        for (int i = 0; i < list.size(); i++) {
//            if (StringUtils.isNotBlank(name) || StringUtils.isNotBlank(school) || StringUtils.isNotBlank(grade)) {
//                if (StringUtils.isNotBlank(name) && StringUtils.isNotBlank(school) && StringUtils.isNotBlank(grade)) {
//                    if (list.get(i).getName().contains(name) && list.get(i).getSchool().equals(school) && list.get(i).getGrade().equals(grade)) {
//                        newList.add(list.get(i));
//                    }
//                }
//                else  if(StringUtils.isNotBlank(name) && StringUtils.isNotBlank(school) && StringUtils.isBlank(grade)) {
//                    if (list.get(i).getName().contains(name) && list.get(i).getSchool().equals(school)) {
//                        newList.add(list.get(i));
//                    }
//                }
//                else  if (StringUtils.isNotBlank(name) && StringUtils.isBlank(school) && StringUtils.isNotBlank(grade)) {
//                    if (list.get(i).getName().contains(name) && list.get(i).getGrade().equals(grade)) {
//                        newList.add(list.get(i));
//                    }
//                }
//                else  if (StringUtils.isNotBlank(school) && StringUtils.isNotBlank(grade)) {
//                    if (list.get(i).getSchool().equals(school) && list.get(i).getGrade().equals(grade)) {
//                        newList.add(list.get(i));
//                    }
//                }
//                else  if (StringUtils.isNotBlank(grade)) {
//                    if (list.get(i).getGrade().equals(grade)) {
//                        newList.add(list.get(i));
//                    }
//                }
//                else  if (StringUtils.isNotBlank(school)) {
//                    if (list.get(i).getSchool().equals(school)) {
//                        newList.add(list.get(i));
//                    }
//                }
//                else  if (StringUtils.isNotBlank(name)) {
//                    if (list.get(i).getName().contains(name)) {
//                        newList.add(list.get(i));
//                    }
//                }
//            }
//        }
//
//        //封装到分页对象中
//        PageInfo pageInfo = new PageInfo<>(newList);
//        return pageInfo;
//    }
    

    //查询学生列表（初始化页面和查询时候调用此方法，支持模糊查询和分页）
    public PageInfo getStudentList(String name, String school, String grade, int offset, int limit) {

        int pageNum = offset / limit + 1;
        PageHelper.startPage(pageNum, limit);

        //定义一个键
//        String key = "key";
//        //定义一个值
//        String value = (String) redisCache.get(key);
//        //接受的集合
//        List<Student> list;
//        if (value == null || value.equals(" ")) {
//            list = studentMapper.getStudentList(name, school, grade);
//            //将数据设置到缓存redis中
//            redisCache.set(key, JSON.toJSONString(list));
//        } else {
//            list = JSON.parseArray(value, Student.class);
//        }


        //封装到分页对象中
        List<Student> list;
        list = studentMapper.getStudentList(name, school, grade);
        PageInfo pageInfo = new PageInfo<>(list);
        return pageInfo;

    }


    //点击“统计”字段，调动此方法，读取数据显示到弹窗上面
    public List<Student> getUserListForPop(String name, String school) {
        String name1 = name;
        String school2 = school;
        List<Student> list = studentMapper.getUserListForPop(name1, school2);
        //对集合进行处理，要求前台传入的name，排序后到页面展示列表首位（若有多个同名的name依次展示在前面）
        int t = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(name1) || list.get(i).getSchool().equals(school2)) {
                Student student = list.get(t);
                list.set(t, list.get(i));
                list.set(i, student);
                t++;
            }
        }
        return list;

    }


    //根据id查询学生信息
    public Student queryStudentById(int id) {
        Student student = studentMapper.queryStudentById(id);
        return student;
    }


    public void updateSex(int[] ids, String sex) {


        for (int id : ids) {
            studentMapper.updateSex(id, sex);
        }

//        //更新操作过后，重新设置缓存
//        //定义一个键
//        String key = "key";
//        //定义一个值
//        String value = (String) redisCache.get(key);
//        //接受的集合
//        List<Student> list;
//
//        list = studentMapper.getStudentList(null, null, null);
//        //将数据设置到缓存redis中
//        redisCache.set(key, JSON.toJSONString(list));

    }


}