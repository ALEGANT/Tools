package com.ggf.service;

import com.ggf.dao.UserDaoMysqlImpl;
import com.ggf.service.UserService;
import com.ggf.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    public static void main(String[] args){

        UserServiceImpl userService = new UserServiceImpl();
        userService.setUserDao(new UserDaoMysqlImpl());
        System.out.println(userService.getUser());

        // --------------------1---------------------
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        UserService service1 = context.getBean("UserServiceImpl", UserService.class);
        System.out.println(service1.getUser());

        // --------------------2---------------------
        UserService service2 = context.getBean("UserServiceImpl", UserService.class);
        System.out.println(service1 == service2);
    }
}
