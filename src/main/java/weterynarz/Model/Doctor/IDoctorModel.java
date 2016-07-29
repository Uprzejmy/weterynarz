package weterynarz.Model.Doctor;

import weterynarz.Model.Entities.Doctors.Doctor;
import weterynarz.Model.Entities.Users.User;
import weterynarz.Model.IModel;

/**
 * Created by Uprzejmy on 2016-07-20.
 */
public interface IDoctorModel extends IModel {
    public Doctor findDoctorByUser(User user);
}
