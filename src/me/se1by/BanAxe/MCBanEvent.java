package me.se1by.BanAxe;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class MCBanEvent
{
	private Player admin;
	private Player user;
	private BanAxe plugin;
	private String reason;

	public MCBanEvent(Player admin, Player user, BanAxe plugin, String reason)
	{
		this.admin = admin;
		this.user = user;
		this.plugin = plugin;
		this.reason = reason;
	}

	public void run()
	{
		plugin.getServer().getScheduler().scheduleAsyncDelayedTask(plugin, new Runnable()
		{
			@Override
			public void run()
			{
				String adminname = admin.getName();
				Player userplayer = ((Player) user);
				admin.sendMessage(ChatColor.DARK_BLUE + "[BanAxe] " + ChatColor.RED + "You banned " + userplayer.getName());
				userplayer.kickPlayer("You got banned by " + adminname);
				admin.performCommand("ban g " + userplayer.getName() + " " + reason);
				System.out.println("[BanAxe] " + admin.getName() + " banned " + userplayer.getName());
			}
		}
		, 40L);
	}
}
