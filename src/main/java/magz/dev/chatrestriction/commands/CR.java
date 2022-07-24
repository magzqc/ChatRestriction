package magz.dev.chatrestriction.commands;

import magz.dev.chatrestriction.CustomConfig.c_config;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;

public class CR implements CommandExecutor{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        if (sender instanceof Player){
            Player p = (Player) sender;

            if (!p.hasPermission(c_config.get().getString("plugin.permission.admin"))) {
                p.sendMessage(c_config.get().getString("plugin.prefix") + c_config.get().getString("messages.no_perm"));
                return true;
            }

            if (args.length == 0) {
                return false;
            } else {

                switch (args[0]) {
                    case "set":

                        if (c_config.get().getString(args[1]) != null) {

                            try {
                                c_config.setString(args[1], ChatColor.translateAlternateColorCodes('&',args[2]));
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            p.sendMessage(c_config.get().getString("plugin.prefix") + c_config.get().getString("messages.succesfully_changed") + args[1] + " -> " + c_config.get().getString(args[1]));
                            c_config.reload();
                        }
                        break;

                    case "reload":
                        p.sendMessage(c_config.get().getString("plugin.prefix") + c_config.get().getString("messages.reload_msg"));
                        c_config.reload();
                        break;


                    default:
                        p.sendMessage("/cr set <path> <key>");
                        p.sendMessage("/cr reload");

                        break;

                }



            }






        }






    return true;

    }
}
