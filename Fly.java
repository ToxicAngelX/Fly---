package me.toxiccoder.me.toxiccoder.Me.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Fly implements CommandExecutor {

    private ArrayList<Player> list_of_flying_people = new ArrayList<>();
    private IlluminatiFly plugin;

    public Fly(IlluminatiFly plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;
            String onMessage = plugin.getConfig().getString("on-message");
            String offMessage = plugin.getConfig().getString("off-message");
            if(player.hasPermission("toxic.fly")){
                if (list_of_flying_people.contains(player)){
                    list_of_flying_people.remove(player);
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', offMessage));
                    player.setAllowFlight(false);
                }else if(!list_of_flying_people.contains(player)){
                    list_of_flying_people.add(player);
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', onMessage));
                    player.setAllowFlight(true);
                }
            }else{
                player.sendMessage(ChatColor.GREEN + "You don't have the " + ChatColor.YELLOW + "toxic.fly " + ChatColor.GREEN + "permission required to use this command.");
            }
        }else{
            System.out.println("You must be a player to fly.");
        }

        return true;
    }
}
