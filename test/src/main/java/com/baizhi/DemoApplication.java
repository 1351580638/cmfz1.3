package com.baizhi;

import com.baizhi.test2.LuceneDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    @Bean
    public LuceneDao getLuceneDao(){
        return new LuceneDao();

    }
}
