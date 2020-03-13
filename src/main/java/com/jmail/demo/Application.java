package com.jmail.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * <p>Create Time: 2020年03月13日 11:35  </p>
 * <p>@author zhangxs7  </p>
 **/
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Application {
    private static Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        logger.info("Success Running");
    }
}
