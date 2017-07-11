package br.com.mars.marsrobot;

public class RobotPosition {
	
	protected int x;
	protected int y;
	private Orientation o = Orientation.N;
	
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
			Movement.valueOf(movement).move(this);
		}
	}
	
	public void moveLeft() {
		o = o.getLeftOrientation();
	}
	
	public void moveRight() {
		o = o.getRightOrientation();
	}

	public void moveOnePosition() {
		o.move(this);
		if(x>=5 || y>=5 || x<0 || y<0) throw new IllegalStateException();
	}

}
