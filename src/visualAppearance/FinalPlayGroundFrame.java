package visualAppearance;


import javax.swing.*;
import java.awt.*;

public class FinalPlayGroundFrame extends JFrame {



    public FinalPlayGroundFrame() {
        setWindowForm();
        this.setExtendedState(MAXIMIZED_BOTH);

    }

    private void setWindowForm(){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        this.setBounds(dimension.width/4,dimension.height/4,dimension.width/2,dimension.height/2);
        this.setTitle("  Уже ЗАМЕШИВАЕМ!!!!");
    }

}
