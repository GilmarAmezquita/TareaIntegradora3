package model;
public abstract class Employee{
	
	private String name;
	private int identifier;
	private int salary;
	private boolean state;
	
	public Employee(String name, int identifier, int salary, boolean state){
		this.name = name;
		this.identifier = identifier;
		this.salary = salary;
		this.state = state;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public int getIdentifier(){
		return identifier;
	}
	
	public int getSalary(){
		return salary;
	}
	
	public void setSalary(int salary){
		this.salary = salary;
	}
	
	public boolean getState(){
		return state;
	}
	
	public void setState(boolean state){
		this.state = state;
	}
	public abstract String getInfo();
}