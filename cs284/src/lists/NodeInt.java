
/*
 * Brandon Patton and Liam King
 * I pledge my honor that I have abided by the Stevens Honor System.
 */

package lists;

public class NodeInt {
    // Data fields
    private Integer data;
    private NodeInt next;
	
    // Constructors
    NodeInt(Integer data) {
	this.data=data;
	this.next=null;
    }
    NodeInt(Integer data, NodeInt next) {
	this.data=data;
	this.next=next;
    }
	

 
    public boolean allEven() {
    	if(this.data == null) {
    		throw new IllegalArgumentException();
    	}
    	NodeInt current = this;
    	while(current.next != null) {
    		if(current.data % 2 != 0) {
    			return false;
    		}
    		current = current.next;
    	}
    	if(current.data % 2 != 0) {
    		return false;
    	}
    	return true;
	    }
    public NodeInt stutter() {
    	if(this.data == null) {
    		throw new IllegalArgumentException();
    	}
    	NodeInt current = this;
    	while(current.next != null) {
    		NodeInt temp = new NodeInt(current.data, current.next);
    		current.next = temp;
    		current = current.next.next;
    	}
    	NodeInt temp = new NodeInt(current.data, current.next);
    	current.next = temp;
    	return this;
	    }
    	
    public String toString() {
	if (next==null) {
	    return data.toString();
	} else {
	    return data.toString() + "," + next.toString();
	}
    }
    
    public static void main(String[]  args) {
	NodeInt n1 = new NodeInt(4);
	NodeInt n2 = new NodeInt(2,n1);
	NodeInt n3 = new NodeInt(6,n2);
		
	System.out.println(n3.allEven());
	System.out.println(n3);
	System.out.println(n3.stutter());
    }
}
