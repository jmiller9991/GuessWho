//import libs
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//This class acts as the frame for the game
public class GameFrame extends JFrame {
	
	JPanel initPane = new JPanel();
	JLabel guessWho = new JLabel("Chat Room", SwingConstants.CENTER);
	JButton host = new JButton("Host Game");
	JPanel temp = new JPanel();
	JButton join = new JButton("Join Game");
	TxtHorzBoxLabel joinIP = new TxtHorzBoxLabel("TCP/IP ", 14);
	JButton quit = new JButton("Quit Game");
	JPanel ptemp = new JPanel();
	JLabel ltemp1 = new JLabel("");
	JPanel ptemp2 = new JPanel();
	JLabel ltemp2 = new JLabel("");
	JPanel ptemp3 = new JPanel();
	JLabel ltemp3 = new JLabel("");
	JPanel ptemp4 = new JPanel();
	JLabel ltemp4 = new JLabel("");
	JPanel ptemp5 = new JPanel();
	JLabel ltemp5 = new JLabel("");
	JPanel ptemp6 = new JPanel();
	JLabel ltemp6 = new JLabel("");
	
	//constructor
	GameFrame() {
		build();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setTitle("Chat Room");
		setVisible(true);
		setResizable(false);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	}

	//builds the initial frame
	private void build() {
		Font f = new Font("Bitstream Vera Sans", Font.BOLD, 24);
		Font bf = new Font("Bitstream Vera Sans", Font.BOLD, 12);
		guessWho.setFont(f);
		host.setFont(bf);
		join.setFont(bf);
		quit.setFont(bf);
		joinIP.setLabelFont(bf);
		
		
		initPane.setLayout(new BorderLayout());
		temp.setLayout(new GridLayout(7,1));
		
		ptemp.setLayout(new FlowLayout());
		ptemp.add(ltemp1);
		
		ptemp2.setLayout(new FlowLayout());
		ptemp2.add(ltemp2);
		
		ptemp3.setLayout(new FlowLayout());
		ptemp3.add(ltemp3);
		
		ptemp4.setLayout(new FlowLayout());
		ptemp4.add(ltemp4);
		
		ptemp5.setLayout(new FlowLayout());
		ptemp5.add(ltemp5);
		
		ptemp6.setLayout(new FlowLayout());
		ptemp6.add(ltemp6);
		
		ptemp3.setPreferredSize(new Dimension(20, 50));
		ptemp4.setPreferredSize(new Dimension(50, 50));
		ptemp5.setPreferredSize(new Dimension(50, 50));
		ptemp6.setPreferredSize(new Dimension(50, 50));
		
		temp.add(guessWho);
		temp.add(host);
		temp.add(ptemp);
		temp.add(join);
		temp.add(joinIP);
		temp.add(ptemp2);
		temp.add(quit);
		initPane.add(temp, BorderLayout.CENTER);
		initPane.add(temp, BorderLayout.CENTER);
		initPane.add(ptemp3, BorderLayout.NORTH);
		initPane.add(ptemp4, BorderLayout.EAST);
		initPane.add(ptemp5, BorderLayout.WEST);
		initPane.add(ptemp6, BorderLayout.SOUTH);
		
		host.addActionListener(new ActionListen());
		join.addActionListener(new ActionListen());
		quit.addActionListener(new ActionListen());
		
		add(initPane);
	}	
	
	public static void main(String[] args) {
		GameFrame g = new GameFrame();
	}
	
	private class ActionListen implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(host)) {
				try{
					Network.Host(5974);
				}catch(Exception ex){
					
				}
			}
			
			if(e.getSource().equals(join)) {
				try{
					Network.Client(joinIP.getFieldText(), 5974);
				}catch(Exception ex){
					
				}
			}
			
			if(e.getSource().equals(quit)) {
				System.exit(0);
			}
			
		}
		
	}
}

