package model;


import java.util.ArrayList;

public class Player {

    private final String NAME;
    private final int NUMBEROFPLAYER;
    private final int NUMBEROFCARDS = 40;
    private final int countFaction = 2;
    private final int CRITRIONOFCOMPLETE = 0;
    private int CRITRIONOFWIN = 15;
    private int countAction = 1;
    private int countHenchman = 1;
    private int points = 0;
    private PairFaction pairFaction = new PairFaction(countFaction);
    private ArrayList<PlayingCards> cards = new ArrayList<>(NUMBEROFCARDS);



    public Player(final String name, final int number) {
        NAME = name;
        NUMBEROFPLAYER=number;
    }


    public void chooseRace(int idOfFaction){

        pairFaction.setIDOfFaction(idOfFaction,this.cards);

    }

    public ArrayList<PlayingCards> getCards() {
        return cards;
    }
}
