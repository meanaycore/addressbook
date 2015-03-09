package addressbook.repository;

import addressbook.domain.Address;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by akhona on 2015/03/09.
 */
public interface AddressRepository extends MongoRepository<Address, String> {
}
