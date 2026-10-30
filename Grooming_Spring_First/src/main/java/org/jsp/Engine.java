package org.jsp;

public class Engine {
	private int id;
	private String engineName;
	private String engineType;
	
	
	
	@Override
	public String toString() {
		return "Engine [id=" + id + ", engineName=" + engineName + ", engineType=" + engineType + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEngineName() {
		return engineName;
	}
	public void setEngineName(String engineName) {
		this.engineName = engineName;
	}
	public String getEngineType() {
		return engineType;
	}
	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}
	public Engine(int id, String engineName, String engineType) {
		super();
		this.id = id;
		this.engineName = engineName;
		this.engineType = engineType;
	}

	
}
