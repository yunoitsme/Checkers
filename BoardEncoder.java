public class BoardEncoder
{
  public static String Encode(Board b)
  {
    String s = "";
    for(int x = 0; x < 8; x++)
    {
      for(int y = 0; y < 8; y++)
      {
        s = s + b.GetPiece(x, y);
      }
    }
    return s;
  }
  
  public static Board Decode(String s)
  {
    int z = 0;
    Board b = new Board();
    for(int x = 0; x < 8; x++)
    {
      for(int y = 0; y < 8; y++)
      {
        b.Put(x, y, Integer.parseInt(s.charAt(z) + ""));
        z++;
      }
    }
    return b;
  }
  
  public static void main(String args[])
  {
    Board b = new Board();
    b.FillBoard();
    System.out.println(Encode(b));
    System.out.println(Decode(Encode(b)));
    Decode(Encode(b)).Print();
  }
}