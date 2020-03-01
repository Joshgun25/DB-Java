package jdbcdemo;

import java.sql.*;
public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","joshgun","542599");
			
			Statement myStmt = myCon.createStatement();
			
			ResultSet myRs = myStmt.executeQuery("select * from country");
			
			while(myRs.next()) {
				System.out.println(myRs.getString("NAME") + "," + myRs.getString("CAPITAL"));
			}
		}
		
		catch(Exception exc) {
			exc.printStackTrace();
		}
	
	}

}
