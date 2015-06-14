package spacecraftcore;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import displayConsole.Gamewindow;
import displayConsole.menu.Menuwindow;

/**
 * ����������������ϸ���Manager��ȫ�ֱ���
 * 
 */

public class MainGame {
	public static int gamestatus=0;//0�˵�״̬��1��Ϸ״̬,2,����״̬//0:menu mode 1:gamemode 2:loading
	public static BattleFieldManager bm;
	public static Gamewindow test;
	public static Menuwindow mainmenu;
	public static long gametime;
	public static Thread mt,lan_t;
	public static boolean debug=true;
	public static boolean lan_game=true;//��������Ϸ
	public static String lan_IP="172.21.70.97";
//	public static String lan_IP="127.0.0.1";
	public static Dimension srcDim = Toolkit.getDefaultToolkit().getScreenSize();
	public static boolean cansendimage=true;

	public static void main(String[] args) {
		mt = new Thread(new SpaceTimmer());//�½��߳�//new thread
		lan_t=new Thread(new Receiver());
		
		srcDim = Toolkit.getDefaultToolkit().getScreenSize();   //��ȡ��Ļ�ֱ���//get screensize
		mainmenu=new Menuwindow("Images//UI//menubg.jpg",srcDim.width,srcDim.height);
		mainmenu.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		mt.start();//���߳�
		lan_t.start();//ͨ���߳�
	}
}