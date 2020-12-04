package model;
public abstract class Coach extends Employee{
	private int yearsExperience;
	/**
	* Constructor mothod for coachs 
	* <b> pre: </b> 
	*			1. The coach's name must be unique <br>
	*			2. The identifier must be unique <br>
	*			3. The coach's years of experience only can be natural numbers
	* <b> post: </b>
	* @param name coach's name
	* @param identifier coach's identifier
	* @param salary coach's salary
	* @param state coach's state
	* @param yearsExperience coach's years of experience
	*/
	public Coach(String name, int identifier, int salary, boolean state, int yearsExperience){
		super(name, identifier, salary, state);
		this.yearsExperience = yearsExperience;
	}
	/**
	* Get the coach's years of experience
	* <b> pre: </b> <br>
	* <b> post: </b>
	* @return yearsExperience coach's years of experience
	*/
	public int getYearsExperience(){
		return yearsExperience;
	}
	/**
	* Increase by 1 the coach's years of experience
	* <b> pre: </b> <br>
	* <b> post: </b>
	*/
	public void increaseYearsExperience(){
		yearsExperience++;
	}
	/**
	* Abstract method to get the info of the coachs
	* <b> pre: </b> <br>
	* <b> post: </b>
	* @return String
	*/
	public abstract String getInfo();
}