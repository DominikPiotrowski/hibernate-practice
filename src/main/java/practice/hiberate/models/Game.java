package practice.hiberate.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Game {

    @Getter
    @Setter

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "publisher", nullable = false)
    private String publisher;

    @Column(name = "price", nullable = false, precision = 6, scale = 2) //max 6 digits, two after coma
    private double price;

    @ManyToMany(mappedBy = "games")
    private Set<User> user;

    public Game() {
    }

    public Game(String name, String publisher, double price) {
        this.name = name;
        this.publisher = publisher;
        this.price = price;
    }
}