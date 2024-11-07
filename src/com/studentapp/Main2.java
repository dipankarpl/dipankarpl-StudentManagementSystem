package com.studentapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main2 {
	public static List<Student> studentList;

	public static void main(String[] args) {
		System.out.println("***** Student Management System *****");
		studentList = new ArrayList<Student>();

		Student s1 = new Student("Rahul Kuhad", 25, "S-25");
		s1.enrollCourse("JAVA");
		s1.enrollCourse("JAVA");
		s1.enrollCourse("C#");

		Student s2 = new Student("Rahul Dua", 21, "S-21");
		s2.enrollCourse("JAVA");

		Student s3 = new Student("Rahul Tanwar", 23, "S-23");
		s3.enrollCourse("DSA");

		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);

		Student result = findStudentByID("S-20");
		System.out.println("Result: " + result);
		sortByName();
	}

	private static void sortByName() {
		Comparator<Student> studentNameComparator = new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				return o1.getName().compareTo(o2.getName());
			}
		};
		Collections.sort(studentList, studentNameComparator);
		System.out.println(studentList);
	}

	private static Student findStudentByID(String id) {
		Student result = null;
		try {
			result = studentList.stream().filter(x -> x.getStudentId().equalsIgnoreCase(id)).findFirst()
					.orElseThrow(() -> new RuntimeException("No data found"));

		} catch (Exception e) {
			System.out.println("Student " + id + " not found");
		}

		return result;
	}

}
