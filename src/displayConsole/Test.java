package displayConsole;
import java.awt.*;

import javax.swing.*;

import spacecraftcore.KL;
import spacecraftcore.ML;
import spacecraftcore.MainGame;

public class Test extends JFrame {
   public Repainter repainter;
   public KL kl;
   public ML ml;
   public int windowsizex=800;
   public int windowsizey=600;
	public Test(){
	   this.setTitle("Spacecraft");
	   Container c = this.getContentPane();
	   repainter=new Repainter();
	   c.add(repainter);
	   this.setBounds(400,200,windowsizex,windowsizey);
	   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   this.setResizable(false);
	   this.setVisible(true);
	   //事件部分
	   kl = new KL();
	   this.addKeyListener(kl);
	   ml = new ML();
	   this.addMouseMotionListener(ml);
	   this.addMouseMotionListener(new ML());
	   this.addMouseListener(ml);
   }
//   public static void main(String args[]){
//	   Test test = new Test();
//	   test.addWindowListener(new WindowAdapter(){
//		   public void windowClosing(WindowEvent e){
//			   System.exit(0);
//		   }
//	   });
//   }
	public void setMapsize(int x,int y)
	{
		this.repainter.mapsizex=x;
		this.repainter.mapsizex=y;
		this.repainter.windowsizex = MainGame.test.windowsizex;
		this.repainter.windowsizey = MainGame.test.windowsizey;
	}
}
