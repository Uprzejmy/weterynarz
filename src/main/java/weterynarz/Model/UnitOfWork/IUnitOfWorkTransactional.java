package weterynarz.Model.UnitOfWork;

/**
 * Created by Uprzejmy on 2016-07-31.
 */
public interface IUnitOfWorkTransactional extends IUnitOfWorkNonTransactional {
    void saveChanges();
    void discardChanges();
}
