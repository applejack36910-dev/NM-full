package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringiocApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringiocApplication.class, args);

        ApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");

        Student s = (Student) context.getBean("student");

        s.display();
    }
}