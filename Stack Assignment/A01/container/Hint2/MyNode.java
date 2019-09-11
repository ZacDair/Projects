
/**
* This class models the concept (a type of objects) of a single linked node<br>. 
*/
public class MyNode {

	//--------------------------------------------------
	// Attributes
	//--------------------------------------------------
	/**
	 * @param info: It represent the element contained in MyNode.
	 * @param next: It represents the MyNode placed next (referenced) from this object.
	 */
	private int info;
	private MyNode next;
	
	//--------------------------------------------------
	// Constructor
	//--------------------------------------------------
	/**
	 * The constructor creates 1 instance (1 object) of the class MyNode<br>
	 * @param i: The element contained in MyNode.
	 * @param n: The MyNode placed next (referenced) from this object.
	 */
	public MyNode(int i, MyNode n){
		this.info = i;
		this.next = n;
	}
	
	//--------------------------------------------------
	// Get methods
	//--------------------------------------------------
	/**
	 * Given a concrete MyNode (this), the function returns its content.<br>
	 * @return: The content of the concrete object (this) calling to the method.
	 */	
	public int getInfo(){
		return this.info;
	}
	
	/**
	 * Given a concrete MyNode (this), the function returns the MyNode placed next (referenced) from this object.<br>
	 * @return: The content of the concrete MyNode placed next (referenced) from this object.
	 */	
	public MyNode getNext(){
		return this.next;
	}
	
	//--------------------------------------------------
	// Set methods
	//--------------------------------------------------
	/**
	 * Given a concrete MyNode (this), the function modifies its content.<br>
	 * @param i: The new content of the concrete object (this) calling to the method.
	 */	
	public void setInfo(int i){
		this.info = i;
	}
	
	/**
	 * Given a concrete MyNode (this), the function modifies the MyNode placed next (referenced) from this object.<br>
	 * @param n: The new MyNode placed next (referenced) from this object.
	 */		
	public void setNext(MyNode n){
		this.next = n;
	}

}
