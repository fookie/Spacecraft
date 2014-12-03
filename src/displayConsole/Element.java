package displayConsole;
import java.awt.Image;
import java.awt.*;

public class Element {
  private Toolkit tk = Toolkit.getDefaultToolkit();
  public String filename;
  public int x;
  public int y;
  public double rotatedegree;
  public int layer;
  public Image img =  tk.getImage(filename);
  /**
	 * 贴图的大小，正方形图片的直径。单位：像素
	 */
public int Imagesize;
  
   public Element(String s,int x,int y,double d,int l){
	   filename = s;
	   this.x = x;
	   this.y = y;
	   rotatedegree = d;
	   layer = l;
   }


}
