package model;

import model.factions.Aliens;
import model.factions.Dinosaurus;
import model.factions.Ninja;

import java.util.ArrayList;

public class Faction {

    private int idOfFaction;
    final private int NINJA = 1, ALIENS = 2, DINOSAURUS = 3, MAGES = 4, ZOMBIES = 5, PIRATES = 6, GOBLINS = 7, ROBOTS = 8;

    final private int NUMBEROFCARDSINFACTIONDECK = 20;



    public Faction() {

    }

    public void setFaction(final int idOfFaction, ArrayList<PlayingCards> playingCards) {
        this.idOfFaction=idOfFaction;

        if (this.idOfFaction==NINJA) {
            for (int i = 0; i < this.NUMBEROFCARDSINFACTIONDECK; i++) {
                playingCards.add(new Ninja().chooseCard(i));
            }
        }else if (this.idOfFaction==ALIENS) {
            for (int i = 0; i < this.NUMBEROFCARDSINFACTIONDECK; i++) {
                playingCards.add(new Aliens().chooseCard(i));
            }
        }else if (this.idOfFaction==DINOSAURUS) {
            for (int i = 0; i < this.NUMBEROFCARDSINFACTIONDECK; i++) {
                playingCards.add(new Dinosaurus().chooseCard(i));
            }
        }else if (this.idOfFaction==MAGES) {
            for (int i = 0; i < this.NUMBEROFCARDSINFACTIONDECK; i++) {
                playingCards.add(new Dinosaurus().chooseCard(i));
            }
        }else
            System.out.println(" сисюны");


    }

    public int getIdOfFaction() {
        return idOfFaction;
    }
}

