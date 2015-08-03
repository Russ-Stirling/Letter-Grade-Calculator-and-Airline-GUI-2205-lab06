

package lab06;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
public class rstirli2_lab02_GUI_Manager {
	
	public static void message(String text){  //METHOD FOR ALL MESSAGE NOTIFICATIONS
		
		JFrame frame = new JFrame("message");
		frame.setVisible(false);

		JOptionPane.showMessageDialog(frame, text);
	}
	
	public static String inputText(String message) //METHOD FOR ALL USER INPUTS
	{
		String text=null;
		
		JFrame frame = new JFrame("input");
		frame.setVisible(false);
		
		text = JOptionPane.showInputDialog(frame, message);
		
		return text;	
	}
	
	public static boolean isNumeric(String text)  
	{  
	  try  
	  {  
	    int i = Integer.parseInt(text);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final rstirli2_lab01_Airline airline;
		airline = new rstirli2_lab01_Airline();
		
		JFrame frame = new JFrame("lab04");
		frame.setVisible(true);
		frame.setSize(1200,600);
		
		JPanel panel = new JPanel ();
		frame.add(panel);
		

		JButton listPassengers = new JButton ("List Passengers");
		panel.add(listPassengers);
		listPassengers.addActionListener (new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
				message(airline.returnPassengerList());
			} });
		listPassengers.setFont(new Font("Arial", Font.PLAIN, 40));

