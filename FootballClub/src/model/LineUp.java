package model;
import java.util.Vector;
public class LineUp{
	private final static int LINE_UP_SIZE_1 = 10;
	private final static int LINE_UP_SIZE_2 = 7;
	
	private String date;
	private Tactic tactic;
	private String formation;
	
	private int[][] lineUp;
	
	public LineUp(String date, int numTactic, String formation){
		this.date = date;
		enumTactic(numTactic);
		this.formation = formation;
		this.lineUp = new int[LINE_UP_SIZE_1][LINE_UP_SIZE_2];
		assignMatriz(formation);
	}
	
	public String getDate(){
		return date;
	}
	public Tactic getTactic(){
		return tactic;
	}
	public String getFormation(){
		return formation;
	}
	
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
	public void assignMatriz(String formation){
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