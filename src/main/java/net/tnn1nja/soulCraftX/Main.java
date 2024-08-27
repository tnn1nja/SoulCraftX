package net.tnn1nja.soulCraftX;

import net.tnn1nja.soulCraftX.Commands.CommandExec;
import net.tnn1nja.soulCraftX.Commands.TabHandler;
import net.tnn1nja.soulCraftX.Listeners.Listeners;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class Main extends JavaPlugin {

    public final Logger log = Bukkit.getLogger();
    public final CommandExec commExec = new CommandExec();
    public final TabHandler tabHand = new TabHandler();

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new Listeners(), this);
        getCommand("jump").setExecutor(commExec);
        getCommand("jump").setTabCompleter(tabHand);

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
