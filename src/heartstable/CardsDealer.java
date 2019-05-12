/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heartstable;

import javax.swing.JLabel;
import javax.swing.JScrollPane;


public interface CardsDealer {
    
    public void showDeck(JScrollPane pane);
    public Card dealRandomCard();
    public void dealToPlayers(JLabel[] label);
    public void decideWinner(JLabel[] label,JLabel label1,JLabel label2,JLabel label3,JLabel label4);
    
}
