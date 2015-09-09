package com.hand.POJO;

import java.sql.Timestamp;

public class Payment {
	private int payment_id;
	private int customer_id;
	private int rental_id;
	
public Payment(){}
	
	public Payment(int id,int customer_id ){
		this.payment_id=id;
		this.customer_id=customer_id;
	}

	
	public int getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}

	public int getRental_id() {
		return rental_id;
	}

	public void setRental_id(int rental_id) {
		this.rental_id = rental_id;
	}

	public int getId() {
		return payment_id;
	}

	public void setId(int id) {
		this.payment_id = id;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	
	
	
}
