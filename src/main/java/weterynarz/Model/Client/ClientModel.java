package weterynarz.Model.Client;

import weterynarz.Model.Entities.Clients.Client;
import weterynarz.Model.Entities.Clients.ClientsRepository;
import weterynarz.Model.Entities.Clients.IClientsRepository;
import weterynarz.Model.Entities.Patients.IPatientsRepository;
import weterynarz.Model.Entities.Patients.Patient;
import weterynarz.Model.Entities.Patients.PatientsRepository;
import weterynarz.Model.Entities.Users.User;
import weterynarz.Model.UnitOfWork.*;

import java.util.List;

/**
 * Created by Uprzejmy on 2016-07-20.
 */
public class ClientModel implements IClientModel {
    public List<Patient> findPatientsByUser(User user)
    {
        IUnitOfWorkNonTransactional uow = new UnitOfWorkNonTransactional();

        IClientsRepository clientsRepository = new ClientsRepository(uow.getSession());
        Client client = clientsRepository.findByUser(user);
        List<Patient> patients = client.getPatients();

        uow.close();

        return patients;
    }

    public void createPatient(User user,String name, String breed,String pawsNumber,String color)
    {
        IUnitOfWorkTransactional uow = new UnitOfWorkTransactional();

        IClientsRepository clientsRepository = new ClientsRepository(uow.getSession());
        Client client = clientsRepository.findByUser(user);

        Patient patient = new Patient(name,breed,breed,Integer.parseInt(pawsNumber),color);
        patient.setOwner(client);
        client.addPatient(patient);

        IPatientsRepository patientsRepository = new PatientsRepository(uow.getSession());
        patientsRepository.add(patient);

        clientsRepository.update(client);

        uow.saveChanges();
    }
}
