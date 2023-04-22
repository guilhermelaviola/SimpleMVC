package model;

import java.sql.Date;

public class Person {
	String firstName;
	String lastName;
	Date dob;
	Sex sex;
	Profession profession;
	
	
	
	public Person(String firstName, String lastName, Date dob, Sex sex) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.sex = sex;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Date getDob() {
		return dob;
	}

	public Sex getSex() {
		return sex;
	}

	public Profession getProfession() {
		return profession;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public void setProfession(Profession profession) {
		this.profession = profession;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + ", sex=" + sex
				+ ", profession=" + profession + "]";
	}		
}

enum Sex{
	M,
	F
}
