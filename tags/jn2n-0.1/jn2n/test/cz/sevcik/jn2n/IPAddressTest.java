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
public class IPAddressTest {

    private IPAddress iPAddress;

    public IPAddressTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void test() {
        String ip1 = "192.168.0.1";
        iPAddress = new IPAddress(ip1);
        assertEquals(ip1, iPAddress.toString());

        String ip2 = "192.168.0.2:80";
        iPAddress = new IPAddress(ip2);
        assertEquals(ip2, iPAddress.toString());

        iPAddress = new IPAddress("192.168.0.3", "82");
        assertEquals("192.168.0.3", iPAddress.getIp());
        assertEquals("82", iPAddress.getPort());

        iPAddress = new IPAddress("192.168.0.2:84:85");
        assertEquals("192.168.0.2:84", iPAddress.toString());

        iPAddress = new IPAddress();
        iPAddress.setIp("10.10.0.1");
        iPAddress.setPort("10000");
        assertEquals("10.10.0.1:10000", iPAddress.toString());

    }
}
