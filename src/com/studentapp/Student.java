package com.studentapp;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {

	private String name;
	private int age;
	private String studentId;
	private List<String> courses;

	public Student(String name, int age, String studentId) {
		super();
		if (validateName(name) && validateAge(age)) {
			this.name = name;
			this.age = age;
			this.studentId = studentId;
			courses = new ArrayList<>();
		}
		
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getStudentId() {
		return studentId;
	}

	public List<String> getCourses() {
		return courses;
	}

	public void enrollCourse(String course) {
		if (validateCourseName(course)) {
			if (!courses.contains(course)) {
				courses.add(course);
				System.out.println("Student is enrolled to " + course + " course successfully");
			} else {
				System.err.println("Student is already enrolled to the " + course + " course");
			}
		}

	}

	public void printStudentInfo() {
		System.out.println("***** Student information *****");
		System.out.println("Student name: " + name);
		System.out.println("Student age: " + age);
		System.out.println("Student id: " + studentId);
		System.out.println("Enrolled for: " + courses);
	}

	public boolean validateName(String name) {
		String nameRegex = "^[a-zA-Z\\s]+$";
		Pattern namePattern = Pattern.compile(nameRegex);
		Matcher nameMatcher = namePattern.matcher(name);
		if (nameMatcher.matches()) {
			return true;
		} else {
			System.err.println("Invalid name!! Please enter alphabets only");
			return false;
		}
	}

	public boolean validateAge(int age) {
		if (age >= 19 && age <= 35) {
			return true;
		} else {
			System.err.println("Invalid age!! Student age should be between 19 and 35");
			return false;
		}
	}

	public boolean validateCourseName(String course) {
		if (course.equalsIgnoreCase("Java") || course.equalsIgnoreCase("DSA") || course.equalsIgnoreCase("Devops")) {
			return true;
		} else {
			System.err.println("Invalid course!! Course name should be only from JAVA, DSA, Devops");
			return false;
		}
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", studentId=" + studentId + ", courses=" + courses + "]";
	}

}
