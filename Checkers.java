/*
 * 0 = empty
 * 1 = black
 * 2 = red
 * 3 = black king
 * 4 = red king
 */
//get rid of after game strucure test
import javax.swing.*;
public class Checkers
{
  Board b;
  int x = - 1;
  int y = - 1;
  public Checkers()
  {
    b = new Board();
    //fill with red
    int z = 0;
    for(int row = 0; row < 3; row++)
    {
      for(int col = z; col < 8; col+= 2)
      {
        b.Put(row, col, 2);
      }
      
      if(z == 0)
      {
        z++;
      }else
      {
        z--;
      }
    }//end adding red
    //fill with black
    for(int row = 5; row < 8; row++)
    {
      for(int col = z; col < 8; col+= 2)
      {
        b.Put(row, col, 1);
      }
      
      if(z == 0)
      {
        z++;
      }else
      {
        z--;
      }
    }//end adding black
  }//end cunstructor
  
  public boolean IsValidMove(int row, int col, int newrow, int newcol)
  {
    if(b.GetPiece(row, col) == 0)
    {
      return false;
    }
    if(b.GetPiece(newrow, newcol) != 0)
    {
      return false;
    }
    //check regular for black
    if(b.GetPiece(row, col) == 1)
    {
      if(row - 1 == newrow && col + 1 == newcol)
      {
        return true;
      }
      if(row - 1 == newrow && col - 1 == newcol)
      {  
        return true;
      }
    }//end regular move black
    //check regular move red
    if(b.GetPiece(row, col) == 2)
    {
      if(row + 1 == newrow && col + 1 == newcol)
      {
        return true;
      }
      if(row + 1 == newrow && col - 1 == newcol)
      {  
        return true;
      }
    }//end regular move red
    //check jump black
    if(b.GetPiece(row, col) == 1)
    {
      if(row - 2 == newrow && col + 2 == newcol && b.GetPiece(row - 1, col + 1) == 2 || row - 2 == newrow && col + 2 == newcol && b.GetPiece(row - 1, col + 1) == 4)
      {
        b.Remove(row - 1, col + 1);
        return true;
      }
      if(row - 2 == newrow && col - 2 == newcol && b.GetPiece(row - 1, col - 1) == 2 || row - 2 == newrow && col - 2 == newcol && b.GetPiece(row - 1, col - 1) == 4)
      {  
        b.Remove(row - 1, col - 1);
        return true;
      }
    }//end black jump
    //check red jump
    if(b.GetPiece(row,  col) == 2)
    {
      if(row + 2 == newrow && col + 2 == newcol && b.GetPiece(row + 1, col + 1) == 1 || row - 2 == newrow && col + 2 == newcol && b.GetPiece(row + 1, col + 1) == 1)
      {
        b.Remove(row + 1, col + 1);
        return true;
      }
      if(row + 2 == newrow && col - 2 == newcol && b.GetPiece(row + 1, col - 1) == 1 || row - 2 == newrow && col + 2 == newcol && b.GetPiece(row + 1, col - 1) == 3)
      {  
        b.Remove(row + 1, col - 1);
        return true;
      }
    }//end red jump
    //check black king regular
    if(b.GetPiece(row, col) == 3)
    {
      if(row - 1 == newrow && col + 1 == newcol)
      {
        return true;
      }
      if(row - 1 == newrow && col - 1 == newcol)
      {  
        return true;
      }
      if(row + 1 == newrow && col + 1 == newcol)
      {
        return true;
      }
      if(row + 1 == newrow && col - 1 == newcol)
      {
        return true;
      }
    }//end black king regular move
    //check red king regular
    if(b.GetPiece(row, col) == 4)
    {
      if(row - 1 == newrow && col + 1 == newcol)
      {
        return true;
      }
      if(row - 1 == newrow && col - 1 == newcol)
      {  
        return true;
      }
      if(row + 1 == newrow && col + 1 == newcol)
      {
        return true;
      }
      if(row + 1 == newrow && col - 1 == newcol)
      {
        return true;
      }
    }//end red king regular move
    //black king jump
    if(b.GetPiece(row, col) == 3)
    {
      if(row + 2 == newrow && col + 2 == newcol && b.GetPiece(row + 1, col + 1) == 2 || row + 2 == newrow && col + 2 == newcol && b.GetPiece(row + 1, col + 1) == 4)
      {
        b.Remove(row + 1, col + 1);
        return true;
      }
      if(row + 2 == newrow && col - 2 == newcol && b.GetPiece(row + 1, col - 1) == 2 || row + 2 == newrow && col - 2 == newcol && b.GetPiece(row + 1, col - 1) == 4)
      {  
        b.Remove(row + 1, col - 1);
        return true;
      }
      if(row - 2 == newrow && col + 2 == newcol && b.GetPiece(row - 1, col + 1) == 2 || row - 2 == newrow && col + 2 == newcol && b.GetPiece(row - 1, col + 1) == 4)
      {
        b.Remove(row - 1, col + 1);
        return true;
      }
      if(row - 2 == newrow && col - 2 == newcol && b.GetPiece(row - 1, col - 1) == 2 || row - 2 == newrow && col - 2 == newcol && b.GetPiece(row - 1, col - 1) == 4)
      {  
        b.Remove(row - 1, col - 1);
        return true;
      }
    }//end black king jump
    //check red king jump
    if(b.GetPiece(row, col) == 4)////////////////////////////////add remove
    {
      if(row + 2 == newrow && col + 2 == newcol && b.GetPiece(row + 1, col + 1) == 1 || row + 2 == newrow && col + 2 == newcol && b.GetPiece(row + 1, col + 1) == 3)
      {
        b.Remove(row + 1, col + 1);
        return true;
      }
      if(row + 2 == newrow && col - 2 == newcol && b.GetPiece(row + 1, col - 1) == 1 || row + 2 == newrow && col - 2 == newcol && b.GetPiece(row + 1, col - 1) == 3)
      {  
        b.Remove(row + 1, col - 1);
        return true;
      }
      if(row - 2 == newrow && col + 2 == newcol && b.GetPiece(row - 1, col + 1) == 1 || row - 2 == newrow && col + 2 == newcol && b.GetPiece(row - 1, col + 1) == 3)
      {
        b.Remove(row - 1, col + 1);
        return true;
      }
      if(row - 2 == newrow && col - 2 == newcol && b.GetPiece(row - 1, col - 1) == 1 || row - 2 == newrow && col - 2 == newcol && b.GetPiece(row - 1, col - 1) == 3)
      {  
        b.Remove(row - 1, col - 1);
        return true;
      }
    }//end red king jump
    return false;
  }//end isvalidmove
  
