
/**
 * ObjectTreeNodeInterface Interface
 *
 * @author (Luka Kolev, Student I.D = 012034735)
 * @version (11/20/19)
 */
public interface ObjectTreeNodeInterface {
	public void setInfo(Object o);
	public Object getInfo();
	public void setLeft(ObjectTreeNode p);
	public ObjectTreeNode getLeft();
	public void setRight(ObjectTreeNode p);
	public ObjectTreeNode getRight();
}
