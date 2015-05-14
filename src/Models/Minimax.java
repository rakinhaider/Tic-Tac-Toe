package Models;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Minimax {
	
	
	
	
	public static int turn=0;
	
	public static Action miniMaxDecision(State state)
	{
		int v = maxValue(state,-11,+11);
		System.out.println(state.actionToTake.value);
		return state.actionToTake;
	}
	
/*	private static int maxValue(State state) {
		
		if(Utility.isTerminal(state))
		{
			return Utility.getUtility(state);
		}
		
		int v=-2;
		int prevv=-2;
		for (Action a : state.getSuccessor()) {
			
			State s= state.performAction(a, Utility.MAXMOVE);
			v=Utility.max(v, minValue(s));
			if(v>prevv || prevv==-2)
			{
				a.value=v;
				state.actionToTake=a;
			}
			prevv=v;
		}
		return v;
	}

	private static int minValue(State state) {
		if(Utility.isTerminal(state))
		{
			return Utility.getUtility(state);
		}
		
		int v=2;
		int prevv=2;
		for (Action a : state.getSuccessor()) {
			
			State s= state.performAction(a, Utility.MINMOVE);
			v=Utility.min(v, maxValue(s));
			if(v<prevv || prevv==2)
			{
				a.value=v;
				state.actionToTake=a;
			}
			prevv=v;
		}
		return v;	
	}
*/
private static int maxValue(State state,int alpha,int beta) {
		
		if(Utility.isTerminal(state))
		{
			return (10-state.move)*Utility.getUtility(state);
			//return Utility.getUtility(state);
		}
		
		int v=-11;
		int prevv=-11;
		for (Action a : state.getSuccessor()) {
			
			State s= state.performAction(a, Utility.MAXMOVE);
			//s.setMove(state.move+1);
			v=Utility.max(v, minValue(s,alpha,beta));
			if(v>prevv)
			{
				a.value=v;
				state.actionToTake=a;
			}
			
			if(v>=beta)return v;
			alpha=Utility.max(alpha,v);
			
			prevv=v;
		}
		return v;
	}

	private static int minValue(State state,int alpha,int beta) {
		if(Utility.isTerminal(state))
		{
			return (10-state.move)*Utility.getUtility(state);
			//return Utility.getUtility(state);
		}
		
		int v=11;
		int prevv=11;
		for (Action a : state.getSuccessor()) {
			
			State s= state.performAction(a, Utility.MINMOVE);
			//s.setMove(state.move+1);
			v=Utility.min(v, maxValue(s,alpha,beta));
			if(v<prevv)
			{
				a.value=v;
				state.actionToTake=a;
			}
			
			if(v<=alpha)return v;
			beta=Utility.min(beta,v);
			
			prevv=v;
		}
		return v;	
	}

	
	public static void main(String[] args) {
	
		Scanner sc= new Scanner(System.in);
		int count=0;
		int N= Integer.parseInt(args[count++]);
		
		int[][] grid= new int [N][N];
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				grid[i][j]=Integer.parseInt(args[count++]);
			}
		}
		
		State s= new State(grid);
		System.out.println(Utility.isTerminal(s));
		System.out.println(s);
		count=1;
		State cur=s;
		while(!Utility.isTerminal(cur))
		{
			Action mavMove=miniMaxDecision(cur);
			cur=cur.performAction(mavMove, Utility.MAXMOVE);
//			for (int[] is : cur.grid) {
//				for (int i : is) {
//					System.out.print(i+" ");
//				}
//				System.out.println();
//			}
			Action minmove=new Action(sc.nextInt(), sc.nextInt(), 0,0);
			cur=cur.performAction(minmove, Utility.MINMOVE);
		}
		
		
//		for (int[] is : grid) {
//			for (int i : is) {
//				System.out.print(i+ " ");
//			}
//			System.out.println();
//		}
//		
	}
	
	
}

