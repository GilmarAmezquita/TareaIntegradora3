package model;
public class Player extends Employee{
	private int tShirtNumber;
	private int goals;
	private double avarageQualification;
	private Position position;
	private int marketPrice;
	private double level;
	/**
	* Constructor method of the players
	* <b> pre: </b> 
	*			1. The player's name must be unique <br>
	*			2. The player's identifier must be unique <br>
	*			3. The player's salary only can be natural numbers <br>
	*			4. The player's state is true if the state is active <br>
	*			5. The player's state is false if the state is inactive <br>
	*			6. The player's tShirtNumber must be unique <br>
	*			7. The player's avarageQualification only can be positive real numbers
	*			8. The player's position number can only be between 1 and 4
	* <b> post: </b> Initializes a player with all its information
	* @param name Player's name
	* @param identifier Player's identifier
	* @param salary Player's salary
	* @param state Player's state
	* @param tShirtNumber Player's t-shirt number
	* @param goals Player's goals in the football club
	* @param avarageQualification Player's avarage qualification
	* @param numPosition Player's position number that plays
	*/
	public Player(String name, int identifier, int salary, boolean state, int tShirtNumber, int goals, double avarageQualification, int numPosition){
		super(name, identifier, salary, state);
		this.tShirtNumber = tShirtNumber;
		this.goals = goals;
		this.avarageQualification = avarageQualification;
		enumPosition(numPosition);
		calculateMarketPrice();
		calculateLevel();
	}
	/**
	* Get the player's t-shirt number
	* <b> pre: </b> <br>
	* <b> post: </b> 
	* @return tShirtNumber Player's t-shirt number
	*/
	public int getTShirtNumber(){
		return tShirtNumber;
	}
	/**
	* Replace the player's t-shirt number
	* <b> pre: </b> The new t-shirt number must be unique<br>
	* <b> post: </b>
	* @param tShirtNumber
	*/
	public void setTShirtNumber(int tShirtNumber){
		this.tShirtNumber = tShirtNumber;
	}
	/**
	* Get the player's goals in the football club
	* <b> pre: </b> <br>
	* <b> post: </b>
	* @return goals Player's goals
	*/
	public int getGoals(){
		return goals;
	}
	/**
	* Increase by 1 the player's goals in the football club
	* <b> pre: </b> <br>
	* <b> post: </b>
	*/
	public void increaseGoals(){
		goals++;
		calculateMarketPrice();
		calculateLevel();
	}
	/**
	* Get the player's avarage qualification
	* <b> pre: </b> <br>
	* <b> post: </b>
	* @return avarageQualification Player's avarage qualification
	*/
	public double getAvarageQualification(){
		return avarageQualification;
	}
	/**
	* Replace the player's avarage qualification
	* <b> pre: </b> <br>
	* <b> post: </b>
	* @avarageQualification new avarage qualification
	*/
	public void setAvarageQualification(double avarageQualification){
		this.avarageQualification = avarageQualification;
		calculateMarketPrice();
		calculateLevel();
	}
	/**
	* Get the player's position in the games
	* <b> pre: </b> <br>
	* <b> post: </b>
	* @return position
	*/
	public Position getPosition(){
		return position;
	}
	/**
	* Calculate the player's position depending the option (numPosition)
	* <b> pre: </b> <br>
	* <b> post: </b>
	* @param numPosition Option from the menu
	*/
	private void enumPosition(int numPosition){
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
	/**
	* Get the player's market price
	* <b> pre: </b> <br>
	* <b> post: </b>
	* @return marketPrice
	*/
	public int getMarketPrice(){
		return marketPrice;
	}
	/**
	* Get the player's level  in the football club
	* <b> pre: </b> <br>
	* <b> post: </b>
	* @return level Level of the player in the football club
	*/
	public double getLevel(){
		return level;
	}
	/**
	* Calculate the player's market price
	* <b> pre: </b> <br>
	* </b> post: </b>
	*/
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
	/**
	* Calculate the player's level in the football club
	* <b> pre: </b> <br>
	* <b> post: </b>
	*/
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
	/**
	* Get the player's information
	* <b> pre: </b> <br>
	* <b> post: </b>
	* @return content The information of the player
	*/
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
}