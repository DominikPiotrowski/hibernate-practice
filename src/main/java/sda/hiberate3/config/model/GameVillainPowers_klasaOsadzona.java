package sda.hiberate3.config.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
public class GameVillainPowers_klasaOsadzona {

    public String villainPowers;
    public String villainStrenght;

    public String getVillainPowers() {
        return villainPowers;
    }

    public void setVillainPowers(String villainPowers) {
        this.villainPowers = villainPowers;
    }

    public String getVillainStrenght() {
        return villainStrenght;
    }

    public void setVillainStrenght(String villainStrenght) {
        this.villainStrenght = villainStrenght;
    }
}