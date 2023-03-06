package assignment2;

/*
 * NodeType.java
 * NodeType class that uses generics.
 */

public class NodeType<T extends Comparable<T>> {
	public T info;
	public NodeType<T> next;
	public NodeType<T> back;
	
	
};
