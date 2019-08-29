package practice.hiberate.models;

import lombok.Getter;
import lombok.Setter;
import practice.hiberate.excercises.EHeroSite;

import javax.persistence.*;

//one model into two tables

@Entity
@Table(name = "GameHeroData")
@SecondaryTable(name = "GameHeroPower")

public class GameHeroDivided {

    @Getter
    @Setter

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(table = "GameHeroData", name = "heroName", nullable = false)
    private String name;

    @Column(table = "GameHeroData", name = "heroRealName")
    private String realName;

    @Column(table = "GameHeroData", name = "heroAge")
    private int age;

    @Column(table = "GameHeroPower", name = "heroPower")
    private String power;

    @Column(table = "GameHeroPower", name = "whichSide", nullable = false)
    @Enumerated(EnumType.STRING)
    private EHeroSite heroSite;

    public GameHeroDivided() {
    }

    public GameHeroDivided(String name, String realName, int age, String power, EHeroSite heroSite) {
        this.name = name;
        this.realName = realName;
        this.age = age;
        this.power = power;
        this.heroSite = heroSite;
    }
}
