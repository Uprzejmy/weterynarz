package weterynarz.Model;

import weterynarz.Model.Patients.Patient;
import weterynarz.Model.Users.User;

import java.util.List;

/**
 * Created by Uprzejmy on 2016-07-20.
 */
public interface IClientModel extends IModel {
    public List<Patient> findPatientsByUser(User user);
    public void createPatient(User user,String name, String breed,String pawsNumber,String color);
}
