package displayConsole.menu;

import java.awt.Rectangle;

/**
 * ���ǰ�ť�����ֽ�������º�ϵͳ�Դ����ظ�
 * @author Hale
 */
public abstract class SButton {
	String Default;//δ����ȥʱ��״̬
	String over;//�������֮��
	String pressed;//����ȥ��
	int status=0;//״̬,0δ����,1֮��,2����ȥ��
	Rectangle buttonhitbox=new Rectangle();
	public abstract void setstatus(int s);
	public abstract String getImage();
	public abstract boolean click();
}
