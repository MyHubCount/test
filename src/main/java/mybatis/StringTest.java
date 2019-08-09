package mybatis;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description TODO
 * @Author wx
 *
 * //TODO: 字符串操作：将“2019-07”转换成 “2019-7”。若遇到10，11，12月，则原样输出
 *
 * @DATE 2019/8/6 11:09
 **/
public class StringTest {

    public  static  final String  SOURCE_FORMATTER="yyyy-MM";
    public  static  final String  TARGET_FORMATTER="yyyy-M";


    public static void main(String[] args) {

        //数组的方法
//        String s = "2019-11";
//        String[] split = s.split("");
//        String s1="";
//        if(split[5].equals("0")){
//            for(int i =0 ;i<split.length ;i++){
//                if(i==5){
//                    continue;
//                }
//                s1 += split[i];
//            }
//        }else{
//            s1=s;
//        }
//        System.out.println(s1);



           //原始思路
//         String date2="2019-05";
//
//         String date3= date2.substring(0,7);
//         String v =date2.substring(5,6);
//
//         String prefix=date2.substring(0,5);
//         String suffix=date2.substring(6,7);
//
//         if(v.equals("0")){
//            String newDate=prefix+suffix;
//            System.out.println(newDate);
//         }else{
//             System.out.println(date2);
//         }



       // DateTimeFormatter实现
        String date1="2019-07";


        DateTimeFormatter sourceFomatter =DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter targetFomatter =DateTimeFormatter.ofPattern(TARGET_FORMATTER);
        final String date=targetFomatter.format(sourceFomatter.parse(date1+"-08"));

        System.out.println(date);



        //正则表达式替换0
//        String str="2019-02";
//        str =  str.replaceAll("(?<=.{5}).*(?=.{1})","");


        //正则表达式基本用法
        //定义原始字符串,正则表达式
//        String  str="a123123123123d";
//        String regex="[ac]\\d*[bd]";
//       //通过Pattern类设置正则表达式,最后将原始字符串放置到Matcher中
//       Pattern p=Pattern.compile(regex);
//       Matcher m=p.matcher(str);
//        //查看结果
//        boolean v=m.matches();
//        System.out.println(v);


//        String s = "a0b1c3456";
//        String ss[] = s.split("\\d");
//        for(String str: ss)
//            System.out.println(str);


//        String s = "GET /index.html HTTP/1.1";
//        String ss[] = s.split(" ");
//        for(String str: ss)
//            System.out.println(str);



//        String date1="2019-07";
//        SimpleDateFormat dateFormat1=new SimpleDateFormat(SOURCE_FORMATTER);
//        SimpleDateFormat dateFormat2=new SimpleDateFormat(TARGET_FORMATTER);
//
//        String  str=  dateFormat2.format(dateFormat1.parse(date1).getTime());
//
//        System.out.println(str);


//
//        String s = "2019-07";
//        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-M");
//        try {
//            Date date= simpleDateFormat.parse(s);
//           String str= simpleDateFormat.format(date);
//            System.out.println(str);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//
    }


}
