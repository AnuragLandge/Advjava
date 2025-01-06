package com.demo.beans;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Hibernate_Employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empId;
	private String empName;
	private double empSal;
	private LocalDate doj;
	@ManyToOne(fetch = FetchType.LAZY)
	Department dept;

	public Employee() {
		super();
	}

	public Employee(String empName, double empSal, LocalDate doj, Department dept) {
		super();
		this.empName = empName;
		this.empSal = empSal;
		this.doj = doj;
		this.dept = dept;
	}

	public Employee(int empId, String empName, double empSal, LocalDate doj, Department dept) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSal = empSal;
		this.doj = doj;
		this.dept = dept;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public double getEmpSal() {
		return empSal;
	}

	public void setEmpSal(double empSal) {
		this.empSal = empSal;
	}

	public LocalDate getDoj() {
		return doj;
	}

	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSal=" + empSal + ", doj=" + doj + ", dept="
				+ dept + "]";
	}

}
