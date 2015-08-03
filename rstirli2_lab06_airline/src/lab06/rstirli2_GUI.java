package lab06;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.Collections;
import java.util.Collection;

public class rstirli2_GUI extends JFrame{
	
	 private LinkedList<rstirli2_lab01_Passenger> pass = new LinkedList<rstirli2_lab01_Passenger>();
	 private JTextField jtfNumber = new JTextField(8);
	 private JTextArea jtaNumbers = new JTextArea();
	 private JButton jbtSort = new JButton("Sort");
	 private JButton jbtShuffle = new JButton("Shuffle");
	 private JButton jbtReverse = new JButton("Reverse");
	 private rstirli2_lab01_Airline airline;
	 private String text, list;
	 
	 public void shellSort(LinkedList<rstirli2_lab01_Passenger> list)
	 {
		 for (int gap=list.size()/2; gap>0; gap/=2) {
		        // do the insertion sort
		        for (int i=gap; i<list.size(); i++) {
		            rstirli2_lab01_Passenger val = list.get(i);
		            int j;
		            for (j=i; j>=gap && list.get(j - gap).getName().compareTo(val.getName())>0; j-=gap) {
		                
		            	list.remove(j);
		            	list.add(j,list.get(j-gap));
		            }
		            list.remove(j);
		            list.add(j, val);
		        }
		    }	 
	 }
	 
	
	public rstirli2_GUI(rstirli2_lab01_Airline a){
		 
		 airline = a;
		 pass=airline.getList();
		 JPanel panel1 = new JPanel();
		 panel1.add(new JLabel("Enter a number: "));
		 panel1.add(jtfNumber);
		 
		 JScrollPane jsp = new JScrollPane(jtaNumbers);
		 
		 JPanel panel2 = new JPanel();
		 panel2.add(jbtSort);
		 panel2.add(jbtShuffle);
		 panel2.add(jbtReverse);
		 
		 this.add(panel1, BorderLayout.NORTH);
		 add(jsp, BorderLayout.CENTER);
		 add(panel2, BorderLayout.SOUTH);
		
		 jtfNumber.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 
				text = jtfNumber.getText();
				System.out.println(text);
				 
				if (airline.checkFlight(text))
				{
					pass=airline.getFlight(text).getPassengerLink();
					//display passengers on that flight in order
				}
					
				else 
				{
					pass=airline.getList();
				}			 
		}});
		 
		jbtSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if (airline.checkFlight(text))
				{
					 list = airline.getFlight(text).getName();
				}
				
				else 
				{
					list="All Passengers: ";
				}
				rstirli2_lab01_Passenger out;
				shellSort(pass);
				ListIterator<rstirli2_lab01_Passenger> iterator = pass.listIterator();
				while (iterator.hasNext())
				{
					list += "\n";
					out = iterator.next();
					list += out.getName() + "       " + out.getID();			
				}
				jtaNumbers.setText(list);
		 }});
		 
		jbtShuffle.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
			
				 if (airline.checkFlight(text))
			 	 {
					 list = airline.getFlight(text).getName();
			 	 }
					
				 else 
				 {
					 list = "All Passengers: "; 
				 }
				 rstirli2_lab01_Passenger out;
				 Collections.shuffle(pass);
				 ListIterator<rstirli2_lab01_Passenger> iterator = pass.listIterator();
				 while (iterator.hasNext())
				 {
					  list += "\n";
					  out = iterator.next();
					  list += out.getName() + "       " + out.getID();			
				 }
			
				 jtaNumbers.setText(list);	 
		 }});
		 
		 jbtReverse.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {

				 if (airline.checkFlight(text))
			 	 {
					 list = airline.getFlight(text).getName();
			 	 }
					
				 else 
				 {
					 list = "All Passengers: "; 
				 }
				
				rstirli2_lab01_Passenger out;
				ListIterator<rstirli2_lab01_Passenger> iterator = pass.listIterator();
				Collections.reverse(pass);
				while (iterator.hasNext())
				{
					list += "\n";
					out = iterator.next();
					list += out.getName() + "       " + out.getID();						
				}
				
				jtaNumbers.setText(list);
		 }});
	}
}