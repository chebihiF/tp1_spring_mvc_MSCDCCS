package metier;

import dao.PersonDao;
import entities.Person;

import java.util.List;

public class PersonMetierImpl implements PersonMetier {

    private PersonDao dao ; // = null

    public void setDao(PersonDao dao) {
        this.dao = dao;
    }

    @Override
    public Person subscribePerson(Person person) throws Exception {
        if(person.getEmail().contains("@gmail.com"))
            dao.addPerson(person);
        else throw new Exception("Person not authorized");
        return person;
    }

    @Override
    public Person updatePerson(Person person) {
        return dao.updatePerson(person);
    }

    @Override
    public Person deletePerson(Person person) {
        return dao.deletePerson(person);
    }

    @Override
    public Person getProfile(Long id) {
        return dao.getPerson(id);
    }

    @Override
    public List<Person> getPeoples() {
        return dao.getAll();
    }
}
