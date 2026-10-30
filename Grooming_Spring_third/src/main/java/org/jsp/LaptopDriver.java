package org.jsp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LaptopDriver {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("app.xml");
		Laptop laptop = context.getBean(Laptop.class);
		System.out.println(laptop);
	}
}
