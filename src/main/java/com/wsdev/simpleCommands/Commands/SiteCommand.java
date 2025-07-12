package com.wsdev.simpleCommands.Commands;

import com.wsdev.simpleCommands.SimpleCommands;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SiteCommand implements CommandExecutor
{
    @Override
    public boolean onCommand( @NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings )
    {
        var exigirPermissao = SimpleCommands.getPluginConfig().getBoolean( "Site.Exigir-Permissao" );
        var mensagem = SimpleCommands.getPluginConfig().getString( "Site.Mensagem" );

        if( commandSender instanceof Player player )
        {
            if ( exigirPermissao && !player.hasPermission( "simplecommands.site" ) )
            {
                player.sendMessage( "§e§l[Info]: §7Voce não tem permissão para executar esse comando." );
                return true;
            }
        }

        commandSender.sendMessage( ChatColor.translateAlternateColorCodes( '&', mensagem ) );

        return true;
    }
}
