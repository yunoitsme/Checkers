import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CClient2
{
  int clickedRow;
  int clickedCol;
  static GBoard g = new GBoard();
  static JFrame frame = new JFrame("Checkers");
  static boolean send = false;
  
  public static void main(String argv[]) throws Exception
 {
  String sentence;
  String boardFromServer;
  Board b = new Board();
  b.FillBoard();
  
  frame.add(g);
         frame.setSize(801, 823);
         frame.setVisible(true);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.addMouseListener(new MouseAdapter()
    {
      public void mousePressed(MouseEvent e)
      {
        int col;
        int row;
        if(g.GetCheckers().GameOver())
        {
          if(e.getX() < 400 && e.getY() > 600)
          {
            g.NewCheckers();
          }else
          {
            System.exit(0);
          }
        }else
        {
          System.out.println(e.getPoint());
          col = (e.getX() / 10) / 10;
          row = ((e.getY() / 10) - 2) / 10;
          g.GetCheckers().Click(row, col);
          //System.out.println(row);
          //System.out.println(col);
        }
      }
    }
    );
  
  while(true)
  {
    
    /*
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
    */
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