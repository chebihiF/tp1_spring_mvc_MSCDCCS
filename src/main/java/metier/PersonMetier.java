package metier;

import entities.Person;

import java.util.List;

public interface PersonMetier {
    Person subscribePerson(Person person) throws Exception;
    Person updatePerson(Person person);
    Person deletePerson(Person person);
    Person getProfile(Long id);
    List<Person> getPeoples();
}
