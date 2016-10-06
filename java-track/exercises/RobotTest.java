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
	public void testAttackRobotInit() {
		AttackRobot r = new AttackRobot("WALLEE", 3, 270, 2, 2, 10 );
		assertEquals("WALLEE", r.getName());
		assertEquals(3, r.getSpeed());
		assertEquals(270, r.getOrientation());
		assertEquals(2, r.getX());
		assertEquals(2, r.getY());
		assertEquals(10, r.getStrength());
		assertEquals("YOU'VE BEEN ATTACKED BY: WALLEE", r.getAttackMessage());
		for (int i = 0; i < 20; ++i) {
			int a =  (int)(Math.random() * 5000);
			int b =  (int)(Math.random() * 5000);
			int c = (int)(Math.random() * 4);
			AttackRobot r3 = new AttackRobot((String)(a + " "), b, degrees[c], a,a, a);
			assertEquals(s1, (String)(a + " "), r3.getName());
			assertEquals(s2, b, r3.getSpeed());
			assertEquals(s4, degrees[c], r3.getOrientation());
			assertEquals(s5, a, r3.getX());
			assertEquals(s5, a, r3.getY());
			assertEquals("Strength is not defined",a, r3.getStrength());
			assertEquals("Attack message is not defined", "YOU'VE BEEN ATTACKED BY: " + (String)(a + " "), r3.getAttackMessage());
		}
	}
	
	@Test
	public void testPushBotInit() {
		PushBot r = new PushBot("WALLEE", 3, 270, 2, 2, 10 );
		assertEquals("WALLEE", r.getName());
		assertEquals(3, r.getSpeed());
		assertEquals(270, r.getOrientation());
		assertEquals(2, r.getX());
		assertEquals(2, r.getY());
		assertEquals(10, r.getStrength());
		assertEquals("YOU'VE BEEN PUSHED BY WALLEE 10 PACES", r.getPushMessage());
		for (int i = 0; i < 20; ++i) {
			int a =  (int)(Math.random() * 5000);
			int b =  (int)(Math.random() * 5000);
			int c = (int)(Math.random() * 4);
			PushBot r3 = new PushBot((String)(a + " "), b, degrees[c], a,a, a);
			assertEquals(s1, (String)(a + " "), r3.getName());
			assertEquals(s2, b, r3.getSpeed());
			assertEquals(s4, degrees[c], r3.getOrientation());
			assertEquals(s5, a, r3.getX());
			assertEquals(s5, a, r3.getY());
			assertEquals("Strength is not defined",a, r3.getStrength());
			assertEquals("Attack message is not defined", "YOU'VE BEEN PUSHED BY "+ (String)(a + " ")+" " + a + " PACES" , r3.getPushMessage());
		}
	}

	@Test
	public void testMove() {
		Robot r = new Robot("WALLEE", 3, 360, 2, 2 );
		r.move(1);
		assertEquals(5, r.getY());
	}

	@Test
	public void testRotate() {
		Robot r = new Robot("WALLEE", 3, 360, 2, 2 );
		r.rotate("l");
		assertEquals(450, r.getOrientation());
	}

	@Test
	public void testDistance() {
		Robot r = new Robot("WALLEE", 3, 360, 2, 2 );
		Robot l = new Robot("WALLEE", 3, 360, 100, -2 );
		//System.out.println(r.Distance(l));
		assertEquals(98.08159868191383, r.Distance(l));
	}

	@Test
	public void testToString() {
		Robot r = new Robot("WALLEE", 3, 360, 2, 2 );
		assertEquals("Name: WALLEE Orientation: 360 Speed: 3 Cords X: 2 Cords Y: 2", r.ToString());
	}
	
	@Test
	public void testAttack(){
		Robot r = new Robot("WALLEE", 3, 360, 2, 2 );
		AttackRobot a = new AttackRobot("FIRE", 3, 360, 2, 2, 10);
		assertEquals("YOU'VE BEEN ATTACKED BY: FIRE", a.Attack(r));
		assertEquals("BYE BYE", r.getName());
		assertEquals(0, r.getSpeed());
		assertEquals(0, r.getOrientation());
		assertEquals(0, r.getX());
		assertEquals(0, r.getY());	
	}
	
	@Test
	public void testPush(){
		Robot r = new Robot("WALLEE", 3, 360, 2, 2 );
		PushBot a = new PushBot("FIRE", 3, 360, 2, 2, 10);
		assertEquals("YOU'VE BEEN PUSHED BY FIRE 10 PACES", a.push(r));
		assertEquals("WALLEE", r.getName());
		assertEquals(3, r.getSpeed());
		assertEquals(360, r.getOrientation());
		assertEquals(2, r.getX());
		assertEquals(-88, r.getY());	
	}


}
