package br.com.erichmantai.controller;

import br.com.erichmantai.model.business.Person;
import br.com.erichmantai.model.dao.PersonDAO;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author erichmantai
 */
@Named("personBean")
@RequestScoped
public class PersonController extends AbstractController {

    @Inject
    private PersonDAO personDAO;

    @Inject
    private Person person;

    public String save() {
        personDAO.save(person);
        return "";
    }

    public List<Person> findAll() {
        return personDAO.listAll();
    }

    public PersonDAO getPersonDAO() {
        return personDAO;
    }

    public void setPersonDAO(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

}
