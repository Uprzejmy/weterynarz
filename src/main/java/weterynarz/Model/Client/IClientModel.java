package weterynarz.Model.Client;

import weterynarz.Model.Entities.Patients.Patient;
import weterynarz.Model.Entities.Users.User;
import weterynarz.Model.IModel;

import java.util.List;

/**
 * Created by Uprzejmy on 2016-07-20.
 */
public interface IClientModel extends IModel {
    public List<Patient> findPatientsByUser(User user);
    public void createPatient(User user,String name, String breed,String pawsNumber,String color);
}
