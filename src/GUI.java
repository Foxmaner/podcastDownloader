import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI {
	
	public GUI() {
		JFrame frame = new JFrame();
		frame.setLayout(new GridLayout(4,1));
		
		
		
		JPanel linkSelectPanel = new JPanel();
		JPanel programSelectPanel = new JPanel();
		JPanel downloadSelectPanel = new JPanel();
		JPanel consolePanel = new JPanel();
		
		JButton fetchProgramButton = new JButton("Hämta program");
		
		
		
		frame.add(linkSelectPanel);
		frame.add(programSelectPanel);
		frame.add(downloadSelectPanel);
		frame.add(consolePanel);
		
		
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Podcast Downloader!");
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GUI();
		
	}

}
