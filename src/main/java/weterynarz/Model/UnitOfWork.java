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

	public Session getSession()
	{
		System.out.println("Obtaining session");
		try //zmienic na try with resources
		{
			if (_session == null)
			{
				System.out.println("Session doesn't exists, opening new session");
				_session = _sessionFactory.openSession();
			}

			if(_transaction == null)
			{
				System.out.println("transaction doesn't exists, beginning new transaction");
				_transaction = _session.beginTransaction();
			}

			System.out.println("Got the session");
		}
		catch(HibernateException he)
		{
			System.out.println("Failed to get session");
			if (_transaction != null)
				_transaction.rollback();

			if(_session != null)
				_session.close();

			throw he;
		}

		return _session;
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
			if(_session != null)
				_session.close();

			_session = null;
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
    }

}
