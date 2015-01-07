//remove col amd row from sting that is sent between them
//have the program display ur ip for easy use
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.io.*;
import java.net.*;

public class CServer
{
  public static void main(String args[]) throws IOException
  {
    ServerSocket socket = new ServerSocket(9091);
    int x = 1;
    Checkers2 c = new Checkers2();
    Board b = c.GetBoard();
    System.out.println(b);
    String fromClient = "";
    
    while(true)
    {
      Socket s = socket.accept();
      BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
      fromClient = in.readLine();
      System.out.println(fromClient);
      PrintWriter out = new PrintWriter(s.getOutputStream(), true);
      out.println(b);
    }
    
    /*
    try
    {
      while(true)
      {
        Socket s = socket.accept();
        try
        {
          BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
          fromClient = in.readLine();
          System.out.println(fromClient);
          PrintWriter out = new PrintWriter(s.getOutputStream(), true);
          out.println(b);
          
        }finally
        {
          s.close();
        }
        x++;
      }
    }finally
    {
      socket.close();
    }
    */
  }//end main
}//end class