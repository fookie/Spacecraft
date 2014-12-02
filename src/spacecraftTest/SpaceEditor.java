package spacecraftTest;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class SpaceEditor {
	final static int minsize = 10;// �����С //��λ��С
	static int maparea[][];
	static DataOutputStream dos;

	public static void main(String[] args) throws IOException {
		writemap(1600, 1200, "bigmap1600*1200.cmp", "Image//bg1.png"); // ���ɵ�ͼ
	}

	/**
	 * ������ʵ�ʴ�Сx,y,�����ַ,������ַ
	 * 
	 * @param x
	 * @param y
	 * @param address
	 * @param bg
	 * @throws IOException 
	 */
	public static void writemap(int x, int y, String address, String bg) throws IOException {
		int ax, ay;
		try {
			dos = new DataOutputStream(new BufferedOutputStream(
					new FileOutputStream(address)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		ax = x / minsize;
		ay = y / minsize;
		System.out.println(ax);
		System.out.println(ay+"��ʼ���ɵ�ͼ");
			//�Զ����
			// ����д��
				dos.writeUTF(bg);// ��д����λ��
				dos.writeInt(ax);// ������
				dos.writeInt(ay);
				dos.writeInt(x);// д��ʵ�ʴ�С
				dos.writeInt(y);
				dos.writeInt(minsize);//д�������С
		

			try {
				dos.flush();
				dos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("���");
		}
	}
