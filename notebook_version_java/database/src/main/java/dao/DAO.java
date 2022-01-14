package dao;

import model.Person;
import java.util.List;

public interface DAO {

    public void save(Person person);
    public void update(Person person);
    public void delete(Person person);
    public List<Person> findAll();
    public List<Person> personSearch(String name);
}
