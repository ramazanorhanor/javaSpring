package com.ramazan.domain.employee;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Location {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "location_id",nullable = false,unique = true)
	private Long locationId;
	
	@Column(length = 25)
	private String streetAddress;
	
	@Column(name ="postalCode" )
	private int postalCode;
	
	//eðer hiçbirþey girmezsek hinernate default deðer verir.
	private String city;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "location")
	// mappedBy = "location" --> department tablosuna locationId ekler
	private List<Department> departments;
/*
 * Location ile department arasýnda bire-çok iliþki var 
 * bir location -- çok department
 * bir department -- bir location
 */
	
	public Location() {
		
	}


	public Location(String streetAddress, int postalCode, String city) {
		
		this.streetAddress = streetAddress;
		this.postalCode = postalCode;
		this.city = city;
	}


	public Long getLocationId() {
		return locationId;
	}


	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}


	public String getStreetAddress() {
		return streetAddress;
	}


	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}


	public int getPostalCode() {
		return postalCode;
	}


	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public List<Department> getDepartments() {
		return departments;
	}


	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((locationId == null) ? 0 : locationId.hashCode());
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
		Location other = (Location) obj;
		if (locationId == null) {
			if (other.locationId != null)
				return false;
		} else if (!locationId.equals(other.locationId))
			return false;
		return true;
	}
	
	
}
/**
Category  ile Product  Arasýnda bire çok iliþki varsa 
Yani 1 category’nin birden çok elemaný var ise
Category Sýnýfýn’da bir tane Liste tanýmlarýz product için 

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

