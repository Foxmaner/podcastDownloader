import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUI {
	
	public GUI() {
		
		//
		//Skapa frame och layout
		//
		JFrame frame = new JFrame();
		frame.setLayout(new GridLayout(4,1));
		
		
		//
		//Skapa panel för att skriva in länkar
		//
		JPanel linkSelectPanel = new JPanel();
		linkSelectPanel.setLayout(new GridLayout(3,1));
		
		JLabel linkInstructionLabel = new JLabel("Skriv in länken till RSS filen");
		JTextField inputLinkField = new JTextField();
		JButton fetchProgramButton = new JButton("Hämta program (Ej ladda ner)");
		
		
		linkSelectPanel.add(linkInstructionLabel);	
		linkSelectPanel.add(inputLinkField);	
		linkSelectPanel.add(fetchProgramButton);
		
		
		//
		//Skapa panel för att se och välja program
		//
		JPanel programSelectPanel = new JPanel();
		programSelectPanel.setLayout(new GridLayout(1,2));
		
		JTextArea fetchedProgramsTextArea = new JTextArea();
		JTextArea selectedProgramsTextArea = new JTextArea();
		
		programSelectPanel.add(fetchedProgramsTextArea);
		programSelectPanel.add(selectedProgramsTextArea);
		
		//
		//Skapa panel för att välja nerladdningsplats
		//
		JPanel downloadSelectPanel = new JPanel();
		downloadSelectPanel.setLayout(new GridLayout(3,1));
		
		JLabel downloadLocationInstructionLabel = new JLabel("Välj plats för nerladdning");
		JTextField downloadLocationkField = new JTextField();
		JButton downloadProgramButton = new JButton("Ladda ner valda program");
		
		
		downloadSelectPanel.add(downloadLocationInstructionLabel);	
		downloadSelectPanel.add(downloadLocationkField);	
		downloadSelectPanel.add(downloadProgramButton);
		
		//
		//Skapa panel för konsol/status
		//
		JPanel consolePanel = new JPanel();
		consolePanel.setLayout(new GridLayout(1,1));
		
		JTextArea consoleStatusTextArea = new JTextArea("DDD");
		
		consolePanel.add(consoleStatusTextArea);
		

		//
		//Lägger till alla paneler i framen
		//
		frame.add(linkSelectPanel);
		frame.add(programSelectPanel);
		frame.add(downloadSelectPanel);
		frame.add(consolePanel);
		
		
		
		//
		//Ballt
		//
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
