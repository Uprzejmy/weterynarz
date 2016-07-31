package weterynarz.Model.UnitOfWork;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import weterynarz.Utils.HibernateUtil;

public class UnitOfWorkTransactional extends UnitOfWorkNonTransactional implements IUnitOfWorkTransactional {

	protected Transaction _transaction;

	public Session getSession()
	{
		try //sprobowac zmienic na try with resources
		{
			if (_session == null)
			{
				_session = HibernateUtil.openSession();
			}

			if(_transaction == null)
			{
				_transaction = _session.beginTransaction();
			}
		}
		catch(HibernateException he)
		{
			if (_transaction != null)
				_transaction.rollback();

			if(_session != null)
				_session.close();

			_transaction = null;
			_session = null;

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
            if (_transaction != null)
                _transaction.rollback();

            throw he;
        }
		finally
		{
			if(_session != null)
				_session.close();

			_transaction = null;
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
			throw he;
		}
		finally
		{
			if(_session != null)
				_session.close();

			_transaction = null;
			_session = null;
		}
    }

	public void close()
	{
		discardChanges();
	}

}
