package com.SkyStudios.CustomMobHeads;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import java.io.File;
import java.io.IOException;
import java.sql.*;

public class DatabaseManager {

    Connection connection = null;

    public DatabaseManager() {
        try {
            getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS HeadData (" +
                    "`player` TEXT NOT NULL," +
                    "`counter` TEXT NOT NULL," +
                    "PRIMARY KEY (`player`))").execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Connection getConnection() {
        try {
            File f = new File(CustomMobHeadsMain.getPlugin().getDataFolder(), "CustomMobHeadsCounter.db");
            if(!(f.exists())) {
                try {
                    CustomMobHeadsMain.getPlugin().getDataFolder().mkdir();
                    f.createNewFile();
                    Bukkit.getLogger().info("Created DataBase file for Head Counter");
                }
                catch(IOException e1) {
                    e1.printStackTrace();
                }
            }

            try{
                Class.forName("org.sqlite.JDBC");
                if (connection == null || connection.isClosed()) {
                    connection = DriverManager.getConnection("jdbc:sqlite:" + f);
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public int getCounter(Player player) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = getConnection().prepareStatement("SELECT * FROM HeadData WHERE player = ?");
            ps.setString(1, player.getUniqueId().toString());
            rs = ps.executeQuery();

            while (rs.next()) {
                if (rs.getString("player").equals(player.getUniqueId().toString())) {
                    return Integer.parseInt(rs.getString("counter"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }

                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return 0;
    }

    public void addPlayer(Player player) {
        addPlayer(player, 1);
    }

    public void addPlayer(Player player, int increment) {
        PreparedStatement ps = null;
        PreparedStatement ps1 = null;
        ResultSet rs = null;

        try {
            ps = getConnection().prepareStatement("SELECT * FROM HeadData WHERE player = ?");
            ps.setString(1, player.getUniqueId().toString());
            rs = ps.executeQuery();
            if (rs.next()) {
                ps1 = getConnection().prepareStatement("UPDATE HeadData SET counter = ? WHERE player = ?");
                ps1.setString(1, Integer.toString(getCounter(player) + increment));
                ps1.setString(2, player.getUniqueId().toString());
                ps1.executeUpdate();
            }
            else{
                ps1 = getConnection().prepareStatement("INSERT INTO HeadData (player, counter) VALUES (?,?)");
                ps1.setString(1, player.getUniqueId().toString());
                ps1.setString(2, Integer.toString(increment));
                ps1.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }

                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}