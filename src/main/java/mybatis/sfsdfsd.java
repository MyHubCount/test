package mybatis;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: wangxin * @Date: 2018/7/18 11:19 * @Description: *
 */
public class sfsdfsd {
    public static void main(String[] args) {
    //    String name = "1.张三,2.李四,3.王五";

        String ticket = "2555/p2,3/p3,4/p3,5/p3,122/p1,";
        String[] t = ticket.split(",");
        String[] t2;
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        for(String s : t){
           list1.add(s.substring(s.indexOf("p")+1));
        }
        Collections.sort(list1);
        System.out.println(list1);



//        List<String> list = new ArrayList<>();
//        for (String s : t) {
//            list.add(s.substring(s.length() - 1));
//        }
//        String str;
//        str = t[0].substring(0, t[0].indexOf("/"));
//        for (int i = 0; i < list.size(); i++) {
//            if (i == list.size() - 1) {
//                break;
//            }
//            if (list.get(i).equals(list.get(i + 1))) {
//                str += "," + t[i + 1].substring(0, 1);
//            } else {
//                str += ";" + t[i + 1].substring(0, 1);
//            }
//        }
//        System.out.println(str);

    }
}
