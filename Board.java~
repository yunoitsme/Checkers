//v1.6.0
//may add toString method for board to make it easier in server/ client classes
public class Board
{
  private int[][] GameBoard;
  
  public Board()
  {
    GameBoard = new int[8][8];
    for(int x = 0; x < 8; x++)
    {
      for(int y = 0; y < 8; y++)
      {
        GameBoard[x][y] = 0;
      }
    }
  }//end default cunstructor
  
  public void MovePiece(int row, int col, int newrow, int newcol)
  {
    GameBoard[newrow][newcol] = GameBoard[row][col];
    GameBoard[row][col] = 0;
  }
  
  public int GetPiece(int row, int col)
  {
    return GameBoard[row][col];
  }
  
  public void Put(int row, int col, int piece)
  {
    GameBoard[row][col] = piece;
  }
  
  public void Remove(int row, int col)
  {
    GameBoard[row][col] = 0;
  }
  
  public String GetString()
  {
    String s = "";
    for(int row = 0; row < 8; row++)
    {
      for(int col = 0; col < 8; col++)
      {
        s = s + GetPiece(row,col);
        //System.out.print(GameBoard[row][col]);
      }
      s = s + "\n";
    }
    return s;
  }
  
  public void ResetBoard()
  {
    for(int x = 0; x < 8; x++)
    {
      for(int y = 0; y < 8; y++)
      {
        GameBoard[x][y] = 0;
      }
    }
  }
  
  public void Print()
  {
    for(int row = 0; row < 8; row++)
    {
      for(int col = 0; col < 8; col++)
      {
        System.out.print(GameBoard[row][col]);
      }
      System.out.println();
    }
  }
  
  public String toString()
  {
    String b = "";
    for(int row = 0; row < 8; row++)
    {
      for(int col = 0; col < 8; col++)
      {
        b = b + GameBoard[row][col]; 
      }
      b = b + "\n";
    }
    return b;
  }
}//end class