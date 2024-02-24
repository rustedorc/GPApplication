import java.awt.*;

public class GPWindow extends javax.swing.JFrame{
    Toolkit tk = Toolkit.getDefaultToolkit();
    int xSize =((int) tk.getScreenSize().getWidth());
    int ySize =((int) tk.getScreenSize().getHeight());

    GPWindow() {
        //models the JFrame
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setMinimumSize((new Dimension(1000,800)));
        this.setResizable(false);
        this.setVisible(true);
        this.setLocation((xSize/2)-(this.getWidth()/2),(ySize/2)-(this.getHeight()/2));
    }
}
