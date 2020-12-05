package model;
public class HeadCoach extends Coach{
	private int teamsInRace;
	private int championshipsAchieved;
	private int marketPrice;
	private double level;
	/**
	* Constructor method of the head coachs
	* <b> pre: </b> 
	*			1. The head coach's name must be unique <br>
	*			2. The head coach's identifier must be unique <br>
	*			3. The head coach's salary can only be natural numbers <br>
	*			4. The head coach's state is true if the state is active <br>
	*			5. The head coach's state is false if the state is inactive
	* <b> post: </b> Initializes a head coach with all its information
	* @param name Head coach's name
	* @param identifier Head coach's identifier
	* @param salary Head coach's salary
	* @param state Head coach's state
	* @param yearsExperience Head coach's years of experience
	* @param teamsInRace Teams that the head coach has managed during his career
	* @param championshipsAchieved Head coach's championships won
	*/
	public HeadCoach(String name, int identifier, int salary, boolean state, int yearsExperience, int teamsInRace, int championshipsAchieved){
		super(name, identifier, salary, state, yearsExperience);
		this.teamsInRace = teamsInRace;
		this.championshipsAchieved = championshipsAchieved;
		calculateMarketPrice();
		calculateLevel();
	}
	/**
	* Get the teams that the head coach has managed
	* <b> pre: </b> <br>
	* <b> post: </b>
	* @return teamsInRace 
	*/
	public int getTeamsInRace(){
		return teamsInRace;
	}
	/**
	* Increase by 1 the teams that has managed the head coach
	* <b> pre: </b> <br>
	* <b> post: </b>
	*/
	public void increaseTeamsInRace(){
		teamsInRace++;
	}
	/**
	* Get the championships that has won a team with the head coach
	* <b> pre: </b> <br>
	* <b> post: </b>
	* @return championshipsAchieved
	*/
	public int getChampionshipAchieved(){
		return championshipsAchieved;
	}
	/**
	* Increase by 1 the championships that has won a team with the head coach
	* <b> pre: </b> <br>
	* <b> post: </b>
	*/
	public void increaseChampionshipAchieved(){
		championshipsAchieved++;
		calculateMarketPrice();
		calculateLevel();
	}
	/**
	* Get the head coach's market price 
	* <b> pre: </b> <br>
	* <b> post: </b>
	* @return marketPrice
	*/
	public int getMarketPrice(){
		return marketPrice;
	}
	/**
	* Get the head coach's level
	* <b> pre: </b> <br>
	* <b> post: </b>
	* @return level
	*/
	public double getLevel(){
		return level;
	}
	/**
	* Calculate the head coach's market price
	* <b> pre: </b> <br>
	* <b> post: </b>
	*/
	private void calculateMarketPrice(){
		this.marketPrice = (int) (getSalary()*10+getYearsExperience()*100+getChampionshipAchieved()*50);
	}
	/**
	* Calculate the head coach's level
	* <b> pre: </b> <br>
	* <b> post: </b>
	*/
	private void calculateLevel(){
		this.level = 5+getChampionshipAchieved()/10;
	}
	/**
	* Get all the information of the head coach
	* <b> pre: </b> <br>
	* <b> post: </b>
	* @return content Head coach's information
	*/
	public String getInfo(){
		String content = "***************Employee***************\n";
		content += "** Work: entrenador principal\n";
		content += "** name: "+getName()+"\n";
		content += "** Identifier: "+getIdentifier()+"\n";
		content += "** Salary: "+getSalary()+"\n";
		content += "** State: ";
		if(getState() == true){
			content += "Activo\n";
		}else content += "Inactivo\n";
		content += "** Years Exp: "+getYearsExperience()+"\n";
		content += "** Teams in Race: "+getTeamsInRace()+"\n";
		content += "** Championships Won: "+getChampionshipAchieved()+"\n";
		content += "** Market Price: "+getMarketPrice()+"\n";
		content += "** Level: "+getLevel()+"\n";
		return content;
	}
}