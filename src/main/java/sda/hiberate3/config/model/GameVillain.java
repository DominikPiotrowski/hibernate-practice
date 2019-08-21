package sda.hiberate3.config.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

////////klasa GameVillainPowers jest teraz osadzona-- @Embedable - @Embeded///////////

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
    private GameVillainPowers_klasaOsadzona villainPowers;

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

    public GameVillainPowers_klasaOsadzona getVillainPowers() {
        return villainPowers;
    }

    public void setVillainPowers(GameVillainPowers_klasaOsadzona villainPowers) {
        this.villainPowers = villainPowers;
    }
}
