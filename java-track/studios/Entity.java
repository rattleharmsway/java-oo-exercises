
public abstract class Entity {
	private final int uid;
	private static int counter =0;
	
	public Entity(){
		
		counter+=1;
		System.out.println(counter);
		this.uid = counter;
	}
	
	public int getUid(){
		return this.uid;
	}

}
