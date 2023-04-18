package fr.surowyn.saunacore.listeners;

import fr.surowyn.saunacore.database.DBCon;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.sql.SQLException;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) throws SQLException, ClassNotFoundException {
        DBCon.onUserConnect(e.getPlayer());
    }

}
