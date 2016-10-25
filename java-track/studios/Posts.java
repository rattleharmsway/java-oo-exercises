import java.util.Date;

public class Posts extends Entity{
	private String body;
	private String title;
	private String author;
	private final Date created;
	private Date modified;
	
	public Posts(String body, String title, String author){
		super();
		this.body = body;
		this.title = title;
		this.author = author;
		this.created = new Date();
		this.modified = new Date();
		//counter++;
		
	}
	
	public String getBody(){
		return this.body;
	}
	
	public String getTitle(){
		return this.title;
	}
	
	public String getAuthor(){
		return this.author;
	}
	
	public Date getCreated(){
		return this.created;
	}
	
	public Date getModified(){
		return this.modified;
	}
	
	public void updateBody(String s){
		this.body = s;
		this.modified = new Date();
	}
	
	public void updateTitle(String s){
		this.title = s;
		this.modified = new Date();
	}
	
	public void updateAuthor(String s){
		this.author = s;
		this.modified = new Date();
	}

}
