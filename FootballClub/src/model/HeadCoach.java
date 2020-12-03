package model;
public class HeadCoach extends Coach{
	private int teamsInRace;
	private int championshipsAchieved;
	
	public HeadCoach(String name, int identifier, int salary, boolean state, int yearsExperience, int teamsInRace, int championshipsAchieved){
		super(name, identifier, salary, state, yearsExperience);
		this.teamsInRace = teamsInRace;
		this.championshipsAchieved = championshipsAchieved;
	}
	
	public int getTeamsInRace(){
		return teamsInRace;
	}
	public void increaseTeamsInRace(){
		teamsInRace++;
	}
	
	public int getChampionshipAchieved(){
		return championshipsAchieved;
	}
	public void increaseChampionshipAchieved(){
		championshipsAchieved++;
	}
	
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
		return content;
	}
}