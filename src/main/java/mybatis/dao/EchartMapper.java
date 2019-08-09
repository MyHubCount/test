package mybatis.dao;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface EchartMapper {

    List<Double>  selectEchart();

    List<Double>  selectEchart2();

    List<String> selectMonth();
}
