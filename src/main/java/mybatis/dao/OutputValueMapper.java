package mybatis.dao;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OutputValueMapper {

     List<String>  selectMonth(@Param("proId") int proId);

     List<Integer>  selectRelSchedule(@Param("proId") int proId);

     List<Integer>  selectExpSchedule(@Param("proId") int proId);


}
