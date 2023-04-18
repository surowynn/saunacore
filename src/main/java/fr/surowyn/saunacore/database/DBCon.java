package fr.surowyn.saunacore.database;
import org.bukkit.entity.Player;

import java.sql.*;

public class DBCon {

    public static void setupDB() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/saunamc","root","password");
        Statement stmt = con.createStatement();
        stmt.execute("CREATE TABLE IF NOT EXISTS users (id INT AUTO_INCREMENT PRIMARY KEY NOT NULL, uuid VARCHAR(255) NOT NULL, money FLOAT NOT NULL DEFAULT 0, tokens FLOAT NOT NULL DEFAULT 0, created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP);");
    }

    private static Statement getDBCon() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/saunamc","root","password");
        return con.createStatement();
    }

    public static void onUserConnect(Player p) throws SQLException, ClassNotFoundException {
        Statement stmt = getDBCon();
        stmt.execute("INSERT INTO users(uuid) VALUES('" + p.getUniqueId().toString() + "');");
        stmt.close();
    }

}
