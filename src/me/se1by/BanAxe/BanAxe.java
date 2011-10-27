package me.se1by.BanAxe;


import java.util.HashMap;
import java.util.logging.Logger;

import me.se1by.BanAxe.BanAxePlayerListener;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.Event.Priority;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.nijiko.permissions.PermissionHandler;
import com.nijikokun.bukkit.Permissions.Permissions;


public class BanAxe extends JavaPlugin
{
	Logger log = Logger.getLogger("Minecraft");
	
	static HashMap<String, Boolean>hm = new HashMap<String, Boolean>();
	static HashMap<String, Integer>bantool = new HashMap<String, Integer>();
	static HashMap<String, Integer>mcbantool = new HashMap<String, Integer>();
	
	private final BanAxePlayerListener playerListener = new BanAxePlayerListener(this);
	
	static String reason = "bad boy";

	static boolean enabled = false;
	
	static int banitem = 258;
	static int mcbanitem = 279;
		
	@Override
	public void onDisable()
	{
		System.out.println("[BanAxe] disabled");
	}

	@Override
	public void onEnable()
	{
		setupPermissions();
		
		System.out.println("[BanAxe] enabled");
		
		PluginManager pm = getServer().getPluginManager();
		
		pm.registerEvent(Event.Type.PLAYER_INTERACT_ENTITY, this.playerListener, Priority.Normal, this);
	}
	public static PermissionHandler permissionHandler;
	private void setupPermissions() {
	    if (permissionHandler != null) {
	        return;
	    }
	    
	    Plugin permissionsPlugin = this.getServer().getPluginManager().getPlugin("Permissions");
	    
	    if (permissionsPlugin == null) {
	        System.out.println("[BanAxe] Permission system not detected, defaulting to OP");
	        return;
	    }
	    
	    permissionHandler = ((Permissions) permissionsPlugin).getHandler();
	    System.out.println("[BanAxe] Found and will use plugin "+((Permissions)permissionsPlugin).getDescription().getFullName());
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{  
		
		boolean succeed = false;
				
		if(sender instanceof Player)
		{
			if (cmd.getName().equalsIgnoreCase("banaxe"))
				  if (!BanAxe.permissionHandler.has((Player)sender, "BanAxe.Use")) {
				      return false;
				  }


			{
				if (args.length == 0)
				{
					sender.sendMessage(ChatColor.DARK_BLUE + "[BanAxe] " + ChatColor.RED + "/banaxe help");
				}
				
				else if (args.length == 1)
				{
					if (args[0].equalsIgnoreCase("enable"))
					{
						hm.put(sender.getName(), true);
					
						succeed = true;
					
						sender.sendMessage(ChatColor.DARK_BLUE + "[BanAxe] " + ChatColor.RED + "enabled");
					}
				
					else if (args[0].equalsIgnoreCase("disable"))
					{
						hm.put(sender.getName(), false);
					
						sender.sendMessage(ChatColor.DARK_BLUE + "[BanAxe] " + ChatColor.RED + "disabled");
					}
					
					else if (args[0].equalsIgnoreCase("help"))
					{
						sender.sendMessage(ChatColor.GOLD + "----------------" + ChatColor.DARK_BLUE + "[BanAxe]" + ChatColor.GOLD + "----------------");
						sender.sendMessage(ChatColor.GOLD + "-----" + ChatColor.GREEN + " /banaxe enable " + ChatColor.RED + "to enable BanAxe " + ChatColor.GOLD + "-----");
						sender.sendMessage(ChatColor.GOLD + "----" + ChatColor.GREEN + " /banaxe disable " + ChatColor.RED + "to disable BanAxe " + ChatColor.GOLD + "------");
						sender.sendMessage(ChatColor.GOLD + "---" + ChatColor.GREEN + " /banaxe item ID " + ChatColor.RED + "to set the banitem " + ChatColor.GOLD + "-------");
						sender.sendMessage(ChatColor.GOLD + "--" + ChatColor.GREEN + " /banaxe global ID " + ChatColor.RED + "to set the mcbanitem " + ChatColor.GOLD + "----");
					}
					
					else
					{
						sender.sendMessage(ChatColor.DARK_BLUE + "[BanAxe] " + ChatColor.RED + "Wrong input!");
					}
				}
				
				else if (args.length == 2)
				{
					if (args[0].equalsIgnoreCase("item") && !(args[1] == (null)))
					{
						bantool.put(sender.getName(),Integer.parseInt(args[1]));
						banitem = bantool.get(sender.getName());
						if (mcbanitem == banitem)
						{
							sender.sendMessage(ChatColor.DARK_BLUE + "[BanAxe] " + ChatColor.RED + "Global banitem can't be your banitem!");
							banitem = 258;
						}
						
						else
						{
							sender.sendMessage(ChatColor.DARK_BLUE + "[BanAxe] " + ChatColor.RED + "Banitem set to " + banitem);
						}
					}
				}
				
				else if (args.length == 3)
				{
					 if (args[0].equalsIgnoreCase("global") && !(args[1] == (null)) && !(args[2] == (null)))
					{
						mcbantool.put(sender.getName(),Integer.parseInt(args[1]));
						mcbanitem = mcbantool.get(sender.getName());
						if (mcbanitem == banitem)
						{
							sender.sendMessage(ChatColor.DARK_BLUE + "[BanAxe] " + ChatColor.RED + "Global banitem can't be your banitem!");
							mcbanitem = 279;
						}
						
						else
						{
							reason = args[2];
							sender.sendMessage(ChatColor.DARK_BLUE + "[BanAxe] " + ChatColor.RED + "Global banitem set to " + banitem + ", reason set to " + reason);
						}
					}
				}
				
				else
				{
					sender.sendMessage(ChatColor.DARK_BLUE + "[BanAxe] " + ChatColor.RED + "Wrong input!");
				}
			}
		}
		return succeed;
	}
	
	public static boolean Active(Player player)
	{
		return hm.get(player.getName());
	}
	
	public boolean hasEntry(Player player)
	{
		return hm.containsKey(player.getName());
	}
}
	

