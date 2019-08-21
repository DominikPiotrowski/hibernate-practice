package sda.hiberate3.config.model;

import lombok.Getter;
import lombok.Setter;
import sda.hiberate3.config.excercises.EHeroSite;

import javax.persistence.*;

/////////////ROZDZIELAMY JEDEN MODEL NA DWIE TABELE W BAZIE///////////

@Entity
@Table(name = "GameHeroData")
@SecondaryTable(name = "GameHeroPower")

public class GameHero_klasaRozdzielona {

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

    public GameHero_klasaRozdzielona() {
    }

    public GameHero_klasaRozdzielona(String name, String realName, int age, String power, EHeroSite heroSite) {
        this.name = name;
        this.realName = realName;
        this.age = age;
        this.power = power;
        this.heroSite = heroSite;
    }
}
