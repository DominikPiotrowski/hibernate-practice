package sda.hiberate3.config.excercises;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import sda.hiberate3.config.HibernateUtils;
import sda.hiberate3.config.model.User;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import java.util.List;

public class Queries_criteriaAPI {

//ZAPYTANIA Z CRITERIA API:

    public static void query7() {
        Session session = HibernateUtils.getHibernateSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);

        Root<User> root = criteriaQuery.from(User.class); //skąd
        Path<String> activityStatus = root.get("name"); //na jakiej kolumnie

        criteriaQuery.select(root).where(builder.equal(activityStatus, "Olo")); //co sprawdzamy

        TypedQuery<User> typedQuery = session.createQuery(criteriaQuery);

        List<User> resultList = typedQuery.getResultList();
        resultList.forEach(x -> System.out.println(x.toString()));
    }

    public static void query8() {
        Session session = HibernateUtils.getHibernateSession();

        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("id", 52));

        System.out.println(criteria.uniqueResult().toString());
    }

    public static void query9() {
        Session session = HibernateUtils.getHibernateSession();
        Criteria criteria = session.createCriteria(User.class);
        List<User> results = criteria.add(Restrictions.lt("id", 50)).list();
        results.forEach(x -> System.out.println(x.toString()));
    }

    public static void quer10() {
        Session session = HibernateUtils.getHibernateSession();
        Criteria criteria = session.createCriteria(User.class);
        List<User> results = criteria
                .add(Restrictions.le("id", 50)) //less than or equal
                .add(Restrictions.ge("id",20)) //laeger than or equal
                .addOrder(Order.desc("id")).list();

        results.forEach(x-> System.out.println(x.toString()));
    }
    public static void query11() {
        Session session = HibernateUtils.getHibernateSession();
        Criteria criteria = session.createCriteria(User.class);
        List<User> results = criteria
                .add(Restrictions.like("name", "Ol%"))
                .addOrder(Order.asc("id")).list();

        results.forEach(x-> System.out.println(x.toString()));
    }

    public static void query12() {
        Session session = HibernateUtils.getHibernateSession();
        Criteria criteria = session.createCriteria(User.class);
        List<User> results = criteria
                .add(Restrictions.between("id", 5, 50))
                .addOrder(Order.asc("id")).list();

        results.forEach(x-> System.out.println(x.toString()));
    }

    public static void query13() {
        Session session = HibernateUtils.getHibernateSession();
        Criteria criteria = session.createCriteria(User.class);
        List<User> results = criteria
                .add(Restrictions.or
                        (Restrictions.between("id", 5, 50),
                                Restrictions.between("id",60,100))).list();

        results.forEach(x-> System.out.println(x.toString()));
    }

}
