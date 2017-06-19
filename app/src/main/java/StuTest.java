package StudentFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class StuTest {
    
	@SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		// TODO �Զ����ɵķ������
		
		StuMgr stuMgr = new StuMgr();
		while(true){
			stuMenu();
			System.out.println("��ѡ��");
			int sel = new Scanner(System.in).nextInt();
			if(sel >= 1 && sel <= 6){
				switch (sel) {
				case 1:
					stuMgr.addStu();
					break;
				case 2:
					stuMgr.deleteStuByNo();
					break;
				case 3:
					stuMgr.updateStu();
					break;
				case 4:
					stuMgr.getStuByNo();
					break;
				case 5:
					stuMgr.listStus();
					break;
				case 6:
					stuMgr.save();
					System.exit(0);
					break;
				}
			}else{
				System.out.println("ѡ����������ѡ��1-6��");
			}
		}
		
	}	
		public static void stuMenu(){
			System.out.println("---------------------------------");
			System.out.println("|\t1.����ѧ����Ϣ\t\t|");
			System.out.println("|\t2.ɾ��ѧ����Ϣ\t\t|");
			System.out.println("|\t3.�޸�ѧ����Ϣ\t\t|");
			System.out.println("|\t4.��ѯѧ����Ϣ\t\t|");
			System.out.println("|\t5.��ѯ����ѧ����Ϣ\t|");
			System.out.println("|\t6.�˳�\t\t\t|");
			System.out.println("---------------------------------");
			
		}



}
