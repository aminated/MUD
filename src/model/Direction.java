package model;

public enum Direction {
	North, East, South, West;
	public Direction turnBack(){
		switch(this){
			case North: return South;
			case East: return West;
			case South: return North;
			default: return East;
		}
	}
	public Direction turnRight(){
		switch(this){
		case North: return East;
		case East: return South;
		case South: return West;
		default: return North;
	}
	}
	public Direction turnLeft(){
		return this.turnBack().turnRight();
	}
}
