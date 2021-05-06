package com.ggf.Ioc2;

import com.ggf.Ioc2.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {

    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("Ioc2.xml");
        User user = (User)context.getBean("user");
        System.out.println(user.getName());
    }

}
