package com.mrx_first.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "Student")
public class Student {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long stuid;

@Column(name = "stu_name")
private String stu_name;

@Column(name = "stu_rollno")
private int Stu_rollno;

@Column(name = "stu_email")
private String stu_email;

@Column(name = "stu_address")
private String stu_address;

public Long getStuid() {
	return stuid;
}

public void setStuid(Long stuid) {
	this.stuid = stuid;
}

public String getStu_name() {
	return stu_name;
}

public void setStu_name(String stu_name) {
	this.stu_name = stu_name;
}

public int getStu_rollno() {
	return Stu_rollno;
}

public void setStu_rollno(int stu_rollno) {
	Stu_rollno = stu_rollno;
}

public String getStu_email() {
	return stu_email;
}

public void setStu_email(String stu_email) {
	this.stu_email = stu_email;
}

public String getStu_address() {
	return stu_address;
}

public void setStu_address(String stu_address) {
	this.stu_address = stu_address;
}

public Student(Long stuid, String stu_name, int stu_rollno, String stu_email, String stu_address) {
	super();
	this.stuid = stuid;
	this.stu_name = stu_name;
	Stu_rollno = stu_rollno;
	this.stu_email = stu_email;
	this.stu_address = stu_address;
}

public Student()
{
	
}

@Override
public String toString() {
	return "Student [stuid=" + stuid + ", stu_name=" + stu_name + ", Stu_rollno=" + Stu_rollno + ", stu_email="
			+ stu_email + ", stu_address=" + stu_address + "]";
}
	

}
