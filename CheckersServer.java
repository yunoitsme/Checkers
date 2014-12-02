/*
 * server for checkers
 * v 0.1
 */
import java.lang.*;
import java.io.*;
import java.net.*;
import java.util.*;

public class CheckersServer extends Thread
{
  private ServerSocket s;
  
  public CheckersServer() throws IOException
  {
    s = new ServerSocket(50000);
  }
  
  public void run()
  {
    while(true)
    {
      try
      {
        
      }
      catch(IOException e)
      {
        System.out.println(e.getMessage());
      }
    }
  }
  
}