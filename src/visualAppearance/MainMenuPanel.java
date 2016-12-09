package visualAppearance;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;


class MainMenuPanel extends JPanel {

    private ArrayList<String> namesoflines;
    private   int numbersoflines;
    JPanel panel= new JPanel();
    private JButton[] jbutt;
    private NextWindow[] nextWindow;
    private ArrayList<MyButtonMM> listBottoms = new ArrayList<>();
    private MainMenuFrame mainMenuFrame;
    static int bottonActionsInWindow=0;

    MainMenuPanel(){}

    MainMenuPanel(final ArrayList<String> namesoflines, final MainMenuFrame mainMenuFrame) {
        this.mainMenuFrame = mainMenuFrame;
        this.namesoflines = namesoflines;
        this.numbersoflines = namesoflines.size();
        this.jbutt = new JButton[this.numbersoflines];
        this.nextWindow = new NextWindow[this.numbersoflines];
        this.panel.setLayout(null);

        for (int i = 0; i < this.numbersoflines; i++) {
             this.listBottoms.add(new MyButtonMM(this.namesoflines.get(i), this.numbersoflines, i + 1));
            this.jbutt[i] = createButton(this.listBottoms.get(i).nameButton, this.listBottoms.get(i).numberOfLines, this.listBottoms.get(i).numberOFselectedLine);
            this.panel.add(this.jbutt[i]);
            this.nextWindow[i] = new NextWindow(i);
            jbutt[i].addActionListener(this.nextWindow[i]);
            if (i==this.numbersoflines-1 && MainMenuPanel.bottonActionsInWindow!=0){
                JButton backButton = createButton("Назад");
                this.panel.add(backButton);
                NextWindow clikOnBack = new NextWindow(10);
                backButton.addActionListener(clikOnBack);
            }
        }
    }



    WidthAndHeight returnWidthOrHeight (final String s){
        Container container = new JFrame().getContentPane();
        JButton jButton = new JButton(s);
        container.add(jButton);
        Dimension dimension = jButton.getPreferredSize();
        return new WidthAndHeight((int)dimension.getWidth(),(int)dimension.getHeight());
    }



    JButton createButton(final String s,final  int numberOfLines,final  int numberOFselectedLine){
        JButton jButton = new JButton(s);
        WidthAndHeight widthAndHeihht = returnWidthOrHeight(s);
        jButton.setBounds((MainMenuFrame.DEFAULT_WIDTH-widthAndHeihht.getWidth())/2,
                ((MainMenuFrame.DEFAULT_HEIGHT*numberOFselectedLine)/(numberOfLines+1))-(widthAndHeihht.getHeight()/2),
                widthAndHeihht.getWidth(),
                widthAndHeihht.getHeight());
        return jButton;
    }




    JButton createButton(final String s){
        JButton jButton = new JButton(s);
        WidthAndHeight widthAndHeihht = returnWidthOrHeight(s);
        jButton.setBounds((MainMenuFrame.DEFAULT_WIDTH-widthAndHeihht.getWidth()*2),
                (MainMenuFrame.DEFAULT_HEIGHT-widthAndHeihht.getHeight()*3),
                widthAndHeihht.getWidth(),
                widthAndHeihht.getHeight());

        return jButton;
    }

    class NextWindow  implements ActionListener  {

        private ArrayList<ArrayList<String>> lists = new ArrayList<>();
        private int windowStyle;


        NextWindow(int i){
            this.windowStyle = i;
            Collections.addAll(lists,new ArrayList<String>(),new ArrayList<String>());
            Collections.addAll(lists.get(0), "Многопользовательская игра", "Настройки", "Выход");
            Collections.addAll(lists.get(1), "Пошаговая с выбором персонажей", "Онлайн");
        }


       @Override
        public void actionPerformed(ActionEvent e) {
           if (MainMenuPanel.bottonActionsInWindow==0) {
               MainMenuPanel.bottonActionsInWindow++;
               if(this.windowStyle==0) {
                   mainMenuFrame.dispose();
                   ArrayList<String> strings = new ArrayList<>(lists.get(this.windowStyle+1));
                   mainMenuFrame = new MainMenuFrame(strings);
                   mainMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                   mainMenuFrame.setVisible(true);
               }else if (this.windowStyle==1){
                   mainMenuFrame.dispose();
                   SettingsFrame settingsFrame = new SettingsFrame();
                   settingsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                   settingsFrame.setVisible(true);
               }else if (this.windowStyle==2){
                   mainMenuFrame.dispose();
               }

           } else if(MainMenuPanel.bottonActionsInWindow==1){
                              if(this.windowStyle==10){
                   MainMenuPanel.bottonActionsInWindow--;
                   mainMenuFrame.setVisible(false);
                   panel.setVisible(false);
                   mainMenuFrame.dispose();
                   mainMenuFrame = new MainMenuFrame(new ArrayList<>(lists.get(MainMenuPanel.bottonActionsInWindow)));
                   mainMenuFrame.setLocationRelativeTo(null);
                   mainMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                   mainMenuFrame.setVisible(true);
               }else if (this.windowStyle==0){
                                  MainMenuPanel.bottonActionsInWindow++;
                                  mainMenuFrame.dispose();
                                  TurnBasedGameFrame mainMenu = new TurnBasedGameFrame();
                                  mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                  mainMenu.setVisible(true);
                              } else if (this.windowStyle == 1) {

                              }
           }

       }
    }

    private class MyButtonMM {
        private final String nameButton;
        private final int numberOFselectedLine;
        private final int numberOfLines;

        MyButtonMM(final String nameButton, final int numberOfLines, final int numberOFselectedLine) {
            this.nameButton = nameButton;
            this.numberOFselectedLine = numberOFselectedLine;
            this.numberOfLines = numberOfLines;
        }

    }

    class WidthAndHeight {

        private final int width, height;

        private WidthAndHeight(final int width, final int height) {
            this.width = width;
            this.height = height;
        }

        int getWidth() {
            return width;
        }

        int getHeight() {
            return height;
        }
    }
}
