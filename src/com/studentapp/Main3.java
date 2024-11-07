package com.studentapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main3 {
	public static List<Student> studentList;

	public static void main(String[] args) {
		System.out.println("***** Student Management System *****");
		studentList = new ArrayList<Student>();

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter student name");
		String name = scanner.next();
		System.out.println("Name entered: " + name);
		System.out.println("Enter student age");
		int age = scanner.nextInt();
		System.out.println("Age entered: " + age);
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
