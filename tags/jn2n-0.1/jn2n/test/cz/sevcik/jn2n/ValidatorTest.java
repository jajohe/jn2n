package cz.sevcik.jn2n;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jaroslav Sevcik
 *
 * @version $Rev$
 */
public class ValidatorTest {

    private Validator validator;

    public ValidatorTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        validator = new Validator();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of validateIP method, of class Validator.
     */
    @Test
    public void testValidateIP() {
        assertTrue(validator.validateIP("192.168.1.1"));
        assertTrue(validator.validateIP("1.1.1.1"));
        assertFalse(validator.validateIP("192.168.1.1.1"));
        assertFalse(validator.validateIP("192.168.2"));
        assertFalse(validator.validateIP("a.168.2"));
        assertFalse(validator.validateIP("1921.168.1.1"));
        assertFalse(validator.validateIP(".168.1.1"));
        assertFalse(validator.validateIP("1..1.1"));
        assertFalse(validator.validateIP("192,168.1.1"));
        assertFalse(validator.validateIP(""));
       
    }

    /**
     * Test of validateString method, of class Validator.
     */
    @Test
    public void testValidateString() {
        assertTrue(validator.validateString("karel"));        
        assertFalse(validator.validateIP(""));
    }

    /**
     * Test of validateIPWidthPort method, of class Validator.
     */
    @Test
    public void testValidateIPWidthPort() {
        assertTrue(validator.validateIPWidthPort("192.168.1.1:88999"));
        assertTrue(validator.validateIPWidthPort("1.1.1.1:1"));
        assertFalse(validator.validateIPWidthPort("192.168.1.1"));
        assertFalse(validator.validateIPWidthPort("1.1.1.1"));
        assertFalse(validator.validateIPWidthPort("192.168.1.1.1"));
        assertFalse(validator.validateIPWidthPort("192.168.2"));
        assertFalse(validator.validateIPWidthPort("a.168.2"));
        assertFalse(validator.validateIPWidthPort("1921.168.1.1"));
        assertFalse(validator.validateIPWidthPort(".168.1.1"));
        assertFalse(validator.validateIPWidthPort("1..1.1"));
        assertFalse(validator.validateIPWidthPort("192,168.1.1"));
        assertFalse(validator.validateIPWidthPort("192.168.1.1:88999:9"));
        assertFalse(validator.validateIPWidthPort("192.168.1.1:"));
        assertFalse(validator.validateIPWidthPort(""));
    }
}
