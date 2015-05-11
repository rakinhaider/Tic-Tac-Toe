import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class TicTacToeUI extends JFrame {
	public TicTacToeUI() {
		setTitle("Tic Tac Toe Multiplayer");
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(10, 50, 90, 70);
		panel.add(btnNewButton);
	
		
		JButton button_0= new JButton("");
		button_0.setBounds(105, 50, 90, 70);
		panel.add(button_0);
		
		JButton button_1 = new JButton("");
		button_1.setBounds(200, 50, 90, 70);
		panel.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setBounds(200, 125, 90, 70);
		panel.add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.setBounds(105, 125, 90, 70);
		panel.add(button_3);
		
		JButton button_4 = new JButton("");
		button_4.setBounds(10, 125, 90, 70);
		panel.add(button_4);
		
		JButton button_5 = new JButton("");
		button_5.setBounds(200, 200, 90, 70);
		panel.add(button_5);
		
		JButton button_6 = new JButton("");
		button_6.setBounds(105, 200, 90, 70);
		panel.add(button_6);
		
		JButton button_7 = new JButton("");
		button_7.setBounds(10, 200, 90, 70);
		panel.add(button_7);
		
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
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < Minimax.board.length; i++) {
					for (int j = 0; j < Minimax.board[i].length; j++) {
						Minimax.board[i][j]=0;
					}
				}
			}
		});
		btnStart.setBounds(59, 281, 89, 23);
		panel.add(btnStart);
		
		JButton btnReset = new JButton("Reset\r\n");
		btnReset.setBounds(158, 281, 89, 23);
		panel.add(btnReset);
	}
}
