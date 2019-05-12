/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heartstable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

/**
 *
 * @author georg
 */
public class Deck{
    /* SKOPOS THS KLASSHS AYTHS EINAI H DIMIOURGEIA MONO TOU DECK 
    AYTO GINETAI 
    1) STHN GRAPHICAL CLASS DHMIOURGOUME STHN ARXH TOUS CONSTRUCTOR ENA INSTANCE TOU DECK
    2)KAI KANOUME SE ENA TOPIKO THS GRAPHICAL CLASS ARRAYLIST RETURN TO DECK APO AYTHN THN TRAPOULA
    */
    
    private ArrayList<String> list = new ArrayList<String>();
    String[] figure = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    int k = 0;
    
    public Deck(){
        for (int i = 0; i < 52; i++) {
            if (i == 13 || i == 26 || i == 39) {
                k = 0;
            }
            if (i < 13) {
                list.add("$" + figure[k]+".png");
            } else if (i >= 13 && i < 25) {
                list.add("&" + figure[k]+".png");
            } else if (i >= 26 && i < 39) {
                list.add("#" + figure[k]+".png");
            } else {
                list.add("%" + figure[k]+".png");
            }
            k++;
        }
        System.out.println(list.size());
    }
    
    
    public void deckShuffle(){
        Collections.shuffle(list);
    }

    
    public ArrayList getDeck(){
        return list;
    }
    
}
