package MySQLDemo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;


public class MyFrame extends JFrame{
	
	JButton searchButton;
	JLabel searchLabel;
	JTextArea searchText;

	JButton titleButton;
	JLabel titleLabel;
	JTextArea titleText;
	
	JButton rdButton;
	JLabel rdLabel;
	JTextArea rdText;

	JButton tagButton;
	JLabel tagLabel;
	JTextArea tagText;
	
	JButton devButton;
	JLabel devLabel;
	JTextArea devText;
	
	JButton pubButton;
	JLabel pubLabel;
	JTextArea pubText;
	JButton testButton1;


	static JTextArea resultText;

	JButton sp1Button;
	JButton sp2Button;
	JButton sp3Button;
	
	JTextArea bugText;
	
	
	MyFrame(){
		
		//Frame creation
		JFrame frame = new JFrame("Tabbed Pane Sample");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);

		
		//result textbox and scroll bar creation
	    resultText = new JTextArea();
	    resultText.setPreferredSize(new Dimension(600, 3000));
	    JScrollPane jScrollPane = new JScrollPane(resultText);
	    jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    jScrollPane.setViewportBorder(new LineBorder(Color.RED));
	    jScrollPane.getViewport().add(resultText, null);
	    frame.setResizable(false);
	    resultText.setEditable(false);
	    frame.add(jScrollPane, BorderLayout.EAST);
	    frame.setSize(900, 600);
		
	    //Search Price 
		searchText = new JTextArea();
		searchText.setBounds(25,25,100,25);
		searchText.setText("");
		searchText.setBorder(new LineBorder(Color.BLACK));
		searchButton = new JButton();
		searchButton.setBounds(150,25, 100,25);
		searchButton.addActionListener(e -> priceSearch(searchText.getText()));
		searchButton.setText("Search");
		searchButton.setFocusable(false);
		searchLabel = new JLabel();
		searchLabel.setBounds(25,0,150, 25);
		searchLabel.setText("Search Price Here (No . )");
		frame.add(searchButton);
		frame.add(searchLabel);
		frame.add(searchText);
		
		//Search Title
		titleText = new JTextArea();
		titleText.setBounds(25,75,100,25);
		titleText.setText("");
		titleText.setBorder(new LineBorder(Color.BLACK));
		titleButton = new JButton();
		titleButton.setBounds(150,75, 100,25);
		titleButton.addActionListener(e -> titleSearch(titleText.getText()));
		titleButton.setText("Search");
		titleButton.setFocusable(false);
		titleLabel = new JLabel();
		titleLabel.setBounds(25,50,150,25);
		titleLabel.setText("Search Title Here");
		frame.add(titleButton);
		frame.add(titleLabel);
		frame.add(titleText);
		
		
		//Release Date Search
		rdText = new JTextArea();
		rdText.setBounds(25,125,100,25);
		rdText.setText("");
		rdText.setBorder(new LineBorder(Color.BLACK));
		rdButton = new JButton();
		rdButton.setBounds(150,125, 100,25);
		rdButton.addActionListener(e -> releaseSearch(rdText.getText()));
		rdButton.setText("Search");
		rdButton.setFocusable(false);
		rdLabel = new JLabel();
		rdLabel.setBounds(25,100,150, 25);
		rdLabel.setText("Search Release Date Here");
		frame.add(rdButton);
		frame.add(rdLabel);
		frame.add(rdText);
		
		//Tag Search
		tagText = new JTextArea();
		tagText.setBounds(25,175,100,25);
		tagText.setText("");
		tagText.setBorder(new LineBorder(Color.BLACK));
		tagButton = new JButton();
		tagButton.setBounds(150,175, 100,25);
		tagButton.addActionListener(e -> tagSearch(tagText.getText()));
		tagButton.setText("Search");
		tagButton.setFocusable(false);
		tagLabel = new JLabel();
		tagLabel.setBounds(25,150,150, 25);
		tagLabel.setText("Search Tag Here");
		frame.add(tagButton);
		frame.add(tagLabel);
		frame.add(tagText);
		
		//Developer Search
		devText = new JTextArea();
		devText.setBounds(25,225,100,25);
		devText.setText("");
		devText.setBorder(new LineBorder(Color.BLACK));
		devButton = new JButton();
		devButton.setBounds(150,225, 100,25);
		devButton.addActionListener(e -> devSearch(devText.getText()));
		devButton.setText("Search");
		devButton.setFocusable(false);
		devLabel = new JLabel();
		devLabel.setBounds(25,200,150, 25);
		devLabel.setText("Search Developer Here");
		frame.add(devButton);
		frame.add(devLabel);
		frame.add(devText);
		
