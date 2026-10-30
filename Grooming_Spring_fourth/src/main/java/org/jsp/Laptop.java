package org.jsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Laptop {
	private int id;
	private String name;
	private Battery battery;
	@Override
	public String toString() {
		return "Laptop [id=" + id + ", name=" + name + ", battery=" + battery + "]";
	}
	
	public int getId() {
		return id;
	}
	@Value("101")
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	@Value("Asus")
	public void setName(String name) {
		this.name = name;
	}
	public Battery getBattery() {
		return battery;
	}
	
	@Autowired
	public void setBattery(Battery battery) {
		this.battery = battery;
	}
	
	

}

