package com.qianli.ilink.cloud_platform.commons;

import com.qianli.ilink.cloud_platform.commons.dao.TestMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@SpringBootApplication
@MapperScan("com.qianli.ilink.cloud_platform.commons.dao")
@RestController
public class CommonsApplication {
	public static void main(String[] args) {
		SpringApplication.run(CommonsApplication.class, args);
	}

	@Resource
	TestMapper testMapper;
	@RequestMapping("hello")
	public void test(){
		int count = testMapper.count();
		System.out.println(count);
	}

}
