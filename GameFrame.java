//import libs
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//This class acts as the frame for the game
public class GameFrame extends JFrame {
	
	//constructor
	GameFrame() {
		build();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(360, 220);
		setTitle("Guess Who");
		setVisible(true);
	}

	//builds the initial frame
	private void build() {
		JPanel initPane = new JPanel();
		JButton host = new JButton("Host Game");
		JPanel temp = new JPanel();
		JButton join = new JButton("Join Game");
		TxtHorzBoxLabel joinIP = new TxtHorzBoxLabel("TCP/IP", 14);
		JButton quit = new JButton("Quit Game");
		GridBagConstraints c = new GridBagConstraints();
		
		join.setPreferredSize(new Dimension(340,25));
		
		initPane.setLayout(new BorderLayout());
		initPane.add(host, BorderLayout.NORTH);
		temp.setLayout(new GridBagLayout());
		c.gridx = 0;
		c.gridy = 0;
		temp.add(join, c);
		c.gridx = 0;
		c.gridy = 1;
		temp.add(joinIP, c);
		initPane.add(temp, BorderLayout.CENTER);
		initPane.add(quit, BorderLayout.SOUTH);
		
		add(initPane);
	}	
	
	public static void main(String[] args) {
		GameFrame g = new GameFrame();
	}
	
	private class ActionListen implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}


