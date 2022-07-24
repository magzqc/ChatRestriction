package magz.dev.chatrestriction.utilities;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class message {

   public static void BroadcastPerms(String message ,String permission){

       for (Player p : Bukkit.getOnlinePlayers()){

           if (p.hasPermission(permission)){
               p.sendMessage(message);
           }

       }

    }


}
