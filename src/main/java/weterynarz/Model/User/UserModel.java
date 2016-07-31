package weterynarz.Model.User;

import weterynarz.Context;
import weterynarz.EContexts;
import weterynarz.Model.Entities.Clients.Client;
import weterynarz.Model.Entities.Clients.ClientsRepository;
import weterynarz.Model.Entities.Clients.IClientsRepository;
import weterynarz.Model.Entities.Doctors.Doctor;
import weterynarz.Model.Entities.Doctors.DoctorsRepository;
import weterynarz.Model.Entities.Doctors.IDoctorsRepository;
import weterynarz.Model.Entities.Users.IUsersManager;
import weterynarz.Model.Entities.Users.User;
import weterynarz.Model.Entities.Users.UsersManager;
import weterynarz.Model.UnitOfWork.*;

/**
 * Created by Uprzejmy on 2016-07-20.
 */
public class UserModel implements IUserModel {
    public Context registerUser(String email, String password, String name, String surname, String address, String phone, EContexts type)
    {
        IUnitOfWorkTransactional uow = (UnitOfWorkTransactional) UnitOfWorkFactory.createUnitOfWork(true);

        IUsersManager usersManager = new UsersManager(uow.getSession());
        User user = usersManager.register(email,password);

        switch(type)
        {
            case DOCTOR:
            {
                System.out.println("Registering doctor");
                IDoctorsRepository doctorsRepository = new DoctorsRepository(uow.getSession());
                Doctor doctor = new Doctor(name,surname,address,phone);
                doctor.setUser(user);
                doctorsRepository.add(doctor);
                break;
            }
            case CLIENT:
            {
                System.out.println("Registering client");
                IClientsRepository clientsRepository = new ClientsRepository(uow.getSession());
                Client client = new Client(name,surname,address,phone);
                client.setUser(user);
                clientsRepository.add(client);
                break;
            }
            default:
            {
                uow.discardChanges();
                throw new RuntimeException("Unsupported user type");
            }

        }

        uow.saveChanges();
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
        IUnitOfWorkNonTransactional uow = (UnitOfWorkNonTransactional) UnitOfWorkFactory.createUnitOfWork(false);

        IUsersManager usersManager = new UsersManager(uow.getSession());
        User user = usersManager.login(email,password);

        EContexts type = usersManager.getUserType(user);

        uow.close();

        if(user == null)
        {
            System.out.println("Couldn't log in, incorrect email or password");
            return null;
        }

        System.out.println("User logged in correctly");


        return new Context(user,type);


    }
}
