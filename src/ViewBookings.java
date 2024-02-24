import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class ViewBookings extends GPWindow {
    private JPanel viewConsultationPanel;
    private JComboBox monthDd;
    private JTextField yearTf;
    private JButton backBtn;
    private JButton searchBtn;
    private JLabel titleLb;
    private JLabel yearLb;
    private JTable table;
    private JLabel monthLb;

    ViewBookings() {
        setupPanel();
        titleLb.setText("View Bookings");
        titleLb.setForeground(new Color(0xe0e0e0));
        titleLb.setFont(new Font("Poppins",Font.BOLD,50));

        monthLb.setText("Enter Month");
        monthLb.setForeground(new Color(0xe0e0e0));
        monthLb.setFont(new Font("Poppins",Font.BOLD,20));

        yearLb.setText("Enter Year");
        yearLb.setForeground(new Color(0xe0e0e0));
        yearLb.setFont(new Font("Poppins",Font.BOLD,20));

        monthDd.setPreferredSize(new Dimension(200,50));
        monthDd.setBackground(new Color(156, 138, 154));
        monthDd.setForeground(new Color(240, 233, 239));
        monthDd.setFont(new Font("Poppins",Font.PLAIN,20));
        monthDd.setBorder(null);
        monthDd.setBorder(new UiGraphics(10));
        monthDd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                monthDd.setBackground(new Color(112, 96, 111));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                monthDd.setBackground(new Color(156, 138, 154));
            }
        });

        yearTf.setPreferredSize(new Dimension(200,50));
        yearTf.setBackground(new Color(156, 138, 154));
        yearTf.setForeground(new Color(240, 233, 239));
        yearTf.setFont(new Font("Poppins",Font.PLAIN,20));
        yearTf.setBorder(null);
        yearTf.setBorder(new UiGraphics(10));
        yearTf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                yearTf.setBackground(new Color(112, 96, 111));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                yearTf.setBackground(new Color(156, 138, 154));
            }
        });

        table.setBackground(new Color(156, 138, 154));
        table.setForeground(new Color(240, 233, 239));
        table.setFont(new Font("Poppins",Font.PLAIN,20));
        table.setBorder(null);
        table.setBorder(new UiGraphics(10));


        backBtn.setText("Back");
        backBtn.setPreferredSize(new Dimension(50,25));
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
                new MainApplicationMenu().setLocation(ViewBookings.this.getLocation());
                ViewBookings.this.dispose();
            }
        });

        searchBtn.setText("Search");
        searchBtn.setPreferredSize(new Dimension(50,25));
        searchBtn.setFont(new Font("Poppins",Font.PLAIN,20));
        searchBtn.setBackground(new Color(0x1e1e1e));
        searchBtn.setForeground(new Color(0xe0e0e0));
        searchBtn.setBorder(new LineBorder(new Color(0x323232)));
        searchBtn.setFocusPainted(false);
        searchBtn.setBorder(new UiGraphics(10));
        searchBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                searchBtn.setBackground(new Color(0x1a1a1a));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                searchBtn.setBackground(new Color(0x1e1e1e));
            }
        });
        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedMonth = (String) monthDd.getSelectedItem();
                int selectedYear = Integer.parseInt(yearTf.getText());
                ResultSet resultSet = Repository.getBookingsByMonthAndYear(selectedMonth, selectedYear);
                updateTable(resultSet);
            }
        });
    }

    @Override
    public void setupPanel() {
        viewConsultationPanel.setForeground(new Color(255, 255, 255));
        viewConsultationPanel.setBackground(new Color(47, 35, 48));
        this.add(viewConsultationPanel);
        viewConsultationPanel.setVisible(true);
    }

    private void updateTable(ResultSet resultSet) {
        try {
            // Specify column names as an array of strings
            String[] columnNames = {"BookingID", "Day", "Month", "Year", "DoctorID", "PatientID"};

            // Create a DefaultTableModel with specific column names
            DefaultTableModel model = new DefaultTableModel(columnNames, 0);
            model.addRow(columnNames);

            // Populate the table model with data from the ResultSet
            while (resultSet.next()) {
                // Extract data from the ResultSet
                String bookingID = resultSet.getString("BookingID");
                String day = resultSet.getString("Day");
                String month = resultSet.getString("Month");
                String year = resultSet.getString("Year");
                String doctorID = resultSet.getString("DoctorID");
                String patientID = resultSet.getString("PatientID");

                // Add a row to the table model
                model.addRow(new String[]{bookingID, day, month, year, doctorID, patientID});
            }

            // Set the updated table model to the JTable
            table.setModel(model);

            // Update the UI to reflect the changes
            table.getTableHeader().repaint();

        } catch (Exception ex) {
            System.out.println("Error updating table: " + ex);
        }
    }
}
