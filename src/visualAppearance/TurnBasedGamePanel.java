package visualAppearance;

import model.Player;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;


class TurnBasedGamePanel extends MainMenuPanel {

    private JButton[] jButton;
    private JTextField[] jTextFields;
    private final int DEFAULT_WIDTH = 146;
    private final int DEFAULT_HEIGHT = 30;
    private static Player[] players;
    private static TurnBasedGameFrame turnBasedGameFrame;
    private static int numberNotSelectedPlayrs = SettingsFrame.numberOfPlayers;


    TurnBasedGamePanel(TurnBasedGameFrame turnBasedGameFrame){
        TurnBasedGamePanel.turnBasedGameFrame = turnBasedGameFrame;
        TurnBasedGamePanel.players = new Player[SettingsFrame.numberOfPlayers];
        this.setLayout(null);
        createLabelsAndTextFields();
    }

    private void createLabelsAndTextFields() {
        String player = "Player ";
        this.jButton = new JButton[SettingsFrame.numberOfPlayers];
        this.jTextFields = new  JTextField[SettingsFrame.numberOfPlayers];
        for (int i = 0; i <this.jButton.length ; i++) {
            this.jButton[i] = createButton(player, this.jButton.length, i + 1);
            this.add(this.jButton[i]);
            this.jTextFields[i] = createTextField(this.jTextFields.length, i + 1);
            this.add(jTextFields[i]);
            ChoosePlayerName choosePlayerName = new ChoosePlayerName(this.jButton[i],this.jTextFields[i], i);
            this.jButton[i].addActionListener(choosePlayerName);


        }
        JButton backButton = this.createButton("Назад");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TurnBasedGamePanel.turnBasedGameFrame.dispose();
                MainMenuPanel.bottonActionsInWindow--;
                ArrayList<String> namesoflines = new ArrayList<>();
                Collections.addAll(namesoflines, "Пошаговая с выбором персонажей", "Онлайн");
                MainMenuFrame mainMenu = new MainMenuFrame(namesoflines);
                mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                mainMenu.setVisible(true);
            }
        });
        this.add(backButton);
    }
    JButton createButton(final String s,final  int numberOfColumns, final  int numberOFselectedColumn){
        String finalName = s + " " + numberOFselectedColumn;
        JButton jButton = new JButton(finalName);
        WidthAndHeight widthAndHeihht = returnWidthOrHeight(s);
        jButton.setBounds(((TurnBasedGameFrame.DEFAULT_WIDTH-(widthAndHeihht.getWidth()*2*numberOfColumns))/(numberOfColumns+1))
                +((numberOFselectedColumn-1)*((widthAndHeihht.getWidth()*2)+((TurnBasedGameFrame.DEFAULT_WIDTH-
                (widthAndHeihht.getWidth()*2*numberOfColumns))/(numberOfColumns+1)))),
                (TurnBasedGameFrame.DEFAULT_HEIGHT/4-widthAndHeihht.getHeight()),
                widthAndHeihht.getWidth()*2,
                widthAndHeihht.getHeight()*2);
        return jButton;
    }

    JButton createButton(String name){
        JButton jButton = new JButton(name);
        WidthAndHeight widthAndHeihht = returnWidthOrHeight(name);
        jButton.setBounds((TurnBasedGameFrame.DEFAULT_WIDTH-widthAndHeihht.getWidth()*2),
                (TurnBasedGameFrame.DEFAULT_HEIGHT-widthAndHeihht.getHeight()*3),
                widthAndHeihht.getWidth(),
                widthAndHeihht.getHeight());

        return jButton;
    }

    private JTextField createTextField(final  int numberOfColumns, final int numberOFselectedColumn){
        JTextField jTextField = new JTextField("NickName of Player " + numberOFselectedColumn);
        jTextField.setBounds(((TurnBasedGameFrame.DEFAULT_WIDTH - (this.DEFAULT_WIDTH  * numberOfColumns)) / (numberOfColumns + 1))
                        + ((numberOFselectedColumn - 1) * ((this.DEFAULT_WIDTH ) + ((TurnBasedGameFrame.DEFAULT_WIDTH -
                        (this.DEFAULT_WIDTH  * numberOfColumns)) / (numberOfColumns + 1)))),
                        (TurnBasedGameFrame.DEFAULT_HEIGHT / 2 - this.DEFAULT_HEIGHT), this.DEFAULT_WIDTH, this.DEFAULT_HEIGHT);

        return jTextField;
    }

    private class ChoosePlayerName implements ActionListener{

        private JButton jButton;
        private JTextField jTextField;
        private int numPlayer;


        ChoosePlayerName(JButton jButton, JTextField jTextField, int i){
            this.jButton = jButton;
            this.jTextField = jTextField;
            this.numPlayer = i;

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            jButton.setVisible(false);
            jTextField.setEditable(false);
            TurnBasedGamePanel.numberNotSelectedPlayrs--;
            TurnBasedGamePanel.players[this.numPlayer] = new Player(this.jTextField.getText(), this.numPlayer);
            if (TurnBasedGamePanel.numberNotSelectedPlayrs < 1) {
                TurnBasedGamePanel.turnBasedGameFrame.dispose();
                ChooseFactionsFrame chooseFactionsFrame = new ChooseFactionsFrame(TurnBasedGamePanel.players);
                chooseFactionsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                chooseFactionsFrame.setVisible(true);
            }

        }
    }
}