  public boolean MakeMove( int row, int col, int newrow, int newcol)
  {
    if(IsValidMove(row, col, newrow, newcol))
    {
      b.MovePiece(row, col, newrow, newcol);
      return true;
    }
    return false;
  }//end make move
  
  public void KingMe()
  {
    //checks to king black
    for(int col = 0; col < 8; col++)
    {
      if(b.GetPiece(0, col) == 1)
      {
        b.Put(0, col, 3);
      }
    }//end king black
    //checks to king red
    for(int col = 0; col < 8; col++)
    {
      if(b.GetPiece(7, col) == 2)
      {
        b.Put(7, col, 4);
      }
    }//end king red
  }//end kingme
  
  public void PrintBoard()
  {
    b.Print();
    System.out.println();
  }//end print
  
  //creating structure for game later to be put in main or have graphics incorparated
  public void PlayGame()
  {
    String r;
    String c;
    int row;
    int col;
    int newrow;
    int newcol;
    System.out.println("red goes first");
    PrintBoard();
    while(true)
    {
      System.out.println("choose piece");
      r = JOptionPane.showInputDialog("What row?");
      row = Integer.parseInt(r);
      c = JOptionPane.showInputDialog("What col?");
      col = Integer.parseInt(c);
      System.out.println("choose destination");
      r = JOptionPane.showInputDialog("What row?");
      newrow = Integer.parseInt(r);
      c = JOptionPane.showInputDialog("What col?");
      newcol = Integer.parseInt(c);
      MakeMove(row, col, newrow, newcol);
      PrintBoard();
    }
  }
  
  public int GetPiece(int row, int col)
  {
    return b.GetPiece(row, col);
  }
  
  public void HighlightSpace(int xval, int yval)
  {
    x = xval;
    y = yval;
  }
  
  public void ResetHighlight()
  {
    x = -1;
    y = -1;
  }
  
  public boolean GetHighlightedSpace()
  {
    if(x == -1 || y == -1)
    {
      return false;
    }
    return true;
  }
  
  public int GetHRow()
  {
    return x;
  }
  
  public int GetHCol()
  {
    return y;
  }
  
  public static void main(String args[])
  {
    Checkers c = new Checkers();
    c.PrintBoard();
    c.MakeMove(5, 7, 4, 6);
    c.PrintBoard();
    c.MakeMove(4, 6, 3, 5);
    c.PrintBoard();
    c.MakeMove(2, 4, 4, 6);
    c.PrintBoard();
    c.MakeMove(5, 5, 3, 7);
    c.PrintBoard();
    c.MakeMove(3, 0, 4, 1);
    c.PrintBoard();
    /*
    c.PrintBoard();
    c.KingMe();
    c.PrintBoard();*/
    //c.PlayGame();
  }
}//end class
