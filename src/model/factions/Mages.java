package model.factions;


import model.PlayingCards;
import model.factions.mages.*;
import model.interfaces.ISelectionOfCards;

public class Mages extends PlayingCards implements ISelectionOfCards {

    @Override
    public Mages chooseCard(int i) {

        if (i == 0)
            return new Archmage();
        else if (i >=1 && i<=2)
            return new Calling();
        else if (i == 3)
            return new Clairvoyance();
        else if (i == 4)
            return new DeathToll();
        else if (i >=5 && i<=7)
            return new Enchantress();
        else if (i >=8 && i<=9)
            return new Hronomag();
        else if (i == 10)
            return new MassSpell();
        else if (i >=11 && i<=14)
            return new Neophyte();
        else if (i==15)
            return new Portal();
        else if (i >=16 && i <=17)
            return new SecretKnowledge();
        else if (i==18)
            return new TheWindOfChange();

        return new TimeLoop();

    }
}
