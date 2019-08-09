package mybatis;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: wangxin * @Date: 2018/7/20 10:13 * @Description: *
 */
public class abc {

    public static void main(String[] args) {
//        boolean b =true;
//        String s = "14324A723421";
//        Pattern compile = Pattern.compile("^[0-9]+$");
//        Matcher matcher = compile.matcher(s);
//        String s1= "";
//        while (matcher.find()){
//            s1+=matcher.group();
//        }
//        if (s1.equals("")){
//            b=false;
//        }
//        System.out.println(b);


        String ticket = "9/p6,300/p3,004999999/p3,995/p3,100/p1,2/p2";
        String[] s = ticket.split(",");
        List<String> strings = Arrays.asList(s);
        Collections.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.parseInt(o1.substring(o1.indexOf("p") + 1)) - Integer.parseInt(o2.substring(o2.indexOf("p") + 1));
            }
        });
        System.out.println(strings);
        List<String> list = new ArrayList<>();
        for (String s1 : strings) {
            list.add(s1.substring(s1.length() - 1));
        }
//        for(String tickets: list){
//            System.out.print(" "+tickets);
//        }
//         System.out.println(" ");
        String str;
        str = strings.get(0).substring(0, s[0].indexOf('/'));
        System.out.println(str);
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                break;
            }
            if (list.get(i).equals(list.get(i + 1))) {
                str += "," + strings.get(i+1).substring(0, s[i+1].indexOf('/'));
            } else {
                str += ";" +strings.get(i+1).substring(0, s[i+1].indexOf('/'));
            }
        }

        System.out.println(str);


    }


}
