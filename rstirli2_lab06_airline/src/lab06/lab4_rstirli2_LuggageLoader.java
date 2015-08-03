package lab06;

interface Stack<T> {
    void push(T ele);
    T pop();
    boolean isEmpty();
}

public class lab4_rstirli2_LuggageLoader<T> implements Stack<T> {
	
	private int size=0;
	
	private class StackNode {
        private T data;
        private StackNode next;
    }
	
	private StackNode top;
	
	public void push(T ele)
	{
		if (size==0)
		{
			top= new StackNode();
			top.data=ele;
		}
		
		else 
		{
			StackNode add = new StackNode();
			add.data=top.data;
			top.next=add;
			top.data=ele;
		}
		size++;
		System.out.println(size);

		
	}
	
	public T pop()
	{
		if (size>0)
		{
			T ele = top.data;
			top=top.next;
			size--;
			return ele;
		}
		else
		{
			System.out.println("nothing to pop");
			return null;
		}
		
	}
	
	public boolean isEmpty()
	{
		if (size<=0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public int getSize()
	{
		return size;
	}

}
