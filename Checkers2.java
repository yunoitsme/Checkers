//v1.0.0
/*
 * 
 */
public class Checkers2
{
  Board b;
  boolean RedTurn = true;
  Location[] toBeRemoved = new Location[10]; //red
  Location[] path = new Location[10];//gray
  Location start;// yellow
  Location piece;// green
  
  public Checkers2()
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
  }
  
  public Checkers2(Board board)
  {
    b = board;
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
  }
  
  public boolean IsValidMove(Location loc, Location newloc)
  {
    
  }
  
  public boolean MakeMove(Location loc, Location newloc)
  {
    
  }
  
  public void Move(Location loc, Location newloc)
  {
    
  }
  
  public void RemovePieces()
  {
    for(int x = 0; x < toBeRemoved.length - 1; x++)
    {
      b.Remove(toBeRemoved[x].GetRow(), toBeRemoved[x].GetCol());
    }
    toBeRemoved = new Location[10];
  }
  
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
  }
  
  public int GetPiece(Location loc)
  {
    return b.GetPiece(loc.GetRow(), loc.GetCol());
  }
  
  public boolean GameOver()
  {
    if(NoBlack() || NoRed())
    {
      return true;
    }
    return false;
  }
  
  public boolean RedWon()
  {
    if(NoRed())
    {
      return false;
    }
    return true;
  }
  
  public boolean NoRed()
  {
    for(int row = 0; row < 8; row++)
    {
      for(int col = 0; col < 8; col++)
      {
        if(b.GetPiece(row, col) == 2 || b.GetPiece(row, col) == 4)
        {
          return false;
        }
      }
    }
    return true;
  }
  
  public boolean NoBlack()
  {
    for(int row = 0; row < 8; row++)
    {
      for(int col = 0; col < 8; col++)
      {
        if(b.GetPiece(row, col) == 1 || b.GetPiece(row, col) == 3)
        {
          return false;
        }
      }
    }
    return true;
  }
  
  public void Click()
  {
    
  }
}





















