package linked;

import java.util.*;


public class CharLinkedList 
{
	private CharNode		head;	// Empty if head and
	private CharNode		tail;	// tail are null
	
	
	public CharLinkedList()		{ }
	
	
	public CharLinkedList(String s)
	{
		for (int i=s.length()-1; i>=0; i--)
			insertAtHead(s.charAt(i));
	}
	
	
	public void insertAtHead(char ch)
	{
		assert hasIntegrity();		// Precondition
		
		CharNode node = new CharNode(ch);
		node.setNext(head);
		head = node;
		if (tail == null)
			tail = node;			// Corner case: inserting into empty node
		
		assert hasIntegrity();		// Postcondition
	}
	
	
	public String toString()
	{
		String s = "";
		CharNode node = head;
		while (node != null)
		{
			s += node.getData();
			node = node.getNext();
		}
		return s;
	}
	
	
	//
	// Returns true if this list has emptiness integrity, has tail integrity, has no loops,  
	// and tail is reachable from head.
	//
	// Caution: this checks for most but not all common integrity problems. 
	//
	boolean hasIntegrity()
	{
		// Check emptiness. If either head or tail is null, the other must
		// also be null. Different logic from what you saw in lecture. Returns
		// immediately if this list is empty.
		if (head == null  ||  tail == null)
			return head == null  &&  tail == null;
		
		// Check tail integrity (tail.next must be null).
		if (tail.getNext() != null)
			return false;
		
		// Check for loops.
		Set<CharNode> visitedNodes = new HashSet<>();
		CharNode node = head;
		while (node != null)
		{
			if (visitedNodes.contains(node))
				return false;		// Current node has been visited before, we must have a loop
			visitedNodes.add(node); // First visit to this node
			node = node.getNext();
		}
		
		// Make sure tail is reachable from head.
		node = head;
		while (node != null && node != tail)
			node = node.getNext();
		return node == tail;
	}
	
	
	//finds the node with the given data
	public CharNode find(char ch)
	{
		CharNode node = head;
		assert hasIntegrity():"The list doesn't have integrity";
		while(node!=null)
		{
			if(node.getData()==ch)
			{
				return node;
			}
			node=node.getNext();
		}
		return null;
	}
	
	//duplicates the node with the given data
	public void duplicate(char ch)
	{
		assert hasIntegrity():"The list doesn't have integrity";
		
		CharNode node = this.find(ch);				//Uses the find method to find the node with given data
		
		if(node==null)
			return;
		else if(node!=tail)							//duplicates when the node is not the tail
		{
			CharNode nextNode = node.getNext();
			CharNode newNode = new CharNode(ch);
			node.setNext(newNode);					//first setting the next node to the new node
			newNode.setNext(nextNode);				//Setting the node after the new node to the next node in the list
		}
		else										//duplicates when the node is tail
		{
			CharNode newNode = new CharNode(ch);
			tail=newNode;							//sets the new node to the tail
			node.setNext(newNode);					//Setting the new node to the next node in the list
			
		}
	}
	
	static void sop(Object x) 		{ System.out.println(x); }
}
