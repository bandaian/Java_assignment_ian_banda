package cmet.ac.sockets.servers;

import java.io.BufferedReader;
import java.util.ArrayList;



//import cmet.ac.lab.Scientist;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {
	//initialising the array list
	
	private ArrayList<SensorData> sensorDataValues = new ArrayList<SensorData>() ;
	
	
	
	
	
	//constructor to create object type csv reader

	public CSVReader() {
		// TODO Auto-generated method stub
			
		// storing file path as string so we can pass it in an object
		
		String path = "C:\\Users\\44783\\Downloads\\sensor_data.csv";
		String line;
		
	
		
		SensorData sensorDataVariable;
		
		
		// we are going to use buffer reader
		// its a lot faster
        
		try {
			BufferedReader br = new	BufferedReader(new FileReader(path));
			
			while((line = br.readLine()) != null) {
				String[] items = line.split(",");
				
				
				
				// this object
				sensorDataVariable = new SensorData(items[7],  items[9]); 
				// add object to arraylist
	
				
				//System.out.println(sensorDataVariable);
				sensorDataValues.add(sensorDataVariable);
			}
			
			

		
		}
		
		 catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }
		 catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	} 

}





	/**
	 * @return the sensorDataValues
	 * method that will be used in the server
	 */
	public ArrayList<SensorData> getSensorDataValues() {
		return sensorDataValues;
	}
	
}



	
	
