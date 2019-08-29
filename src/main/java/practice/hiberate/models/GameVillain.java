package practice.hiberate.models;

import javax.persistence.*;

// GameVillainPowers is @Embeded

@Entity
@Table(name = "GameVillain")
public class GameVillain {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "villainName")
    private String villainName;

    @Column(name = "villainRealName")
    private String villainRealName;

    @Embedded
    private GameVillainPowersEmbeded villainPowers;

    public GameVillain() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVillainName() {
        return villainName;
    }

    public void setVillainName(String villainName) {
        this.villainName = villainName;
    }

    public String getVillainRealName(String s) {
        return villainRealName;
    }

    public void setVillainRealName(String villainRealName) {
        this.villainRealName = villainRealName;
    }

    public GameVillainPowersEmbeded getVillainPowers() {
        return villainPowers;
    }

    public void setVillainPowers(GameVillainPowersEmbeded villainPowers) {
        this.villainPowers = villainPowers;
    }
}
