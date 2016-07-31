package weterynarz.Model.UnitOfWork;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.boot.archive.scan.spi.PackageDescriptor;
import weterynarz.Utils.HibernateUtil;

/**
 * Created by Uprzejmy on 2016-07-29.
 */
public class UnitOfWorkNonTransactional implements IUnitOfWorkNonTransactional {
    protected Session _session;

    public Session getSession()
    {
        try //sprobowac zmienic na try with resources
        {
            if (_session == null)
            {
                _session = HibernateUtil.openSession();
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
