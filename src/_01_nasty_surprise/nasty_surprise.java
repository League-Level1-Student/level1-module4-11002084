package _01_nasty_surprise;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class nasty_surprise implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton trickButton = new JButton();
	JButton treatButton = new JButton();

	void putStuffTogether() {
		panel.add(trickButton);
		panel.add(treatButton);
		frame.add(panel);
		frame.setVisible(true);
		frame.pack();
		trickButton.setText("Trick");
		treatButton.setText("Treat");
		trickButton.addActionListener(this);
		treatButton.addActionListener(this);
	}

	public static void main(String[] args) {
		nasty_surprise surprise = new nasty_surprise();
		surprise.putStuffTogether();

	}

	private void showPictureFromTheInternet(String imageUrl) {
		try {
			URL url = new URL(imageUrl);
			Icon icon = new ImageIcon(url);
			JLabel imageLabel = new JLabel(icon);
			JFrame frame2 = new JFrame();
			frame2.add(imageLabel);
			frame2.setVisible(true);
			frame2.pack();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==trickButton) {
		showPictureFromTheInternet("https://d17fnq9dkz9hgj.cloudfront.net/uploads/2018/04/Pomeranian_02.jpg");
	}else if(e.getSource()==treatButton)

	{
		showPictureFromTheInternet("https://i.imgur.com/AS22WfJ.jpg");
	}
}
}
