package mybatis;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author: wangxin * @Date: 2018/8/22 16:52 * @Description: *
 */
public class MapTest {

    public static void main(String[] args){
        Map<String,String>  map=new HashMap<>();
        map.put("1","智慧");
        map.put("2","勇敢");
        map.put("3","坚持");
        map.put("4","善良");

        //1.推荐使用遍历方式
//        for(Map.Entry<String,String> entry:map.entrySet()){
//            System.out.println(entry.getKey()+" "+entry.getValue());
//        }

        //2.使用迭代器遍历
//        Iterator<Map.Entry<String,String>> iterator = map.entrySet().iterator();
//         while (iterator.hasNext()){
//          Map.Entry<String,String> entry  = iterator.next();
//             System.out.println(entry.getKey()+"----- "+entry.getValue());
//         }

        //3.普通方式
//        for(String keys:map.keySet()){
//          System.out.println(keys+"====="+map.get(keys));
//        }



    }


}
