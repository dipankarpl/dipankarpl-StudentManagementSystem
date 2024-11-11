package com.studentapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
	private static List<Student> studentList;
	private static Scanner scanner;

	public static void main(String[] args) {
		System.out.println("***** Student Management System *****");
		studentList = new ArrayList<Student>();
		scanner = new Scanner(System.in);
		while (true) {
			System.out.println("***** Welcome *****");
			System.out.println("Select an option");
			System.out.println("1. Register a student");
			System.out.println("2. Find student with student id");
			System.out.println("3. List all student information");
			System.out.println("4. list student information in sorted order");
			System.out.println("5. EXIT");

			int option = scanner.nextInt();
			switch (option) {
			case 1:
				enrollStudent(scanner);
				break;
			case 2:
				findStudentById(scanner);
				break;
			case 3:
				printAllStudentData();
				break;
			case 4:
				sortByName();
				break;
			case 5:
				exit();
				break;
			default:
				System.out.println("Invalid option selected!!");
			}
		}
	}

	private static void exit() {
		System.out.println("Good bye!!");
		System.exit(0);
	}

	private static void printAllStudentData() {
		if (!studentList.isEmpty()) {
			System.out.println("********** Print all student data **********");
			for (Student student : studentList) {
				student.printStudentInfo();
			}
			System.out.println("********************");
		} else
			System.err.println("Student list is empty!!");

	}

	private static void findStudentById(Scanner scanner2) {
		Student result = null;
		System.out.println("Enter the student id");
		String studentId = scanner2.next();
		try {
			result = studentList.stream().filter(x -> x.getStudentId().equalsIgnoreCase(studentId)).findFirst()
					.orElseThrow(() -> new RuntimeException("No data found"));

		} catch (Exception e) {
			System.out.println("Student " + studentId + " not found");
		}

		result.printStudentInfo();
	}

	private static void enrollStudent(Scanner scanner2) {
		System.out.println("Enter student name");
		String name = scanner.next();

		System.out.println("Enter student age");
		int age = scanner.nextInt();

		System.out.println("Enter student id");
		String id = scanner.next();

		Student newStudent = new Student(name, age, id);
		studentList.add(newStudent);

		while (true) {
			System.out.println("Enter the course to be enrolled!!..Type DONE to exit :)");
			String courseName = scanner2.next();
			if (courseName.equalsIgnoreCase("done")) {
				break;
			}
			newStudent.enrollCourse(courseName);
		}

		newStudent.printStudentInfo();
	}

	private static void sortByName() {
		Comparator<Student> studentNameComparator = new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				return o1.getName().compareTo(o2.getName());
			}
		};
		Collections.sort(studentList, studentNameComparator);
		printAllStudentData();
	}

}
