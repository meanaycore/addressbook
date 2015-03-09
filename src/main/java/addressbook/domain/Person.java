package addressbook.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Created by akhona on 2015/03/09.
 */

@Document
public class Person {

    @Id
    private String id;
    @Field
    private String name;
    @Field
    private String surname;
    @Field
    private String cell;
    @Field
    private String email;
    @DBRef
    private Address address;

    private Person()
    {}

    private Person( Builder builder )
    {
        id = builder.id;
        name = builder.name;
        surname = builder.surname;
        cell = builder.cell;
        email = builder.email;
        address = builder.address;
    }

    public static class Builder
    {
        private String id;
        private String name;
        private String surname;
        private String cell;
        private String email;
        private Address address;

        public Builder( String id )
        {
            this.id = id;
        }

        public Builder name( String value )
        {
            name = value;
            return this;
        }

        public Builder surname( String value )
        {
            surname = value;
            return this;
        }

        public Builder cell( String value )
        {
            cell = value;
            return this;
        }

        public Builder email( String value )
        {
            email = value;
            return this;
        }

        public Builder address( Address value )
        {
            address = value;
            return this;
        }

        public Person build()
        {
            return new Person(this);
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getCell() {
        return cell;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }
}
