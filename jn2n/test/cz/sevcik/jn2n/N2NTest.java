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
public class N2NTest {

    public N2NTest() {
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

    /**
     * Test of getEdgeNode method, of class N2N.
     */
    @Test
    public void test() {
        N2N n2n = new N2N();
        n2n.setEdgeNode("192.168.0.1");
        n2n.setCommunityName("community");
        n2n.setEncryptionKey("key");
        n2n.setSuperNode("10.10.0.1:89");

        assertEquals("192.168.0.1", n2n.getEdgeNode().toString());
        assertEquals("community", n2n.getCommunityName());
        assertEquals("key", n2n.getEncryptionKey());
        assertEquals("10.10.0.1:89", n2n.getSuperNode().toString());

        n2n = new N2N();
        n2n.setEdgeNode(new IPAddress("192.168.200.2"));
        n2n.setCommunityName("eee");
        n2n.setEncryptionKey("xxx");
        n2n.setSuperNode(new IPAddress("88.168.222.2", "32"));
        assertEquals("192.168.200.2 eee xxx 88.168.222.2:32", n2n.toString());

        n2n = new N2N();
        n2n.setEdgeNode("192.168.2.2:87");
        n2n.setCommunityName("rrr");
        n2n.setEncryptionKey("yyy");
        n2n.setSuperNode(new IPAddress("88.168.222.2", "32"));
        assertEquals("192.168.2.2 rrr yyy 88.168.222.2:32", n2n.toString());

        n2n = new N2N(new IPAddress("192.168.50.60"), "pepa", "heslo", new IPAddress("88.87.112.1:91"));
        assertEquals("192.168.50.60 pepa heslo 88.87.112.1:91", n2n.toString());

        n2n = new N2N("192.168.11.12", "pepa", "heslo", "88.87.12.1:90");
        assertEquals("192.168.11.12 pepa heslo 88.87.12.1:90", n2n.toString());
    }
}
