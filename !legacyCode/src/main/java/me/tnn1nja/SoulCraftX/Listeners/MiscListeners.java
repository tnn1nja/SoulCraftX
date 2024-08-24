package me.tnn1nja.SoulCraftX.Listeners;

import me.tnn1nja.SoulCraftX.Tools;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityBreedEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.HashMap;

public class MiscListeners implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e){
        if (e.getMessage().contains("@")) {
            HashMap<String, String> formatted = Tools.playerChatAts(e.getMessage());

            for (Player pt : Bukkit.getOnlinePlayers()) {
                if (formatted.get(pt.getName().toLowerCase()) == null) {
                    pt.sendMessage( "<" + e.getPlayer().getDisplayName() + ChatColor.WHITE + "> " +
                            Tools.colorReplace(formatted.get("None")));
                } else {
                    pt.sendMessage( "<" + e.getPlayer().getDisplayName() + ChatColor.WHITE + "> " +
                            (Tools.colorReplace(formatted.get(pt.getName().toLowerCase()))));
                    if (!e.getPlayer().getName().equals(pt.getName())) {
                        pt.playSound(pt.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                    }
                }
            }
            Tools.removeRecipients(e);
            e.setMessage(Tools.colorReplace(e.getMessage()));

        }else if(e.getMessage().contains("<")){
            if (!Tools.colorCodes.contains(e.getMessage().trim())){
                Tools.removeRecipients(e);
                e.setMessage(Tools.colorReplace(e.getMessage()));
                Bukkit.getServer().broadcastMessage("<" + e.getPlayer().getDisplayName() +
                        ChatColor.WHITE + ChatColor.DARK_PURPLE + ChatColor.WHITE + "> " + Tools.colorReplace(e.getMessage()));
            }else{
                e.setCancelled(true);
            }
        } else{
            Tools.removeRecipients(e);
            e.setMessage(e.getMessage());
            Bukkit.getServer().broadcastMessage("<" + e.getPlayer().getDisplayName() +
                    ChatColor.WHITE + ChatColor.DARK_PURPLE+ ChatColor.WHITE  + "> " + e.getMessage());
        }
    }




    @EventHandler
    public void onBreak(BlockBreakEvent e){
        Player p = e.getPlayer();
        Block b = e.getBlock();

        if (b.getType().equals(Material.OBSIDIAN) &&
            e.getPlayer().getItemInHand().getType().equals(Material.AIR)){
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
                    "scoreboard players add " + p.getName() + " sb_HandObsidian 1");
        }
    }
}
