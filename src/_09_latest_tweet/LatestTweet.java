package _09_latest_tweet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class LatestTweet implements ActionListener {
	static LatestTweet tweet = new LatestTweet();
	JFrame frame = new JFrame();
	JPanel panel= new JPanel();
	JTextField textfield = new JTextField();
	JButton button = new JButton();
	JLabel label = new JLabel();
	String search;
	
	void createUI(){
		frame.setTitle("You should've used Reddit");
		textfield.setColumns(25);
		button.setText("Search Twitter");
		button.addActionListener(this);
		panel.add(label);
		panel.add(textfield);
		panel.add(button);
		frame.add(panel);
		frame.setVisible(true);
		frame.pack();
	}
	
	void searchWhat() {
		search = textfield.getText();
		System.out.println(getLatestTweet(search));
		label.setText(getLatestTweet(search));
		frame.pack();
	}
	
	public static void main(String[] args) {
		tweet.createUI();

		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("TWEET TWEET THE BIRDS ARE SINGING");
		tweet.searchWhat();
	}
	
	
	private String getLatestTweet(String searchingFor) {

	    Twitter twitter = new TwitterFactory().getInstance();

	    AccessToken accessToken = new AccessToken(
	        "2453751158-IVD2VGZsvwZiRKxNe3Gs2lMjg30nvSkV1xSuPFf",
	        "vBa5PjKfuMTK1LLBG51nCUI9r5d6Ph5cAHrS73spg6Nvu");
	    twitter.setOAuthConsumer("YqeZdD2hYxOKv4QOkmp0i2djN",
	        "6XUB1r8KXBvd8Pk9HHW3NgphMxHvHWBLAr5TihnckMU0ttyGST");
	    twitter.setOAuthAccessToken(accessToken);

	Query query = new Query(searchingFor);
	    try {
	        QueryResult result = twitter.search(query);
	        return result.getTweets().get(0).getText();
	    } catch (Exception e) {
	        System.err.print(e.getMessage());
	        return "What the heck is that?";
	    }
	}
}
