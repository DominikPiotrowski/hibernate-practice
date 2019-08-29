package practice.hiberate;

import practice.hiberate.excercises.*;
import practice.hiberate.models.*;

public class App {
    public static void main(String[] args) {

        User user1 = new User("Majkel", "Jankiel", EActivity.ACTIVE);
        User user2 = new User("Kot", "Filemon", EActivity.BANNED);
        User user3 = new User("Pies", "Puszek", EActivity.NONACTIVE);

        Queries.getAllUsers();
        Queries.getUserByStaticLastName();
        Queries.getUserById(1);
        Queries.getUserByStatus(EActivity.ACTIVE);
        Queries.getUserByStatusWithIterator(EActivity.ACTIVE);
        Queries.getUserByIdRange(2, 55);
        Queries.getUserByNameList();

        QueriesWithFunctions.agregateQuery1();
        QueriesWithFunctions.agregateQuery2();
        QueriesWithFunctions.lancuchyZnakow();

        QueriesWithCriteriaAPI.getUserByNameCriteriaApi();
        QueriesWithCriteriaAPI.getSingleUserByIdCriteriaApi();
        QueriesWithCriteriaAPI.getUsersByLastNameCriteriaApi();
        QueriesWithCriteriaAPI.getUserByIdMultiRestrictionsCriteriaApi();
        QueriesWithCriteriaAPI.getUserByNameLikeCriteriaApi();
        QueriesWithCriteriaAPI.getUserByIdBetweenCriteriaApi();
        QueriesWithCriteriaAPI.getUserByIdRestrictionsBetweenCriteriaApi();

        Inserts.insertUser(user1);
        Inserts.insertUser(user2);
        Inserts.insertUser(user3);

        Game game1 = new Game("Star Wars", "Publisher one", 60.90);
        Game game2 = new Game("Star Wars 98", "Publisher two", 90.90);

        Inserts.insertGame(game1);
        Inserts.insertGame(game2);

        Deletes.deleteGame(2);

        GameHeroDivided hero1 = new GameHeroDivided("Batman", "BruceWayne", 40, "BatPowers", EHeroSite.BRIGHT);
        GameHeroDivided hero2 = new GameHeroDivided("Joker", null, 45, "Jokes", EHeroSite.DARK);

        Inserts.insertHero(hero1);
        Inserts.insertHero(hero2);

        //hibernate will connect these into one table
        GameVillain villain1 = new GameVillain();
        GameVillainPowersEmbeded villainPowers1 = new GameVillainPowersEmbeded();

        villain1.setVillainName("B.A.");
        villain1.setVillainRealName("Mr.T");

        villain1.setVillainPowers(villainPowers1);
        villainPowers1.setVillainPowers("Biceps");
        villainPowers1.setVillainStrength("Strong");

        //insert into villain, embeded class will insert along with it
        Inserts.insertVillain(villain1);
    }
}