package model;
public class HeadCoach extends Coach{
	private int teamsInRace;
	private int championshipsAchieved;
	private int marketPrice;
	private double level;
	/**
	*
	* <b> pre: </b> <br>
	* <b> post: </b>
	*/
	public HeadCoach(String name, int identifier, int salary, boolean state, int yearsExperience, int teamsInRace, int championshipsAchieved){
		super(name, identifier, salary, state, yearsExperience);
		this.teamsInRace = teamsInRace;
		this.championshipsAchieved = championshipsAchieved;
		calculateMarketPrice();
		calculateLevel();
	}
	/**
	*
	* <b> pre: </b> <br>
	* <b> post: </b>
	*/
	public int getTeamsInRace(){
		return teamsInRace;
	}
	/**
	*
	* <b> pre: </b> <br>
	* <b> post: </b>
	*/
	public void increaseTeamsInRace(){
		teamsInRace++;
	}
	/**
	*
	* <b> pre: </b> <br>
	* <b> post: </b>
	*/
	public int getChampionshipAchieved(){
		return championshipsAchieved;
	}
	/**
	*
	* <b> pre: </b> <br>
	* <b> post: </b>
	*/
	public void increaseChampionshipAchieved(){
		championshipsAchieved++;
		calculateMarketPrice();
		calculateLevel();
	}
	/**
	*
	* <b> pre: </b> <br>
	* <b> post: </b>
	*/
	public int getMarketPrice(){
		return marketPrice;
	}
	/**
	*
	* <b> pre: </b> <br>
	* <b> post: </b>
	*/
	public double getLevel(){
		return level;
	}
	/**
	*
	* <b> pre: </b> <br>
	* <b> post: </b>
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
	/**
	*
	* <b> pre: </b> <br>
	* <b> post: </b>
	*/
	private void calculateMarketPrice(){
		this.marketPrice = (int) (getSalary()*10+getYearsExperience()*100+getChampionshipAchieved()*50);
	}
	/**
	*
	* <b> pre: </b> <br>
	* <b> post: </b>
	*/
	private void calculateLevel(){
		this.level = 5+getChampionshipAchieved()/10;
	}
}