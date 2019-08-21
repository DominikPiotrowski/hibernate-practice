package sda.hiberate3.config.excercises;

import org.hibernate.Session;
import org.hibernate.query.Query;
import sda.hiberate3.config.HibernateUtils;

public class QueriesWithFunctions {

    public static void agregateQ1() {
        Session session = HibernateUtils.getHibernateSession();
        Query query = session.createQuery("SELECT COUNT(e) FROM User e");
        System.out.println(query.getSingleResult());
    }

    //tu zwracamy tablicę, od razu spraqdzamy kilka warunków

    public static void agregateQ2() {
        Session session = HibernateUtils.getHibernateSession();
        Query query = session.createQuery("SELECT MIN(e.id), MAX(e.id), AVG(e.id) FROM User e");

        Object[] results = (Object[]) query.getSingleResult();
        System.out.println("Min ID " + results[0]);
        System.out.println("Max ID " + results[1]);
        System.out.println("Average ID " + results[2]);
    }

    public static void lancuchyZnakow() {
        Session session = HibernateUtils.getHibernateSession();
        Query query = session.createQuery("SELECT substring(e.name, 1, 2), length(e.lastName) FROM User e WHERE e.name = 'Karol'");
        Object[] results = (Object[]) query.getSingleResult();
        System.out.println(results[0]);
        System.out.println(results[1]);

        //z przydatnych jeszcze: lower(), upper(), trim()
    }
}
