package model;
public class Player extends Employee{
	
	private int tShirtNumber;
	private int goals;
	private double avarageQualification;
	private Position position;
	private int marketPrice;
	private double level;
	
	public Player(String name, int identifier, int salary, boolean state, int tShirtNumber, int goals, double avarageQualification, int numPosition){
		super(name, identifier, salary, state);
		this.tShirtNumber = tShirtNumber;
		this.goals = goals;
		this.avarageQualification = avarageQualification;
		enumPosition(numPosition);
		calculateMarketPrice();
		calculateLevel();
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
		calculateMarketPrice();
		calculateLevel();
	}
	
	public double getAvarageQualification(){
		return avarageQualification;
	}
	public void setAvarageQualification(double avarageQualification){
		this.avarageQualification = avarageQualification;
		calculateMarketPrice();
		calculateLevel();
	}
	
	public Position getPosition(){
		return position;
	}
	public void enumPosition(int numPosition){
		switch(numPosition){
			case 1:
				this.position = Position.Goal_keeper;
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
	
	public int getMarketPrice(){
		return marketPrice;
	}
	public double getLevel(){
		return level;
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
		content += "** Market Price: "+getMarketPrice()+"\n";
		content += "** Level: "+getLevel()+"\n";
		return content;
	}
	private void calculateMarketPrice(){
		if(getPosition() == Position.Goal_keeper){
			this.marketPrice = (int) (getSalary()*12+getAvarageQualification()*150);
		}else if(getPosition() == Position.Defender){
			this.marketPrice = (int) (getSalary()*13+getAvarageQualification()*125+getGoals()*100);
		}else if(getPosition() == Position.Midfielder){
			this.marketPrice = (int) (getSalary()*14+getAvarageQualification()*135+getGoals()*125);	
		}else if(getPosition() == Position.Forward){
			this.marketPrice = (int) (getSalary()*15+getAvarageQualification()*145+getGoals()*150);
		}
	}
	private void calculateLevel(){
		if(getPosition() == Position.Goal_keeper){
			this.level = getAvarageQualification()*0.9;
		}else if(getPosition() == Position.Defender){
			this.level = getAvarageQualification()*0.9+getGoals()/100;
		}else if(getPosition() == Position.Midfielder){
			this.level = getAvarageQualification()*0.9+getGoals()/90;
		}else if(getPosition() == Position.Forward){
			this.level = getAvarageQualification()*0.9+getGoals()/90;
		}
	}
}