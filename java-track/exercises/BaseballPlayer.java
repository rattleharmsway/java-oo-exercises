
public class BaseballPlayer {
	
	private int jerseyNumber, runs, rbis, games, hits;
	private String name,hand;

	public BaseballPlayer(String name, String hand, int jerseyNumber){
		this.runs = 0;
		this.rbis = 0;
		this.games = 0;
		this.hits = 0;
		this.name = name;
		this.jerseyNumber = jerseyNumber;
		this.hand = hand;
		
	}
	
	public void game(int runs, int rbis, int hits){
		this.runs += runs;
		this.rbis += rbis;
		this.games++;
		this.hits += hits;
	}
	
	public String getHand(){
		if (this.hand == "l"){
			return this.name + " Plays with their " + this.hand + " and bats left handed";
		}
		else if (this.hand == "r"){
			return this.name + " Plays with their " + this.hand + " and bats right handed";
		}
		else if (this.hand == "b"){
			return this.name + " Plays with their " + this.hand + " and bats ambidextrously";
		}
		else{
			return "There is incomplete data for " + this.name;
		}
	}
	
	public String getRuns(){
		return this.runs + " RUNS scored by " + this.name + " in " + this.games + " games.";
	}
	
	public String getRBIS(){
		return this.rbis + " RBIS made by " + this.name + " in " + this.games + " games.";
	}
	
	public String getHits(){
		return this.hits + " HITS achieved by " + this.name + " in " + this.games + " games.";
	}
	
	
	public static void main(String[] args) {
		BaseballPlayer Jeff = new BaseballPlayer("Jeffrey Harms", "l", 27);
		for (int i = 0; i < 100; i++){
			Jeff.game((int)(Math.random()*3), (int)(Math.random() * 4), (int)(Math.random() * 4) );
		}
		System.out.println(Jeff.getHand());
		System.out.println(Jeff.getRuns());
		System.out.println(Jeff.getRBIS());
		System.out.println(Jeff.getHits());
		
	}
	
	

}

