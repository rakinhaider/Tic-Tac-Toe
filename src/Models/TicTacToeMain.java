package Models;
import javax.swing.JFrame;

import UI.TicTacToeUI;

public class TicTacToeMain {

	public static void main(String[] args) {
		TicTacToeUI ticTacToeUI=new TicTacToeUI();
		ticTacToeUI.setSize(312, 348); 
		ticTacToeUI.setVisible(true);
		ticTacToeUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
