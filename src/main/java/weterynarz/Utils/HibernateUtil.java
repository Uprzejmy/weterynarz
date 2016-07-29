package weterynarz.Utils;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Uprzejmy on 2016-07-29.
 */
public final class HibernateUtil {
    protected static SessionFactory _sessionFactory;

    static
    {
        try
        {
            _sessionFactory = new Configuration().configure().buildSessionFactory();
        }
        catch(HibernateException he)
        {
            System.out.println("Failed to build session factory");
            throw he;
        }
    }

    private HibernateUtil()
    {
    }

    public static Session openSession()
    {
        return _sessionFactory.openSession();
    }

}
