package automation;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class AddressParser4Test {

    // 0. This test will show that there will be spaces that leak out!
    @Test
    public void shouldParseANormalAddress() {
        String address = "One, Cabot Square, London, E14 4QJ";
        AddressParser4.Address expected = new AddressParser4.Address("One", "Cabot Square", "London", "E14 4QJ");

        assertThat(new AddressParser4(false, false).parse(address), equalTo(expected));
    }

    // 1a. This test will show that lenient mode seems to work
    @Test
    public void shouldAllowMissingFieldsInLenientMode() {
        String address = "One, Cabot Square";
        AddressParser4.Address expected = new AddressParser4.Address("One", "Cabot Square", null, null);

        assertThat(new AddressParser4(false, false).parse(address), equalTo(expected));
    }

    // 1b. This test will show that strict mode seems to work
    @Test(expected = IllegalArgumentException.class)
    public void shouldRejectBadAddressesInStrictMode() {
        String address = "One, Cabot Square, London";
        AddressParser4.Address expected = new AddressParser4.Address("One", "Cabot Square", "London", "E14 4QJ");

        assertThat(new AddressParser4(true, false).parse(address), equalTo(expected));
    }

    // 2. This test will show that city uppercasing works
    @Test
    public void shouldUppercaseCityName() {
        String address = "One, Cabot Square, London";
        AddressParser4.Address expected = new AddressParser4.Address("One", "Cabot Square", "LONDON", null);

        assertThat(new AddressParser4(false, true).parse(address), equalTo(expected));
    }

    // 3. This test will uncover a bug in the last permutation! NullPointerException
    @Test
    public void shouldUppercaseCityNameInLenientModeToo() {
        String address = "One, Cabot Square";
        AddressParser4.Address expected = new AddressParser4.Address("One", "Cabot Square", null, null);

        assertThat(new AddressParser4(false, true).parse(address), equalTo(expected));
    }

}
