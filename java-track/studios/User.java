import java.util.ArrayList;

public class User extends Entity{
	private String username;
	private String hashedpassword;
	private static ArrayList<User> users = new ArrayList<User>();
	
	public User(String user, String unhashedpassword) throws Exception{
		super();
		if(User.isValidUsername(user)){
			this.username = user;
		}
		else{
			throw new Exception("Invalid User name");
		}
		this.hashedpassword = User.hashPassword(unhashedpassword);
		User.users.add(this);
		
	}
	
	public static ArrayList<User> getAllUsers(){
		return User.users;
		
	}
	
	private static String hashPassword(String pass){
		return pass;
	}
	
	public boolean isValidPassword(String pass){
		if (this.hashedpassword == User.hashPassword(pass)){
			return true;
		}
		else{
			return false;
		}
	}
	
	public String getUser(){
		return this.username;
	}
		
	private static boolean isValidUsername(String user){
			return user.matches("[a-zA-Z][a-zA-Z0-9_-]{4,11}");
	}
	
}
