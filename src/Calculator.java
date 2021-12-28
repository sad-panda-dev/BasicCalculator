/**
 * Basic calculator in Java. GUI made using Java Swing API
 */

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Calculator implements ActionListener {

	//Create the variables for operators and operands
	String value1, value2, operator;
	
	//Create the frame object
	private static JFrame frame;
	
	//Create a text field object
	private static JTextField textField;
	
	//Create the main panel and 3 subpanel objects
	private static JPanel mainPanel, subPanel1, subPanel2, subPanel3;
	
	/**
	 * Default constructor for the Calculator Object
	 */
	public Calculator() {
		
		value1 = operator = value2 = "";

	}
	
	/**
	 * main method for the Calculator GUI, creates a calculator object 
	 * and then adds the attributes of the calculator to that object using
	 * what is available in the java Swing API(i.e. JPanels, JButtons,
	 * JFrames, JTextFields, .addActionListener, .add, 
	 * .setDefaultCloseOpperation, etc.) 
	 * @param args
	 */
	public static void main(String[] args) {
		
		//create the frame or the boundary of the GUI
		frame = new JFrame();
				
		try {
            // set look and feel
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
		//create Calculator object
		Calculator calc = new Calculator();
		
				
		//create the text field
		textField = new JTextField(16);
		
		//set the text field to non editable
		textField.setEditable(false);
		
		//create the panels
		mainPanel = new JPanel();
		subPanel1 = new JPanel();
		subPanel2 = new JPanel();
		subPanel3 = new JPanel();
				
		//Create the number buttons of the calculator
		JButton button0 = new JButton("0");
		JButton button1 = new JButton("1");
		JButton button2 = new JButton("2");
		JButton button3 = new JButton("3");
		JButton button4 = new JButton("4");
		JButton button5 = new JButton("5");
		JButton button6 = new JButton("6");
		JButton button7 = new JButton("7");
		JButton button8 = new JButton("8");
		JButton button9 = new JButton("9");
				
		//Create operation buttons for the calculator
		JButton plus_button = new JButton("+");
		JButton minus_button = new JButton("-");
		JButton multiply_button = new JButton("*");
		JButton divide_button = new JButton("/");
				
		//Create the equals button for the calculator
		JButton equal_button = new JButton("=");
				
		
		//TO DO figure out functionality for decimal
		//probably using float instead of int will be enough
		
		//Create the decimal button for the calculator
		JButton decimal_button = new JButton(".");
				
		//Create button to clear the information already sent
		//to the calculator
		JButton clear_button = new JButton("Clear");
				
		//Create the click events (.addActionListener())
		//of the calculators buttons
		button0.addActionListener(calc);
		button1.addActionListener(calc);
		button2.addActionListener(calc);
		button3.addActionListener(calc);
		button4.addActionListener(calc);
		button5.addActionListener(calc);
		button6.addActionListener(calc);
		button7.addActionListener(calc);
		button8.addActionListener(calc);
		button9.addActionListener(calc);
		plus_button.addActionListener(calc);
		minus_button.addActionListener(calc);
		multiply_button.addActionListener(calc);
		divide_button.addActionListener(calc);
		equal_button.addActionListener(calc);
		decimal_button.addActionListener(calc);
		clear_button.addActionListener(calc);
				
		//change the size of the clear button
		clear_button.putClientProperty("JComponent.sizeVariant", "large");
		
		//add the text field to subPanel1
		subPanel1.add(textField);
		
		//add the buttons to subPanel2
		subPanel2.add(button7);
		subPanel2.add(button8);
		subPanel2.add(button9);
		subPanel2.add(divide_button);
		subPanel2.add(button4);
		subPanel2.add(button5);
		subPanel2.add(button6);
		subPanel2.add(multiply_button);
		subPanel2.add(button1);
		subPanel2.add(button2);
		subPanel2.add(button3);
		subPanel2.add(minus_button);
		subPanel2.add(button0);
		subPanel2.add(decimal_button);
		subPanel2.add(equal_button);
		subPanel2.add(plus_button);
		subPanel3.add(clear_button);
				
		//set the border of the panel using BorderFactory
		mainPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
		
		//next set the layouts
		mainPanel.setLayout(new GridLayout(3, 1));
		subPanel2.setLayout(new GridLayout(4, 4));
		subPanel3.setLayout(new GridLayout(1, 1));
		
		//add the sub panels to the main panel
		mainPanel.add(subPanel1);
		mainPanel.add(subPanel2);
		mainPanel.add(subPanel3);
		
		//set the background color of the panels
		mainPanel.setBackground(Color.DARK_GRAY);
		subPanel1.setBackground(Color.white);
		
		//add panels to the frame
		frame.add(mainPanel,BorderLayout.CENTER);
		
		//set operation for when they close the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//set title for the GUI
		frame.setTitle("Basic Calculator");
		
		//set the window to match a certain size
		//force update to the UI
		SwingUtilities.updateComponentTreeUI(frame);
		frame.pack();
		
		//set the window to be visible and in focus
		frame.setVisible(true);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String str = e.getActionCommand();
		
		//how to handle if a number is selected
		if ((str.charAt(0) >= '0' && str.charAt(0) <= '9') || str.charAt(0) == '.') {
			//if an opperand is selected
			if (!operator.equals("")) {
				value2 += str;
			}
			else {
				value1 += str;
			}
			//set the value to the text field
			textField.setText(value1 + operator + value2);
		} else if (str.charAt(0) == 'C') {
			//clear what was previously entered
			value1 = operator = value2 = "";
			
			//set new value to the text field
			textField.setText(value1 + operator + value2);
		} else if (str.charAt(0) == '=') {
 
            double result;
 
            // store the value in 1st
            if (operator.equals("+"))
                result = (Double.parseDouble(value1) + Double.parseDouble(value2));
            else if (operator.equals("-"))
                result = (Double.parseDouble(value1) - Double.parseDouble(value2));
            else if (operator.equals("/"))
                result = (Double.parseDouble(value1) / Double.parseDouble(value2));
            else
                result = (Double.parseDouble(value1) * Double.parseDouble(value2));
 
            // set the value of text
            textField.setText(value1 + operator + value2 + "=" + result);
 
            // convert it to string
            value1 = Double.toString(result);
 
            operator = value2 = "";
        }
        else {
            // if there was no operand
            if (operator.equals("") || value2.equals(""))
                operator = str;
            // else evaluate
            else {
                double result;
             // store the value in 1st
                if (operator.equals("+"))
                    result = (Double.parseDouble(value1) + Double.parseDouble(value2));
                else if (operator.equals("-"))
                    result = (Double.parseDouble(value1) - Double.parseDouble(value2));
                else if (operator.equals("/"))
                    result = (Double.parseDouble(value1) / Double.parseDouble(value2));
                else
                    result = (Double.parseDouble(value1) * Double.parseDouble(value2));
 
                // convert it to string
                value1 = Double.toString(result);
 
                // place the operator
                operator = str;
 
                // make the operand blank
                value2 = "";
            }
 
            // set the value of text
            textField.setText(value1 + operator + value2);
		
	}
	}
}
