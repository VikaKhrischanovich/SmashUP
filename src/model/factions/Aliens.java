package model.factions;

import model.PlayingCards;
import model.factions.aliens.*;
import model.interfaces.ISelectionOfCards;


public class Aliens  extends PlayingCards implements ISelectionOfCards {

    @Override
    public Aliens chooseCard(int i) {

        if (i >= 0 && i<=3)
            return new CollectorAli();
        else if (i >=4 && i<=5)
            return new Disintegrator();
        else if (i == 6)
            return new Interference();
        else if (i >=7 && i<=8)
            return new Invader();
        else if (i==9)
            return new Invasion();
        else if (i==10)
            return new Kidnapping();
        else if (i >=11 && i <=12)
            return new LiftingBeam();
        else if (i==13)
            return new Overlord();
        else if (i==14)
            return new Sensing();
        else if (i >=15 && i <=17)
            return new Spy();
        else if (i==18)
            return new Terraforming();

        return new СropСircles();

    }


}
