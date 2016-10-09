package com.post.bean;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import com.post.formbean.FeedBackFormBean;
import com.sun.org.apache.commons.beanutils.BeanUtils;

public class FeedbackTo {

	
private String feedback;
	
	private String name;
	private String address;
	private String email;
	private String city;
	private String country;
	private String occupation;
	
	private int pin;
	
	private int fid;
	
	
	
	
	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public FeedbackTo(){
		
		
		
		
	}
	
	public FeedbackTo(FeedBackFormBean fb){
		
		

		   try{
				Map  map= BeanUtils.describe(fb);
				BeanUtils.populate(this, map);
			}
			catch (IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InvocationTargetException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	
	
	
	
	
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}
	
	
	
}
