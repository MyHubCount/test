package mybatis;

import java.util.Arrays;

/**
 * @Author: wangxin * @Date: 2018/7/20 19:23 * @Description: *
 */
public class Test004 {

    public static void main(String[] args){
//        String no="";
//        String s="123;22,55;77777";
//        Boolean  B= Arrays.asList(s.replace(";", ",").split(",")).contains(no);
//        System.out.println(B);

        String NO="张xin";
        String Name="张xin(123)";
        Boolean B=Name.contains(NO);
        System.out.println(B);



    }
}
