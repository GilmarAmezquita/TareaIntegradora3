package model;
public class TechnicalAssistant extends Coach{
	private final static int MAX_EXPERTISE = 4;
	
	boolean player;
	Expertise[] expertiseSeries;
	
	public TechnicalAssistant(String name, int identifier, int salary, boolean state, int yearsExperience, boolean player, int[] numExpertises){
		super(name, identifier, salary, state, yearsExperience);
		this.player = player;
		this.expertiseSeries = new Expertise[MAX_EXPERTISE];
		enumExpertise(numExpertises);
	}
	
	public boolean getPlayer(){
		return player;
	}
	public void setPlayer(boolean player){
		this.player = player;
	}
	
	public void enumExpertise(int[] numExpertises){
		boolean added = false;
		for(int i = 0; i<MAX_EXPERTISE; i++){
			switch(numExpertises[i]){
				case 1:
					for(int j = 0; j<MAX_EXPERTISE && !added; j++){
						if(expertiseSeries[i] == null){
							this.expertiseSeries[i] = Expertise.Offensive;
							added = true;
						}
					}
					break;
				case 2:
				for(int j = 0; j<MAX_EXPERTISE && !added; j++){
						if(expertiseSeries[i] == null){
							this.expertiseSeries[i] = Expertise.Defensive;
							added = true;
						}
					}
					break;
				case 3:
				for(int j = 0; j<MAX_EXPERTISE && !added; j++){
						if(expertiseSeries[i] == null){
							this.expertiseSeries[i] = Expertise.Possesion;
							added = true;
						}
					}
					break;
				case 4:
				for(int j = 0; j<MAX_EXPERTISE && !added; j++){
						if(expertiseSeries[i] == null){
							this.expertiseSeries[i] = Expertise.Lab_plays;
							added = true;
						}
					}
					break;
			}
		}
	}
	
	public String getExpertises(){
		String content = "";
		for(int i = 0; i<MAX_EXPERTISE; i++){
			if(expertiseSeries[i] != null){
				content += "\n"+expertiseSeries[i];
			}
		}
		return content;
	}
	
	public String getInfo(){
		String content = "***************Employee***************\n";
		content += "** Work: asistente tecnico\n";
		content += "** name: "+getName()+"\n";
		content += "** Identifier: "+getIdentifier()+"\n";
		content += "** Salary: "+getSalary()+"\n";
		content += "** State: ";
		if(getState() == true){
			content += "Activo\n";
		}else content += "Inactivo\n";
		content += "** Years Exp: "+getYearsExperience()+"\n";
		content += "** Was a player: ";
		if(getPlayer() == true){
			content += "yes\n";
		}else content += "no\n";
		content += "** Expertises: "+getExpertises()+"\n";
		return content;
	}
}