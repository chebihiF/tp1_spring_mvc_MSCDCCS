package dao;

import entities.Person;

import java.util.List;

public interface PersonDao {
    Person addPerson(Person person);
    Person updatePerson(Person person);
    Person deletePerson(Person person);
    Person getPerson(Long id);
    List<Person> getAll();
}
