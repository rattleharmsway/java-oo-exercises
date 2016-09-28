
public class Robot {
	private String name;
	public int speed;
	private int orientation;
	private int x;
	private int y;
	
	public Robot(String name, int speed, int orientation, int x, int y){
		this.name = name;
		this.speed = speed;
		if (orientation == 360 || orientation == 270 || orientation == 180 || orientation == 90){
			this.orientation = orientation;	
		}
		else{
			this.orientation = 360;
		}
		this.x = x;
		this.y = y;
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getSpeed(){
		return this.speed;
	}
	
	public int getOrientation(){
		return this.orientation;
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
	public void move(int move){
		if (this.orientation%360 == 0){
			this.y = this.y + (move * this.speed);			
		}
		else if (this.orientation%270 == 0){
			this.x = this.x + (move * this.speed);
		}
		else if (this.orientation%180 == 0){
			this.y = this.y - (move * this.speed);
		}
		else{
			this.x = this.x - (move * this.speed);  //this.speed
		}
	}
	
	public void rotate(String direction){
		if (direction.contains("r")){
			this.orientation -= 90;
		}
		else{
			this.orientation += 90;
		}	
	}
	
	public double Distance(Robot a){
		return Math.sqrt(Math.pow((this.x - a.x), 2) + Math.pow((this.y - a.y), 2));
	}
	
	public String ToString(){
		return "Orientation: " + this.orientation + " Speed: " + this.speed + " Name: " + this.name + " Cords X: " + this.x + " Cords Y: " + this.y;
	}
	
	
	public static void main(String[] args) {
		Robot rob1 = new Robot("ROB1", 1, 360, 1, 1);
		Robot rob2 = new Robot("ROB2", 1, 270, 2,2);
		System.out.println(rob1.ToString());
		System.out.println(rob2.ToString());
		System.out.println(rob1.Distance(rob2));
		rob1.rotate("r");
		rob1.move();
		rob1.rotate("l");
		rob1.move();
		System.out.println(rob1.ToString());
		System.out.println(rob1.Distance(rob2));
	}	
}
