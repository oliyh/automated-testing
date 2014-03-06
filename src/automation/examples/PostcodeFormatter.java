package automation.examples;

import org.apache.commons.lang.StringUtils;

public class PostcodeFormatter {

    public String format(String postcode) {
        if (postcode == null) {
            return null;
        }

        String firstPart = StringUtils.substring(postcode, 0, -3).trim();
        String secondPart = StringUtils.substring(postcode, -3).trim();

        if (StringUtils.isBlank(firstPart)) {
            return secondPart;
        } else {
            return firstPart + " " + secondPart;
        }
    }
}
