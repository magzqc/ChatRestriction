package magz.dev.chatrestriction.utilities;

import magz.dev.chatrestriction.CustomConfig.c_config;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class cooldown implements Runnable{

    public Player player1 = null;
    public List<Player> cooldown_list = new ArrayList<>();

    public void setPlayer(Player player){
        player1 = player;
    }

    public void setCooldown_list(List<Player> list){
        this.cooldown_list = list;
    }

    public void run(){
        try {
            try {
                Thread.sleep(c_config.get().getInt("plugin.cooldown") * 1000L);
                cooldown_list.remove(player1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } finally {
            // ?ma
        }
    }


}
