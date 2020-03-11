package jdbcdemo;

import java.sql.*;
import java.util.Scanner;
public class main {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		try {
			
			// Defining the connection parameters for MySQL connection.
			String hostname = "jdbc:mysql://localhost:3306/sys";
			String user = "joshgun";
			String pass = "542599";
			String sql;
			String table;
			// Variables for Country table
			String countryID, countryName, countryCapital, countryPopulation, countryArea;
			// Variables for City table
			String cityID, cityName, cityLocation, cityArea, cityLatitude, cityLongitude;
			int command;
			ResultSet myRs;

			// Make Connection
			Connection myCon = DriverManager.getConnection(hostname, user, pass);
			
			// Create Statement
			Statement myStmt = myCon.createStatement();
			
			// SQL query for creating table City
			sql = "CREATE TABLE IF NOT EXISTS CITY (\r\n" + 
					"    ID INT NOT NULL AUTO_INCREMENT,\r\n" + 
					"    NAME VARCHAR(45) DEFAULT NULL,\r\n" + 
					"    LOCATION VARCHAR(45) DEFAULT NULL,\r\n" + 
					"    AREA INT DEFAULT NULL,\r\n" + 
					"    LATITUDE INT DEFAULT NULL,\r\n" + 
					"    LONGITUDE INT DEFAULT NULL,\r\n" + 
					"    PRIMARY KEY (ID)\r\n" + 
					") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4";
			myStmt.executeUpdate(sql);
			
			// SQL query for creating table Country
			sql = "CREATE TABLE IF NOT EXISTS COUNTRY (\r\n" + 
					"    ID INT NOT NULL AUTO_INCREMENT,\r\n" + 
					"    NAME VARCHAR(45) DEFAULT NULL,\r\n" + 
					"    CAPITAL VARCHAR(45) DEFAULT NULL,\r\n" + 
					"    CAPITAL_ID INT DEFAULT NULL,\r\n" + 
					"    POPULATION INT DEFAULT NULL,\r\n" + 
					"    AREA INT DEFAULT NULL,\r\n" + 
					"    PRIMARY KEY (ID),\r\n" +
					"    FOREIGN KEY (CAPITAL_ID)\r\n" + 
					"    REFERENCES CITY (ID)\r\n" + 
					") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci";
			myStmt.executeUpdate(sql);
			
