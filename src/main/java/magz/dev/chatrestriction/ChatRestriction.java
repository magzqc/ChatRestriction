package magz.dev.chatrestriction;

import magz.dev.chatrestriction.CustomConfig.c_config;
import magz.dev.chatrestriction.commands.CR;
import magz.dev.chatrestriction.events.PlayerChatEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import magz.dev.chatrestriction.utilities.message;


public final class ChatRestriction extends JavaPlugin {



    @Override
    public void onEnable() {




        loadConfig();

        PluginManager pm = Bukkit.getPluginManager();


        pm.registerEvents((Listener) new PlayerChatEvent(), this);
        getCommand("cr").setExecutor(new CR());



    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


    public void loadConfig(){
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        c_config.setup();
        c_config.get().options().copyDefaults(true);
        c_config.save();

        message.BroadcastPerms((c_config.get().getString("plugin.prefix") + c_config.get().getString("messages.start_msg")),c_config.get().getString("plugin.permission.admin"));


    }


}
