package cn.edu.lsu;

public class Student {
	int id;
	String name;
	int age;
	float score;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	public Student(int id, String name, int age, float score) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.score = score;
	}
	public Student() {

	}

}
