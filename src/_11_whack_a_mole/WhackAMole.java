package _11_whack_a_mole;

import java.applet.AudioClip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class WhackAMole implements ActionListener {
	JFrame frame = new JFrame();
	Random random = new Random();
	JButton moleButton = new JButton();
	JPanel panel = new JPanel();

	void createUI() {
		frame.setSize(250, 275);
		frame.add(panel);
		drawButtons(21);
		frame.setTitle("Don't Tell PETA");
		frame.setVisible(true);
	}

	void drawButtons(int numberOfButtons) {
		int num = random.nextInt(numberOfButtons) + 1;
		for (int i = 1; i < numberOfButtons; i++) {

			if (i == num) {
				System.out.println(i);
				moleButton.setText("Mole!");
				moleButton.addActionListener(this);
				panel.add(moleButton);
			}
			JButton button = new JButton();
			button.addActionListener(this);
			panel.add(button);
		}
	}

	public static void main(String[] args) {
		new WhackAMole().createUI();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == moleButton) {
			playSound("Ding.wav");
		} else {
			speak("OOF you missed");
		}
		frame.dispose();
		frame.remove(panel);
		createUI();
	}

	void speak(String words) {
		try {
			Runtime.getRuntime().exec("say " + words).waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void playSound(String fileName) {
		AudioClip sound = JApplet.newAudioClip(getClass().getResource(fileName));
		sound.play();
	}
}
