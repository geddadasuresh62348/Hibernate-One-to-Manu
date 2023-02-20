package hibernate.advanced.CreateInstructorDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.advanced.Entity.Course;
import hibernate.advanced.Entity.Instructor;
import hibernate.advanced.Entity.InstructorDetails;


public class CreateInstructorDemo {

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
			Instructor instructor=new Instructor("naveen","pusarla","naveenp111@gmail.com");
			
			InstructorDetails instructorDetails=new InstructorDetails 												("http://www.naveenp111@youtube.com","Reading Books....!");
			// associate the objects
			instructor.setInstructorDetails(instructorDetails);
			
			// start a transaction
			session.beginTransaction();
			
			// save the java object
			// Note :- this will also save the InstructordDetails object
			session.save(instructor);
			// commit transaction
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
	}
}
