
public class Fraction {
	private int numer;
	private int denom;
	
	public Fraction(int num, int den){
		this.numer = num;
		this.denom = den;
	}
	
	public String addFrac(Fraction a){
		return ((this.numer * a.denom) + (a.numer * this.denom)) + " / " + ((this.denom * a.denom) + (a.denom * this.denom));
	}
	
	public String multFrac(Fraction a){
		return (this.numer * a.numer) + " / " + (this.denom * a.denom);
	}
	
	public String recipFrac(){
		return this.denom + " / " + this.numer;
	}
	
	public String simpFrac(){
		if (this.numer % 2 == 0 && this.denom % 2 ==0){
			return this.numer / 2 + " / " + this.denom / 2;
		}
		else{
			return "This Fraction cannot be simplified by 2";
		}
	}
	
	public static void main(String[] args) {
		Fraction a = new Fraction(2,4);
		Fraction b = new Fraction(2,4);
		System.out.println(a.recipFrac());
		System.out.println(a.simpFrac());
		System.out.println(a.addFrac(b));
		System.out.println(a.multFrac(b));
	}

}
