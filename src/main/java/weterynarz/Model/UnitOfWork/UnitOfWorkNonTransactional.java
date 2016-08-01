package weterynarz.Model.UnitOfWork;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Uprzejmy on 2016-07-29.
 */
public class UnitOfWorkNonTransactional implements IUnitOfWorkNonTransactional {

    protected static SessionFactory _sessionFactory;
    protected Session _session;

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

    public Session getSession()
    {
        try //sprobowac zmienic na try with resources
        {
            if (_session == null)
            {
                _session = _sessionFactory.openSession();
            }
        }
        catch(HibernateException he)
        {
            if(_session != null)
                _session.close();

            _session = null;

            throw he;
        }

        return _session;
    }

    public void close()
    {
        try
        {
            if(_session != null)
                _session.close();

            _session = null;
        }
        catch(HibernateException he)
        {
            throw he;
        }
    }
}
