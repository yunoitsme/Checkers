import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GBoard extends JPanel
{
  Checkers c = new Checkers();
  static final int Xmax = 720;
  static final int Ymax = 720;
  int space = 90;
  public void paint(Graphics g) 
  {
    Graphics2D b = (Graphics2D) g;
    
    //draw lines to separate board
    for(int n = 0; n < 8; n++)
    {
      int x = (Xmax / 8) * n;
      b.drawLine(x, 0, x, Ymax);
    }
    for(int n = 0; n < 8; n++)
    {
      int y = (Ymax / 8) * n;
      b.drawLine(0, y, Xmax, y);
    }
    
    //draws pieces
    for(int row = 0; row < 8; row++)
    {
      for(int col = 0; col < 8; col++)
      {
        switch (c.GetPiece(row, col))
        {
          case 0:
            break;
            
          case 1:
            b.setColor(Color.BLACK);
            //b.fillOval(row * (Xmax / 8), col * (Xmax / 8), (row + 1) * (Xmax / 8), (col + 1) * (Xmax / 8));
            b.fillOval(col * space, row * space, col + 1 * space, row + 1 * space);
            break;
            
          case 2:
            b.setColor(Color.RED);
            //b.fillOval();
            b.fillOval(col * space, row * space, col + 1 * space, row + 1 * space);
            break;
            
          case 3:
            b.setColor(Color.BLACK);
            //b.drawOval();
            b.drawOval(col * space, row * space, col + 1 * space, row + 1 * space);
            break;
            
          case 4:
            b.setColor(Color.RED);
            //b.fillOval();
            b.drawOval(col * space, row * space, col + 1 * space, row + 1 * space);
            break;
          
          default:
            break;
        }//end switch//
      }
    }
  }
  
  public static void main(String[] args) 
  {
    JFrame frame = new JFrame("Checkers");
    frame.add(new GBoard());
    frame.setSize(Xmax, Ymax);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}


