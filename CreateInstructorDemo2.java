package hibernate.advanced.CreateInstructorDemo;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.advanced.Entity.Course;
import hibernate.advanced.Entity.Instructor;
import hibernate.advanced.Entity.InstructorDetails;


public class CreateInstructorDemo2 {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory=new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetails.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		// create session
		Session session=factory.getCurrentSession();
		
		try {			
			// create a instructor object
			Instructor instructor=new Instructor("Faheem","mohammad","faheemM45@gmail.com");
			
			InstructorDetails instructorDetails=new InstructorDetails 	
					("http://www.FaheemMohammad@youtube.com","Playing tennis....!");
			
			Course course1=new Course("Java");
			Course course2=new Course("Python");
			Course course3=new Course("C");
			List<Course> courses=Arrays.asList(course1,course2,course3);
			
			// associate the objects
			instructor.setInstructorDetails(instructorDetails);
//			instructor.setCourses(courses);
//			instructor.add(course1);
//			instructor.add(course2);
			
//			course1.setInstructor(instructor);
//			course2.setInstructor(instructor);
//			course3.setInstructor(instructor);
			
			// list of courses
			instructor.addCourse(courses, instructor);
			
			// start a transaction
			session.beginTransaction();
			
			// save the java object
			// Note :- this will also save the InstructordDetails object
			session.save(instructor);
			session.save(instructorDetails);
			session.save(course1);
			session.save(course2);
			session.save(course3);
			
			// commit transaction
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
	}
}
