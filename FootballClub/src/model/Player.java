package model;
public class Player extends Employee{
	
	private int tShirtNumber;
	private int goals;
	private double avarageQualification;
	private Position position;
	
	public Player(String name, int identifier, int salary, boolean state, int tShirtNumber, int goals, double avarageQualification, int numPosition){
		super(name, identifier, salary, state);
		this.tShirtNumber = tShirtNumber;
		this.goals = goals;
		this.avarageQualification = avarageQualification;
		enumPosition(numPosition);
	}
	
	public int getTShirtNumber(){
		return tShirtNumber;
	}
	
	public void setTShirtNumber(int tShirtNumber){
		this.tShirtNumber = tShirtNumber;
	}
	
	public int getGoals(){
		return goals;
	}
	
	public void increaseGoals(){
		goals++;
	}
	
	public double getAvarageQualification(){
		return avarageQualification;
	}
	
	public Position getPosition(){
		return position;
	}
	public void enumPosition(int numPosition){
		switch(numPosition){
			case 1:
				this.position = Position.Gaol_keeper;
				break;
			case 2:
				this.position = Position.Defender;
				break;
			case 3: 
				this.position = Position.Midfielder;
				break;
			case 4:
				this.position = Position.Forward;
		}
	}
	public String getInfo(){
		String content = "***************Employee***************\n";
		content += "** Work: jugador\n";
		content += "** name: "+getName()+"\n";
		content += "** Identifier: "+getIdentifier()+"\n";
		content += "** Salary: "+getSalary()+"\n";
		content += "** State: ";
		if(getState() == true){
			content += "Activo\n";
		}else content += "Inactivo\n";
		content += "** tShir Number: "+getTShirtNumber()+"\n";
		content += "** Goals: "+getGoals()+"\n";
		content += "** Avarage Qualification: "+getAvarageQualification()+"\n";
		content += "** Position: "+getPosition()+"\n";
		return content;
	}
}