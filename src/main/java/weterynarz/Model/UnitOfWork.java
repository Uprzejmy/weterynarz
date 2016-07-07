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
	
	public UnitOfWork()
	{
		if(_sessionFactory == null)
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
		
	}

	public void save(Object object)
	{
		_session.save(object);
	}
	
	
	
	public void start()
	{
		_session = _sessionFactory.openSession();
		
		_transaction = _session.beginTransaction();
	}
	
	public void finalize()
	{
		_transaction.commit();
	    _session.close();
	}

}
