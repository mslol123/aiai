package com.jxky.bgxs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jxky.bgxs.dao")
public class ZhwGroupProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZhwGroupProjectApplication.class, args);
	}
}