			do {
				// The operations menu.
				System.out.println(
						"Enter your selection:\n1 for list all table.\n2 for inserting new row to the selected table.\n"
						+ "3 for update the selected row.\n"
						+ "4 for deleting the selected row.\n0 for Exit.");
				// Getting the command from the user.
				command = input.nextInt();
				
				// The operations according to the selection.
				switch(command) {
					// List all table
					case 1:
						System.out.println("Enter the Table name:\n");
						table = input.next();
						myRs = myStmt.executeQuery("select * from " + table);
						if(table.equals("country") || table.equals("Country") || table.equals("COUNTRY")) {
							while(myRs.next()) {
								System.out.println(myRs.getString("ID") + "\t" + myRs.getString("NAME") + "\t" + myRs.getString("CAPITAL") + "\t" + myRs.getString("POPULATION") + "\t" + myRs.getString("AREA"));
							}
							System.out.println("\n");
						}
						else if(table.equals("city") || table.equals("City") || table.equals("CITY")){
							while(myRs.next()) {
								System.out.println(myRs.getString("ID") + "\t" + myRs.getString("NAME") + "\t" + myRs.getString("LOCATION") +  "\t" + myRs.getString("AREA") +  "\t" + myRs.getString("LATITUDE") +  "\t" + myRs.getString("LONGITUDE"));
							}
							System.out.println("\n");
						}
						break;
					
					// Insert new data
					case 2:
						System.out.println("Enter the Table name:");
						table = input.next();
						
						// For Country Table.
						if(table.equals("country") || table.equals("Country") || table.equals("COUNTRY")) {
							System.out.println("Enter the new Country name:");
							countryName = input.next();
							System.out.println("Enter the new Capital name:");
							countryCapital = input.next();
							System.out.println("Enter the new Population count:");
							countryPopulation = input.next();
							System.out.println("Enter the new Area count:");
							countryArea = input.next();
							
							// Insert SQL query
							sql = "insert into country" + "(name, capital, population, area)" + "values('" + countryName + "', '" + countryCapital + "', '" + countryPopulation + "', '" + countryArea + "')";
							
							myStmt.executeUpdate(sql);
						}
						
						// For City Table.
						else if(table.equals("city") || table.equals("City") || table.equals("CITY")) {
							System.out.println("Enter the new City name:");
							cityName = input.next();
							System.out.println("Enter the new City Location:");
							cityLocation = input.next();
							System.out.println("Enter the new City Area:");
							cityArea = input.next();
							System.out.println("Enter the new City Latitude:");
							cityLatitude = input.next();
							System.out.println("Enter the new City Longitude:");
							cityLongitude = input.next();
							
							// Insert SQL query
							sql = "insert into city" + "(name, location, area, latitude, longitude)" + "values('" + cityName + "', '" + cityLocation + "', '" + cityArea + "', '" + cityLatitude + "', '" + cityLongitude + "')";
							
							myStmt.executeUpdate(sql);
						}
						break;
					
					// Update the table
					case 3:
						System.out.println("Enter the Table name:");
						table = input.next();
						
						// For Country Table.
						if(table.equals("country") || table.equals("Country") || table.equals("COUNTRY")) {
							System.out.println("Enter the country ID that you want to update:");
							countryID = input.next();
							System.out.println("Enter the new Country name:");
							countryName = input.next();
							System.out.println("Enter the new Capital name:");
							countryCapital = input.next();
							System.out.println("Enter the new Population count:");
							countryPopulation = input.next();
							System.out.println("Enter the new Area count:");
							countryArea = input.next();
							
							// Update SQL query
							sql = "update country set name = '" + countryName + "', capital = '" + countryCapital +
									"', population = '" + countryPopulation + 
									"', area = '" + countryArea + "' where id = " + countryID;
							
							myStmt.executeUpdate(sql);
						}
						
						// For City Table.
						else if(table.equals("city") || table.equals("City") || table.equals("CITY")) {
							System.out.println("Enter the City ID that you want to update:");
							cityID = input.next();
							System.out.println("Enter the new City name:");
							cityName = input.next();
							System.out.println("Enter the new City Location:");
							cityLocation = input.next();
							System.out.println("Enter the new City Area:");
							cityArea = input.next();
							System.out.println("Enter the new City Latitude:");
							cityLatitude = input.next();
							System.out.println("Enter the new City Longitude:");
							cityLongitude = input.next();
							
							// Update SQL query
							sql = "update city set name = '" + cityName + "', location = '" + cityLocation +
									"', area = '" + cityArea + 
									"', latitude = '" + cityLatitude + "', longitude = '" + cityLongitude +"' where id = " + cityID;
							
							myStmt.executeUpdate(sql);
						}
						break;
					
					// Delete the row
					case 4:
						System.out.println("Enter the Table name:");
						table = input.next();
						
						// For Country table
						if(table.equals("country") || table.equals("Country") || table.equals("COUNTRY")) {
							System.out.println("Enter the country ID that you want to delete:");
							countryID = input.next();
							
							// Delete SQL query
							sql = "delete from country where id=" + countryID;
							myStmt.executeUpdate(sql);
						}
						
						// For City table
						else if(table.equals("city") || table.equals("City") || table.equals("CITY")) {
							System.out.println("Enter the City ID that you want to delete:");
							cityID = input.next();
							
							// Delete SQL query
							sql = "delete from city where id=" + cityID;
							myStmt.executeUpdate(sql);
						}
						break;
					default:
						break;
				}
			}while(command != 0);  // end for do-while
		}
		
		catch(Exception exc) {
			exc.printStackTrace();
		}
	
	}

}
