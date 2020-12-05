package model;
import java.util.ArrayList;
public class Team{
	private final static int MAX_PLAYERS = 25;
	private final static int TECHNICAL_ASSISTANTS = 3;
	private String name;
	private HeadCoach headCoach;
	private TechnicalAssistant[] technicalAssistants;
	public Player[] players;
	private ArrayList<LineUp> lineUps;
	/**
	* Constructor method for a team
	* <b> pre: </b> <br>
	* <b> post: </b> Initializes a team
	* @param name Team's name
	*/
	public Team(String name){
		this.name = name;
		this.technicalAssistants = new TechnicalAssistant[TECHNICAL_ASSISTANTS];
		this.players = new Player[MAX_PLAYERS];
		this.lineUps = new ArrayList<LineUp>();
	}
	/**
	* Get the team's name
	* <b> pre: </b> <br>
	* <b> post: </b>
	* @return name Team's name
	*/
	public String getName(){
		return name;
	}
	/**
	* Look for a player in the technical assistants array
	* <b> pre: </b> <br>
	* <b> post: </b>
	*			1. Returns true if the technical assistant was finded <br>
	*			2. Returns false if the technical assistant couldn't be finded
	* @param name Technical assistant's name
	* @return finded
	*/
	private boolean findTechnicalAssistant(String name){
		boolean finded = false;
		for(int i = 0; i<TECHNICAL_ASSISTANTS && !finded; i++){
			if(technicalAssistants[i] != null){
				if(technicalAssistants[i].getName().equals(name)){
					finded = true;
				}
			}
		}
		return finded;
	}
	/**
	* Look for a player in the players array
	* <b> pre: </b> <br>
	* <b> post: </b>
	*			1. Returns true if the player was finded <br>
	*			2. Returns false if the player couldn't be finded
	* @param name Player's name
	* @return finded
	*/
	private boolean findPlayer(String name){
		boolean finded = false;
		for(int i = 0; i<MAX_PLAYERS && !finded; i++){
			if(players[i] != null){
				if(players[i].getName().equals(name)){
					finded = true;
				}
			}
		}
		return finded;
	}
	/**
	* Add the team head coach
	* <b> pre: </b> <br>
	* <b> post: </b>
	* @param headCoach Team's head coach
	*/
	public void addHeadCoach(HeadCoach headCoach){
		this.headCoach = headCoach;
	}
	/**
	* Add a technical assistant to the team
	* <b> pre: </b> <br>
	* <b> post: </b>
	*			1. Returns true if the technical assistant was added <br>
	*			2. Returns false if the technical assistant couldn't be added
	* @param technicalAssistant The technical assistant to be added
	* @return added
	*/
	public boolean addTechnicalAssistant(TechnicalAssistant technicalAssistant){
		boolean finded = findTechnicalAssistant(technicalAssistant.getName());
		boolean added = false;
		if(!finded){
			for(int i = 0; i<TECHNICAL_ASSISTANTS && !added; i++){
				if(technicalAssistants[i] == null){
					technicalAssistants[i] = technicalAssistant;
					added = true;
				}
			}
		}
		return added;
	}
	/**
	* Add a player to the team
	* <b> pre: </b> <br>
	* <b> post: </b>
	*			1. Returns true if the player was added <br>
	*			2. Returns false if the player couldn't be added
	* @param player The player to be added
	* @return added
	*/
	public boolean addPlayer(Player player){
		boolean finded = findPlayer(player.getName());
		boolean added = false;
		if(!finded){
			for(int i = 0; i<MAX_PLAYERS && !added; i++){
				if(players[i] == null){
					players[i] = player;
					added = true;
				}
			}
		}
		return added;
	}
	/**
	* Remove the head coach from the team
	* <b> pre: </b> <br>
	* <b> post: </b>
	* 			1. Returns true if the coach was removed <br>
	*			2. Returns false if the coach couldn't be removed
	* @param name Head coach's name
	* @param identifier Head coach's identifier
	* @return removed
	*/
	public boolean removeHeadCoach(String name, int identifier){
		boolean removed = false;
		if(headCoach.getName().equals(name) && headCoach.getIdentifier() == identifier){
			headCoach = null;
			removed = true;
		}
		return removed;
	}
	/**
	* Remove a technical assistant from the team
	* <b> pre: </b> <br>
	* <b> post: </b>
	*			1. Returns true if the technical assistant was removed <br>
	*			2. Returns false if the technical assistant couldn't be removed
	* @param name Technical assistant's name
	* @param identifier Technical assistant's identifier
	* @return removed
	*/
	public boolean removeTechnicalAssistant(String name, int identifier){
		boolean finded = findTechnicalAssistant(name);
		boolean removed = false;
		if(finded){
			for(int i = 0; i<TECHNICAL_ASSISTANTS && !removed; i++){
				if(technicalAssistants[i].getName().equals(name) && technicalAssistants[i].getIdentifier() == identifier){
					technicalAssistants[i] = null;
					removed = true;
				}
			}
		}
		return removed;
	}
	/**
	* Remove a player from the team
	* <b> pre: </b> <br>
	* <b> post: </b>
	*			1. Returns true if the player was removed <br>
	*			2. Returns false if the player couldn't be removed
	* @param name Player's name
	* @param identifier Player's identifier
	* @return removed
	*/
	public boolean removePlayer(String name, int identifier){
		boolean finded = findPlayer(name);
		boolean removed = false;
		if(finded){
			for(int i = 0; i<MAX_PLAYERS && !removed; i++){
				if(players[i].getName().equals(name) && players[i].getIdentifier() == identifier){
					players[i] = null;
					removed = true;
				}
			}
		}
		return removed;
	}
	/**
	* Add a line-up to the team
	* <b> pre: </b> 
	*			1. The tactic number can only be between 1 and 4<br>
	*			2. The formation components must sume 10
	* <b> post: </b>
	*			1. Returns true if the line-up was added <br>
	*			2. Returns false if the line-up couldn't be added
	* @param date Line-up date
	* @param numTactic Tactic number option
	* @param formation Line-up formation
	* @return added
	*/
	public boolean addLineUp(String date, int numTactic, String formation){
		boolean added = false;
		LineUp newLineUp = new LineUp(date, numTactic, formation);
		lineUps.add(newLineUp);
		added = true;
		return added;
	}
	/**
	* Get the Team information without line-ups
	* <b> pre: </b> <br>
	* <b> post: </b>
	* @return content Team's information
	*/
	public String getInfo(){
		String content = "***************TEAM***************\n";
		content += "** Name: "+getName()+"\n";
		if(headCoach != null){
			content += headCoach.getInfo();
		}
		for(int i = 0; i<TECHNICAL_ASSISTANTS; i++){
			if(technicalAssistants[i]!=null){
				content += technicalAssistants[i].getInfo();
			}
		}
		for(int i = 0; i<MAX_PLAYERS; i++){
			if(players[i] != null){
				content += players[i].getInfo();
			}
		}
		content += "***************TEAM***************";
		return content;
	}
	/**
	* Get the team's line-ups
	* <b> pre: </b> <br>
	* <b> post: </b>
	* @return content Line-ups
	*/
	public String getLineUps(){
		String content = "";
		for(int i = 0; i<lineUps.size(); i++){
			content += lineUps.get(i).getInfo();
		}
		return content;
	}
}