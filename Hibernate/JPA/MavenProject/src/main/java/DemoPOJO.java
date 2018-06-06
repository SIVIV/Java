import entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.util.List;

public class DemoPOJO {

    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure();
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

// Your Code Here
        Student joro = new Student("Joro", LocalDate.parse("2018-03-18"));
        session.save(joro);
        Student ivan = new Student("Ivan", LocalDate.parse("2017-11-24"));
        session.save(ivan);
        Student maria = new Student("Maria", LocalDate.parse("2068-01-11"));
        session.save(maria);
        Student stoyan = new Student("Stoyan", LocalDate.parse("2017-01-07"));
        session.save(stoyan);


        List<Student> studentList = session.createQuery("FROM Student WHERE name = 'Stoyan'").list();
        for (Student student : studentList) {
            System.out.println(student.getName());
        }
        session.getTransaction().commit();
        session.close();

    }
}