
public class Robot {
	private String name;
	public int speed;
	private int orientation;
	private int x;
	private int y;
	
	public Robot(String name, int speed, int orientation, int x, int y){
		this.name = name;
		this.speed = speed;
		this.orientation = orientation;
		this.x = x;
		this.y = y;
	}
	
	public void move(){
		if (this.orientation%360 == 0){
			this.y = this.y + this.speed;			
		}
		else if (this.orientation%270 == 0){
			this.x = this.x + this.speed;
		}
		else if (this.orientation%180 == 0){
			this.y = this.y - this.speed;
		}
		else{
			this.x = this.x - this.speed;  //this.speed
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
