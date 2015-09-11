package com.hand.POJO;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Repository;

@Repository
@Entity
@Table(name="address")
public class Address {
//	@Id  
//	@GeneratedValue
//	 @Column(name="address_id")
	private int address_id;
//	@Column(name="address")
	private String address;
	
	public Address(){}

	public Address(int address_id, String address){
		this.address_id=address_id;
		this.address=address;
	}

	@Id  
	@GeneratedValue(strategy = GenerationType.AUTO) 
//	 @Column(name="address_id")
	public int getAddress_id() {
		return address_id;
	}
	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}
	@Column(name="address")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
