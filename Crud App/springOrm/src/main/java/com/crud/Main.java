package com.crud;

import java.util.List;
import java.util.Scanner;
import com.crud.entities.*;
import com.crud.service.*;

public class Main {

	public static void main(String[] args) {

		ServiceClass service = new ServiceClass();
		boolean run = true;
		while (run) {
			System.out.println("##################  Welcome To Spring Orm Project  ################## \n"
					+ "PRESS 1 for add new student \n" + "PRESS 2 for display all students \n"
					+ "PRESS 3 for get detail of single student \n" + "PRESS 4 for delete student \n"
					+ "PRESS 5 for update student \n" + "PRESS 6 for exit");

			Scanner sc = new Scanner(System.in);
			int num = sc.nextInt();

			try {
				switch (num) {
				case 1: {
					//code for add new student
					
					StudentEntity st = new StudentEntity();
					
					//Getting the details of student Entity
					System.out.println("Enter the name of student");
					String studentName = sc.next();
					System.out.println("Enter the dept");
					String dept = sc.next();
					
					//Setting it in student entity
					st.setDept(dept);
					st.setStudentName(studentName);
					st.setStudentId(1);
					Integer studentId = service.add(st);
					if (studentId == null)
						System.out.println("Something went wrong! please try again");
					else {
						System.out.println("____________________________________________\n");
						System.out.println();
						System.out.println("Student is added and your generated id is " + studentId);
						System.out.println();
					}
						
					break;
				}

				case 2: {
					//code for displaying all the students
					List<StudentEntity> students = service.displayAll();
					for (StudentEntity s : students) {
						System.out.println("___________________________________________\n");
						System.out.println();
						System.out.println("Student Id is : "+s.getStudentId()+"\n"+
								"Student Name is : "+s.getStudentName()+"\n"
								+ "Student department is : "+s.getDept());
						System.out.println("\n_____________________________________________");
					}
					break;
				}

				case 3: {
					//code for displaying student of given id
					System.out.println("Enter the Student id to get student");
					int id = sc.nextInt();
					StudentEntity student = service.getStudent(id);
					if (student == null)
						System.out.println("Item not found! please enter valid id");
					else {
						System.out.println("_____________________________________________\n");
						System.out.println("Student Id is : "+student.getStudentId()+"\n"+
								"Student Name is : "+student.getStudentName()+"\n"
								+ "Student department is : "+student.getDept());
						System.out.println("\n_____________________________________________");
						
					}
						
					break;
				}
				case 4: {
					// code for delete student
					
					System.out.println("Enter the Student Id for deleting student");
					int id=sc.nextInt();
					service.deleteStudent(id);
					break;
				}
				case 5: {
					// Code for updating the student object
					StudentEntity st=new StudentEntity();
					System.out.println("Enter the details\n");
					System.out.println("Enter the id");
					int id=sc.nextInt();
					System.out.println("Enter the Student Name");
					String name=sc.next();
					System.out.println("Enter the department");
					String dept=sc.next();
					st.setDept(dept);
					st.setStudentId(id);
					st.setStudentName(name);
					int updatedId=service.updateStudent(st);
					System.out.println("________________________________\n");
					System.out.println("Student is updated Successfully\n");
					System.out.println("Your updated id is : "+updatedId+"\n__________________________________");
					
					break;
				}
				case 6: {
					// code for exit
					run = false;
					break;
				}
				}
			} catch (Exception e) {
				System.out.println("Something went wrong Please try again y" + e);
			}
			System.out.println("************************************");
		}
		System.out.println("Thank you for using our service...");
	}
}
