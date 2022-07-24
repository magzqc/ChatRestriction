package magz.dev.chatrestriction.events;

import magz.dev.chatrestriction.CustomConfig.c_config;
import magz.dev.chatrestriction.utilities.cooldown;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class PlayerChatEvent implements Listener {

    public List<Player> onCD = new ArrayList<Player>();


    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {

        Player p = event.getPlayer();

         if (p.hasPermission(c_config.get().getString("plugin.permission.bypass"))){
             return;
         }

        cooldown d = new cooldown();
        d.setCooldown_list(onCD);

        if (onCD.contains(p)){
            p.sendMessage(c_config.get().getString("messages.on_cooldown"));
             event.setCancelled(true);
         } else {
            onCD.add(p);
            d.setPlayer(p);
            new Thread(d).start();
        }


    }



}
