package cz.sevcik.jn2n;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
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

    private N2N n2n;

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
        try {
            InetAddress edge = InetAddress.getByName("192.168.0.1");
            InetAddress superNode = InetAddress.getByName("10.11.12.13");
            InetSocketAddress superN = new InetSocketAddress(superNode, 100);
            n2n = new N2N(edge, "aa", "bb", superN);

            assertEquals("192.168.0.1", n2n.getEdgeNode().getHostAddress());
            assertEquals("aa", n2n.getCommunityName());
            assertEquals("bb", n2n.getEncryptionKey());
            assertEquals("10.11.12.13", n2n.getSuperNode().getHostName());
            assertEquals(100, n2n.getSuperNode().getPort());

        } catch (UnknownHostException ex) {
            fail(ex.toString());
        }

        try {
            n2n = new N2N();
            n2n.setEdgeNode(InetAddress.getByName("192.168.200.2"));
            n2n.setCommunityName("eee");
            n2n.setEncryptionKey("xxx");
            n2n.setSuperNode(new InetSocketAddress(InetAddress.getByName("88.168.222.2"), 32));
            assertEquals("192.168.200.2 eee xxx 88.168.222.2:32", n2n.toString());
        } catch (UnknownHostException ex) {
            fail(ex.toString());
        }

        n2n = new N2N();
        try {
            n2n.setEdgeNode("192.168.1.1");
            n2n.setCommunityName("community");
            n2n.setEncryptionKey("key");
            n2n.setSuperNode("10.10.0.1:89");

            assertEquals("192.168.1.1", n2n.getEdgeNodeString());
            assertEquals("community", n2n.getCommunityName());
            assertEquals("key", n2n.getEncryptionKey());
            assertEquals("10.10.0.1:89", n2n.getSuperNodeString());
        } catch (UnknownHostException ex) {
            fail(ex.toString());
        }

        n2n = new N2N();
        try {
            n2n.setEdgeNodeString("192.168.11.11");
            n2n.setCommunityName("com");
            n2n.setEncryptionKey("pass");
            n2n.setSuperNodeString("10.10.11.2:89");

            assertEquals("192.168.11.11", n2n.getEdgeNodeString());
            assertEquals("com", n2n.getCommunityName());
            assertEquals("pass", n2n.getEncryptionKey());
            assertEquals("10.10.11.2:89", n2n.getSuperNodeString());
        } catch (UnknownHostException ex) {
            fail(ex.toString());
        }
    }
}
