package weterynarz.Model;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UnitOfWork {
	
	private static SessionFactory _sessionFactory;
	
	private Session _session;
	
	private Transaction _transaction;
	
	static // blok static jest wykonywany tylko raz, przy pierwszym odwolaniu do klasy, chyba dobre miejsce, sprawdzic
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
	
	public UnitOfWork()
	{
		_session = _sessionFactory.openSession();	
	}
	
	public Session getSession()
	{
		return _session;
	}
	
	public void beginTransaction()
	{
		_transaction = _session.beginTransaction();
	}
	
	public void saveChanges()
    {
        try
        {
            if (_transaction != null)
                _transaction.commit();
        }
        catch(HibernateException he)
        {
        	System.out.println("Failed to commit transaction, rollbacking");
            if (_transaction != null)
                _transaction.rollback();
 
            throw he;
        }
        finally
        {
        	_session.close();
        }
    }
	
	public void discardChanges()
    {
        try
        {
            if (_transaction != null)
                _transaction.rollback();
        }
        catch(HibernateException he)
        {
        	System.out.println("Failed to discard changes");
        	throw he;
        }
        finally
        {
            _session.close();
        }
    }

}
