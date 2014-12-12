public class Location
{
  int row;
  int col;
  public Location()
  {
    row = -1;
    col = -1;
  }
  
  public Location(int r, int c)
  {
    row = r;
    col = c;
  }
  
  public int GetRow()
  {
    return row;
  }
  
  public int GetCol()
  {
    return col;
  }
  
  public boolean Equals(Location loc)
  {
    if(row == loc.GetRow() && col == loc.GetCol())
    {
      return true;
    }
    return false;
  }
  
  public void Print()
  {
    System.out.println("(" + row + ", " + col + ")");
  }
}