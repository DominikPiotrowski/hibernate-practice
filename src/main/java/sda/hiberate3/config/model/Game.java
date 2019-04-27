package sda.hiberate3.config.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Game {

    @Getter
    @Setter

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name, publisher;
    private double price;

    @ManyToMany(mappedBy = "games")
    private Set<User> user;
}
