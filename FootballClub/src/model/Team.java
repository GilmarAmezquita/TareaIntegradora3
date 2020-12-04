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
	
	public Team(String name){
		this.name = name;
		this.technicalAssistants = new TechnicalAssistant[TECHNICAL_ASSISTANTS];
		this.players = new Player[MAX_PLAYERS];
		this.lineUps = new ArrayList<LineUp>();
	}
	
	public String getName(){
		return name;
	}
	
	public void addHeadCoach(HeadCoach headCoach){
		this.headCoach = headCoach;
	}
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
	public boolean addPlayer(Player player){
		boolean finded = findPlayer(player.getName());
		boolean added = false;
		if(!finded){
			for(int i = 0; i<MAX_PLAYERS; i++){
				if(players[i] == null){
					players[i] = player;
					added = true;
				}
			}
		}
		return added;
	}
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
	public boolean addLineUp(String date, int numTactic, String formation){
		boolean added = false;
		LineUp newLineUp = new LineUp(date, numTactic, formation);
		lineUps.add(newLineUp);
		added = true;
		return added;
	}
	
	public String getInfo(){
		String content = "***************TEAM***************\n";
		content += "** Name: "+getName()+"\n";
		content += headCoach.getInfo();
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
	
	public String getLineUps(){
		String content = "";
		for(int i = 0; i<lineUps.size(); i++){
			content += lineUps.get(i).getInfo();
		}
		return content;
	}
}