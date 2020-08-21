package com.ramazan.domain.employee;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "department_id")	
	private Long DepartmentId;
	
	@Column
	private String departmentName;
	
	//@ManyToOne(targetEntity = Location.class,fetch = FetchType.EAGER)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "location_id", foreignKey = @ForeignKey(foreignKeyDefinition = "location_fk "))
	private Location locatin;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "department")
	//mappedBy = "department --> employee tablosuna DepartmentId ekler
	private List<Employee> employees;
	/*
	 * Location ile department arasýnda bire-çok iliþki var 
	 * bir location -- çok department
	 * bir department -- bir location 
	 * 
	 * Department ile Employee arasýnda bire-çok iliþ var 
	 * bir department -- çok employee 
	 * bir employee -- bir department 
	 */
	
	public Department() {
		
	}

	public Department(String departmentName, Location locatin, List<Employee> employees) {
		
		this.departmentName = departmentName;
		this.locatin = locatin;
		this.employees = employees;
	}

	public Long getDepartmentId() {
		return DepartmentId;
	}

	public void setDepartmentId(Long departmentId) {
		DepartmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Location getLocatin() {
		return locatin;
	}

	public void setLocatin(Location locatin) {
		this.locatin = locatin;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((DepartmentId == null) ? 0 : DepartmentId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		if (DepartmentId == null) {
			if (other.DepartmentId != null)
				return false;
		} else if (!DepartmentId.equals(other.DepartmentId))
			return false;
		return true;
	}
	
	
}
