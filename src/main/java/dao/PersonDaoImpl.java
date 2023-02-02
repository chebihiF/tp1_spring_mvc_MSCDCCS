package dao;

import entities.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class PersonDaoImpl implements PersonDao {

    private SessionFactory factory = HibernateUtil.getFactory();
    private Session session = null ;

    @Override
    public Person addPerson(Person person) {
        try{
        session = factory.openSession();
        session.beginTransaction();
        session.save(person);
        session.getTransaction().commit();
        } catch (Exception exception){
            // gestion de l'exception
            exception.printStackTrace();
        }finally {
            session.close();
        }
        return person;
    }

    @Override
    public Person updatePerson(Person person) {
        try{
            session = factory.openSession();
            session.beginTransaction();
            session.update(person);
            session.getTransaction().commit();
        } catch (Exception exception){
            // gestion de l'exception
            exception.printStackTrace();
        }finally {
            session.close();
        }
        return person;
    }

    @Override
    public Person deletePerson(Person person) {
        try{
            session = factory.openSession();
            session.beginTransaction();
            session.delete(person);
            session.getTransaction().commit();
        } catch (Exception exception){
            // gestion de l'exception
            exception.printStackTrace();
        }finally {
            session.close();
        }
        return person;
    }

    @Override
    public Person getPerson(Long id) {
        Person person = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            person = session.get(Person.class,id);
            session.getTransaction().commit();
        }catch (Exception exception)
        {
            exception.printStackTrace();
        }finally {
            session.close();
        }
        return person;
    }

    @Override
    public List<Person> getAll() {
        List<Person> people = new ArrayList<>();
        try {
            session = factory.openSession();
            session.beginTransaction();
            // HQL
            people = session.createQuery("from Person",Person.class).getResultList();
            session.getTransaction().commit();
        }catch (Exception exception){
            exception.printStackTrace();
        }finally {
            session.close();
        }
        return people;
    }
}
