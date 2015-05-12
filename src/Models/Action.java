package Models;

public class Action {
	@Override
	public String toString() {
		return "Action [x=" + x + ", y=" + y + ", value=" + value + "]";
	}
	public int x;
	public int y;
	int value;
	public Action(int x, int y, int value) {
		super();
		this.x = x;
		this.y = y;
		this.value = value;
	}
	
	
	
}
