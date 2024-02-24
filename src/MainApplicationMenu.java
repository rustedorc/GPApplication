import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainApplicationMenu extends GPWindow{
    private JPanel mainPanel;
    private JButton patientRecordsBtn;
    private JButton viewBookingsBtn;
    private JButton newBookingBtn;
    private JButton logOutBtn;
    private JLabel welcomeLb;

    MainApplicationMenu(){
        setupPanel();

        //models the welcome label
        welcomeLb.setText("Welcome");
        welcomeLb.setForeground(new Color(0xe0e0e0));
        welcomeLb.setFont(new Font("Poppins",Font.BOLD,50));

        //models new consultation button
        newBookingBtn.setPreferredSize(new Dimension(300,250));
        newBookingBtn.setFont(new Font("Poppins",Font.PLAIN,20));
        newBookingBtn.setBackground(new Color(0x1e1e1e));
        newBookingBtn.setForeground(new Color(0xe0e0e0));
        newBookingBtn.setBorder(new LineBorder(new Color(0x323232)));
        newBookingBtn.setFocusPainted(false);
        newBookingBtn.setBorder(new UiGraphics(10));
        newBookingBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                newBookingBtn.setBackground(new Color(0x1a1a1a));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                newBookingBtn.setBackground(new Color(0x1e1e1e));
            }
        });
        newBookingBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NewBookingFrom().setLocation(MainApplicationMenu.this.getLocation());
                MainApplicationMenu.this.dispose();
            }
        });

        viewBookingsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewBookings().setLocation(MainApplicationMenu.this.getLocation());
                MainApplicationMenu.this.dispose();
            }
        });

        //models view consultation button
        viewBookingsBtn.setPreferredSize(new Dimension(300,250));
        viewBookingsBtn.setFont(new Font("Poppins",Font.PLAIN,20));
        viewBookingsBtn.setBackground(new Color(0x1e1e1e));
        viewBookingsBtn.setForeground(new Color(0xe0e0e0));
        viewBookingsBtn.setBorder(new LineBorder(new Color(0x323232)));
        viewBookingsBtn.setFocusPainted(false);
        viewBookingsBtn.setBorder(new UiGraphics(10));
        viewBookingsBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                viewBookingsBtn.setBackground(new Color(0x1a1a1a));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                viewBookingsBtn.setBackground(new Color(0x1e1e1e));
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

    @Override
    public void setupPanel() {
        mainPanel.setForeground(new Color(255, 255, 255));
        mainPanel.setBackground(new Color(47, 35, 48));
        this.add(mainPanel);
        mainPanel.setVisible(true);

    }

    //this method updates welcome message with the users name
    public void updateWelcomeMsg(String name){
        welcomeLb.setText("Welcome " + name);
    }

}
