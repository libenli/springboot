package com.lbl.springboot.mapper;

import com.lbl.springboot.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author benli
 * @date 2019/2/24 19:06
 */
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM tb_user")
    List<User> findAll();

    @Select("SELECT * FROM tb_user WHERE id = #{id}")
    User findUser(int id);

    @Select("SELECT * FROM tb_user WHERE name = #{name}")
    User findByUsername(String name);

    @Insert("INSERT INTO tb_user(name,age) VALUES(#{name}, #{age})")
    void insert(User user);

    @Delete("DELETE FROM tb_user WHERE id = #{id}")
    void deleteById(int id);
}
