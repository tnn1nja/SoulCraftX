package net.tnn1nja.soulCraftX;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class Main extends JavaPlugin {

    public final Logger log = Bukkit.getLogger();
    public final CommandExec commExec = new CommandExec();

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new Listeners(), this);
        getCommand("jump").setExecutor(new CommandExec());

        for(Player p: Bukkit.getOnlinePlayers()){
            p.kickPlayer("Server has reloaded");
        }

        log.info("[SoulCraftX] SoulCraftX has successfully started.");
    }

    @Override
    public void onDisable() {
        log.info("[SoulCraftX] SoulCraftX has successfully stopped.");
    }

}
