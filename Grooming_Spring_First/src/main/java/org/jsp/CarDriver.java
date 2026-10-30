package org.jsp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CarDriver {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("car.xml");
		
		Car car = context.getBean(Car.class);
		car.start();
		System.out.println(car);
		System.out.println(car.getEngine());
		car.stop();
	}

}
