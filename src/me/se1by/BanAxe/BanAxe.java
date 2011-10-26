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
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public class BanAxe extends JavaPlugin {
	
	 Logger log = Logger.getLogger("Minecraft");
	 Logger log1 = Logger.getLogger("BanAxe");
	

	
static HashMap<String, Boolean>hm = new HashMap<String, Boolean>();
	
private final BanAxePlayerListener playerListener = new BanAxePlayerListener(this);

static boolean enabled = false;

	
	@Override
	public void onDisable() {

		System.out.println("[BanAxe] disabled");
	}

	@Override
	public void onEnable() {
		
		  
		  
		System.out.println("[BanAxe] enabled");
		
		PluginManager pm = getServer().getPluginManager();
		
		pm.registerEvent(Event.Type.PLAYER_INTERACT_ENTITY, this.playerListener, Priority.Normal, this);
		
		
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		boolean succeed = false;
		
		
		
		if(sender instanceof Player)
			{
				Player player = (Player) sender;
				
				if (cmd.getName().equalsIgnoreCase("banaxe"))
				{
				
				
				if (args[0].equalsIgnoreCase("enable"))
						{
					
					hm.put(sender.getName(), true);
					succeed = true;
					sender.sendMessage(ChatColor.DARK_BLUE + "[BanAxe] " + ChatColor.RED + "enabled");
					
						}
				if (args[0].equalsIgnoreCase("disable"))
					{
					hm.put(sender.getName(), false);
					sender.sendMessage(ChatColor.DARK_BLUE + "[BanAxe] " + ChatColor.RED + "disabled");
					}
				}
		}

		
			
		
	return succeed;
		
		
}
	public static Boolean Active(Player player) {

		return hm.get(player.getName());
		}
	
	public boolean hasEntry(Player player) {
		return hm.containsKey(player.getName());
	}
}
	

