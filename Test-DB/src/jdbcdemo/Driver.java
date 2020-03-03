package jdbcdemo;

import java.sql.*;
public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			// Make Connection
			Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","joshgun","542599");
			
			// Create Statement
			Statement myStmt = myCon.createStatement();
			
			// Insert Query
			String sql = "insert into country" + "(name, capital, population, area)" + "values('Norway', 'Oslo', '554554','223232323')";
			myStmt.executeUpdate(sql);
			
			// Update Query
			sql = "update country set capital = 'Ankara' where id=2";
			myStmt.executeUpdate(sql);
			
			// Delete Query
			sql = "delete from country where name='Russia'";
			myStmt.executeUpdate(sql);
			
			// Select Query
			ResultSet myRs = myStmt.executeQuery("select * from country");
			while(myRs.next()) {
				System.out.println(myRs.getString("ID") + "," + myRs.getString("NAME") + "," + myRs.getString("CAPITAL"));
			}
		}
		
		catch(Exception exc) {
			exc.printStackTrace();
		}
	
	}

}
