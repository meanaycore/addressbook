package addressbook.dto;

import addressbook.domain.Person;

import java.util.List;

/**
 * Created by akhona on 2015/03/09.
 */
public class PersonListDto {

    private List<Person> personList;

    public List<Person> getPersonList()
    {
        return personList;
    }

    public void setPersonList( List<Person> personList )
    {
        this.personList = personList;
    }
}
