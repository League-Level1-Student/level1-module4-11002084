package _09_latest_tweet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LatestTweet implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel= new JPanel();
	JTextField textfield = new JTextField();
	JButton button = new JButton();
	
	void createUI(){
		frame.setTitle("You should've used Reddit");
		textfield.setColumns(25);
		button.setText("Search Twitter");
		button.addActionListener(this);
		panel.add(textfield);
		panel.add(button);
		frame.add(panel);
		frame.setVisible(true);
		frame.pack();
	}
	
	public static void main(String[] args) {
		LatestTweet tweet = new LatestTweet();
		tweet.createUI();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("TWEET TWEET THE BIRDS ARE SINGING");
	}
}
