import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Repository {
    private static final String DatabaseLocation = System.getProperty("user.dir") + "\\Database.accdb";

    //establishes connection with the access database using a library called ucanacess
    public static Connection getConnection() {
        try {
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://" + DatabaseLocation, "", "");
            return con;

        } catch (Exception e) {
            System.out.println("Error in the repository class: " + e);
        }return null;
    }

    public static Boolean login(String Username, String Password){
        ResultSet rs;
        try {
            //uses the Connection method to connect to the database in order to run the SQL
            Connection con = getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "SELECT * FROM LoginTbl WHERE [username] = '" + Username + "' AND [password] = '" + Password + "'";

            //executes query and if the passed data from sign in page matchs any rows in the database it will log them in.
            rs = stmt.executeQuery(sql);
            if (rs.next()){
                System.out.println("Validlogin");

                return true;
            }

            //closes the connection once query is done
            con.close();
            return false;

        }catch (Exception e) {
            System.out.println("Error in the repository: " + e);
        }

        return null;
    }
    private void populateTable(JTable jTable1) {
        ResultSet rs;
        try {
            // Establish connection to the database using the Repository class
            Connection con = Repository.getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "SELECT * FROM BookingTbl";

            // Execute query
            rs = stmt.executeQuery(sql);

            // Create a DefaultTableModel with column names
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(new String[]{"BookingID", "Month", "Year", "DoctorID", "PatientID"});

            // Loop through the result set and add rows to the table model
            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getString("bookingID"),
                        rs.getString("month"),
                        rs.getString("year"),
                        rs.getString("doctorID"),
                        rs.getString("patientID")
                });
            }

            // Set the table model to table1
            table1.setModel(model);

            // Close resources
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
