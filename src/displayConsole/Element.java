package displayConsole;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.util.LinkedList;
import java.util.List;
import java.awt.*;

import javax.swing.*;

public class Element extends Image{
  private Toolkit tk = Toolkit.getDefaultToolkit();
  public String filename;
  public int x;
  public int y;
  public int rotatedegree;
  public int layer;
  private Element element = (Element) tk.getImage(filename);
  
   public Element(String s,int x,int y,int d,int l){
	   filename = s;
	   this.x = x;
	   this.y = y;
	   rotatedegree = d;
	   layer = l;
   }
   public void add(String name,int x,int y,int degree,int layer){
	   List<Element> el = new LinkedList<Element>();
   }

@Override
public int getWidth(ImageObserver observer) {
	return this.getWidth(observer);
}

@Override
public int getHeight(ImageObserver observer) {
	return this.getHeight(observer);
}

@Override
public ImageProducer getSource() {
	return this.getSource();
}

@Override
public Graphics getGraphics() {
	return this.getGraphics();
}

@Override
public Object getProperty(String name, ImageObserver observer) {
	return this.getProperty(name, observer);
}
}
