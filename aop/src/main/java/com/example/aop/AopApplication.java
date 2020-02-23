package com.example.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@ComponentScan(basePackages = {"com"})
@EnableAspectJAutoProxy
public class AopApplication implements CommandLineRunner {
	@Autowired
	private DemoBean demoBean;

	public static void main(String[] args) {
		SpringApplication.run(AopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		demoBean.newMethod();
		try {
			demoBean.throwRuntimeException();
		} catch (Exception e) {
		}
		demoBean.returnString();
	}
}
