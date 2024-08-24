package me.tnn1nja.SoulCraftX.Listeners;
import me.tnn1nja.SoulCraftX.Main;
import me.tnn1nja.SoulCraftX.Tools;
import org.bukkit.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.scheduler.BukkitRunnable;
import java.util.Random;

public class DieRelocateListener implements Listener{

    //Variables
    public static Player delayPlayer;




    //Death
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        Player player = e.getEntity().getPlayer();
        String dthmsg;
        String[] guddeaths = {" was bollocked", " was disciplined", " was reprimanded", " was disobedient",
                " got a stern ticking off", " commited suicide according to Mining Monkey Ltd",
                " was involved in a workplace accident", " failed to meet his quota", " wanted additional porridge",
                " looked slightly off", " probably deserved it", " got what was coming to him", " failed to revolt"};

        if (player.getName().equalsIgnoreCase("itsallgud") &&
                e.getDeathMessage().toLowerCase().contains("tnn1nja")){
            //Random Number
            Random rand = new Random();
            int random = rand.nextInt(guddeaths.length-1);
            dthmsg = ChatColor.RED + player.getName() + guddeaths[random];

        }else{
             dthmsg =  ChatColor.RED + e.getDeathMessage();
        }

        Tools.RelocateEffect(player);
        e.setDeathMessage(dthmsg);
    }




    //Respawn
    @EventHandler
    public void onRespawn(PlayerRespawnEvent e){
        Player player = e.getPlayer();

        delayPlayer = player;
        new BukkitRunnable(){
            @Override
            public void run() {
                Tools.RelocateEffect(delayPlayer);
                delayPlayer.getWorld().playSound(delayPlayer.getLocation(), Sound.ENTITY_EVOKER_CAST_SPELL, 0.2F,
                        1.45F);
            }
        }.runTaskAsynchronously(Main.me);
    }

    //Teleport
    @EventHandler
    public void onTeleport(PlayerTeleportEvent e) {
        if (e.getCause() == PlayerTeleportEvent.TeleportCause.COMMAND ||
                e.getCause() == PlayerTeleportEvent.TeleportCause.CHORUS_FRUIT ||
                e.getCause() == PlayerTeleportEvent.TeleportCause.ENDER_PEARL){
            Player player = e.getPlayer();
            Tools.RelocateEffect(player);

            delayPlayer = player;
            new BukkitRunnable(){
                @Override
                public void run() {
                    Tools.RelocateEffect(delayPlayer);
                }
            }.runTaskAsynchronously(Main.me);
        }
    }

}

