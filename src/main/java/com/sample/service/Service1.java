package com.sample.service;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;

@Service
@EnableAspectJAutoProxy
public class Service1 {
	
	public void method1() {
		System.out.println("Iam method1");
	}
	
	public void method2() {
		System.out.println("Iam method2");
		throw new RuntimeException();
	}
	
	public String method3(int a) {
//		System.out.println("Iam method3");
		return "Iam method3 with id: "+ a;
	}


}
