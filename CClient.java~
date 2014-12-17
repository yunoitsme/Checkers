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
    JOptionPane.showMessageDialog(null, answer);
    System.exit(0);
  }
}