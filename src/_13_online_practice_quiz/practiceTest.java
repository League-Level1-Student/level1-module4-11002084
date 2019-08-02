package _13_online_practice_quiz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class practiceTest implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton buttonHint = new JButton();
	JButton buttonSubmit = new JButton();
	JLabel label = new JLabel();
	JTextField textfield = new JTextField();
	
	public static void main(String[] args) {
		new practiceTest().createUI();
	}
	
	void createUI() {
		frame.setTitle("Let's play a game");
		buttonHint.setText("Hint");
		buttonSubmit.setText("Submit");
		buttonHint.addActionListener(this);
		buttonSubmit.addActionListener(this);
		label.setText("I always run but never walk, what am I?");
		textfield.setColumns(5);
		panel.add(label);
		panel.add(textfield);
		panel.add(buttonSubmit);
		panel.add(buttonHint);
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == buttonHint) {
			JOptionPane.showMessageDialog(null, "The answer is a liquid, and it has five letters.");
		}
		else if(e.getSource() == buttonSubmit) {
			String text = textfield.getText();
			if(text.equalsIgnoreCase("blood")) {
				JOptionPane.showMessageDialog(null, "Correct");
				System.exit(0);
			} else if(text.equalsIgnoreCase("water")){
				JOptionPane.showMessageDialog(null, "Foolish mortal. You are wrong, for your answer is too mundane!");
			} else {
				JOptionPane.showMessageDialog(null, "Ding-dong your answer is wrong");
			}
		}
	}
}
