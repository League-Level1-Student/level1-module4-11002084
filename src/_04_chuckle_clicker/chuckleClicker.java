package _04_chuckle_clicker;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class chuckleClicker implements ActionListener {
	static chuckleClicker chuckleClicker=new chuckleClicker();
	JButton buttonJoke=new JButton();
	JButton buttonPunchline=new JButton();
	
	public static void main(String[] args) {
		chuckleClicker.makeButtons();
	}
	
	void makeButtons(){
		JFrame frame=new JFrame();
		frame.setVisible(true);
		JPanel panel=new JPanel();
		buttonJoke.setText("Joke");
		buttonJoke.addActionListener(this);
		buttonPunchline.setText("Punchline");
		buttonPunchline.addActionListener(this);
		panel.add(buttonJoke);
		panel.add(buttonPunchline);
		frame.add(panel);
		frame.pack();
		
	}
	
	void speak(String words) {
		try {
			Runtime.getRuntime().exec("say " + words).waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == buttonJoke) {
			JOptionPane.showMessageDialog(null, "While in a car, a child asks his dad what an alcoholic is. His dad tells his son to look at the 4 cars in front of their car, and tells him that an alcholic would see 8.");
			speak("While in a car, a child asks his dad what an alcoholic is. His dad tells his son to look at the 4 cars in front of their car, and tells him that an alcholic would see 8.");
		}else if(e.getSource() == buttonPunchline){
			JOptionPane.showMessageDialog(null, "But his son points out that there are only two cars in front of them.");
			speak("But his son points out that there are only two cars in front of them.");
			JOptionPane.showMessageDialog(null, "*Crashes and explosions can be heard*");
			speak("Crashes and explosions can be heard.");
		}
		
		
	}
}
