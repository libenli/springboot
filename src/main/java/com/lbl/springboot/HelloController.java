package com.lbl.springboot;

import com.alibaba.fastjson.JSON;
import com.lbl.springboot.mapper.UserMapper;
import com.lbl.springboot.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * @author benli
 * @date 2019/2/24 15:16
 */
@Controller
public class HelloController {
    @Autowired
    UserMapper userMapper;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;


    @RequestMapping("/hello")
    public String hello(Map<String, Object> paramMap) {
        List<User> users = userMapper.findAll();
        for (User user:users) {
            System.out.println("SAH--->"+user.getName());
        }
        // 具体使用
        redisTemplate.opsForList().leftPush("user:list", JSON.toJSONString(users));
        stringRedisTemplate.opsForValue().set("user:name", "张三");


        paramMap.put("lists", users);
//        return "Hello Spring Boot heihei ----------------------->时阿慧!"+users.size();
//        return "Hello Spring Boot heihei ----------------------->时阿慧!";
        return "showlist";
    }

    @RequestMapping("/test")
    public String goTest(Map<String, Object> paramMap) {
        paramMap.put("name", "章三");
        paramMap.put("age", 21);
        return "test";
    }
}
