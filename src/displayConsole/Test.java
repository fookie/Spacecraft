package displayConsole;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Test extends JFrame {
   Test(){
	   this.setTitle("Try");
	   Container c = this.getContentPane();
	   c.add(new Repainter());
	   this.setBounds(400,200,800,600);
	   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   this.setResizable(false);
	   this.setVisible(true);
   }
   public static void main(String args[]){
	   Test test = new Test();
	   test.addWindowListener(new WindowAdapter(){
		   public void windowClosing(WindowEvent e){
			   System.exit(0);
		   }
	   });
   }
}
