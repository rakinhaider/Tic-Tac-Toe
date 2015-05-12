package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Models.Action;
import Models.Minimax;
import Models.State;
import Models.Utility;

public class TicTacToeUI extends JFrame {

	public static int[][] board = new int[3][3];
	public static MyButton[][] grid;

	public TicTacToeUI() {
		setTitle("Tic Tac Toe Multiplayer");

		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		grid = new MyButton[3][];

		for (int i = 0; i < grid.length; i++) {
			grid[i] = new MyButton[3];
			for (int j = 0; j < grid[i].length; j++) {
				grid[i][j] = new MyButton(i, j);
			}
		}

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				grid[i][j].setBounds(10 + 5 * (j) + 90 * j,
						50 + 70 * i + 5 * i, 90, 70);
				grid[i][j].setText("X");
				grid[i][j].setVisible(true);

				grid[i][j].addActionListener(new MyActionListener());

				// grid[i][j].addActionListener(new ActionListener() {
				//
				// @Override
				// public void actionPerformed(ActionEvent e) {
				// if(Minimax.turn%2==0)((JButton)e.getSource()).setText("O");
				// }
				// });
				panel.add(grid[i][j]);
			}
		}

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(10, 11, 279, 28);
		panel.add(panel_1);

		JLabel label = new JLabel("Tic Tac Toe");
		label.setForeground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_1.add(label);

		JButton btnStart = new JButton("Start");
		btnStart.setForeground(new Color(0, 0, 0));
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Minimax.turn = 1;
				for (int i = 0; i < board.length; i++) {
					for (int j = 0; j < board[i].length; j++) {
						board[i][j] = Utility.EMPTY;
						grid[i][j].setText("");
						grid[i][j].setEnabled(true);
					}
				}

				State s = new State(board);
				Action action = Minimax.miniMaxDecision(s);
				board[action.x][action.y] = Utility.MAXMOVE;
				grid[action.x][action.y].setText("X");

			}
		});
		btnStart.setBounds(59, 281, 89, 23);
		panel.add(btnStart);

		JButton btnReset = new JButton("Reset\r\n");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Minimax.turn = 1;
				for (int i = 0; i < board.length; i++) {
					for (int j = 0; j < board[i].length; j++) {
						board[i][j] = Utility.EMPTY;
						grid[i][j].setText("");
						grid[i][j].setEnabled(true);
					}
				}
			}
		});
		btnReset.setBounds(158, 281, 89, 23);
		panel.add(btnReset);
	}

}

class MyActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		MyButton mb = (MyButton) e.getSource();
		mb.setText("O");
		TicTacToeUI.board[mb.x][mb.y] = Utility.MINMOVE;
		State s = new State(TicTacToeUI.board);
		Action action = Minimax.miniMaxDecision(s);
		TicTacToeUI.board[action.x][action.y] = Utility.MAXMOVE;
		TicTacToeUI.grid[action.x][action.y].setText("X");
		s = new State(TicTacToeUI.board);
		if (Utility.isTerminal(s)) {
			JOptionPane.showMessageDialog(null,
					"You loose. Press Start to play again.");
			for (int i = 0; i < TicTacToeUI.grid.length; i++) {
				for (int j = 0; j < TicTacToeUI.grid.length; j++) {
					TicTacToeUI.grid[i][j].setEnabled(false);
				}
			}
		}
	}

}
