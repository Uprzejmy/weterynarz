package weterynarz.Model.User;

import weterynarz.Context;
import weterynarz.EContexts;
import weterynarz.Model.IModel;

/**
 * Created by Uprzejmy on 2016-07-20.
 */
public interface IUserModel extends IModel {
    public Context loginUser(String email, String password);
    public Context registerUser(String email, String password, String name, String surname, String address, String phone, EContexts type);
}
