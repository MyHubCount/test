package mybatis.dao;

import mybatis.bean.Book;
import mybatis.bean.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface BookMapper {

   //批量新增书籍的方法
    public void add(List<Book> bookList);

    //弹窗展示书籍信息
    List<Book>  getBookPop(@Param("id")int id);


}
