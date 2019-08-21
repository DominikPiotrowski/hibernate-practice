package sda.hiberate3.config.model;

import lombok.Getter;
import lombok.Setter;
import sda.hiberate3.config.excercises.EActivity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "User")  // atrybut domyślnie taki jak nazwa klasy modelu, ale można zmienić
                        // jeśłi zmieniony, to taki bedzie trzeba wpisywać do zapytań JPQL/HQL
                        // i UWAGA - tala bedzie nazwa tabeli w bazie SQL
@Table
//tu też można nazwać name i działa tak samo, ale tylko nadaje nazwę tabeli, nie wpływa na nazwę encji w zapytaniach

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //to generuje ID automatycznie
    private int id;

    //jeśli nie podamy 'name' zostanie taka jak nazwa pola

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, length = 30)
    private String lastName;

    @Column(name = "activityStatus")
    @Enumerated(EnumType.STRING) // STRING wrzuci wartość, ORDINAL kolejność wybranego pola enuma
    private EActivity activityStatus;

    //to było tylko do stworzenia komuny, w SQL jest trigger ktory dodaje do tego pola 4
    //za każdym dodanie usera do bazy

//    @Column(name = "numberOfGames")
//    private int numberOfGames;

    //UWAGA jeśłi chcesz pominąć kolumnę adnotacja  " @Transient "

    //relacja dwukierunkowa mozemy uzyskać dostęp do usera danej gry lub z drugiej strony do gier danego usera:

    @ManyToMany
    private Set<Game> games;

    //bezparametrowy
    public User() {
    }

    //z tymi polami ktore chcesz stworzyć, UWAGA Id jest autonumerowane więc pomiń w konstruktorze

    public User(String name, String lastName, EActivity activityStatus) {
        this.name = name;
        this.lastName = lastName;
        this.activityStatus = activityStatus;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", activityStatus=" + activityStatus +
                ", games=" + games +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public EActivity getActivityStatus() {
        return activityStatus;
    }

    public void setActivityStatus(EActivity activityStatus) {
        this.activityStatus = activityStatus;
    }

    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }
}