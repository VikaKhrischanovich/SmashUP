package model.factions;


import model.PlayingCards;
import model.factions.dinosaurus.*;
import model.interfaces.ISelectionOfCards;

public class Dinosaurus extends PlayingCards implements ISelectionOfCards {


    @Override
    public Dinosaurus chooseCard(int i) {

        if (i >= 0 && i<=3)
            return new BattleRaptor();
        else if (i >=4 && i<=5)
            return new Howl();
        else if (i >=6 && i<=7)
            return new Improvement();
        else if (i==8)
            return new KingLizard();
        else if (i >=9 && i<=10)
            return new Lazaratos();
        else if (i==11)
            return new Modernization();
        else if (i==12)
            return new NaturalSelection();
        else if (i >=13 && i<=15)
            return new Panesar();
        else if (i==16)
            return new Rampage();
        else if (i==17)
            return new Reserve();
        else if (i==18)
            return new SurvivalOfTheFittest();

        return new TeethClawsAndTwoSmokingBarrels();

    }
}
