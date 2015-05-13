package Models;

public class Action {
	@Override
	public String toString() {
		return "Action [x=" + x + ", y=" + y + ", value=" + value + "]";
	}
	public int x;
	public int y;
	int move;
	int value;
	public Action(int x, int y, int value,int move) {
		super();
		this.x = x;
		this.y = y;
		this.value = value;
		this.move=move;
	}
	
	
	
}
