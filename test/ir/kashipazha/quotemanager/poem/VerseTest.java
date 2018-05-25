package ir.kashipazha.quotemanager.poem;

import ir.kashipazha.commons.HibernateUtil;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VerseTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void saveVerseToDB() {
        Verse v = new Verse("سلام", "سلام");

        Session session = HibernateUtil.sessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(v);
        session.getTransaction().commit();
    }
}