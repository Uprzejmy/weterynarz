package weterynarz.Model;

import weterynarz.Model.Clients.Client;
import weterynarz.Model.Clients.ClientsRepository;
import weterynarz.Model.Clients.IClientsRepository;
import weterynarz.Model.Patients.IPatientsRepository;
import weterynarz.Model.Patients.Patient;
import weterynarz.Model.Patients.PatientsRepository;
import weterynarz.Model.Users.User;

import java.util.List;

/**
 * Created by Uprzejmy on 2016-07-20.
 */
public class ClientModel implements IClientModel {
    public List<Patient> findPatientsByUser(User user)
    {
        UnitOfWork unitOfWork = new UnitOfWork();

        IClientsRepository clientsRepository = new ClientsRepository(unitOfWork.getSession());
        Client client = clientsRepository.findByUser(user);
        List<Patient> patients = client.getPatients();

        unitOfWork.saveChanges();

        return patients;
    }

    public void createPatient(User user,String name, String breed,String pawsNumber,String color)
    {
        UnitOfWork unitOfWork = new UnitOfWork();

        IClientsRepository clientsRepository = new ClientsRepository(unitOfWork.getSession());
        Client client = clientsRepository.findByUser(user);

        Patient patient = new Patient(name,breed,breed,Integer.parseInt(pawsNumber),color);
        patient.setOwner(client);
        client.addPatient(patient);

        IPatientsRepository patientsRepository = new PatientsRepository(unitOfWork.getSession());
        patientsRepository.add(patient);

        clientsRepository.update(client);

        unitOfWork.saveChanges();
    }
}
