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
	 * ����һ��ѧ��
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public void addStu() throws FileNotFoundException, IOException{
		Student a = new Student();
		System.out.println("������ѧ�ţ�");
		while(true){
			String no = sc.next();
			if(no.length() != 4){
				System.out.println("ѧ�ű���Ϊ��λ�����������룺");
				continue;
			}
			a.setNo(no);
			break;
		}
		
		System.out.println("������������");
		String name = sc.next();
		a.setName(name);
		
		System.out.println("���������䣺");
		while(true){
			int age = sc.nextInt();
			if(age < 10 || age > 30){
				System.out.println("�������10-30�����������룺");
				continue;
			}
			a.setAge(age);
			break;
		}
		
		System.out.println("�������Ա�0��Ů����1���У���");
		while(true){
			int sel = sc.nextInt();
			System.out.println("sel = "+sel);
			if(sel != 0 && sel != 1){
				System.out.println("�����������������룺");
				continue;
			}
			if(0 == sel){
				a.setSex('Ů');
			}
			else{
				a.setSex('��');
			}
			break;
		}
		stul.add(a);
		save();
		System.out.println("��ӳɹ���");
		System.out.println(a.toString());

	}
	
	/**
	 *ͨ��ѧ��ɾ��ѧ��
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 */
	public void deleteStuByNo() throws FileNotFoundException, IOException, ClassNotFoundException{
		load();
		System.out.println("������Ҫɾ����ѧ�ţ�");
		int index = getStuIndexByNo(sc.next());
		if(-1 != index){
			stul.remove(index);
			System.out.println("ɾ���ɹ���");
			save();
			load();
		}
		
	}
	
	/**
	 * �޸�ѧ����Ϣ
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 */
	public void updateStu() throws FileNotFoundException, IOException, ClassNotFoundException{
		Student b = new Student();
		System.out.println("������Ҫ�޸ĵ�ѧ��ѧ�ţ�");
		int index = getStuIndexByNo(sc.next());
		if(-1 != index){
			System.out.println("ԭ����Ϊ��"+stul.get(index).getName()+",�������µ�������");
			String name = sc.next();
			b.setName(name);;
			
			System.out.println("ԭ����Ϊ"+stul.get(index).getAge()+",�������µ����䣺");
			while(true){
				int age = sc.nextInt();
				if(age < 10 || age > 30 ){
					System.out.println("����������10-30�����������룺");
					continue;
				}
				b.setAge(age);
				save();
				load();
				System.out.println("�޸ĳɹ���");
				break;
			}		
		}else{
			System.out.println("��ѧ�Ų�����");
		}
		
	}
	
	/**
	 * ����ѧ�Ż�ȡѧ��
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public void getStuByNo() throws ClassNotFoundException, IOException{
		
		load();
		System.out.println("������Ҫ��ѯ��ѧ�ţ�");
		int index = getStuIndexByNo(sc.next());
		if(-1 != index){
			System.out.println("���ҳɹ���");
			System.out.println(stul.get(index).toString());
		}else{
			System.out.println("��ѧ�Ų����ڣ�");
			
		}
	}
	
	/**
	 * ��ȡ����ѧ��
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public void listStus() throws ClassNotFoundException, IOException{
		load();
		System.out.println("ѧ��������"+stul.size());
		for(Student a : stul) {
            System.out.println(a);
        }
		Collections.sort(stul,new NameComparator());
		System.out.println("***��ѧ������˳�����ѧ����Ϣ***");
		Iterator<Student> it  = stul.iterator();
		while(it.hasNext()){
			
			System.out.println(it.next());
		}
		
		Collections.sort(stul);
		System.out.println("***��ѧ��ѧ��˳�����ѧ����Ϣ***");
		Iterator<Student> it1  = stul.iterator();
		while(it1.hasNext()){	
			System.out.println(it1.next());
		}
		
	}
	
	/**
	 * ����ѧ�Ż�ȡ������LinkedList���±�
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
		// TODO �Զ����ɵķ������
		Student a = o1;
		Student b = o2;
		return b.getName().compareTo(a.getName());
	}
	
}
