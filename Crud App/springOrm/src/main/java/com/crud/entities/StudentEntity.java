package com.crud.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Student")
public class StudentEntity {


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int studentId;
	
	@Column
	private String studentName;
	
	@Column
	private String dept;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public StudentEntity(int studentId, String studentName, String dept) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.dept = dept;
	}

	public StudentEntity() {
		super();
	}

	@Override
	public String toString() {
		return "StudentEntity [studentId=" + studentId + ", studentName=" + studentName + ", dept=" + dept + "]";
	}
	
	
	
}
