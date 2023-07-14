import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import java.util.function.*;
import java.util.GregorianCalendar;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Datenbankanbindung {
    private static Connection conn;
    
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
    
    public static <E> List<E> getAllDataInColumn(String column, SQLFunction<ResultSet, E> cons) throws SQLException {
        var list = new ArrayList<E>();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM " + column);
        while (rs.next()) {
            list.add(cons.apply(rs));
        }
        rs.close();
        st.close();            
        return list;
    }
    
    /**
     * Holt sich die Filme aus der Datenbank
     * 
     * @return Eine Liste mit allen Filmen
     */
    public static List<Film> getFilme() throws SQLException {
        return getAllDataInColumn("film", 
            rs -> new Film(rs.getInt("idFilm"), 
                rs.getString("name"), 
                rs.getInt("jahr"), 
                rs.getInt("laenge"), 
                rs.getInt("FSK")
                ));
    }
    
    /**
     * Holt sich die Kinosaele aus der Datenbank
     * 
     * @return Eine Liste mit allen Kinosaelen
     */
    public static List<Kinosaal> getKinosaal() throws SQLException {
        return getAllDataInColumn("kinosaal", rs -> new Kinosaal(rs.getInt("idKinosaal")));
    }
    
    /**
     * Holt sich die Kinosaele aus der Datenbank
     * 
     * @return Eine Liste mit allen Kinosaelen
     */
    public static List<Vorstellung> getVorstellung() throws SQLException {
        return getAllDataInColumn("vorstellung",
            rs -> new Vorstellung(
                rs.getInt("idVorstellung"), 
                createGregFromSQLDate(rs.getDate("datum"), rs.getTime("zeit")),
                rs.getInt("idFilm"),
                rs.getInt("idKinosaal")
                ));
    }
    
    /**
     * Holt sich die Plaetze aus der Datenbank
     * 
     * @return Eine Liste mit allen Plaetzen
     */
    public static List<Platz> getPlatz() throws SQLException {
        return getAllDataInColumn("platz", 
            rs -> new Platz(
                rs.getInt("idPlatz"), 
                (char) rs.getInt("reihe"), 
                rs.getInt("platz"), 
                rs.getInt("idKinosaal")
                ));
    }
    
    /**
     * Holt sich die Reservierungen aus der Datenbank
     * 
     * @return Eine Liste mit allen Reservierungen
     */
    public static List<Reservierung> getReservierung() throws SQLException {
        return getAllDataInColumn("reservierung", 
            rs -> new Reservierung(
                rs.getInt("idReservierung"), 
                rs.getInt("idVorstellung"), 
                rs.getInt("idBesucher"), 
                rs.getInt("idPlatz")
                ));
    }
    
    /**
     * Holt sich die Besuchern aus der Datenbank
     * 
     * @return Eine Liste mit allen Besuchern
     */
    public static List<Besucher> getBesucher() throws SQLException {
        return getAllDataInColumn("besucher", 
            rs -> new Besucher(
                rs.getInt("idBesucher"), 
                rs.getString("name"), 
                rs.getInt("telefon_nummer")
                ));
    }
    
    private static GregorianCalendar createGregFromSQLDate(Date date, Time time) {
        return GregorianCalendar.from(
            date.toLocalDate() // Date
            .atTime(time.toLocalTime()) // Specify time
            .atZone(ZoneId.of("ECT")) // Interpret as ECT time
            );
    }

}