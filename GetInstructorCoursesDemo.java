package hibernate.advanced.GetAndDeleteInstructor.Demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.advanced.Entity.Course;
import hibernate.advanced.Entity.Instructor;
import hibernate.advanced.Entity.InstructorDetails;


public class GetInstructorCoursesDemo {

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
			
			System.out.println(" Instructor : "+instructor);
			System.out.println(" Courses : "+instructor.getCourses());
			
			// commit transaction
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
	}
}
