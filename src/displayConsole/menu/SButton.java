package displayConsole.menu;

import java.awt.Rectangle;

/**
 * ���ǰ�ť�����ֽ�������º�ϵͳ�Դ����ظ�<br/>
 * It's the button class. The name of it is to avoid conflict.
 * @author Hale
 */
public abstract class SButton {
	String Default;//δ����ȥʱ��״̬           //The default status of button.
	String over;//�������֮��                  //The cursor is over it.
	String pressed;//����ȥ��                   //pressed
	int status=0;//״̬,0δ����,1֮��,2����ȥ�� //Status: 0: default 1: over 2: pressed
	Rectangle buttonhitbox=new Rectangle();
	public abstract void setstatus(int s);
	public abstract String getImage();
	public abstract boolean click();
}
