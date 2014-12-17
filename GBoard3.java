import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;

public class GBoard3 extends JPanel
{
  //will change to incorparate screen size and prefered screen size
  Font red = new Font("SansSerif", Font.BOLD, 80);
  static Checkers3 c = new Checkers3();
  static final int Dimensions = 800;
  static final int Xmax = Dimensions + 1;
  static final int Ymax = Dimensions + 23;
  int space = Dimensions / 8;
  
  public void paint(Graphics g)
  { 
    //draw highlights
    //c.Highlight();
    for(int row = 0; row < 8; row++)
    {
      for(int col = 0; col < 8; col++)
      {
        Location loc = new Location(row, col);
        switch (c.GetHighlightID(loc))
        {
          case 0:
            break;
            
          case 1:
            g.setColor(Color.yellow);
            //b.fillOval(row * (Xmax / 8), col * (Xmax / 8), (row + 1) * (Xmax / 8), (col + 1) * (Xmax / 8));
            g.fillRect(col * space, row * space, (col + 1 * space) - col, (row + 1 * space) - row);
            break;
            
          case 2:
            g.setColor(Color.green);
            //b.fillOval();
            g.fillRect(col * space, row * space, (col + 1 * space) - col, (row + 1 * space) - row);
            break;
            
          case 3:
            g.setColor(Color.orange);
            //b.drawOval();
            g.fillRect(col * space, row * space, (col + 1 * space) - col, (row + 1 * space) - row);
            break;
            
          case 4:
            g.setColor(Color.gray);
            //b.fillOval();
            g.fillRect(col * space, row * space, (col + 1 * space) - col, (row + 1 * space) - row);
            break;
          
          default:
            break;
        }//end switch
      }
    }//end outer for
    
    //draws pieces
    for(int row = 0; row < 8; row++)
    {
      for(int col = 0; col < 8; col++)
      {
        Location loc = new Location(row, col);
        switch (c.GetPiece(loc))
        {
          case 0:
            break;
            
          case 1:
            g.setColor(Color.BLACK);
            //b.fillOval(row * (Xmax / 8), col * (Xmax / 8), (row + 1) * (Xmax / 8), (col + 1) * (Xmax / 8));
            g.fillOval(col * space, row * space, (col + 1 * space) - col, (row + 1 * space) - row);
            break;
            
          case 2:
            g.setColor(Color.RED);
            //b.fillOval();
            g.fillOval(col * space, row * space, (col + 1 * space) - col, (row + 1 * space) - row);
            break;
            
          case 3:
            g.setColor(Color.BLACK);
            //b.drawOval();
            g.drawOval(col * space, row * space, (col + 1 * space) - col, (row + 1 * space) - row);
            break;
            
          case 4:
            g.setColor(Color.RED);
            //b.fillOval();
            g.drawOval(col * space, row * space, (col + 1 * space) - col, (row + 1 * space) - row);
            break;
          
          default:
            break;
        }//end switch
      }
    }//end outer for
    
    //draw lines to separate board
    for(int n = 0; n < 9; n++)
    {
      int x = (Dimensions / 8) * n;
      g.drawLine(x, 0, x, Dimensions);
    }
    for(int n = 0; n < 9; n++)
    {
      int y = (Dimensions / 8) * n;
      g.drawLine(0, y, Dimensions, y);
    }
  }
  
  public static void main(String args[])
  {
    JFrame frame = new JFrame("Checkers");
    frame.add(new GBoard3());
    frame.setSize(Xmax, Ymax);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}