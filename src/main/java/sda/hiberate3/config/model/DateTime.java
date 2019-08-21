package sda.hiberate3.config.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity

public class DateTime {

    @Getter
    @Setter

    @Id
    private int id;

    //można ustawic kolumny tabel tak:

//    private java.sql.Date date;
//    private java.sql.Time time;
//    private java.sql.Timestamp timestamp;

    //ale lepiej użyć adnotacji i pakietu util:

    @Temporal(TemporalType.DATE)
    private java.util.Date getGetUtilDate;

    @Temporal(TemporalType.TIME)
    private java.util.Date getUtilTime;

    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date getUtilTimestamp;

}
