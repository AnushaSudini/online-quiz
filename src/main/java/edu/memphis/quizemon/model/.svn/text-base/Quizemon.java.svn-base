package edu.memphis.quizemon.model;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.Serializable;

public class Quizemon implements Cloneable, Serializable{
	
	private static final long serialVersionUID = 1L;

	private String name;
	private int price;
	private String rareness;
	private int weight;
	private String specialpower;
	private InputStream  image;
	
	public Quizemon(String name, int price, String rareness, int weight, String specialpower, InputStream imageStream) {
		this.setName(name);
		this.setPrice(price);
		this.setRareness(rareness);
		this.setWeight(weight);
		this.setSpecialpower(specialpower);
		this.setImage(imageStream);
	}
	
	public String getSpecialpower() { return specialpower; }
	public InputStream getImage() { return image; }
	public int getWeight() { return weight; }
	public String getRareness() { return rareness; }
	public int getPrice() { return price; }
	public String getName() { return name; }

	public void setSpecialpower(String specialpower) { this.specialpower = specialpower; }
	public void setImage(InputStream image) { this.image = image; }
	public void setWeight(int weight) { this.weight = weight; }
	public void setRareness(String rareness) { this.rareness = rareness; }
	public void setPrice(int price) { this.price = price; }
	public void setName(String name) { this.name = name; }
	
	public Object clone(){  
		try {
			return super.clone();  
		} catch (Exception e) { 
			return null;
		}
	}
}
