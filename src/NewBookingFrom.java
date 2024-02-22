import java.util.Date;
import java.util.Calendar;
import javax.swing.SpinnerDateModel;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewBookingFrom extends javax.swing.JFrame{
    Toolkit tk = Toolkit.getDefaultToolkit();
    int xSize =((int) tk.getScreenSize().getWidth());
    int ySize =((int) tk.getScreenSize().getHeight());
    private JTextField nameTf;
    private JTextField surnameTf;
    private JTextField addressTf;
    private JLabel nameLb;
    private JLabel surnameLb;
    private JLabel addressLb;
    private JButton addConsultationBtn;
    private JLabel dateLb;
    private JLabel timeLb;
    private JTextField dateTf;
    private JSpinner timeTf;
    private JLabel commentsLb;
    private JTextArea commentsTf;
    private JLabel gpLb;
    private JPanel newConsultationPanel;
    private JButton backBtn;
    private JLabel titleLb;

    NewBookingFrom(){
        //models the JFrame
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setMinimumSize((new Dimension(1000,800)));
        this.setResizable(false);
        this.setVisible(true);
        this.setLocation((xSize/2)-(this.getWidth()/2),(ySize/2)-(this.getHeight()/2));
        newConsultationPanel.setForeground(new Color(255, 255, 255));
        newConsultationPanel.setBackground(new Color(47, 35, 48));
        this.add(newConsultationPanel);
        newConsultationPanel.setVisible(true);

        //models title label
        titleLb.setText("New Booking");
        titleLb.setForeground(new Color(0xe0e0e0));
        titleLb.setFont(new Font("Poppins",Font.BOLD,50));

        //models gp label
        gpLb.setText("GP");
        gpLb.setForeground(new Color(0xe0e0e0));
        gpLb.setFont(new Font("Poppins",Font.BOLD,150));

        //models name label
        nameLb.setText("Name");
        nameLb.setForeground(new Color(0xe0e0e0));
        nameLb.setFont(new Font("Poppins",Font.BOLD,20));

        //models name txt field
        nameTf.setPreferredSize(new Dimension(300,60));
        nameTf.setBackground(new Color(156, 138, 154));
        nameTf.setForeground(new Color(240, 233, 239));
        nameTf.setFont(new Font("Poppins",Font.PLAIN,20));
        nameTf.setBorder(null);
        nameTf.setBorder(new UiGraphics(10));
        nameTf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nameTf.setBackground(new Color(112, 96, 111));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nameTf.setBackground(new Color(156, 138, 154));
            }
        });

        //models surname label
        surnameLb.setText("Surname");
        surnameLb.setForeground(new Color(0xe0e0e0));
        surnameLb.setFont(new Font("Poppins",Font.BOLD,20));

        //models surname txt field
        surnameTf.setPreferredSize(new Dimension(300,60));
        surnameTf.setBackground(new Color(156, 138, 154));
        surnameTf.setForeground(new Color(240, 233, 239));
        surnameTf.setFont(new Font("Poppins",Font.PLAIN,20));
        surnameTf.setBorder(null);
        surnameTf.setBorder(new UiGraphics(10));
        surnameTf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                surnameTf.setBackground(new Color(112, 96, 111));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                surnameTf.setBackground(new Color(156, 138, 154));
            }
        });

        //models address label
        addressLb.setText("Address");
        addressLb.setForeground(new Color(0xe0e0e0));
        addressLb.setFont(new Font("Poppins",Font.BOLD,20));

        //models address txt field
        addressTf.setPreferredSize(new Dimension(300,60));
        addressTf.setBackground(new Color(156, 138, 154));
        addressTf.setForeground(new Color(240, 233, 239));
        addressTf.setFont(new Font("Poppins",Font.PLAIN,20));
        addressTf.setBorder(null);
        addressTf.setBorder(new UiGraphics(10));
        addressTf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addressTf.setBackground(new Color(112, 96, 111));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addressTf.setBackground(new Color(156, 138, 154));
            }
        });

        //models date label
        dateLb.setText("Date");
        dateLb.setForeground(new Color(0xe0e0e0));
        dateLb.setFont(new Font("Poppins",Font.BOLD,20));

        //models date txt field
        dateTf.setPreferredSize(new Dimension(300,60));
        dateTf.setBackground(new Color(156, 138, 154));
        dateTf.setForeground(new Color(240, 233, 239));
        dateTf.setFont(new Font("Poppins",Font.PLAIN,20));
        dateTf.setBorder(null);
        dateTf.setBorder(new UiGraphics(10));
        dateTf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dateTf.setBackground(new Color(112, 96, 111));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dateTf.setBackground(new Color(156, 138, 154));
            }
        });

        //models time label
        timeLb.setText("Time");
        timeLb.setForeground(new Color(0xe0e0e0));
        timeLb.setFont(new Font("Poppins",Font.BOLD,20));

        //models time txt field
        timeTf.setPreferredSize(new Dimension(300,60));
        timeTf.setBackground(new Color(156, 138, 154));
        timeTf.setForeground(new Color(240, 233, 239));
        timeTf.setFont(new Font("Poppins",Font.PLAIN,20));
        timeTf.setBorder(null);
        timeTf.setBorder(new UiGraphics(10));
        timeTf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                timeTf.setBackground(new Color(112, 96, 111));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                timeTf.setBackground(new Color(156, 138, 154));
            }
        });

        //models comments label
        commentsLb.setText("Comments");
        commentsLb.setForeground(new Color(0xe0e0e0));
        commentsLb.setFont(new Font("Poppins",Font.BOLD,20));

        //models date txt field
        commentsTf.setPreferredSize(new Dimension(300,60));
        commentsTf.setBackground(new Color(156, 138, 154));
        commentsTf.setForeground(new Color(240, 233, 239));
        commentsTf.setFont(new Font("Poppins",Font.PLAIN,20));
        commentsTf.setBorder(null);
        commentsTf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                commentsTf.setBackground(new Color(112, 96, 111));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                commentsTf.setBackground(new Color(156, 138, 154));
            }
        });

        //models back button
        backBtn.setText("Back");
        backBtn.setPreferredSize(new Dimension(300,25));
        backBtn.setFont(new Font("Poppins",Font.PLAIN,20));
        backBtn.setBackground(new Color(0x1e1e1e));
        backBtn.setForeground(new Color(0xe0e0e0));
        backBtn.setBorder(new LineBorder(new Color(0x323232)));
        backBtn.setFocusPainted(false);
        backBtn.setBorder(new UiGraphics(10));
        backBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backBtn.setBackground(new Color(0x1a1a1a));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                backBtn.setBackground(new Color(0x1e1e1e));
            }
        });
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainApplicationMenu().setLocation(NewBookingFrom.this.getLocation());
                NewBookingFrom.this.dispose();
            }
        });

        //models consultation button
        addConsultationBtn.setText("Add Consultation");
        addConsultationBtn.setPreferredSize(new Dimension(300,25));
        addConsultationBtn.setFont(new Font("Poppins",Font.PLAIN,20));
        addConsultationBtn.setBackground(new Color(0x1e1e1e));
        addConsultationBtn.setForeground(new Color(0xe0e0e0));
        addConsultationBtn.setBorder(new LineBorder(new Color(0x323232)));
        addConsultationBtn.setFocusPainted(false);
        addConsultationBtn.setBorder(new UiGraphics(10));
        addConsultationBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addConsultationBtn.setBackground(new Color(0x1a1a1a));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addConsultationBtn.setBackground(new Color(0x1e1e1e));
            }
        });
        createUIComponents();
    }

    //models the jSpinner so that its in a time format hour : minute : seconds
    //gets the current time upon opening the new consultation form
    private void createUIComponents() {
        Date date = new Date();
        SpinnerDateModel sm =
                new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
        timeTf = new javax.swing.JSpinner(sm);
        JSpinner.DateEditor de = new JSpinner.DateEditor(timeTf, "HH:mm:ss");
        timeTf.setEditor(de);

        //gets the text field of the editor
        JFormattedTextField textField = ((JSpinner.DefaultEditor) timeTf.getEditor()).getTextField();

        //sets the background color of the text field as jSpinners .setBackground doesn't change the color of the field
        textField.setBackground(new Color(156, 138, 154));
        textField.setForeground(new Color(240, 233, 239));
        textField.setFont(new Font("Poppins", Font.PLAIN, 20));
        textField.setBorder(null);
        textField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                textField.setBackground(new Color(112, 96, 111));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                textField.setBackground(new Color(156, 138, 154));
            }
        });
    }
}
