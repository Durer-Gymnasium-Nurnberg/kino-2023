import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Vector;
import java.util.function.*;
import java.util.GregorianCalendar;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Datenbankanbindung {
    private static Connection conn;

    static {
        try {
            // Deprecated
            //Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Class.forName("com.mysql.cj.jdbc.Driver").getConstructors()[0].newInstance();
            //new com.mysql.cj.jdbc.Driver();
            //Verbindung zur MySQL-Datenbank (MariaDB) in xampp auf dem Lehrerrechner im Raum 105:
            conn = DriverManager.getConnection("jdbc:mysql://172.28.40.54/kino?user=q11&password=dg");
            
            //Verbingung zur MySQL-Datenbank (MariaDB) in xampp auf eigenem Rechner:
            //conn = DriverManager.getConnection("jdbc:mysql://localhost/kino?user=root&password=");
            
            //Verbindung zu einer MySQL-Datenbank auf einem externen Server von World2Web:
            //conn = DriverManager.getConnection("jdbc:mysql://85.13.144.17/d03d56ab?user=d03d56ab&password=2BcyR5v32BjhzV");
            
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
    
    private static String formatToSqlList(Object... props) {
        StringBuilder sb = new StringBuilder("'");
        for (var a : props) {
            sb.append(a.toString());
            sb.append("', '");
        }
        return sb.substring(0, sb.length()-3);
    }

    /**
     * 
     * Fuegt einen Film in die Datenbank ein
     * 
     * @return Die Zeile in der Datenbank
     */
    public static int filmEintragen(String name, int jahr, int laenge, int fsk) throws SQLException {
        Statement st = conn.createStatement();
        return st.executeUpdate("INSERT INTO film (name, jahr, laenge, fsk)\nVALUES (" + formatToSqlList(name, jahr, laenge, fsk) + ")");
    }

    /**
     * 
     * Fuegt eine Reservierung in die Datenbank ein
     * 
     * @return Die Zeile in der Datenbank
     */
    public static int reservierungEintragen(int idVorstellung, int idBesucher, int idPlatz) throws SQLException {
        Statement st = conn.createStatement();
        return st.executeUpdate("INSERT INTO reservierung (Vorstellung_idVorstellung, Besucher_idBesucher, Platz_idPlatz)\nVALUES (" + formatToSqlList(idVorstellung, idBesucher, idPlatz) + ")");
    }
    
    /**
     * 
     * Fuegt eine Vorstellung in die Datenbank ein
     * 
     * @return Die Zeile in der Datenbank
     */
    public static int vorstellungEintragen(GregorianCalendar date, int idFilm, int idKinosaal) throws SQLException {
        Statement st = conn.createStatement();
        return st.executeUpdate("INSERT INTO vorstellung (datum, zeit, Film_idFilm, Kinosaal_idKinosaal)\nVALUES (" + formatToSqlList(createDateFromGreg(date), createTimeFromGreg(date)) + ")");
    }
    
    /**
     * 
     * Fuegt eine Besucher in die Datenbank ein
     * 
     * @return Die Zeile in der Datenbank
     */
    public static int besucherEinfuegen(String name, int telefonnr) throws SQLException {
        Statement st = conn.createStatement();
        return st.executeUpdate("INSERT INTO besucher (name, telefonnr)\nVALUES (" + formatToSqlList(name, telefonnr) + ")");
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
                    rs.getInt("fsk")
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
     * Holt sich die Vorstellungen aus der Datenbank
     * 
     * @return Eine Liste mit allen Vorstellungen
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
                    rs.getString("reihe").toCharArray()[0], 
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
                    rs.getInt("telefonnr")
                ));
    }

    private static GregorianCalendar createGregFromSQLDate(Date date, Time time) {
        return GregorianCalendar.from(
            date.toLocalDate() // Date
            .atTime(time.toLocalTime()) // Specify time
            .atZone(ZoneId.systemDefault()) // Interpret as ECT time
        );
    }
    
    private static Date createDateFromGreg(GregorianCalendar greg) {
        return Date.valueOf(greg.toZonedDateTime().toLocalDate());
    }
    
    private static Time createTimeFromGreg(GregorianCalendar greg) {
        return Time.valueOf(greg.toZonedDateTime().toLocalTime());
    }
}