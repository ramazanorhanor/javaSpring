package com.ramazan.domain.employee;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({
	@NamedQuery(name = "Employee.findAll",query = "select e from employee e"),
	@NamedQuery(name = "Employee.findFullById",query = "select e from employee e left outer fetch e.job left join fetch e.department where e.employeeId=: employeeId  "),
	@NamedQuery(name = "Employee.count",query = "select count(e) from Employee e ")
})

public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long employeeId;
	@Column
	private String firstName;
	@Column
	
	private String lastName;
	@Column
	private String email;
	@Column
	private String phoneNumber;
	@Temporal(TemporalType.DATE)
	@Column
	private Date hireDate;
	
	 @ManyToOne(fetch = FetchType.LAZY,targetEntity =Job.class )
	 @JoinColumn(name = "job_id",foreignKey = @ForeignKey(foreignKeyDefinition = "job_fk"))
	private Job job;
	 
	 @ManyToOne(fetch = FetchType.LAZY, targetEntity = Department.class)
	 @JoinColumn(name = "department_id",foreignKey = @ForeignKey(foreignKeyDefinition = "department_fk"))
	private Department department;
	
	/*
	 * job ile employee aras�nda bire �ok ili�ki var 
	 * bir employee bir job 
	 * bir job -- �ok employee
	 * 
	 * department ile employee aras�nda bire �ok ili�ki var 
	 * bir employee bir department 
	 * bir department -- �ok employee
	 */
	public Employee() {
		
	}
	public Employee(String firstName, String lastName, String email, String phoneNumber, Date hireDate, Job job,
			Department department) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.hireDate = hireDate;
		this.job = job;
		this.department = department;
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((employeeId == null) ? 0 : employeeId.hashCode());
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
		Employee other = (Employee) obj;
		if (employeeId == null) {
			if (other.employeeId != null)
				return false;
		} else if (!employeeId.equals(other.employeeId))
			return false;
		return true;
	}
	
	
}

/**
  Category  ile Product  Aras�nda bire �ok ili�ki varsa 
Yani 1 category�nin birden �ok eleman� var ise
Category S�n�f�n�da bir tane Liste tan�mlar�z product i�in 

      public class Category
    {
        public int Id { get; set; }
        public string Name { get; set; }

        public List<Product> Products { get; set; }
    }

      public class Product
    {
        public int Id { get; set; }
        public string Name { get; set; }
        public string ImageUrl { get; set; }
        public decimal Price { get; set; }

        public int CategoryId { get; set; }
        public Category Category { get; set; }
    }

 
 */

