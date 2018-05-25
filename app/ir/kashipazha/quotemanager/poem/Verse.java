package ir.kashipazha.quotemanager.poem;

import ir.kashipazha.commons.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.*;

@Entity
@Table(name = "verse")
public class Verse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "verse_pk", nullable = false, unique = true, updatable = false)
    private long id;

    @Column(name = "first", nullable = false)
    private String first;

    @Column(name = "last", nullable = false)
    private String last;

    Verse(String first, String last){
        this.first = first;
        this.last = last;
    }

    public Verse(){}
}
