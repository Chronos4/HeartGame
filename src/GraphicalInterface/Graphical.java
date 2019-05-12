package GraphicalInterface;

import heartstable.Card;
import heartstable.Deck;
import heartstable.HeartsDealer;
import heartstable.HeartsPlayer;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class Graphical extends JFrame {

    // TODO :  the absolute path for the cards directory change it  
    public static final String absolutePath = "C:\\Users\\georg\\OneDrive\\Έγγραφα\\NetBeansProjects\\HeartsTable\\src\\";
    private JPanel mainPanel;
    private JLabel player1, dealer, player2, numberOfPlayer1, numberOfPlayer2, totalPlayer1, totalPlayer2;
    private JLabel pointsForPlayer2Label, pointsForPlayer1Label, totalPointsForPlayer1Label, totalPointsForPlayer2Label;
    private JLabel[] label = new JLabel[10]; // the total labels for the cards in the hand f each player
    private JButton introduce1, introduce2, introduceD, showDeck, showHand1, showHand2, deal, decideW;
    private JTextArea mainArea, secondMainArea;
    private JScrollPane mainScrollPane;
    public static int pointsForPlayer1 = 0, pointsForPlayer2 = 0, totalPoints1 = 0, totalPoints2 = 0;
    private Deck deck;
    public static ArrayList<String> deckList, newList;
    public static int counter = 0;
    public static Boolean checkDeal = false;
    public static Boolean checkFlipForPlayer1 = false, checkFlipForPlayer2 = false; //aytes oi boolean times 
    //xrhsimopoiountai wste gia na mproume na ektelsoume thn methodo decideWinner efoson kai oi 2 paixtes exoun
    // anoi3ei ta fyla tous.

    /* O logos pou evala parametrous ston constructor einai gia na perasw ta instance apo ta players kai ton dealer
    poy dhmiourghsa sthn main wste na mporw na exw prosvash sta dedomena 
     */
    Graphical(HeartsDealer theOnlyDealer, HeartsPlayer firstPlayer, HeartsPlayer secondPlayer) {
        deck = new Deck();   // TO prwto pou kanoume einai na ftia3oume to deck me ta cards kai sthn apo katw grammh 
        // to kaloume to deck
        deck.deckShuffle();  // kanei shuffle to list mesa sthn deck klassh oustiastika kanei shuffle to deck mas
        // h hlopoihsh ths deckshuffle einai sto deck class
        newList = deck.getDeck();
        deckList = newList;
        setTitle("Hearts Table");
        //setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // setResizable(false); 
        setMinimumSize(new Dimension(974, 600)); // setting the minimum and maximum size of the frame
        //setMaximumSize(new Dimension(974, 500));

        // THIS IS THE MAIN PANEL OF THE FRAME 
        mainPanel = new JPanel(new BorderLayout());
        add(mainPanel);// HERE WE ARE ADDING IT TO THE FRAME

        //WE ARE GOING TO CREATE A FLOW LAYOUT  FOR THE TOP SIDE OF THE MAIN PANEL 
        JPanel pageStartPanel = new JPanel(new FlowLayout(3));
        mainPanel.add(pageStartPanel, BorderLayout.PAGE_START); // we add it in the main panel

        /* part 1 of the flow layout in the top side */
        JPanel panelForFlowStart = new JPanel(new BorderLayout()); // creating the borderlayout as the first item 
        // of the flow layout top side
        pageStartPanel.add(panelForFlowStart); // add it to the main flowlayout for the top side

        player1 = new JLabel("Player 1");
        player1.setHorizontalAlignment(JLabel.CENTER); // we center the label 
        panelForFlowStart.add(player1, BorderLayout.CENTER); //adding the label in the borderlayout which exists
        // in the flow layout top

        JPanel panelFlowInBorder = new JPanel(new FlowLayout(2)); // we create this flow layout to make the buttons 
        // side by side then we will add it in the borderlayout too
        panelForFlowStart.add(panelFlowInBorder, BorderLayout.PAGE_END);

        // creating the buttons
        introduce1 = new JButton("Introduce");
        introduce1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String information = firstPlayer.introduceSelf();
                secondMainArea.setText("-Player1 \n" + information + "\n And i love"
                        + " to play Hears and i am known as Player 1.");
            }

        });
        panelFlowInBorder.add(introduce1, BorderLayout.PAGE_END);

        showHand1 = new JButton("Show Hand");
        showHand1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkDeal == true) { // h xrhsh ths checkdeal einai na elegxoume an exoun moirastei fyla prwta
                    //kai meta na exoume thn dynatothta na ta kanoume flip
                    for (int i = 0; i < label.length / 2; i++) {
                        Card tempCard = theOnlyDealer.dealRandomCard();
                        String tempName = tempCard.getName();
                        label[i].setIcon(tempCard.getCard());
                        label[i].setName(tempName);
                    }
                    checkFlipForPlayer1 = true;
                } else {
                    System.out.println("deal first");
                }
            }
        }
        );
        panelFlowInBorder.add(showHand1, BorderLayout.PAGE_END);

        /*-------------------------------------------------------------------*/
        // PART 2 OF THE TOP FLOW LAYOUT
        // here we will add the labels for the cards 
        JPanel panelForHere = new JPanel(new FlowLayout(5));

        pageStartPanel.add(panelForHere);

        for (int k = 0;
                k < (label.length)
                / 2; k++) {
            label[k] = new JLabel();
            addLayouts(label[k]);
            panelForHere.add(label[k]);
        }

