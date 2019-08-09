package mybatis.service.impl;

import mybatis.bean.Account;
import mybatis.dao.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by huawei on 2017/12/26.
 */
@Service
public class AccountServiceImpl {

    @Autowired
    AccountMapper accountMapper;

    public int insertAccount(Account account) {
       return  accountMapper.insertAccount(account);
    }

    public void updateAccount(Account account) {
          accountMapper.updateAccount(account);
     }

    public Account findOne(int id) {
        return accountMapper.findOne(id);
    }

    public List<Account> findAll() {
        return accountMapper.findAll();
    }

    public  List<Account> selectAccounts(){
        return accountMapper.findAll();
    };

}
