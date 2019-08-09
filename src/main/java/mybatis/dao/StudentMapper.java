package mybatis.dao;


import mybatis.bean.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import mybatis.dao.StudentMapper;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Mapper
@Repository
public interface StudentMapper {

    @Select("select * from student")
    List<Student> findAll();
    //初始化页面，模糊查询调动方法
    List<Student>  getStudentList(@Param("name")String name, @Param("school")String school, @Param("grade")String grade);
   //弹窗统计
    List<Student>  getUserListForPop(@Param("name")String name, @Param("school")String school);


    List<Student> selectStudentById( );

    public  void  addStudent(Student student);

    public  void  updateStudent(Student student);

    //根据id查询学生信息
    public  Student queryStudentById(int id);

    public  void  updateSex(@Param("id") int id,@Param("sex") String sex);

}
