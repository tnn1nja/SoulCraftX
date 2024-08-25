package net.tnn1nja.soulCraftX;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class Main extends JavaPlugin {

    public final Logger log = Bukkit.getLogger();

    @Override
    public void onEnable() {
        log.info("[SoulCraftX] SoulCraftX has successfully started.");
        getServer().getPluginManager().registerEvents(new Listeners(), this);
    }

    @Override
    public void onDisable() {
        for(Player p: Bukkit.getOnlinePlayers()){
            p.kickPlayer("Server has reloaded");
        }
        log.info("[SoulCraftX] SoulCraftX has successfully stopped.");
    }

}
