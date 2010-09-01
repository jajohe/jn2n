package cz.sevcik.jn2n;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Input string validator
 * 
 * @author Jaroslav Sevcik
 *
 * @version $Rev$
 */
public class Validator {

    private static final String IP_ADDRESS_REGEX = "[0-9]{1,3}[.][0-9]{1,3}[.][0-9]{1,3}[.][0-9]{1,3}";
    private static final String IP_ADDRESS_WITH_PORT_REGEX = "[0-9]{1,3}[.][0-9]{1,3}[.][0-9]{1,3}[.][0-9]{1,3}[:][0-9]+";

    /**
     * Validate IP address
     * @param ip
     * @return is IP valid
     */
    public boolean validateIP(String ip) {
        return validate(ip, IP_ADDRESS_REGEX);
    }

    /**
     * Validate string - not empty only
     * @param string
     * @return is not empty
     */
    public boolean validateString(String string) {
        return !string.isEmpty();
    }

    /**
     * Validate IP address width port
     * @param ipWidthPort
     * @return is IP and port valid
     */
    public boolean validateIPWidthPort(String ipWidthPort) {
        return validate(ipWidthPort, IP_ADDRESS_WITH_PORT_REGEX);
    }

    /**
     * Validate mechanism
     * @param value
     * @param regex
     * @return
     */
    private boolean validate(String value, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }
}
