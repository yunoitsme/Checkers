/*
 * for the first click start and piece will be the same then piece will move away
 */
public class Checkers3
{
  Board b;
  boolean RedTurn = true;
  InteractionBoard ib = new InteractionBoard();
  
  //cunstructors
  public Checkers3()
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
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  //listner interaction 
  public void Click(Location loc)
  {
    if(ib.GetStart() == null)
    {
      ib.SetPiece(loc);
      ib.SetStart(loc);
    }else
    {
      if(IsBasicMove(loc))
      {
        if(loc.equals(ib.GetPiece()))
        {
          MakeMove(loc);
        }else
        {
          ib.SetPiece(loc);
          Move(loc);
        }
        //ib.SetPiece(loc);
       // Move(loc);
        //MakeMove(loc);
        //ib.ResetInteraction();
      }
      if(loc.equals(ib.GetPiece()))
        {
          MakeMove(loc);
        }
      if(IsValidMove(loc))
      {
        if(ib.GetPiece().equals(ib.GetStart()))
        {
          ib.AddRemoved(FindJumpedPiece(ib.GetPiece(), loc));
          ib.SetPiece(loc);
        }else
        {
          ib.AddRemoved(FindJumpedPiece(ib.GetPiece(), loc));
          ib.SetPiece(loc);
          ib.AddPath(ib.GetPiece());
        }
        
      }
    }
    //ib.ResetInteraction();
  }
  
  public void ClearIB()
  {
    ib.ResetInteraction();
  }
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  //game control methods
  public boolean IsValidMove(Location newloc)//ad kings later
  {
    if(b.GetPiece(ib.GetPiece().GetRow(), ib.GetPiece().GetCol()) == 0)
    {
      return false;
    }
    if(b.GetPiece(newloc.GetRow(), newloc.GetCol()) != 0)
    {
      return false;
    }
    //check jump black
    if(b.GetPiece(ib.GetPiece().GetRow(), ib.GetPiece().GetCol()) == 1)
    {
      if(ib.GetPiece().GetRow() - 2 == newloc.GetRow() && ib.GetPiece().GetCol() + 2 == newloc.GetCol() && b.GetPiece(ib.GetPiece().GetRow() - 1, ib.GetPiece().GetCol() + 1) == 2 || 
         ib.GetPiece().GetRow() - 2 == newloc.GetRow() && ib.GetPiece().GetCol() + 2 == newloc.GetCol() && b.GetPiece(ib.GetPiece().GetRow() - 1, ib.GetPiece().GetCol() + 1) == 4)
      {
        //b.Remove(piece.GetRow() - 1, piece.GetCol() + 1);
        return true;
      }
      if(ib.GetPiece().GetRow() - 2 == newloc.GetRow() && ib.GetPiece().GetCol() - 2 == newloc.GetCol() && b.GetPiece(ib.GetPiece().GetRow() - 1, ib.GetPiece().GetCol() - 1) == 2 || 
         ib.GetPiece().GetRow() - 2 == newloc.GetRow() && ib.GetPiece().GetCol() - 2 == newloc.GetCol() && b.GetPiece(ib.GetPiece().GetRow() - 1, ib.GetPiece().GetCol() - 1) == 4)
      {  
        //b.Remove(piece.GetRow() - 1, piece.GetCol() - 1);
        return true;
      }
    }//end black jump
    //check red jump
    if(b.GetPiece(ib.GetPiece().GetRow(),  ib.GetPiece().GetCol()) == 2)
    {
      if(ib.GetPiece().GetRow() + 2 == newloc.GetRow() && ib.GetPiece().GetCol() + 2 == newloc.GetCol() && b.GetPiece(ib.GetPiece().GetRow() + 1, ib.GetPiece().GetCol() + 1) == 1 || 
         ib.GetPiece().GetRow() - 2 == newloc.GetRow() && ib.GetPiece().GetCol() + 2 == newloc.GetCol() && b.GetPiece(ib.GetPiece().GetRow() + 1, ib.GetPiece().GetCol() + 1) == 3)
      {
        //b.Remove(piece.GetRow() + 1, piece.GetCol() + 1);
        return true;
      }
      if(ib.GetPiece().GetRow() + 2 == newloc.GetRow() && ib.GetPiece().GetCol() - 2 == newloc.GetCol() && b.GetPiece(ib.GetPiece().GetRow() + 1, ib.GetPiece().GetCol() - 1) == 1 || 
         ib.GetPiece().GetRow() - 2 == newloc.GetRow() && ib.GetPiece().GetCol() + 2 == newloc.GetCol() && b.GetPiece(ib.GetPiece().GetRow() + 1, ib.GetPiece().GetCol() - 1) == 3)
      {  
        //b.Remove(piece.GetRow() + 1, piece.GetCol() - 1);
        return true;
      }
    }//end red jump
    return false;
  }
  
