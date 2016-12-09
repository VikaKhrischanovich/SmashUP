package visualAppearance;


import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;


public class SUBottonGen extends JButton {

    private int genNumber;

    private static ArrayList<Integer> list = new ArrayList<>(8);



    public SUBottonGen() {
        this.selectNumber();

    }

    public SUBottonGen(Icon icon) {
        super(icon);
        this.selectNumber();
    }

    public SUBottonGen(String text) {
        super(text);
        long date = System.nanoTime();
        this.selectNumber();
        long date1 = System.nanoTime();
        long ms = date1 - date;
        System.out.println(ms);
    }

    public SUBottonGen(String text, Icon icon) {
        super(text, icon);
        this.selectNumber();
    }

    public SUBottonGen(Action a) {
        super(a);
        this.selectNumber();
    }

    public int getGenNumber() {
        return genNumber;
    }

    public void setGenNumber(int genNumber) {
        this.genNumber = genNumber;
    }

    private void selectNumber() {
        if (SUBottonGen.list.size() == 0) {
            int i = generateNumber();
            SUBottonGen.list.add(i);
            this.genNumber = i;
        }else {
            int i = generateNumber();
            int lenArr = new ArrayList<>(SUBottonGen.list).size();
            int countEq = 0;
            for (Integer l : new ArrayList<>(SUBottonGen.list)) {
                if (i != l) {
                    countEq++;
                }
            }
            if (lenArr == countEq) {
                SUBottonGen.list.add(i);
                this.genNumber = i;
            } else {
                selectNumber();
            }
        }

    }
    private int generateNumber() {
        int i = (int)(Math.random()*10);
        if (i >= 9 || i <=0) {
            i = generateNumber();
        }
        return i;
    }
}
