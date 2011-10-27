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
            String userSimpleName = user.getClass().getSimpleName().toString();
            
            if(plugin.hasEntry(admin))
            {            	
            	if (BanAxe.Active(admin))
            	{            	
            		if (admin.getItemInHand().getTypeId() == BanAxe.banitem)
            		{
            			admin.sendMessage(user.getClass().getSimpleName());
            			
            			if(user instanceof Player)
            			{
            				Player userPlayer = ((Player) user);
            				BanEvent ban = new BanEvent(admin, userPlayer, plugin);
   	
            				admin.getWorld().strikeLightning(user.getLocation());
            				ban.run();  
            			}
            			
                        else
                        {
                        	if(userSimpleName.equalsIgnoreCase("craftcow"))
                        	{
                        		admin.sendMessage(ChatColor.DARK_BLUE + "[BanAxe] "+ ChatColor.RED + "There's no place for more cows!");
                        	}
                        	
                        	else if(userSimpleName.equalsIgnoreCase("craftpig"))
                        	{
                        		admin.sendMessage(ChatColor.DARK_BLUE + "[BanAxe] " + ChatColor.RED + "There is no place for two of us!");
                        	}
                        	
                        	else if(userSimpleName.equalsIgnoreCase("craftchicken"))
                        	{
                        		admin.sendMessage(ChatColor.DARK_BLUE + "[BanAxe] " + ChatColor.RED + "We'll have chicken king for dinner!");
                        	}
                        	
                        	else if(userSimpleName.equalsIgnoreCase("craftsheep"))
                        	{
                        		admin.sendMessage(ChatColor.DARK_BLUE + "[BanAxe] " + ChatColor.RED + "Thanks for your wool!");
                        	}
                        	
                        	else if(userSimpleName.equalsIgnoreCase("craftzombie"))
                        	{
                        		admin.sendMessage(ChatColor.DARK_BLUE + "[BanAxe] " + ChatColor.RED + "Yippee-Ki-Yay, Motherfucker!");
                        	}
                        	
                        	else if(userSimpleName.equalsIgnoreCase("craftskeleton"))
                        	{
                        		admin.sendMessage(ChatColor.DARK_BLUE + "[BanAxe] " + ChatColor.RED + "Any last words?");
                        	}
                        	
                        	else if(userSimpleName.equalsIgnoreCase("craftcreeper"))
                        	{
                        		admin.sendMessage(ChatColor.DARK_BLUE + "[BanAxe] " + ChatColor.RED + "Click click BOOM!");
                        	}
                        	
                        	else if(userSimpleName.equalsIgnoreCase("craftspider"))
                        	{
                        		admin.sendMessage(ChatColor.DARK_BLUE + "[BanAxe] " + ChatColor.RED + "You ran out of strings, spiderman!");
                        	}
                        	
                        	else if(userSimpleName.equalsIgnoreCase("craftcavespider"))
                        	{
                        		admin.sendMessage(ChatColor.DARK_BLUE + "[BanAxe] " + ChatColor.RED + "You ran out of strings, spiderman!");
                        	}
                        	
                        	else if(userSimpleName.equalsIgnoreCase("craftgiant"))
                        	{
                        		admin.sendMessage(ChatColor.DARK_BLUE + "[BanAxe] " + ChatColor.RED + "Dammit Hagrid!");
                        	}
                        	
                        	else if(userSimpleName.equalsIgnoreCase("craftsilverfish"))
                        	{
                        		admin.sendMessage(ChatColor.DARK_BLUE + "[BanAxe] " + ChatColor.RED + "Die little rats!");
                        	}
                        	
                        	else if(userSimpleName.equalsIgnoreCase("craftslime"))
                        	{
                        		admin.sendMessage(ChatColor.DARK_BLUE + "[BanAxe] " + ChatColor.RED + "Jelly for dessert?");
                        	}
                        	
                        	else if(userSimpleName.equalsIgnoreCase("craftghast"))
                        	{
                        		admin.sendMessage(ChatColor.DARK_BLUE + "[BanAxe] " + ChatColor.RED + "Next stop: HELL!");
                        	}
                        	
                        	else if(userSimpleName.equalsIgnoreCase("craftmonster"))
                        	{
                        		admin.sendMessage(ChatColor.DARK_BLUE + "[BanAxe] " + ChatColor.RED + "I'm unique!");
                        	}
                        	
                        	else if(userSimpleName.equalsIgnoreCase("craftpigzombie"))
                        	{
                        		admin.sendMessage(ChatColor.DARK_BLUE + "[BanAxe] " + ChatColor.RED + "Back to the nether!");
                        	}
                        	
                        	else if(userSimpleName.equalsIgnoreCase("craftsquid"))
                        	{
                        		admin.sendMessage(ChatColor.DARK_BLUE + "[BanAxe] " + ChatColor.RED + "The clarinet calls!");
                        	}
                        	
                        	else if(userSimpleName.equalsIgnoreCase("craftwolf"))
                        	{
                        		admin.sendMessage(ChatColor.DARK_BLUE + "[BanAxe] " + ChatColor.RED + "I won't dance with you!");
                        	}
                        	
                        	else if(userSimpleName.equalsIgnoreCase("craftenderman"))
                        	{
                        		admin.sendMessage(ChatColor.DARK_BLUE + "[BanAxe] " + ChatColor.RED + "That's MY block!");
                        	}
                        	user.remove();
                        }
            		}
            		
            		else if (admin.getItemInHand().getTypeId() == BanAxe.mcbanitem)
            		{
            			if(user instanceof Player)
            			{
            				Player userPlayer = ((Player) user);
            				MCBanEvent ban = new MCBanEvent(admin, userPlayer, plugin, BanAxe.reason);
   	
            				admin.getWorld().strikeLightning(user.getLocation());
            				ban.run();  
            			}
            			
                        else
                        {
                        	if(userSimpleName.equalsIgnoreCase("craftcow"))
                        	{
                        		admin.sendMessage(ChatColor.DARK_BLUE + "[BanAxe] "+ ChatColor.RED + "There's no place for more cows!");
                        	}
                        	
                        	else if(userSimpleName.equalsIgnoreCase("craftpig"))
                        	{
                        		admin.sendMessage(ChatColor.DARK_BLUE + "[BanAxe] " + ChatColor.RED + "There is no place for two of us!");
                        	}
                        	
                        	else if(userSimpleName.equalsIgnoreCase("craftchicken"))
                        	{
                        		admin.sendMessage(ChatColor.DARK_BLUE + "[BanAxe] " + ChatColor.RED + "We'll have chicken king for dinner!");
                        	}
                        	
                        	else if(userSimpleName.equalsIgnoreCase("craftsheep"))
                        	{
                        		admin.sendMessage(ChatColor.DARK_BLUE + "[BanAxe] " + ChatColor.RED + "Thanks for your wool!");
                        	}
                        	
                        	else if(userSimpleName.equalsIgnoreCase("craftzombie"))
                        	{
                        		admin.sendMessage(ChatColor.DARK_BLUE + "[BanAxe] " + ChatColor.RED + "Yippee-Ki-Yay, Motherfucker!");
                        	}
                        	
                        	else if(userSimpleName.equalsIgnoreCase("craftskeleton"))
                        	{
                        		admin.sendMessage(ChatColor.DARK_BLUE + "[BanAxe] " + ChatColor.RED + "Any last words?");
                        	}
                        	
                        	else if(userSimpleName.equalsIgnoreCase("craftcreeper"))
                        	{
                        		admin.sendMessage(ChatColor.DARK_BLUE + "[BanAxe] " + ChatColor.RED + "Click click BOOM!");
                        	}
                        	
                        	else if(userSimpleName.equalsIgnoreCase("craftspider"))
                        	{
                        		admin.sendMessage(ChatColor.DARK_BLUE + "[BanAxe] " + ChatColor.RED + "You ran out of strings, spiderman!");
                        	}
                        	
                        	else if(userSimpleName.equalsIgnoreCase("craftcavespider"))
                        	{
                        		admin.sendMessage(ChatColor.DARK_BLUE + "[BanAxe] " + ChatColor.RED + "You ran out of strings, spiderman!");
                        	}
                        	
                        	else if(userSimpleName.equalsIgnoreCase("craftgiant"))
                        	{
                        		admin.sendMessage(ChatColor.DARK_BLUE + "[BanAxe] " + ChatColor.RED + "Dammit Hagrid!");
                        	}
                        	
                        	else if(userSimpleName.equalsIgnoreCase("craftsilverfish"))
                        	{
                        		admin.sendMessage(ChatColor.DARK_BLUE + "[BanAxe] " + ChatColor.RED + "Die little rats!");
                        	}
                        	
                        	else if(userSimpleName.equalsIgnoreCase("craftslime"))
                        	{
                        		admin.sendMessage(ChatColor.DARK_BLUE + "[BanAxe] " + ChatColor.RED + "Jelly for dessert?");
                        	}
                        	
                        	else if(userSimpleName.equalsIgnoreCase("craftghast"))
                        	{
                        		admin.sendMessage(ChatColor.DARK_BLUE + "[BanAxe] " + ChatColor.RED + "Next stop: HELL!");
                        	}
                        	
                        	else if(userSimpleName.equalsIgnoreCase("craftmonster"))
                        	{
                        		admin.sendMessage(ChatColor.DARK_BLUE + "[BanAxe] " + ChatColor.RED + "I'm unique!");
                        	}
                        	
                        	else if(userSimpleName.equalsIgnoreCase("craftpigzombie"))
                        	{
                        		admin.sendMessage(ChatColor.DARK_BLUE + "[BanAxe] " + ChatColor.RED + "Back to the nether!");
                        	}
                        	
                        	else if(userSimpleName.equalsIgnoreCase("craftsquid"))
                        	{
                        		admin.sendMessage(ChatColor.DARK_BLUE + "[BanAxe] " + ChatColor.RED + "The clarinet calls!");
                        	}
                        	
                        	else if(userSimpleName.equalsIgnoreCase("craftwolf"))
                        	{
                        		admin.sendMessage(ChatColor.DARK_BLUE + "[BanAxe] " + ChatColor.RED + "I won't dance with you!");
                        	}
                        	
                        	else if(userSimpleName.equalsIgnoreCase("craftenderman"))
                        	{
                        		admin.sendMessage(ChatColor.DARK_BLUE + "[BanAxe] " + ChatColor.RED + "That's MY block!");
                        	}
                        	user.remove();
                        }
            		}
            	}
            }
       
    }
}


