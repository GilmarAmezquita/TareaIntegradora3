package ui;
import model.*;
import java.util.Scanner;
public class Menu{
	private final static int CONTRACT_PLAYER = 1;
	private final static int CONTRACT_HEAD_COACH = 2;
	private final static int CONTRACT_TECHNICAL_ASSISTANT = 3;
	
	private final static int CONTRACT_EMPLOYEE = 1;
	private final static int THROW_EMPLOYEE = 2;
	private final static int TEAM_ADD_HEAD_COACH = 3;
	private final static int TEAM_ADD_TECHNICAL_ASSISTANT = 4;
	private final static int TEAM_ADD_PLAYER = 5;
	private final static int TEAM_REMOVE_HEAD_COACH = 6;
	private final static int TEAM_REMOVE_TECHNICAL_ASSISTANT = 7;
	private final static int TEAM_REMOVE_PLAYER = 8;
	private final static int ASSIGN_TEAM_DRESSING_ROOM = 9;
	private final static int TEAM_ADD_LINE_UP = 10;
	private final static int PRINT_TEAM_INFO = 11;
	private final static int PRINT_TEAM_LINE_UPS = 12;
	private final static int PRINT_EMPLOYEES = 13;
	private final static int PRINT_PLAYERS = 14;
	private final static int PRINT_HEAD_COACHS = 15;
	private final static int PRINT_TECHNICAL_ASSISTANTS = 16;
	private final static int PRINT_CLUB_INFO = 17;
	private final static int PRINT_DRESSING_ROOMS = 18;
	private final static int PRINT_OFFICE_SECTOR = 19;
	private final static int EXIT = 20;
	private static Scanner sc = new Scanner(System.in);
	private Club club;
	public Menu(){
		this.club = readInitialData();
	}
	/**
	* Read the initial data of the futbol club
	* <b> pre: </b> <br>
	* <b> post: </b>
	* @return club Return the information entered by the user
	*/
	public Club readInitialData(){
		System.out.println("Ingrese el nombre del Club:");
		String name = sc.nextLine();
		System.out.println("Ingrese el nit del Club:");
		String nit = sc.nextLine();
		System.out.println("Ingrese la fecha de fundación del Club:");
		String fundationDate = sc.nextLine();
		club = new Club(nit, name, fundationDate);
		return club;
	}
	/**
	* Show the menu options
	* <b> pre: </b> <br>
	* <b> post: </b>
	*/
	public void showMenu(){
		System.out.println("\n***********************MENU***********************");
		System.out.println("(1) Contratar un empleado");
		System.out.println("(2) Despedir un empleado");
		System.out.println("(3) Asignar entrenador principal a un equipo");
		System.out.println("(4) Agregar asistente tecnico a un equipo");
		System.out.println("(5) Agregar un jugador a un equipo");
		System.out.println("(6) Eliminar el entrenador principal de un equipo)");
		System.out.println("(7) Eliminar un asistente tecnico de un equipo");
		System.out.println("(8) Eliminar un jugador de un equipo");
		System.out.println("(9) Asignar un camerino a un equipo");
		System.out.println("(10) Agregar una alineacion a un equipo");
		System.out.println("(11) Listar la informacion de un equipo");
		System.out.println("(12) Imprimir las alineaciones de un equipo");
		System.out.println("(13) Listar Empleados");
		System.out.println("(14) Listar Jugadores");
		System.out.println("(15) Listar Entrenadores Principales");
		System.out.println("(16) Listar Asistentes Tecnicos");
		System.out.println("(17) Imprimir la informacion del club");
		System.out.println("(18) Imprimir los camerinos");
		System.out.println("(19) Imprimir el sector de oficinas");
		System.out.println("(20) Salir");
		System.out.println("***********************MENU***********************");
	}
	/**
	* Gets the choice of the menu options
	* <b> pre: </b> <br>
	* <b> post: </b>
	* @return choice user's choice
	*/
	public int readOption(){
		System.out.print("Opcion: ");
		int choice = sc.nextInt();
		sc.nextLine();
		System.out.println();
		return choice;
	}
	/**
	* Read the initial information to contract an employee
	* <b> pre: </b> <br>
	* <b> post: </b>
	*			1. The employee's name must be unique <br>
	*			2. The employee's identifier must be unique <br>
	*			3. The employee's state can only be "activo" or "inactivo" <br>
	*			4. The choice can only be between 1 and 4
	*/
	public void readEmployee(){
		System.out.println("Ingrese el nombre del empleado:");
		String name = sc.nextLine();
		System.out.println("Ingrese el identificador del empleado:");
		int identifier = sc.nextInt();
		System.out.println("Ingrese el salario del empleado:");
		int salary = sc.nextInt();
		sc.nextLine();
		System.out.println("Ingrese el estado del empleado (activo o inactivo):");
		String stateStr = sc.nextLine();
		boolean state = false;
		if(stateStr.equalsIgnoreCase("Activo")){
			state = true;
		}else state = false;
		showContractMenu();
		int choice = readOption();
		doOperationContract(choice, name, identifier, salary, state);
	}
	/**
	* Show the contract menu options
	* <b> pre: </b> <br>
	* <b> post: </b>
	*/
	public void showContractMenu(){
		System.out.println("******************TIPO DE EMPLEADO*****************");
		System.out.println("(1) Contratar un jugador");
		System.out.println("(2) Contratar un entrenador principal");
		System.out.println("(3) Contratar un asistente tecnico");
	}
	/**
	* Read the information of a player
	* <b> pre: </b> <br>
	* <b> post: </b>
	* @param name Employee's name
	* @param identifier Employee's identifier
	* @param salary Employee's salary
	* @param state Employee's state
	* @return String 
	*/
	public String readPlayer(String name, int identifier, int salary, boolean state){
		System.out.println("Ingrese el numero de su camiseta de juego:");
		int tShirtNumber = sc.nextInt();
		System.out.println("Ingrese la cantidad de goles del jugador en el club:");
		int goals = sc.nextInt();
		System.out.println("Ingrese la calificacion promedio del jugador:");
		double avarageQualification = sc.nextDouble();
		System.out.println("Ingrese la posicion del jugador:");
		System.out.println("(1) Portero\n(2) Defensor\n(3) Volante\n(4) Delantero");
		System.out.print("Opcion: ");
		int position = sc.nextInt();
		sc.nextLine();
		boolean added = club.addEmployee(name, identifier, salary, state, tShirtNumber, goals, avarageQualification, position);
		if(added){
			return "Se agrego correctamente el empleado";
		}else return "No se pudo agregar el empleado";
	}
	/**
	* Read the information of a head coach
	* <b> pre: </b> <br>
	* <b> post: </b>
	* @param name Employee's name
	* @param identifier Employee's identifier
	* @param salary Employee's salary
	* @param state Employee's state
	* @return String
	*/
	public String readHeadCoach(String name, int identifier, int salary, boolean state){
		System.out.println("Ingrese los años de experiencia que tiene:");
		int yearsExperience = sc.nextInt();
		System.out.println("Ingrese cantidad de equipos que ha manejado en su carrera:");
		int teamsInRace = sc.nextInt();
		System.out.println("Ingrese la cantidad de campeonatos ganados:");
		int championshipsAchieved = sc.nextInt();
		boolean added = club.addEmployee(name, identifier, salary, state, yearsExperience, teamsInRace, championshipsAchieved);
		if(added){
			return "Se agrego correctamente el empleado";
		}else return "No se pudo agregar el empleado";
	}
	/**
	* Read the information of a technical assistant
	* <b> pre: </b> The assistant's expertises can be a maximum of 4<br>
	* <b> post: </b>
	* @param name Employee's name
	* @param identifier Employee's identifier
	* @param salary Employee's salary
	* @param state Employee's state
	* @return String
	*/
	public String readTechnicalAssistant(String name, int identifier, int salary, boolean state){
		System.out.println("Ingrese los años de experiencia que tiene:");
		int yearsExperience = sc.nextInt();
		System.out.println("El empleado fue un jugador de futbol:");
		System.out.println("(1) Si\n(2) No");
		System.out.print("Opcion: ");
		int optionPlayer = sc.nextInt();
		boolean wasPlayer = false;
		if(optionPlayer == 1){
			wasPlayer = true;
		}else wasPlayer = false;
		System.out.println("Ingrese las expertisias del tecnico:");
		int subChoice = 0;
		int[] numExpertises = new int[4];
		for(int i = 0; i<4 && subChoice!=5; i++){
			System.out.println("(1) Ofensivo\n(2) Defensivo\n(3) Posesion\n(4) Jugadas de laboratorio\n(5) Terminar");
			System.out.print("Opcion: ");
			subChoice = sc.nextInt();
			sc.nextLine();
			if(subChoice<5){
				numExpertises[i] = subChoice;
			}
		}
		boolean added = club.addEmployee(name, identifier, salary, state, yearsExperience, wasPlayer, numExpertises);
		if(added){
			return "Se agrego correctamente el empleado";
		}else return "No se pudo agregar el empleado";
	}
	/**
	* Do an action depending on the choice
	* <b> pre: </b> <br>
	* <b> post: </b> 
	* @param choice User choice
	* @param name Employee's name
	* @param identifier Employee's identifier
	* @param salary Employee's salary
	* @param state Employee's state
	*/
	public void doOperationContract(int choice, String name, int identifier, int salary, boolean state){
		switch(choice){
			case CONTRACT_PLAYER:
				System.out.println(readPlayer(name, identifier, salary, state));
				break;
			case CONTRACT_HEAD_COACH:
				System.out.println(readHeadCoach(name, identifier, salary, state));
				break;
			case CONTRACT_TECHNICAL_ASSISTANT:
				System.out.println(readTechnicalAssistant(name, identifier, salary, state));
				break;
			default:
				System.out.println("Tipo de empleado inexistente.");
		}
	}
	/**
	* Throw an employee
	* <b> pre: </b> The employee's name and identifier must match <br>
	* <b> post: </b>
	* @return String
	*/
	public String throwEmployee(){
		System.out.println("Ingrese el nombre del empleado que va a despedir:");
		String name = sc.nextLine();
		System.out.println("Ingrese el identificador del empleado:");
		int identifier = sc.nextInt();
		sc.nextLine();
		boolean delated = club.delateEmployee(name, identifier);
		if(delated){
			return "Se despidio al empleado";
		}else return "No se pudo despedir al empleado";
	}
	/**
	* Add the head coach to a team
	* <b> pre: </b>
	*			1. The team must exist<br>
	*			2. The coach's name and identifier must match
	* <b> post: </b>
	* @return String
	*/
	public String teamAddHeadCoach(){
		System.out.println("Ingrese el nombre del equipo:");
		String name = sc.nextLine();
		System.out.println("Ingrese el nombre del entrenador principal:");
		String coachName = sc.nextLine();
		System.out.println("Ingrese el identificador del entrenador:");
		int identifier = sc.nextInt();
		sc.nextLine();
		boolean added = club.addTeamHeadCoach(name, coachName, identifier);
		if(added){
			return "Se agrego correctamente el entrenador al equipo";
		}else return "No se pudo agregar el entrenador al equipo";
	}
	/**
	* Add a technical assistant to a team
	* <b> pre: </b>
	*			1. The team must exist<br>
	*			2. The technical's name and identifier must match
	* <b> post: </b>
	* @return String
	*/
	public String teamAddTechnicalAssistant(){
		System.out.println("Ingrese el nombre del equipo:");
		String name = sc.nextLine();
		System.out.println("Ingrese el nombre del asistente tecnico:");
		String technicalName = sc.nextLine();
		System.out.println("Ingrese el identificador del asistente tecnico:");
		int identifier = sc.nextInt();
		sc.nextLine();
		boolean added = club.addTeamTechnicalAssistant(name, technicalName, identifier);
		if(added){
			return "Se agrego correctamente el asistente tecnico al equipo";
		}else return "No se pudo agregar el asistente tecnico al equipo";
	}
	/**
	* Add a player to a team
	* <b> pre: </b>
	*			1. The team must exist<br>
	*			2. The player's name and identifier must match
	* <b> post: </b>
	* @return String
	*/
	public String teamAddPlayer(){
		System.out.println("Ingrese el nombre del equipo:");
		String name = sc.nextLine();
		System.out.println("Ingrese el nombre del jugador:");
		String playerName = sc.nextLine();
		System.out.println("Ingrese el identificador del jugador:");
		int identifier = sc.nextInt();
		sc.nextLine();
		boolean added = club.addTeamPlayer(name, playerName, identifier);
		if(added){
			return "Se agrego correctamente el jugador al equipo";
		}else return "No se pudo agregar el jugador al equipo";
	}
	/**
	* Remove a head coach from a team
	* <b> pre: </b> <br>
	* <b> post: </b>
	* @return String
	*/
	public String teamRemoveHeadCoach(){
		System.out.println("Ingrese el nombre del equipo:");
		String name = sc.nextLine();
		System.out.println("Ingrse el nombre del entrenador principal:");
		String coachName = sc.nextLine();
		System.out.println("Ingrese el identificador del entrenador principal:");
		int identifier = sc.nextInt();
		sc.nextLine();
		boolean removed = club.removeTeamHeadCoach(name, coachName, identifier);
		if(removed){
			return "Se elimino el entrenador principal del equipo";
		}else return "No se pudo eliminar el entrenador principal del equipo";
	}
	/**
	* Remove a technical assistant from a team
	* <b> pre: </b>
	*			1. The team must exist<br>
	*			2. The technical's name and identifier must match
	* <b> post: </b>
	* @return String
	*/
	public String teamRemoveTechnicalAssistant(){
		System.out.println("Ingrese el nombre del equipo:");
		String name = sc.nextLine();
		System.out.println("Ingrese el nombre del asistente tecnico:");
		String technicalName = sc.nextLine();
		System.out.println("Ingrese el identificador del asistente tecnico:");
		int identifier = sc.nextInt();
		sc.nextLine();
		boolean removed = club.removeTeamTechnicalAssistant(name, technicalName, identifier);
		if(removed){
			return "Se elimino el asistente tecnico del equipo";
		}else return "No se pudo eliminar el asistente tenico del equipo";
	}
	/**
	* Remove a player from a team
	* <b> pre: </b>
	*			1. The team must exist<br>
	*			2. The player's name and identifier must match
	* <b> post: </b>
	* @return String
	*/
	public String teamRemovePlayer(){
		System.out.println("Ingrese el nombre del equipo:");
		String name = sc.nextLine();
		System.out.println("Ingrese el nombre del jugador:");
		String playerName = sc.nextLine();
		System.out.println("Ingrese el identificador del jugador:");
		int identifier = sc.nextInt();
		sc.nextLine();
		boolean removed = club.removeTeamPlayer(name, playerName, identifier);
		if(removed){
			return "Se elimino el jugador del equipo";
		}else return "No se pudo eliminar el jugador del equipo";
	}
	/**
	* Assign a dressing room to a team
	* <b> pre: </b> <br>
	* <b> post: </b>
	* @return String
	*/
	public String assignDressingRoomToTeam(){
		System.out.println("Ingrese el numero de camerino al que asignara un equipo:");
		System.out.println("(1) Camerino 1(7x6)\n(2) Camerino 2(7x7)");
		System.out.print("Opcion: ");
		int dressingRoom = sc.nextInt();
		sc.nextLine();
		System.out.println("Ingrese el nombre del equipo:");
		String name = sc.nextLine();
		boolean assigned = club.assignDressingRoom(name, dressingRoom);
		if(assigned){
			return "Se asigno correctamente el camerino";
		}else return "No se pudo asignar el camerino";
	}
	/**
	* Add a line-up to a team
	* <b> pre: </b> <br>
	* <b> post: </b>
	* @return String
	*/
	public String addLineUpToTeam(){
		System.out.println("Ingrese el nombre del equipo:");
		String name = sc.nextLine();
		System.out.println("Ingrese la fecha de la alineacion:");
		String date = sc.nextLine();
		System.out.println("Ingrese el tipo de tactica de la alineacion:");
		System.out.println("(1) Posesion\n(2) Contraataque\n(3) Presion alte\n(4) Por defecto");
		System.out.print("Opcion: ");
		int tacticNum = sc.nextInt();
		sc.nextLine();
		System.out.println("Ingrese la formacion de la alineacion (x-y-z):");
		String formation = sc.nextLine();
		boolean added = club.addLineUpToTeam(name, date, tacticNum, formation);
		if(added){
			return "Se agrego correctamente la alineacion";
		}else return "No se pudo agregar la alineacion";
	}
	/**
	* Gets the team's information
	* <b> pre: </b> The team must exist <br>
	* <b> post: </b>
	* @return content the information of the team
	*/
	public String getTeamInfo(){
		System.out.println("Ingrese el nombre del equipo:");
		String name = sc.nextLine();
		String content = club.getTeamInfo(name);
		return content;
	}
	/**
	* Get the line-ups of a team
	* <b> pre: </b> <br>
	* <b> post: </b>
	* @return content
	*/
	public String getTeamLineUps(){
		System.out.println("Ingrese el nombre del equipo:");
		String name = sc.nextLine();
		String content = club.getTeamLineUp(name);
		return content;
	}
	/**
	* Do an action depending on the choice
	* <b> pre: </b> <br>
	* <b> post: </b> 
	* @param choice User choice
	*/
	public void doOperation(int choice){
		switch(choice){
			case CONTRACT_EMPLOYEE:
				readEmployee();
				break;
			case THROW_EMPLOYEE:
				System.out.println(throwEmployee());
				break;
			case TEAM_ADD_HEAD_COACH:
				System.out.println(teamAddHeadCoach());
				break;
			case TEAM_ADD_TECHNICAL_ASSISTANT:
				System.out.println(teamAddTechnicalAssistant());
				break;
			case TEAM_ADD_PLAYER:
				System.out.println(teamAddPlayer());
				break;
			case TEAM_REMOVE_HEAD_COACH:
				System.out.println(teamRemoveHeadCoach());
				break;
			case TEAM_REMOVE_TECHNICAL_ASSISTANT:
				System.out.println(teamRemoveTechnicalAssistant());
				break;
			case TEAM_REMOVE_PLAYER:
				System.out.println(teamRemovePlayer());
				break;
			case ASSIGN_TEAM_DRESSING_ROOM:
				System.out.println(assignDressingRoomToTeam());
				break;
			case TEAM_ADD_LINE_UP:
				System.out.println(addLineUpToTeam());
				break;
			case PRINT_TEAM_INFO:
				System.out.println(getTeamInfo());
				break;
			case PRINT_TEAM_LINE_UPS:
				System.out.println(getTeamLineUps());
				break;
			case PRINT_EMPLOYEES:
				System.out.println(club.getEmployeesInfo());
				break;
			case PRINT_PLAYERS:
				System.out.println(club.getPlayersInfo());
				break;
			case PRINT_HEAD_COACHS:
				System.out.println(club.getHeadCoachsInfo());
				break;
			case PRINT_TECHNICAL_ASSISTANTS:
				System.out.println(club.getTechnicalAssistantsInfo());
				break;
			case PRINT_CLUB_INFO:
				System.out.println(club.getInfo());
				break;
			case PRINT_DRESSING_ROOMS:
				System.out.println(club.getDressingsRooms());
				break;
			case PRINT_OFFICE_SECTOR:
				System.out.println(club.getOfficeSector());
				break;
			case EXIT:
				System.out.println("Saliendo");
				break;
			default:
				System.out.println("Opcion invalida, ingrese otra opcion.");
		}
	}
	/**
	* Method to start and end the aplication depending the users choice
	* <b> pre: </b>
	* <b> post: </b>
	*/
	public void startProgram(){
		int choice;
		do{
			showMenu();
			choice = readOption();
			doOperation(choice);
		}while(choice!=EXIT);
	}
}