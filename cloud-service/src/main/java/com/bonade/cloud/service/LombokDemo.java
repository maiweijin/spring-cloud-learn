package com.bonade.cloud.service;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@Data
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
public class LombokDemo {
    private String name;
    private Integer age;
    private static final String LOCK = "lock";
    public String sayHello(String name){
        File file = new File("application.properties");

        log.info("name:{}",name);
        return "Hello:"+name;
    }
}
