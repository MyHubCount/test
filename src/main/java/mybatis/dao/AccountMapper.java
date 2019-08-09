package mybatis.dao;

import mybatis.bean.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by huawei on 2017/12/26.
 */
@Mapper
@Repository
public interface AccountMapper {

    @Select("select * from account where id = #{id}")
    Account findOne(@Param("id") int id);

    @Select("select * from account")
    List<Account> findAll();

    @Insert("insert into account(id,name,money) values(#{id},#{name},#{money})")
    int insertAccount(Account account);


    @Update("update account set name=#{name}, money=#{money} where id=#{id}")
    void updateAccount(Account account);



}
