package ir.kashipazha.commons;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import static org.hibernate.boot.registry.StandardServiceRegistryBuilder.DEFAULT_CFG_RESOURCE_NAME;
import static org.hibernate.boot.registry.StandardServiceRegistryBuilder.destroy;

/**
 * please set SessionFactory in @see Application#init() before using
 * sessionFactory()
 *
 * @author yoones
 */

@SuppressWarnings("unused")
public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static synchronized void resetFactory() {
        if (sessionFactory == null) return;
        if (!sessionFactory.isClosed()) sessionFactory.close();
        sessionFactory = null;
    }

    public static synchronized SessionFactory rawSessionFactory() {
        return sessionFactory;
    }

    /**
     * @return the sessionFactory
     */
    public static synchronized SessionFactory sessionFactory() {
        return sessionFactory(DEFAULT_CFG_RESOURCE_NAME);
    }

    /**
     * @return the sessionFactory
     */
    public static synchronized SessionFactory sessionFactory(String resourceName) {
        return sessionFactory == null ? sessionFactory = init(resourceName) : sessionFactory;
    }

    public static synchronized void setSessionFactory(SessionFactory factory) {
        sessionFactory = factory;
    }

    private static synchronized SessionFactory init(String resourceName) {
        if (sessionFactory != null) return sessionFactory;
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure(resourceName) // configures settings from hibernate.cfg.xml
            .build();
        try{
            sessionFactory=new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch(Exception e){
            destroy(registry);
        }
        return sessionFactory;
    }
}
