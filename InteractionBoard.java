/*
 * 0 = no highlight
 * 1 = start = yellow
 * 2 = piece = green
 * 3 = path = gray
 * 4 = toberemoved = orange
 * 
 * get number of highleghted spaces function NO
 * get highleghted location #... function NO
 * have a manage interactionboard function in checkers or here 
 * have a similar switch statement to the drawing the of the  pieces
 * have this class manage the highlight not checkers class
 * get highlight id function
 */
public class InteractionBoard extends Board
{
  Location piece;
  Location start;
  Location[] path = new Location[10];
  Location[] toBeRemoved = new Location[10];
  int pathLength = 0;
  int toBeRemovedLength = 0;
  
  public void SetPiece(Location loc)
  {
    piece = loc;
    Put(loc.GetRow(), loc.GetCol(), 2);
  }
  
  public Location GetPiece()
  {
    return piece;
  }
  
  public void SetStart(Location loc)
  {
    start = loc;
    Put(loc.GetRow(), loc.GetCol(), 1);
  }
  
  public Location GetStart()
  {
    return start;
  }
  
  public void AddRemoved(Location loc)
  {
    toBeRemoved[toBeRemovedLength] = loc;
    toBeRemovedLength++;
    Put(loc.GetRow(), loc.GetCol(), 4);
  }
  
  public Location[] GetRemoved()
  {
    return toBeRemoved;
  }
  
  public void AddPath(Location loc)
  {
    path[pathLength] = loc;
    pathLength++;
    Put(loc.GetRow(), loc.GetCol(), 3);
  }
  
  public Location[] GetPath()
  {
    return path;
  }
  
  public int GetHighlightID(Location loc)
  {
    return GetPiece(loc.GetRow(), loc.GetCol());
  }
  
  public void ResetInteraction()
  {
    start = null;
    piece = null;
    path = new Location[10];
    toBeRemoved = new Location[10];
    toBeRemovedLength = 0;
    pathLength = 0;
  }
}










