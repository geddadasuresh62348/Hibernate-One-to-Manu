package hibernate.advanced.CreateInstructorDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.advanced.Entity.Course;
import hibernate.advanced.Entity.Instructor;
import hibernate.advanced.Entity.InstructorDetails;

public class CreateCoursesDemo {

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
			// start a transaction
			session.beginTransaction();
			
			// get the instructor from db
			int theId=1;
			Instructor instructor=session.get(Instructor.class, theId);
			
			// create some courses
			Course course1=new Course("Java");
			Course course2=new Course("Springboot");
			
			// add courses to instructor
			instructor.add(course1);
			instructor.add(course2);
			
			// save the courses
			session.save(course1);
			session.save(course2);
			
			// commit transaction
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
	}
}
