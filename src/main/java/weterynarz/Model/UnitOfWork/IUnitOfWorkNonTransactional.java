package weterynarz.Model.UnitOfWork;

import org.hibernate.Session;

/**
 * Created by Uprzejmy on 2016-07-31.
 */
public interface IUnitOfWorkNonTransactional {
    Session getSession();
    void close();
}
