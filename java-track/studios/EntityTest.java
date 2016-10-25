import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * 
 */
import java.util.Date;
/**
 * @author harms_000
 *
 */
public class EntityTest extends TestCase{
	
	String s1 = "either your getName() method isn't   doing its job or you're not " +
			"setting your instance variables properly";
	String s2 = "either your getGPA() method is not doing its job or you're not " +
			"setting your instance variables properly";
	String s4 = "either your getCredits() method is not doing its job or you're not " +
			"setting your instance variables properly";
	String s5 = "either your getClassStanding() method isn't doing its job or you're not " +
			"setting your instance variables properly";
	String s6 = "The plus method shouldn't change the original vector";
	String s8 = "hasHigherAverage() isn't working properly";
	String s9 = "getClassStanding() isn't working properly";
	
	@Test
	public void testPostsInit() {
		Posts s = new Posts("body", "title", "author");
		assertEquals("body", s.getBody());
		assertEquals("title", s.getTitle());
		//No credits, should be a freshman, no GPA
		assertEquals("author", s.getAuthor());
		assertEquals(1, s.getUid());
		assertEquals(new Date(), s.getModified());
		Posts s1 = new Posts("body", "title", "author");
		assertEquals("body", s1.getBody());
		assertEquals("title", s1.getTitle());
		//No credits, should be a freshman, no GPA
		assertEquals("author", s1.getAuthor());
		assertEquals(2, s1.getUid());
		assertEquals(new Date(), s1.getModified());
		for (int i = 2; i < 20; ++i) {
			double a =  (Math.random() * 5000);
			double b =  (Math.random() * 5000);
			double c =  (Math.random() * 5000);
			Posts s3 = new Posts("" + a, "" + b, ""+c);
			assertEquals(s2, a + "" , s3.getBody());
			assertEquals(s2, "" + b, s3.getTitle());
			assertEquals(s4, "" + c, s3.getAuthor());
			assertEquals(i+1, s3.getUid());

		}
	}

}
