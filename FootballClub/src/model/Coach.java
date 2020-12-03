package model;
public abstract class Coach extends Employee{
	private int yearsExperience;
	
	public Coach(String name, int identifier, int salary, boolean state, int yearsExperience){
		super(name, identifier, salary, state);
		this.yearsExperience = yearsExperience;
	}
	
	public int getYearsExperience(){
		return yearsExperience;
	}
	
	public void increaseYearsExperience(){
		yearsExperience++;
	}
	public abstract String getInfo();
}