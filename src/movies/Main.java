package movies;

import movies.models.Customers;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            System.out.println("connecting to db");
            Customers newCustomer = new Customers("israel", "akpan", LocalDate.of(2003,2,4), true);
            session.beginTransaction();
            session.save(newCustomer);
            session.getTransaction().commit();
            System.out.println("connected successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
