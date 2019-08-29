package practice.hiberate.excercises;

import org.hibernate.Session;
import org.hibernate.query.Query;
import practice.hiberate.HibernateUtils;
import practice.hiberate.models.User;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Queries {

    public static void getAllUsers() {
        Session session = HibernateUtils.getHibernateSession();
        List<User> userList = session.createQuery("FROM " + User.class.getName()).list();

        System.out.println(userList.toString() + "\n");
    }

    public static void getUserByStaticLastName() {
        Session session = HibernateUtils.getHibernateSession();
        Query query = session.createQuery("SELECT u FROM User u WHERE u.lastName=:p");
        query.setParameter("p", "Piotrowski");

        System.out.println(query.getResultList().toString());
    }

    public static void getUserById(int id) {
        Session session = HibernateUtils.getHibernateSession();
        Query query = session.createQuery("SELECT u FROM User u WHERE u.id=:x");
        query.setParameter("x", id);

        System.out.println(query.getSingleResult().toString());
    }

    public static void getUserByStatus(Enum status) {
        Session session = HibernateUtils.getHibernateSession();
        TypedQuery<User> query = session.createQuery("SELECT u FROM User u WHERE u.activityStatus=:a ORDER BY id");
        query.setParameter("a", status);

        List<User> activeUsers = query.getResultList();

        for (User user : activeUsers) {
            System.out.println(user.getName());
            System.out.println(user.getLastName());
            System.out.println(user.getId());
        }
    }

    public static void getUserByStatusWithIterator(Enum status) {
        Session session = HibernateUtils.getHibernateSession();
        Query query = session.createQuery(
                "SELECT CONCAT(u.name, ' ', u.lastName, ' '), u.activityStatus FROM User u WHERE u.activityStatus=:a");
        query.setParameter("a", status);

        //iterator creates table of results
        Iterator<?> iterator = query.getResultList().iterator();

        //object to string and enum:
        while (iterator.hasNext()) {
            Object[] item = (Object[]) iterator.next();
            String firstAndLastName = (String) item[0]; //first table item
            Enum stat = (Enum) item[1]; //second table item
            System.out.println(firstAndLastName + stat);
        }
    }

    public static void getUserByIdRange(int minimumId, int maximumId) {
        Session session = HibernateUtils.getHibernateSession();
        Query query = session.createQuery("SELECT u FROM User u WHERE u.id > ?1 AND u.id < ?2");
        query.setParameter(1, minimumId);
        query.setParameter(2, maximumId);

        List<User> results = query.getResultList();

        results.forEach(x -> {
            x.getName();
            x.getLastName();
            x.getId();
        });
    }

    public static void getUserByNameList() {
        Session session = HibernateUtils.getHibernateSession();
        Query query = session.createQuery("SELECT u FROM User u WHERE u.lastName IN :names");

        List<String> names = new ArrayList<>();
        names.addAll(Arrays.asList("Marx", "Jankiel", "Puszek"));

        query.setParameter("names", names);

        List<User> results = query.getResultList();

        results.forEach(x -> {
            x.getName();
            x.getLastName();
        });
    }
}