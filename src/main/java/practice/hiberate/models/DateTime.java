package practice.hiberate.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity

public class DateTime {

    @Getter
    @Setter

    @Id
    private int id;

    @Temporal(TemporalType.DATE)
    private java.util.Date getGetUtilDate;

    @Temporal(TemporalType.TIME)
    private java.util.Date getUtilTime;

    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date getUtilTimestamp;
}