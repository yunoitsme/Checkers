import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
/*
 * instead of (row, col)
 * (col, row)
 */
public class GBoard extends JPanel
{
  Checkers c = new Checkers();
  static final int Dimensions = 800;
  static final int Xmax = Dimensions + 1;
  static final int Ymax = Dimensions + 23;
  int space = Dimensions / 8;
  static int Row = -1;
  static int Col = -1;
  public void paint(Graphics g)
  {
    Graphics2D b = (Graphics2D) g;
    
    //draw lines to separate board
    for(int n = 0; n < 9; n++)
    {
      int x = (Dimensions / 8) * n;
      b.drawLine(x, 0, x, Dimensions);
    }
    for(int n = 0; n < 9; n++)
    {
      int y = (Dimensions / 8) * n;
      b.drawLine(0, y, Dimensions, y);
    }
    
    //highlight selected piece
    if(Col != -1 || Row != -1)
    {
      b.setColor(Color.yellow);
      b.fillRect(Col * space, Row * space, (Col + 1 * space) - Col, (Row + 1 * space) - Row);
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
            b.fillOval(col * space, row * space, (col + 1 * space) - col, (row + 1 * space) - row);
            break;
            
          case 2:
            b.setColor(Color.RED);
            //b.fillOval();
            b.fillOval(col * space, row * space, (col + 1 * space) - col, (row + 1 * space) - row);
            break;
            
          case 3:
            b.setColor(Color.BLACK);
            //b.drawOval();
            b.drawOval(col * space, row * space, (col + 1 * space) - col, (row + 1 * space) - row);
            break;
            
          case 4:
            b.setColor(Color.RED);
            //b.fillOval();
            b.drawOval(col * space, row * space, (col + 1 * space) - col, (row + 1 * space) - row);
            break;
          
          default:
            break;
        }//end switch
      }
    }
  }
  
  public static void SetRow(int row)
  {
    Row = row;
  }
  
  public static void SetCol(int col)
  {
    Col = col;
  }
  
  public static void main(String[] args) 
  {
    JFrame frame = new JFrame("Checkers");
    frame.add(new GBoard());
    frame.setSize(Xmax, Ymax);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.addMouseListener(new MouseAdapter()
    {
      public void mousePressed(MouseEvent e)
      {
        System.out.println(e.getPoint());
        Row = e.getX();
        Col = e.getY();
      }
    }
    );
    System.out.println(Row);
    frame.repaint();
  }
}


