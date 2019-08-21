package sda.hiberate3.config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

    //buduje sesję z bazą:

    private static final SessionFactory sf = new Configuration()
            .configure()
            .buildSessionFactory();

    //otwiera sesje z bazą:

    private static Session session = sf.openSession();

    public static Session getHibernateSession() {
        if (session == null) {
            session = (Session) new HibernateUtils();
        }
        return session;
    }
}