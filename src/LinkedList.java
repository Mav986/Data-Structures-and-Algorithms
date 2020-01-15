import java.util.*;

/**
 * FILE: 	LinkedList.java
 * AUTHOR: 	Kalon Shannon-Innes
 * ID: 		18529687
 * UNIT: 	Data Structures and Algorithms
 * DATE: 	May 19, 2017 
 * SOURCE: 	Unmodified version of GenericLinkedList.java I submitted for Prac07
 */
public class LinkedList<E> implements Iterable<E>
{
	private ListNode<E> head;
	private ListNode<E> tail;

	/**
	 * NAME: Default Constructor
	 * IMPORT: none
	 * EXPORT: none
	 * PURPOSE: Create a default LinkedList object
	 */
	public LinkedList()
	{
		setHead(null);
		setTail(null);
	}

	/**
	 * NAME: setHead
	 * IMPORT: inDLN (Generic ListNode)
	 * EXPORT: none
	 * PURPOSE: Setter for head class field 						
	 */
	public void setHead(ListNode<E> inDLN)
	{
		head = inDLN;
	}
	
	/**
	 * NAME: setTail
	 * IMPORT: inDLN (Generic ListNode)
	 * EXPORT: none
	 * PURPOSE: Setter for tail class field 						
	 */
	public void setTail(ListNode<E> inDLN)
	{
		tail = inDLN;
	}
	
	/**
	 * NAME: getHead
	 * IMPORT: none
	 * EXPORT: headCopy (Generic ListNode)
	 * PURPOSE: Getter for head class field 						
	 */
	public ListNode<E> getHead()
	{
		ListNode<E> headCopy = new ListNode<E>(head);
		
		return headCopy;
	}
	
	/**
	 * NAME: getTail
	 * IMPORT: none
	 * EXPORT: tailCopy (Generic ListNode)
	 * PURPOSE: Getter for tail class field 						
	 */
	public ListNode<E> getTail()
	{
		ListNode<E> tailCopy = new ListNode<E>(tail);
		
		return tailCopy;
	}

	/**
	 * NAME: insertFirst
	 * IMPORT: newValue (Generic)
	 * EXPORT: none
	 * PURPOSE: Insert a new value into the start of the list
	 */
	public void insertFirst(E newValue)
	{
		ListNode<E> newNd = new ListNode<E>(newValue);
		
		if(isEmpty())
		{
			setHead(newNd);
			setTail(newNd);
		}
		else if(head.getNext() == null)
		{
			newNd.setNext(head);
			setTail(head);
			tail.setPrev(newNd);
			setHead(newNd);
		}
		else
		{
			head.setPrev(newNd);
			newNd.setNext(head);
			setHead(newNd);
		}
	}
	
	/**
	 * NAME: insertLast
	 * IMPORT: newValue (Generic)
	 * EXPORT: none
	 * PURPOSE: Insert a new value at the end of the list
	 */
	public void insertLast(E newValue)
	{
		ListNode<E> newNd = new ListNode<E>(newValue);

		if(isEmpty())
		{
			setHead(newNd);
		}
		else if(head.getNext() == null)
		{			
			head.setNext(newNd);
			newNd.setPrev(head);
			setTail(newNd);
		}
		else
		{
			tail.setNext(newNd);
			newNd.setPrev(tail);
			setTail(newNd);
		}
	}

	/**
	 * NAME: removeFirst
	 * IMPORT: none
	 * EXPORT: nodeVal (Generic)
	 * PURPOSE: Remove the first value from the list					
	 */
	public E removeFirst()
	{
		ListNode<E> node;
		E nodeVal;
		
		if(isEmpty())
		{
			throw new NullPointerException();
		}
		else if(head.getNext() == null)
		{
			node = getHead();
			setHead(null);
			setTail(null);
		}			
		else
		{
			node = getHead();
			setHead(head.getNext());
		}
		nodeVal = node.getValue();
		
		return nodeVal;
	}
	
	/**
	 * NAME: removeLast
	 * IMPORT: none
	 * EXPORT: nodeVal (Generic)
	 * PURPOSE: Remove the last value from the list					
	 */
	public E removeLast()
	{
		ListNode<E> node;
		E nodeVal;
		
		if(isEmpty())
		{
			throw new NullPointerException();
		}
		else if(head.getNext() == null)
		{
			node = getHead();
			setHead(null);
			setTail(null);
		}
		else
		{
			node = getTail();
			setTail(tail.getPrev());
		}
		nodeVal = node.getValue();
		
		return nodeVal;
	}

	/**
	 * NAME: peekFirst
	 * IMPORT: none
	 * EXPORT: nodeVal (Generic)
	 * PURPOSE: Look at the first value in the list					
	 */
	public E peekFirst()
	{
		ListNode<E> node;
		E nodeVal;
		
		if(isEmpty())
		{
			throw new NullPointerException();
		}
		else
		{
			node = getHead();
		}
		nodeVal = node.getValue();
		
		return nodeVal;
	}
	
	/**
	 * NAME: peekLast
	 * IMPORT: none
	 * EXPORT: nodeVal (Generic)
	 * PURPOSE: Look at the last value in the list					
	 */
	public E peekLast()
	{
		ListNode<E> node;
		E nodeVal;
		
		if(isEmpty())
		{
			throw new NullPointerException();
		}
		else
		{
			node = getTail();
		}
		nodeVal = node.getValue();
		
		return nodeVal;
	}
	
