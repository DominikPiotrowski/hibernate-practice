package practice.hiberate.models;

import javax.persistence.Embeddable;

@Embeddable
public class GameVillainPowersEmbeded {
    public String villainPowers;
    public String villainStrength;

    public String getVillainPowers() {
        return villainPowers;
    }

    public void setVillainPowers(String villainPowers) {
        this.villainPowers = villainPowers;
    }

    public String getVillainStrength() {
        return villainStrength;
    }

    public void setVillainStrength(String villainStrenght) {
        this.villainStrength = villainStrenght;
    }
}