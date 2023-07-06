import java.sql.*;

public class Datenbankanbindung {
    private Connection conn;

    public Datenbankanbindung() {
        /*
         * https://dev.mysql.com/doc/connector-j/8.0/en/connector-j-usagenotes-connect-drivermanager.html
         * 
         */
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://172.28.40.54/kino?user=q11&password=dg");
            //conn = DriverManager.getConnection("jdbc:mysql://localhost/kino?user=root&password=");
            
            System.out.println(conn);
            
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public void filmeAusgeben() {
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM film");
            while ( rs.next() ) {
                System.out.println(rs.getString("name") + ", " + rs.getInt("laenge"));
            }
            rs.close();
            st.close();            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }

}
