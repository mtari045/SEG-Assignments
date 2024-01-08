package edu.seg2105.edu.server.backend;
// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 


import java.io.IOException;
import edu.seg2105.client.common.ChatIF;
import ocsf.client.AbstractClient;
import ocsf.server.*;

/**
 * This class overrides some of the methods in the abstract 
 * superclass in order to give more functionality to the server.
 *
 * @author Dr Timothy C. Lethbridge
 * @author Dr Robert Lagani&egrave;re
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Paul Holden
 */
public class EchoServer extends AbstractServer  {
  //Class variables *************************************************
  
  /**
   * The default port to listen on.
   */
  final public static int DEFAULT_PORT = 5555;
  
  //Instance variables ***************************************
  /**
   * The interface type variable.  It allows the implementation of 
   * the display method in the client.
   */
  ChatIF serverUI; 
  AbstractClient client;
  
  //Constructors ****************************************************
  
  /**
   * Constructs an instance of the echo server.
   *
   * @param port The port number to connect on.
   */
  
  public EchoServer(int port, ChatIF serverUI)  {
    super(port);
    this.serverUI = serverUI;
  }

  
  //Instance methods ************************************************
  
  /**
   * This method handles any messages received from the client.
   *
   * @param msg The message received from the client.
   * @param client The connection from which the message originated.
   */
  public void handleMessageFromClient (Object msg, ConnectionToClient client) {
	String message = msg.toString();
    System.out.println("received: " + msg + " from " + client.getInfo("loginIDKey"));
    
    if(message.startsWith("#login")) {
		String[] partsOfMessage = message.split(" "); 
		if(client.getInfo("loginIDKey") == null ) { 
			client.setInfo("loginIDKey", partsOfMessage[1]);
			this.serverUI.display(partsOfMessage[1] + " has logged in.");	
		} else if(!client.isAlive()) { //if we need to restart client 
			client.setInfo("loginIDKey", partsOfMessage[1]);
			this.serverUI.display(partsOfMessage[1] + " has logged in.");
		}else { // in case the client is already logged int 
			try {
				client.sendToClient("can't login twice, terminating connection.");
				client.close();
			} catch (IOException e) {
				System.out.println("error closing connection.");
			}
		}		
	 }else {
		 sendToAllClients("from "+ client.getInfo("loginIDKey")+ " > " + msg);
	}
  }
    
 /**
   * This method overrides the one in the superclass.  Called
   * when the server starts listening for connections.
   */
  protected void serverStarted()
  {
    System.out.println
      ("server listening for connections on port " + getPort());
  }
  
  /**
   * This method overrides the one in the superclass.  Called
   * when the server stops listening for connections.
   */
  protected void serverStopped()
  {
    System.out.println
      ("Server has stopped listening for connections.");
  }
  
  
  //Class methods ***************************************************
 
  synchronized protected void clientConnected(ConnectionToClient client) {
	  System.out.println("A client has connected to the server");
  }

  
  synchronized protected void clientDisconnected(ConnectionToClient client) {
	  System.out.println("A client has disconnected to the server. ID: " +  client.getInfo("loginIDKey"));
  }
  synchronized protected void clientException(ConnectionToClient client, Throwable exception) {
	 System.out.println("A client has disconnected to the server. ID: " +  client.getInfo("loginIDKey"));
  }
  
  public void handleMessageFromServerUI(String message)
  {
	  try
	    {
		  // check what the message starts with
	      if(message.startsWith("#")) {
	    	 handleCommand(message);
	      }
	      else {
	    	  // if it's not a command and the client exists, send the message to be processed
	    	  if(this.client != null) {
	    		  client.sendToServer(message);
	    	  }
	    	  // also display in server
	    	  serverUI.display(message);
	      }
	    }
	    catch(IOException e)
	    {
	      serverUI.display
	        ("Could not send message.");
	    }
    
  }
  
  private void handleCommand(String message) {
	  try {
		  // split the message to process 
		  String[] partsOfMessage = message.split(" ");
		  
		  // the first part should be the command
		  String firstPartOfMessage = partsOfMessage[0];
		  
		  // now see what the actual command is 
		  switch (firstPartOfMessage) {
		  	case "#quit": {
		  		// close the server 
		  		System.out.println("terminateing server...");
		  		System.exit(0);
		  		break;
		  	}
		  	case "#stop": {
		  		// if its already stopped i can't do anything 
		  		if(!isListening()) {
		  			System.out.println("can't stop the server, its already terminated");
		  			break;
		  		}
		  		// otherwise its listening so stop it 
		  		stopListening();
		  		break;
		  	}
		  	case "#close": { // stop but don't shut down 
		  		close();
		  		break;
		  	}
		  	case "#setport": {
		  		// has other parameters
		  		setPort(Integer.parseInt(partsOfMessage[1]));
		  		System.out.println("port:" + getPort());
		  		break;
		  	}
		  	case "#start": {
		  		if(!isListening()) {
		  			listen();
		  		} else { // if already listening, we cant start listening again
		  			System.out.println("can't start listening for clients when the server is already listening");
		  		}
		  		break;
		  	}
		  	case "#getport": {
		  		System.out.println(" port: " + getPort());
		  		break;
		  	}
		  	default: {
		  		// unknown command sent, try again
		  		System.out.println("please use a valid command");
		  		break;
		  	}
		}
	  } catch(IOException e) {
		  System.out.println("can't send msg to server");
	  } catch(IndexOutOfBoundsException i) {
		  System.out.println("need to provide required parameters");
	  }
  }
  
}
//End of EchoServer class
