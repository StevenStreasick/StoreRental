import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**************************************************************
 * Functionality of a double Linked list
 *
 * @author Steven
 * @version 4/8/2022
 **************************************************************/
public class MyDoubleWithOutTailLinkedList implements Serializable {
    
    /** The object on top of the list */
    private DNode top;

    /** current size of the list */
    private int size;

    public MyDoubleWithOutTailLinkedList() {
        top = null;
    }

    
    /**
     * Returns the size of the linked list
     * 
     * @return int
     */
    public int size() {
        return this.size;
    }

    /**
     * Removes all of the elements inside of the Linked List
     */
    public void clear() {

        //Get all the elements
        while(top != null) {
           remove(0);
        }

        //size = 0;
    }


    
    /** 
     * Returns the element at a certain position. 
     * 
     * @param index
     * @return Rental
     * @throws IndexOutOfBoundsException If an input is greater then
     *                                   or equal to size, 
     *                                   or less than 0
     */
    public Rental get(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                "Invalid index for list of size " + size
                );
        }
        else {
            int i = 0;
            DNode cur = top;
            while (i < index) {
                cur = cur.getNext();
                i++;
            }
            return cur.getData();
        }

        
    }

    
    /** 
     * Removes the element at the specified location. 
     * 
     * @param index
     * @return Rental
     * @throws IndexOutOfBoundsException If an input is greater then
     *                                   or equal to size, 
     *                                   or less than 0
     */
    public Rental remove(int index) {

        /** The element currently being analyzed */
        DNode currentNode = top;

        /** The node previous of currentNode */
        DNode previousNode = null;

        /** The node after currentNode */
        DNode nextNode;

        /** The current index of the loop */
        int i = 0;

        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                "Invalid index for list of size " + size
                );
        }

        //Go through all elements
        while(currentNode != null) {

            //If the currentNode is the one we want to remove
            if(i == index) { 
                nextNode = currentNode.getNext();
                //If the array is one element long -> Clean it up
                if(top.getNext() == null && top.getPrev() == null) {
                    top = null;
                }else {

                    //first element
                    if(previousNode == null) { 
                        top = nextNode; 
                        nextNode.setPrev(null);
                    } else if(nextNode == null) {
                        currentNode.setPrev(null);
                        previousNode.setNext(null);
                    } else {
                        nextNode.setPrev(previousNode);
                        previousNode.setNext(nextNode);
                    }  
                }
                size--;
                return currentNode.getData();   
            }
            
            i++;
            previousNode = currentNode;
            currentNode = currentNode.getNext();
        }
        return null;
    }

    
    /** 
     * Inserts the object v inbetween the before and after DNodes
     * 
     * @param after
     * @param before
     * @param v
     */
    private void insert(DNode after, DNode before, Rental v) {

        /** The object to insert into the list. Contains data v */
        DNode objectToInsert;

        if((after != null || before != null)) {
            if(v != null) {
                //Insert object as head
                if(before == null) {
                    objectToInsert = new DNode(v, after, null);

                    top = objectToInsert;
                    after.setPrev(objectToInsert);

                //Insert object as tail
                } else if(after == null) {
                    objectToInsert = new DNode(v, null, before);

                    before.setNext(objectToInsert);
                } else {
                    objectToInsert = new DNode(v, after, before);

                    before.setNext(objectToInsert);
                    after.setPrev(objectToInsert);
                    
                }
                size++;
            }     
        } else if(after == null & before == null && v != null) {
            objectToInsert = new DNode(v, after, before);

            top = objectToInsert;
            size++;
        } 
    }

    
    /** Adds the element into the list, inserting 
     * games before consoles based off of the due date (Oldest first).
     * If it's the same game and the same due date, 
     * then it will sort by renter's name.
     * 
     * @param r
     */
    public void add(Rental r) {
        
        DNode v = top;
        for(int i = 0; i < size; i++) {
            if(r instanceof Game) {
                if(v.getData() instanceof Game) { 
                
                    //Check due date.
                    if(v.getData().getDueBack()
                            .compareTo(r.getDueBack()) > 0) {
                        insert(v, v.getPrev(), r);
                        return;
                    }

                    //If the due dates are the same
                    if(v.getData().getDueBack()
                            .compareTo(r.getDueBack()) == 0) {

                        //Sort by renter's name.
                        if(v.getData().getNameOfRenter()
                                .compareTo(r.getNameOfRenter()) > 0) {
                            insert(v, v.getPrev(), r);
                            return;
                        }
                    } 

                //If r is a game, and it hasn't been added yet,
                //add before we switch to consoles
                } else {
                    insert(v, v.getPrev(), r);
                    return;
                }
            
            //Type is console
            } else if(v.getData() instanceof Console && 
                    r instanceof Console) {
                
                //Sort by renter's dueDate.
                if(v.getData().getDueBack()
                        .compareTo(r.getDueBack()) > 0) {
                   
                    insert(v, v.getPrev(), r);
                    return;
 
                } else if(v.getData().getDueBack()
                        .compareTo(r.getDueBack()) == 0) { 
                    if(v.getData().getNameOfRenter()
                            .compareTo(r.getNameOfRenter()) > 0) {
                        insert(v, v.getPrev(), r);
                        return;
                    }
                }
            }
            //Append to the end of the list.
            if(v.getNext() == null) {
                insert(null, v, r); 
                return;
            }

            v = v.getNext();
        }
        if(top == null) {
            insert(null, null, r);
        }
    }

    /** 
     * Prints all of the elements of the list into the output
     */
    public void display() {
        DNode temp = top;
        while (temp != null) {
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
    }

    
    /** 
     * Returns a string containing information 
     * on the top and the size of the list.
     * 
     * @return String
     */
    public String toString() {
        return "LL {" +
                "top=" + top +
                ", size=" + size() +
                '}';
    }


   
    /** 
     * <b>This constructor is purely for testing purposes </b> <p>
     * Creates a double linkedList with all of the 
     * elements within an ArrayList
     * 
     * @param rentals
     */
    public MyDoubleWithOutTailLinkedList(ArrayList<Rental> rentals) {
        DNode prev = null;

        for(int i=0; i<rentals.size(); i++) {
            DNode cur = new DNode(rentals.get(i), null, null);

            size++;
            if (i == 0) {
                top = cur;
            }
            else {
                // updates prev for this node
                cur.setPrev(prev);
                // updates next for node before this
                prev.setNext(cur);
            }
            prev = cur;
        }
    }

    
    /** 
     * Returns the node at the top of the list
     * 
     * @return DNode
     */
    public DNode getTop() {
        return top;
    }


}