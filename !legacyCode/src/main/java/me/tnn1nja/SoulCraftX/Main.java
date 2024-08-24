package me.tnn1nja.SoulCraftX;

import me.tnn1nja.SoulCraftX.Listeners.MiscListeners;
import me.tnn1nja.SoulCraftX.Listeners.DieRelocateListener;
import me.tnn1nja.SoulCraftX.Listeners.JoinLeaveListener;
import me.tnn1nja.SoulCraftX.Commands.SoulCommands;
import me.tnn1nja.SoulCraftX.Commands.SoulTabComplete;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Team;
import xyz.haoshoku.nick.api.NickAPI;

import java.util.Objects;
public final class Main extends JavaPlugin {

    //Constants
    public static Main me;

    //On Load
    @Override
    public void onEnable() {
        //Initialise
        Bukkit.getLogger().info("[SoulCraftX] SoulCraftX Successfully Loaded");
        me = this;

        //Event HandlersgetServer().getPluginManager().registerEvents(new MiscListeners(), this);
        getServer().getPluginManager().registerEvents(new JoinLeaveListener(), this);
        getServer().getPluginManager().registerEvents(new DieRelocateListener(), this);


        //Custom Recipes
        CustomRecipes.createRecipe();

        //Save and Load
        getDataFolder().mkdirs();
        Tools.dataFile = getDataFolder() + "/pDataStore.dat";
        Tools.loadData();

        //Command Executors
        SoulCommands SoulC = new SoulCommands();
        Objects.requireNonNull(getCommand("help")).setExecutor(SoulC);
        Objects.requireNonNull(getCommand("seed")).setExecutor(SoulC);
        Objects.requireNonNull(getCommand("display")).setExecutor(SoulC);
        Objects.requireNonNull(getCommand("kick")).setExecutor(SoulC);
        Objects.requireNonNull(getCommand("members")).setExecutor(SoulC);
        Objects.requireNonNull(getCommand("nick")).setExecutor(SoulC);
        Objects.requireNonNull(getCommand("online")).setExecutor(SoulC);
        Objects.requireNonNull(getCommand("lastseen")).setExecutor(SoulC);
        Objects.requireNonNull(getCommand("ls")).setExecutor(SoulC);
        Objects.requireNonNull(getCommand("playtime")).setExecutor(SoulC);
        Objects.requireNonNull(getCommand("pt")).setExecutor(SoulC);
        Objects.requireNonNull(getCommand("playtimetop")).setExecutor(SoulC);
        Objects.requireNonNull(getCommand("ptt")).setExecutor(SoulC);

        //Command TabAutoComplete
        SoulTabComplete SoulT = new SoulTabComplete();
        Objects.requireNonNull(getCommand("display")).setTabCompleter(SoulT);
        Objects.requireNonNull(getCommand("kick")).setTabCompleter(SoulT);
        Objects.requireNonNull(getCommand("members")).setTabCompleter(SoulT);
        Objects.requireNonNull(getCommand("nick")).setTabCompleter(SoulT);
        Objects.requireNonNull(getCommand("lastseen")).setTabCompleter(SoulT);
        Objects.requireNonNull(getCommand("ls")).setTabCompleter(SoulT);
        Objects.requireNonNull(getCommand("playtime")).setTabCompleter(SoulT);
        Objects.requireNonNull(getCommand("pt")).setTabCompleter(SoulT);

        //Timed Tasks
        new BukkitRunnable(){
            @Override
            public void run() {
                //Tab Name Afking
                for (Player p : Bukkit.getOnlinePlayers()){
                    Team activeDis = p.getScoreboard().getTeam("activeDis");
                    Team afkDis = p.getScoreboard().getTeam("afkDis.afk");
                    for (OfflinePlayer px : activeDis.getPlayers()){
                        if (px.getName().equals(p.getName())){
                            if (!p.getPlayerListName().startsWith(ChatColor.WHITE.toString())){
                                if (!NickAPI.isNicked(p)) {
                                    p.setPlayerListName(ChatColor.WHITE + p.getName());
                                }
                            }
                        }
                    }
                    for (OfflinePlayer px : afkDis.getPlayers()){
                        if (px.getName().equals(p.getName())){
                            if (!p.getPlayerListName().startsWith(ChatColor.GRAY.toString())){
                                if (!NickAPI.isNicked(p)) {
                                    p.setPlayerListName(ChatColor.GRAY + p.getName());
                                }
                            }
                        }
                    }
                }
            }
        }.runTaskTimerAsynchronously(me, 20, 20);
    }


    //On Close
    @Override
    public void onDisable(){
        //Remove Players
        for (Player p : Bukkit.getOnlinePlayers()){
            p.kickPlayer("SoulCraft is Reloading...");
        }

        //Save Data
        Tools.saveData();
        Bukkit.getLogger().info("[SoulCraftX] SoulCraftX Saved it's Data");
    }
}