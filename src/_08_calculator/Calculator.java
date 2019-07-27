package _08_calculator;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Calculator implements ActionListener {
	
	double result;
	double value1;
	double value2;
	JFrame frame= new JFrame();
	JPanel panel=new JPanel();
	TextField text1=new TextField();
	TextField text2 = new TextField();
	JButton buttonAdd = new JButton();
	JButton buttonSub = new JButton();
	JButton buttonMult = new JButton();
	JButton buttonDiv = new JButton();
	JLabel label = new JLabel();
	
	void add(){
		result=value1+value2;
	}
	
	void subtract() {
		result=value1-value2;
	}
	
	void multiply() {
		result=value1*value2;
	}
	
	void divide() {
		result=value1/value2;
	}
	void createUI(){
	frame.setTitle("Calculator");
	text1.setColumns(10);
	text2.setColumns(10);
	panel.add(text1);
	panel.add(text2);
	buttonAdd.addActionListener(this);
	buttonAdd.setText("Add");
	buttonSub.addActionListener(this);
	buttonSub.setText("Sub");
	buttonMult.addActionListener(this);
	buttonMult.setText("Mul");
	buttonDiv.addActionListener(this);
	buttonDiv.setText("Div");
	label.setText("No Current Answer");
	panel.add(buttonAdd);
	panel.add(buttonSub);
	panel.add(buttonMult);
	panel.add(buttonDiv);
	panel.add(label);
	frame.add(panel);
	frame.setSize(175, 180);
	frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		value1=Double.parseDouble(text1.getText());
		value2=Double.parseDouble(text2.getText());
		
		if(e.getSource()==buttonAdd) {
			add();
			System.out.println(result);
		}
		
		else if(e.getSource()==buttonSub) {
			subtract();
			System.out.println(result);
		}
		
		else if(e.getSource()==buttonMult) {
			multiply();
			System.out.println(result);
		}
		
		else {
			divide();
			System.out.println(result);
		}
		label.setText(String.valueOf(result));
		
	}
}
