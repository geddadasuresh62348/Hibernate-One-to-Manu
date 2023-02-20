package hibernate.advanced.CreateInstructorDemo;

import java.util.Arrays;
import java.util.List;

import hibernate.advanced.Entity.Course;
import hibernate.advanced.Entity.Instructor;

public class Test {

	public static void main(String[] args) {
		Instructor instructor=new Instructor("harish","pullela","harishp789@gmail.com");
		
		Course course1=new Course("Python");
		Course course2=new Course("C");
		Course course3=new Course("C++");
		List<Course> courses=Arrays.asList(course1,course2,course3);
		instructor.setCourses(courses);
		System.out.println(instructor.getCourses());
		System.out.println(instructor.getFirstName());
	}

}
