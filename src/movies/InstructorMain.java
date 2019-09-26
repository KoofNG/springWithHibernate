package movies;

import movies.models.Instructor;
import movies.models.InstructorDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InstructorMain {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try{
            Instructor instructor = new Instructor("Dapo", "Adeniji", "abne@gmail.com", 25);
            InstructorDetails instructorChannels = new InstructorDetails("More Gospel", "Reading and Programming");

            instructor.setInstructorDetailId(instructorChannels);
            session.beginTransaction();
            System.out.println("Saving instructorDetails: " + instructor);
            session.save(instructor);
            System.out.println("Saving instructorDetails: " + instructor);
            session.getTransaction().commit();
            System.out.println("Done!");
        } catch (Exception e) {
                e.printStackTrace();
        }
    }
}
