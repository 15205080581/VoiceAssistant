package StudentFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class StuMgr{
	
	List<Student> stul = new LinkedList<Student>();
	Scanner sc = new Scanner(System.in);
	
	@SuppressWarnings({ "unchecked", "resource" })
	public void load() throws IOException, ClassNotFoundException{
		
		File f = new File("src\\StudentFile\\students");
		f.createNewFile();
		FileInputStream fis = null;
		ObjectInputStream isr = null;
		fis = new FileInputStream(f);
		isr = new ObjectInputStream(fis);
		stul =  (List<Student>) isr.readObject();
	}
    @SuppressWarnings("resource")
	public void save() throws IOException{
    	File f = new File("src/stus.txt");
		FileOutputStream fos = null;
		ObjectOutputStream osr = null;
		fos = new FileOutputStream(f);
		osr = new ObjectOutputStream(fos);
		osr.writeObject(stul);
    	
    }
	
	
	/**
	 * 增加一个学生
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public void addStu() throws FileNotFoundException, IOException{
		Student a = new Student();
		System.out.println("请输入学号：");
		while(true){
			String no = sc.next();
			if(no.length() != 4){
				System.out.println("学号必须为四位！请重新输入：");
				continue;
			}
			a.setNo(no);
			break;
		}
		
		System.out.println("请输入姓名：");
		String name = sc.next();
		a.setName(name);
		
		System.out.println("请输入年龄：");
		while(true){
			int age = sc.nextInt();
			if(age < 10 || age > 30){
				System.out.println("年龄必须10-30！请重新输入：");
				continue;
			}
			a.setAge(age);
			break;
		}
		
		System.out.println("请输入性别，0（女），1（男）：");
		while(true){
			int sel = sc.nextInt();
			System.out.println("sel = "+sel);
			if(sel != 0 && sel != 1){
				System.out.println("输入有误！请重新输入：");
				continue;
			}
			if(0 == sel){
				a.setSex('女');
			}
			else{
				a.setSex('男');
			}
			break;
		}
		stul.add(a);
		save();
		System.out.println("添加成功！");
		System.out.println(a.toString());

	}
	
	/**
	 *通过学号删除学生
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 */
	public void deleteStuByNo() throws FileNotFoundException, IOException, ClassNotFoundException{
		load();
		System.out.println("请输入要删除的学号：");
		int index = getStuIndexByNo(sc.next());
		if(-1 != index){
			stul.remove(index);
			System.out.println("删除成功！");
			save();
			load();
		}
		
	}
	
	/**
	 * 修改学生信息
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 */
	public void updateStu() throws FileNotFoundException, IOException, ClassNotFoundException{
		Student b = new Student();
		System.out.println("请输入要修改的学生学号：");
		int index = getStuIndexByNo(sc.next());
		if(-1 != index){
			System.out.println("原姓名为："+stul.get(index).getName()+",请输入新的姓名：");
			String name = sc.next();
			b.setName(name);;
			
			System.out.println("原年龄为"+stul.get(index).getAge()+",请输入新的年龄：");
			while(true){
				int age = sc.nextInt();
				if(age < 10 || age > 30 ){
					System.out.println("年龄必须介于10-30，请重新输入：");
					continue;
				}
				b.setAge(age);
				save();
				load();
				System.out.println("修改成功！");
				break;
			}		
		}else{
			System.out.println("该学号不存在");
		}
		
	}
	
	/**
	 * 根据学号获取学生
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public void getStuByNo() throws ClassNotFoundException, IOException{
		
		load();
		System.out.println("请输入要查询的学号：");
		int index = getStuIndexByNo(sc.next());
		if(-1 != index){
			System.out.println("查找成功！");
			System.out.println(stul.get(index).toString());
		}else{
			System.out.println("该学号不存在！");
			
		}
	}
	
	/**
	 * 获取所有学生
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public void listStus() throws ClassNotFoundException, IOException{
		load();
		System.out.println("学生个数："+stul.size());
		for(Student a : stul) {
            System.out.println(a);
        }
		Collections.sort(stul,new NameComparator());
		System.out.println("***按学生姓名顺序输出学生信息***");
		Iterator<Student> it  = stul.iterator();
		while(it.hasNext()){
			
			System.out.println(it.next());
		}
		
		Collections.sort(stul);
		System.out.println("***按学生学号顺序输出学生信息***");
		Iterator<Student> it1  = stul.iterator();
		while(it1.hasNext()){	
			System.out.println(it1.next());
		}
		
	}
	
	/**
	 * 根据学号获取该生在LinkedList的下标
	 * @param no
	 * @return
	 */
	public int getStuIndexByNo(String no){
		for(int i = 0; i < stul.size(); i++)
		{
			if(stul.get(i).getNo().equals(no))
			{
				return i;
			}
	    }
		return -1;
	}

}

class NameComparator implements Comparator<Student>{

	public int compare(Student o1, Student o2) {
		// TODO 自动生成的方法存根
		Student a = o1;
		Student b = o2;
		return b.getName().compareTo(a.getName());
	}
	
}
