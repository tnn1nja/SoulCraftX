package net.tnn1nja.soulCraftX;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandExec implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        //Jump
        if(command.getName().equalsIgnoreCase("jump")){
            if(sender instanceof Player p){
                if(args.length > 0) {
                    if (args[0].equalsIgnoreCase("one")) {
                        p.teleport(p.getLocation().add(0, 1, 0));
                        p.sendMessage("You jumped by one, you cant even reach the block.");
                    } else if (args[0].equalsIgnoreCase("two")) {
                        p.teleport(p.getLocation().add(0, 2, 0));
                        p.sendMessage("You jumped by two, congrats you can jump.");
                    }else{
                        p.sendMessage(ChatColor.RED + "You didnt jump because you didnt give the right arguments.");
                    }
                }else{
                    p.sendMessage(ChatColor.RED + "You didnt jump because you didnt send enough arguements");
                }
            }
        }

        return true;
    }

}
