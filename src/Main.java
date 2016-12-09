
import visualAppearance.ChooseFactionsFrame;
import visualAppearance.FinalPlayGroundFrame;
import visualAppearance.MainMenuFrame;
import visualAppearance.TurnBasedGameFrame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Random;

public class Main  {



    public static void main(String[] args) throws InterruptedException {
//        int count=0;
//        Player player = new Player("Rbh", 2);
//        ArrayList<PlayingCards> list = new ArrayList<>();
//        player.chooseRace(1,list);
//        player.chooseRace(2,list);
//        for (PlayingCards d :list) {
//            System.out.println(d);
//            count++;
//        }
//        System.out.println(count);
//    }


//        ArrayList<String> namesoflines = new ArrayList<String>();
//        Collections.addAll(namesoflines, "Многопользовательская игра", "Настройки", "Выход");
//        MainMenuFrame mainMenu = new MainMenuFrame(namesoflines);
//        mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        mainMenu.setVisible(true);


//        FinalPlayGroundFrame mainMenu = new FinalPlayGroundFrame();
//        mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        mainMenu.setVisible(true);
        long date = System.nanoTime();
        final Random random = new Random();
        int[] k = new int[8];
        for (int i = 0; i < 8; i++) {
            boolean b;
            do {
                b=false;
                int m = random.nextInt(8) + 1;
// System.out.println(m);
                for (int j = 0; j < i; j++) {
                    if (k[j] == m) {
                        b = true;
                        break;
                    }
// System.out.println(b);
                }
                if (!b) {
                    k[i] = m;
                }
            }while (b);
        }
        long date1 = System.nanoTime();
        long ms = date1 - date;
        System.out.println(ms);


    }}




