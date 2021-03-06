//client could only send valid moves????
//one bite every piece after indicatiing intager
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import javax.swing.JOptionPane;
import java.io.*;
import java.net.*;

public class CClient
{
  public static void main(String args[]) throws IOException
  {
    Board b = new Board();
    b.FillBoard();
    
    String ip = JOptionPane.showInputDialog("Enter IP Address of a machine that is\n" + "running on port 9090:");
    Socket s = new Socket(ip, 9091);
    DataOutputStream output = new DataOutputStream(s.getOutputStream());
    BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
    
    output.writeBytes(b.toString() + '\n');
    String answer = input.readLine();
    
    JOptionPane.showMessageDialog(null, b);
    b = DeCodeBoard(answer);
    JOptionPane.showMessageDialog(null, b.Print());
    System.out.println(answer);
    System.exit(0);
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