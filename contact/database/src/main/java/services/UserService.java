package services;

import dao.PersonDAOImpl;
import model.Person;
import java.util.List;

public class UserService {

    private PersonDAOImpl personDAO = new PersonDAOImpl();

    public UserService(){}

    public void savePerson(Person person){
        personDAO.save(person);
    }

    public void updatePerson(Person person){
        personDAO.update(person);
    }

    public void deletePerson(Person person){
        personDAO.delete(person);
    }

    public List<Person> findAllPerson(){
        return personDAO.findAll();
    }

    public List<Person> personSearch(String name){
        return personDAO.personSearch(name);
    }
}
