package Student;

import java.util.Scanner;

public class StuControl {
	public static void main(String[] args) {
		StuMgr stuMgr = new StuMgr();
		while(true){
			sysMenu();
			System.out.println("请选择：");
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
					System.exit(0);
					break;
				}
			}else{
				System.out.println("选择有误，重新选择（1-6）");
			}
		}
	}
	
	public static void sysMenu(){
		System.out.println("---------------------------------");
		System.out.println("|\t1.增加学生信息\t\t|");
		System.out.println("|\t2.删除学生信息\t\t|");
		System.out.println("|\t3.修改学生信息\t\t|");
		System.out.println("|\t4.查询学生信息\t\t|");
		System.out.println("|\t5.查询所有学生信息\t|");
		System.out.println("|\t6.退出\t\t\t|");
		System.out.println("---------------------------------");
	}
}
