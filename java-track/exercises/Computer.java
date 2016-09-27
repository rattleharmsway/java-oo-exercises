//package encapsulation;
public class Computer {
	private int memory;
	private float size;
	private double speed;
	private String brand;
	
	public Computer(int memory, float size, double speed, String brand) {
		this.memory = memory;
		this.size = size;
		this.speed = speed;
		this.brand = brand;
	}
	
	public int getMemory(){
		return this.memory;
	}
	
	public float getSize(){
		return this.size;
	}

	public double getSpeed(){
		return this.speed;
	}

	public String getBrand(){
		return this.brand;
	}
	
	public void addMemory(int newMem){
		if (this.memory + newMem > 8){
			return;
		}
		else{
			this.memory += newMem;
		}
		
	}
	
	public void setProcessor(double newProcessor){
		this.speed = newProcessor;
	}

	public String toString(){
		return "Memory: " + this.memory + " Size: " + this.size + " Speed: " + this.speed + " Brand: " + this.brand;
	}
	
	public static void main(String[] args) {
		Computer myComp = new Computer(7, 17, 2.4, "HP");
		System.out.println(myComp.toString());
		myComp.addMemory(1);
		System.out.println(myComp.toString());
		
	}

}


