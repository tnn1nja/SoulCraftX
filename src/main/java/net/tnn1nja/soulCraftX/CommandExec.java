package net.tnn1nja.soulCraftX;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandExec implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        //Jump
        if(command.getName().equalsIgnoreCase("jump")){
            if(sender instanceof Player){
                Player p = (Player) sender;
                p.teleport(p.getLocation().add(0, 1.25, 0));
            }
        };

        return true;
    }

}
