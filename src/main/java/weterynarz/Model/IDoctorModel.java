package weterynarz.Model;

import weterynarz.Model.Doctors.Doctor;
import weterynarz.Model.Users.User;

/**
 * Created by Uprzejmy on 2016-07-20.
 */
public interface IDoctorModel extends IModel {
    public Doctor findDoctorByUser(User user);
}
