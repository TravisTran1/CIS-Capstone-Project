package Data;

import javax.print.DocFlavor;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class DatabaseUnitTest {
    private static final String SQL_QUERY = "DELETE FROM MS_Users WHERE Username = 'KingOfKnights'";
    //private static final String SQL_QUERY = "INSERT INTO MS_Users (Subscriber, Admin, Username, Password, Email, FullName, DateLogin)\n" + "VALUES (1, 0, 'DatabaseTest...2!', 'stuff', 'random.2test@gmail.com', 'Test McTest Jr', GETDATE());";

    public static void main(String[] args) {
        try {
            ArrayList<HashMap<String, String>> results = Database.runQuery(SQL_QUERY);
            //printResults(results);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void printResults(ArrayList<HashMap<String, String>> queryResults) {
        for (HashMap<String, String> map : queryResults) {
            System.out.println(map.get("Username") + " " + map.get("Phone"));
        }
    }
}
