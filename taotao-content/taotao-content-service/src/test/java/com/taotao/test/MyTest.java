package com.taotao.test;

import com.taotao.jedis.JedisClient;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

import java.util.HashSet;
import java.util.Set;

public class MyTest {

    /*
    @Test
    public void demo1(){

        Jedis jedis=new Jedis("192.168.25.153",6379);
        jedis.set("key1","zhangsan");
        System.out.println(jedis.get("key1"));
        jedis.close();
    }

    @Test
    public void testJedisClient(){
        //初始化Spring容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
        //从容器中获得JedisClient对象
        JedisClient jedisClient = applicationContext.getBean(JedisClient.class);
        jedisClient.set("first", "100");
        String result = jedisClient.get("first");
        System.out.println(result);
    }
    */
}
