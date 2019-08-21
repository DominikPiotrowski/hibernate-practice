package sda.hiberate3.config.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Cart {

    @Id
    private int id;

    @ManyToOne
    private User user;

    @ManyToOne
    private  Game game;

}
