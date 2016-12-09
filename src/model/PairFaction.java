package model;


import java.util.ArrayList;

public class PairFaction {

    private final Faction[] factions={new Faction(),new Faction()};

    private final int numberOfFaction;
    private  int countOfFaction;

    public PairFaction(final int numberOfFaction) {
        this.numberOfFaction = numberOfFaction;
        this.countOfFaction = numberOfFaction;
    }

    public void setIDOfFaction(int idOfFaction, ArrayList<PlayingCards> playingCards) {

        if (countOfFaction == 0) {
            System.out.println("Сделать уведомление на отсутствие выбора");
        } else {
            factions[countOfFaction - 1].setFaction(idOfFaction, playingCards);
            oneTimeChoiceOfFaction();
        }
    }

    private void oneTimeChoiceOfFaction(){
        countOfFaction--;
    }



}
