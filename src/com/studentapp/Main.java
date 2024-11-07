package com.studentapp;

public class Main {

	public static void main(String[] args) {
		System.out.println("***** Student Management System *****");
				
		Student s1=new Student("Rahul Kuhad", 25, "S-25");
		s1.enrollCourse("JAVA");
		s1.enrollCourse("JAVA");
		s1.enrollCourse("C#");
		s1.printStudentInfo();
		//System.out.println(s1);
		
		Student s2=new Student("Rahul Dua", 21, "S-21");
		s2.enrollCourse("JAVA");
		s2.printStudentInfo();
		//System.out.println(s2);
		
		Student s3=new Student("Rahul Tanwar", 23, "S-23");
		s3.enrollCourse("DSA");
		s3.printStudentInfo();
		//System.out.println(s3);
	}

}
