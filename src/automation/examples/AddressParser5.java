package automation.examples;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class AddressParser5 {

    private final boolean strict;
    private final boolean makeCityNameUppercase;
    private final PostcodeFormatter postcodeFormatter;

    public AddressParser5(boolean strict, boolean makeCityNameUppercase, PostcodeFormatter postcodeFormatter) {
        this.strict = strict;
        this.makeCityNameUppercase = makeCityNameUppercase;
        this.postcodeFormatter = postcodeFormatter;
    }

    public Address parse(String address) {
        String[] addressBits = address.split(",");

        return new Address(tryRead(addressBits, 0), tryRead(addressBits, 1), maybeUpperCaseCity(tryRead(addressBits, 2)), postcodeFormatter.format(tryRead(addressBits, 3)));
    }

    private String tryRead(String[] addressBits, int index) {
        try {
            return addressBits[index].trim();
        } catch (IndexOutOfBoundsException e) {
            if (strict) {
                throw new IllegalArgumentException("Address is not formatted as expected", e);
            } else {
                return null;
            }
        }
    }

    private String maybeUpperCaseCity(String city) {
        if (makeCityNameUppercase && city != null) {
            return city.toUpperCase();
        }
        return city;
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
