package edu.neu.CSYE6200.daycare.API;

public abstract class AbstractVaccine {

	private String name;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Vaccine [name=" + name + "]";
	}
	
	
	
	
}
