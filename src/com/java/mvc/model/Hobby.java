package com.java.mvc.model;

public class Hobby {
	String hobbies;

	public Hobby(String hobbies) {
		this.hobbies = hobbies;
	}

	public String getHobbies() {
		return hobbies;
	}

	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}

	@Override
	public String toString() {
		return "Hobby [hobbies=" + hobbies + "]";
	}
}