  public boolean IsBasicMove(Location newloc)
  {
    if(b.GetPiece(ib.GetPiece().GetRow(), ib.GetPiece().GetCol()) == 0)
    {
      return false;
    }
    if(b.GetPiece(newloc.GetRow(), newloc.GetCol()) != 0)
    {
      return false;
    }
    //check regular for black
    if(b.GetPiece(ib.GetPiece().GetRow(), ib.GetPiece().GetCol()) == 1)
    {
      if(ib.GetPiece().GetRow() - 1 == newloc.GetRow() && ib.GetPiece().GetCol() + 1 == newloc.GetCol())
      {
        return true;
      }
      if(ib.GetPiece().GetRow() - 1 == newloc.GetRow() && ib.GetPiece().GetCol() - 1 == newloc.GetCol())
      {  
        return true;
      }
    }//end regular move black
    //check regular move red
    if(b.GetPiece(ib.GetPiece().GetRow(), ib.GetPiece().GetCol()) == 2)
    {
      if(ib.GetPiece().GetRow() + 1 == newloc.GetRow() && ib.GetPiece().GetCol() + 1 == newloc.GetCol())
      {
        return true;
      }
      if(ib.GetPiece().GetRow() + 1 == newloc.GetRow() && ib.GetPiece().GetCol() - 1 == newloc.GetCol())
      {  
        return true;
      }
    }//end regular move red
    //check black king regular
    if(b.GetPiece(ib.GetPiece().GetRow(), ib.GetPiece().GetCol()) == 3)
    {
      if(ib.GetPiece().GetRow() - 1 == newloc.GetRow() && ib.GetPiece().GetCol() + 1 == newloc.GetCol())
      {
        return true;
      }
      if(ib.GetPiece().GetRow() - 1 == newloc.GetRow() && ib.GetPiece().GetCol() - 1 == newloc.GetCol())
      {  
        return true;
      }
      if(ib.GetPiece().GetRow() + 1 == newloc.GetRow() && ib.GetPiece().GetCol() + 1 == newloc.GetCol())
      {
        return true;
      }
      if(ib.GetPiece().GetRow() + 1 == newloc.GetRow() && ib.GetPiece().GetCol() - 1 == newloc.GetCol())
      {
        return true;
      }
    }//end black king regular move
    //check red king regular
    if(b.GetPiece(ib.GetPiece().GetRow(), ib.GetPiece().GetCol()) == 4)
    {
      if(ib.GetPiece().GetRow() - 1 == newloc.GetRow() && ib.GetPiece().GetCol() + 1 == newloc.GetCol())
      {
        return true;
      }
      if(ib.GetPiece().GetRow() - 1 == newloc.GetRow() && ib.GetPiece().GetCol() - 1 == newloc.GetCol())
      {  
        return true;
      }
      if(ib.GetPiece().GetRow() + 1 == newloc.GetRow() && ib.GetPiece().GetCol() + 1 == newloc.GetCol())
      {
        return true;
      }
      if(ib.GetPiece().GetRow() + 1 == newloc.GetRow() && ib.GetPiece().GetCol() - 1 == newloc.GetCol())
      {
        return true;
      }
    }//end red king regular move
    return false;
  }
  
  public Location FindJumpedPiece(Location loc, Location newloc)
  {
    Location jPiece = new Location();
    if(newloc.GetRow() > loc.GetRow())
    {
      if(newloc.GetCol() > loc.GetCol())
      {
        jPiece = new Location(newloc.GetRow() - 1, newloc.GetCol() - 1);
      }else
      {
        jPiece = new Location(newloc.GetRow() - 1, newloc.GetCol() + 1);
      }
    }else
    {
      if(newloc.GetCol() > loc.GetCol())
      {
        jPiece = new Location(newloc.GetRow() + 1, newloc.GetCol() - 1);
      }else
      {
        jPiece = new Location(newloc.GetRow() + 1, newloc.GetCol() + 1);
      }
    }
    return jPiece;
  }
  
  public void Move(Location loc)
  {
    if(IsBasicMove(loc) == false)///////////need to look at this
    {
      MakeMove(loc);
    }else
    {
      Location jumped;
      jumped = FindJumpedPiece(ib.GetPiece(), loc);
      ib.AddPath(ib.GetPiece());
      ib.AddRemoved(jumped);
      ib.SetPiece(loc);
      //ib.ResetInteraction();
    }
  }
  
  public void MakeMove(Location loc)//ad for jumps later
  {
    /*
    int id;
    id = b.GetPiece(ib.GetStart().GetRow(), ib.GetStart().GetCol());
    b.Remove(ib.GetStart().GetRow(), ib.GetStart().GetCol());
    b.Put(ib.GetPiece().GetRow(), ib.GetPiece().GetCol(), id);
    */
    //b.Remove(ib.GetStart().GetRow(), ib.GetStart().GetCol());
    //b.Put(ib.GetPiece().GetRow(), ib.GetPiece().GetCol(), b.GetPiece(ib.GetStart().GetRow(), ib.GetStart().GetCol()));
    b.MovePiece(ib.GetStart().GetRow(), ib.GetStart().GetCol(), ib.GetPiece().GetRow(), ib.GetPiece().GetCol());
    ib.ResetInteraction();
  }
  
  public void DontMakeMove()
  {
    
  }
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  //methods that return info
  public int GetPiece(Location loc)
  {
    return b.GetPiece(loc.GetRow(), loc.GetCol());
  }
  
  public int GetHighlightID(Location loc)
  {
    return ib.GetHighlightID(loc);
  }
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  //test methods
  public void Highlight()
  {
    ib.SetStart(new Location(0,0));
    ib.SetPiece(new Location(1,1));
    ib.AddPath(new Location(2,2));
    ib.AddRemoved(new Location(2,4));
  }
  
  public static void main(String args[])
  {
    
  }
}










