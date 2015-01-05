//remove col amd row from sting that is sent between them
//have the program display ur ip for easy use
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class CServer
{
  public static void main(String args[]) throws IOException
  {
    ServerSocket socket = new ServerSocket(9091);
    int x = 1;
    Checkers2 c = new Checkers2();
    Board b = c.GetBoard();
    //System.out.println(b);
    
    try
    {
      while(true)
      {
        Socket s = socket.accept();
        try
        {
          PrintWriter out = new PrintWriter(s.getOutputStream(), true);
          out.println(/*new Date().toString()*//*"connections: "+ x*/ b);
          
        }finally
        {
          s.close();
        }
        x++;
      }
    }finally
    {
      socket.close();
    }
  }
  
  //dont use
  public static String CreateBoardString(Board board)
  {
    String boardString = "0";
    
    for(int row = 0; row < 8; row++)
    {
      for(int col = 0; col < 8; col++)
      {
        boardString = boardString + row + col + board.GetPiece(row, col);
      }
    }
    return boardString;
  }//end createboardstring
}