package mybatis;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Description TODO
 * @Author wx
 * @DATE 2019/7/31 9:41
 **/



public class MapTestDemo2019 {


    public static void main(String[] args) {

        Map<String,String> maplist=new HashMap<>();

        maplist.put("1","平面设计师");
        maplist.put("2","开发工程师");
        maplist.put("3","职业摄像师");

        //遍历键集，拿到值集（效率最低）
//        for (String key : maplist.keySet()){
//            String value =maplist.get(key);
//            System.out.println("key="+key+"   "+"value="+value);
//        }


        //第二种遍历方式
//        for( Map.Entry<String,String> entry :maplist.entrySet()){
//
//            System.out.println("key="+entry.getKey()+"   "+"value="+entry.getValue());
//        }value


        //使用迭代器
//       Iterator iterator =  maplist.entrySet().iterator();
//
//        while (iterator.hasNext()){
//           Map.Entry<String,String> entry =(Map.Entry<String,String>)iterator.next();
//            String key=entry.getKey();
//            String value=entry.getValue();
//
//            System.out.println("key="+key+" "+"value="+value);
//
//        }


        //1.8新式操作
        maplist.forEach((k,v)->{
            // 打印键
            System.out.println(k);
            // 打印值
            System.out.println(v);
        });





    }








}
