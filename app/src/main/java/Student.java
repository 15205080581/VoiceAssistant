package StudentFile;

import java.io.Serializable;

public class Student implements Comparable<Student>,Serializable{
	/** 学号*/
	private String no;
	/**姓名*/
	private String name;
	/**年龄*/
	private int age;
	/**性别*/
	private char sex;
	
	public Student() {
	}
	public Student(String no, String name, int age, char sex) {
		super();
		this.no = no;
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	
	public String toString() {
		return "Student [no=" + no + ", name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}
	
	public int compareTo(Student o) {
		Student input = o;
		return getNo().compareTo(input.getNo());
	}
}
