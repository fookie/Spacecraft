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
	 * ��ͼ�Ĵ�С��������ͼƬ��ֱ������λ������
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
