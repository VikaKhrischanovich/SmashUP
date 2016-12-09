package visualAppearance;


import model.Player;

import javax.swing.*;
import java.awt.*;


public class ChooseFactionsFrame extends JFrame {

    static final int DEFAULT_WIDTH = 693;
    static final int DEFAULT_HEIGHT = 495;

    public ChooseFactionsFrame(Player[] players) {
        this.toSetTheWindowCenter();
        ChooseFactionsPanel chooseFactionsPanel = new ChooseFactionsPanel(this, players);
        this.add(chooseFactionsPanel);
    }

    void toSetTheWindowCenter()  {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        int screenWidth=dimension.width;
        int screenHeihth=dimension.height;
        this.setBounds((screenWidth- ChooseFactionsFrame.DEFAULT_WIDTH)/2,
                (screenHeihth- ChooseFactionsFrame.DEFAULT_HEIGHT)/2,
                ChooseFactionsFrame.DEFAULT_WIDTH,
                ChooseFactionsFrame.DEFAULT_HEIGHT);
        this.setTitle("  ЗАМЕС: Выбор фракций");
        this.setResizable(false);
    }
}