	/**
	 * NAME: isEmpty
	 * IMPORT: none
	 * EXPORT: empty (Boolean)
	 * PURPOSE: Check if the list is empty						
	 */
	public boolean isEmpty()
	{
		boolean empty = (head == null);
		
		return empty;
	}
	
	/**
	 * NAME: iterator
	 * IMPORT: none
	 * EXPORT: newIter (Generic Iterator)
	 * PURPOSE: Accessor for LinkedList.LinkedListIterator
	 */
	public Iterator<E> iterator()
	{
		Iterator<E> newIter = new LinkedListIterator<E>(this);
		
		return newIter;
	}
	
	/**
	 * FILE: 	LinkedList.ListNode
	 * AUTHOR: 	Kalon Shannon-Innes
	 * ID: 		18529687
	 * UNIT: 	Data Structures and Algorithms
	 * DATE: 	May 19, 2017 
	 * SOURCE: 	Unmodified version of GenericLinkedList.DSAListNode I submitted for Prac07
	 */
	private class ListNode<N>
	{
		private N value;
		private ListNode<N> next;
		private ListNode<N> prev;

		/**
		 * NAME: Standard Constructor
		 * IMPORT: inValue (Generic)
		 * EXPORT: none
		 * PURPOSE: Create a default ListNode
		 */
		public ListNode(N inValue)
		{
			setValue(inValue);
			setNext(null);
			setPrev(null);
		}

		/**
		 * NAME: Copy Constructor
		 * IMPORT: dln (Generic ListNode)
		 * EXPORT: none
		 * PURPOSE: Create a copy of a Generic ListNode
		 */
		public ListNode(ListNode<N> dln)
		{
			setValue(dln.getValue());
			setNext(dln.getNext());
			setPrev(dln.getPrev());
		}
		
		/**
		 * NAME: setValue
		 * IMPORT: val (Generic)
		 * EXPORT: none
		 * PURPOSE: Setter for value class field
		 */
		public void setValue(N val)
		{
			value = val;
		}
		
		/**
		 * NAME: setNext
		 * IMPORT: inNext (Generic ListNode)
		 * EXPORT: none
		 * PURPOSE: Setter for next class field
		 */
		public void setNext(ListNode<N> inNext)
		{
			next = inNext;
		}
		
		/**
		 * NAME: setPrev
		 * IMPORT: inPrev (Generic ListNode)
		 * EXPORT: none
		 * PURPOSE: Setter for prev class field
		 */
		public void setPrev(ListNode<N> inPrev)
		{
			prev = inPrev;
		}
		
		/**
		 * NAME: getValue
		 * IMPORT: none
		 * EXPORT: value (Generic)
		 * PURPOSE: Getter for value class field
		 */
		public N getValue()
		{
			return value;
		}
		
		/**
		 * NAME: getNext
		 * IMPORT: none
		 * EXPORT: next (Generic ListNode)
		 * PURPOSE: Getter for next class field
		 */
		public ListNode<N> getNext()
		{
			return next;
		}
		
		/**
		 * NAME: getPrev
		 * IMPORT: none
		 * EXPORT: prev (Generic ListNode)
		 * PURPOSE: Getter for prev class field
		 */
		public ListNode<N> getPrev()
		{
			return prev;
		}
	}
	
	/**
	 * FILE: 	LinkedList.LinkedListIterator
	 * AUTHOR: 	Kalon Shannon-Innes
	 * ID: 		18529687
	 * UNIT: 	Data Structures and Algorithms
	 * DATE: 	May 19, 2017 
	 * SOURCE: 	Unmodified version of GenericLinkedList.DSALinkedListIterator I submitted for Prac07
	 */
	private class LinkedListIterator<I> implements Iterator<I>
	{
		private LinkedList<I>.ListNode<I> iterNext;
		
		/**
		 * NAME: Standard Constructor
		 * IMPORT: list (Generic LinkedList)
		 * EXPORT: none
		 * PURPOSE: Create a default LinkedListIterator
		 */
		public LinkedListIterator(LinkedList<I> list)
		{
			iterNext = list.head;
		}
		
		/**
		 * NAME: hasNext
		 * IMPORT: none
		 * EXPORT: hasNext (Boolean)
		 * PURPOSE: Check if the iterator has a next node
		 */
		public boolean hasNext()
		{
			boolean hasNext = (iterNext != null);
			
			return hasNext;
		}
		
		/**
		 * NAME: next
		 * IMPORT: none
		 * EXPORT: val (Generic)
		 * PURPOSE: Get the next value from the iterator
		 */
		public I next()
		{
			I val;
			if(iterNext == null)
			{
				val = null;
			}
			else
			{
				val = iterNext.getValue();
				iterNext = iterNext.getNext();
			}
			return val;
		}
		
		/**
		 * NAME: remove
		 * IMPORT: none
		 * EXPORT: none
		 * PURPOSE: Remove a value from the iterator
		 * NOTE: Not implemented at this time
		 */
		public void remove()
		{
			throw new UnsupportedOperationException("Not Supported");
		}
	}
}
