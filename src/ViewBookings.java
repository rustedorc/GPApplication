import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;


public class ViewBookings extends javax.swing.JFrame {

    Toolkit tk = Toolkit.getDefaultToolkit();
    int xSize = ((int) tk.getScreenSize().getWidth());
    int ySize = ((int) tk.getScreenSize().getHeight());
    private JPanel viewConsultationPanel;
    private JComboBox monthDd;
    private JTextField yearTf;
    private JButton backBtn;
    private JButton searchBtn;
    private JLabel titleLb;
    private JLabel yearLb;
    private JTable table1;

    ViewBookings() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setMinimumSize((new Dimension(1000, 800)));
        this.setResizable(false);
        this.setVisible(true);
        this.setLocation((xSize / 2) - (this.getWidth() / 2), (ySize / 2) - (this.getHeight() / 2));
        viewConsultationPanel.setForeground(new Color(255, 255, 255));
        viewConsultationPanel.setBackground(new Color(47, 35, 48));
        this.add(viewConsultationPanel);
        viewConsultationPanel.setVisible(true);

        // Call populateTable method to populate the table with data from the database
    }

    // Method to populate the table with data from the database

}
