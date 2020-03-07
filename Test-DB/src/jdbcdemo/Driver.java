package jdbcdemo;

import java.sql.*;
import java.util.Scanner;
public class Driver {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		try {
			
			// Defining the connection parameters for MySQL connection.
			String hostname = "jdbc:mysql://localhost:3306/sys";
			String user = "Joshgun";
			String pass = "542599";
			String sql;
			String table;
			String countryID, countryName, countryCapital, countryCapitalID, countryPopulation, countryArea;
			// Make Connection
			Connection myCon = DriverManager.getConnection(hostname + user + pass);
			
			// Create Statement
			Statement myStmt = myCon.createStatement();
			
			int command,count;
			ResultSet myRs;
			
			
			do {
				// The operations menu.
				System.out.println(
						"Enter your selection:\n1 for list all table.\n2 for listing specific columns.\n"
						+ "3 for inserting new row to the selected table.\n4 for update the selected row.\n"
						+ "5 for deleting the selected row.\n0 for Exit.");
				// Getting the command from the user.
				command = input.nextInt();
				
				// The operations according to the selection.
				switch(command) {
					case 1:
						System.out.println("Enter the Table name:");
						table = input.next();
						myRs = myStmt.executeQuery("select * from " + table);
							if(table == "country" || table == "Country" || table == "COUNTRY") {
								while(myRs.next()) {
									System.out.println(myRs.getString("ID") + "," + myRs.getString("NAME") + "," + myRs.getString("CAPITAL"));
								}
							}
							else if(table == "city" || table == "City" || table == "CITY") {
								while(myRs.next()) {
									System.out.println(myRs.getString("ID") + "," + myRs.getString("NAME") + "," + myRs.getString("CAPITAL"));
								}
							}
						break;						
					case 2:
						System.out.println("Enter the Table name:");
						table = input.next();
						System.out.println("Enter the wanted columns name:");
						for(int i = 0; i < 7; i++) {
							System.out.println("\n" + i);
							// WILL CONTINUE HERE.
						}
						myRs = myStmt.executeQuery("select * from " + table);
							if(table == "country" || table == "Country" || table == "COUNTRY") {
								while(myRs.next()) {
									System.out.println(myRs.getString("ID") + "," + myRs.getString("NAME") + "," + myRs.getString("CAPITAL"));
								}
							}
							else if(table == "city" || table == "City" || table == "CITY") {
								while(myRs.next()) {
									System.out.println(myRs.getString("ID") + "," + myRs.getString("NAME") + "," + myRs.getString("CAPITAL"));
								}
							}
						break;
					
					// Update the table
					case 3:
						System.out.println("Enter the Table name:");
						table = input.next();
						System.out.println("Enter the row ID:");
						countryID = input.next();
						
						// For Country Table.
						if(table == "country" || table == "Country" || table == "COUNTRY") {
							System.out.println("Enter the new Country name:");
							countryName = input.next();
							System.out.println("Enter the new Capital name:");
							countryCapital = input.next();
							System.out.println("Enter the new Capital ID name:");
							countryCapitalID = input.next();
							System.out.println("Enter the new Population count:");
							countryPopulation = input.next();
							System.out.println("Enter the new Area count:");
							countryArea = input.next();
							
							sql = "update country set name = " + countryName + ", capital = " + countryCapital +
									", capital_id = " + countryCapitalID + ", population = " + countryPopulation + 
									", area = " + countryArea + " where id = " + countryID;
							
							myStmt.executeUpdate(sql);
						}
						// For City Table.
						
						
						break;
					case 4:
						break;
					case 5:
						break;
					default:
						break;
				}
			}while(command != 0);
			
			
		
			
			// Insert Query
			sql = "insert into country" + "(name, capital, population, area)" + "values('Norway', 'Oslo', '554554','223232323')";
			myStmt.executeUpdate(sql);
			
			// Update Query
			sql = "update country set capital = 'Ankara' where id=2";
			myStmt.executeUpdate(sql);
			
			// Delete Query
			sql = "delete from country where name='Russia'";
			myStmt.executeUpdate(sql);
			
			// Select Query
			myRs = myStmt.executeQuery("select * from country");
			while(myRs.next()) {
				System.out.println(myRs.getString("ID") + "," + myRs.getString("NAME") + "," + myRs.getString("CAPITAL"));
			}
		}
		
		catch(Exception exc) {
			exc.printStackTrace();
		}
	
	}

}
