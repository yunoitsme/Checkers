import java.io.*;
import java.net.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;

public class CServer2
{
  int clickedRow;
  int clickedCol;
  static GBoard g = new GBoard();
  static JFrame frame = new JFrame("Checkers");
  static boolean send = false;
  
  public static void main(String args[]) throws Exception
      {
         
         String boardFromClient;
         String capitalizedSentence;
         
         ServerSocket socket = new ServerSocket(6789);
         Checkers c = g.GetCheckers();
         Board b = c.GetBoard();
         System.out.println(b);
         
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
            frame.repaint();
            if(c.RedTurn == false)
            {
              System.out.println("yay");
              Socket s = socket.accept();
              BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
              DataOutputStream out = new DataOutputStream(s.getOutputStream());
              boardFromClient = in.readLine();
              
              Board hold = DeCodeBoard(boardFromClient);
              out.writeBytes(b.toString() + '\n');
              send = false;
            }
            //Socket s = socket.accept();
            //BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            //DataOutputStream out = new DataOutputStream(s.getOutputStream());
            //boardFromClient = in.readLine();
            
            
            //System.out.println("Received: " + boardFromClient);
            
            
            //Board hold = DeCodeBoard(boardFromClient);
            //out.writeBytes(b.toString() + '\n');
            c.KingMe();
            frame.repaint();
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
  
  public void SetClicked(int row, int col)
  {
    clickedRow = row;
    clickedCol = col;
  }
  
  public static void UpDate()
  {
    frame.repaint();
  }
  
  public static void Send()
  {
    send = true;
  }
}