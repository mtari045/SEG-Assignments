
package edu.seg2105.client.backend;

import ocsf.client.*;

import java.io.*;

import edu.seg2105.client.common.*;

public class ChatClient extends AbstractClient {
  //Instance variables **********************************************
  /**
   * The interface type variable.  It allows the implementation of 
   * the display method in the client.
   */
  ChatIF clientUI; 
  
  /**
   * The String containing the user's login ID. Allows the user to 
   * be identified
   */
  String loginID;

  
  //Constructors ****************************************************
  
  /**
   * Constructs an instance of the chat client.
   *
   * @param host The server to connect to.
   * @param port The port number to connect on.
   * @param clientUI The interface type variable.
   */
  
  public ChatClient(String loginID, String host, int port, ChatIF clientUI) 
    throws IOException 
  {
    super(host, port); //Call the superclass constructor
    this.clientUI = clientUI;
    this.loginID = loginID;
  
    openConnection();
  }
  
  //Instance methods ************************************************
    

  public void handleMessageFromServer(Object msg)  {
    clientUI.display(msg.toString());
  }

  
  public void handleMessageFromClientUI(String message)
  {
    try {
     if(message.startsWith("#")) {
    	 handleCommandFromClientUI(message);
      }
      else {
    	  sendToServer(message);
      }
    }
    catch(IOException e)
    {
      clientUI.display
        ("can't send message, shutting down");
      quit();
    }
  }
  
  
  // method called in handle message from ui to process # commands from client
  private void handleCommandFromClientUI(String message) {
	  try {  // need to split the message to process the command asked for 
		  String[] partsOfMessage = message.split(" ");
		  // check this first part against possible commands
		  switch (partsOfMessage[0]) {
		  	case "#quit": { // close the client 
		  		System.out.println("shutting down chat");
		  		quit();
		  		break;
		  	}
		  	case "#logoff": {
		  		//if they're not connected there is nothing to log off from
		  		if(!isConnected()) {
		  			System.out.println("no connection to close");
		  		} else {
		  			// otherwise terminate the connection
		  			closeConnection();
		  			while(isConnected()) { // do nothting ig? 
		  			}
		  			//inform the user they are no longer connected
		  			if(!isConnected()) {
		  				System.out.println("disconnected from the server");
		  			}
		  		}
		  		break;
		  	}
		  	case "#sethost": {
		  		// has other parameters
		  		if(isConnected()) {
		  			System.out.println("can't set host while iss connected");
		  		} else {
		  			// change the host the client wants to connect to
		  			setHost(partsOfMessage[1]);
		  		}
		  		break;
		  	}
		  	case "#setport": {
		  		// has other parameters
		  		if(isConnected()) {
		  			System.out.println("cant set port whille connected.");
		  		} else {
		  			setPort(Integer.parseInt(partsOfMessage[1]));
		  		}
		  		break; 
		  	}
		  	
		  	case "#login": {
		  		if(!isConnected()) {
		  			//open the connection, since #login is handled by the server
		  			openConnection();
		  			// if connection happens tell them 
			  		System.out.println("connected to server");	
		  		} else {
		  			System.out.println("cant login while connected.");
		  			quit(); // exit since they tried to login again
		  		}
		  		break;
		  	}
		  	case "#gethost": {
		  		// print the host name
		  		System.out.println("host: " + getHost());
		  		break;
		  	}
		  	case "#getport": {
		  		// print the port number
		  		System.out.println("port: " +getPort());
		  		break;
		  	}
		  	default: {
		  		System.out.println("invalid command, try again");
		  		break;
		  	}
		}
	  } catch(IOException e) {
		  System.out.println("can't send message to server, closing connection");
		  quit();
	  } catch(IndexOutOfBoundsException i) {
		  System.out.println("pls provide proper parameters");
	  }
  }
  
    // closes connection/terminates teh client 
  public void quit()
  {
    try
    {
      closeConnection();
    }
    catch(IOException e) {}
    System.exit(0);
  }
  
	protected void connectionClosed() {
		clientUI.display("connection has been closed.");
	}
  

  	@Override
	protected void connectionException(Exception exception) {	
  		clientUI.display("connection has been shut down.");
  		quit();
	}
  	
 
	protected void connectionEstablished(){
	    // sending "#login " + loginID to the server
		System.out.println("connected, now logging in"); 
		try {
			sendToServer("#login " + loginID);
		} catch (IOException e) { // idk just incase theres an error or something
			System.out.println("rrror while logging in, ending client...");
			quit();
		}
		System.out.println("welcome, " + loginID);
		 // welcoming once connection is established properly
	}
}
//End of ChatClient class
