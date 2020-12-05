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
	/**
	* Constructor method for the club
	* <b> pre: </b> <br>
	* <b> post: </b>
	* @param nit Club's nit
	* @param name Club's name
	* @param fundationDate Club's fundationDate
	*/
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
	/**
	* Get the club's nit
	* <b> pre: </b> <br>
	* <b> post: </b>
	* @return nit
	*/
	public String getNit(){
		return nit;
	}
	/**
	* Get the club's name
	* <b> pre: </b> <br>
	* <b> post: </b>
	* @return name
	*/
	public String getName(){
		return name;
	}
	/**
	* Replace the club's name
	* <b> pre: </b> <br>
	* <b> post: </b>
	* @param name New club's name
	*/
	public void setName(String name){
		this.name = name;
	}
	/**
	* Get the club's fundation date
	* <b> pre: </b> <br> 
	* <b> post: </b>
	* @return fundationDate
	*/
	public String getFundationDate(){
		return fundationDate;
	}
	/**
	* Find a employee with his name
	* <b> pre: </b> <br>
	* <b> post: </b>
	*			1. Returns true if the employee exists <br>
	*			2. Return false if the employee doesn't exist
	* @param name Employee's name
	* @return finded
	*/
	private boolean findEmployee(String name){
		boolean finded = false;
		for(int i = 0; i<employees.size() && !finded; i++){
			if(employees.get(i).getName().equals(name)){
				finded = true;
			}
		}
		return finded;
	}
	/**
	* Contract a new employee to be a player
	* <b> pre: </b> 
	*			1. The employee's name must be unique <br>
	*			2. The employee's identifier must be unique <br>
	*			3. The employee's salary must be natural numbers <br>
	*			4. The Employee's state is true if the state is active <br>
	*			5. The Employee's state is false if the state is inactive <br>
	*			6. The employee's t-shirt number must be unique <br>
	*			7. The position number can only be between 1 and 4 <br>
	* <b> post: </b>
	*			1. Returns true if the employee was added <br>
	*			2. Returns false if the employee couldn't be added
	* @param name Employee's name
	* @param identifier Employee's identifier
	* @param salary Employee's salary
	* @param state Employee's state
	* @param tShirtNumber Employee's t-shirt number
	* @param goals Employee's goals in the football club
	* @param avarageQualification Employee's avarage qualification
	* @param numPosition Employee's number position option
	* @return added
	*/
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
	/**
	* Contract a new employee to be a head coach
	* <b> pre: </b> 
	*			1. The employee's name must be unique <br>
	*			2. The employee's identifier must be unique <br>
	*			3. The employee's salary must be natural numbers <br>
	*			4. The Employee's state is true if the state is active <br>
	*			5. The Employee's state is false if the state is inactive <br>
	* <b> post: </b>
	*			1. Returns true if the employee was added <br>
	*			2. Returns false if the employee couldn't be added
	* @param name Employee's name
	* @param identifier Employee's identifier
	* @param salary Employee's salary
	* @param state Employee's state
	* @param yearsExperience Employee's years of experience
	* @param teamsInRace Teams that the employee has managed during his career
	* @param championshipsAchieved Employee's championships won
	* @return added
	*/
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
	/**
	* Contract a new employee to be a technical assistant
	* <b> pre: </b> 
	*			1. The employee's name must be unique <br>
	*			2. The employee's identifier must be unique <br>
	*			3. The employee's salary must be natural numbers <br>
	*			4. The Employee's state is true if the state is active <br>
	*			5. The Employee's state is false if the state is inactive <br>
	*			6. wasPlayer is true if the employee was a player <br>
	*			7. wasPlayer is false if the employee wasn't a player
	* <b> post: </b>
	*			1. Returns true if the employee was added <br>
	*			2. Returns false if the employee couldn't be added
	* @param name Employee's name
	* @param identifier Employee's identifier
	* @param salary Employee's salary
	* @param state Employee's state
	* @param yearsExperience Employee's years of experience
	* @param wasPlayer Employee was a player or not 
	* @param numExpertises Employee's expertises
	* @return added
	*/
	public boolean addEmployee(String name, int identifier, int salary, boolean state, int yearsExperience, boolean wasPlayer, int[] numExpertises){
		boolean finded = findEmployee(name);
		boolean added = false;
		if(!finded){
			Employee newEmployee = new TechnicalAssistant(name, identifier, salary, state, yearsExperience, wasPlayer, numExpertises);
			employees.add(newEmployee);
			added = true;
			Coach newCoach = (Coach) newEmployee;
			addToOfficeSector(newCoach);
		}
		return added;
	}
	/**
	* Throw an employee of the football club
	* <b> pre: </b> <br>
	* <b> post: </b>
	*			1. Returns true if the employee was delated <br>
	*			2. Returns false if the employee couldn't be delated
	* @param name Employee's name
	* @param identifier Employee's identifier
	* @return delated
	*/
	public boolean delateEmployee(String name, int identifier){
		boolean delated = false;
		for(int i = 0; i<employees.size() && !delated; i++){
			if(employees.get(i).getName().equals(name) && employees.get(i).getIdentifier() == identifier){
				if(employees.get(i) instanceof Coach){
					Coach delatedCoach = (Coach) employees.get(i);
					delateFromOfficeSector(delatedCoach);
				}
				if(employees.get(i) instanceof Player){
					for(int j = 0; j<TEAMS; j++){
						removeTeamPlayer(teams[i].getName(), employees.get(i).getName(), employees.get(i).getIdentifier());
					}
				}
				if(employees.get(i) instanceof TechnicalAssistant){
					for(int j = 0; j<TEAMS; j++){
						removeTeamTechnicalAssistant(teams[i].getName(), employees.get(i).getName(), employees.get(i).getIdentifier());
					}
				}
				employees.remove(i);
				delated = true;
			}
		}
		return delated;
	}
	/**
	* Add a coach to the office sector
	* <b> pre: </b> <br>
	* <b> post: </b>
	* @param coach Coach to be added
	*/
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
	/**
	* Delete a coach from the office sector
	* <b> pre: </b> <br>
	* <b> post: </b>
	* @param coach Coach to be delated
	*/
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
	/**
	* Assign dressing room to a team
	* <b> pre: </b> The dressing room number can only be 1 or 2<br>
	* <b> post: </b>
	*			1. Returns true if the dressing room was assigned <br>
	*			2. Returns false if the dressing room couldn't be assigned
	* @param name Team's name
	* @param dressingRoom Dressing room number
	* @return added
	*/
	//ASIGNA TODO EN NULL
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
		if(finded && dressingRoom == 1){
			for(int j = 0; j<ROOM_SIZE_2; j++){
				for(int k = 0; k<ROOM_SIZE_1; k++){
					dressingRoom1[j][k] = null;
				}
			}
			for(int j = 0; j<teams[i].players.length; j++){
				if(teams[i].players[j] != null){
					added = false;
					for(int k = 0; k<ROOM_SIZE_2 && !added; k++){
						for(int l = 0; l<ROOM_SIZE_1 && !added; l++){
							if((k+l)%2 == 0 && dressingRoom1[k][l] == null){
								dressingRoom1[k][l] = teams[i].players[j];
								added = true;
							}
						}
					}
				}
			}
		}else if(finded && dressingRoom==2){
			for(int j = 0; j<ROOM_SIZE_2; j++){
				for(int k = 0; k<ROOM_SIZE_2; k++){
					dressingRoom2[j][k] = null;
				}
			}
			added = false;
			for(int j = 0; j<teams[i].players.length; j++){
				if(teams[i].players[j] != null){
					added = false;
					for(int k = 0; k<ROOM_SIZE_2 && !added; k++){
						for(int l = 0; l<ROOM_SIZE_2 && !added; l++){
							if((k+l)%2 == 0 && dressingRoom2[k][l] == null){
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
	/**
	* Get an simulate image of the dressing room, 1 is an occupied space and 0 is an empty space
	* <b> pre: </b> <br>
	* <b> post: </b>
	* @return content
	*/
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
	/**
	* Get an simulate image of the office sector, 1 is an occupied space and 0 is an empty space
	* <b> pre: </b> <br>
	* <b> post: </b>
	* @return content
	*/
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
	/**
	* Add a head coach to a team
	* <b> pre: </b> <br>
	* <b> post: </b>
	*			1. Returns true if the head coach was added <br>
	*			2. Returns false if the head coach couldn't be added
	* @param name Team's name
	* @param coachName Coach's name
	* @param identifier Coach's identifier
	* @return added
	*/
	public boolean addTeamHeadCoach(String name, String coachName, int identifier){
		boolean added = false;
		for(int i = 0; i<TEAMS && !added; i++){
			if(teams[i].getName().equals(name)){
				for(int j = 0; j<employees.size() && !added; j++){
					if(employees.get(j).getName().equals(coachName) && employees.get(j).getIdentifier() == identifier){
						if(employees.get(j) instanceof HeadCoach){
							HeadCoach headCoach = (HeadCoach) employees.get(j);
							teams[i].addHeadCoach(headCoach);
							added = true;
						}
					}
				}
			}
		}
		return added;
	}
	/**
	* Add a technical assistant to a team
	* <b> pre: </b> <br>
	* <b> post: </b>
	*			1. Returns true if the technical assistant was added <br>
	*			2. Returns false if the technical assistant couldn't be added
	* @param name Team's name
	* @param technicalName Technical assistant's name
	* @param identifier Technical assistant's identifier
	* @return added
	*/
	public boolean addTeamTechnicalAssistant(String name, String technicalName, int identifier){
		boolean added = false;
		for(int i = 0; i<TEAMS && !added; i++){
			if(teams[i].getName().equals(name)){
				for(int j = 0; j<employees.size() && !added; j++){
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
	/**
	* Add a player to a team
	* <b> pre: </b> <br>
	* <b> post: </b>
	*			1. Returns true if the player was added <br>
	*			2. Returns false if the player couldn't be added
	* @param name Team's name
	* @param playerName Player's name
	* @param identifier Player's identifier
	* @return added
	*/
	public boolean addTeamPlayer(String name, String playerName, int identifier){
		boolean added = false;
		for(int i = 0; i<TEAMS && !added; i++){
			if(teams[i].getName().equals(name)){
				for(int j = 0; j<employees.size() && !added; j++){
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
	/**
	* Removed the head coach from a team
	* <b> pre: </b> <br>
	* <b> post: </b>
	*			1. Returns true if the head coach was removed <br>
	*			2. Returns false if the head coach couldn't be removed
	* @param name Team's name
	* @param coachName Head coach's name
	* @param identifier Head coach's identifier
	* @return removed
	*/
	public boolean removeTeamHeadCoach(String name, String coachName, int identifier){
		boolean removed = false;
		for(int i = 0; i<TEAMS && !removed; i++){
			if(teams[i].getName().equals(name)){
				removed = teams[i].removeHeadCoach(coachName, identifier);
			}
		}
		return removed;
	}
	/**
	* Remove a technical assistant from a team
	* <b> pre: </b> <br>
	* <b> post: </b>
	*			1. Returns true if the technical assistant was removed
	*			2. Returns false if the technical assistant couldn't be removed
	* @param name Team's name
	* @param technicalName Technical assistant's name
	* @param identifier Technical assistant's identifier
	* @return removed
	*/
	public boolean removeTeamTechnicalAssistant(String name, String technicalName, int identifier){
		boolean removed = false;
		for(int i = 0; i<TEAMS && !removed; i++){
			if(teams[i].getName().equals(name)){
				removed = teams[i].removeTechnicalAssistant(technicalName, identifier);
			}
		}
		return removed;
	}
	/**
	* Remove a player from a team
	* <b> pre: </b> <br>
	* <b> post: </b>
	*			1. Returns true if the player was removed
	*			2. Returns false if the player couldn't be removed
	* @param name Team's name
	* @param playerName Player's name
	* @param identifier Player's identifier
	* @return removed
	*/
	public boolean removeTeamPlayer(String name, String playerName, int identifier){
		boolean removed = false;
		for(int i = 0; i<TEAMS && !removed; i++){
			if(teams[i].getName().equals(name)){
				removed = teams[i].removePlayer(playerName, identifier);
			}
		}
		return removed;
	}
	/**
	* Add a line-up to a team
	* <b> pre: </b> 
	*			1. The tactic number can only be between 1 and 4<br>
	*			2. The formation components must sume 10
	* <b> post: </b>
	*			1. Returns true if the line-up was added <br>
	*			2. Returns false if the line-up couldn't be added
	* @param name Team's name
	* @param date Date to be used the line-up
	* @param tacticNum Tactic number option
	* @param formation Formation to be used
	* @return added
	*/
	public boolean addLineUpToTeam(String name, String date, int tacticNum, String formation){
		boolean added = false;
		for(int i = 0; i<TEAMS && !added; i++){
			if(teams[i].getName().equals(name)){
				added = teams[i].addLineUp(date, tacticNum, formation);
			}
		}
		return added;
	}
	/**
	* Get the team's information
	* <b> pre: </b> <br>
	* <b> post: </b>
	* @param name Team's name
	* @return content
	*/
	public String getTeamInfo(String name){
		String content = "";
		for(int i = 0; i<TEAMS; i++){
			if(teams[i].getName().equals(name)){
				content += teams[i].getInfo();
			}
		}
		return content;
	}
	/**
	* Get the club's information
	* <b> pre: </b> <br>
	* <b> post: </b>
	* @return content
	*/
	public String getInfo(){
		String content = "************CLUB************\n";
		content += "** Name: "+getName()+"\n";
		content += "** Nit: "+getNit()+"\n";
		content += "** Fundation Date: "+getFundationDate()+"\n";
		content += "** Employees: "+employees.size()+"\n";
		content += "** Teams:";
		for(int i = 0; i<TEAMS; i++){
			content += "\n** "+teams[i].getName();
		}
		return content;
	}
	/**
	* Get the line-ups information of a team
	* <b> pre: </b> <br>
	* <b> post: </b>
	* @param name Team's name
	* @return content
	*/
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