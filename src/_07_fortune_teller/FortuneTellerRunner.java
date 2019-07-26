package _07_fortune_teller;
import javax.swing.SwingUtilities;

/*
 *    Copyright (c) The League of Amazing Programmers 2013-2019
 *    Level 1
 */

public class FortuneTellerRunner {
    public static void main(String[] args) throws Exception {
      	 SwingUtilities.invokeLater(new FortuneTeller());
      	 begin();
       }
    
    static void begin() {
      	 // Welcome the user. Give them a hint for the secret location.
    	System.out.println("Hello random person. You have accessed a totally legitimate fortune teller that is NOT a scam. In order to proceed with questioning, you must click the green circle's center.");
    }
}
