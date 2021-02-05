package cmet.ac.sockets.servers;


import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * 
 * @author thanuja
 *
 * A simple server class, listen to a port and serves clients when they connect..
 *
 */
public class SampleServer 
{   
	int 	portnumber;
	
	ServerSocket 	server_socket;
	
	// reference variable to store object IO streams, should be used when working with serialized objects.
	// Students to use and replace datainput streams..
	ObjectOutputStream 		objoutput;
	ObjectInputStream 		objinput;
	
	DataInputStream 		dis;
	DataOutputStream 		dos;
	
	// initilise csv reaser object
	CSVReader csvtest = new CSVReader();
	
	// taking value from csv reader
	
   ArrayList<SensorData> sensorDataValues = csvtest.getSensorDataValues() ;
	
	/**
	 * Constructor to run the server..
	 * @param port
	 */
	public SampleServer(int port) {
		
		this.portnumber = port;
			
		try {
			this.server_socket = new ServerSocket(port);
			
			System.out.println("## server is listening to port: " + port + " waiting for client connections..");
			
			for (int i = 0; i< sensorDataValues.size(); i++ ) {
				// the numbers are the numbers of columns within the excel sheet
				
				System.out.println( sensorDataValues.get(i));}
				//Thread.sleep(2000);}
			
			
			
			while (true) //infinite while loop
			{ 
				Socket s = null; //Declare a variable s of type socket and set it to null
				
				try
				{ 
					// socket object to receive incoming client requests 
					s = this.server_socket.accept(); 
					
					System.out.println("A new client is connected : " + s); 
					
					
					
					
					// obtaining input and out streams 
					dis = new DataInputStream(s.getInputStream()); 
					dos = new DataOutputStream(s.getOutputStream()); 
					
					System.out.println("Assigning new thread for this client"); 

					// create a new thread to handle the connected client 
					Thread t = new SampleClientHandler(s, dis, dos); //declare a new thread t of type ClientHandler

					// Invoking the start() method 
					t.start(); //Start the client handler
					
				} // End try part
				catch (Exception e){ 
					s.close(); 
					e.printStackTrace(); 
				} // End catch
			} // End while
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
}
	
	/**
	 * Main program...
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException 
	{ 
		// server is listening on port 5056 as previous example port changed from 3142
		
		//int port = Integer.parseInt(args[0]);	
		int port = 0102;
		SampleServer server = new SampleServer(port);		
		
	} // End Main
} // End Server Class


/**
 * A client handler class.
 * an instance of this class is created when a new client client is connected..
 * Each instance acts as a separate thread.
 * @author thanuja
 *
 */
class SampleClientHandler extends Thread 
{ 
	
	final DataInputStream 			dis; //Declare dis as DataInputStream
	final DataOutputStream 			dos; //Declare dos as DataOutputStream
	
	final Socket 					s; //Declare s as a Socket
	
	// initilise csv reaser object
	CSVReader csvtest = new CSVReader();
	
	// taking value from csv reader
	
   ArrayList<SensorData> sensorDataValues = csvtest.getSensorDataValues() ;

	/**
	 * Constructor.
	 * 
	 * @param s
	 * @param dis
	 * @param dos
	 */
	public SampleClientHandler(Socket s, DataInputStream dis, DataOutputStream dos) 
	{ 
		this.s = s; 
		this.dis = dis; 
		this.dos = dos; 
	} 

	@Override
	/**
	 * run method, called when a client handler thread is starting..
	 * responds to client requests
	 */
	public void run() 
	{ 
		//Declare two strings for receive and return information
		String received; 
		String toreturn; 
		
		//Infinite loop setup
		while (true) 
		{ 
			try { 

				// Ask user what he wants 
				dos.writeUTF("Welcome to the server connection. Type something..."); 
				
				// receive the answer from client 
				received = dis.readUTF(); 
				
				System.out.println(received);
				
				if(received.equals("Exit")) 
				{ 
					System.out.println("Client " + this.s + " sends exit..."); 
					System.out.println("Closing this connection."); 
					this.s.close(); 
					System.out.println("Connection closed"); 
					break; 
				} 
				
				//for (int i; i <  sensorDataValues.lenght();) {};
				
				for (int i = 0; i< sensorDataValues.size(); i++ ) {
					// the numbers are the numbers of columns within the excel sheet
					
					dos.writeUTF("Server response: " + sensorDataValues.get(i) );
					
					
					}
				
				// server response is simply the upper case of client request.
				//dos.writeUTF("Server response: " + received.toUpperCase()); 		
		
				
			} catch (IOException e) { 
				e.printStackTrace(); 
			} 
		} 
		
		try
		{ 
			// closing resources 
			this.dis.close(); 
			this.dos.close(); 
			
		}catch(IOException e){ 
			e.printStackTrace(); 
		} 
	}

	private String getSensorDataValues() {
		// TODO Auto-generated method stub
		return null;
	} 
} 