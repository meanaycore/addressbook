package addressbook.services.Impl;

import addressbook.domain.Person;
import addressbook.repository.PersonRepository;
import addressbook.services.PersonServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by akhona on 2015/03/09.
 */

@Service
public class PersonServiceImpl implements PersonServiceInt {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<Person> getPersonList() {
        return personRepository.findAll();
    }
}
