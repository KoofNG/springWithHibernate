package movies;

import movies.models.Course;
import movies.models.Instructor;
import movies.models.InstructorDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class InstructorMain {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try{
            int theID = 15;
            session.beginTransaction();

            Instructor tempInstructor = session.get(Instructor.class, theID);
            List<Course> coursesList = tempInstructor.getCourses();

            for (Course e: coursesList) {
                System.out.println(e.getId() + " " + e.getTitle() + " " );
            }
            session.getTransaction().commit();
        } catch (Exception e) {
                e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
