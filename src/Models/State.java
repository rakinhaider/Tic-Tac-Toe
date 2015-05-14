package Models;

import java.util.ArrayList;
import java.util.Arrays;

public class State {
	
	public static final int XMOVE=1;
	public static final int OMOVE=2;
	public static final int EMPTY=0;
	
	public int getMove() {
		return move;
	}

	public void setMove(int move) {
		this.move = move;
	}

	int[][] grid;
	int move;
	Action actionToTake;
	
	ArrayList<Action> successor;
	public State(int [][] grid){
		this.grid=new int[3][3];
		move=0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				
				this.grid[i][j]=grid[i][j];
				if(this.grid[i][j]!=Utility.EMPTY)move++;
			}
		}
		successor=new ArrayList<Action>();
		
		createSuccessors();
	}
	
	public State performAction(Action action,int value)
	{
		int x=grid[action.x][action.y];
		grid[action.x][action.y]=value;
		State s=new State(this.grid);
		grid[action.x][action.y]=x;
		return s;
	}
	
	
	
	@Override
	public String toString() {
		String s="State [grid=";
		for (int[] is : grid) {
			for (int i : is) {
				s+=i + ", ";
			}
		}
		s+="] , [successor=";
		for (Action a : successor) {
			s+=a.toString();
		}
			
		s+="]";
		return s;
	}

	private void createSuccessors() {
		
		successor.clear();
		
		for(int i=0;i<grid.length;i++)
		{
			for(int j=0;j<grid[i].length;j++)
			{
				if(grid[i][j]==Utility.EMPTY)
				{
					Action action=new Action(i, j, 0,0);
					successor.add(action);
				}
			}
		}
		
	}
	
	public ArrayList<Action> getSuccessor()
	{
		return successor;
	}
	
}
