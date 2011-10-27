package me.se1by.BanAxe;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class BanEvent
{
	private Player admin;
	private Player user;
	private BanAxe plugin;

	public BanEvent(Player admin, Player user, BanAxe plugin)
	{
		this.admin = admin;
		this.user = user;
		this.plugin = plugin;
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
				admin.performCommand("ban " + userplayer.getName());
				System.out.println("[BanAxe] " + admin.getName() + " banned " + userplayer.getName());
			}
		}
		, 40L);
	}
}
