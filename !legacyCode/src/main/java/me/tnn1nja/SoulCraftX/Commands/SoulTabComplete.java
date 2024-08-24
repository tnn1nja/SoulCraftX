package me.tnn1nja.SoulCraftX.Commands;

import me.tnn1nja.SoulCraftX.Tools;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SoulTabComplete implements TabCompleter {

    //Suggestions
    public static List<String> Suggest12(){
        List<String> players = new ArrayList<String>();
        for (Player px : Bukkit.getOnlinePlayers()) {
            players.add(px.getName());
        }
        players.add("clear");
        return players;
    }

    public static List<String> Suggest14 = Arrays.asList("bomotod", "ItsAllGud", "tnn1nja");
    public static List<String> Suggest13 = Arrays.asList("bomotod", "ItsAllGud");
    public static List<String> Suggest9 = Arrays.asList("_mgldn", "clear");
    public static List<String> Suggest10 = Arrays.asList("JayBennyBoy", "clear");
    public static List<String> Suggest11= Arrays.asList("JayBennyBoy", "_mgldn", "clear");
    public static List<String> Suggest6 = Arrays.asList("ItsAllGud", "clear");
    public static List<String> Suggest5 = Arrays.asList("tnn1nja", "ItsAllGud", "clear");
    public static List<String> Suggest8 = Arrays.asList("GoddessAnnalise", "clear");
    public static List<String> Suggest7 = Arrays.asList("bomotod", "GoddessAnnalise", "clear");
    public static List<String> Suggest3 = Arrays.asList("remove", "add");
    public static List<String> Suggest4 = Arrays.asList("clear");
    public static List<String> EmptySuggest = Arrays.asList();
    public static List<String> Suggest1 = Arrays.asList("scoreboard", "tab");
    public static List<String> Suggest2 = Arrays.asList("Health", "Deaths", "KillCount", "TotalKills", "AnimalsBred",
            "Aviate", "Brewing", "CakeEaten", "ChestOpened", "Climb", "Crafts", "Crouch", "DamageDealt", "DamageTaken",
            "EnderChest", "Fall", "FishCaught", "FlowerPotted", "Fly", "FurnaceUsed", "HorseRode", "EnchantItem", "Jump",
            "MinecartRide", "MobKills", "PlayNoteblock", "TuneNoteblock", "PigRide", "PlayTime", "PlayerKills",
            "RecordsPlayed", "ShulkerBox", "Sneak", "Sprint", "Swim", "LastDeath", "VillagerTrade", "TrapChestOpen", "Walk",
            "CraftBeacon", "CraftEndCryst", "CraftConduit", "CraftShulkBox", "UsePotion", "UseTotem", "UseTorch",
            "UseGoldApple", "UseBonemeal", "UseBucket", "UseWatrBucket", "UseLavaBucket", "UseSnowball", "UseEyeOfEnder",
            "UseEnderPearl", "UseTrident", "UseBottleEnch", "UseFishingRod", "UseHoneyBottl", "BreakDPick", "BreakDAxe",
            "BreakDShovel", "BreakDSword", "BreakDHoe", "BreakNPick", "BreakNAxe", "BreakNShovel", "BreakNSword",
            "BreakNHoe", "BreakBow", "BreakShears", "MineCoal", "MineDiamond", "MineEmerald", "MineQuartz", "MineRedstone",
            "MineLapis", "MineIron", "MineGold", "MineCopper", "MineNetherite", "MineDCoal", "MineDDiamond", "MineDEmerald",
            "MineDRedstone", "MineDLapis", "MineDIron", "MineDGold", "MineDCopper", "KillHoglin", "KillPiglin", "KillStrider",
            "KillZoglin", "KillBee", "KillBat", "KillBlaze", "KillCveSpider", "KillChicken", "KillCod", "KillCow",
            "KillCreeper", "KillDolphin", "KillDonkey", "KillDrowned", "KillEGuardian", "KillEDragon", "KillEnderman",
            "KillEndermite", "KillEvoker", "KillGhast", "KillGuardian", "KillHorse", "KillHusk", "KillIllusion",
            "KillIronGolem", "KillLlama", "KillMagmaCube", "KillMooshroom", "KillMule", "KillOcelot", "KillParrot",
            "KillPhantom", "KillPig", "KillPigman", "KillPolarBear", "KillPuffish", "KillRabbit", "KillSalmon", "KillSheep",
            "KillShulker", "KillSilvfish", "KillSkeleton", "KillSkeletonH", "KillSlime", "KillSnowGolem", "KillSpider",
            "KillSquid", "KillStray", "KillTropifish", "KillTurtle", "KillVex", "KillVillager", "KillVindicatr", "KillWitch",
            "KillWither", "KillWSkeleton", "KillWolf", "KillZombie", "KillZombieH", "KillZombieV", "KillWandering",
            "KillTraderLla", "KillFox", "KillPanda", "KillPillager", "KillRavager", "KillGlowSquid", "KillAxolotl",
            "KillGoat", "DthHoglin", "DthPiglin", "DthStrider", "DthZoglin", "DthBee", "DthBlaze", "DthCveSpider",
            "DthCreeper", "DthDolphin", "DthDrowned", "DthEGuardian", "DthEDragon", "DthEnderman", "DthEndermite",
            "DthEvoker", "DthGhast", "DthGuardian", "DthHusk", "DthIllusion", "DthIronGolem", "DthLlama", "DthMagmaCube",
            "DthPhantom", "DthPigman", "DthPolarBear", "DthPuffish", "DthRabbit", "DthShulker", "DthSilvfish", "DthSkeleton",
            "DthSkeletonH", "DthSlime", "DthSnowGolem", "DthSpider", "DthStray", "DthTurtle", "DthVex", "DthVillager",
            "DthVindicatr", "DthWitch", "DthWither", "DthWSkeleton", "DthWolf", "DthZombie", "DthZombieH", "DthZombieV",
            "DthWandering", "DthTraderLla", "DthFox", "DthPanda", "DthPillager", "DthRavager", "elytraCm", "playTick",
            "swimCm", "MineCoal", "MineDiamond", "MineEmerald", "MineRedstone", "MineLapis", "MineIron", "MineGold",
            "MineCopper", "Clear", "HandObsidian");




    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {

        //DISPLAY
        if (command.getName().equalsIgnoreCase("display")) {
            if (args.length == 1) {
                return Suggest1.stream().filter(s -> s.toLowerCase().startsWith(args[0].toLowerCase())).
                        collect(Collectors.toList());
            }
            if (args.length == 2) {
                return Suggest2.stream().filter(s -> s.toLowerCase().startsWith(args[1].toLowerCase())).
                        collect(Collectors.toList());
            }
        }




        //KICK
        if (command.getName().equalsIgnoreCase("kick")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                //ANNALISE GUD PERMS
                if (args.length == 1 && p.hasPermission("commandwhitelist.group.gud") &&
                        !p.hasPermission("commandwhitelist.group.admin")) {
                    if (Bukkit.getOfflinePlayer("tnn1nja").isOnline() &&
                            Bukkit.getOfflinePlayer("bomotod").isOnline()){
                        return Suggest14.stream().filter(s -> s.toLowerCase().startsWith(args[0].toLowerCase())).
                                collect(Collectors.toList());

                    }else if (Bukkit.getOfflinePlayer("tnn1nja").isOnline()) {
                        return Suggest5.stream().filter(s -> s.toLowerCase().startsWith(args[0].toLowerCase())).
                                collect(Collectors.toList());

                    }else if(Bukkit.getOfflinePlayer("bomotod").isOnline()){
                        return Suggest13.stream().filter(s -> s.toLowerCase().startsWith(args[0].toLowerCase())).
                                collect(Collectors.toList());

                    }else{
                        return Suggest6.stream().filter(s -> s.toLowerCase().startsWith(args[0].toLowerCase())).
                                collect(Collectors.toList());
                    }
                }
                if (args.length == 1 && p.hasPermission("commandwhitelist.group.annalise") &&
                        !p.hasPermission("commandwhitelist.group.admin")) {
                    if (Bukkit.getOfflinePlayer("bomotod").isOnline()) {
                        return Suggest7.stream().filter(s -> s.toLowerCase().startsWith(args[0].toLowerCase())).
                                collect(Collectors.toList());
                    } else {
                        return Suggest8.stream().filter(s -> s.toLowerCase().startsWith(args[0].toLowerCase())).
                                collect(Collectors.toList());
                    }
                }
                if (args.length == 1 && p.hasPermission("commandwhitelist.group.jeth") &&
                        !p.hasPermission("commandwhitelist.group.admin")) {
                    if (Bukkit.getOfflinePlayer("JayBennyBoy").isOnline() && //Only Jake online
                            !Bukkit.getOfflinePlayer("_mgldn").isOnline()) {
                        return Suggest10.stream().filter(s -> s.toLowerCase().startsWith(args[0].toLowerCase())).
                                collect(Collectors.toList());
                    }
                    if (Bukkit.getOfflinePlayer("_mgldn").isOnline() && //Only Seth online
                            !Bukkit.getOfflinePlayer("JayBennyBoy").isOnline()) {
                        return Suggest9.stream().filter(s -> s.toLowerCase().startsWith(args[0].toLowerCase())).
                                collect(Collectors.toList());
                    } else {
                        return Suggest11.stream().filter(s -> s.toLowerCase().startsWith(args[0].toLowerCase())).
                                collect(Collectors.toList());
                    }
                }
                if (args.length > 1) {
                    return EmptySuggest;
                }
            }
      }




        //MEMBERS
        if (command.getName().equalsIgnoreCase("members")) {
            if (args.length == 1 && sender.hasPermission("commandwhitelist.group.admin")) {
                return Suggest3.stream().filter(s -> s.toLowerCase().startsWith(args[0].toLowerCase())).
                        collect(Collectors.toList());
            } else if (args.length == 2 && sender.hasPermission("commandwhitelist.group.admin")) {
                if (args[0].equalsIgnoreCase("remove")) {
                    return Tools.whitelist("").stream().filter(s -> s.toLowerCase().startsWith(args[1].toLowerCase())).
                            collect(Collectors.toList());
                }else{
                    return EmptySuggest;
                }
            } else {
                return EmptySuggest;
            }
        }




        //NICK
        if (command.getName().equalsIgnoreCase("nick")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                //ADMIN PERMS
                if (args.length == 1 && p.hasPermission("commandwhitelist.group.admin")){
                    return Suggest12().stream().filter(s -> s.toLowerCase().startsWith(args[0].toLowerCase())).
                            collect(Collectors.toList());
                }

                //ANNALISE GUD PERMS
                if (args.length == 1 && p.hasPermission("commandwhitelist.group.gud") &&
                        !p.hasPermission("commandwhitelist.group.admin")) {
                    if (Bukkit.getOfflinePlayer("tnn1nja").isOnline() &&
                            Bukkit.getOfflinePlayer("bomotod").isOnline()){
                        return Suggest14.stream().filter(s -> s.toLowerCase().startsWith(args[0].toLowerCase())).
                                collect(Collectors.toList());

                    }else if (Bukkit.getOfflinePlayer("tnn1nja").isOnline()) {
                        return Suggest5.stream().filter(s -> s.toLowerCase().startsWith(args[0].toLowerCase())).
                                collect(Collectors.toList());

                    }else if(Bukkit.getOfflinePlayer("bomotod").isOnline()){
                        return Suggest13.stream().filter(s -> s.toLowerCase().startsWith(args[0].toLowerCase())).
                                collect(Collectors.toList());

                    }else{
                        return Suggest6.stream().filter(s -> s.toLowerCase().startsWith(args[0].toLowerCase())).
                                collect(Collectors.toList());
                    }
                } else if (args.length == 1 && p.hasPermission("commandwhitelist.group.annalise") &&
                        !p.hasPermission("commandwhitelist.group.admin")) {
                    if (Bukkit.getOfflinePlayer("bomotod").isOnline()) {
                        return Suggest7.stream().filter(s -> s.toLowerCase().startsWith(args[0].toLowerCase())).
                                collect(Collectors.toList());
                    } else {
                        return Suggest8.stream().filter(s -> s.toLowerCase().startsWith(args[0].toLowerCase())).
                                collect(Collectors.toList());
                    }
                } else if (args.length == 1 && p.hasPermission("commandwhitelist.group.jeth") &&
                        !p.hasPermission("commandwhitelist.group.admin")) {
                    if (Bukkit.getOfflinePlayer("JayBennyBoy").isOnline() && //Only Jake online
                            !Bukkit.getOfflinePlayer("_mgldn").isOnline()) {
                        return Suggest10.stream().filter(s -> s.toLowerCase().startsWith(args[0].toLowerCase())).
                                collect(Collectors.toList());
                    } if (Bukkit.getOfflinePlayer("_mgldn").isOnline() && //Only Seth online
                            !Bukkit.getOfflinePlayer("JayBennyBoy").isOnline()){
                        return Suggest9.stream().filter(s -> s.toLowerCase().startsWith(args[0].toLowerCase())).
                                collect(Collectors.toList());
                    } else{
                        return Suggest11.stream().filter(s -> s.toLowerCase().startsWith(args[0].toLowerCase())).
                                collect(Collectors.toList());
                    }
                }

                //STANDARD PERM
                if (!p.hasPermission("commandwhitelist.group.admin") &&
                        !p.hasPermission("commandwhitelist.group.gud") &&
                        !p.hasPermission("commandwhitelist.group.annalise") &&
                        !p.hasPermission("commandwhitelist.group.jeth")){
                    if (args.length == 1) {
                        return Suggest4.stream().filter(s -> s.toLowerCase().startsWith(args[0].toLowerCase())).
                                collect(Collectors.toList());
                    }
                }

                //ARG 2
                if (args.length == 2) {
                    return Suggest4.stream().filter(s -> s.toLowerCase().startsWith(args[1].toLowerCase())).
                            collect(Collectors.toList());
                }
            }
        }




        //LAST SEEN
        if (command.getName().equalsIgnoreCase("lastseen") ||
                command.getName().equalsIgnoreCase("ls")){
            if (args.length == 1){
                return Tools.whitelist("").stream().filter(s -> s.toLowerCase().startsWith(args[0].toLowerCase())).
                        collect(Collectors.toList());
            }
        }




        //PLAYTIME
        if (command.getName().equalsIgnoreCase("playtime") ||
                command.getName().equalsIgnoreCase("pt")){
            if (args.length == 1){
                return Tools.whitelist("").stream().filter(s -> s.toLowerCase().startsWith(args[0].toLowerCase())).
                        collect(Collectors.toList());
            }
        }




        //CATCH ALL
        return null;
    }
}
