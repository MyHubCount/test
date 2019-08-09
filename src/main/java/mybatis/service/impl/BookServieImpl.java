package mybatis.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import mybatis.bean.Book;
import mybatis.bean.Student;
import mybatis.dao.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServieImpl {

    @Autowired
    private BookMapper BookMapper;

    //查询学生列表（初始化页面和查询时候调用此方法，支持模糊查询和分页）
    public PageInfo getBookPop(int id) {
        List<Book> list = BookMapper.getBookPop(id);
        PageInfo pageInfo = new PageInfo<>(list);
        return pageInfo;

    }




}
