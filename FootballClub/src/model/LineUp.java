package model;
import java.util.Vector;
public class LineUp{
	private final static int LINE_UP_SIZE_1 = 10;
	private final static int LINE_UP_SIZE_2 = 7;
	private String date;
	private Tactic tactic;
	private String formation;
	private int[][] lineUp;
	/**
	* Constructor method for the lineUps
	* <b> pre: </b> 
	*			1. Date must be a valid date <br>
	*			2. The number of the tactic can only be between 1 and 4 <br>
	*			3. The formation can obly be confermed between 3 and 5 numbers that sume 10
	* <b> post: </b>
	* @param date line-up date to be used
	* @param numTactic Option of the tactic that have the line-up
	* @param formation Formation in the court
	*/
	public LineUp(String date, int numTactic, String formation){
		this.date = date;
		enumTactic(numTactic);
		this.formation = formation;
		this.lineUp = new int[LINE_UP_SIZE_1][LINE_UP_SIZE_2];
		assignMatriz(formation);
	}
	/**
	* Get the date to be used the line-up
	* <b> pre: </b> <br>
	* <b> post: </b>
	* @return date
	*/
	public String getDate(){
		return date;
	}
	/**
	* Get the tactic type of the line-up
	* <b> pre: </b> <br>
	* <b> post: </b>
	* @return tactic
	*/
	public Tactic getTactic(){
		return tactic;
	}
	/**
	* Get the formation String
	* <b> pre: </b> <br>
	* <b> post: </b>
	* @return formation
	*/
	public String getFormation(){
		return formation;
	}
	/**
	* Calculate the tactic depending of the option from the menu (numTactic)
	* <b> pre: </b> Number of tactic can obly be between 1 and 4 <br>
	* <b> post: </b>
	* @param numTactic
	*/
	private void enumTactic(int numTactic){
		switch(numTactic){
			case 1:
				this.tactic = Tactic.Possesion;
				break;
			case 2:
				this.tactic = Tactic.Counter_attack;
				break;
			case 3:
				this.tactic = Tactic.High_pressure;
				break;
			case 4:
				this.tactic = Tactic.Default;
			break;
		}
	}
	/**
	* Organize a matriz depending the formation to be played in the court
	* <b> pre: </b> <br>
	* <b> post: </b>
	* @param formation
	*/
	private void assignMatriz(String formation){
		String[] formationString = formation.split("-");
		int[] formationInt = new int[formationString.length];
		boolean[] formationBoolean = new boolean[formationString.length];
		for(int i = 0; i<formationString.length; i++){
			formationInt[i] = Integer.parseInt(formationString[i]);
			formationBoolean[i] = false;
		}
		int line = 1;
		for(int i = formationInt.length-1; i>=0; i--){
			for(int j = line; j<LINE_UP_SIZE_1 && !formationBoolean[i]; j++){
				for(int k = 0; k<formationInt[i] && !formationBoolean[i]; k++){
					if(formationInt[i]%2 != 0){
						lineUp[j][3] = 1;
					}
					int formationIndex = formationInt[i]/2;
					for(int l = 0; l<formationIndex && !formationBoolean[i]; l++){
						lineUp[j][3+(l+1)] = 1;
						lineUp[j][3-(l+1)] = 1;
					}
				}
				if(formationInt.length == 3){
					line += 3;
				}else line += 2;
				formationBoolean[i] = true;
			}
		}
	}
	/**
	* Get the information of the line-up
	* <b> pre: </b> <br>
	* <b> post: </b>
	* @return content
	*/
	public String getInfo(){
		String content = "************LINE UP************\n";
		content += "** Date: "+getDate()+"\n";
		content += "** Tactic: "+getTactic()+"";;
		content += "** Formation: "+getFormation()+"\n";
		for(int i = 0; i<LINE_UP_SIZE_1; i++){
			for(int j = 0; j<LINE_UP_SIZE_2; j++){
				content += lineUp[i][j]+" ";
			}
			content += "\n";
		}
		return content;
	}
}