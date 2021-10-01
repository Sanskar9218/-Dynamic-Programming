/*class Node{
	public int data;
	public Node next;
	public Node prev;
	
	public Node(int d)
	{
		data = d;
	}
}*/

public class DoublyLL {
	
	Node head;
	Node tail;
	
	public void insertFirst(int d) {
		Node newNode = new Node(d);
		if(head == null)
		{
			head = newNode;
			newNode.next = null;
			newNode.prev = null;
			tail = newNode;
		}
		else {
			head.prev = newNode;
			newNode.next = head;
			newNode.prev = null;
			head = newNode;
		}
	}
	
	public void insertLast(int d) {
		Node newNode = new Node(d);
		if(head == null) {
			head = newNode;
			newNode.next = null;
			newNode.prev = null;
			tail = newNode;
		}
		else {
			newNode.prev = tail;
			tail.next = newNode;
			tail = newNode;
			newNode.next = null;
		}
	}
	
	public void deleteFirst() {
		head = head.next;
		head.prev = null;
	}
	
	public void deleteLast() {
		tail = tail.prev;
		tail.next = null;
	}
	
	public void show() {
		Node ptr = tail;
		while(ptr != null)
		{
			System.out.print(ptr.data+" ");
			ptr = ptr.prev;
		}
		System.out.println("");
	}
	
	public static void main(String args[])
	{
		DoublyLL ob = new DoublyLL();
		
		ob.insertLast(1);
		ob.insertLast(2);
		ob.insertLast(3);
		ob.insertLast(4);
		ob.insertLast(5);
		
		ob.show();
		
		ob.deleteFirst();
		
		ob.show();
		
		ob.deleteLast();
		
		ob.show();
	}
}