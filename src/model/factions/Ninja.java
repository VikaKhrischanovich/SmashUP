package model.factions;


import model.PlayingCards;
import model.factions.ninja.*;
import model.interfaces.ISelectionOfCards;

public class Ninja extends PlayingCards implements ISelectionOfCards {

    @Override
    public Ninja chooseCard(int i) {
        if (i >= 0 && i<=3)
            return new NinjaCadet();
        else if (i >=4 && i<=6)
            return new Shinobi();
        else if (i >=7 && i <=8)
            return new Assassin();
        else if (i==9)
            return new NinjaSensei();
        else if (i==10)
            return new DymZavesa();
        else if (i==11)
            return new Killing();
        else if (i >=12 && i <=13)
            return new StarFall();
        else if (i==14)
            return new Poison();
        else if (i==15)
            return new Mask();
        else if (i==16)
            return new Deception();
        else if (i >=17 && i <=18)
            return new EntryNin();

        return new UnderCover();
    }
}