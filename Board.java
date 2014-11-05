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
}//end class