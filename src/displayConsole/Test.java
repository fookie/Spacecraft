package displayConsole;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import spacecraftcore.BattleFieldManager;
import spacecraftcore.KL;
import spacecraftcore.ML;

public class Test extends JFrame {
   public Repainter repainter;
   public KL kl;
   public ML ml;
	public Test(){
	   this.setTitle("Try");
	   Container c = this.getContentPane();
	   repainter=new Repainter();
	   c.add(repainter);
	   this.setBounds(400,200,800,600);
	   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   this.setResizable(false);
	   this.setVisible(true);
	   kl = new KL();
	   this.addKeyListener(kl);
	   ml = new ML();
	   this.addMouseMotionListener(ml);
	   this.addMouseMotionListener(new ML());
   }
//   public static void main(String args[]){
//	   Test test = new Test();
//	   test.addWindowListener(new WindowAdapter(){
//		   public void windowClosing(WindowEvent e){
//			   System.exit(0);
//		   }
//	   });
//   }
}
