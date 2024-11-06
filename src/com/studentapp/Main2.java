package com.studentapp;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("***** Student Management System *****");
				
		Student s1=new Student("Rahul Kuhad", 25, "S-25");
		s1.enrollCourse("JAVA");
		s1.enrollCourse("JAVA");
		s1.enrollCourse("C#");
		
		Student s2=new Student("Rahul Dua", 21, "S-21");
		s2.enrollCourse("JAVA");
		
		Student s3=new Student("Rahul Tanwar", 23, "S-23");
		s3.enrollCourse("DSA");
	}

}
