package mybatis;

import java.util.*;

/**
 * @Author: wangxin * @Date: 2018/7/24 10:21 * @Description: *
 */
public class ABCD {

    public  static  void main(String arg[]) {

        Map<Integer, String> map = new HashMap<>();
        map.put(11, "商务舱");
        map.put(2, "头等舱");
        map.put(1, "公务舱");
        map.put(4, "经济舱");
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            list.add(entry.getKey());
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        System.out.println(map.get(list.get(0)));




    }
}
