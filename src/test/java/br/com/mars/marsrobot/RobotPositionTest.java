package br.com.mars.marsrobot;

import org.junit.Test;

public class RobotPositionTest {
	
	@Test
	public void testMove() {
		new RobotPosition().move("MML");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testMove_withIllegalArguments() {
		new RobotPosition().move("MMX");
	}


}
