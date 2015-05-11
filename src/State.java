
public class State {
	
	int[][] grid;
	
	public State(){
		grid = new int[3][3];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				grid[i][j]=0;
			}
		}
	}
	
}
