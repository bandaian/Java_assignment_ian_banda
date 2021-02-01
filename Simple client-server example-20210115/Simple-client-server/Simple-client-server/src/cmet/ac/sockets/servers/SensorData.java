package cmet.ac.sockets.servers;

/**
 * 
 */

/**
 * @author 44783
 *
 */
public class SensorData {
	// to store a collection of objects
	
	   private String light;
	   private String temperature;
	
		
		
		// constructor
		
	 public SensorData(String light, String temperature) {
		 
		this.light = light;
		 this.temperature = temperature;
	 }
	 
	 // getter
	 
	 /**
	 * @return the light
	 */
	
	

	public String getlight() {
		 
return this.light;
	 }
	
	public String gettemperature() {
		 
		return this.temperature;
			 }
	
	@Override
    public String toString() { 
        return  "LIGHT:  " + this.light+ " , TEMP:  " + this.temperature; 
    }

}
