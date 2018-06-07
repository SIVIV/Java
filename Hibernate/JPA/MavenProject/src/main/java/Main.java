import entities.Student;
import entities.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate_intro");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        //Teacher teacher = new Teacher("Boni","bonito_bonita@yahoo.com");
        //Teacher teacher2 = new Teacher("Soni","son_i@gmail.com");
        //em.persist(teacher);
        //em.persist(teacher2);

        Student s = em.find(Student.class, 1);
        boolean a = em.contains(s);
        if (a) System.out.println(s);
        else System.out.println("Not Found");

        Query query = em.createQuery("SELECT t FROM Teacher as t WHERE t.id=1");
        Query query2 = em.createQuery("SELECT t.name FROM Teacher as t WHERE t.id=1");
        Teacher t = (Teacher) query.getSingleResult();
        String t2 = (String)query2.getSingleResult();
        System.out.println(t);
        System.out.println(t2);
        //em.remove(s);

        em.getTransaction().commit();
    }
}
