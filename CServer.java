import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class CServer
{
  public static void main(String args[]) throws IOException
  {
    ServerSocket socket = new ServerSocket(9090);
    int x = 1;
    
    try
    {
      while(true)
      {
        Socket s = socket.accept();
        try
        {
          PrintWriter out = new PrintWriter(s.getOutputStream(), true);
          out.println(/*new Date().toString()*/"connections: "+ x);
          
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
  }
}