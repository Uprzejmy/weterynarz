package weterynarz.Model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UnitOfWork {
	
	SessionFactory _sessionFactory;
	
	Session _session;
	
	Transaction _transaction;
	
	public UnitOfWork()
	{
		_sessionFactory = new Configuration().configure().buildSessionFactory();
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