// -----------------------------------------------------------------------------
        // HERE WE GOT THE PART 3 OF THE FLOW LAYOUT IN THE TOP SIDE
        // this part consists of the labels about the points 
        JPanel newFlowForHere = new JPanel(new GridLayout(2, 2)); // we need the gridlayout too make them in a box shape

        pageStartPanel.add(newFlowForHere);
        numberOfPlayer1 = new JLabel("Number of hearts: ");

        newFlowForHere.add(numberOfPlayer1);

        pointsForPlayer1Label = new JLabel(Integer.toString(pointsForPlayer1));

        newFlowForHere.add(pointsForPlayer1Label);

        totalPlayer1 = new JLabel("Total points: ");

        newFlowForHere.add(totalPlayer1);

        totalPointsForPlayer1Label = new JLabel(Integer.toString(totalPoints1));

        newFlowForHere.add(totalPointsForPlayer1Label);
//---------------------------------------------------------------------------

//   HERE WE ARE CREATING THE CENTER OF THE MAIN PANEL
        // in this part we will create 2 gridlayouts and we will add them the first one to 
        // Line-start of the main panel and the second one to the center of the border layout
        JPanel gridLayoutForMiddle = new JPanel(new GridLayout(2, 1)); // first gridlayout

        gridLayoutForMiddle.setPreferredSize(
                new Dimension(300, 50));
        mainPanel.add(gridLayoutForMiddle, BorderLayout.LINE_START); // HERE WE ARE ADDING THE MAIN GRIDLAYOUT TOU THE ORIGINAL
        // MAIN PANEL

        // WE ARE GOING TO CREATE THE 1ST PART OF THE GRIDLAYOUT
        dealer = new JLabel("Dealer");

        dealer.setPreferredSize(
                new Dimension(40, 40));
        dealer.setHorizontalAlignment(JLabel.CENTER); // we center the label in the layout

        gridLayoutForMiddle.add(dealer);

        // the second part is to add the buttons for the 1st gridlayout
        JPanel secondGridLayout = new JPanel(new GridLayout(2, 2));

        secondGridLayout.setPreferredSize(
                new Dimension(50, 50));
        gridLayoutForMiddle.add(secondGridLayout);
        introduceD = new JButton("Introduce");

        introduceD.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                String information = theOnlyDealer.introduceSelf();
                secondMainArea.setText("-Dealer \n" + information);
            }

        }
        );
        introduceD.setPreferredSize(
                new Dimension(25, 25));
        showDeck = new JButton("Show Deck");

        showDeck.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                theOnlyDealer.showDeck(mainScrollPane);
            }
        }
        );
        showDeck.setPreferredSize(
                new Dimension(25, 25));
        deal = new JButton("Deal");

        deal.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                theOnlyDealer.dealToPlayers(label);
            }
        }
        );
        deal.setPreferredSize(
                new Dimension(25, 25));
        decideW = new JButton("Decide winner");

        decideW.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                if (counter < 4) {
                    theOnlyDealer.decideWinner(label, pointsForPlayer1Label, pointsForPlayer2Label, totalPointsForPlayer1Label, totalPointsForPlayer2Label);
                    counter++;
                } else {
                    int p1 = Integer.parseInt(totalPointsForPlayer1Label.getText());
                    int p2 = Integer.parseInt(totalPointsForPlayer2Label.getText());
                    if (p1 > p2) {
                        secondMainArea.setText("-Player1 wins with " + Integer.toString(p1) + " points");
                    } else if (p1 < p2) {
                        secondMainArea.setText("-Player2 wins with " + Integer.toString(p2) + " points");
                    } else {
                        secondMainArea.setText("Its a draw");
                    }
                }
                // deck.deckShuffle();
            }
        }
        );
        decideW.setPreferredSize(
                new Dimension(25, 25));
        secondGridLayout.add(introduceD);

        secondGridLayout.add(showDeck);

        secondGridLayout.add(deal);

        secondGridLayout.add(decideW);

