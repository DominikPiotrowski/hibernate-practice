package sda.hiberate3.config;

import org.hibernate.Session;
import sda.hiberate3.config.excercises.*;

public class App {
    public static void main(String[] args) {

        Session session = HibernateUtils.getHibernateSession();

        //klasy dostały własne sesje więc nie ma potrzeby otwerania nowej///////
//
//        Queries.query1();
//        Queries.query2();
//        Queries.query3(1);
//        Queries.query4(EActivity.ACTIVE);
//        Queries.query41(EActivity.NONACTIVE);
//       Queries.query42(EActivity.ACTIVE);
//        Queries.query5(2,55);
//        Queries.query6();
//            QueriesWithFunctions.agregateQ1();
//            QueriesWithFunctions.agregateQ2();
//            QueriesWithFunctions.lancuchyZnakow();

//            Queries_criteriaAPI.query7();
//        Queries_criteriaAPI.query8();
//        Queries_criteriaAPI.query9();
//        Queries_criteriaAPI.quer10();
//        Queries_criteriaAPI.query11();
        Queries_criteriaAPI.query12();

//        User user1 = new User("Majkel", "Jankiel", EActivity.ACTIVE);
//        User user2 = new User("Kot", "Filemon", EActivity.BANNED);
//        User user3 = new User("Pies", "Puszek", EActivity.NONACTIVE);
//
//        Inserts.insertUser(user1);
//        Inserts.insertUser(user2);
//        Inserts.insertUser(user3);


//        Game game1 = new Game("Star Wars","Publish this Shit",60.90);
//        Game game2 = new Game("Star Wars 98","Publish this Shit",90.90);
//
//        Inserts.insertGame(game1);
//        Inserts.insertGame(game2);

//        Deletes.deleteGame(2);

//        GameHero_klasaRozdzielona hero1 = new GameHero_klasaRozdzielona("Batman", "BruceWayne",40,"BatPowers",EHeroSite.BRIGHT);
//        GameHero_klasaRozdzielona hero2 = new GameHero_klasaRozdzielona("Joker",null,45,"Jokes",EHeroSite.DARK);
//
//        Inserts.insertHero(hero1);
//        Inserts.insertHero(hero2);

        //do klasy osadzonej, tworzymy dwie instancje 'villain' i villainPowers
        //hibernate połączy je w jedną tabelę
//
//        GameVillain villain1 = new GameVillain();
//        GameVillainPowers_klasaOsadzona villainPowers1 = new GameVillainPowers_klasaOsadzona();
//
//        villain1.setVillainName("B.A.");
//        villain1.getVillainRealName("Mr.T");
//        villain1.setVillainPowers(villainPowers1);
//        villainPowers1.setVillainPowers("Biceps");
//        villainPowers1.setVillainStrenght("Strong");
//
//        //wystarczy insert do klasy nadrzednej, zagniezdzona już wejdzie w jej skład
//        Inserts.insertVillain(villain1);
    }
}

