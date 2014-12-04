import java.io.*;
import java.net.*;

public class CheckersClient
{
  public static void main(String argv[]) throws Exception
  {
    while(true)
    {
      String sentence;
      String modifiedSentence;
      BufferedReader inFromUser = new BufferedReader( new InputStreamReader(System.in));//takes creatse means of taking string from user
      Socket clientSocket = new Socket("localhost", 6789);//establishes connection to ip/port
      DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());//creates way of sending info
      BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
      sentence = inFromUser.readLine();
      outToServer.writeBytes(sentence + '\n'); //sends string to the server
      modifiedSentence = inFromServer.readLine();//gets information from the server.
      System.out.println("FROM SERVER: " + modifiedSentence);//prints info
    }
    /*
    String sentence;
    String modifiedSentence;
    BufferedReader inFromUser = new BufferedReader( new InputStreamReader(System.in));
    Socket clientSocket = new Socket("localhost", 6789);
    DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
    BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    sentence = inFromUser.readLine();
    outToServer.writeBytes(sentence + '\n');
    modifiedSentence = inFromServer.readLine();
    System.out.println("FROM SERVER: " + modifiedSentence);
    clientSocket.close();
    */
  }
}