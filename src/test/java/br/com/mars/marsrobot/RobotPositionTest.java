package br.com.mars.marsrobot;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RobotPositionTest {
	
	RobotPosition position;
	
	@Before
	public void setUp() {
		position = new RobotPosition();
	}
	
	@Test
	public void testInitialPosition() {
		Assert.assertEquals("(0, 0, N)", position.toString());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testMove_withIllegalArguments() {
		position.move("X");
	}
	
	@Test
	public void testMoveLeft() {
		testMovement("(0, 0, W)", "L");
	}

	@Test
	public void testMoveRight() {
		testMovement("(0, 0, E)", "R");
	}
	
	@Test
	public void testMoveOnePosition() {
		testMovement("(0, 1, N)", "M");
	}
	
	@Test
	public void testMoveTwoPositionsRight() {
		testMovement("(2, 0, E)", "RMM");
	}
	
	@Test
	public void testMoveTwoPositionsUp() {
		testMovement("(0, 2, N)", "MM");
	}
	
	@Test(expected=IllegalStateException.class)
	public void testMoveOnePositionDown() {
		position.move("LLM");
	}
	
	@Test(expected=IllegalStateException.class)
	public void testMoveOnePositionLeft() {
		position.move("LM");
	}

	@Test(expected=IllegalStateException.class)
	public void testMoveFivePositionsUp() {
		position.move("MMMMM");
	}

	@Test(expected=IllegalStateException.class)
	public void testMoveFivePositionsRight() {
		position.move("RMMMMM");
	}

	private void testMovement(String expectedPosition, String movements) {
		position.move(movements);
		Assert.assertEquals(expectedPosition, position.toString());
	}
	
}
