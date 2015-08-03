package rstirli2_lab06;
import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.*;


public class rstirli2_lab06_LetterGrade extends JFrame {
	
	private JLabel jlblNumber1 = new JLabel("ES1036:");
	private JLabel jlblNumber2 = new JLabel("CS 1037:");
	private JLabel jlblNumber3 = new JLabel("SE2205:");
	private JLabel jlblNumber4 = new JLabel("SE2250");
	private JLabel jlblNumber5 = new JLabel("Total Marks:");
	private JLabel jlblNumber6 = new JLabel("Average Marks:");
	private JLabel jlblNumber7 = new JLabel("Letter Grade:");
	
	
	private JTextField textES1036 = new JTextField();
	private JTextField textCS1037 = new JTextField();
	private JTextField textSE2205 = new JTextField();
	private JTextField textSE2250 = new JTextField();
	private JTextField textTotalMarks = new JTextField();
	private JTextField textAvgMarks = new JTextField();
	private JTextField textLetterGrade = new JTextField();
	
	private JButton computeGrade = new JButton("Compute Grade");
	
	rstirli2_lab06_LetterGrade() {
		JPanel panel = new JPanel(new GridLayout(10,2));
 		panel.add(jlblNumber1);
 		panel.add(textES1036);
 		panel.add(jlblNumber2);
 		panel.add(textCS1037);
 		panel.add(jlblNumber3);
 		panel.add(textSE2205);
 		panel.add(jlblNumber4);
 		panel.add(textSE2250);
 		panel.add(jlblNumber5);
 		panel.add(textTotalMarks);
 		textTotalMarks.setEditable(false);
 		panel.add(jlblNumber6);
 		panel.add(textAvgMarks);
 		textAvgMarks.setEditable(false);
 		panel.add(jlblNumber7);
 		panel.add(textLetterGrade);
 		textLetterGrade.setEditable(false);

 		panel.setBorder(new TitledBorder("Enter marks for four subjects"));
 		JPanel panel3 = new JPanel((LayoutManager) new FlowLayout(FlowLayout.RIGHT));
 		panel3.add(computeGrade);
 		add(panel, BorderLayout.CENTER);
 		add(panel3, BorderLayout.SOUTH);
 		computeGrade.addActionListener(new ActionListener() {
	 	public void actionPerformed(ActionEvent e) {
	 		
	 		double es1036, cs1037, se2205, se2250, totalMarks, avgMarks;
	 		String letterGrade;
	 		
	 		es1036 = Double.parseDouble(textES1036.getText());
	 		cs1037 = Double.parseDouble(textCS1037.getText());
	 		se2205 = Double.parseDouble(textSE2205.getText());
	 		se2250 = Double.parseDouble(textSE2250.getText());
	 		
 			Grade grade = new Grade(es1036,cs1037,se2205,se2250);
 			
 			textTotalMarks.setText(String.valueOf(grade.getTotalMarks()));
 			textAvgMarks.setText(String.valueOf(grade.getAvg()));
 			textLetterGrade.setText(grade.getLetter());

 		}
 	});
 }
	public static void main(String[] args) {
		rstirli2_lab06_LetterGrade frame = new rstirli2_lab06_LetterGrade();
		frame.pack();
		frame.setTitle("Letter Grade Calculator");
		frame.setLocationRelativeTo(null);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
class Grade {
	
	private double es1036;
	private double cs1037;
	private double se2205;
	private double se2250;
	private double totalMarks, avgMarks;
	private String letterGrade;
	
	/** Default constructor */
	
	public Grade() {
		this(100,100,100,100);
	}
		/** Construct a loan with specified annual interest rate,
 		number of years and loan amount */
	public Grade(double es1036, double cs1037,double se2205, double se2250) {
		this.es1036 = es1036;
		this.cs1037 = cs1037;
		this.se2205 = se2205;
		this.se2250 = se2250;
		setTotalMarks();
		setAvg();
		setLetter();
	}
	
 /** Return annualInterestRate */
	public double getes1036() {
		return es1036;
	}
	
 /** Set a new annualInterestRate */
	public void setes1036(double es1036) {
		this.es1036 = es1036;
	}
	
 /** Return numberOfYears */
	public double getcs1037() {
		return cs1037;
	}
	
 /** Set a new numberOfYears */
	public void setcs1037(double cs1037) {
		this.cs1037 = cs1037;
	}
	
	 /** Return annualInterestRate */
	public double getse2205() {
		return se2205;
	}
		
	 /** Set a new annualInterestRate */
	public void setse2205(double se2205) {
		this.se2205 = se2205;
	}
		
	 /** Return numberOfYears */
	public double getse2250() {
		return se2250;
	}
		
	 /** Set a new numberOfYears */
	public void setse2250(double se2250) {
		this.se2250 = se2250;
	}
	
	public void setTotalMarks()
	{
		totalMarks=es1036+cs1037+se2205+se2250;
	}
	
	public double getTotalMarks(){
		return totalMarks;
	}
	
	public void setAvg()
	{
		avgMarks=totalMarks/4;
	}
	
	public double getAvg()
	{
		return avgMarks;
	}
	
	public void setLetter()
	{
		if (avgMarks<50)
			letterGrade="F";
		else if (avgMarks<60)
			letterGrade = "D";
		else if (avgMarks<70)
			letterGrade="C";
		else if (avgMarks<80)
			letterGrade="B";
		else
			letterGrade="A";
	}
	
	public String getLetter()
	{
		return letterGrade;
	}
 
 }