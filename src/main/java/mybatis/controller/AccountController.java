package mybatis.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import mybatis.bean.Account;
import mybatis.service.impl.AccountServiceImpl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by huawei on 2017/12/26.
 */
@RestController
@RequestMapping("/Account")
public class AccountController {

    public static final Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    AccountServiceImpl accountService;


    @RequestMapping(value = "/update", method = RequestMethod.POST)
     void updateAccount(@RequestBody Account account) {
        logger.info("接受到数据："+ account);
         accountService.updateAccount(account);
//        if (i == 1) return "add account success";
//        else return "add account fail";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    String insertAccount(@RequestBody Account account) {
        logger.info("接受到数据："+ account);
        int i = accountService.insertAccount(account);
        if (i == 1) return "add account success";
        else return "add account fail";
    }




    @GetMapping("/findOne/{id}")
    Account findOne(@PathVariable int id){
        logger.info("接收到数据：" + id);
        return accountService.findOne(id);
    }


    @GetMapping("/findAll/{pageNum}/{pageSize}")
    Page findAll(@PathVariable Integer pageNum, @PathVariable Integer pageSize) {
        logger.info("接收到数据：" + pageNum + "->" + pageSize);
        pageNum = pageNum == null? 1 : pageNum;
        pageSize= pageSize == null? 1 : pageSize;
        //对于该startPage方法后面的第一个查询会被分页,accounts会被分页
        PageHelper.startPage(pageNum, pageSize);
        List<Account> accounts = accountService.findAll();
//      PageInfo pageInfo = new PageInfo(accounts);
        return (Page)accounts;
    }

    @RequestMapping("/list")
    @ResponseBody
    public   Map<String, Object>  userList(){
        Map<String, Object> result = new HashMap<>();
        List<Account> accounts =  accountService.selectAccounts();
        result.put("accounts",accounts);
        return result;
     //   request.setAttribute("account",accountService.selectAccounts());

    }





}
