package addressbook.services.crud;

import addressbook.domain.Person;

/**
 * Created by akhona on 2015/03/09.
 */
public interface PersonCrudInt {

    public Person create( Person person );
    public Person read( Person person );
    public Person update( Person person );
    public Boolean delete( Person person );

}
