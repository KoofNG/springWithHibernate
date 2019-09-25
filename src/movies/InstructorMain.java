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
            Instructor popoola = new Instructor("Joshua", "Popoola", "jjpopola@futa.edu.ng", 56);
            InstructorDetails popChannels = new InstructorDetails("Circuit Analysis", "Teaching and Preaching");

            popoola.setInstructorDetailId(popChannels);

            session.beginTransaction();
            System.out.println("Saving instructor: " + popoola);
            session.save(popoola);
            session.getTransaction().commit();
            System.out.println("Done!");
        } catch (Exception e) {
                e.printStackTrace();
        }
    }
}
