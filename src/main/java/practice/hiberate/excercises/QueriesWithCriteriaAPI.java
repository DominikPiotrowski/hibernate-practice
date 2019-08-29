package practice.hiberate.excercises;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import practice.hiberate.HibernateUtils;
import practice.hiberate.models.User;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import java.util.List;

public class QueriesWithCriteriaAPI {

    public static void getUserByNameCriteriaApi() {
        Session session = HibernateUtils.getHibernateSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);

        Root<User> root = criteriaQuery.from(User.class);
        Path<String> userName = root.get("name");

        criteriaQuery.select(root).where(builder.equal(userName, "Majkel"));

        TypedQuery<User> typedQuery = session.createQuery(criteriaQuery);

        List<User> resultList = typedQuery.getResultList();
        resultList.forEach(x -> System.out.println(x.toString()));
    }

    public static void getSingleUserByIdCriteriaApi() {
        Session session = HibernateUtils.getHibernateSession();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("id", 52));

        System.out.println(criteria.uniqueResult().toString());
    }

    public static void getUsersByLastNameCriteriaApi() {
        Session session = HibernateUtils.getHibernateSession();
        Criteria criteria = session.createCriteria(User.class);

        List<User> results = criteria.add(Restrictions.lt("lastName", "Filemon")).list();
        results.forEach(x -> System.out.println(x.toString()));
    }

    public static void getUserByIdMultiRestrictionsCriteriaApi() {
        Session session = HibernateUtils.getHibernateSession();
        Criteria criteria = session.createCriteria(User.class);

        List<User> results = criteria
                .add(Restrictions.le("id", 50)) //less or equal
                .add(Restrictions.ge("id",20)) //greater or equal
                .addOrder(Order.desc("id"))
                .list();

        results.forEach(x-> System.out.println(x.toString()));
    }

    public static void getUserByNameLikeCriteriaApi() {
        Session session = HibernateUtils.getHibernateSession();
        Criteria criteria = session.createCriteria(User.class);

        List<User> results = criteria
                .add(Restrictions.like("name", "Ol%"))
                .addOrder(Order.asc("id"))
                .list();

        results.forEach(x-> System.out.println(x.toString()));
    }

    public static void getUserByIdBetweenCriteriaApi() {
        Session session = HibernateUtils.getHibernateSession();
        Criteria criteria = session.createCriteria(User.class);

        List<User> results = criteria
                .add(Restrictions.between("id", 5, 50))
                .addOrder(Order.asc("id"))
                .list();

        results.forEach(x-> System.out.println(x.toString()));
    }

    public static void getUserByIdRestrictionsBetweenCriteriaApi() {
        Session session = HibernateUtils.getHibernateSession();
        Criteria criteria = session.createCriteria(User.class);

        List<User> results = criteria
                .add(Restrictions.or
                        (Restrictions.between("id", 5, 50),
                                Restrictions.between("id",60,100))).list();

        results.forEach(x-> System.out.println(x.toString()));
    }
}