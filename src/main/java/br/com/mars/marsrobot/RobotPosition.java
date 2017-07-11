package br.com.mars.marsrobot;

public class RobotPosition {
	
	private int x;
	private int y;
	private Orientation o = Orientation.W;
	
	public RobotPosition() {
	}
	
	public RobotPosition(int x, int y, Orientation o) {
		this.x=x;
		this.y=y;
		this.o=o;
	};
	
	@Override
	public String toString() {
		return "(" + x + ", " + y + ", " + o + ")";
	}
	
	public void move(String movements) {
		String[] movementsArray = movements.split("");		
		for (String movement : movementsArray) {
			Movement.valueOf(movement);
		}
	}

}
