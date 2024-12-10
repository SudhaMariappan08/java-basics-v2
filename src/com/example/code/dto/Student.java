package com.example.code.dto;

public class Student {

	private String name;
	private int marks;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public Student(String name, int marks) {
		super();
		this.name = name;
		this.marks = marks;
	}
	
	@Override
    public String toString() {
        return name + " (Marks: " + marks + ")";
    }
	
}
