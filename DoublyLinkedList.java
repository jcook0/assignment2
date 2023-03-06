package assignment2;

import java.util.Stack;

/*
 * DoublyLinkedList.java
 * 
 * A sorted doubly linked list implementation that has unique elements. 
 * Each node can point to the next or previous node. 
 * 
 	void insertItem(T item)
	void deleteItem(T item)
	int length()
	boolean doesItemExist()
	void print()
	void printReverse()

 */

public class DoublyLinkedList<T extends Comparable<T>> {
	
	private NodeType<T> head;
	private int length;	
	
	// constructor
	public DoublyLinkedList() {
		
	}
	
	// doesItemExist()
	// takes in a parameter returns true if the item is present or false if it's not found.
	public boolean doesItemExist(T item) {
		if (head == null) {
			return false;
		} 
		
		NodeType<T> curNode = head;
		
		while (curNode != null) {
			
			if (curNode.info.compareTo(item) == 0) {
				System.out.println("Item already exists");
				return true;
			}
			
			if (curNode.next == null) {
				break;
			}
			
			curNode = curNode.next;
		}
		
		return false;
	}
	
	public void deleteItem(T item) {
		if (head == null) {
			return;
		} 
		
		NodeType<T> curr = head;
	 
	    while (curr != null) {
	        if (curr.info.compareTo(item) == 0) { // item found
	        	// if curr is the head
	            if (curr.back == null) {
	                head = curr.next;
	            } else {
	                curr.back.next = curr.next;
	            }
	            
	            if (curr.next != null) {
	                curr.next.back = curr.back;
	            }
	            
	            length--;
	            
	            return;
	        }      
	        curr = curr.next;
	    }
	}
	
	public void insertItem(T item) {
		// creates the node object to insert
		NodeType<T> newNode = new NodeType<T>();
		newNode.info = item;
		
		if (head == null) {
			head = newNode;
			return;
		}
		
		// calling doesItemExist() makes this operation slower
		if (doesItemExist(item) == true) {
			return;
		}
		
		NodeType<T> curNode = head;
				
		while (curNode != null) {
			if (curNode.info.compareTo(item) == 1) { // curNode.info is greater than item
				newNode.next = curNode;
				
				if (curNode.back != null) {
					curNode.back = newNode;
				}
				
				if (head == curNode) {
					newNode = head;
				}
				
				this.length++;
				
				break;
			}
			
			// if the end of the linked list is reached
			if (curNode.next == null) {	
				curNode.next = newNode;
				newNode.back = curNode;	
				this.length++;
				break;
			}
			
			curNode = curNode.next;
		}
	}

	public int length() {
		if (head == null) {
			this.length = 0;
		}
		
		return this.length;
	}
	
	public void print() {
		if (head == null) {
			return;
		} 
		
		NodeType<T> curNode = head;
		
		while (curNode != null) {
			System.out.print(curNode.info + " ");
			curNode = curNode.next;
		}
		
		System.out.println();
	}
	
	public void printReverse() {
		Stack<T> stack = new Stack<T>(); // stack
		NodeType<T> curNode = head;
		
		while (curNode != null) {
			stack.push(curNode.info); //add to stack
						
			if (curNode.next == null) {
				break;
			}
			
			curNode = curNode.next;
		}
		
		while(stack.size() > 0) {
			System.out.print(stack.pop() + " "); // pop off the stack
		}
		
		System.out.println(); 
		
	}
	
	public void deleteSubsection(T lower, T upper) {
		if (head == null) {
			return;
		}
		
		NodeType<T> curNode = head;		
		
		while (curNode != null) {
			//System.out.print(curNode.info + " ");	
			
			if (curNode.info.compareTo(lower) == -1 || curNode.info.compareTo(upper) == -1)
			{
				deleteItem(curNode.info);
			}

			// end of list reached
			if (curNode.next == null) {
				return;
			}
			
			curNode = curNode.next;
		}
	}
	
	public void reverseList() {
		if (head == null) {
			return;
		}
		
        NodeType<T> curNode = head;
        NodeType<T> tempNode = null;

        while (curNode != null) {
        	tempNode = curNode.back;
        	curNode.back = curNode.next;
        	curNode.next = tempNode;
        	curNode = curNode.back;
        	
        	if (curNode.next == null) {
        		break;
        	}
        
        }  
        if (tempNode != null) {
            head = tempNode.back;
        }
        

	}

    public void swapAlternate() {
		if (head == null) {
			return;
		}
		
		
		
    }
	

};