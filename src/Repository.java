import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Repository {
    private static final Path DatabaseLocation = Paths.get(System.getProperty("user.dir") ,"Database.accdb");

    //establishes connection with the access database using a library called ucanacess
    public static Connection getConnection() {
        try {
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://" + DatabaseLocation);
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
    public static ResultSet getBookingsByMonthAndYear(String month, Integer year) {
        ResultSet rs = null;
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM BookingTbl WHERE Month = '" + month + "' AND Year = '" + year + "'";
            rs = stmt.executeQuery(sql);
        } catch (Exception e) {
            System.out.println("Error in retrieving bookings: " + e);
        }
        return rs;
    }
}
