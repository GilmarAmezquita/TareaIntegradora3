package model;
public abstract class Employee{
	private String name;
	private int identifier;
	private int salary;
	private boolean state;
	/**
	* Construct method for the employees
	* <b> pre: </b> 
	*			1. The Employee's name must be unique <br>
	*			2. The Employee's identifier must be unique <br>
	*			3. The Employee's salary only can be natural numbers <br>
	*			4. The Employee's state is true if the state is active <br>
	*			5. The Employee's state is false if the state is inactive
	* <b> post: </b>
	* @param name Employee's name
	* @param identifier Employee's identifier
	* @param salary Employee's salary
	* @param state Employee's state
	*/
	public Employee(String name, int identifier, int salary, boolean state){
		this.name = name;
		this.identifier = identifier;
		this.salary = salary;
		this.state = state;
	}
	/**
	* Get the employee's name
	* <b> pre: </b> <br>
	* <b> post: </b>
	* @return name Employee's name
	*/
	public String getName(){
		return name;
	}
	/**
	* Replace the employee's name
	* <b> pre: </b> The new employee's name must be unique <br>
	* <b> post: </b>
	* @param name New employee's name
	*/
	public void setName(String name){
		this.name = name;
	}
	/**
	* Get the employee's identifier
	* <b> pre: </b> <br>
	* <b> post </b>
	* @return identifier Employee's identifier
	*/
	public int getIdentifier(){
		return identifier;
	}
	/**
	* Get the employee's salary
	* <b> pre: </b> <br>
	* <b> post: </b>
	* @return salary Employee's salary
	*/
	public int getSalary(){
		return salary;
	}
	/**
	* Replace the employee's salary
	* <b> pre: </b> <br>
	* <b> post: </b>
	* @param salary New employee's salary
	*/
	public void setSalary(int salary){
		this.salary = salary;
	}
	/**
	* Get the employee's state
	* <b> pre: </b> 
	*			1. Returns true if the employee's state is active <br>
	*			2. Returns false if the employee's state is inactive
	* <b> post: </b>
	* @return state
	*/
	public boolean getState(){
		return state;
	}
	/**
	* Replace the employee's state
	* <b> pre: </b> <br>
	* <b> post: </b>
	* @param state New employee's state
	*/
	public void setState(boolean state){
		this.state = state;
	}
	/**
	* Abstract method to get the information of the employee
	* <b> pre: </b> <br>
	* <b> post: </b>
	* @return String
	*/
	public abstract String getInfo();
}