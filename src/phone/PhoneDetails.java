package phone;

import java.io.*;
import java.sql.*;
import java.util.*;

public class PhoneDetails {
	public static String help_msg = "Press: H Help -  A Add contact  - S search  - D Delete  - M Modify  -  CR  CountRecords  -  DAR  Display All Records - Q  Quit:";
	public static void main(String[] args) {
		Connection conn = null; 
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection("jdbc:sqlserver://REHAAN10\\SQLEXPRESS01; " + " databaseName = PhoneBook; user = sa; password = Farah2022;encrypt=true;trustServerCertificate=true");
			System.out.println("\n\n***** Welcome to MyPhone Book *****\n\n");
			Scanner S = new Scanner(System.in);
			String command = "";
			for(;;) {
				 System.out.print("[Main Menu] "+help_msg+"\n:");
				    command=S.next().trim();
				    if(command.trim().isEmpty()) {continue;}
				    
				    if(command.equalsIgnoreCase("H")) {
				    	System.out.println("help_msg");
				    	
				    	/*Adding contacts*/
				    } else if(command.equalsIgnoreCase("A")) {
				    	System.out.println("Type in contact details in the format: name, lastname,phone\n");
				    	for(;;) {
				    		String data =  S.next().trim();
				    		String [] temp = data.split(";");
				    		if(temp.length !=3) {
				    			System.out.println("Error, the insertion format should be in the format: firstname,lastname,phone :");
				    			continue;
				    		}
				    		
				    		conn.createStatement().executeUpdate("insert into contacts (name, lastname, phone) value" + 
				    		"('"+temp[0] + "','" + temp[1] + "','" +temp[2]+"')");
				    		break;
				    	}
				    	/*
						* 	
						*Searching for Contacts
						*
						*/
				    }else if (command.equalsIgnoreCase("S")){
				    	System.out.print("Type in the name you are searching for :\n:");
				    	String data=S.next().trim();  

				    	String q="select * from contacts  where name like '%"+data+"%' or lname like '%"+data+"%'";

						PreparedStatement pst=conn.prepareStatement(q);
						pst.clearParameters();
						ResultSet rs=pst.executeQuery();

						System.out.println("********          Results          *********");
						System.out.println("ID\t\tName\t\tLast Name\t\tPhone");
						while(rs.next()){
						    System.out.println(rs.getString(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t"+rs.getString(4));
						}
			}
		}
	} catch(Exception e) {
		e.printStackTrace();
	}
}
}
