package com.example.hibernate.controller;

import com.example.hibernate.dao.UserDAO;
import com.example.hibernate.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @Author 落叶飞翔的蜗牛
 * @Date 2018/2/24
 * @Description
 */
@Controller
@RequestMapping("/hibernate")
@EnableAutoConfiguration
public class UserController {
    @Autowired
    private UserDAO userDao;

    @RequestMapping("getUserById")
    @ResponseBody
    public User getUserById(Long id) {
        User user = userDao.findOne(id);
        System.out.println("userDao: " + userDao);
        System.out.println("id: " + id);
        return user;
    }

    @RequestMapping("saveUser")
    @ResponseBody
    public void saveUser() {
        User user = new User();
        user.setUserName("zhangsan");
        user.setAddress("shanghai");
        user.setBirthDay(new Date());
        user.setSex("male");
        userDao.save(user);
    }

    @RequestMapping("findUserByName")
    @ResponseBody
    public User findUserByName(String userName) {
        return userDao.findUserByName(userName);
    }
}
