package phone;

import java.io.*;
import java.sql.*;
import java.util.*;

public class PhoneBook {
	public static String help_msg = "Press: H Help -  A Add contact  - S search  - D Delete  - M Modify  -  CR  CountRecords  -  DAR  Display All Records - Q  Quit:";
	public static void main(String[] args) {
		System.out.println("\n\n**** Welcome to MyPhone Book ****\n\n");
		Scanner S = new Scanner(System.in);
		for(;;) {
			System.out.println("[Main Menu]" +help_msg+"\n:");
			String command = S.nextLine().trim();
			
			if(command.equalsIgnoreCase("H")) {
				System.out.println(help_msg);
			}else if(command.equalsIgnoreCase("A")) {
				  System.out.println("Type in contact details in the format: name, firstname, phone");
			}else if(command.equalsIgnoreCase("S")) {
				System.out.println("Type in the name you are searching for: \n:");
			}else if(command.equalsIgnoreCase("D")) {
				System.out.println("Type the delete details:");
			}else if(command.equalsIgnoreCase("M")) {
				System.out.println("Modify the details from the user:");
			}else if(command.equalsIgnoreCase("CR")) {
				System.out.println("Count records: ");
			}else if(command.equalsIgnoreCase("DAR")) {
				System.out.println("Display all records from the user");
			}else if(command.equalsIgnoreCase("Q")) {
				System.out.println("Good bye user.....");
				System.exit(0);
			}else {
				System.out.println("Unknown command ! Try again \n:");
			}
		}
	}

}
