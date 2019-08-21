package sda.hiberate3.config.excercises;

import org.hibernate.Session;
import org.hibernate.query.Query;
import sda.hiberate3.config.HibernateUtils;
import sda.hiberate3.config.model.User;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Queries {

    public static void query1() {

        Session session = HibernateUtils.getHibernateSession();

        List<User> userList = session.createQuery("FROM " + User.class.getName()).list();
        System.out.println(userList.toString() + "\n");
    }

    public static void query2() {

        Session session = HibernateUtils.getHibernateSession();

        Query query = session.createQuery("SELECT u FROM User u WHERE u.lastName=:p");
        query.setParameter("p", "Piotrowski");

//        List results = query.list();
//        System.out.println(results);

        //albo od razu:
        System.out.println(query.getResultList().toString());
    }

    public static void query3(int id) {

        Session session = HibernateUtils.getHibernateSession();
        Query query = session.createQuery("SELECT u FROM User u WHERE u.id=:x");
        query.setParameter("x", id);
        System.out.println(query.getSingleResult().toString());
    }

    public static void query4(Enum status) {
        Session session = HibernateUtils.getHibernateSession();
        Query query = session.createQuery("SELECT u FROM User u WHERE u.activityStatus=:a");
        query.setParameter("a", status);
        System.out.println(query.getResultList().toString());
    }

////////////// query4 z printem do konsoli:

    public static void query41(Enum status) {
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

//////////////wersja z iteratorem:

    public static void query42(Enum status) {
        Session session = HibernateUtils.getHibernateSession();
        Query query = session.createQuery("SELECT CONCAT(u.name, ' ', u.lastName, ' '), u.activityStatus FROM User u WHERE u.activityStatus=:a");
        query.setParameter("a", status);

        //iterator po rezultatach tworzy tablicę obiektów nie wiemy jakiego typu

        Iterator<?> iterator = query.getResultList().iterator();

        //pętla z rzutowaniem typu obiekt na string

        while (iterator.hasNext()) {
            Object[] item = (Object[]) iterator.next();
            String name = (String) item[0]; //pierwszy item w tablicy to imię
            Enum stat = (Enum) item[1]; //drugi to enum status
            System.out.println(name + stat);
        }

    }

/////////////zapytanie z dwoma parametrami:

    public static void query5(int minimumId, int maximumId) {
        Session session = HibernateUtils.getHibernateSession();
        Query query = session.createQuery("SELECT u FROM User u WHERE u.id > ?1 AND u.id < ?2");
        query.setParameter(1, minimumId);
        query.setParameter(2, maximumId);

        List<User> results = query.getResultList();

//        for (User user : results) {
//            System.out.println(user.getName() + " " + user.getLastName() + " " + user.getId());
//        }
        results.forEach(x -> {
            x.getName();
            x.getLastName();
            x.getId();
        });
    }

/////////////zapytanie z listą parametrów:

    public static void query6() {
        Session session = HibernateUtils.getHibernateSession();
        Query query = session.createQuery("SELECT u FROM User u WHERE u.lastName IN :names");

        List<String> names = new ArrayList<>();
        names.add("Marx");
        names.add("Jankiel");
        names.add("Puszek");
        query.setParameter("names", names);

        List<User> results = query.getResultList();
//        for (User user : results) {
//            System.out.println(user.getName() + " " + user.getLastName());

        results.forEach(x -> {
            x.getName();
            x.getLastName();
        });
    }
}