package mybatis;

import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @Description TODO
 * @Author wx
 * @DATE 2019/8/7 14:09
 **/
public class TimedemoTest {

    public static void main(String[] args) {

        //1.
        //创建日期类
        Date date =new Date();
        //设置时间为当前时间的下一个月
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH,1);
        Date date2= calendar.getTime();
        //格式化时间
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM");
        String   target = simpleDateFormat.format(date2);
        //输出时间
        System.out.println(target);


        //2.
        //创建Calendar 获取当前时间
//        Calendar c = Calendar.getInstance(TimeZone.getTimeZone("GMT+08:00"));
//        //分别拿到年，月，日
//        int year=c.get(Calendar.YEAR);
//        int month = c.get(Calendar.MONTH) + 1;//获取当前月必须+1
//        int day=c.get(Calendar.DAY_OF_MONTH);
//        //输出
//        System.out.println(year);
//        System.out.println(month);
//        System.out.println(day);

    }
}
