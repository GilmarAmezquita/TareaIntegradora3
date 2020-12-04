package model;
import java.util.ArrayList;
import java.util.Vector;
public class Club{
	private final static int ROOM_SIZE_1 = 6;
	private final static int ROOM_SIZE_2 = 7;
	private final static int TEAMS = 2;
	
	private String name;
	private String nit;
	private String fundationDate;
	private ArrayList<Employee> employees;
	private Team[] teams;
	
	private Player[][] dressingRoom1;
	private Player[][] dressingRoom2;
	private Coach[][] officeSector;
	
	public Club(String nit, String name, String fundationDate){
		this.nit = nit;
		this.name = name;
		this.fundationDate = fundationDate;
		this.employees = new ArrayList<Employee>();
		this.teams = new Team[2];
		teams[0] = new Team("A");
		teams[1] = new Team("B");
		this.dressingRoom1 = new Player[ROOM_SIZE_2][ROOM_SIZE_1];
		this.dressingRoom2 = new Player[ROOM_SIZE_2][ROOM_SIZE_2];
		this.officeSector = new Coach[ROOM_SIZE_1][ROOM_SIZE_1];
	}
	
	public String getNit(){
		return nit;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getFundationDate(){
		return fundationDate;
	}
	
	//ADD EMPLOYEES
	public boolean findEmployee(String name){
		boolean finded = false;
		for(int i = 0; i<employees.size() && !finded; i++){
			if(employees.get(i).getName().equals(name)){
				finded = true;
			}
		}
		return finded;
	}
	public boolean addEmployee(String name, int identifier, int salary, boolean state, int tShirtNumber, int goals, double avarageQualification,int numPosition){
		boolean finded = findEmployee(name);
		boolean added = false;
		if(!finded){
			Employee newEmployee = new Player(name, identifier, salary, state, tShirtNumber, goals, avarageQualification, numPosition);
			employees.add(newEmployee);
			added = true;
		}
		return added;
	}
	public boolean addEmployee(String name, int identifier, int salary, boolean state, int yearsExperience, int teamsInRace, int championshipsAchieved){
		boolean finded = findEmployee(name);
		boolean added = false;
		if(!finded){
			Employee newEmployee = new HeadCoach(name, identifier, salary, state, yearsExperience, teamsInRace, championshipsAchieved);
			employees.add(newEmployee);
			added = true;
			Coach newCoach = (Coach) newEmployee;
			addToOfficeSector(newCoach);
		}
		return added;
	}
	public boolean addEmployee(String name, int identifier, int salary, boolean state, int yearsExperience, boolean player, int[] numExpertises){
		boolean finded = findEmployee(name);
		boolean added = false;
		if(!finded){
			Employee newEmployee = new TechnicalAssistant(name, identifier, salary, state, yearsExperience, player, numExpertises);
			employees.add(newEmployee);
			added = true;
			Coach newCoach = (Coach) newEmployee;
			addToOfficeSector(newCoach);
		}
		return added;
	}
	public boolean delateEmployee(String name, int identifier){
		boolean delated = false;
		for(int i = 0; i<employees.size() && !delated; i++){
			if(employees.get(i).getName().equals(name) && employees.get(i).getIdentifier() == identifier){
				if(employees.get(i) instanceof Coach){
					Coach delatedCoach = (Coach) employees.get(i);
					delateFromOfficeSector(delatedCoach);
				}
				employees.remove(i);
				delated = true;
			}
		}
		return delated;
	}
	private void addToOfficeSector(Coach coach){
		boolean added = false;
		for(int i = 0; i<ROOM_SIZE_1 &&  !added; i++){
			for(int j = 0; j<ROOM_SIZE_1 && !added; j++){
				if((i+j)%2==0 && officeSector[i][j]==null){
					officeSector[i][j] = coach;
					added = true;
				}
			}
		}
	}
	private void delateFromOfficeSector(Coach coach){
		boolean removed = false;
		for(int i = 0; i<ROOM_SIZE_1; i++){
			for(int j = 0; j<ROOM_SIZE_1; j++){
				if(officeSector[i][j]!=null){
					if(officeSector[i][j].getName().equals(coach.getName()) && officeSector[i][j].getIdentifier() == coach.getIdentifier()){
						officeSector[i][j] = null;
						removed = true;
					}
				}
			}
		}
	}
	public boolean assignDressingRoom(String name, int dressingRoom){
		boolean finded = false;
		int i = 0;
		for(i = 0; i<TEAMS && !finded; i++){
			if(teams[i].getName().equals(name)){
				i--;
				finded = true;
			}
		}
		boolean added = false;
		if(finded && dressingRoom==1){
			for(int j = 0; j<teams[i].players.length; j++){
				for(int k = 0; k<ROOM_SIZE_2; k++){
					for(int l = 0; l<ROOM_SIZE_1; l++){
						dressingRoom1[k][l] = null;
					}
				}
				if(teams[i].players[j] != null){
					added = false;
					for(int k = 0; k<ROOM_SIZE_2 && !added; k++){
						for(int l = 0; l<ROOM_SIZE_1 && !added; l++){
							if((k+l)%2==0 && dressingRoom1[k][l] == null){
								dressingRoom1[k][l] = teams[i].players[j];
								added = true;
							}
						}
					}
				}
			}
		}else if(finded && dressingRoom==2){
			for(int j = 0; j<teams[i].players.length; j++){
				for(int k = 0; k<ROOM_SIZE_2; k++){
					for(int l = 0; l<ROOM_SIZE_2; l++){
						dressingRoom2[k][l] = null;
					}
				}
				if(teams[i].players[j] != null){
					added = false;
					for(int k = 0; k<ROOM_SIZE_2 && !added; k++){
						for(int l = 0; l<ROOM_SIZE_2 && !added; l++){
							if((k+l)%2==0 && dressingRoom2[k][l] == null){
								dressingRoom2[k][l] = teams[i].players[j];
								added = true;
							}
						}
					}
				}
			}
		}
		return added;
	}
	public String getDressingsRooms(){
		String content = "************DRESSING ROOM 1************\n";
		for(int i = 0; i<ROOM_SIZE_2; i++){
			for(int j = 0; j<ROOM_SIZE_1; j++){
				if(dressingRoom1[i][j] != null){
					content += "1 ";
				}else content += "0 ";
			}
			content += "\n";
		}
		content += "************DRESSING ROOM 2************\n";
		for(int i = 0; i<ROOM_SIZE_2; i++){
			for(int j = 0; j<ROOM_SIZE_2; j++){
				if(dressingRoom2[i][j] != null){
					content += "1 ";
				}else content += "0 ";
			}
			content += "\n";
		}
		return content;
	}
	public String getOfficeSector(){
		String content = "************OFFICE SECTOR************\n";
		for(int i = 0; i<ROOM_SIZE_1; i++){
			for(int j = 0; j<ROOM_SIZE_1; j++){
				if(officeSector[i][j] != null){
					content += "1 ";
				}else content += "0 ";
			}
			content += "\n";
		}
		return content;
	}
	/**
	* Get all the information of the employees
	* <b> pre: </b> <br>
	* <b> post: </b>
	* @return content information of the employees
	*/
	public String getEmployeesInfo(){
		String content = "";
		for(int i = 0; i<employees.size(); i++){
			content += employees.get(i).getInfo();
		}
		return content;
	}
	/**
	* Get all the information of the players
	* <b> pre: </b> <br>
	* <b> post: </b>
	* @return content information of the players
	*/
	public String getPlayersInfo(){
		String content = "";
		for(int i = 0; i<employees.size(); i++){
			if(employees.get(i) instanceof Player){
				content += employees.get(i).getInfo();
			}
		}
		return content;
	}
	/**
	* Get all the information of the head coachs
	* <b> pre: </b> <br>
	* <b> post: </b>
	* @return content information of the head coachs
	*/
	public String getHeadCoachsInfo(){
		String content = "";
		for(int i = 0; i<employees.size(); i++){
			if(employees.get(i) instanceof HeadCoach){
				content += employees.get(i).getInfo();
			}
		}
		return content;
	}
	/**
	* Get all the information of the technical assistants
	* <b> pre: </b> <br>
	* <b> post: </b>
	* @return content information of the tecnichal assitants
	*/
	public String getTechnicalAssistantsInfo(){
		String content = "";
		for(int i = 0; i<employees.size(); i++){
			if(employees.get(i) instanceof TechnicalAssistant){
				content += employees.get(i).getInfo();
			}
		}
		return content;
	}
	public boolean addTeamHeadCoach(String name, String coachName, int identifier){
		boolean added = false;
		for(int i = 0; i<TEAMS && !added; i++){
			if(teams[i].getName().equals(name)){
				for(int j = 0; j<employees.size() && !added; j++){
					if(employees.get(j).getName().equals(coachName) && employees.get(j).getIdentifier() == identifier){
						if(employees.get(j) instanceof HeadCoach){
							HeadCoach headCoach = (HeadCoach) employees.get(i);
							teams[i].addHeadCoach(headCoach);
							added = true;
						}
					}
				}
			}
		}
		return added;
	}
	public boolean addTeamTechnicalAssistant(String name, String technicalName, int identifier){
		boolean added = false;
		for(int i = 0; i<TEAMS && !added; i++){
			if(teams[i].getName().equals(name)){
				for(int j = 0; j<employees.size() && !added; i++){
					if(employees.get(j).getName().equals(technicalName) && employees.get(j).getIdentifier() == identifier){
						if(employees.get(j) instanceof TechnicalAssistant){
							TechnicalAssistant technicalAssistant = (TechnicalAssistant) employees.get(j);
							added = teams[i].addTechnicalAssistant(technicalAssistant);
						}
					}
				}
			}
		}
		return added;
	}
	public boolean removeTeamTechnicalAssistant(String name, String technicalName, int identifier){
		boolean removed = false;
		for(int i = 0; i<TEAMS && !removed; i++){
			if(teams[i].getName().equals(name)){
				removed = teams[i].removeTechnicalAssistant(technicalName, identifier);
			}
		}
		return removed;
	}
	public boolean addTeamPlayer(String name, String playerName, int identifier){
		boolean added = false;
		for(int i = 0; i<TEAMS; i++){
			if(teams[i].getName().equals(name)){
				for(int j = 0; j<employees.size(); j++){
					if(employees.get(j).getName().equals(playerName) && employees.get(j).getIdentifier() == identifier){
						if(employees.get(j) instanceof Player){
							Player player = (Player) employees.get(j);
							added = teams[i].addPlayer(player);
						}
					}
				}
			}
		}
		return added;
	}
	public boolean removeTeamPlayer(String name, String playerName, int identifier){
		boolean removed = false;
		for(int i = 0; i<TEAMS && !removed; i++){
			if(teams[i].getName().equals(name)){
				removed = teams[i].removePlayer(playerName, identifier);
			}
		}
		return removed;
	}
	public String getTeamInfo(String name){
		String content = "";
		for(int i = 0; i<TEAMS; i++){
			if(teams[i].getName().equals(name)){
				content += teams[i].getInfo();
			}
		}
		return content;
	}
	public String getInfo(){
		String content = "************CLUB************\n";
		content += "** Name: "+getName()+"\n";
		content += "** Nit: "+getNit()+"\n";
		content += "** Fundation Date: "+getFundationDate()+"\n";
		content += "** Employees: "+employees.size()+"\n";
		return content;
	}
	public boolean addLineUpToTeam(String name, String date, int tacticNum, String formation){
		boolean added = false;
		for(int i = 0; i<TEAMS && !added; i++){
			if(teams[i].getName().equals(name)){
				added = teams[i].addLineUp(date, tacticNum, formation);
			}
		}
		return added;
	}
	public String getTeamLineUp(String name){
		boolean showed = false;
		String content = "";
		for(int i = 0; i<TEAMS && !showed; i++){
			if(teams[i].getName().equals(name)){
				content = teams[i].getLineUps();
			}
		}
		return content;
	}
}