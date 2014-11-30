package displayConsole;
import java.awt.Graphics;
import java.awt.Image;
import java.util.LinkedList;
import java.util.List;
import java.awt.*;

import javax.swing.*;

public class Element {
  private Toolkit tk = Toolkit.getDefaultToolkit();
  public String filename;
  public int x;
  public int y;
  public int rotatedegree;
  public int layer;
  public Image img =  tk.getImage(filename);
  
   public Element(String s,int x,int y,int d,int l){
	   filename = s;
	   this.x = x;
	   this.y = y;
	   rotatedegree = d;
	   layer = l;
   }


}
