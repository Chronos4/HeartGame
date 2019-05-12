package heartstable;

import GraphicalInterface.Graphical;
import static GraphicalInterface.Graphical.absolutePath;
import static GraphicalInterface.Graphical.checkFlipForPlayer1;
import static GraphicalInterface.Graphical.checkFlipForPlayer2;
import static GraphicalInterface.Graphical.deckList;
import static GraphicalInterface.Graphical.pointsForPlayer1;
import static GraphicalInterface.Graphical.pointsForPlayer2;
import static GraphicalInterface.Graphical.totalPoints1;
import static GraphicalInterface.Graphical.totalPoints2;
import static GraphicalInterface.Graphical.checkDeal;
import static GraphicalInterface.Graphical.counter;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.util.Random;

public class HeartsDealer extends Human implements CardsDealer {

    int jobTime;

    public HeartsDealer(String name, String surname, int age, int jobTime) {
        super(name, surname, age); // kaloume ton constructor tou superclass-human
        this.jobTime = jobTime;
    }

    @Override
    public String introduceSelf() {
        /* to introduce methodos tou dealer exoume se static text na emfanizontai ta stoixeia tou dealer
        -->>h methodos pou thn xrhsimopoiei einai h introduce tou dealer
         */
        String information;
        information = "Hi! i am " + this.age + " years old and my name is " + this.name
                + " " + this.surname + "\nand i am doing this job for  " + this.jobTime + " years";
        return information;
    }

    @Override
    public void showDeck(JScrollPane pane) {
        /*Ayth h methodos pernei to main scrollpane apo to graphical class kai eisagei thn vasikh eikonas ths trapoulas
        pou periexei ola ta fyla mesa. ---->>Ayth h methodos kaleitai sto show deck apo ton dealer
         */
        ImageIcon img = new ImageIcon(absolutePath + "cards\\cards.png");
        JLabel label = new JLabel(img);
        pane.setViewportView(label);
    }

    @Override
    public Card dealRandomCard() {
        /* Travaei to teleytaio fylo apo thn trapoula h trapoula otan arxikopoieitai mesw ths methodou pou 
        exoume ftia3ei sto deck thn kanoume shuffle
        -- to fylo pou ginetai return taytoxrona ginetai kai remove apo to deck
    -----------------------------------------------------------------------------------------------    
        Ayth thn methodo thn xrhsimopoihoume sto show hand action listener kai gia tous 2 players
         */
        int testNum = deckList.size() - 1;
        String item = deckList.get(testNum);
        deckList.remove(testNum);
        Card card = new Card(item);
        return card;
    }

    @Override
    public void dealToPlayers(JLabel[] label) {
        for (int j = 0; j < label.length; j++) {
            ImageIcon tempIcon = new ImageIcon(absolutePath + "cards\\backview.png");
            label[j].setIcon(tempIcon);
        }
        checkDeal = true;
    }

    @Override
    public void decideWinner(JLabel[] labelll, JLabel pointsForPlayer1Label, JLabel pointsForPlayer2Label,
            JLabel totalPointsForPlayer1Label, JLabel totalPointsForPlayer2Label) {
        // 3eroume ta prwta 5 fyla apo 0-4 sto arraylist einai tou player 1 
        // kai ta ypoloipa 5 tou player 2
        // tha paroume ta names apo ta icon kai tha doume an yparxoun koupes sta xeria twn paixtwn 
        // sy synexeia tha ypologisoume poios exei tis pio polles koupes kai tha anadeixtei nikhths
        // epishs tha prosththoun 10 points gia thn diafora tou plithous apo koupes 
        //pou eixe se sxehsh me ton allon paikth
        if (checkFlipForPlayer1 == true && checkFlipForPlayer2 == true) {
            String example = Character.toString('#');
            for (int i = 0; i < labelll.length / 2; i++) {
                String tempItem = labelll[i].getName();
                if (tempItem.toLowerCase().contains(example)) {
                    pointsForPlayer1++;
                    pointsForPlayer1Label.setText(Integer.toString(pointsForPlayer1));
                }
            }
            for (int i = labelll.length / 2; i < labelll.length; i++) {
                String tempItem = labelll[i].getName();
                if (tempItem.toLowerCase().contains(example)) {
                    pointsForPlayer2++;
                    pointsForPlayer2Label.setText(Integer.toString(pointsForPlayer2));
                }
            }

            if (pointsForPlayer1 > pointsForPlayer2) {
                totalPoints1 += (pointsForPlayer1 - pointsForPlayer2) * 10;
                totalPointsForPlayer1Label.setText(Integer.toString(totalPoints1));
            } else if (pointsForPlayer2 > pointsForPlayer1) {
                totalPoints2 += (pointsForPlayer2 - pointsForPlayer1) * 10;
                totalPointsForPlayer2Label.setText(Integer.toString(totalPoints2));
            }
            pointsForPlayer1 = 0;
            pointsForPlayer2 = 0;
            this.dealToPlayers(labelll);
        }

    }
}
