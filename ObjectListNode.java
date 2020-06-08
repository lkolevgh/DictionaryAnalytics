
/**
 * ObjectListNode Class. Responsible for constructing/manipulating nodes in a ObjectList list
 *
 * @author (Luka Kolev, Student I.D = 012034735)
 * @version (11/20/19)
 */

// ObjectListNode.java

public class ObjectListNode implements ObjectListNodeInterface {
    private Object info;
    private ObjectListNode next;
    
    /**
     * // Default ctor  
     */
    public ObjectListNode() {
        info = null;
        next = null;
    }

    /**
     * // One-arg ctor
     */
    public ObjectListNode (Object o) {
        info = o;
        next = null;
    }    
    
    /**
     * // Two-arg ctor
     */
    public ObjectListNode (Object o, ObjectListNode p) {
        info = o;
        next = p;
    }       

    /**
     * // Sets info field
     *
     * @param     Object o (Object)
     */
    public void setInfo(Object o) {
        info = o;
    }    

    /**
     * // Returns object in info field
     *
     * @return    returns info (Object)
     */
    public Object getInfo() {
        return info;
    }

    /**
     * // Sets next field
     *
     * @param     ObjectListNode p (ObjectListNode)
     */
    public void setNext(ObjectListNode p) {
        next = p;
    }

    /**
     * // Returns object in info field
     *
     * @return    returns next (ObjectListNode)
     */
    public ObjectListNode getNext() {
        return next;
    }
}