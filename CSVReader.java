/**
 * 
 */
package cmet.ac.fileio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * ian banda
 *
 */
public class CSVReader {

	String filename;	
	String[] data;
	
	public void readFile(String filename) {
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line;
			while((line = br.readLine()) != null) {
				
				data = line.split(",");
				System.out.println("Light level: " + data[7] 
						+ " , temperature: " + data[9]);				
			}						
		} 
		catch (IOException e) {
			System.out.println("IO error occured while trying to read the file...");
		}
		
	}
}
