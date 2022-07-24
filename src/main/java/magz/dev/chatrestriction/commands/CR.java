package magz.dev.chatrestriction.commands;

import magz.dev.chatrestriction.CustomConfig.c_config;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CR implements CommandExecutor{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){
            Player p = (Player) sender;

            if (p.hasPermission("cr.reload")){
                c_config.reload();
                p.sendMessage(c_config.get().getString("plugin.prefix") +  c_config.get().getString("messages.reload_msg") );

            }else {
                p.sendMessage(c_config.get().getString("messages.no_perm"));
            }



            return true;
        }

        c_config.reload();




        return true;

    }
}
