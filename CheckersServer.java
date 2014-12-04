/*
 * server for checkers
 * v 0.1
 */
import java.lang.*;
import java.io.*;
import java.net.*;
import java.util.*;

public class CheckersServer
{
  public static void main(String argv[]) throws Exception
  {
    String clientSentence;
    String capitalizedSentence;
    ServerSocket welcomeSocket = new ServerSocket(6789);

    while(true)
    {
      Socket connectionSocket = welcomeSocket.accept();//accepts connection
      BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));//reads information from client
      DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
      clientSentence = inFromClient.readLine();
      System.out.println("Received: " + clientSentence);//printd
      capitalizedSentence = clientSentence.toUpperCase() + '\n';//makes upper case
      outToClient.writeBytes(capitalizedSentence);//sends information back to client
    }
  }
}