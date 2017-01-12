package com.self.ddyoung.daily;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author <a href="mailto:sanbian@pamirs.top">Sanbian</a>
 * @version 1.0
 * @since 16/12/22 下午7:52
 */
public class BaseTest{

    public ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:test-spring-config.xml");

    public Apple apple = (Apple) applicationContext.getBean("apple");
}
