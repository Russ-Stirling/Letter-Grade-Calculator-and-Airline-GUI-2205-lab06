package lab06;

interface Queue<T> {
    void enqueue(T ele);
    T dequeue();
}

public class rstirli2_WaitingList<T> implements Queue<T> {
	
	private int size=0;
	
	private class Node {
        private T data;
        private Node next;
    }
	
	private Node head, tail;
	
	public rstirli2_WaitingList() {}
	
	public int getSize()
	{
		return size;
	}
	
	public T getData(int num)
	{
		Node current;
		current = head;
		T data=null;
		for (int i=0; i<num; i++)
		{
			current=current.next;
		}
		
		data = current.data;
		
		return data;
				
	}
	
	
	
	public void enqueue(T ele)//public rstirli2_WaitingList<T> enqueue(T ele)
    {
        Node current = tail;
        tail = new Node();
        tail.data = ele;

        if (size == 0) 
        {
        	head = tail;
        }
        else 
        {
        	current.next = tail;
        }
        size++;
        //return this;
    }
	
	public void addToFront(T ele)
	{
		Node current = new Node();
		current.data=ele;
		current.next=head;
		head=current;
		size++;
	}
	
    public T dequeue()
    {
        if (size == 0) throw new java.util.NoSuchElementException();
        T ele = head.data;
        head = head.next;
        if (size == 1) tail = null;
        size--;
        return ele;
    }
    
    public boolean remove(T ele)
    {
    	
    	Node current, previous=null;
		current = head;
		
		if (current.data.equals(ele))
    	{
			
	        head = head.next;
	        if (size == 1) tail = null;
	        
    		size--;
    		return true;
    	}
		previous=current;
		current=current.next;
		
		for (int i=1; i<size; i++)
		{
			if (current.data.equals(ele))
			{
				current=current.next;
				previous.next=current;
				size--;
				return true;
			}
			previous=current;
			current=current.next;
		}
		return false;
    }
    
}
