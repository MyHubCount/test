package mybatis;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: wangxin * @Date: 2018/9/11 14:50
 * * @Description:
 *   正则表达式的测试使用类
 * *
 */
public class RegexTest {
   public static void main(String [] args){
       String str= "123456\r\n" +
               " ,55\r\n" +
                   ",67";
//       System.out.print(str);
       String[] split = str.split("\r\n,");
       String regex="(?s).[13579]$";
       for(String st :split){
           Pattern pattern=Pattern.compile(regex);
           Matcher matcher=pattern.matcher(st);
           while(matcher.find()){
               System.out.println(matcher.group());
           }
       }

   }





}
