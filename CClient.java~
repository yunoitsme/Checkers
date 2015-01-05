//client could only send valid moves????
//one bite every piece after indicatiing intager
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import javax.swing.JOptionPane;

public class CClient
{
  public static void main(String args[]) throws IOException
  {
    String ip = JOptionPane.showInputDialog("Enter IP Address of a machine that is\n" + "running on port 9090:");
    Socket s = new Socket(ip, 9090);
    BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
    String answer = input.readLine();
    Board b = DeCodeBoard(answer);
    JOptionPane.showMessageDialog(null, answer);
    System.exit(0);
  }
  
  public static Board DeCodeBoard(String s)
  {
    Board b = new Board();
    if(s.charAt(0) == 0)
    {
      for(int x = 1; x < s.length(); x+= 3)
      {
        b.Put(s.charAt(x), s.charAt(x+1), s.charAt(x));
      }
    }
    return b;
  }
}