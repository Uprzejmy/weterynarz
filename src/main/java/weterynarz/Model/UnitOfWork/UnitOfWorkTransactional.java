package weterynarz.Model.UnitOfWork;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;

public class UnitOfWorkTransactional extends UnitOfWorkNonTransactional implements IUnitOfWorkTransactional {

	protected Transaction _transaction;

	public Session getSession()
	{
		try //sprobowac zmienic na try with resources
		{
			if (_session == null)
			{
				_session = _sessionFactory.openSession();
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
            if (transactionExists())
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
            if (transactionExists())
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

	private boolean transactionExists()
	{
		return 	_transaction != null
				&& _transaction.isActive()
				&& _transaction.getStatus().isNotOneOf(TransactionStatus.COMMITTED,TransactionStatus.ROLLED_BACK);
	}

}
