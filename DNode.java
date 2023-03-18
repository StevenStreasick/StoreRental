import java.io.Serializable;

/**************************************************************
 * Acts as a container for information inside of the Linked List
 *
 * @author Steven
 * @version 4/8/2022
 **************************************************************/
public class DNode implements Serializable {
    private Rental data;
    private DNode next;
    private DNode prev;

    /** 
     * Establishes the node with data, and it's location in the list
     * 
     * @param data
     * @param next
     * @param prev
     */
    public DNode(Rental data, DNode next, DNode prev) {
        super();
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    /** 
     * <b> Serves no purpose. </b> Default constructor
     *
     */
    public DNode() {
    }

    
    /** 
     * Gets the data within the node
     * 
     * @return Rental
     */
    public Rental getData() {
        return data;
    }

    
    /** 
     * Sets the data within the node
     * 
     * @param data
     */
    public void setData(Rental data) {
        this.data = data;
    }

    
    /** 
     * Gets the next node
     * 
     * @return DNode
     */
    public DNode getNext() {
        return next;
    }

    
    /** 
     * Sets the next node
     * 
     * @param next
     */
    public void setNext(DNode next) {
        this.next = next;
    }

    
    /** 
     * Sets the previous node
     * 
     * @param prev
     */
    public void setPrev(DNode prev) {
        this.prev = prev;
    }

    
    /** 
     * Gets the previous node
     * 
     * @return DNode
     */
    public DNode getPrev() {
        return prev;
    }

    
    /** 
     * Returns a string containing information 
     * on the data in the node and the next node
     * 
     * @return String
     */
    @Override
    public String toString() {
        return "DNode{" +
                "data=" + data +
                ", next=" + next +
                              '}';
    }
}
