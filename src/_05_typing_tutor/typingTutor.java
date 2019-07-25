package _05_typing_tutor;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class typingTutor implements KeyListener {
	JFrame frame=new JFrame();
	char currentLetter;
	JLabel label= new JLabel();
	
	char generateRandomLetter() {
		Random random = new Random();
		return (char) (random.nextInt(26) +'a');
	}
	
	public static void main(String[] args) {
		typingTutor typingTutor = new typingTutor();
		typingTutor.createUI();
	}
	void createUI() {
		frame.setVisible(true);
		frame.addKeyListener(this);
		currentLetter = generateRandomLetter();
		label.setText(currentLetter+"");
		label.setFont(label.getFont().deriveFont(28.0f));
		label.setHorizontalAlignment(JLabel.CENTER);
		frame.add(label);
		frame.pack();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getKeyChar());
		label.setText(currentLetter+"");
		if(currentLetter==e.getKeyChar()) {
			System.out.println("Correct");
			frame.setBackground(Color.green);
		}else {
			frame.setBackground(Color.red);
		}
		currentLetter = generateRandomLetter();
		
	}
}
