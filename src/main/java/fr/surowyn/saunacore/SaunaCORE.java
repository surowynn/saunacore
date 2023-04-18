package fr.surowyn.saunacore;

import fr.surowyn.saunacore.commands.MoneyCommand;
import fr.surowyn.saunacore.database.DBCon;
import fr.surowyn.saunacore.listeners.PlayerJoin;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;
import java.sql.*;

public class SaunaCORE extends JavaPlugin {

    private static SaunaCORE instance;

    private static final Logger log = Logger.getLogger("Minecraft");

    @Override
    public void onEnable() {
        try {
            DBCon.setupDB();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        instance = this;

        getServer().getPluginCommand("money").setExecutor(new MoneyCommand());
        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);

        System.out.println("[SAUNACORE] Successfully enabled SaunaCORE v1.0.0");
    }

    public static SaunaCORE getInstance() {
        return instance;
    }

    public void test(Player player) {
        player.sendMessage("OK");
    }

    @Override
    public void onDisable() {
    }

}
