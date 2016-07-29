package weterynarz.Model.UnitOfWork;

/**
 * Created by Uprzejmy on 2016-07-29.
 */
public final class UnitOfWorkFactory {

    private UnitOfWorkFactory()
    {
    }

    public static IUnitOfWork createUnitOfWork(boolean transactional)
    {
        if(transactional)
        {
            return new UnitOfWorkTransactional();
        }

        return new UnitOfWorkNonTransactional();
    }

}
