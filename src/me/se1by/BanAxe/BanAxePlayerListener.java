package me.se1by.BanAxe;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerListener;


public class BanAxePlayerListener extends PlayerListener{

public BanAxe plugin;
public BanAxePlayerListener(BanAxe BanAxe) {
plugin = BanAxe;
}

    
    public void onPlayerInteractPlayer(PlayerInteractEntityEvent event) {

            Player admin = event.getPlayer();
            Entity user = event.getRightClicked();
            
          
            if(plugin.hasEntry(admin)) {
            if (BanAxe.Active(admin)){   
            if (admin.getItemInHand().getTypeId() == 258) {

                    if(user instanceof Player){
                    		
                    	admin.getWorld().strikeLightning(user.getLocation());
                            admin.sendMessage(ChatColor.DARK_BLUE + "[BanAxe] " + ChatColor.RED + "You banned " + ((Player) user).getName());
                            ((Player) user).kickPlayer("You got banned by " + admin.getName());
                            ((Player) user).setBanned(true);
                            System.out.println("[BanAxe] " + admin.getName() + " banned " + user);
                    }
                            else{
                     admin.sendMessage(ChatColor.DARK_BLUE + "[BanAxe] "+ ChatColor.RED + "Click on a user!");
                    
                    }
                }
            }
        }
        else
        {
        	admin.sendMessage("Fail");
            BanAxe.hm.put(admin.getName(), false);
        }
    }
}


