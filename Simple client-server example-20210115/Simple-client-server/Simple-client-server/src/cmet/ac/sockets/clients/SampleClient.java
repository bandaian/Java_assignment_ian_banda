package cmet.ac.sockets.clients;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *  
 * @author thanuja
 * 
 * Class represents a simple client program
 * User types in a command, server responds and displays in terminal output
 */
public class SampleClient 
{ 
	// reference variable to store object IO streams, should be used when working with serialized objects.
	// To be used by students instead of DataInputStream...	
	ObjectOutputStream 		objoutput;
	ObjectInputStream 		objinput;
	
	// variables to store IP and port number
	String					ipaddress;
	int						portnumber;
	
	// Handle IO streams to and from socket
	DataInputStream 		dis;
	DataOutputStream 		dos;
	
	public SampleClient(String ipaddress, int port) {
		this.ipaddress = ipaddress;
		this.portnumber = port;
		
		Scanner scn = new Scanner(System.in); 

		// establish the connection with server 
		try {
			Socket s = new Socket(this.ipaddress, this.portnumber);
			
			dis = new DataInputStream(s.getInputStream()); 
			dos = new DataOutputStream(s.getOutputStream()); 
			
			// the following loop performs the exchange of 
			// information between client and client handler in the server
			while (true) 
			{ 
				System.out.println(dis.readUTF()); 
				String tosend = scn.nextLine(); 
				dos.writeUTF(tosend); 
				
				// If client sends exit,close this connection 
				// and then break from the while loop 
				if(tosend.equals("Exit")) 
				{ 
					System.out.println("Closing this connection : " + s); 
					s.close(); 
					System.out.println("Connection closed"); 
					break; 
				} // End if
				
				// printing date or time as requested by client 
				String received = dis.readUTF(); 
				System.out.println(received); 
			} // End while
			
			// closing resources 
			scn.close(); 
			dis.close(); 
			dos.close(); 
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	/**
	 * Main program..
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException 
	{ 
		
		//String ip = args[0];
		//int port = Integer.parseInt(args[1]);
		int port = 0102;
		String ip = "127.00.1";
		
		SampleClient client = new SampleClient(ip, port);
		
	} // End main
} // End Client Class
