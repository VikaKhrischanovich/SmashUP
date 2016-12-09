package visualAppearance;

import java.awt.*;


public class TurnBasedGameFrame extends MainMenuFrame {

    public static final int DEFAULT_WIDTH = 630;
    public static final int DEFAULT_HEIGHT = 300;


    public TurnBasedGameFrame(){
        toSetTheWindowCenter();
        TurnBasedGamePanel setPlayerNamePanel = new TurnBasedGamePanel(this);
        this.add(setPlayerNamePanel);
    }



    void toSetTheWindowCenter(){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        int screenWidth=dimension.width;
        int screenHeihth=dimension.height;
        this.setBounds((screenWidth- TurnBasedGameFrame.DEFAULT_WIDTH)/2,
                (screenHeihth- TurnBasedGameFrame.DEFAULT_HEIGHT)/2,
                TurnBasedGameFrame.DEFAULT_WIDTH,
                TurnBasedGameFrame.DEFAULT_HEIGHT);
        this.setTitle("  ЗАМЕС: Выбор Nickname-а");
        this.setResizable(false);
    }
}
