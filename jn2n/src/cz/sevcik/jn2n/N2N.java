package cz.sevcik.jn2n;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 * Tunel n2n data class
 *
 * @author Jaroslav Sevcik
 *
 * @version $Rev$
 */
@XmlRootElement(name = "n2n")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(propOrder = {"version", "edgeNodeString", "communityName", "encryptionKey", "superNodeString"})
public class N2N {

    private int version = 1;
    private InetAddress edgeNode;
    private String communityName;
    private String encryptionKey;
    private InetSocketAddress superNode;

    public N2N() {
    }

    public N2N(InetAddress edgeNode, String communityName, String encryptionKey, InetSocketAddress superNode) {
        this.edgeNode = edgeNode;
        this.communityName = communityName;
        this.encryptionKey = encryptionKey;
        this.superNode = superNode;
    }

    /**
     * Get the value of edgeNode
     * 
     * @return ip address of edgeNode
     */
    @XmlTransient
    public InetAddress getEdgeNode() {
        return edgeNode;
    }

    /**
     * Set the value of edgeNode
     * Example 192.168.0.1
     *
     * @param address
     */
    public void setEdgeNode(InetAddress address) {
        this.edgeNode = address;
    }

    /**
     * Set the value of edgeNode
     * Example 192.168.0.1
     *
     * @param address
     * @throws UnknownHostException
     */
    public void setEdgeNode(String address) throws UnknownHostException {
        if (address == null || address.length() == 0) {
            throw new UnknownHostException(address);
        }
        this.edgeNode = InetAddress.getByName(address);
    }

    /**
     * Get the value of edgeNode
     *
     * @return ip address of edgeNode
     */
    @XmlElement(name = "edgeNode")
    public String getEdgeNodeString() {
        return edgeNode.getHostName();
    }

    /**
     * Set the value of edgeNode
     * Example 192.168.0.1
     *
     * @param address
     * @throws UnknownHostException
     */
    public void setEdgeNodeString(String address) throws UnknownHostException {
        setEdgeNode(address);
    }

    /**
     * Get the value of communityName
     *
     * @return the value of communityName
     */
    public String getCommunityName() {
        return communityName;
    }

    /**
     * Set the value of communityName
     *
     * @param name new value of communityName
     */
    public void setCommunityName(String name) {
        this.communityName = name;
    }

    /**
     * Get the value of encryptionKey
     *
     * @return the value of encryptionKey
     */
    public String getEncryptionKey() {
        return encryptionKey;
    }

    /**
     * Set the value of encryptionKey
     *
     * @param key new value of encryptionKey
     */
    public void setEncryptionKey(String key) {
        this.encryptionKey = key;
    }

    /**
     * Get the ip address and port of supernode 
     * Example 88.86.108.50:82
     *
     * @return ip addess and port of supernode
     */
    @XmlTransient
    public InetSocketAddress getSuperNode() {
        return superNode;
    }

    /**
     * Set the ip address and port of supernode
     * Example 88.86.108.50:82
     *
     * @param address
     */
    public void setSuperNode(InetSocketAddress address) {
        this.superNode = address;
    }

    /**
     * Set the ip address and port of supernode
     * Example 88.86.108.50:82
     *
     * @param addressWithPort 
     * @throws UnknownHostException
     */
    public void setSuperNode(String addressWithPort) throws UnknownHostException {
        if (addressWithPort == null || addressWithPort.length() == 0) {
            throw new UnknownHostException(addressWithPort);
        }

        String[] addressPart = addressWithPort.split(":");
        if (addressPart.length != 2) {
            throw new UnknownHostException(addressWithPort);
        }
        InetAddress ia = InetAddress.getByName(addressPart[0]);

        int port;
        try {
            port = Integer.parseInt(addressPart[1]);
        } catch (NumberFormatException nfe) {
            throw new UnknownHostException(addressWithPort);
        }
        this.superNode = new InetSocketAddress(ia, port);
    }

    /**
     * Get the ip address and port of supernode
     * Example 88.86.108.50:82
     *
     * @return ip addess and port of supernode
     */
    @XmlElement(name = "superNode")
    public String getSuperNodeString() {
        return superNode.getAddress().getHostAddress() + ":" + superNode.getPort();
    }

    /**
     * Set the ip address and port of supernode
     * Example 88.86.108.50:82
     *
     * @param addressWithPort
     * @throws UnknownHostException
     */
    public void setSuperNodeString(String addressWithPort) throws UnknownHostException {
        setSuperNode(addressWithPort);
    }

    /**
     * Get the value of config version
     *
     * @return the value of version
     */
    @XmlAttribute(name = "version", required = true)
    public int getVersion() {
        return version;
    }

    /**
     * Set the value of config version
     *
     * @param version new value of version
     */
    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return getEdgeNodeString() + " " + communityName + " " + encryptionKey + " " + getSuperNodeString();
    }
}
