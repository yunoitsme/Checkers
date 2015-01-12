import java.io.*;
import java.net.*;
import javax.swing.*;

public class CClient2
{
  public static void main(String argv[]) throws Exception
 {
  String sentence;
  String boardFromServer;
  Board b = new Board();
  b.FillBoard();
  
  
  while(true)
  {
    Socket socket = new Socket("localhost", 6789);
    DataOutputStream out = new DataOutputStream(socket.getOutputStream());
    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    String s = JOptionPane.showInputDialog("would you like to stop server");
    if(s.equals("yes"))
    {
      JOptionPane.showMessageDialog(null, "Client stopped");
      socket.close();
      break;
    }
    out.writeBytes(b.toString() + '\n');
    boardFromServer = in.readLine();
    b = DeCodeBoard(boardFromServer);
    JOptionPane.showMessageDialog(null, "FROM SERVER: " + b);
    socket.close();
  }
 }
  
  public static Board DeCodeBoard(String s)
  {
    int z = 0;
    Board b = new Board();
    for(int x = 0; x < 8; x++)
    {
      for(int y = 0; y < 8; y++)
      {
        b.Put(x, y, Integer.parseInt(s.charAt(z) + ""));
        z++;
      }
    }
    return b;
  }
}