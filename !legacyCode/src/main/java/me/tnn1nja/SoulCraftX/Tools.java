package me.tnn1nja.SoulCraftX;

import github.scarsz.discordsrv.dependencies.jda.api.JDA;
import github.scarsz.discordsrv.dependencies.jda.api.entities.TextChannel;
import github.scarsz.discordsrv.util.DiscordUtil;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.util.io.BukkitObjectInputStream;
import org.bukkit.util.io.BukkitObjectOutputStream;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;


import static java.lang.String.valueOf;
import static org.bukkit.util.NumberConversions.floor;

public class Tools {

    //Particles
    public static Particle.DustOptions lightDust = new Particle.DustOptions(Color.fromRGB(191, 0, 191),
            1.3F);
    public static Particle.DustOptions darkDust = new Particle.DustOptions(Color.fromRGB(255, 85, 255),
            1.3F);
    public static void RelocateEffect(Player player) {
        player.getWorld().spawnParticle(Particle.REDSTONE, (player.getLocation().add(0, 1, 0)), 90,
                0.3F, 0.45F, 0.3F, Tools.lightDust);
        player.getWorld().spawnParticle(Particle.REDSTONE, (player.getLocation().add(0, 1, 0)), 90,
                0.3F, 0.45F, 0.3F, Tools.darkDust);
    }

    public static void SpawnEffect(Player player) {
        player.getWorld().playSound(player.getLocation(), Sound.ENTITY_EVOKER_CAST_SPELL, 0.2F, 1.45F);
        player.getWorld().spawnParticle(Particle.REDSTONE, (player.getLocation().add(0, 1, 0)), 450,
                0.3F, 0.45F, 0.3F, Tools.lightDust);
        player.getWorld().spawnParticle(Particle.REDSTONE, (player.getLocation().add(0, 1, 0)), 450,
                0.3F, 0.45F, 0.3F, Tools.darkDust);
    }




    //Data Storage
    public static String dataFile;

    public static HashMap<String, DataStore> pDataStore = new HashMap<String, DataStore>();

    public static void saveData() {
        try {
            BukkitObjectOutputStream out = new BukkitObjectOutputStream
                    (new GZIPOutputStream(Files.newOutputStream(Paths.get(dataFile))));
            out.writeObject(pDataStore);
            out.close();
        } catch (IOException e) {
            Bukkit.getLogger().info("[SoulCraftX] Data file not found, creating one...");
        }
    }
    public static void loadData() {
        try {
            BukkitObjectInputStream in = new BukkitObjectInputStream
                    (new GZIPInputStream(Files.newInputStream(Paths.get(dataFile))));
            pDataStore = (HashMap<String, DataStore>) in.readObject();
            in.close();
        } catch (ClassNotFoundException | IOException e) {
            Bukkit.getLogger().info("[SoulCraftX] Data file not found, creating one...");
        }
    }

    public static SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm a, dd/MM/yy");
    static {
        dateFormat.setTimeZone(TimeZone.getTimeZone("Europe/London"));
    }

    public static class DataStore implements Serializable {
        public long timesJoined;
        public String lastPlayed;
        public long joinTime;

        public DataStore(String lastPlayed, long timesJoined){
            this.lastPlayed = lastPlayed;
            this.timesJoined = timesJoined;
            this.joinTime = System.currentTimeMillis();
        }

        public void addJoin(){
            timesJoined++;
            joinTime = System.currentTimeMillis();
        }

        public void updateDate(String input){
            lastPlayed = input;
        }
    }




    //Discord Linking
    public static TextChannel minecraft_chat;
    public static void initChat(){
        if (minecraft_chat == null) {
            JDA jda = DiscordUtil.getJda();
            List<TextChannel> channels = jda==null?null: jda.getTextChannels();
            if (channels != null) {
                for (TextChannel channel : channels) {
                    if (channel.getName().equalsIgnoreCase("minecraft-chat")) {
                        minecraft_chat = channel;
                    }
                }
            }
        }
    }




