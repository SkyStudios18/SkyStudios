package com.SkyStudios.CustomMobHeads.DataBase;

import org.bukkit.entity.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PigDataBase extends DatabaseManager {

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
