package org.jsp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Battery {
	private int id;
	private String batteryName;
	private int capacity;
	@Override
	public String toString() {
		return "Battery [id=" + id + ", batteryName=" + batteryName + ", capacity=" + capacity + "]";
	}
	public Battery(@Value("101") int id,@Value("AsusBattery") String batteryName,@Value("45000") int capacity) {
		super();
		this.id = id;
		this.batteryName = batteryName;
		this.capacity = capacity;
	}
	
	

}
