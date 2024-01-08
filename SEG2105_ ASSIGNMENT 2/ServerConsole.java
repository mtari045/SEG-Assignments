package edu.seg2105.client.ui;

import java.util.Scanner;

import edu.seg2105.client.common.ChatIF;

import edu.seg2105.edu.server.backend.EchoServer;

public class ServerConsole implements ChatIF {
		//default port 
	  final public static int DEFAULT_PORT = 5555;
		//instance of server 
	  EchoServer echoServer;
	    //scanner for input 
	  Scanner fromConsole; 
	    	//poort number 
	  public static int port;
	  
	//Constructors ****************************************************

	  public ServerConsole(int port) {
		 // server
	    echoServer = new EchoServer(port, this);
	    //  scanner object to read 
	    fromConsole = new Scanner(System.in); 
	  }
	  
	//Instance methods ************************************************
	  
	  // if input is received from console send it to handler to process the command
	  public void lookForInput()  { 
	    try {
	      String message;
	      while (true) {
	        message = fromConsole.nextLine();
	        echoServer.handleMessageFromServerUI(message);
	      }
	    } 
	    catch (Exception ex) {
	      System.out.println ("error while reading from console");
	    }
	  }

	  /**
	   * This method overrides the method in the ChatIF interface.  It
	   * displays a message onto the screen.
	   *
	   * @param message The string to be displayed.
	   */
	  public void display(String message)  {
		  // display to server +  all clients
	    System.out.println("> SERVER MSG > " + message);
	    echoServer.sendToAllClients("SERVER MSG > " + message);
	  } 
	  
	  public static void main(String[] args) {
	    int port = 0; 
	    try {
	     // grab the port from input, otherwise set to default 
	      port = Integer.parseInt(args[0]); 
	    }
	    catch(Throwable t) {
	      port = DEFAULT_PORT; //Set port to 5555
	    }
		
	    ServerConsole servercon = new ServerConsole(port); 
	    try  {
	      servercon.echoServer.listen(); // listening for connections
	    } 
	    catch (Exception ex)  {
	      System.out.println("error, can't listen for clients");
	    }
	    
	    servercon.lookForInput();

	  }
}
