package automation;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class AddressParser {

    /**
     * Builds an @automation.Address class from an input string
     * @param address An address consisting of property number, road name, city and postcode separated by commas
     * @return An @automation.Address object
     */
    public Address parse(String address) {
        return null;
    }

    public static class Address {
        public final String propertyNumber;
        public final String roadName;
        public final String city;
        public final String postcode;

        public Address(String propertyNumber, String roadName, String city, String postcode) {
            this.propertyNumber = propertyNumber;
            this.roadName = roadName;
            this.city = city;
            this.postcode = postcode;
        }

        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this);
        }

        @Override
        public boolean equals(Object that) {
            return EqualsBuilder.reflectionEquals(this, that);
        }
    }
}
