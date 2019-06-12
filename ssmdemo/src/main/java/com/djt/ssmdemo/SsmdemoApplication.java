package com.djt.ssmdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.djt.ssmdemo.dao")
public class SsmdemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(SsmdemoApplication.class, args);
	}

}
