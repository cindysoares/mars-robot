package br.com.mars.marsrobot;

import java.util.function.Consumer;

public enum Orientation {
	
	N("W", "E", (RobotPosition position) -> position.y++),
	S("E", "W", (RobotPosition position) -> position.y--),
	E("N", "S", (RobotPosition position) -> position.x++),
	W("S", "N", (RobotPosition position) -> position.x--);

	private String leftOrientation;
	private String rightOrientation;
	
	private Consumer<RobotPosition> move;	
	
	private Orientation(String left, String right, Consumer<RobotPosition> consumer) {
		leftOrientation = left;
		rightOrientation = right;
		move = consumer;
	}

	public void move(RobotPosition position) {
		move.accept(position);
	}

	public Orientation getLeftOrientation() {
		return Orientation.valueOf(leftOrientation);
	}

	public Orientation getRightOrientation() {
		return Orientation.valueOf(rightOrientation);
	}
	
}
