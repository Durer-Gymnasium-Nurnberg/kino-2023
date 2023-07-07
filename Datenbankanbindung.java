import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import java.util.function.*;

public class Datenbankanbindung {
    private static Connection conn;
    private static Datenbankanbindung instance;
    
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://172.28.40.54/kino?user=q11&password=dg");
            //conn = DriverManager.getConnection("jdbc:mysql://localhost/kino?user=root&password=");
            System.out.println(conn);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    @FunctionalInterface
    private static interface SQLFunction<P, R> {
        public R apply(P arg) throws SQLException;
    }
    
    public static <E> List<E> getAllDataInColumn(String column, SQLFunction<ResultSet, E> cons) {
        var list = new ArrayList<E>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM " + column);
            while (rs.next()) {
                list.add(cons.apply(rs));
            }
            rs.close();
            st.close();            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    /**
     * Holt sich die Filme aus der Datenbank
     * 
     * @param name Der Name
     */
    public static List<Film> getFilme() {
        return getAllDataInColumn("film", rs -> new Film(rs.getInt("idFilm"), rs.getString("name"), rs.getInt("jahr"), rs.getInt("laenge"), rs.getInt("FSK")));
    }

}
