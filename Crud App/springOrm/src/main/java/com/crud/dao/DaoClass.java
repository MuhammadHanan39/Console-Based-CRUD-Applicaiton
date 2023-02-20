package com.crud.dao;

import com.crud.entities.*;
import java.util.List;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class DaoClass{

private HibernateTemplate daoObject;
	
//	Getter and Setters for Object of HibernateTemplate class
	public HibernateTemplate getDaoObject() {
		return daoObject;
	}

	public void setDaoObject(HibernateTemplate daoObject) {
		this.daoObject = daoObject;
	}

	
	
	//method for display student through given id
	public StudentEntity getById(int id) {
		// TODO Auto-generated method stub
		StudentEntity student = null;
		try{
			student=this.daoObject.get(StudentEntity.class,id);
		}catch(Exception e) {
			System.out.println(e);
		}
//		if(student==null) {
//			System.out.println("invalid Id. Please try again with valid id");
//		}
		return student;
	}

	
	
	
	//method for displaying all the students
	public List<StudentEntity> getAll() {
		// TODO Auto-generated method stub
		List<StudentEntity> students=null;
		try {
			students=this.daoObject.loadAll(StudentEntity.class);
		}catch(Exception e) {
			System.out.println(e);
		}
		return students;
	}

	
	
	// method for adding student
	@Transactional
	public Integer addStudent(StudentEntity student) {
		// TODO Auto-generated method stub
		Integer generatedId=null;
//		System.out.println("in Doa class");
		try{
				generatedId=(Integer) this.daoObject.save(student);
		}catch(Exception e) {
			System.out.println(e+"Internal Application error! Please try again");
		}
		return generatedId;
	}

	
	
	//method for updating the student entity
	@Transactional
	public Integer update(int id, StudentEntity student) {
		// TODO Auto-generated method stub
		Integer updatedId=null;
		student.setStudentId(id);
		try {
			updatedId=(Integer)this.daoObject.save(student);
		}catch(Exception e) {
			System.out.println(e+"Please try again");
		}
		return updatedId;
	}

	
	//method for deleting student
	@Transactional
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		StudentEntity s=null;
		try {
		s=daoObject.load(StudentEntity.class, id);
			System.out.println("");
		}catch(Exception e) {
			System.out.println(e+"\nInvalid Id! Please Enter the valid id");
			return;
		}
		try {
			this.daoObject.delete(s);
			System.out.println("_____________________________________________________\n"
					+ "Student id deleted Successfully\n"
					+ "\n____________________________________________________");
		}catch(Exception e) {
			System.out.println("\\nInvalid Id! Please Enter the valid id");
		}
		
	}


	
}
