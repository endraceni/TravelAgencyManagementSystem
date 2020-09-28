package travelagencymanagementsystem;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

import travelagencymanagementsystem.dto.Reservation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import travelagencymanagementsystem.dto.Destination;

public class Document {

	public Document() {}

	FileWriter fileWriter;
	BufferedWriter bufferWritter;
	PrintWriter printWriter;

	private static String defaultPath = "C:\\Users\\User\\Desktop\\";
	
	public void download(ArrayList<Reservation> reservations) throws IOException {
		String filename = "reservations.txt"; // one way of concatenating strings
		String pathFile = defaultPath+filename;
		try {
			fileWriter = new FileWriter(pathFile, true);
			bufferWritter = new BufferedWriter(fileWriter);
			printWriter = new PrintWriter(bufferWritter);
	
			 PrintWriter printWriter = new PrintWriter(fileWriter);
			 printWriter.println();
			 printWriter.println("*********** RESERVATIONS **********");
			 for(Reservation s: reservations) {
				 printWriter.println(s);
			 }
			    
			    printWriter.flush();
	        printWriter.flush();
	   
		} 
		catch (Exception e) {
			System.out.println("Something went wrong.");
			e.printStackTrace();
		}
		finally {
			try {
	        	printWriter.close();
	            bufferWritter.close();
				fileWriter.close();
			}
			catch (Exception e) {
					e.printStackTrace();
			}	
			
		}
	
	
	}
        
        public void downloadDestiation(ArrayList<Destination> destinations) throws IOException {
		String filename = "Destinations.txt"; // one way of concatenating strings
		String pathFile = defaultPath+filename;
		try {
			fileWriter = new FileWriter(pathFile, true);
			bufferWritter = new BufferedWriter(fileWriter);
			printWriter = new PrintWriter(bufferWritter);
	
			 PrintWriter printWriter = new PrintWriter(fileWriter);
			 printWriter.println();
			 printWriter.println("*********** DESTINATIONS **********");
			 for(Destination s: destinations) {
				 printWriter.println(s);
			 }
			    
			    printWriter.flush();
	        printWriter.flush();
	   
		} 
		catch (Exception e) {
			System.out.println("Something went wrong.");
			e.printStackTrace();
		}
		finally {
			try {
	        	printWriter.close();
	            bufferWritter.close();
				fileWriter.close();
			}
			catch (Exception e) {
					e.printStackTrace();
			}	
			
		}
	
	
	}
}