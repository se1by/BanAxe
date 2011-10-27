package me.se1by.BanAxe;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerListener;


public class BanAxePlayerListener extends PlayerListener
{
	public BanAxe plugin;
	public BanAxePlayerListener(BanAxe BanAxe)
	{
		plugin = BanAxe;
	}


    
    public void onPlayerInteractEntity(PlayerInteractEntityEvent event)
    {
            Player admin = event.getPlayer();
            Entity user = event.getRightClicked();
            
            if(plugin.hasEntry(admin))
            {            	
            	if (BanAxe.Active(admin))
            	{            	
            		if (admin.getItemInHand().getTypeId() == 258)
            		{
            			if(user instanceof Player)
            			{
            				Player userPlayer = ((Player) user);
            				BanEvent ban = new BanEvent(admin, userPlayer, plugin);
   	
            				admin.getWorld().strikeLightning(user.getLocation());
            				ban.run();  
            			}
            			
                        else
                        {
                        	admin.sendMessage(ChatColor.DARK_BLUE + "[BanAxe] "+ ChatColor.RED + "Click on a user!");
                        }
            		}
            	}
            }
       
    }
}


