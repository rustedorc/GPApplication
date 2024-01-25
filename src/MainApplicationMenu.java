import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainApplicationMenu extends javax.swing.JFrame{

    Toolkit tk = Toolkit.getDefaultToolkit();
    int xSize =((int) tk.getScreenSize().getWidth());
    int ySize =((int) tk.getScreenSize().getHeight());
    private JPanel mainPanel;
    private JButton patientRecordsBtn;
    private JButton viewConsultationsBtn;
    private JButton newConsultationBtn;
    private JButton logOutBtn;
    private JLabel welcomeLb;

    MainApplicationMenu(){
        //models the JFrame
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setMinimumSize((new Dimension(1000,800)));
        this.setResizable(false);
        this.setVisible(true);
        this.setLocation((xSize/2)-(this.getWidth()/2),(ySize/2)-(this.getHeight()/2));
        mainPanel.setForeground(new Color(255, 255, 255));
        mainPanel.setBackground(new Color(47, 35, 48));
        this.add(mainPanel);
        mainPanel.setVisible(true);

        //models the welcome label
        welcomeLb.setText("Welcome");
        welcomeLb.setForeground(new Color(0xe0e0e0));
        welcomeLb.setFont(new Font("Poppins",Font.BOLD,50));

        //models new consultation button
        newConsultationBtn.setPreferredSize(new Dimension(300,250));
        newConsultationBtn.setFont(new Font("Poppins",Font.PLAIN,20));
        newConsultationBtn.setBackground(new Color(0x1e1e1e));
        newConsultationBtn.setForeground(new Color(0xe0e0e0));
        newConsultationBtn.setBorder(new LineBorder(new Color(0x323232)));
        newConsultationBtn.setFocusPainted(false);
        newConsultationBtn.setBorder(new UiGraphics(10));
        newConsultationBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                newConsultationBtn.setBackground(new Color(0x1a1a1a));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                newConsultationBtn.setBackground(new Color(0x1e1e1e));
            }
        });

        //models view consultation button
        viewConsultationsBtn.setPreferredSize(new Dimension(300,250));
        viewConsultationsBtn.setFont(new Font("Poppins",Font.PLAIN,20));
        viewConsultationsBtn.setBackground(new Color(0x1e1e1e));
        viewConsultationsBtn.setForeground(new Color(0xe0e0e0));
        viewConsultationsBtn.setBorder(new LineBorder(new Color(0x323232)));
        viewConsultationsBtn.setFocusPainted(false);
        viewConsultationsBtn.setBorder(new UiGraphics(10));
        viewConsultationsBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                viewConsultationsBtn.setBackground(new Color(0x1a1a1a));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                viewConsultationsBtn.setBackground(new Color(0x1e1e1e));
            }
        });

        //models patient records button
        patientRecordsBtn.setPreferredSize(new Dimension(300,250));
        patientRecordsBtn.setFont(new Font("Poppins",Font.PLAIN,20));
        patientRecordsBtn.setBackground(new Color(0x1e1e1e));
        patientRecordsBtn.setForeground(new Color(0xe0e0e0));
        patientRecordsBtn.setBorder(new LineBorder(new Color(0x323232)));
        patientRecordsBtn.setFocusPainted(false);
        patientRecordsBtn.setBorder(new UiGraphics(10));
        patientRecordsBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                patientRecordsBtn.setBackground(new Color(0x1a1a1a));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                patientRecordsBtn.setBackground(new Color(0x1e1e1e));
            }
        });

        //models logout button
        logOutBtn.setPreferredSize(new Dimension(300,250));
        logOutBtn.setFont(new Font("Poppins",Font.PLAIN,20));
        logOutBtn.setBackground(new Color(0x1e1e1e));
        logOutBtn.setForeground(new Color(0xe0e0e0));
        logOutBtn.setBorder(new LineBorder(new Color(0x323232)));
        logOutBtn.setFocusPainted(false);
        logOutBtn.setBorder(new UiGraphics(10));
        logOutBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logOutBtn.setBackground(new Color(0x1a1a1a));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logOutBtn.setBackground(new Color(0x1e1e1e));
            }
        });
        logOutBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainApplicationMenu.this.dispose();
            }
        });
    }

    //this method updates welcome message with the users name
    public void updateWelcomeMsg(String name){
        welcomeLb.setText("Welcome " + name);
    }

}
