package com.lbl.springboot;

import com.lbl.springboot.mapper.UserMapper;
import com.lbl.springboot.pojo.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void findUser() throws Exception{
        User user =userMapper.findUser(1);
        System.out.println("username-------->="+user.getName());
    }

    @Test
    public void findUserByName() throws Exception{
//        User user =userMapper.findByUsername("小红");
//        System.out.println("age-------->="+user.getId());
    }

    @Test
    public void insertUser() throws Exception{
        User user = new User();
        user.setName("小红");
        user.setAge(18);
        userMapper.insert(user);
//        Assert.assertEquals(3,userMapper.findAll().size());

    }

    @Test
    public void deleteById() throws Exception{
        userMapper.deleteById(3);
//        Assert.assertEquals(3,userMapper.findAll().size());
    }
}
