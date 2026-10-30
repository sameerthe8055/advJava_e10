package org.jsp;

public class Mobile {
	private int id;
	private String modelName;
	private int ram;
	private int rom;
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
	public int getRam() {
		return ram;
	}
	public void setRam(int ram) {
		this.ram = ram;
	}
	public int getRom() {
		return rom;
	}
	public void setRom(int rom) {
		this.rom = rom;
	}
	@Override
	public String toString() {
		return "Mobile [id=" + id + ", modelName=" + modelName + ", ram=" + ram + ", rom=" + rom + "]";
	}
	
	
	

}
