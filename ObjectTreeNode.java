
/**
 * ObjectTreeNode Class. Responsible for constructing/manipulating nodes in a ObjectBinaryTree tree
 *
 * @author (Luka Kolev, Student I.D = 012034735)
 * @version (11/20/19)
 */

// ObjectTreeNode.java

public class ObjectTreeNode implements ObjectTreeNodeInterface {
    private Object info;
    private ObjectTreeNode left;
    private ObjectTreeNode right;
    
    /**
     * // Default ctor  
     */
    public ObjectTreeNode() {
        info = null;
        left = null;
        right = null;
    }
    
     /**
     * // One-arg ctor
     */
    public ObjectTreeNode (Object o) {
        info = o;
        left = null;
        right = null;
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
     * // Sets left node
     *
     * @param     ObjectTreeNode p
     */
    public void setLeft(ObjectTreeNode p) {
        left = p;
    }
    
    /**
     * // Gets left node
     *
     * @return     ObjectTreeNode left
     */
    public ObjectTreeNode getLeft() {
        return left;
    }
    
    /**
     * // Sets right node
     *
     * @param     ObjectTreeNode p
     */
    public void setRight(ObjectTreeNode p) {
        right = p;
    }
    
    /**
     * // Gets right node
     *
     * @return     ObjectTreeNode left
     */
    public ObjectTreeNode getRight() {
        return right;
    }
}