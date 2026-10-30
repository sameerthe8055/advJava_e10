package org.jsp;

public class Car {
	private int id;
	private String modelName;
	private int mileage;
	private Engine engine ;
	
	
	
	@Override
	public String toString() {
		return "Car [id=" + id + ", modelName=" + modelName + ", mileage=" + mileage + ", engine=" + engine + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public int getMileage() {
		return mileage;
	}
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	public void start() {
		System.out.println("Started");
	}
	public void stop() {
		System.out.println("Stopped");
	}
	public Engine getEngine() {
		return engine;
	}
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	
	
	
}
