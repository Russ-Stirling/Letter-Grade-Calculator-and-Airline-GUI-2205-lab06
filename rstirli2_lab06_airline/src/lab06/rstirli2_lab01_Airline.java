package lab06;

import java.util.LinkedList;
import java.util.ListIterator;

public class rstirli2_lab01_Airline {
	private LinkedList<rstirli2_lab01_Passenger> passengers = new LinkedList<rstirli2_lab01_Passenger>();
	private rstirli2_lab01_Flight[] flights;
	private int passSize=10;
	private int currentPassSize=10;
	private int flightSize=5;
	private int currentFlightSize=5;
	
	public rstirli2_lab01_Airline()
	{
		passengers.add(new rstirli2_lab01_Passenger("Larry","1111"));
		passengers.add(new rstirli2_lab01_Passenger("Jill","2222"));
		passengers.add(new rstirli2_lab01_Passenger("John","3333"));
		passengers.add(new rstirli2_lab01_Passenger("Mike","4444"));
		passengers.add(new rstirli2_lab01_Passenger("Sarah","5555"));
		passengers.add(new rstirli2_lab01_Passenger("Dan","6666"));
		passengers.add(new rstirli2_lab01_Passenger("Julia","7777"));
		passengers.add(new rstirli2_lab01_Passenger("Bradley","8888"));
		passengers.add(new rstirli2_lab01_Passenger("Rita","9999"));
		passengers.add(new rstirli2_lab01_Passenger("Bill","1010"));

		flights = new rstirli2_lab01_Flight[flightSize];
		flights[0] = new rstirli2_lab01_Flight("WS1413");
		flights[1] = new rstirli2_lab01_Flight("WS1050");
		flights[2] = new rstirli2_lab01_Flight("WS1411");
		flights[3] = new rstirli2_lab01_Flight("WS1021");
		flights[4] = new rstirli2_lab01_Flight("WS1036");
	}
	
	public void newPassenger(String name, String id)
	{
		passengers.add(new rstirli2_lab01_Passenger(name,id));
		currentPassSize++;
	}
	
	public void newFlight(String name)
	{
		if (flightSize==currentFlightSize)
		{
			resizeFlightArray(2*flightSize);
			flightSize=2*flightSize;
		}
		
		flights[currentFlightSize]= new rstirli2_lab01_Flight(name);
		currentFlightSize++;
	}
	

	
	public void resizeFlightArray(int newSize)
	{
		rstirli2_lab01_Flight[] copyArray;
		copyArray = new rstirli2_lab01_Flight[flightSize];
		for (int i=0; i<currentFlightSize; i++)
		{
			copyArray[i]=flights[i];
		}
		
		flights = new rstirli2_lab01_Flight[newSize];
		for (int i=0; i<currentFlightSize; i++)
		{
			flights[i]=copyArray[i];
		}
		
		passSize=newSize;
	}

	public String returnPassengerList()
	{
		String list = "Passengers:";
		for (int i=0; i<currentPassSize; i++)
		{
			list += "\n";
			list += passengers.get(i).getName()+"     " + passengers.get(i).getID();
		}
		
	
		
		System.out.println("success");
		
		
		return list;
	}
	
	public LinkedList<rstirli2_lab01_Passenger> getList()
	{
		return passengers;
	}
	
	public int getCurrentSize()
	{
		return currentPassSize;
	}
	
	public String returnFlightList()
	{
		String list = "<html>Flights:";
		for (int i=0; i<currentFlightSize; i++)
		{
			list += "<br>";
			list += flights[i].getName();
		}
		
		list += "</html>";
		return list;
	}
	
	public rstirli2_lab01_Passenger getPassenger(String id)
	{
		
		rstirli2_lab01_Passenger selected= null;
		ListIterator<rstirli2_lab01_Passenger> iterator = passengers.listIterator();

		while (iterator.hasNext())
		{
			selected = iterator.next();
		
			if (selected.getID().equals(id))
			{
				return selected;
			}
		}
		
		return selected;	
	}
	
	
	public boolean checkFlight(String flightName)
	{
		boolean result=false;
		for (int i=0; i<currentFlightSize; i++)
		{
			if (flights[i].getName().equals(flightName))
			{
				result = true;
			}	
		}
		return result;
	}
	
	public boolean checkPassengerExists(String id)
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
	
	public rstirli2_lab01_Flight getFlight (String flightName)
	{
		int j=0;
		for (int i=0; i<currentFlightSize; i++)
		{
			if (flights[i].getName().equals(flightName))
			{
				j=i;
			}
		}
		return flights[j];
	}
}
