package phone;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDB {
	   static final String DB_URL = "jdbc:sqlserver://REHAAN10\\SQLEXPRESS01; " + " databaseName = PhoneBook; user = sa; password = Farah2022;encrypt=true;trustServerCertificate=true";
	   static final String USER = "sa";
	   static final String PASS = "Farah2022";
	   
	public static void main(String[] args) {
		  try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			         Statement stmt = conn.createStatement();
			      ) {		      
			         // Execute a query
			         System.out.println("Inserting records into the table...");          
			         String sql = "INSERT INTO Contact VALUES ('Mohamed', 'Farah', 'Eastleigh-12th-street', 'Nairobi',0729937747)";
			         stmt.executeUpdate(sql);
			         String SQl = "INSERT INTO Contact VALUES ('Mohamed', 'Farah', 'Eastleigh-12th-street', 'Nairobi',072967890)";
			         stmt.executeUpdate(SQl);
			      
			         System.out.println("Inserted records into the table...");   	  
			      } catch (SQLException e) {
			         e.printStackTrace();
			      } 
	}
}
