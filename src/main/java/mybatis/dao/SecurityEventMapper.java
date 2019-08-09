package mybatis.dao;

import mybatis.bean.CountMonth;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SecurityEventMapper {



    List<Integer> echart2(@Param("proId")int proId);

    List<Integer> selectOneById(@Param("proId")int proId,@Param("manualId")int manualId);

    List<CountMonth> selectCount(@Param("proId")int proId, @Param("manualId")int manualId);

    List<String> selectMonth(@Param("id")int id);


}
