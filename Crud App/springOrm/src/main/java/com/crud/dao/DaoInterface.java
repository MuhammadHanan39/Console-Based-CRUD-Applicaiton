package com.crud.dao;

import java.util.List;
import com.crud.entities.*;

public interface DaoInterface {

	// Method for getting one Student through given Id
		public StudentEntity getById(int id);
		
		
		//Method for getting all Students
		public List<StudentEntity> getAll();
		
		
		//Method for inserting the student
		public Integer addStudent(StudentEntity student);
		
		
		//Method for updating the student thorough given Id
		public Integer update(int id,StudentEntity student);
		
		
		//Method for delete through given id
		public void deleteStudent(StudentEntity student);
}
