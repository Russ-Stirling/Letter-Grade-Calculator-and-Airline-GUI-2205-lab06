package lab06;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;
public class rstirli2_lab01_Flight {
	
	private String name = "unknown";
	private int size;
	private LinkedList<rstirli2_lab01_Passenger> passengers;
	private int currentSize=0;
	private rstirli2_WaitingList waitingList= new rstirli2_WaitingList();
	private lab4_rstirli2_LuggageLoader<rstirli2_lab01_Passenger> luggage = new lab4_rstirli2_LuggageLoader();
	
	
	public rstirli2_lab01_Flight(String n){
		name = n;
		size = 5;
		passengers = new LinkedList<rstirli2_lab01_Passenger>();
	}
	
	public LinkedList<rstirli2_lab01_Passenger> getPassengerLink()
	{
		return passengers;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void addToQueue(rstirli2_lab01_Passenger test)
	{
		waitingList.enqueue(test);
	}
	
	public void addToLuggage(rstirli2_lab01_Passenger pass)
	{
		luggage.push(pass);
	}
	
	public boolean luggageEmpty()
	{
		return luggage.isEmpty();
	}
	
	public String getLuggageList()
	{
		String info;
		int lSize=luggage.getSize();
		rstirli2_lab01_Passenger[] pass=new rstirli2_lab01_Passenger[luggage.getSize()];
		info= "<html>Luggage List: "+name;
		for (int i=0; i<lSize; i++)
		{
			pass[i]=(rstirli2_lab01_Passenger)luggage.pop();
			info += "<br>"+(i+1)+":";
			info += " ("+pass[i].getID()+") "+pass[i].getName()+"'s luggage.";
		}
		
		info += "</html>";
		
		for (int i=1; i<=lSize; i++)
		{
			luggage.push(pass[lSize-i]);
		}
		
		return info;
	}
	
	public rstirli2_lab01_Passenger removeFromQueue()
	{
		rstirli2_lab01_Passenger test = (rstirli2_lab01_Passenger) waitingList.dequeue();
		return test;
	}
	
	public rstirli2_lab01_Passenger removeFromLuggage()
	{
		rstirli2_lab01_Passenger test = (rstirli2_lab01_Passenger) luggage.pop();
		return test;
	}
	
	public String waitingListInfo()
	{
		String info;
		
		if (waitingList.getSize()<=0)
		{
			info = "There are no Passengers on the waiting list";
			return info;
		}
		
		else
		{
			info= "<html>Waiting List:";
			for (int i=0; i<waitingList.getSize(); i++)
			{
				info += "<br>"+(i+1)+":";
				info += " "+((rstirli2_lab01_Passenger)waitingList.getData(i)).getName();
				info += " "+((rstirli2_lab01_Passenger)waitingList.getData(i)).getID();
			}
			
			info += "</html>";
			return info;
		}
	}
	
	public void removeFromWait(rstirli2_lab01_Passenger pass)
	{
		waitingList.remove(pass);
	}
	
	public boolean checkOn(String id)
	{
		for (int i=0; i<waitingList.getSize(); i++)
		{
			if (((rstirli2_lab01_Passenger)waitingList.getData(i)).getID().equals(id))
			{
				return false;
			}
		}
		
		return true;
	}
	
	public void reSize(int s)
	{
		size=s;
		//implement linked list wait list adjustment
	}
	
	public rstirli2_WaitingList getQueue()
	{
		return waitingList;
	}
	
	public int getSize()
	{
		return size;
	}
	
	public int getCurrentSize()
	{
		return currentSize;
	}
	
	public boolean checkForPassenger(String id)
	{
		
		ListIterator<rstirli2_lab01_Passenger> iterator = passengers.listIterator();

		while (iterator.hasNext())
		{
			if (iterator.next().getID().equals(id))
			{
				return true;
			}
			
		}
		
		return false;
	}
	
	
	public rstirli2_lab01_Passenger getPassenger(String id)
	{
		
		rstirli2_lab01_Passenger selected= null;
		ListIterator<rstirli2_lab01_Passenger> iterator = passengers.listIterator();

		while (iterator.hasNext())
		{
			selected=iterator.next();
			if (selected.getID().equals(id))
			{
				return selected;
			}
			
		}
	return selected;
		
	}
	
	public String getPassengerList()
	{
		String list="<html>Passengers ("+currentSize+"): ";
		rstirli2_lab01_Passenger out;
		ListIterator<rstirli2_lab01_Passenger> iterator = passengers.listIterator();

		while (iterator.hasNext())
		{
			out = iterator.next();
			list+="<br>";
			list+= out.getName()+"        "+out.getID();
			
		}
		
		list += "</html>";
		
		if (currentSize==0)
		{
			list="There are no passengers registered.";
		}
		return list;
	}
	

	
	public void addPassenger(rstirli2_lab01_Passenger addition)
	{
		passengers.add(addition);
		currentSize++;
		
		//insertionSort();
	}
	/*
	public boolean checkWait(rstirli2_lab01_Passenger test)
	{
		boolean result=true;
		
		for (int i=0; i<(waitingList.getSize()-1); i++)
		{
			if (test.equals((rstirli2_lab01_Passenger)waitingList.getData(i)))
			{
				result=false;
			}
		}
		return result;
	} */
	public void removePassenger(String id)
	{
		int skipNum=size;
		rstirli2_lab01_Passenger[] copyArray;
		ListIterator<rstirli2_lab01_Passenger> iterator = passengers.listIterator();
		rstirli2_lab01_Passenger selected= null;

		
		while (iterator.hasNext())
		{
			selected=iterator.next();
			if (selected.getID().equals(id))
			{
				passengers.remove(selected);
			}
			
		}
		
		currentSize--;

		
		if(waitingList.getSize()!=0)
		{
			//linked list implement
			selected = (rstirli2_lab01_Passenger) waitingList.dequeue();
			addPassenger(selected);
			//passengers[currentSize]=(rstirli2_lab01_Passenger) waitingList.dequeue();
		}
		
		
	}
	
	public rstirli2_lab01_Passenger getLastPassenger()
	{
		//linked list implement
		//return passengers[currentSize-1];
		return passengers.get(currentSize-1);
	}
	

		

	/*
	public void insertionSort()
	{
		for (int i = 1; i <currentSize; i++) 
		{
            rstirli2_lab01_Passenger next = passengers[i];
            
            int j = i;
            
            int k=0;
            
            while (j > 0 && passengers[j - 1].getName().toLowerCase().charAt(k) >= next.getName().toLowerCase().charAt(k))
            {
            	if (passengers[j - 1].getName().toLowerCase().charAt(k)==(next.getName().toLowerCase().charAt(k)))
            	{
            		System.out.println("success insertion sort");	
            		k++;
            	}
            	else
            	{
            		passengers[j] = passengers[j - 1];
            		j--;
            	}
                
            }
            passengers[j] = next;
        }
	}*/
	
}


