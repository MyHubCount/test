package mybatis;

import java.util.*;

/**
 * @Author: wangxin * @Date: 2018/8/9 13:15 * @Description: *
 */
public class LocalTest {

    public static void main(String[] args){

//        /**
//         * 测试案例
//         * 描述：将字符串前面追加，数字和小数点
//         */
//        String str="wx,zhaoxi,zhenrui";
//        List list= Arrays.asList(str.split(","));
//        List<String> list2=new ArrayList();
//        for (int i=0;i<list.size();i++){
//             list2.add(i+1+"."+list.get(i));
//        }
//
//        for (String name:list2){
//            System.out.print(name);
//        }

        /**
         * 动态处理票号
         *
         * 描述： "9/p6,300/p3,004999999/p3,995/p3,100/p1,2/p2" 转成标准票号字符串(分号，逗号)
         */
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
