package mybatis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @Author: wangxin * @Date: 2018/8/10 11:04 * @Description: *
 */
public class JedisTest {
   public  JedisPool jedisPool;
    



    public static void main(String[] args){

        System.out.println("Hello Jedis");
        //连接本地的Redis服务
        Jedis jedis =new Jedis("192.168.80.128",6379);
        //查看服务是否正常运行
        System.out.println("Server is running:"+jedis.ping());
        jedis.set("foo","bar");
        String value=jedis.get("foo");
        //
        System.out.println(value);

        //获取redis 中的值
        System.out.println(jedis.get("name"));




    }



}
