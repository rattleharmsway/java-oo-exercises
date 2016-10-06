
public class AttackRobot extends Robot {
	public int strength;
	public String attackMessage;

	public AttackRobot(String name, int speed, int orientation, int x, int y, int strength) {
		super(name, speed, orientation, x, y);
		this.strength = strength;
		this.attackMessage = "YOU'VE BEEN ATTACKED BY: " + name;
		// TODO Auto-generated constructor stub
	}
	
	public int getStrength(){
		return this.strength;
	}
	
	public String getAttackMessage(){
		return this.attackMessage;
	}
	
	public String Attack(Robot a){
		a.attack("BYE BYE");
		return this.attackMessage;	
	}

}
