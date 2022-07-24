package magz.dev.chatrestriction.CustomConfig;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class c_config {

    private static File file;
    private static FileConfiguration customFile;

    //Finds or generates the custom config file
    public static void setup(){
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("ChatRestriction").getDataFolder(), "c_config.yml");

        if (!file.exists()){
            try{
                file.createNewFile();
            }catch (IOException e){
                //owww
            }
        }
        customFile = YamlConfiguration.loadConfiguration(file);


        c_config.get().addDefault("plugin.prefix", "§4[§cChatRestriction§4]§r ");
        c_config.get().addDefault("plugin.cooldown", 3);

        c_config.get().addDefault("plugin.permission.admin", "chatrestriction.admin");
        c_config.get().addDefault("plugin.permission.bypass", "chatrestriction.bypass");

        c_config.get().addDefault("messages.on_cooldown", "§cYou are on cooldown. Pigeone le shop.");
        c_config.get().addDefault("messages.reload_msg", "§7Successfully reloaded ChatRestriction.");
        c_config.get().addDefault("messages.start_msg", "§7Successfully loaded ChatRestriction.");
        c_config.get().addDefault("messages.no_perm", "§cYou don't have the permissions to do that.");


    }

    public static FileConfiguration get(){
        return customFile;
    }

    public static void save(){
        try{
            customFile.save(file);
        }catch (IOException e){
            System.out.println("Couldn't save file");
        }
    }

    public static void reload(){
        customFile = YamlConfiguration.loadConfiguration(file);
    }

}



