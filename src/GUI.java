import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

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
		//Skapa panel för att skriva in länkar
		//
		linkSelectPanel = new JPanel();
		linkSelectPanel.setLayout(new GridLayout(3,1));
		
		linkInstructionLabel = new JLabel("Skriv in länken till RSS filen");
		inputLinkField = new JTextField();
		fetchProgramButton = new JButton("Hämta program (Ej ladda ner)");
		
		fetchProgramButton.addActionListener(this);
		
		
		linkSelectPanel.add(linkInstructionLabel);	
		linkSelectPanel.add(inputLinkField);	
		linkSelectPanel.add(fetchProgramButton);
		
		
		//
		//Skapa panel för att se och välja program
		//
		programSelectPanel = new JPanel();
		programSelectPanel.setLayout(new GridLayout(1,2));
		
		fetchedProgramsTextArea = new JTextArea();
		selectedProgramsTextArea = new JTextArea();
		
		programSelectPanel.add(fetchedProgramsTextArea);
		programSelectPanel.add(selectedProgramsTextArea);
		
		//
		//Skapa panel för att välja nerladdningsplats
		//
		downloadSelectPanel = new JPanel();
		downloadSelectPanel.setLayout(new GridLayout(3,1));
		
		downloadLocationInstructionLabel = new JLabel("Välj plats för nerladdning");
		downloadLocationkField = new JTextField();
		downloadProgramButton = new JButton("Ladda ner valda program");
		
		downloadProgramButton.addActionListener(this);
		
		
		downloadSelectPanel.add(downloadLocationInstructionLabel);	
		downloadSelectPanel.add(downloadLocationkField);	
		downloadSelectPanel.add(downloadProgramButton);
		
		//
		//Skapa panel för konsol/status
		//
		consolePanel = new JPanel();
		consolePanel.setLayout(new GridLayout(1,1));
		
		consoleStatusTextArea = new JTextArea();
		
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
		
		//testReadFirstPodcastName();
		loadAllPodcasts();
	}
		
	
	private Document document;
	private XMLPodcast[] podcastList;
	
	public void setUpDocument() {
		
		try {
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream("tomochpetter.xml");
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		document = builder.parse(inputStream);
		

		}catch(Exception e) {
			System.out.println("Error: " + e);
		}
		
	}
	
	public void testReadFirstPodcastName() {
		setUpDocument();
		
		
		
		NodeList items = document.getElementsByTagName("item");
		Element firstItem = (Element)items.item(0);
		NodeList titles = firstItem.getElementsByTagName("title");
		Element title = (Element)titles.item(0);
		
		System.out.println("testReadFirstPodcastName()= : " + title.getTextContent());
	}
	
	public void loadAllPodcasts() {
		setUpDocument();
		
		NodeList items = document.getElementsByTagName("item");
		int nrOfItems = items.getLength();
		System.out.println(nrOfItems);
		
		for(int i = 0; i<nrOfItems; i++) {
		
		Element firstItem = (Element)items.item(i);
		NodeList titles = firstItem.getElementsByTagName("title");
		Element title = (Element)titles.item(0);
		
		System.out.println("testReadFirstPodcastName()= : " + title.getTextContent());
		}
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
