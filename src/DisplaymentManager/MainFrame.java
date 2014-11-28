package DisplaymentManager;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
public class MainFrame extends JFrame{
	private Image bg=getToolkit().getImage("bg1.jpg"); 
    private BackgroundPanel backgroundPanel;
    //private static JLabel timeLable;
    //private static JLabel scoreLable;
    
    public MainFrame(){
    	super();
    	setResizable(false);
    	setTitle("Alpha");
    	setAlwaysOnTop(true);
 	    setBounds(400,200,800,600);
 	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 	    backgroundPanel = new BackgroundPanel();
 	    backgroundPanel.setImage(bg);
 	    Container c = this.getContentPane();
 	    c.add(backgroundPanel,BorderLayout.CENTER);
 	    
 	    //Add lable to the background Panel,do remember!!!!
 	    
    }
    
    public static void main(String args[]){
    	MainFrame gameframe = new MainFrame();
    	gameframe.setVisible(true);

    }
}
