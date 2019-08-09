package mybatis.service.impl;


import mybatis.dao.SaleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SaleService {

    @Autowired
    SaleMapper SaleMapper;
    public List<Map<String,Object>> get(){
        return SaleMapper.get();
    }


}
