package br.com.erichmantai.model.dao;

import br.com.erichmantai.model.business.Person;

/**
 *
 * @author erichmantai
 */
public class PersonDAO extends AbstractDAO<Person> {

    public PersonDAO() {
        super(Person.class);
    }

}