// HERE WE ARE CREATING THE SECOND GRIDLAYOUT IN HERE WE WILL ADD THE TO TEXT -AREAS         
        JPanel secondGridLayoutMiddle = new JPanel(new GridLayout(2, 1));// creating the layout

        mainPanel.add(secondGridLayoutMiddle, BorderLayout.CENTER); // adding it to the main panel

        mainArea = new JTextArea(30, 30); // initializing the first main area
        mainScrollPane = new JScrollPane(mainArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        mainArea.setPreferredSize(
                new Dimension(300, 300));
        mainArea.setEditable(
                false); // we make the area not editable
        mainArea.setBackground(Color.LIGHT_GRAY);

        secondGridLayoutMiddle.add(mainScrollPane);

// Now the last part of the second gridlayout
        // is to add a simple text - that will display the data of the person -dealer
        secondMainArea = new JTextArea(15, 20);

        secondGridLayoutMiddle.add(secondMainArea);

//--------------------------------------------------------------------------
//WE ARE GOING TO CREATE A FLOW LAYOUT FOR THE BOTTOM SIDE IN THE MAIN PANEL
        // this part is the same with the first flow layout for the top we created
        JPanel pageEndPanel = new JPanel(new FlowLayout(3)); // the main flow layout for the bottome side

        mainPanel.add(pageEndPanel, BorderLayout.PAGE_END);

        /* part 1 of the flow layout in the Bottom side */
//-------------------------------------------------------------------------------        
        JPanel panelForFlowEnd = new JPanel(new BorderLayout());

        pageEndPanel.add(panelForFlowEnd);

        player2 = new JLabel("Player 2");

        player2.setHorizontalAlignment(JLabel.CENTER);

        panelForFlowEnd.add(player2, BorderLayout.CENTER);

        JPanel panelFlowInBorderBottom = new JPanel(new FlowLayout(2));

        panelForFlowEnd.add(panelFlowInBorderBottom, BorderLayout.PAGE_END);

        introduce2 = new JButton("Introduce");

        introduce2.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                String information = secondPlayer.introduceSelf();
                secondMainArea.setText("-Player2 \n" + information + "\n And i love"
                        + " to play Hears and i am known as Player 2.");
            }

        }
        );
        panelFlowInBorderBottom.add(introduce2, BorderLayout.PAGE_END);

        showHand2 = new JButton("Show Hand");

        showHand2.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                if (checkDeal == true) {
                    for (int i = label.length / 2; i < label.length; i++) {
                        Card tempCard = theOnlyDealer.dealRandomCard();
                        String tempName = tempCard.getName();
                        label[i].setIcon(tempCard.getCard());
                        label[i].setName(tempName);
                    }
                    checkFlipForPlayer2 = true;
                } else {
                    System.out.println("deal first");
                }
            }
        }
        );
        panelFlowInBorderBottom.add(showHand2, BorderLayout.PAGE_END);

        /*-------------------------------------------------------------------------------*/
        // PART 2 OF THE Bottom FLOW LAYOUT
        JPanel panelForHereBottom = new JPanel(new FlowLayout(5));

        pageEndPanel.add(panelForHereBottom);

        for (int e = 5;
                e < label.length;
                e++) {
            label[e] = new JLabel();
            addLayouts(label[e]);
            panelForHereBottom.add(label[e]);
        }

// -----------------------------------------------------------------------------
        // HERE WE GOT THE PART 3 OF THE FLOW LAYOUT IN THE Bottom SIDE
        //-----------------------------------------------------------------------------       
        JPanel newFlowForHereBottom = new JPanel(new GridLayout(2, 2));

        pageEndPanel.add(newFlowForHereBottom);
        numberOfPlayer2 = new JLabel("Number of hearts: ");

        newFlowForHereBottom.add(numberOfPlayer2);

        pointsForPlayer2Label = new JLabel(Integer.toString(pointsForPlayer2));

        newFlowForHereBottom.add(pointsForPlayer2Label);

        totalPlayer2 = new JLabel("Total points: ");

        newFlowForHereBottom.add(totalPlayer2);

        totalPointsForPlayer2Label = new JLabel(Integer.toString(totalPoints2));

        newFlowForHereBottom.add(totalPointsForPlayer2Label);

//-----------------------------------------------------------------------------  
        setVisible(
                true);
    }

    public JLabel addLayouts(JLabel label) {
        /* topiko method wste ta labels sthn ekkinhsh ths efarmoghs na exoun by defaukt to empty label
        
         */
        ImageIcon icon = new ImageIcon(absolutePath + "cards\\empty.png");
        label.setIcon(icon);
        label.setPreferredSize(new Dimension(100, 120));
        return label;

    }

}
