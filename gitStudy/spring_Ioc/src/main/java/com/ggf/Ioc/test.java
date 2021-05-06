package com.ggf.Ioc;

import com.ggf.Ioc.Bean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("Ioc.xml");
        Bean bean = context.getBean("worker", Bean.class);
        Bean treterre = context.getBean("treterre", Bean.class);
        bean.work();
        treterre.work();
    }
}
