import java.awt.*;
import java.awt.event.*;
import java.awt.Component.*;
import javax.swing.*;
import java.util.*;

public class CalcGUI implements ActionListener {
    
	private Calculator calc = new Calculator();
	private JTextArea textBox = new JTextArea("0");
	private JButton equals = new JButton("=");
	
	public CalcGUI(){
	    
		//Panel Creation
		
		JFrame frame = new JFrame();
		JPanel bigPanel = new JPanel();
		JPanel sidePanel = new JPanel();
		JPanel numberPanel = new JPanel();
		JPanel textPanel = new JPanel();
		
		frame.setSize(250,250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(bigPanel);
		
		//Layout of Calculator
		
		bigPanel.setLayout(new BorderLayout(5,6));
		sidePanel.setLayout(new GridLayout(6,1,5,5));
		numberPanel.setLayout(new GridLayout(4,5,5,5));
		
		//Creation of buttons 
		
		JButton seven = new JButton("7");
		seven.addActionListener(this);
		numberPanel.add(seven);
		
		JButton eight = new JButton("8");
		eight.addActionListener(this);
		numberPanel.add(eight);
		
		JButton nine = new JButton("9");
		nine.addActionListener(this);
		numberPanel.add(nine);
		
		JButton four = new JButton("4");
		four.addActionListener(this);
		numberPanel.add(four);
		
		JButton five = new JButton("5");
		five.addActionListener(this);
		numberPanel.add(five);
		
		JButton six = new JButton("6");
		six.addActionListener(this);
		numberPanel.add(six);
		
		JButton one = new JButton("1");
		one.addActionListener(this);
		numberPanel.add(one);
		
		JButton two = new JButton("2");
		two.addActionListener(this);
		numberPanel.add(two);
		
		JButton three = new JButton("3");
		three.addActionListener(this);
		numberPanel.add(three);
		
		JButton empty = new JButton("");
		empty.addActionListener(this);
		numberPanel.add(empty);
		
		JButton zero = new JButton("0");
		zero.addActionListener(this);
		numberPanel.add(zero);
		
		JButton decimal = new JButton(".");
		decimal.addActionListener(this);
		numberPanel.add(decimal);
		
		
		
		JButton clr = new JButton("CLR");
		clr.addActionListener(this);
		sidePanel.add(clr);
		
		JButton plus = new JButton("+");
		plus.addActionListener(this);
		sidePanel.add(plus);
		
		JButton minus = new JButton("-");
		minus.addActionListener(this);
		sidePanel.add(minus);
		
		JButton multiply = new JButton("*");
		multiply.addActionListener(this);
		sidePanel.add(multiply);
		
		JButton divide = new JButton("/");
		divide.addActionListener(this);
		sidePanel.add(divide);
		
		//Add equals button to panel (created as private variable)
		equals.addActionListener(this);
		equals.setEnabled(false);  //  <--  equals button starts disabled
		sidePanel.add(equals);
		

        //Text Area starts with 0 as text		
		
		//Add text area to panel (created as private variable)
		textPanel.add(textBox);
		
		//add all panels to bigPanel, bigPanel is put inside frame
		
		bigPanel.add(numberPanel, BorderLayout.CENTER);
		bigPanel.add(sidePanel, BorderLayout.LINE_END);
		bigPanel.add(textPanel, BorderLayout.PAGE_START);
		
		frame.setVisible(true);
		
		
		
		
	
	}

    public void actionPerformed(ActionEvent event){
			
			//Source is label of Button
			
			String source = event.getActionCommand().toString();
			double answer = 0;
			
		
			//Equals pressed
			
			if(source.equals("=")){
				
			    try {
					
				    answer = calc.equals();
					textBox.setText(String.valueOf(answer));
					equals.setEnabled(false);
					
				} catch(NumberFormatException exception) {
					
					textBox.setText("Illegal Function");
					equals.setEnabled(false);
				}
				
			} 

			//Add number to cache
			
			if(textBox.getText().equals("0")){ 
			    calc.clear();
				textBox.setText(source);
				calc.addToCache(source);
				
			} else if(!(source.equals("CLR") || source.equals("="))){
			    calc.addToCache(source);
				textBox.append(source);
				
			}		
			
			//Unlock equals button if operator is clicked
			
			if(source.equals("+") || source.equals("-") || source.equals("/") || source.equals("*")) {
				equals.setEnabled(true);
				
			}
			
			
			//Clear pressed
			
			if(source.equals("CLR")){
				calc.clear();
				equals.setEnabled(false);
				textBox.setText("0");
			}
	}
}