package sda.hiberate3.config.excercises;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import sda.hiberate3.config.HibernateUtils;
import sda.hiberate3.config.model.Game;

public class Deletes {

    public static void deleteGame(int id) {

        Session session = HibernateUtils.getHibernateSession();
        Transaction t = session.beginTransaction();

        Query query = session.createQuery("DELETE FROM Game WHERE id=:x");
        query.setParameter("x", id);
        query.executeUpdate();

        t.commit();
        session.close();
    }
}