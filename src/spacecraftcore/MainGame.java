package spacecraftcore;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import displayConsole.Gamewindow;
import displayConsole.menu.Menuwindow;

/**
 * 考虑在主程序里加上各个Manager的全局变量
 * 
 */

public class MainGame {
	public static int gamestatus=0;//0菜单状态，1游戏状态,2,加载状态//0:menu mode 1:gamemode 2:loading
	public static BattleFieldManager bm;
	public static Gamewindow test;
	public static Menuwindow mainmenu;
	public static long gametime;
	public static Thread mt,lan_t;
	public static boolean debug=true;
	public static boolean lan_game=true;//局域网游戏
	public static String lan_IP="172.21.70.97";
//	public static String lan_IP="127.0.0.1";
	public static Dimension srcDim = Toolkit.getDefaultToolkit().getScreenSize();
	public static boolean cansendimage=true;

	public static void main(String[] args) {
		mt = new Thread(new SpaceTimmer());//新建线程//new thread
		lan_t=new Thread(new Receiver());
		
		srcDim = Toolkit.getDefaultToolkit().getScreenSize();   //获取屏幕分辨率//get screensize
		mainmenu=new Menuwindow("Images//UI//menubg.jpg",srcDim.width,srcDim.height);
		mainmenu.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		mt.start();//主线程
		lan_t.start();//通信线程
	}
}