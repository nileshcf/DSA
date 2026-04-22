package prac;

import lombok.Getter;
import lombok.Setter;

import java.util.*;
import java.util.stream.*;

@Getter
@Setter
class Employee {
	int  id;
	String name;
	int age;
	double salary;
	String dept;

	Employee(int id, String name, double salary, int age,  String dept) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.dept = dept;
	}

	@Override
	public String toString() {
		return name + " | Age: " + age + " | Salary: " + salary;
	}
}

