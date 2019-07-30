package _10_pig_latin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PigLatinTranslator implements ActionListener {
	
	String text1;
	String text2;
	char text;
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JTextField textfield1 = new JTextField();
	JTextField textfield2 = new JTextField();
	JButton button = new JButton();

	void createUI() {
		frame.setTitle("What even is this language");
		textfield1.setColumns(20);
		textfield2.setColumns(20);
		button.setText("TRANSLATE");
		button.addActionListener(this);
		panel.add(textfield1);
		panel.add(button);
		panel.add(textfield2);
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}
	
	void convertToString() {
		text1 = textfield1.getText();
		for(int i=0; i<text1.length(); i++) {
			text = text1.charAt(i);
		}
	}

		/**
		* Method to test whether a character is a letter or not.
		* @param c The character to test
		* @return True if it's a letter
		*/
		private static boolean isLetter(char c) {
		return ( (c >= 'A' && c <= 'Z') || (c >='a' && c <= 'z') );
		}
		    
		/**
		* Method to translate one word into pig latin.
		* @param word The word in english
		* @return The pig latin version
		*/
		private static String pigWord(String word) {
		int split = firstVowel(word);
		return word.substring(split)+"-"+word.substring(0, split)+"ay";
		}
			
		/**
		* Method to translate a sentence word by word.
		* @param s The sentence in English
		* @return The pig latin version
		*/
		public String translate(String s) {
		String latin = "";
		int i = 0;
		while (i < s.length()) {
		// Take care of punctuation and spaces
		while (i < s.length() && !isLetter(s.charAt(i))) {
		latin = latin + s.charAt(i);
		i++;
		}
		// If there aren't any words left, stop.
		if (i>=s.length()) break;
		// Otherwise we're at the beginning of a word.
		int begin = i;
		while (i < s.length() && isLetter(s.charAt(i))) {
		i++;
		}
		// Now we're at the end of a word, so translate it.
		int end = i;
		latin = latin + pigWord(s.substring(begin, end));
		}
		return latin;
		}
		/**
		* Method to find the index of the first vowel in a word.
		* @param word The word to search
		* @return The index of the first vowel
		*/
			  private static int firstVowel(String word) {
		word = word.toLowerCase();
		for (int i=0; i < word.length(); i++)
		if (word.charAt(i)=='a' || word.charAt(i)=='e' ||
		word.charAt(i)=='i' || word.charAt(i)=='o' ||
		word.charAt(i)=='u')
		return i;
		return 0;
		}
	
	public static void main(String[] args) {
		new PigLatinTranslator().createUI();
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		convertToString();
		PigLatinTranslator.isLetter(text);
		System.out.println(translate(text1));
		textfield2.setText(translate(text1));
	}
}
