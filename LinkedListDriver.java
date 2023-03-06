package assignment2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/*
 * LinkedListDriver.java
 * 
 * 
 * 
 * Commands:
 *  
	(i) - Insert value
	(d) - Delete value
	(p) - Print list
	(l) - Length
	(t) - Print reverse
	(r) - Reverse list
	(b) - Delete Subsection
	(s) - Swap Alternate
	(q) - Quit program
 *
 */

public class LinkedListDriver {
	
	public static DoublyLinkedList linkedList = null;
	public static String listType = "";
	public static Scanner scanner = new Scanner(System.in);
	
	// Takes in a string and returns it as a int, double, or string.
	public static Comparable convertStrToListType(String val) {
    	if (listType.equals("i")) {
        	return Integer.valueOf(val);
        } else if (listType.equals("d")) {
        	return Double.valueOf(val);
        }
		return val;
	}
	
	public static void processCommand(String cmd) {
		char char1 = cmd.charAt(0); // command
		
		switch (char1) {
			case 'i': //insert value		
				System.out.print("The list is: ");
				linkedList.print();
				
				System.out.print("Enter a value to insert: ");
				String val = scanner.next();
				
				linkedList.insertItem(convertStrToListType(val));
				
				System.out.print("The list is: ");
				linkedList.print();
				
				System.out.print("The reversed list is: ");
				linkedList.printReverse();
				
				break;
			case 'd': //delete value
				
				System.out.print("The list is: ");
				linkedList.print();
				
				System.out.print("Enter a value to delete: ");
				String val2 = scanner.next();
				
				linkedList.deleteItem(convertStrToListType(val2));
				
				System.out.print("The list is: ");
				linkedList.print();
				
				System.out.print("The reversed list is: ");
				linkedList.printReverse();
				
				
				break;
				
			case 't': //print reverse
				
				System.out.print("The reversed list is: ");
				linkedList.printReverse();

				break;
			case 'r': //reverse list 
				
				System.out.print("Input list: ");
				linkedList.print();
				
				linkedList.reverseList();
				
				System.out.print("The new list is: ");
				linkedList.print();
				break;
			case 's': //swap alternate
				
				System.out.print("Input list: ");
				linkedList.print();
				
				linkedList.swapAlternate();
				
				System.out.print("The new list is: ");
				linkedList.print();
				
				break;
			case 'b': //delete subsection	
				Comparable l;
				Comparable u;
				
				System.out.print("Enter the lower bound: ");
				l = convertStrToListType(scanner.next());
				
				System.out.print("Enter the upper bound: ");
				u = convertStrToListType(scanner.next());
				
				System.out.print("The original list is: ");
				linkedList.print();
				
				linkedList.deleteSubsection(l, u);
				
				System.out.print("The modified list is: ");
				linkedList.print();
				
				System.out.print("The reverse list is: ");
				linkedList.printReverse();
				
				break;
			case 'p': //print
				
				System.out.print("The list is: ");
				linkedList.print();
				
				break;
			case 'l': //length
				System.out.println("The length of the list is " + linkedList.length());		
				break;
			case 'q': //quit
				System.exit(0);
				break;
		}
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {	
		String fileName = null;
		
        if (args.length != 1) {
            System.err.println("Usage: java LinkedListDriver <file name>");
            //System.exit(1);
            fileName = "int-input.txt";
        }

        System.out.print("Enter list type (i - int, d - double, s - std:String): ");
        listType = scanner.nextLine();
        
        // initialize the doubly linked list
        if (listType.equals("i")) {
        	linkedList = new DoublyLinkedList<Integer>();
        } else if (listType.equals("d")) {
        	linkedList = new DoublyLinkedList<Double>();
        } else if (listType.equals("s")) {
        	linkedList = new DoublyLinkedList<String>();
        }
        
        // parse the file 
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine();
            String[] values = line.split(" ");
            
            // building the doubly linked list
            for (String value : values) {
            	if (listType.equals("i")) {
                	linkedList.insertItem(Integer.valueOf(value));
                } else if (listType.equals("d")) {
                	linkedList.insertItem(Double.valueOf(value));
                } else if (listType.equals("s")) {
                	linkedList.insertItem(value);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            System.exit(1);
        }
        
        // reading user input
	    while (true) {
	    	System.out.print("Enter a command: ");
	    	String cmd = scanner.next();
	    	
	    	if (cmd.equals("q")) { //quit
	    		break;
	    	}
	    	
	    	processCommand(cmd);	
	    }
	    
	    scanner.close();
	}
}
