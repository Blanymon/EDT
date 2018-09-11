package calendar;

import com.sun.javafx.collections.SortableList;
import parser.ICSParser;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Event implements Comparable {

    private Date dateDebut;
    private Date dateFin;
    private String matiere;
    private String description;
    private String salle;

    public Event(Date dateDebut, Date dateFin,String matiere, String description, String salle) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.matiere = matiere;
        this.description = description;
        this.salle = salle;
    }

    @Override
    public String toString() {
        return "Event{\n" +
                "dateDebut=" + dateDebut +
                ",\n dateFin=" + dateFin +
                ",\n matiere='" + matiere + '\'' +
                ",\n description='" + description + '\'' +
                ",\n salle='" + salle + '\'' +
                "}\n";
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    @Override
    public int compareTo(Object event) {
        try {
            return this.dateDebut.compareTo(((Event)event).getDateDebut());
        } catch (NullPointerException e) {
            return -1;
        }

    }
}
