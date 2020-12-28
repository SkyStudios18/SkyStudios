package com.SkyStudios.CustomMobHeads.DataBase;

import com.SkyStudios.CustomMobHeads.CustomMobHeadsMain;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import java.io.File;
import java.io.IOException;
import java.sql.*;

public class DatabaseManager {

    Connection connection = null;
    public PigDataBase pigManager;
    public CowDataBase cowManager;
    public SheepDataBase sheepManager;
    public ChickenDataBase chickenManager;


    public DatabaseManager(boolean initialize) {

        if(initialize) {

            try {
                getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS HeadData (" +
                        "`player` TEXT NOT NULL," +
                        "`pigcounter` TEXT NOT NULL," +
                        "`cowcounter` TEXT NOT NULL," +
                        "`sheepcounter` TEXT NOT NULL," +
                        "`chickencounter` TEXT NOT NULL," +
                        "PRIMARY KEY (`player`))").execute();

            } catch (Exception e) {
                e.printStackTrace();
            }

            pigManager = new PigDataBase();
            cowManager = new CowDataBase();
            sheepManager = new SheepDataBase();
            chickenManager = new ChickenDataBase();
        }

    }

    protected Connection getConnection() {
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
}