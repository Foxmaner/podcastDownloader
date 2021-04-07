import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUI  implements ActionListener{
	
	//Deklarera frame
	JFrame frame;
	
	
	//Deklarera linkSelectPanel
	JPanel linkSelectPanel;
	JLabel linkInstructionLabel; 
	JTextField inputLinkField;
	JButton fetchProgramButton;
	
	//Deklarera programSelectPanel
	JPanel programSelectPanel;
	JTextArea fetchedProgramsTextArea;
	JTextArea selectedProgramsTextArea;
	
	//Deklarera downloadSelectionPanel
	JPanel downloadSelectPanel;
	JLabel downloadLocationInstructionLabel;
	JTextField downloadLocationkField;
	JButton downloadProgramButton;
	
	//Deklarera konsolePanel
	JPanel consolePanel;
	JTextArea consoleStatusTextArea;
	
	
	public GUI(){
		//
		//Skapa frame och layout
		//
		frame = new JFrame();
		frame.setLayout(new GridLayout(4,1));
		
		
		//
		//Skapa panel f�r att skriva in l�nkar
		//
		linkSelectPanel = new JPanel();
		linkSelectPanel.setLayout(new GridLayout(3,1));
		
		linkInstructionLabel = new JLabel("Skriv in l�nken till RSS filen");
		inputLinkField = new JTextField();
		fetchProgramButton = new JButton("H�mta program (Ej ladda ner)");
		
		fetchProgramButton.addActionListener(this);
		
		
		linkSelectPanel.add(linkInstructionLabel);	
		linkSelectPanel.add(inputLinkField);	
		linkSelectPanel.add(fetchProgramButton);
		
		
		//
		//Skapa panel f�r att se och v�lja program
		//
		programSelectPanel = new JPanel();
		programSelectPanel.setLayout(new GridLayout(1,2));
		
		fetchedProgramsTextArea = new JTextArea();
		selectedProgramsTextArea = new JTextArea();
		
		programSelectPanel.add(fetchedProgramsTextArea);
		programSelectPanel.add(selectedProgramsTextArea);
		
		//
		//Skapa panel f�r att v�lja nerladdningsplats
		//
		downloadSelectPanel = new JPanel();
		downloadSelectPanel.setLayout(new GridLayout(3,1));
		
		downloadLocationInstructionLabel = new JLabel("V�lj plats f�r nerladdning");
		downloadLocationkField = new JTextField();
		downloadProgramButton = new JButton("Ladda ner valda program");
		
		downloadProgramButton.addActionListener(this);
		
		
		downloadSelectPanel.add(downloadLocationInstructionLabel);	
		downloadSelectPanel.add(downloadLocationkField);	
		downloadSelectPanel.add(downloadProgramButton);
		
		//
		//Skapa panel f�r konsol/status
		//
		consolePanel = new JPanel();
		consolePanel.setLayout(new GridLayout(1,1));
		
		consoleStatusTextArea = new JTextArea("DDD");
		
		consolePanel.add(consoleStatusTextArea);
		

		//
		//L�gger till alla paneler i framen
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == fetchProgramButton) {
			fetchedProgramsTextArea.append("Fetch");
		}else if(e.getSource() == downloadProgramButton){
			fetchedProgramsTextArea.append("Download");
		}
	}

}
