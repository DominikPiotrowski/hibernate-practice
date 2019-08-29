package practice.hiberate.models;

import lombok.Getter;
import lombok.Setter;
import practice.hiberate.excercises.EActivity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class User {

    @Getter
    @Setter

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, length = 30)
    private String lastName;

    @Column(name = "activityStatus")
    @Enumerated(EnumType.STRING) // STRING = value, ORDINAL = according to field order in enum
    private EActivity activityStatus;

    //to omit column add " @Transient "

    //two way relation - can access games of user or user of a game
    @ManyToMany
    private Set<Game> games;

    public User() {
    }

    //ID is generated so skip it!
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
}