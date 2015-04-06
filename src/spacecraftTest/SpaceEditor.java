package spacecraftTest;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class SpaceEditor {
	final static int minsize = 10;//useless
	static int maparea[][];
	static DataOutputStream dos;

	public static void main(String[] args) throws IOException {
		writemap(2560, 1600, "Data\\scmaps\\spacemap1.smp", "Images//bg//newBG.png"); // ���ɵ�ͼ
	}

	/**
	 * ������ʵ�ʴ�Сx,y,�����ַ,������ַ 
	 * 
	 * @param x(mapsize)
	 * @param y
	 * @param address(output address)
	 * @param bg(background image address)
	 * @throws IOException 
	 */
	public static void writemap(int x, int y, String address, String bg) throws IOException {
		try {
			dos = new DataOutputStream(new BufferedOutputStream(
					new FileOutputStream(address)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		};
		System.out.println("��ʼ���ɵ�ͼ");
			// ����д��//write
				dos.writeUTF(bg);// ��д����λ��
				dos.writeInt(x);// д��ʵ�ʴ�С
				dos.writeInt(y);
				
			try {
				dos.flush();
				dos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("���");
		}
	}
