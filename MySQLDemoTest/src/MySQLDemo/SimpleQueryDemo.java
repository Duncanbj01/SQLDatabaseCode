package MySQLDemo;

import javax.swing.JOptionPane; //GUI


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class SimpleQueryDemo extends MyFrame{

	//MyFrame frame = new MyFrame();
	String results;
	
	
	static final String databasePrefix ="cs366-2231_duncanbj01";
    static final String netID ="duncanbj01"; // Please enter your netId
    static final String hostName ="washington.uww.edu"; //140.146.23.39 or washington.uww.edu
    static final String databaseURL ="jdbc:mariadb://"+hostName+"/"+databasePrefix;
    static final String password="bd1413"; // please enter your own password
	   
	    private Connection connection = null;
        private Statement statement = null;
        private ResultSet resultSet = null;
        
	    public void Connection(){
	  
	      try {
	    	    Class.forName("org.mariadb.jdbc.Driver");
	    	  	System.out.println("databaseURL"+ databaseURL);
	            connection = DriverManager.getConnection(databaseURL, netID, password);
	            System.out.println("Successfully connected to the database");
	         }
	        catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	        catch (SQLException e) {
	            e.printStackTrace();
	        }
	    } // end of Connection
	    
//	    public void firstIterationQuery(String sqlQuery) {//This is the example Query which sends all information into the console
//	    
//	    	try {
//	    		statement = connection.createStatement();
//	    		resultSet = statement.executeQuery(sqlQuery);
//
//	    		ResultSetMetaData metaData = resultSet.getMetaData();
//	    		int columns = metaData.getColumnCount();
//
//	    		for (int i=1; i<= columns; i++) {
//	    			System.out.print(metaData.getColumnName(i)+"\t");
//	    		}
//
//	    		System.out.println();
//
//	    		while (resultSet.next()) {
//	       
//	    			for (int i=1; i<= columns; i++) {
//	    				System.out.print(resultSet.getObject(i)+"\t\t");
//	    			}
//	    			System.out.println();
//	    		}
//	    	}
//	    	catch (SQLException e) {
//	    		e.printStackTrace();
//	    	}
//	    } // end of simpleQuery method
	    
	    public void simpleQuery(String sqlQuery) { //Updated Query that sends information to updateText function that then sends it to our Textbox
		    
	    	try {
	    		statement = connection.createStatement();
	    		resultSet = statement.executeQuery(sqlQuery);

	    		ResultSetMetaData metaData = resultSet.getMetaData();
	    		int columns = metaData.getColumnCount();

	    		for (int i=1; i<= columns; i++) {
//	    			System.out.print(metaData.getColumnName(i)+"\t");//changed from system out to sending to my update text function
	    	    	MyFrame.updateText(metaData.getColumnName(i)+"\t\t");
	    		}
//	    		System.out.println();
	    		MyFrame.updateText("\n");

	    		while (resultSet.next()) {
	       
	    			for (int i=1; i<= columns; i++) {
//	    				System.out.print(resultSet.getObject(i)+"\t\t");
	    				MyFrame.updateText(resultSet.getObject(i)+"\t\t");
	    			}
	    			//System.out.println();
		    		MyFrame.updateText("\n");
	    		}
	    	}
	    	catch (SQLException e) {
	    		e.printStackTrace();
	    	}
	    } // end of simpleQuery method
	    
	    public static void main(String args[]) 
	    {
	    	SimpleQueryDemo demoObj = new SimpleQueryDemo();
	    	demoObj.Connection();
	    }
	    
	    public static void search(String searchString) {//search function that is called by myFrame which has the string of text
	    	SimpleQueryDemo demoObj = new SimpleQueryDemo();
	    	demoObj.Connection();
	    	demoObj.simpleQuery(searchString);
	    }
}

