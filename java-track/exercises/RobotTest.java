import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

import junit.framework.TestCase;

public class RobotTest extends TestCase {

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
	int[] degrees = {90,180,270,360};
	@Test
	public void testRobotInit() {
		Robot r = new Robot("WALLEE", 3, 270, 2, 2 );
		assertEquals("WALLEE", r.getName());
		assertEquals(3, r.getSpeed());
		assertEquals(270, r.getOrientation());
		assertEquals(2, r.getX());
		assertEquals(2, r.getY());
		for (int i = 0; i < 20; ++i) {
			int a =  (int)(Math.random() * 5000);
			int b =  (int)(Math.random() * 5000);
			int c = (int)(Math.random() * 4);
			Robot r3 = new Robot((String)(a + " "), b, degrees[c], a,a);
			assertEquals(s1, (String)(a + " "), r3.getName());
			assertEquals(s2, b, r3.getSpeed());
			assertEquals(s4, degrees[c], r3.getOrientation());
			assertEquals(s5, a, r3.getX());
			assertEquals(s5, a, r3.getY());
		}
	}	

	@Test
	public void testMove() {
		fail("Not yet implemented");
	}

	@Test
	public void testRotate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDistance() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}


}
