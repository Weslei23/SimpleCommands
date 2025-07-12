package com.wsdev.simpleCommands.Commands;

import com.wsdev.simpleCommands.SimpleCommands;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class FlyCommand  implements CommandExecutor
{
    @Override
    public boolean onCommand( @NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings )
    {
        var exigirPermissao = SimpleCommands.getPluginConfig().getBoolean( "Fly.Exigir-Permissao" );
        if( commandSender instanceof Player player )
        {
            if( exigirPermissao && !player.hasPermission( "simpleCommands.fly" ) )
            {
                player.sendMessage( "§e§l[Info]: §7Voce não permissão para executar este comando." );
                return true;
            }

            if ( player.getAllowFlight() == false )
            {
                player.setAllowFlight( true );
                player.setFlying( true );

                player.sendMessage( "§e§l[Info]: §7Fly ativado" );

            }
            else
            {
                player.setAllowFlight( false );
                player.setFlying( false );
                player.sendMessage( "§e§l[Info]: §7Fly desativado" );
            }
        }
        return true;
    }
}
