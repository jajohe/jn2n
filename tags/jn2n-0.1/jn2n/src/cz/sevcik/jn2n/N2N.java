package cz.sevcik.jn2n;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
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
@XmlType(propOrder = {"version", "edgeNode", "communityName", "encryptionKey", "superNode"})
public class N2N {

    private int version = 1;
    private IPAddress edgeNode;
    private String communityName;
    private String encryptionKey;
    private IPAddress superNode;

    public N2N() {
    }

    public N2N(IPAddress edgeNode, String communityName, String encryptionKey, IPAddress superNode) {
        this.edgeNode = edgeNode;
        this.communityName = communityName;
        this.encryptionKey = encryptionKey;
        this.superNode = superNode;
    }

    public N2N(String edgeNode, String communityName, String encryptionKey, String superNode) {
        this.edgeNode = new IPAddress(edgeNode);
        this.communityName = communityName;
        this.encryptionKey = encryptionKey;
        this.superNode = new IPAddress(superNode);
    }

    /**
     * Get the value of edgeNode
     * 
     * @return ip address of edgeNode
     */
    public IPAddress getEdgeNode() {
        return edgeNode;
    }

    /**
     * Set the value of edgeNode
     * Example 192.168.0.1
     *
     * @param ip address of edgeNode
     */
    public void setEdgeNode(IPAddress ip) {
        this.edgeNode = ip;
    }

    /**
     * Set the value of edgeNode
     * Example 192.168.0.1
     *
     * @param ip address of edgeNode
     */
    public void setEdgeNode(String ip) {
        this.edgeNode = new IPAddress(ip, null);
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
    public IPAddress getSuperNode() {
        return superNode;
    }

    /**
     * Set the ip address and port of supernode
     * Example 88.86.108.50:82
     *
     * @param ip addess and port of supernode
     */
    public void setSuperNode(IPAddress ip) {
        this.superNode = ip;
    }

    /**
     * Set the ip address and port of supernode
     * Example 88.86.108.50:82
     *
     * @param ip addess and port of supernode
     */
    public void setSuperNode(String ip) {
        this.superNode = new IPAddress(ip);
    }

    /**
     * Set the ip address and port of supernode
     * Example 88.86.108.50:82
     *
     * @param ip addess and port of supernode
     */
    public void setSuperNode(String ip, String port) {
        this.superNode = new IPAddress(ip, port);
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
        return edgeNode + " " + communityName + " " + encryptionKey + " " + superNode;
    }
}