    //Color Tools
    public static String[][] colorRealign = {
            {"<dark_red>","§4"},
            {"<red>","§c"},
            {"<gold>","§6"},
            {"<yellow>","§e"},
            {"<dark_green>","§2"},
            {"<green>","§a"},
            {"<aqua>","§b"},
            {"<dark_aqua>","§3"},
            {"<dark_blue>","§1"},
            {"<blue>","§9"},
            {"<light_purple>","§d"},
            {"<dark_purple>","§5"},
            {"<white>","§f"},
            {"<gray>","§7"},
            {"<dark_gray>","§8"},
            {"<black>","§0"},
            {"<bold>","§l"},
            {"<italic>","§o"},
            {"<strike>","§m"},
            {"<flash>","§k"},
            {"<reset>","§r"}};

    public static List<String> colorCodes = new ArrayList<String>(colorRealign.length);
    static{
        for(String[] array: colorRealign){
            colorCodes.add(array[0]);
        }
    }

    public static String colorReplace(String string){
        for(String[] array : Tools.colorRealign) {
            string = string.replaceAll(array[0],array[1]);
        }
        return string;
    }

    public static HashMap<String, String> playerChatAts(String chatInput) {
        List<String> whitelist = Tools.whitelist("lower");
        List<String> roles = Arrays.asList("developer", "member", "owner");
        //Blue
        String[] words = chatInput.split(" ");
        for (String testStr : words) {
            if (testStr.startsWith("@")) {
                String playerName = testStr.replaceAll("@", "");

                if (whitelist.contains(playerName.toLowerCase())) {
                    chatInput = chatInput.replace(testStr, "<dark_aqua>@" +
                            Bukkit.getOfflinePlayer(playerName).getName() + "<reset>");
                } if (roles.contains(playerName.toLowerCase())){
                    chatInput = chatInput.replace(testStr, "<dark_purple>" + testStr + "<reset>");
                }
            }
        }

        HashMap<String, String> outputs = new HashMap<String, String>();
        outputs.put("None", chatInput);

        words = chatInput.split(" ");
        for (String testStr : words) {
            if (testStr.contains("<dark_aqua>")) {
                String playerName = testStr.replaceAll("<dark_aqua>", "");
                playerName = playerName.replaceAll("<reset>", "");
                playerName = playerName.replaceAll("@", "");

                if (whitelist.contains(playerName.toLowerCase())) {
                    String replaceStr;
                    if (outputs.get(playerName) == null) {
                        replaceStr = chatInput;
                    } else {
                        replaceStr = outputs.get(playerName);
                    }

                    outputs.put(playerName, replaceStr.replaceAll(testStr, "<gold>@" + playerName +
                            "<reset>"));
                }

            }
        }
        return outputs;
    }

    public static void NameColor(Player player){
        player.setDisplayName(ChatColor.DARK_PURPLE + player.getName() + ChatColor.WHITE);
        player.setPlayerListName(ChatColor.WHITE + player.getName());
    }




    //Player Tools
    public static void removeRecipients(AsyncPlayerChatEvent e){
        for (Player p: Bukkit.getOnlinePlayers()) {
            e.getRecipients().remove(p);
        }
    }

    public static List<String> onlinePlayers() {
        List<String> onlinep = new ArrayList<String>();
        for (Player px : Bukkit.getOnlinePlayers()) {
            onlinep.add(px.getName().toLowerCase());
        }
        return onlinep;
    }

    public static List<String> whitelist(String mode) {
        List<String> whitelisted = new ArrayList<String>();
        for (OfflinePlayer px : Bukkit.getWhitelistedPlayers()) {
            if(mode=="lower"){
                whitelisted.add((px.getName()).toLowerCase());
            }else{
                whitelisted.add(px.getName());
            }
        }
        return whitelisted;
    }




    //Playtime
    public static String tickFormat(float plyTicks, boolean days){
        float plySeconds = floor(plyTicks/20);

        String[] values = {"0d ", "0h ", valueOf(floor(plySeconds/60)%60) + "m ",
                valueOf((long) plySeconds%60) + "s "};

        if(days) { //Returns in days
            values[1] = valueOf(floor(plySeconds / 3600) % 24) + "h ";
            values[0] = valueOf(floor(plySeconds / (3600 * 24))) + "d ";
        }else { //Returns in hours
            values[1] = valueOf(floor(plySeconds/3600)) + "h ";
        }

        //Return final output
        StringBuilder output = new StringBuilder(ChatColor.GRAY.toString());
        for(String val: values){
            if (!val.startsWith("0")){
                output.append(val);
            }
        }
        return output.toString();
    }

}
