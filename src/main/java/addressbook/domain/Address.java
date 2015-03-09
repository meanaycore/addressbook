package addressbook.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Created by akhona on 2015/03/09.
 */

@Document
public class Address {

    @Id
    private String id;
    @Field
    private String streetname;
    @Field
    private String surburb;
    @Field
    private String town;
    @Field
    private String postalcode;

    private Address()
    {}

    private Address( Builder builder )
    {
        id = builder.id;
        streetname = builder.streetname;
        surburb = builder.surburb;
        town = builder.town;
        postalcode = builder.postalcode;
    }

    public static class Builder
    {
        private String id;
        private String streetname;
        private String surburb;
        private String town;
        private String postalcode;

        public Builder( String id )
        {
            this.id = id;
        }

        public Builder streetname( String value )
        {
            streetname = value;
            return this;
        }

        public Builder surburb( String value )
        {
            surburb = value;
            return this;
        }

        public Builder town( String value )
        {
            town = value;
            return this;
        }

        public Builder postalcode( String value  )
        {
            postalcode = value;
            return this;
        }

        public Address build()
        {
            return new Address(this);
        }
    }

    public String getId() {
        return id;
    }

    public String getStreetname() {
        return streetname;
    }

    public String getSurburb() {
        return surburb;
    }

    public String getTown() {
        return town;
    }

    public String getPostalcode() {
        return postalcode;
    }
}
