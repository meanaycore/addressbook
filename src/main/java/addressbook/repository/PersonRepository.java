package addressbook.repository;

import addressbook.domain.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by akhona on 2015/03/09.
 */
public interface PersonRepository extends MongoRepository<Person, String>{
    Person findById( String id );
}
