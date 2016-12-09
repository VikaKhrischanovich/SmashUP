package visualAppearance;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainMenuFrame extends JFrame {

    static final int DEFAULT_WIDTH = 400;
    static final int DEFAULT_HEIGHT = 500;


    public MainMenuFrame( final ArrayList<String> namesoflines)  {
        this.toSetTheWindowCenter();
        MainMenuPanel mainMenuPanel = new MainMenuPanel(namesoflines,this);
        add(mainMenuPanel);
        getContentPane().add(mainMenuPanel.panel);
        }
    public MainMenuFrame(){

    }

    void toSetTheWindowCenter()  {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        int screenWidth=dimension.width;
        int screenHeihth=dimension.height;
        this.setBounds((screenWidth- MainMenuFrame.DEFAULT_WIDTH)/2,
                        (screenHeihth- MainMenuFrame.DEFAULT_HEIGHT)/2,
                        MainMenuFrame.DEFAULT_WIDTH,
                        MainMenuFrame.DEFAULT_HEIGHT);
        this.setTitle("  ЗАМЕС");
        this.setResizable(false);
    }
}
