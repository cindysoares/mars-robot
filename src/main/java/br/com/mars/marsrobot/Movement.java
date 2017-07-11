package br.com.mars.marsrobot;

import java.util.function.Consumer;

public enum Movement {
	
	L((RobotPosition position)-> position.moveLeft() ), 
	R((RobotPosition position)-> position.moveRight() ), 
	M((RobotPosition position)-> position.moveOnePosition() );
	
	private Consumer<RobotPosition> consumer;
	
	private Movement(Consumer<RobotPosition> consumer) {
		this.consumer = consumer;
	}

	public void move(RobotPosition robotPosition) {
		consumer.accept(robotPosition);		
	}

}
