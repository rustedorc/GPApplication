import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class SignIn extends GPWindow{
    private JPanel SignInPanel;
    private JTextField userTf;
    private JPasswordField passwordTf;
    private JButton logInButton;
    private JLabel titleLb;
    private JLabel userLb;
    private JLabel passwordLb;
    private JLabel loginResponseLb;

    SignIn(){
        SignInPanel.setForeground(new Color(255, 255, 255));
        SignInPanel.setBackground(new Color(47, 35, 48));
        this.add(SignInPanel);
        SignInPanel.setVisible(true);


        //models title label
        titleLb.setText("GP Application");
        titleLb.setForeground(new Color(0xe0e0e0));
        titleLb.setFont(new Font("Poppins",Font.BOLD,50));

        //models user label
        userLb.setText("User");
        userLb.setForeground(new Color(0xe0e0e0));
        userLb.setFont(new Font("Poppins",Font.BOLD,20));

        //models loginResponse label
        loginResponseLb.setText("Login Details Incorrect!");
        loginResponseLb.setForeground(new Color(0xe0e0e0));
        loginResponseLb.setFont(new Font("Poppins",Font.BOLD,15));
        loginResponseLb.setVisible(false);

        //models password label
        passwordLb.setText("Password");
        passwordLb.setForeground(new Color(0xe0e0e0));
        passwordLb.setFont(new Font("Poppins",Font.BOLD,20));

        //models the user text field
        userTf.setPreferredSize(new Dimension(300,60));
        userTf.setBackground(new Color(156, 138, 154));
        userTf.setForeground(new Color(240, 233, 239));
        userTf.setFont(new Font("Poppins",Font.PLAIN,20));
        userTf.setBorder(null);
        userTf.setBorder(new UiGraphics(10));
        userTf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                userTf.setBackground(new Color(112, 96, 111));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                userTf.setBackground(new Color(156, 138, 154));
            }
        });

        //models the password text field
        passwordTf.setPreferredSize(new Dimension(300,60));
        passwordTf.setBorder(new LineBorder(new Color(0x1e1e1e)));
        passwordTf.setBackground(new Color(156, 138, 154));
        passwordTf.setForeground(new Color(240, 233, 239));
        passwordTf.setFont(new Font("Poppins",Font.PLAIN,20));
        passwordTf.setBorder(new UiGraphics(10));
        passwordTf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                passwordTf.setBackground(new Color(112, 96, 111));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                passwordTf.setBackground(new Color(156, 138, 154));
            }
        });

        //models the login button

        logInButton.setText("Log In");
        logInButton.setPreferredSize(new Dimension(300,25));
        logInButton.setFont(new Font("Poppins",Font.PLAIN,20));
        logInButton.setBackground(new Color(0x1e1e1e));
        logInButton.setForeground(new Color(0xe0e0e0));
        logInButton.setBorder(new LineBorder(new Color(0x323232)));
        logInButton.setFocusPainted(false);
        logInButton.setBorder(new UiGraphics(10));
        logInButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logInButton.setBackground(new Color(0x1a1a1a));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logInButton.setBackground(new Color(0x1e1e1e));
            }
        });
        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //calls the login method
                    Login();
                } catch (NoSuchAlgorithmException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

    }
    public boolean loginLogic(String username, String password) throws NoSuchAlgorithmException {
        //message digest library used to hash password using SHA-256
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");

        //gets the string value of the password text field and puts it through the hash algorithm
        messageDigest.update(password.getBytes());
        String hashedPassword = new String(messageDigest.digest());

        return Repository.login(username, hashedPassword);
    }
    public void Login() throws NoSuchAlgorithmException {

        //calls login method in the Repository and passes the values in the user text field and the hashed password
        //then stores is as a boolean result
        Boolean result = loginLogic(userTf.getText(), String.valueOf(passwordTf.getPassword()));

        //if result comes back as true, it then runs the Main application and disposes of the Sign in JFrame
        if (result == true){
            MainApplicationMenu mainMenu = new MainApplicationMenu();
            //this line makes sure that the new JFrame opens in the same location as the old
            mainMenu.setLocation(SignIn.this.getLocation());
            //this line adds the name of the user to the welcome message
            mainMenu.updateWelcomeMsg(userTf.getText());
            SignIn.this.dispose();
        }else{
            //if false, displays a message will be displayed in App
            loginResponseLb.setVisible(true);
        }
    }

}
