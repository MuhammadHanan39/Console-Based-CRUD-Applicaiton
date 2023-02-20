package com.crud.service;



import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import com.crud.dao.*;
import com.crud.entities.*;

@Service
public class ServiceClass {
	
	ApplicationContext c=new ClassPathXmlApplicationContext("config.xml");
	private DaoClass daoClass=c.getBean("daoClass",DaoClass.class);
	
		
	public DaoClass getDaoClass() {
		return daoClass;
	}

	public void setDaoClass(DaoClass daoClass) {
		this.daoClass = daoClass;
	}




	//Code for adding student
	public Integer add(StudentEntity student) {
//		System.out.println("In service class");
		Integer studentId=this.daoClass.addStudent(student);
		return studentId;
	}
	
	
	
	
//	Code for display all the student stored in database
	public List<StudentEntity> displayAll(){
		return daoClass.getAll();
	}
	
	
	
	//Code for getting the student through given id
	public StudentEntity getStudent(int id) {
		StudentEntity st=daoClass.getById(id);
		return st;
	}
	
	
	//Method for deleting the student
	public void deleteStudent(int id) {
		daoClass.deleteStudent(id);
	}
	
	
	//Method for updating the student
	public int updateStudent(StudentEntity s) {
		int stId=daoClass.update(s.getStudentId(), s);
		return stId;
	}
}
