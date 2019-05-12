/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heartstable;

import static GraphicalInterface.Graphical.absolutePath;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Card {
    /* dhmiourgoume ta cards ousiastika kanoume return to full path tou icon 
    */
    private ImageIcon ic;
    private JLabel label;
    private String name;
    Card(String item) {
        this.name = item;
        this.ic = new ImageIcon(absolutePath+"cards\\" + item);
    }

    public ImageIcon getCard() {
        return this.ic;
    }
    public String getName(){
        return this.name;
    }
}
