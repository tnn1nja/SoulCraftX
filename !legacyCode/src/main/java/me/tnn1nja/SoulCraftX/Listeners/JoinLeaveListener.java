package me.tnn1nja.SoulCraftX.Listeners;
import me.tnn1nja.SoulCraftX.Tools;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.Date;

public class JoinLeaveListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        Tools.NameColor(player);
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
                "team join activeDis " + player.getName());

        if (player.hasPlayedBefore()){
            e.setJoinMessage(ChatColor.LIGHT_PURPLE + player.getName() + " just materialised");
            Tools.SpawnEffect(player);

            Tools.pDataStore.get(player.getName().toLowerCase()).addJoin();

        }else{
            e.setJoinMessage(ChatColor.LIGHT_PURPLE + player.getName() + "'s soul has been made manifest");
            Tools.SpawnEffect(player);

            Tools.pDataStore.put(player.getName().toLowerCase(),
                    new Tools.DataStore(Tools.dateFormat.format(new Date()), 1));
        }

        Tools.saveData();

    }




    @EventHandler
    public void onLeave(PlayerQuitEvent e){
        Player player = e.getPlayer();
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
                "team join offlineDis " + player.getName());

        e.setQuitMessage(ChatColor.LIGHT_PURPLE + player.getName() + " has dematerialised");
        Tools.SpawnEffect(player);

        Tools.pDataStore.get(player.getName().toLowerCase()).updateDate(Tools.dateFormat.format(new Date()));
        Tools.saveData();
    }
}


