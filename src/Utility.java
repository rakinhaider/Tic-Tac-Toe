public class Utility {

	public static int moves;
	public static final int MAXMOVE = 1;
	public static final int MINMOVE = -1;
	public static final int EMPTY = 0;
	private static int winner = EMPTY;

	public static boolean terminalTest(State state) {
		if (moves == 9)
			return false;
		for (int i = 0; i < state.grid.length; i++) {
			if (state.grid[i][0] == state.grid[i][1]
					&& state.grid[i][1] == state.grid[i][2]
					&& state.grid[i][0] != EMPTY) {
				winner = state.grid[i][0];
				return true;
			}
		}

		for (int i = 0; i < state.grid.length; i++) {
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
		return false;
	}

	public int getUtility(State state) {
		return winner;
	}

}
