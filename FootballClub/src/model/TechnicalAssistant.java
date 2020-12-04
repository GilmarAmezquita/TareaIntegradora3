package model;
public class TechnicalAssistant extends Coach{
	private final static int MAX_EXPERTISE = 4;
	boolean wasPlayer;
	Expertise[] expertiseSeries;
	/**
	* Constructor method of the technical assistant
	* <b> pre: </b> 
	*			1. The technical's name must be unique <br>
	*			2. The technical's identifier must be unique <br>
	*			3. The technical's salary only can be natural numbers <br>
	*			4. The technical's state is true if the state is active <br>
	*			5. The technical's state is false if the state is inactive <br>
	*			6. The technical's boolean player is true if the technical was a player <br>
	*			7. The technical's boolean player is false if the technical wasn't a player <br>
	*			8. The technical's max expertises is four
	* <b> post: </b> Initializes a technical assistant with all its information
	* @param name Technical's name
	* @param identifier Technical's identifier
	* @param salary Technical's salaray
	* @param state Technical's state
	* @param yearsExperience Technical's years of experience
	* @param player If the technical was a player or not
	* @param numExpertises Technical's expertises
	*/
	public TechnicalAssistant(String name, int identifier, int salary, boolean state, int yearsExperience, boolean wasPlayer, int[] numExpertises){
		super(name, identifier, salary, state, yearsExperience);
		this.wasPlayer = wasPlayer;
		this.expertiseSeries = new Expertise[MAX_EXPERTISE];
		enumExpertise(numExpertises);
	}
	/**
	* Get if the technical assistant was a player or not
	* <b> pre: </b> <br>
	* <b> post: </b>
	*			1. Returns true if the technical assistant was a plyer <br>
	*			2. Returns false if the technical assistant wasn't a player
	*/
	public boolean getWasPlayer(){
		return wasPlayer;
	}
	/**
	* Set if the technical assistant was a player or not
	* <b> pre: </b> <br>
	* <b> post: </b> Change if the technical assistant was or not a player
	*/
	public void setWasPlayer(boolean wasPlayer){
		this.wasPlayer = wasPlayer;
	}
	/**
	* Set the expertises of the technical assistant
	* <b> pre: </b> The numExpertises must have at least one number between 1 and 4 and a maximum of four<br>
	* <b> post: </b>
	* @param numExpertises Array of the technical's expertises
	*/
	public void enumExpertise(int[] numExpertises){
		for(int i = 0; i<MAX_EXPERTISE; i++){
			for(int j = 0; j<MAX_EXPERTISE; j++){
				if(i!=j){
					if(numExpertises[i] == numExpertises[j]){
						numExpertises[j] = 0;
					}
				}
			}
		}
		boolean added = false;
		for(int i = 0; i<MAX_EXPERTISE; i++){
			added = false;
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
			}
		}
	}
	/**
	* Get the expertises of the technical assistant
	* <b> pre: </b> <br>
	* <b> post: </b>
	* @return content Returns the technical's expertises
	*/
	public String getExpertises(){
		String content = "";
		for(int i = 0; i<MAX_EXPERTISE; i++){
			if(expertiseSeries[i] != null){
				content += "\n** "+expertiseSeries[i];
			}
		}
		return content;
	}
	/**
	* Get all the information of the technical assistant
	* <b> pre: </b> <br>
	* <b> post: </b>
	* @return content The technical's information
	*/
	public String getInfo(){
		String content = "***************Employee***************\n";
		content += "** Work: Asistente tecnico\n";
		content += "** name: "+getName()+"\n";
		content += "** Identifier: "+getIdentifier()+"\n";
		content += "** Salary: "+getSalary()+"\n";
		content += "** State: ";
		if(getState() == true){
			content += "Activo\n";
		}else content += "Inactivo\n";
		content += "** Years Exp: "+getYearsExperience()+"\n";
		content += "** Was a player: ";
		if(getWasPlayer() == true){
			content += "yes\n";
		}else content += "no\n";
		content += "** Expertises: "+getExpertises()+"\n";
		return content;
	}
}