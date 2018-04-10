import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnector {
    static Connection conn = null;
    public static Connection getConnected(){

        try {
            Class.forName("org.h2.Driver");
            conn = DriverManager.getConnection
                    ("jdbc:h2:tcp://localhost/~/StoreDB", "Store","");//otvarq tunela
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            return conn;
        }
    }

}
