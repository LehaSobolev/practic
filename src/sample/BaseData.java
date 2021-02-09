package sample;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class BaseData {
    static Connection connection;
    static Statement stmt = null;
    public static BaseData baseData;

    public static BaseData getBaseData() {
        if (baseData == null) {
            baseData = new BaseData();
        }
        return baseData;
    }

    private BaseData() {
        connect("jdbc:sqlserver://%1$s;databaseName=%2$s;user=%3$s;password=%4$s;", "DESKTOP-P2MROR9\\SQLEXPRESS",
                "state_duma",
                "user",
                "1111"
        );

    }


    public void connect(String connectionUrl, String instanceName, String databaseName, String userName, String pass) {
        try {
            String connectionString = String.format(connectionUrl, instanceName, databaseName, userName, pass);
            connection = DriverManager.getConnection(connectionString);
            stmt = connection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(BaseData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    ArrayList<Deputy> selectDeputies() throws SQLException {
            ArrayList<Deputy> deputies = new ArrayList<>();
            ResultSet rs;
                rs = stmt.executeQuery("SELECT * FROM Deputies" );
            while (rs.next()) {
                deputies.add(new Deputy(
                        rs.getInt(1),rs.getString(2),
                        rs.getString(3),rs.getString(4),
                        rs.getString(5),rs.getString(6)));
            }
            return deputies;
        }


    public ArrayList<Commission> selectCommissions() throws SQLException {
            ArrayList<Commission> commissions = new ArrayList<>();
            ResultSet rs;
            rs = stmt.executeQuery("SELECT * FROM Commissions" );
            while (rs.next()) {
                commissions.add(new Commission(
                        rs.getInt(1),rs.getString(2),
                        rs.getString(3),rs.getString(4),
                        rs.getString(5)));
            }
            return commissions;
        }


    public ArrayList<Meetings> selectMeetings() throws SQLException {
        ArrayList<Meetings> meetings = new ArrayList<>();
        ResultSet rs;
        rs = stmt.executeQuery("SELECT * FROM Meetings" );
        while (rs.next()) {
            meetings.add(new Meetings(
                    rs.getInt(1),rs.getInt(2),
                    rs.getString(3),rs.getString(4),
                    rs.getString(5),rs.getString(6)));
        }
        return meetings;
    }

    public void insertDeputy(Deputy deputy) throws SQLException {
        stmt.execute("INSERT INTO Deputies VALUES('"+deputy.FIO+"','"+deputy.Addres+"','"+deputy.Phone_H+"','"+deputy.Phone_O+"','"+deputy.Sex+"')");
    }

    public void delete(String name) throws SQLException {
stmt.execute("exec sp_deleteDeputyForName '"+name.trim()+"'");
    }


}