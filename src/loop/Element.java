package loop;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.util.List;
import java.awt.Component;
import java.awt.*;
import javax.swing.*;

public class Element extends Image{
  private Toolkit tk = Toolkit.getDefaultToolkit();
  private String filename;
  private int x;
  private int y;
  private int rotatedegree;
  private int layer;
  private Image bg = tk.getImage(filename);
  
   public Element(String s,int x,int y,int d,int l){
	   filename = s;
	   this.x = x;
	   this.y = y;
	   rotatedegree = d;
	   layer = l;
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
