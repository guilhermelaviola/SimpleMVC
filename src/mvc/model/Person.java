package mvc.model;

public class Person {
	String name;
	int age;
	double height;
	double weight;
	Gender gender;
	String from;
	Hobby hobby;
	
	public Person(String name, int age, double height, double weight, Gender gender, String from, Hobby hobby) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.gender = gender;
		this.from = from;
		this.hobby = hobby;
	}

	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public double getHeight() {
		return height;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public Gender getGender() {
		return gender;
	}
	
	public String getFrom() {
		return from;
	}
	
	public Hobby getHobby() {
		return hobby;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	public void setFrom(String from) {
		this.from = from;
	}
	
	public void setHobby(Hobby hobby) {
		this.hobby = hobby;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", height=" + height + ", weight=" + weight + ", gender="
				+ gender + ", from=" + from + ", hobby=" + hobby + "]";
	}
}

enum Gender{
	MALE,
	FEMALE
}
