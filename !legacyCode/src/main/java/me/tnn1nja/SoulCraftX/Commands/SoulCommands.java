package me.tnn1nja.SoulCraftX.Commands;

import github.scarsz.discordsrv.util.DiscordUtil;
import me.tnn1nja.SoulCraftX.Main;
import me.tnn1nja.SoulCraftX.Tools;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import xyz.haoshoku.nick.api.NickAPI;

import java.util.*;

import static org.bukkit.util.NumberConversions.floor;


public class SoulCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        //HELP
        if (command.getName().equalsIgnoreCase("help")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                player.sendMessage("");
                player.sendMessage(ChatColor.DARK_GRAY + "----------------- " + ChatColor.LIGHT_PURPLE + "Soul" +
                        ChatColor.DARK_PURPLE + "Craft" + ChatColor.AQUA + " Commands " +
                        ChatColor.DARK_GRAY + "-----------------");
                player.sendMessage(ChatColor.AQUA + "/Seed -" + ChatColor.DARK_AQUA +
                        " This will give you the seed, only use this in reason.");
                player.sendMessage(ChatColor.AQUA + "/Help -" + ChatColor.DARK_AQUA +
                        " Brings up this menu.");
                player.sendMessage(ChatColor.AQUA + "/Playtime (pt) <player> -" + ChatColor.DARK_AQUA +
                        " Shows any players total playtime.");
                player.sendMessage(ChatColor.AQUA + "/Playtimetop (ptt) -" + ChatColor.DARK_AQUA +
                        " This will show a total playtime leaderboard.");
                player.sendMessage(ChatColor.AQUA + "/Lastseen (ls) -" + ChatColor.DARK_AQUA +
                        " Shows when a player last connected.");

                if (player.hasPermission("commandwhitelist.group.admin")) {
                    player.sendMessage(ChatColor.AQUA + "/Members -" + ChatColor.DARK_AQUA +
                            " List and change SoulCraft's members.");
                    player.sendMessage(ChatColor.AQUA + "/Display -" + ChatColor.DARK_AQUA +
                            " Change statistics shown on displays.");
                    player.sendMessage(ChatColor.AQUA + "/Kick -" + ChatColor.DARK_AQUA +
                            " Kick players from the server.");
                    player.sendMessage(ChatColor.AQUA + "/Nick -" + ChatColor.DARK_AQUA +
                            " Change players displayed names.");
                } else {
                    player.sendMessage(ChatColor.AQUA + "/Members -" + ChatColor.DARK_AQUA +
                            " Lists SoulCrafts Whitelisted Members.");
                }

                if (player.hasPermission("commandwhitelist.group.gud") &&
                        !player.hasPermission("commandwhitelist.group.admin")) {
                    player.sendMessage(ChatColor.AQUA + "/Nick -" + ChatColor.DARK_AQUA +
                            " Change tnn1nja, bomotod and your displayed names.");
                    player.sendMessage(ChatColor.AQUA + "/Kick -" + ChatColor.DARK_AQUA +
                            " Kick tnn1nja, bomotod and yourself from the server.");
                    player.sendMessage(ChatColor.AQUA + "/Display -" + ChatColor.DARK_AQUA +
                            " Change statistics shown on displays.");
                }
                if (player.hasPermission("commandwhitelist.group.annalise") &&
                        !player.hasPermission("commandwhitelist.group.admin")) {
                    player.sendMessage(ChatColor.AQUA + "/Nick -" + ChatColor.DARK_AQUA +
                            " Change bomotod and your displayed names.");
                    player.sendMessage(ChatColor.AQUA + "/Kick -" + ChatColor.DARK_AQUA +
                            " Kick bomotod and yourself from the server.");
                }
                if (player.hasPermission("commandwhitelist.group.jeth") &&
                        !player.hasPermission("commandwhitelist.group.admin")) {
                    player.sendMessage(ChatColor.AQUA + "/Nick -" + ChatColor.DARK_AQUA +
                            " Change JayBennyBoy and _mgldn's displayed names.");
                    player.sendMessage(ChatColor.AQUA + "/Kick -" + ChatColor.DARK_AQUA +
                            " Kick JayBennyBoy and _mgldn's from the server.");
                }

                if (!player.hasPermission("commandwhitelist.group.admin") &&
                        !player.hasPermission("commandwhitelist.group.gud") &&
                        !player.hasPermission("commandwhitelist.group.annalise") &&
                        !player.hasPermission("commandwhitelist.group.jeth")) {
                    player.sendMessage(ChatColor.AQUA + "/Nick -" + ChatColor.DARK_AQUA +
                            " Change your own display name.");

                }

                player.sendMessage(ChatColor.AQUA + "/Online -" + ChatColor.DARK_AQUA +
                        " Used in discord, shows online players.");
                player.sendMessage(ChatColor.DARK_GRAY + "----------------------------------------------------");
                player.sendMessage("");
            }
        }




        //SEED
        if (command.getName().equalsIgnoreCase("seed")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;

                if ((args.length) == 0) {

                    TextComponent message = new TextComponent(ChatColor.AQUA + "The " + ChatColor.LIGHT_PURPLE +
                            "Soul" + ChatColor.DARK_PURPLE + "Craft" + ChatColor.AQUA + " Seed: ["
                            + ChatColor.DARK_AQUA + "-8427271091518814370" + ChatColor.AQUA + "]");
                    message.setClickEvent(new ClickEvent(ClickEvent.Action.COPY_TO_CLIPBOARD,
                            "-8427271091518814370"));
                    message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text(
                            "Copy SoulCraft's Seed")));

                    player.spigot().sendMessage(message);

                } else {
                    try {
                        if ((args[0].equals("as_trigger") || args[0].equals("if_invisible"))
                                && args[1].equals("set")) {
                            String fullArgs = String.join(" ", args);
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
                                    "execute as " + player.getName() + " run trigger " + fullArgs);
                        } else {
                            player.sendMessage(ChatColor.RED + "You aren't allowed to do this, try /help!");
                            return true;
                        }
                    } catch (Exception ey) {
                        player.sendMessage(ChatColor.RED + "You aren't allowed to do this, try /help!");

                    }
                }
            }

        }




        //DISPLAY
        if (command.getName().equalsIgnoreCase("display")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (args.length == 2) {
                    if (args[0].equals("scoreboard") || args[0].equals("tab")) {
                        String boardtype = "";
                        if (args[0].equals("scoreboard")) {
                            boardtype = "sidebar ";
                        } else {
                            boardtype = "list ";
                        }

                        if (args[1].equalsIgnoreCase("clear")) {
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
                                    "scoreboard objectives setdisplay " + boardtype);
                            player.sendMessage(ChatColor.AQUA + "The display has been cleared");

                        } else if (SoulTabComplete.Suggest2.contains(args[1])) {
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
                                    "scoreboard objectives setdisplay " + boardtype + "sb_" +
                                            args[1].toString());
                            player.sendMessage(ChatColor.AQUA + "The display has been updated.");
                        } else {
                            player.sendMessage(ChatColor.RED + "Invalid Arguments!");
                        }
                    } else {
                        player.sendMessage(ChatColor.RED + "Invalid Arguments!");
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "Invalid Arguments!");
                }
            }

        }




        //KICK
        if (command.getName().equalsIgnoreCase("kick")) {
            //PERMS
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (p.hasPermission("commandwhitelist.group.gud") &&
                        !p.hasPermission("commandwhitelist.group.admin")) {
                    if (args.length > 0) {
                        if (!args[0].equalsIgnoreCase("tnn1nja") &&
                                !args[0].equalsIgnoreCase("itsallgud") &&
                                !args[0].equalsIgnoreCase("bomotod")) {
                            p.sendMessage(ChatColor.RED + "You aren't allowed to do this, try /help!");
                            return true;
                        }
                    }
                }
                if (p.hasPermission("commandwhitelist.group.annalise") &&
                        !p.hasPermission("commandwhitelist.group.admin")) {
                    if (args.length > 0) {
                        if (!args[0].equalsIgnoreCase("bomotod") &&
                                !args[0].equalsIgnoreCase("goddessannalise")) {
                            p.sendMessage(ChatColor.RED + "You aren't allowed to do this, try /help!");
                            return true;
                        }
                    }
                }
                if (p.hasPermission("commandwhitelist.group.jeth") &&
                        !p.hasPermission("commandwhitelist.group.admin")) {
                    if (args.length > 0) {
                        if (!args[0].equalsIgnoreCase("JayBennyBoy") &&
                                !args[0].equalsIgnoreCase("_mgldn")) {
                            p.sendMessage(ChatColor.RED + "You aren't allowed to do this, try /help!");
                            return true;
                        }
                    }
                }
            }

            //MAIN BODY
            if (args.length == 0) {
                sender.sendMessage(ChatColor.RED + "Invalid Arguments!");
            } else {
                Player target = Bukkit.getServer().getPlayer(args[0]);
                if (target == null) {
                    sender.sendMessage(ChatColor.RED + "Player not found, check you typed their name correctly!");
                } else {
                    String kickMessage = "";
                    if (args.length > 1) {
                        for (int i = 1; i < args.length; i++) {
                            kickMessage += args[i].toString() + " ";
                        }
                        Bukkit.getServer().broadcastMessage(ChatColor.AQUA + target.getName() + ChatColor.DARK_AQUA +
                                " has been kicked for " + ChatColor.AQUA + kickMessage);
                        Tools.initChat();
                        DiscordUtil.sendMessage(Tools.minecraft_chat, "> **" + target.getName() + " was kicked" +
                                " for " + kickMessage + "**");
                    } else {
                        Bukkit.getServer().broadcastMessage(ChatColor.AQUA + target.getName() + ChatColor.DARK_AQUA +
                                " has been kicked");
                        kickMessage = "You have been kicked from SoulCraft. However, you can rejoin!";
                        Tools.initChat();
                        DiscordUtil.sendMessage(Tools.minecraft_chat, "> **" + target.getName() +
                                " has been kicked**");

                    }
                    target.kickPlayer(kickMessage);
                }
            }
        }




        //MEMBERS
        if (command.getName().equalsIgnoreCase("members")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (args.length == 0) {

                    player.sendMessage("");
                    player.sendMessage(ChatColor.DARK_GRAY + "-- " + ChatColor.LIGHT_PURPLE + "Soul" +
                            ChatColor.DARK_PURPLE + "Craft" + ChatColor.AQUA + "'s Members" +
                            ChatColor.DARK_GRAY + " --");
                    for (OfflinePlayer px : Bukkit.getWhitelistedPlayers()) {
                        player.sendMessage(ChatColor.DARK_AQUA + "- " +
                                Objects.requireNonNull(px.getName()));
                    }
                    player.sendMessage(ChatColor.DARK_GRAY + "----------------------");
                    player.sendMessage("");

                } else if (player.hasPermission("commandwhitelist.group.admin")) {
                    if (args.length == 1) {
                        player.sendMessage(ChatColor.RED + "Invalid Arguments!");
                    } else {
                        if (args[0].equals("add")) {
                            if (Tools.whitelist("lower").contains(args[1].toLowerCase())) {
                                player.sendMessage(ChatColor.RED +
                                        Bukkit.getOfflinePlayer(args[1]).getName() + " is already a member");
                            } else {
                                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "whitelist add "
                                        + args[1]);
                                if (Tools.whitelist("lower").contains(args[1].toLowerCase())) {
                                    player.sendMessage(ChatColor.AQUA + Bukkit.getOfflinePlayer(args[1]).getName() +
                                            ChatColor.DARK_AQUA + " has been added to SoulCraft");
                                } else {
                                    player.sendMessage(ChatColor.RED +
                                            "Player not found, check you typed their name correctly!");
                                }
                            }


                        } else if (args[0].equals("remove")) {
                            if (Tools.whitelist("lower").contains(args[1].toLowerCase())) {
                                try {
                                    Bukkit.getOfflinePlayer(args[1]).setWhitelisted(false);
                                    player.sendMessage(ChatColor.AQUA + Bukkit.getOfflinePlayer(args[1]).getName() +
                                            ChatColor.DARK_AQUA + " removed from SoulCraft.");
                                } catch (Exception e) {
                                    player.sendMessage(ChatColor.RED +
                                            "Player not found, check you typed their name correctly!");
                                    return true;
                                }

                                try {
                                    Bukkit.getPlayer(args[1]).kickPlayer("You have been removed from SoulCraft");
                                } catch (Exception e) {
                                    return true;
                                }

                            } else {
                                player.sendMessage(ChatColor.RED + "Player not found, check you typed their name " +
                                        "correctly!");
                            }


                        } else {
                            player.sendMessage(ChatColor.RED + "Invalid Arguments!");
                        }
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "You aren't allowed to do this, try /help!");
                }
            }
        }




        //NICK
        if (command.getName().equalsIgnoreCase("nick")) {
            Player pt;
            String newname;
            if (sender instanceof Player) { //ITS A PLAYER
                Player p = (Player) sender;

                //SUB GROUP PERMS
                if (p.hasPermission("commandwhitelist.group.gud") &&
                        !p.hasPermission("commandwhitelist.group.admin")) {
                    if (!args[0].toLowerCase().equalsIgnoreCase("tnn1nja") &&
                            !args[0].toLowerCase().equalsIgnoreCase("itsallgud")
                            && !args[0].toLowerCase().equalsIgnoreCase("bomotod")){
                        p.sendMessage(ChatColor.RED + "You aren't allowed to do this, try /help!");
                        return true;
                    }
                } else if (p.hasPermission("commandwhitelist.group.annalise") &&
                        !p.hasPermission("commandwhitelist.group.admin")) {
                    if (!args[0].equalsIgnoreCase("bomotod") &&
                            !args[0].equalsIgnoreCase("goddessannalise")) {
                        p.sendMessage(ChatColor.RED + "You aren't allowed to do this, try /help!");
                        return true;
                    }
                } else if (p.hasPermission("commandwhitelist.group.jeth") &&
                        !p.hasPermission("commandwhitelist.group.admin")) {
                    if (!args[0].equalsIgnoreCase("JayBennyBoy") &&
                            !args[0].equalsIgnoreCase("_mgldn")) {
                        p.sendMessage(ChatColor.RED + "You aren't allowed to do this, try /help!");
                        return true;
                    }
                }

                //VALIDATION
                if (p.hasPermission("commandwhitelist.group.admin") ||
                        p.hasPermission("commandwhitelist.group.gud") ||
                        p.hasPermission("commandwhitelist.annalise") ||
                        p.hasPermission("commandwhitelist.jeth")) {
                    if (args.length == 2) {
                        newname = args[1];
                    } else if (args.length == 1){
                        newname = args[0];
                    } else{
                        p.sendMessage(ChatColor.RED + "You aren't allowed to do this, try /help!");
                        return true;
                    }
                } else {
                    if (args.length == 1) {
                        newname = args[0];
                    } else {
                        p.sendMessage(ChatColor.RED + "You aren't allowed to do this, try /help!");
                        return true;
                    }
                }

                //GROUP TESTING
                if (p.hasPermission("commandwhitelist.group.admin") ||
                        p.hasPermission("commandwhitelist.group.gud") ||
                        p.hasPermission("commandwhitelist.annalise") ||
                        p.hasPermission("commandwhitelist.jeth")) {
                    if (args.length == 2 && Tools.onlinePlayers().contains(args[0].toLowerCase())) {
                        pt = Bukkit.getPlayer(args[0]);
                    } else if (args.length == 1) {
                        pt = p;
                    }else{
                        p.sendMessage(ChatColor.RED + "Player not found, check you typed their name " +
                                "correctly!");
                        return true;
                    }
                } else {
                    pt = p;

                }
            } else { //ITS CONSOLE
                try {
                    pt = Bukkit.getPlayer(args[0]);
                    newname = args[1];
                } catch (Exception e) {
                    sender.sendMessage(ChatColor.RED + "Incorrect Arguements!");
                    return true;
                }
            }

            //Clearing Name
            if (newname.equalsIgnoreCase("clear")) {
                NickAPI.resetNick(pt);
                NickAPI.refreshPlayer(pt);
                pt.setDisplayName(ChatColor.DARK_PURPLE + pt.getName());

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        pt.setPlayerListName(ChatColor.WHITE + pt.getName());
                    }
                }.runTaskLater(Main.me, 5);

                Bukkit.broadcastMessage(ChatColor.AQUA + pt.getName() + ChatColor.DARK_AQUA + "'s name has" +
                        " been reset");
                Tools.initChat();
                DiscordUtil.sendMessage(Tools.minecraft_chat, "> **" + pt.getName() + "'s name has" +
                        " been reset**");


                //Setting New Name
            } else {
                NickAPI.nick(pt, ChatColor.RED + newname);
                NickAPI.refreshPlayer(pt);
                pt.setDisplayName(ChatColor.DARK_RED + newname);

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        pt.setPlayerListName(NickAPI.getName(pt));
                    }
                }.runTaskLater(Main.me, 5);

                Bukkit.broadcastMessage(ChatColor.AQUA + pt.getName() + ChatColor.DARK_AQUA + "'s name has" +
                        " been changed to " + ChatColor.AQUA + newname);
                Tools.initChat();
                DiscordUtil.sendMessage(Tools.minecraft_chat, "> **" + pt.getName() + "'s name has" +
                        " been changed to " + newname + "**");

            }
        }




        //ONLINE
        if (command.getName().equalsIgnoreCase("online")) {
            sender.sendMessage(ChatColor.RED + "This command can only be used in the minecraft-chat " +
                    "channel on discord!");
        }




        //LAST SEEN
        if (command.getName().equalsIgnoreCase("lastseen") ||
                command.getName().equalsIgnoreCase("ls")) {
            if (args.length > 0) {
                if (sender instanceof Player){
                    Player p = (Player) sender;
                    if (p.getName().equalsIgnoreCase(args[0])){
                        p.sendMessage(ChatColor.RED + "Thats you numpty, of course your online!");
                        return true;
                    }
                }

                if (Tools.whitelist("lower").contains(args[0].toLowerCase())) {
                    if (Bukkit.getOfflinePlayer(args[0]).isOnline()) {
                        sender.sendMessage(ChatColor.AQUA + Bukkit.getOfflinePlayer(args[0]).getName() +
                                ChatColor.DARK_AQUA + " is currently online!");
                    } else {
                        if (Bukkit.getOfflinePlayer(args[0]).hasPlayedBefore()) {
                            sender.sendMessage(ChatColor.AQUA + Bukkit.getOfflinePlayer(args[0]).getName() +
                                    ChatColor.DARK_AQUA + " was last seen " + ChatColor.AQUA +
                                    Tools.pDataStore.get(args[0].toLowerCase()).lastPlayed);
                        }else{
                            sender.sendMessage(ChatColor.RED + "Player has never joined!");
                        }
                    }
                } else {
                    sender.sendMessage(ChatColor.RED + "Player not found, check you typed their name " +
                            "correctly!");
                }
            } else {
                sender.sendMessage(ChatColor.RED + "You aren't allowed to do this, try /help!");
            }
        }




        //Playtime
        if (command.getName().equalsIgnoreCase("playtime") ||
                command.getName().equalsIgnoreCase("pt")){
            //Validation
            if(args.length == 0) {
                if (!(sender instanceof Player)) {
                    sender.sendMessage(ChatColor.RED + "Incorrect Arguments!");
                    return true;
                }
            }else if (!Tools.whitelist("lower").contains(args[0].toLowerCase())) {
                sender.sendMessage(ChatColor.RED + "Player not found, check you typed their name " +
                        "correctly!");
                return true;
            }


            //Variable set up
            boolean days = true;
            OfflinePlayer pt;
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if(p.getName().equalsIgnoreCase("tnn1nja") || p.getName().equalsIgnoreCase("itsallgud")){
                    days = false;
                }

                if (args.length > 0){
                    pt = Bukkit.getOfflinePlayer(args[0]);
                }else{
                    pt = p;
                }

            }else{
                pt = Bukkit.getOfflinePlayer(args[0]);
            }

            if (pt.hasPlayedBefore() || pt.isOnline()) {
                //Maths
                Scoreboard sb = Bukkit.getScoreboardManager().getMainScoreboard();
                Objective objective = sb.getObjective("sb_PlayTime");
                float plyTicks = objective.getScore(pt.getName()).getScore();

                //Outputs
                sender.sendMessage("");
                sender.sendMessage(ChatColor.DARK_GRAY + "----------------------");
                sender.sendMessage(ChatColor.AQUA + pt.getName() + "'s stats:");
                sender.sendMessage(ChatColor.DARK_AQUA + "PlayTime: " + Tools.tickFormat(plyTicks, days));
                sender.sendMessage(ChatColor.DARK_AQUA + "Times Joined: " +
                        ChatColor.GRAY + Tools.pDataStore.get(pt.getName().toLowerCase()).timesJoined);

                if (pt.isOnline()) {
                    long joined = Tools.pDataStore.get(pt.getName().toLowerCase()).joinTime;
                    long now = System.currentTimeMillis();
                    float time = now - joined;
                    String currentSession = Tools.tickFormat(floor(time / 50), days);


                    sender.sendMessage(ChatColor.DARK_AQUA + "Current Session: " + currentSession);
                }


                sender.sendMessage(ChatColor.DARK_GRAY + "----------------------");
                sender.sendMessage("");
            }else{
                sender.sendMessage(ChatColor.RED + "Player has never joined!");
            }
        }




        //Playtime Top
        if (command.getName().equalsIgnoreCase("playtimetop") ||
                command.getName().equalsIgnoreCase("ptt")){
            //Days setup
            boolean days = true;
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (p.getName().equalsIgnoreCase("tnn1nja") ||
                        p.getName().equalsIgnoreCase("itsallgud")) {
                    days = false;
                }
            }

            //Pull Data
            List<String[]> playerdata = new ArrayList<String[]>();
            for(String pn: Tools.whitelist("lower")){
                OfflinePlayer pt = Bukkit.getOfflinePlayer(pn);
                Scoreboard sb = Bukkit.getScoreboardManager().getMainScoreboard();
                Objective objective = sb.getObjective("sb_PlayTime");

                if(pt.hasPlayedBefore() || pt.isOnline()){
                    String plyTicks =  "" + objective.getScore(pt.getName()).getScore();
                    String name = pt.getName();
                    playerdata.add(new String[] {name, plyTicks});

                }
            }

            //Sort Data
            Collections.sort(playerdata, new Comparator<String[]>() {
                @Override
                public int compare(String[] o1, String[] o2) {
                    long l1 = Long.parseLong(o1[1]);
                    long l2 = Long.parseLong(o2[1]);

                    if(l1<l2){
                        return 1;
                    }else if(l1>l2){
                        return -1;
                    }
                    return 0;
                }
            });

            //Output Data
            sender.sendMessage("");
            sender.sendMessage(ChatColor.DARK_GRAY + "----------------------");
            sender.sendMessage(ChatColor.AQUA + "Top 10 players playtime:");
            sender.sendMessage("");

            int count = 1;
            for(String[] x: playerdata){
                sender.sendMessage("" + ChatColor.DARK_AQUA + count + ". " + x[0] + ": " +
                        Tools.tickFormat(Float.parseFloat(x[1]), days));
                count++;
            }

            sender.sendMessage(ChatColor.DARK_GRAY + "----------------------");
            sender.sendMessage("");

        }




        //NONE OF THE ABOVE
        return true;
    }
}