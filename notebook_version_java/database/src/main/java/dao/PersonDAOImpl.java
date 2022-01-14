package dao;

import model.Person;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSession;

import java.util.List;

public class PersonDAOImpl implements DAO{

    @Override
    public void save(Person person){
        Session session = HibernateSession.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(person);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Person person){
        Session session = HibernateSession.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(person);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Person person){
        Session session = HibernateSession.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(person);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Person> findAll(){
        List<Person> personList = (List<Person>) HibernateSession.getSessionFactory()
                .openSession().createQuery("from Person").list();
        return personList;
    }

    @Override
    public List<Person> personSearch(String name){
        String sql = "from Person where name = :name";
        List<Person> personList= (List<Person>) HibernateSession.getSessionFactory()
                .openSession().createQuery(sql).setParameter("name", name).list();
        return personList;
    }
}
