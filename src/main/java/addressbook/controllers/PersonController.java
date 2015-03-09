package addressbook.controllers;

import addressbook.domain.Address;
import addressbook.domain.Person;
import addressbook.dto.PersonListDto;
import addressbook.services.Impl.PersonServiceImpl;
import addressbook.services.PersonServiceInt;
import addressbook.services.crud.Impl.PersonCrudImpl;
import addressbook.services.crud.PersonCrudInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by akhona on 2015/03/09.
 */

@Controller
@RequestMapping("/users")
public class PersonController {


    @Autowired
    private PersonCrudInt crudservice = new PersonCrudImpl();

    @Autowired
    private PersonServiceInt service = new PersonServiceImpl();

    @RequestMapping
    public String getPersonPage()
    {
        return "users";
    }

    @RequestMapping( value ="/records" )
    public @ResponseBody PersonListDto getPersonList()
    {
        PersonListDto personListDto = new PersonListDto();
        personListDto.setPersonList( service.getPersonList() );
        return personListDto;
    }

    @RequestMapping( value ="/get" )
    public @ResponseBody Person get( @RequestBody Person person )
    {
        return crudservice.read( person );
    }

    @RequestMapping( value ="/create", method = RequestMethod.POST )
    public @ResponseBody Person create(
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam String cell,
            @RequestParam String email,
            @RequestParam String streetname,
            @RequestParam String surburb,
            @RequestParam String town,
            @RequestParam String postalcode )
    {
        Address newAddress = new Address.Builder(null)
                .streetname(streetname)
                .surburb(surburb)
                .town(town)
                .postalcode(postalcode)
                .build();

        Person newPerson = new Person.Builder(null)
                .name(name)
                .surname(surname)
                .cell(cell)
                .email(email)
                .address(newAddress)
                .build();

        return crudservice.create(newPerson);
    }

    @RequestMapping( value ="/update", method = RequestMethod.POST )
    public @ResponseBody Person update(
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam String cell,
            @RequestParam String email,
            @RequestParam String streetname,
            @RequestParam String surburb,
            @RequestParam String town,
            @RequestParam String postalcode )
    {
        Address existingAddress = new Address.Builder(null)
                .streetname(streetname)
                .surburb(surburb)
                .town(town)
                .postalcode(postalcode)
                .build();

        Person existingPerson = new Person.Builder(null)
                .name(name)
                .surname(surname)
                .cell(cell)
                .email(email)
                .address(existingAddress)
                .build();

        return crudservice.update(existingPerson);
    }

    @RequestMapping( value ="/delete", method = RequestMethod.POST )
    public @ResponseBody Boolean delete(
            @RequestParam String id
    )
    {
        Person existingPerson = new Person.Builder(id).build();

        return crudservice.delete(existingPerson);
    }

}
