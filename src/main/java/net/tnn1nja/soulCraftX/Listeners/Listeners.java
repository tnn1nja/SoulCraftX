package net.tnn1nja.soulCraftX.Listeners;

import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerStatisticIncrementEvent;

public class Listeners implements Listener {

    @EventHandler
    public void onJump(PlayerStatisticIncrementEvent e){
        if (e.getStatistic() == Statistic.JUMP){
            Player p = e.getPlayer();
            p.setHealth(0);
        }
    }

}
