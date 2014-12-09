/*
 * server for checkers
 * v 1.6.0
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
    String bString;
    Board b = new Board();
    Checkers c = new Checkers(b);
    ServerSocket welcomeSocket = new ServerSocket(/*6789*/6790);

    while(true)
    {
      Socket connectionSocket = welcomeSocket.accept();
      BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
      DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
      clientSentence = inFromClient.readLine();
      System.out.println("Received: " + clientSentence);
      bString = CreateBoardString(b);
      capitalizedSentence = clientSentence.toUpperCase() + '\n';
      capitalizedSentence = capitalizedSentence + bString;
      outToClient.writeBytes(capitalizedSentence + " " + bString);
    }
  }
  public static String CreateBoardString(Board board)
  {
    String boardString = "0";
    
    for(int row = 0; row < 8; row++)
    {
      for(int col = 0; col < 8; col++)
      {
        boardString = boardString + row + col + board.GetPiece(row, col);
      }
    }
    return boardString;
  }//end createboardstring
}