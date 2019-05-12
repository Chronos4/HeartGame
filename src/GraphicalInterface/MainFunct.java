package GraphicalInterface;

import heartstable.HeartsDealer;
import heartstable.HeartsPlayer;

public class MainFunct {

    public static void main(String[] args) {
        HeartsDealer theOnlyDealer = new HeartsDealer("john", "doe", 21, 6);
        HeartsPlayer firstPlayer = new HeartsPlayer("michael", "arch", 22);
        HeartsPlayer secondPlayer = new HeartsPlayer("george", "Tsapw", 23);
        Graphical gr = new Graphical(theOnlyDealer, firstPlayer, secondPlayer);

    }
}
