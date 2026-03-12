package prac;

import java.util.*;
import java.util.stream.*;

class Employee {
	String name;
	int age;
	double salary;

	Employee(String name, int age, double salary) {
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return name + " | Age: " + age + " | Salary: " + salary;
	}
}

