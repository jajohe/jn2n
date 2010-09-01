package cz.sevcik.jn2n;

/**
 * IP address
 * 
 * @author Jaroslav Sevcik
 *
 * @version $Rev$
 */
public class IPAddress {

    private String ip;
    private String port;

    public IPAddress() {
    }

    public IPAddress(String address) {
        String[] addrPart = address.split(":");
        this.ip = addrPart[0];
        if (addrPart.length > 1) {
            this.port = addrPart[1];
        }
    }

    public IPAddress(String ip, String port) {
        String[] addr = ip.split(":");
        this.ip = addr[0];
        this.port = port;
    }

    /**
     * Get the value of ip
     * Example 192.168.0.1
     *
     * @return the value of ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * Set the value of ip
     * Example 192.168.0.1
     *
     * @param ip new value of ip
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * Get the value of port
     *
     * @return the value of port
     */
    public String getPort() {
        return port;
    }

    /**
     * Set the value of port
     *
     * @param port new value of port
     */
    public void setPort(String port) {
        this.port = port;
    }

    @Override
    public String toString() {
        if (port == null) {
            return ip;
        }
        return ip + ":" + port;
    }
}
