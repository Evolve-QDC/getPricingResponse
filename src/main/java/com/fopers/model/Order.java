package com.fopers.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "ts_hs_key")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	private String apikey;
	
	public String getId() {
		return id;
	}
	public void setId(String Id) {
		this.id = Id;
	}
	
	public String getApikey() {
		return apikey;
	}
	public void setApikey(String apikey) {
		this.apikey = apikey;
	}
	public Order() {

	}
	
	@Override 
	public String toString() {
		return " api key ="+apikey;
	}
}
