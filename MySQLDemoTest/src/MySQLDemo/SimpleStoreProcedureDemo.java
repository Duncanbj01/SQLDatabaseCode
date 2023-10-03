package MySQLDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.CallableStatement;
import java.sql.Types;

public class SimpleStoreProcedureDemo extends MyFrame{

	static final String databasePrefix ="cs366-2231_duncanbj01";
    static final String netID ="duncanbj01"; // Please enter your netId
    static final String hostName ="washington.uww.edu"; //140.146.23.39 or washington.uww.edu
    static final String databaseURL ="jdbc:mariadb://"+hostName+"/"+databasePrefix;
    static final String password="bd1413"; // please enter your own password
     		    
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultSet = null;

	public static int current = 0;
	
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

	public void simpleStoreProcedure(String spName) {
	try {
		statement = connection.createStatement();
		int total =0;
		CallableStatement myCallStmt = connection.prepareCall("{call "+spName+"(?)}");
        myCallStmt.registerOutParameter(1,Types.BIGINT);
        myCallStmt.execute();
        total = myCallStmt.getInt(1);
        
        /////////////// This is just for readability which explains what the total result is when accessing the Stored Procedure
    	if (current == 1)
            MyFrame.updateText("Total number of Games under Action Tag: \n");
    	else if (current == 2)
            MyFrame.updateText("Total number of Games in Single Player Category: \n");
    	else if (current == 3)
            MyFrame.updateText("Total number of Games under $29.99: \n");
    	//////////////
        MyFrame.updateText(String.valueOf(total));//this sends the total result to updateText function which outputs it into the textbox
	}
	catch (SQLException e) {
		e.printStackTrace();
	}
} 
	
	
public static void main(String args[]) {

	SimpleStoreProcedureDemo demoObj = new SimpleStoreProcedureDemo();
	demoObj.Connection();
}

public static void search(String searchString, int num) {//my search function that is called by myFrame and accepts the storedProcedure name (Also accepts an int for readability)
	current = num;
	SimpleStoreProcedureDemo demoObj = new SimpleStoreProcedureDemo();
	demoObj.Connection();
	demoObj.simpleStoreProcedure(searchString);
}



}
