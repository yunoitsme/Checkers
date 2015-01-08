import java.io.*;
import java.net.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;

public class CheckersServer
{
  public static void main(String args[]) throws Exception
  {
    ServerSocket socket = new ServerSocket(9091);
    
    while(true)
    {
      Socket s = socket.accept();
      BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
      DataOutputStream out = new DataOutputStream(s.getOutputStream());
      
      
    }
  }
}