
public class PushBot extends Robot{
	
	private int strength;
	private String pushMessage;

	public PushBot(String name, int speed, int orientation, int x, int y, int strength) {
		// TODO Auto-generated constructor stub
		super(name, speed, orientation, x, y);
		this.strength = strength;
		this.pushMessage = "YOU'VE BEEN PUSHED BY " + name + " " + strength + " PACES";
	}
	
	public int getStrength(){
		return this.strength;
	}
	
	public String getPushMessage(){
		return this.pushMessage;
	}

	public String push(Robot a){
		a.move(-(a.speed*this.strength));
		return this.pushMessage;
	}
}
