package _12_slot_machine;

import java.applet.AudioClip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SlotMachine implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton button = new JButton();
	Random rand = new Random();
	int reelValue;
	String fileName;
	int moneyLeft = 100;
	JLabel label = new JLabel();
	int Slot1;
	int Slot2;
	int Slot3;
	
	void createUI() {
		label.setText("Money Left: $" + moneyLeft);
		panel.add(label);
		button.setText("SPIN");
		button.addActionListener(this);
		panel.add(button);
		createThreeReels();
		frame.add(panel);
		frame.setTitle("Get Rich Quick (Us not You)");
		frame.pack();
		frame.setVisible(true);
	}
	
	void createThreeReels() {
		createReel();
		Slot1 = reelValue;
		panel.add(createLabelImage(fileName));
		createReel();
		Slot2 = reelValue;
		panel.add(createLabelImage(fileName));
		createReel();
		Slot3 = reelValue;
		panel.add(createLabelImage(fileName));
		
	}
	
	private void playSound(String fileName) {
		AudioClip sound = JApplet.newAudioClip(getClass().getResource(fileName));
		sound.play();
	}
	
	void createReel() {
		reelValue = rand.nextInt(10)+1;
		
		if(reelValue == 1) {
			fileName = "Cherry.jpeg";
		}
		else if(reelValue ==  2) {
			fileName = "Chungus.png";
		}
		else if(reelValue == 3) {
			fileName = "Lime.jpeg";
		}
		else if(reelValue == 4) {
			fileName = "Orange.jpeg";
		}
		else if(reelValue == 5) {
			fileName = "Shrek.jpeg";
		}
		else if (reelValue == 6){
			fileName = "Troll.png";
		}
		else if (reelValue == 7){
			fileName = "Bongo.jpeg";
		}
		else if (reelValue ==8) {
			fileName = "Car.jpg";
		}
		else if (reelValue ==9) {
			fileName = "7.jpeg";
		}
		else {
			fileName = "Impossible.jpeg";
		}
	}
	private JLabel createLabelImage(String fileName) {
        URL imageURL = getClass().getResource(fileName);
	if (imageURL == null){
		System.err.println("Could not find image " + fileName);
		return new JLabel();
	}
	Icon icon = new ImageIcon(imageURL);
	JLabel imageLabel = new JLabel(icon);
	return imageLabel;
}
	
	public static void main(String[] args) {
		new SlotMachine().createUI();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(Slot1 == Slot2 && Slot1 == Slot3) {
			playSound("Win.wav");
			moneyLeft+=500;
			JOptionPane.showMessageDialog(null, "Impossible. You won.");
		}
		moneyLeft--;
		System.out.println("Hippity hoppity your money is my property");
		panel.removeAll();
		label.setText("Money Left: $" + moneyLeft);
		panel.add(label);
		panel.add(button);
		createThreeReels();
		frame.pack();
		}
	}
