package DataStructures.List;

import java.util.Iterator;

public class LinkedList<E> implements List<E> {

	private class Node<E> {
		private Node<E> next;
		private E element;
		public Node() {
			this.next = null;
			this.element =null;
		}

		public Node(Node<E> next, E elm) {
			this.next = next;
			this.element = elm;
		}

		public Node(E elm) {
			this.element = elm;
			this.next=null;
		}
		public Node<E> getNext() {
			return next;
		}
		public void setNext(Node<E> next) {
			this.next = next;
		}
		public E getElement() {
			return element;
		}
		public void setElement(E element) {
			this.element = element;
		}

		public void clear() {
			this.next = null;
			this.element=null;
		}	

	}
	private Node<E> head;
	private int size;

	public LinkedList() {
		this.head = null;
		this.size = 0;
	}

	@Override
	public Iterator<E> iterator() {
		return new LinkedListIterator<E>();
	}

	@Override
	public void add(E obj) {
		Node<E> newNode = new Node<E>(obj);

		if(head == null)
			head = newNode;
		else {
			Node<E> temp = head;
			while(temp.getNext() != null) {
				temp = temp.getNext();
			}
			temp.setNext(newNode);
		}
		this.size++;
	}

	@Override
	public void add(int index, E obj) {

		Node<E> newNode = new Node<E>(obj);

		if(head == null)
			head = newNode;
		else {
			Node<E> temp = head;
			while(temp.getNext() != null) {
				temp = temp.getNext();
			}

			temp.setNext(newNode);
		}
		this.size++;

	}

	@Override
	public boolean remove(E obj) {
		Node<E> temp = head;
		for(int i = 0; i < this.size; i++) {
			if(temp.getElement().equals(obj))
				return remove(i);
			temp = temp.getNext();
		}
		return false;
	}

	@Override
	public boolean remove(int index) {
		if(index < 0 || index > size)
			throw new IndexOutOfBoundsException();
		if(index == 0) {
			Node<E> holdNode = this.head;
			this.head = this.head.getNext();
			holdNode.clear();
		}
		else {
			Node<E> previousNode = getNode(index - 1);
			// Get the node we want to remove
			Node<E> nodeToRemove = previousNode.getNext();
			// Update references
			previousNode.setNext(nodeToRemove.getNext());
			// Help GC
			nodeToRemove.clear();
		}
		size--;
		return true;
	}

	@Override
	public int removeAll(E obj) {
		int count = 0;
		Node<E> previousNode = null;
		Node<E> currentNode = head;
		while(currentNode != null) {
			if(currentNode.getElement().equals(obj)) {
				if(currentNode == head) {
					currentNode = currentNode.getNext();
					remove(0);

				}
				else {
					Node<E> holdNode = currentNode;
					previousNode.setNext(currentNode.getNext());
					currentNode = currentNode.getNext();
					holdNode.clear();
					size--;
				}
				count++;
			}
			else {
				previousNode = currentNode;
				currentNode = currentNode.getNext();
			}
		}
		return count;
	}

	public Node<E> getNode(int index) {
		if(index < 0 || index >=size)
			throw new IndexOutOfBoundsException();
		Node<E> temp = head;
		for(int i = 0; i < index; i++)
			temp = temp.getNext();
		return temp;
	}

	public E get(int index) {
		return this.getNode(index).getElement();
	}

	@Override
	public E set(int index, E obj) {
		Node<E> nodeToChange = this.getNode(index);
		E oldValue = nodeToChange.getElement();
		nodeToChange.setElement(obj);
		return oldValue;	}

	@Override
	public int firstIndex(E obj) {
		Node<E> temp = head;
		for(int  i = 0; i < this.size; i++) {
			if(temp.getElement().equals(obj))
				return i;
			temp = temp.getNext();
		}
		return -1;	}

	@Override
	public int lastIndex(E obj) {
		int pos = -1;
		Node<E> temp = head;
		for(int  i = 0; i < this.size; i++) {
			if(temp.getElement().equals(obj))
				pos = i;
			temp = temp.getNext();
		}
		return pos;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return size==0;
	}

	@Override
	public boolean contains(E obj) {
		return false;
	}

	@Override
	public void clear() {
		Node<E> temp = head;
		while(temp != null) {
			Node<E> holdNode = temp;
			temp =temp.getNext();
			holdNode.clear();

		}
		size = 0;
		head = null;

	}
	public String toString() {
		String str = "";
		for(E e: this)
			str+= e + " ";
		return str;
	}

	private class LinkedListIterator<E> implements Iterator<E> {
		private Node<E> currentNode;

		@SuppressWarnings("unchecked")
		public LinkedListIterator() {
			currentNode = (Node<E>) head;
		}

		@Override
		public boolean hasNext() {
			return currentNode != null;
		}
		@Override
		public E next() {
			E value = currentNode.getElement();
			currentNode = currentNode.getNext();
			return value;
		}

	}

}
