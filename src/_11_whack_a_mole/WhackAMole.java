package _11_whack_a_mole;

import java.applet.AudioClip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;
import java.util.Random;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class WhackAMole implements ActionListener {
	JFrame frame;
	Random random = new Random();
	JPanel panel;
	int molesWhacked;
	int timesMissed;
	JButton moleButton;

	void createUI() {
		frame = new JFrame();
		panel = new JPanel();
		frame.setSize(250, 275);
		frame.add(panel);
		drawButtons(21);
		frame.setTitle("Aneurysm Induce-inator");
		frame.setVisible(true);
	}

	void drawButtons(int numberOfButtons) {
		int num = random.nextInt(numberOfButtons) + 1;
		for (int i = 1; i < numberOfButtons; i++) {
			if (i == num) {
				moleButton = new JButton();
				moleButton.setText("Mole!");
				moleButton.addActionListener(this);
				panel.add(moleButton);
			}
			JButton button = new JButton();
			button.addActionListener(this);
			panel.add(button);
		}
	}

	public void run() {
		new WhackAMole().createUI();
	}

	private void endGame(Date timeAtStart, int molesWhacked) {
		Date timeAtEnd = new Date();
		JOptionPane.showMessageDialog(null, "Your whack rate is "
				+ ((timeAtEnd.getTime() - timeAtStart.getTime()) / 1000.00 / molesWhacked) + " moles per second.");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (molesWhacked < 10 || timesMissed < 5) {
			if (e.getSource() == moleButton) {
				playSound("Ding.wav");
				molesWhacked++;
				System.out.println(molesWhacked);
			} else {
				speak("OOF you missed");
				timesMissed++;
			}
		} else if (molesWhacked >= 10) {
			
		}

		frame.dispose();
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
