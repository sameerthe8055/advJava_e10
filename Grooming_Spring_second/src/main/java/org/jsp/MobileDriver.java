package org.jsp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContextExtensionsKt;

public class MobileDriver {
	public static void main(String[] args) {
		ApplicationContext context =  new AnnotationConfigApplicationContext(AppConfig.class);
		
		System.out.println(context.getBean("mobile1"));
		System.out.println(context.getBean(AppConfig.class));
	}

}
