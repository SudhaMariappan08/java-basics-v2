package com.tm.java.concept.dto;

import java.util.Objects;


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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return marks == student.marks && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, marks);
    }
    
    @Override
	public String toString() {
		return name + " (Marks: " + marks + ")";
	}

}
