import java.io.BufferedReader;
import java.util.ArrayList;

//import cmet.ac.lab.Scientist;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// storing file path as string so we can pass it in an object
		
		String path = "C:\\Users\\44783\\Downloads\\sensor_data.csv";
		String line;
		
		//initialising the array list
		
		ArrayList<SensorData> sensorDataValues = new ArrayList<SensorData>() ;
		
		SensorData sensorDataVariable;
		
		
		// we are going to use buffer reader
		// its a lot faster
        
		try {
			BufferedReader br = new	BufferedReader(new FileReader(path));
			
			while((line = br.readLine()) != null) {
				String[] items = line.split(",");
				
				// the numbers are the numbers of columns within the excel sheet
				
				System.out.println("Light level: " + items[7]+ " , temperature: " + items[9]);
				
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
	
}	
