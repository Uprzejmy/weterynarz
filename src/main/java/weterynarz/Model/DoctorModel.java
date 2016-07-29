package weterynarz.Model;

import weterynarz.Model.Doctors.Doctor;
import weterynarz.Model.Doctors.DoctorsRepository;
import weterynarz.Model.Doctors.IDoctorsRepository;
import weterynarz.Model.Users.User;

/**
 * Created by Uprzejmy on 2016-07-20.
 */
public class DoctorModel implements IDoctorModel {
    public Doctor findDoctorByUser(User user)
    {
        UnitOfWork unitOfWork = new UnitOfWork();

        IDoctorsRepository doctorsRepository = new DoctorsRepository(unitOfWork.getSession());
        Doctor doctor = doctorsRepository.findByUser(user);

        unitOfWork.saveChanges();

        if(doctor != null)
        {
            System.out.println("Doctor has been found");
            return doctor;
        }

        System.out.println("Couldn't find doctor");
        return null;
    }
}
