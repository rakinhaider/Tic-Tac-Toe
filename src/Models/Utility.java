package Models;
public class Utility {

	public static int moves;
	public static final int MAXMOVE = 1;
	public static final int MINMOVE = -1;
	public static final int EMPTY = 0;
	private static int winner = EMPTY;

	public static boolean isTerminal(State state) {
		for (int i = 0; i < state.grid.length; i++) {
			if (state.grid[i][0] == state.grid[i][1]
					&& state.grid[i][1] == state.grid[i][2]
					&& state.grid[i][0] != EMPTY) {
				winner = state.grid[i][0];
				return true;
			}
			if (state.grid[0][i] == state.grid[1][i]
					&& state.grid[1][i] == state.grid[2][i]
					&& state.grid[0][i] != EMPTY) {
				winner = state.grid[0][i];
				return true;
			}
		}

		if (state.grid[0][0] == state.grid[1][1]
				&& state.grid[1][1] == state.grid[2][2]
				&& state.grid[0][0] != EMPTY) {
			
			winner=state.grid[1][1];
			return true;

		}
		if (state.grid[0][2] == state.grid[1][1]
				&& state.grid[1][1] == state.grid[2][0]
				&& state.grid[2][0] != EMPTY)
			{
				winner=state.grid[1][1];
				return true;
			}
		
		if (state.move == 9)
			return true;
		return false;
	}

	public static int getUtility(State state) {
		
		
		return winner;
	}
	
	public static int max(int a, int b)
	{
		if(a>=b)return a;
		return b;
	}
	
	public static int min(int a, int b)
	{
		if(a<=b)return a;
		return b;
	}

}
