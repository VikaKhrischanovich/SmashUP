package visualAppearance;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class SettingsPanel extends JPanel {

    private JComboBox jcombo;
    private static SettingsFrame settingsFrame;

    SettingsPanel(SettingsFrame settingsFrame){
        SettingsPanel.settingsFrame = settingsFrame;
        this.jcombo = new JComboBox();
        this.jcombo.setEditable(false);
        jcombo.addItem("2");
        jcombo.addItem("3");
        jcombo.addItem("4");
        this.jcombo.addActionListener(new ActionListener() {
                                          @Override
                                          public void actionPerformed(ActionEvent e) {
                                              SettingsFrame.numberOfPlayers = Integer.parseInt(jcombo.getSelectedItem().toString());
                                          }
                                      }

        );
        this.add(this.jcombo);

        JButton butt = new JButton("Назад");
        butt.addActionListener(new ActionListener() {


            @Override
            public void actionPerformed(ActionEvent e) {
                SettingsPanel.settingsFrame.dispose();
                MainMenuPanel.bottonActionsInWindow--;
                ArrayList<String> namesoflines = new ArrayList<>();
                Collections.addAll(namesoflines, "Многопользовательская игра", "Настройки", "Выход");
                MainMenuFrame mainMenu = new MainMenuFrame(namesoflines);
                mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                mainMenu.setVisible(true);
            }
        });
        this.add(butt);
    }

}
