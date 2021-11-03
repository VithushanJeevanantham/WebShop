import javax.swing.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.Statement;

public class SqlStatements {

    //add a user
    public void addNewUser(String name, String prename, Date birthday, String country, String streetWithNumber, String email, String password, String canton){

        try
        {
            // create a mysql database connection
            String myDriver = "com.mysql.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost/webshop";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "D0minik2005");

            String value = "Example";

            String query = "INSERT INTO `webshop`.`useraccounts` (`Name`, `PreName`, `Birthday`,`Country`,`StreetWithNumber`,`Email`,`Password`,`Canton`) " +
                    "VALUES ("+value+");";

            // create the java statement
            Statement st = conn.createStatement();
            // execute the query, and get a java resultset
            st.executeUpdate(query);

            conn.close();
            JOptionPane.showMessageDialog(null,"Benutzer erfolgreich hinzugefügt.");
        }
        catch (Exception e)
        {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }

    }


}
