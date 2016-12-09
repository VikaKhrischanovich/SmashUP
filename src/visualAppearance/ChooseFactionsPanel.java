package visualAppearance;


import model.Player;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ChooseFactionsPanel extends MainMenuPanel{

    final static int NUMBEROFFACTIONS = 8;
    private final int width = 132;
    private final int height = 198;
    private final ImageIcon image = new ImageIcon("H:\\SU\\src\\visualAppearance\\SmaSH.png");
    private Player[] players;
    private static int numberOfChoices = SettingsFrame.numberOfPlayers*2;

    public ChooseFactionsPanel(ChooseFactionsFrame chooseFactionsFrame, Player[] players) {
        this.players = players;

        this.setLayout(null);

        for (int j = 0; j < 2; j++ ) {
            for (int i = 0; i < ChooseFactionsPanel.NUMBEROFFACTIONS / 2; i++) {
                SUBottonGen jbott = createBotton(i, j);
                ChoiceBott choiceBott = new ChoiceBott(this.players,jbott);
                jbott.addActionListener(choiceBott);
                this.add(jbott);
            }
        }
    }

    private SUBottonGen createBotton(int selectedColumn, int selectedLine){
        SUBottonGen j = new SUBottonGen(this.image);
        j.setBounds(((ChooseFactionsFrame.DEFAULT_WIDTH - (this.width * 4)) / 5) + selectedColumn * (this.width +
                        ((ChooseFactionsFrame.DEFAULT_WIDTH - (this.width * 4)) / 5)),
                ((ChooseFactionsFrame.DEFAULT_HEIGHT - (this.height * 2)-40) / 3) + selectedLine * (this.height +
                        ((ChooseFactionsFrame.DEFAULT_HEIGHT - (this.height * 2)) / 3)),
                this.width,
                this.height);
        return j;
    }

    private class ChoiceBott implements ActionListener {

        private final Player[] players;
        private final SUBottonGen jbott;

        private ChoiceBott(Player[] players, SUBottonGen jbott){
            this.players = players;
            this.jbott = jbott;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i =0;i<SettingsFrame.numberOfPlayers;i++) {
                if(ChooseFactionsPanel.numberOfChoices%SettingsFrame.numberOfPlayers == i){
                    this.players[i].chooseRace(jbott.getGenNumber());
                    jbott.setVisible(false);
                    System.out.println("ra");
                    ChooseFactionsPanel.numberOfChoices--;
                    break;
                }
            }
            if (ChooseFactionsPanel.numberOfChoices == 0) {
                System.out.println("LLFLLFLFLLFL");
            }
        }
    }


}