		//Publisher  Stuff
		pubText = new JTextArea();
		pubText.setBounds(25,275,100,25);
		pubText.setText("");
		pubText.setBorder(new LineBorder(Color.BLACK));
		pubButton = new JButton();
		pubButton.setBounds(150,275,100,25);
		pubButton.addActionListener(e -> pubSearch(pubText.getText()));
		pubButton.setText("Search");
		pubButton.setFocusable(false);
		pubLabel = new JLabel();
		pubLabel.setBounds(25,250,150, 25);
		pubLabel.setText("Search Publisher Here");
		frame.add(pubButton);
		frame.add(pubLabel);
		frame.add(pubText);

		//stored procedure buttons
		sp1Button = new JButton();
		sp1Button.setBounds(25,325, 225, 50);
		sp1Button.addActionListener(e -> stored1());
		sp1Button.setText("Action Games");
		sp1Button.setFocusable(false);
	    frame.add(sp1Button);
		sp2Button = new JButton();
		sp2Button.setBounds(25,400, 225, 50);
		sp2Button.addActionListener(e -> stored2());
		sp2Button.setText("Single Player Games");
		sp2Button.setFocusable(false);
	    frame.add(sp2Button);
		sp3Button = new JButton();
		sp3Button.setBounds(25 ,475, 225, 50);
		sp3Button.addActionListener(e -> stored3());
		sp3Button.setText("Games Unger $29.99");
		sp3Button.setFocusable(false);
		frame.add(sp3Button);
		
		//extra textbox for debugging purposes 
		bugText = new JTextArea();
		bugText.setBounds(0,0,0,0);
		bugText.setEditable(false);
		frame.add(bugText);
		
		frame.setVisible(true);
	}
	
	
	//Stored Procedures 
	public static void stored1(){//this is how we call our first stored procedure
		SimpleStoreProcedureDemo.search("getTotalActionGame", 1);
	}
	public static void stored2(){//this is how we call our second stored procedure
		SimpleStoreProcedureDemo.search("getTotalSinglePlayer", 2);
	}
	public static void stored3(){//this is how we call our third stored procedure
		SimpleStoreProcedureDemo.search("getTotalGame", 3);
	}
	
	public static void priceSearch(String num){//This is the information we send to query for price search
		if (quickTest(num)) {//this is the test to make sure the field isnt empty
			try//this try and catch is to make sure its only numbers  
			{ 
				Integer.parseInt(num); 
				String temp = "select * from Game where price = '";
				temp += num;
				temp += "';";
				SimpleQueryDemo.search(temp);
			}  
			catch (NumberFormatException e)  
			{ 
				updateText("Not a Valid Input"); 
			}
		}
	}
	
	public static void titleSearch(String words){//This is the information we send to query for title search
		if (quickTest(words)) {
			String temp = "select * from Game where title = '";
			temp += words;
			temp += "';";
			SimpleQueryDemo.search(temp);
		}
	}
	
	public static void releaseSearch(String words){//This is the information we send to query for realease date search
		if (quickTest(words)) {
			String temp = "select * from Game where rDate LIKE '";
			temp += words;
			temp += "';";
			SimpleQueryDemo.search(temp);
		}
	}
	
	public static void tagSearch(String words){//This is the information we send to query for tag search
		if (quickTest(words)) {
			String temp = "select appId, category from GameInfo where tags LIKE '%";
			temp += words;
			temp += "';";
			SimpleQueryDemo.search(temp);
		}
	}
	
	public static void devSearch(String words){//This is the information we send to query for developer search
		if (quickTest(words)) {
			String temp = "Select Title from Game G, Developer P where G.appId = P.appID && P.CompanyName LIKE '%";
			temp += words;
			temp += "';";
			SimpleQueryDemo.search(temp);
		}
	}
	
	public static void pubSearch(String words){//This is the information we send to query for publisher search
		if (quickTest(words)) {
			String temp = "Select Title from Game G, Publisher P where G.appId = P.appID && P.CompanyName LIKE '%";
			temp += words;
			temp += "';";
			SimpleQueryDemo.search(temp);
		}
	}
	
	public static void updateText(String words) {//this is where we update the Textbox with our output from the query and stored procedures
		String currentText = resultText.getText();
		resultText.setText(currentText + words);
	}
	
	public static boolean quickTest(String words) {//checks to make sure results aren't empty
		if(words.length() == 0)//if word length is empty
			return false;
		return true;
	}
}
