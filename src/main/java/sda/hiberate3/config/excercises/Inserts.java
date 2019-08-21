package sda.hiberate3.config.excercises;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import sda.hiberate3.config.model.*;


public class Inserts {

    public static void insertUser(User user) {

        Session session = new Configuration().configure().buildSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(user);
        session.refresh(user);
        t.commit();
        session.close();
    }

    public static void insertGame(Game game) {

        Session session = new Configuration().configure().buildSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(game);
        t.commit();
        session.close();
    }

    public static void insertHero(GameHero_klasaRozdzielona gameHero) {
        Session session = new Configuration().configure().buildSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(gameHero);
        session.refresh(gameHero);
        t.commit();
        session.close();
    }

    public static void insertVillain(GameVillain gameVillain) {
        Session session = new Configuration().configure().buildSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(gameVillain);
        session.refresh(gameVillain);
        t.commit();
        session.close();
    }
}

