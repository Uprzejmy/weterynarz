package weterynarz.Model;

import weterynarz.Context;
import weterynarz.EContexts;
import weterynarz.Model.Clients.Client;
import weterynarz.Model.Clients.ClientsRepository;
import weterynarz.Model.Clients.IClientsRepository;
import weterynarz.Model.Doctors.Doctor;
import weterynarz.Model.Doctors.DoctorsRepository;
import weterynarz.Model.Doctors.IDoctorsRepository;
import weterynarz.Model.Users.IUsersManager;
import weterynarz.Model.Users.User;
import weterynarz.Model.Users.UsersManager;

/**
 * Created by Uprzejmy on 2016-07-20.
 */
public class UserModel implements IUserModel {
    public Context registerUser(String email, String password, String name, String surname, String address, String phone, EContexts type)
    {
        UnitOfWork unitOfWork = new UnitOfWork();

        IUsersManager usersManager = new UsersManager(unitOfWork.getSession());
        User user = usersManager.register(email,password);

        switch(type)
        {
            case DOCTOR:
            {
                System.out.println("Registering doctor");
                IDoctorsRepository doctorsRepository = new DoctorsRepository(unitOfWork.getSession());
                Doctor doctor = new Doctor(name,surname,address,phone);
                doctor.setUser(user);
                doctorsRepository.add(doctor);
                break;
            }
            case CLIENT:
            {
                System.out.println("Registering client");
                IClientsRepository clientsRepository = new ClientsRepository(unitOfWork.getSession());
                Client client = new Client(name,surname,address,phone);
                client.setUser(user);
                clientsRepository.add(client);
                break;
            }
            default:
            {
                unitOfWork.discardChanges();
                throw new RuntimeException("Unsupported user type");
            }

        }

        unitOfWork.saveChanges();
        //registration is done, now login part

        if(user == null)
        {
            System.out.println("Couldn't register user, try different email");
            return null;
        }

        System.out.println("Registration successful");
        return new Context(user,type);
    }

    public Context loginUser(String email, String password)
    {
        UnitOfWork unitOfWork = new UnitOfWork();

        IUsersManager usersManager = new UsersManager(unitOfWork.getSession());
        User user = usersManager.login(email,password);

        if(user == null)
        {
            System.out.println("Couldn't log in, incorrect email or password");
            return null;
        }

        System.out.println("User logged in correctly");
        EContexts type = usersManager.getUserType(user);
        unitOfWork.saveChanges();
        return new Context(user,type);


    }
}
