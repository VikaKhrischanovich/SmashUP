package visualAppearance;


import javax.swing.*;
import java.awt.*;


public class SettingsFrame extends JFrame{

    public static final int DEFAULT_WIDTH = 375;
    public static final int DEFAULT_HEIGHT = 300;
    public static int numberOfPlayers = 2;


    public SettingsFrame(){
        toSetTheWindowCenter();
        SettingsPanel setPlayerNamePanel = new SettingsPanel(this);
        getContentPane().add(setPlayerNamePanel);

    }
    void toSetTheWindowCenter(){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        int screenWidth=dimension.width;
        int screenHeihth=dimension.height;
        this.setBounds((screenWidth- SettingsFrame.DEFAULT_WIDTH)/2,
                (screenHeihth- SettingsFrame.DEFAULT_HEIGHT)/2,
                SettingsFrame.DEFAULT_WIDTH,
                SettingsFrame.DEFAULT_HEIGHT);
        this.setTitle("  ЗАМЕС: Настройки");
        this.setResizable(false);
    }

}
