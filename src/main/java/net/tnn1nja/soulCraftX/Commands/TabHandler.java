package net.tnn1nja.soulCraftX.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TabHandler implements TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {

        if(command.getName().equalsIgnoreCase("jump")){
            if(args.length == 1){
                return filterList(Arrays.asList("one", "two"), args[0]);
            }
        }

        //Catch All
        return Arrays.asList("");
    }

    //Filter Outputting List For User Input
    private List<String> filterList(List<String> list, String arg){
        return list.stream().filter(s -> s.toLowerCase().startsWith(arg.toLowerCase())).
                collect(Collectors.toList());
    }

}
