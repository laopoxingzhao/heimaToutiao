package com.hua;

//import com.heima.common.redis.CacheService;
import com.heima.common.redis.CacheService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @ClassName Test1
 * @Description TODO
 * @Author 胡
 * @Date 2023/11/28 17:04
 * @Version 1.0
 */
@SpringBootTest(classes = Application1.class)
public class Test1 {

    @Autowired
    CacheService service;

    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Test
    public void test1(){
//        stringRedisTemplate.opsForValue().set("aa","1ew");
        service.lLeftPush("123", "123");
    }

}
