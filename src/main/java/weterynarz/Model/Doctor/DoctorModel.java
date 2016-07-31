package weterynarz.Model.Doctor;

import weterynarz.Model.Entities.Doctors.Doctor;
import weterynarz.Model.Entities.Doctors.DoctorsRepository;
import weterynarz.Model.Entities.Doctors.IDoctorsRepository;
import weterynarz.Model.Entities.Users.User;
import weterynarz.Model.UnitOfWork.IUnitOfWorkNonTransactional;
import weterynarz.Model.UnitOfWork.UnitOfWorkFactory;
import weterynarz.Model.UnitOfWork.UnitOfWorkNonTransactional;

/**
 * Created by Uprzejmy on 2016-07-20.
 */
public class DoctorModel implements IDoctorModel {
    public Doctor findDoctorByUser(User user)
    {
        IUnitOfWorkNonTransactional uow = (UnitOfWorkNonTransactional) UnitOfWorkFactory.createUnitOfWork(false);

        IDoctorsRepository doctorsRepository = new DoctorsRepository(uow.getSession());
        Doctor doctor = doctorsRepository.findByUser(user);

        uow.close();

        if(doctor != null)
        {
            System.out.println("Doctor has been found");
            return doctor;
        }

        System.out.println("Couldn't find doctor");
        return null;
    }
}
