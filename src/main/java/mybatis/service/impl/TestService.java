package mybatis.service.impl;

import  mybatis.dao.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class TestService {
    @Autowired
    TestMapper testMapper;
    public List<Map<String,Object>> get(){
        return testMapper.get();
    }
}
