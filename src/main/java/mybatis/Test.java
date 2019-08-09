package mybatis;

import mybatis.bean.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Calendar;

public class Test {
    public static void main(String[] args) {

        String str1 = "1.张三,2.李四,3.王五,4.张飒,5.刘德华";
        String str2 = "eeeAA/P2,BBeee/P3,cceee/p5,eeeee/p2";
        String[] s1 = str1.split(",");
        String[] s2 = str2.split(",");
        for (int i = 0; i < s1.length; i++) {
            String str = "";
            for (String s : s2) {
                if (s1[i].substring(0, 1).equals(s.substring(s.length() - 1))) {
                    str += " "+s1[i] + s;
                }
            }
            System.out.println(str);
        }



        //
        //获取年月日
//        Calendar now = Calendar.getInstance();
//        String Year = now.get(Calendar.YEAR) + "";
//        String month = now.get(Calendar.MONTH) + 1 + "";
//        String day = now.get(Calendar.DAY_OF_MONTH) + "";
//        String date = Year + month + day;
//        System.out.println(date);

//        String random2 = random + " ";


//        LocalDate localDate = LocalDate.now();
//        int random = (int) ((Math.random() * 10) * 10000);
//        System.out.print(String.format("QT%d%02d%2d%d", localDate.getYear(), localDate.getMonth().getValue(), localDate.getDayOfMonth(), random)
//        );


    }

}


//        List<Student> list = new ArrayList<>();
//        Student student1 = new Student(1, "王五", "男", 21, "香港中文大学", "大三",1);
//        Student student2 = new Student(2, "李四", "男", 22, "北京大学", "大四",2);
//        Student student3 = new Student(3, "张三", "女", 18, "伦敦大学", "高三",3);
//        Student student4 = new Student(4, "张三", "女", 18, "伦敦大学", "高三",3);
//        Student student5 = new Student(5, "张国荣", "女", 18, "伦敦大学", "高三",3);
//        Student student6 = new Student(6, "李荣基", "女", 18, "伦敦大学", "高三",3);
//        Student student7 = new Student(7, "迪丽热巴", "女", 18, "伦敦大学", "高三",3);
//        Student student8 = new Student(8, "邓超", "女", 18, "伦敦大学", "高三",3);
//        Student student9 = new Student(9, "王祖蓝", "女", 18, "伦敦大学", "高三",3);
//        Student student10 = new Student(4, "张三", "女", 18, "伦敦大学", "高三",3);
//
//
//        list.add(student1);
//        list.add(student2);
//        list.add(student3);
//        list.add(student4);
//        list.add(student5);
//        list.add(student6);
//        list.add(student7);
//        list.add(student8);
//        list.add(student9);
//        list.add(student10);
//
//
//        int t = 0;
//        for(int i =0;i<list.size();i++){
//            if(list.get(i).getName()=="张三"){
//                Student student = list.get(t);
//                list.set(t,list.get(i));
//                list.set(i,student);
//                t++;
//            }
//        }
//        for (int i =0;i<list.size();i++){
//            System.out.println(list.get(i).getName());
//        }
//
//    }


//        List<Integer> list = new ArrayList();
//        list.add(2);
//        list.add(1);
//        list.add(1);
//        list.add(2);
//        list.add(2);
//        list.add(2);
//        list.add(3);
//        list.add(3);
//        list.add(2);
//        List<Integer> l2 = new ArrayList<>(list);
//        //设置新的集合，将制定的元素设置到最后
//        Iterator<Integer> i = list.iterator();
//        while (i.hasNext()){
//            if(i.next()==2){
//                l2.add(2);
//            }
//        }
//
//        System.out.println("设置新的集合，将制定的元素设置到最后"+l2);
//
//        //将制定的元素设置为空值
//        for(int a=0;a<list.size();a++){
//            if(l2.get(a)==2){
//                l2.set(a,null);
//            }
//        }
//        System.out.println("将制定的元素设置为空值"+l2);
//
//        //倒序集合
//        Collections.reverse(l2);
//        System.out.println("倒序集合"+l2);
//
//        //去掉集合中null的值（1.通过新集合。or 2.通过api）
//
//
//        List<Integer> l3 = new ArrayList<>();
//        for(int j=0;j<l2.size();j++){
//            if(l2.get(j)!=null){
//                l3.add(l2.get(j));
//            }
//        }
//        System.out.println(l3);
//    }