		JButton listFlights = new JButton ("List Flights");
		panel.add(listFlights);
		listFlights.addActionListener (new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				message(airline.returnFlightList());
			} });
		listFlights.setFont(new Font("Arial", Font.PLAIN, 40));
		
		JButton addPassenger = new JButton ("Add Passenger");
		panel.add(addPassenger);
		addPassenger.addActionListener (new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				String name, id;
				rstirli2_lab01_Flight flight= null;
				rstirli2_lab01_Passenger passenger= null;


				name=inputText("What is the flight number?");
				if (airline.checkFlight(name)==true)
					{
						flight = airline.getFlight(name);
						

						id=inputText("what is passenger id?");
						
						if(airline.checkPassengerExists(id))
						{
							if (flight.checkForPassenger(id))
							{
								message("Passenger already on board.");
							}
							
							else if (flight.getSize()<=flight.getCurrentSize())
							{
								if (flight.checkOn(id))
								{
									passenger = airline.getPassenger(id);
									flight.addToQueue(passenger);
									message("<html>Flight is full. <br>"+passenger.getName()+" (Passenger: "+passenger.getID()+") added to wait list.<html/>");
								}
								else
								{
									message("Passenger is already on the wait list.");
								}

							}
							else
							{
								passenger = airline.getPassenger(id);
								flight.addPassenger(passenger);
								message(passenger.getName()+" (Passenger: "+passenger.getID()+") Added to flight.");
								message(flight.getPassengerList());
								
							}
						}
						
						else
						{
							message("Passenger does not exist");
						}
						
					}
				else if(name==null)
				{
					
				}
				else
				{
					message("Flight does not exist");
				}
			} });
		addPassenger.setFont(new Font("Arial", Font.PLAIN, 40));

		JButton seeWait = new JButton ("View a wait List");
		panel.add(seeWait);
		seeWait.addActionListener (new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				String name, id;
				rstirli2_lab01_Flight flight= null;
				rstirli2_lab01_Passenger passenger= null;
				rstirli2_lab01_Passenger passenger2= null;


				name=inputText("What is the flight number?");
				if (airline.checkFlight(name)==true)
					{
						flight = airline.getFlight(name);
						message(flight.waitingListInfo());
						
					}
				else if(name==null)
				{
					message("Flight does not exist");
				}
				else
				{
					message("Flight does not exist");
				}
				
			} });
		seeWait.setFont(new Font("Arial", Font.PLAIN, 40));
		
		JButton createPassenger = new JButton ("Create Passenger");
		panel.add(createPassenger);
		createPassenger.addActionListener (new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				String name, id=null;
				
				id = inputText("Create a four digit ID");
				
				if(id==null)
					return;
				while (id.length()!=4)
				{
					
					message("That is not a valid ID. ID must be four digits.");
					id = inputText("Create a four digit ID");
					if(id==null)
						return;
				}
				
				while (!isNumeric(id))
				{
					message("That is not a valid ID. ID can only contain numeric digits.");
					id = inputText("Create a four digit ID");
					if(id==null)
						return;
				}
				
				name = inputText("Choose a name for the Passenger");
				if(name==null)
					return;
				while (name.length()==0)
				{
					name = inputText("There were no characters entered. Choose a name for the Passenger");
					if(name==null)
						return;
				}
				
				airline.newPassenger(name, id);
				message("Passenger Created");
				
			} });
		createPassenger.setFont(new Font("Arial", Font.PLAIN, 40));
		
		JButton createFlight = new JButton ("Create Flight");
		panel.add(createFlight);
		createFlight.addActionListener (new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				String name=null;
				
				name = inputText("Please enter the name of the flight");
				if(name==null)
					return;
				while (name.length()==0)
				{
					name = inputText("There were no characters entered. Choose a name for the flight");
					if(name==null)
						return;
				}
						
				airline.newFlight(name);
				message("Flight Created");
				
				
			} });
		createFlight.setFont(new Font("Arial", Font.PLAIN, 40));
		
		JButton removePassenger = new JButton ("Remove Passenger");
		panel.add(removePassenger);
		removePassenger.addActionListener (new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				String name, id;
				rstirli2_lab01_Flight flight= null;
				rstirli2_lab01_Passenger passenger= null;

				
				name=inputText("What is the flight number?");
				if (airline.checkFlight(name)==true)
					{
						flight = airline.getFlight(name);
						
						id=inputText("what is passenger id?");
						
						if(airline.checkPassengerExists(id))
						{
							if (flight.checkForPassenger(id))
							{
								passenger = airline.getPassenger(id);
								flight.removePassenger(id);
								message(passenger.getName()+" (Passenger: "+passenger.getID()+") Removed from flight.");
							
								if(flight.getCurrentSize()==flight.getSize())
								{
									passenger = flight.getLastPassenger();
									message(passenger.getName()+" (Passenger from wait list: "+passenger.getID()+") Added to flight.");
								}
							}
							else if (!flight.checkOn(id))
							{
								passenger = airline.getPassenger(id);
								flight.removeFromWait(passenger);
								message(passenger.getName()+" has been removed from the wait list.");
							}
							else
							{
								message("Passenger not on FLIGHT.");
				
							}
						}
						
						else
						{
							message("Passenger does not exist");
						}
						
					}
				else if(name==null)
				{
					message("Flight does not exist");
				}
				else
				{
					message("Flight does not exist");
				}
			} });
		removePassenger.setFont(new Font("Arial", Font.PLAIN, 40));

		
		JButton listPassengersOnFlight = new JButton ("List Passengers on a flight");
		panel.add(listPassengersOnFlight);
		listPassengersOnFlight.addActionListener (new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				String name, id;
				rstirli2_lab01_Flight flight= null;
				name=inputText("What is the flight number?");
				if (airline.checkFlight(name)==true)
					{
						flight = airline.getFlight(name);
						message(flight.getPassengerList());
					}
				else if(name==null)
				{
					
				}
				else
				{
					message("Flight does not exist");
				}
			} });
		listPassengersOnFlight.setFont(new Font("Arial", Font.PLAIN, 40));
		
		JButton changeCapacity = new JButton ("Change Flight Capacity");
		panel.add(changeCapacity);
		changeCapacity.addActionListener (new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				String name;
				rstirli2_lab01_Flight flight= null;
				name=inputText("What is the flight number?");
				if (airline.checkFlight(name)==true)
					{
						int newSize;
						String data;
						flight = airline.getFlight(name);
						
						message(flight.getPassengerList());
						message(flight.waitingListInfo());

						data=inputText("<html>The current capacity is "+ flight.getSize()+". <br>What would you like the new size to be?<html/>");
						while (!isNumeric(data))
						{
							data = inputText("That is not a valid size. Input new size.");
						}
						
						newSize=Integer.parseInt(data);
						
						
						flight.reSize(newSize);
						
						message("<html>The capacity is now: " + newSize+".<br>Waiting list updated.");
						message(flight.getPassengerList());
						message(flight.waitingListInfo());

					}
				else if(name==null)
				{
					message("Flight does not exist");
				}
				else
				{
					message("Flight does not exist");
				}
			} });
		changeCapacity.setFont(new Font("Arial", Font.PLAIN, 40));
		
		JButton passView = new JButton("View Passengers GUI");
		panel.add(passView);
		passView.addActionListener (new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				rstirli2_GUI gui = new rstirli2_GUI(airline);
				gui.setVisible(true);
				gui.setSize(600, 600);
				
			}});
		passView.setFont(new Font("Arial", Font.PLAIN, 40));

			
		JButton luggage = new JButton("Luggage Manager");
		panel.add(luggage);
		luggage.addActionListener (new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				JFrame manager = new JFrame("Luggage Manager");
				manager.setVisible(true);
				manager.setSize(600, 400);
				
				JPanel mPanel = new JPanel ();
				manager.add(mPanel);
				
				JButton checkIn = new JButton("Check in luggage.");
				mPanel.add(checkIn);
				checkIn.addActionListener (new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						String name, id;
						rstirli2_lab01_Flight flight= null;
						rstirli2_lab01_Passenger passenger= null;

						id=inputText("what is passenger id?");
						
						if(airline.checkPassengerExists(id))
						{
							passenger=airline.getPassenger(id);
							
							name=inputText("What is the flight number?");
							if (airline.checkFlight(name)==true)
							{
								flight = airline.getFlight(name);
								flight.addToLuggage(passenger);
								message("("+passenger.getID()+") "+passenger.getName()+"'s luggage added to flight "+ flight.getName()+".");
							}
							else
							{
								message("Flight does not exist. Cannot check in luggage to a non existant flight.");
							}
						}
						
						else
						{
							message("Passenger does not exist. Cannot check in luggage for a non existant passenger.");
						}
	
					} });
				checkIn.setFont(new Font("Arial", Font.PLAIN, 40));
				
				JButton view = new JButton("View Luggage.");
				mPanel.add(view);
				view.addActionListener (new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						rstirli2_lab01_Flight flight= null;


						String name=inputText("What is the flight number?");
						if (airline.checkFlight(name)==true)
						{
							flight = airline.getFlight(name);
							if (flight.luggageEmpty())
							{
								message("The luggage stack is empty.");
							}
							else
							{
								message(flight.getLuggageList());
							}

						}
						else
						{
							message("Flight does not exist. Cannot view luggage for a non existant flight.");
						}
						
					} });
				view.setFont(new Font("Arial", Font.PLAIN, 40));
				
				JButton load = new JButton("Load luggage.");
				mPanel.add(load);
				load.addActionListener (new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						rstirli2_lab01_Flight flight= null;
						rstirli2_lab01_Passenger passenger= null;


						String name=inputText("What is the flight number?");
						if (airline.checkFlight(name)==true)
						{
							flight = airline.getFlight(name);
							if (flight.luggageEmpty())
							{
								message("The luggage stack is empty.");
							}
							
							else
							{
								passenger=flight.removeFromLuggage();
								message(passenger.getName()+"'s ("+passenger.getID()+") luggage has been loaded onto flight "+ flight.getName());
							}

						}
						else
						{
							message("Flight does not exist. Cannot load luggage to a non existant flight.");
						}
						
					} });
				load.setFont(new Font("Arial", Font.PLAIN, 40));
				
				GridLayout layout = new GridLayout(6,1);
				mPanel.setLayout(layout);
				
				
			} });
		luggage.setFont(new Font("Arial", Font.PLAIN, 40));
		
		JButton exit = new JButton("Exit");
		panel.add(exit);
		exit.addActionListener (new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				JFrame test = new JFrame();
				test.setVisible(false);
				int i=JOptionPane.showConfirmDialog(test, "Are you sure you wish to exit?");
				if (i==0)
				{
					System.exit(0);
				}
				
			} });
		exit.setFont(new Font("Arial", Font.PLAIN, 40));
		GridLayout layout = new GridLayout(6,2);
		panel.setLayout(layout);


	}
	
}

