
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









