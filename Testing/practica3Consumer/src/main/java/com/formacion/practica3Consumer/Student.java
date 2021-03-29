package com.formacion.practica3Consumer;

public class Student {

	private int id; 
	private String name;
	
	
	
	public Student(int id, String name) {

		this.id = id;
		this.name = name;
	}
	public Student() {
	
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Student ["+ this.id +"] " + "Name: " + this.name + ". \n";
	} 
	
	
}
