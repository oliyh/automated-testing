package automation.examples;

import org.junit.Test;
import org.mockito.Mockito;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

public class AddressParser5Test {

    @Test
    public void shouldUsePostcodeFormatterToFormatPostcode() {
        String address = "One, Cabot Square, London, E14 4QJ";
        String expectedPostcode = "E 144 QJ";
        AddressParser5.Address expected = new AddressParser5.Address("One", "Cabot Square", "London", expectedPostcode);

        PostcodeFormatter postcodeFormatter = Mockito.mock(PostcodeFormatter.class);
        when(postcodeFormatter.format("E14 4QJ")).thenReturn(expectedPostcode);

        assertThat(new AddressParser5(false, false, postcodeFormatter).parse(address), equalTo(expected));
    }
}
