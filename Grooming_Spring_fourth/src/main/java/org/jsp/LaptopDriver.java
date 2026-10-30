package org.jsp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LaptopDriver {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		Laptop laptop = context.getBean(Laptop.class);
		System.out.println(laptop);
	}
}
