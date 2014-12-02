package displayConsole;
import java.awt.Image;
import java.awt.*;

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
