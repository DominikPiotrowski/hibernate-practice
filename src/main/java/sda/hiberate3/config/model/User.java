package sda.hiberate3.config.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {

    @Getter
    @Setter

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name, lastName;

    //relacja dwukierunkowa mozemy uzyskać dostęp dostęp do usera danej gry lub z drugiej strony do gier danego usera:

    @ManyToMany
    private Set<Game> games;


}
