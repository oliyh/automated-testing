package automation;

import automation.examples.PostcodeFormatter;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class PostcodeFormatterTest {

    @Test
    public void shouldFormatPostcodeNicely() {
        assertThat(PostcodeFormatter.format("E144QJ"), equalTo("E14 4QJ"));
    }

    @Test
    public void shouldFormatShortPostcodesNicelyToo() {
        assertThat(PostcodeFormatter.format("W1ABC"), equalTo("W1 ABC"));
    }

    @Test
    public void shouldFormatInvalidPostcodesAsBestItCan() {
        assertThat(PostcodeFormatter.format("W11"), equalTo("W11"));
    }

    @Test
    public void shouldCopeWithNulls() {
        assertThat(PostcodeFormatter.format(null), equalTo(null));
    }
}
