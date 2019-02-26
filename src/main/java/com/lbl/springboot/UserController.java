package com.lbl.springboot;

import com.lbl.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author benli
 * @date 2019/2/24 19:11
 */
@Controller
public class UserController {

    @Autowired
    UserMapper userMapper;

}
