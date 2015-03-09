package addressbook.services.crud.Impl;

import addressbook.domain.Address;
import addressbook.domain.Person;
import addressbook.repository.AddressRepository;
import addressbook.repository.PersonRepository;
import addressbook.services.crud.PersonCrudInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by akhona on 2015/03/09.
 */

@Service
public class PersonCrudImpl implements PersonCrudInt {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Person create(Person person)
    {
        Address address = new Address.Builder(UUID.randomUUID().toString()).build();
        person = new Person.Builder(UUID.randomUUID().toString()).address(address).build();

        addressRepository.save(address);
        return personRepository.save(person);
    }

    @Override
    public Person read(Person person)
    {
        return person;
    }

    @Override
    public Person update(Person person)
    {
        Person existingPerson = personRepository.findById(person.getId());

        if( existingPerson == null )
        {
            return null;
        }

        existingPerson = new Person.Builder( person.getId() )
                            .name( person.getName() )
                            .surname( person.getSurname() )
                            .cell( person.getCell() )
                            .email( person.getEmail() )
                            .address( person.getAddress() )
                            .build();

        addressRepository.save( existingPerson.getAddress() );
        return personRepository.save( existingPerson );
    }

    @Override
    public Boolean delete(Person person)
    {
        Person existingPerson = personRepository.findById( person.getId() );

        if( existingPerson == null )
        {
            return false;
        }

        addressRepository.delete( existingPerson.getAddress() );
        personRepository.delete( existingPerson );
        return false;
    }
}
