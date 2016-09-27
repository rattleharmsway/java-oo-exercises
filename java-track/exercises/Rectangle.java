
public class Rectangle {
	private double width;
	private double height;
	
	public Rectangle(double width, double height){
		this.width = width;
		this.height = height;
	}

	public double Area(){
		return this.width * this.height;
	}
	
	public double Perimeter(){
		return this.width*2 + this.height*2;
	}
	
	public boolean IsSquare(){
		if (this.width == this.height){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean IsSmaller(Rectangle a){
		if (this.Area() < a.Area()){
			return true;
		}
		else{
			return false;
		}
	}
	
	public String ToString(){
		return "Width: " + this.width + " Height: " + this.height;
	}
	
	public static void main(String[] args){
		Rectangle rec1 = new Rectangle(20.0, 7.5);
		Rectangle rec2 = new Rectangle(10.00, 10.00);
		System.out.println(rec1.ToString());
		System.out.println(rec2.ToString());
		System.out.println(rec1.Area());
		System.out.println(rec1.Perimeter());
		System.out.println(rec1.IsSquare());
		System.out.println(rec2.IsSquare());	
		System.out.println(rec1.IsSmaller(rec2));
		System.out.println(rec2.IsSmaller(rec1));
		
	}
	
	
}



