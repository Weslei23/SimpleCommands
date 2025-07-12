package com.wsdev.simpleCommands;

import com.wsdev.simpleCommands.Commands.FlyCommand;
import com.wsdev.simpleCommands.Commands.SiteCommand;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class SimpleCommands extends JavaPlugin
{
    private static FileConfiguration config;

    @Override
    public void onEnable()
    {
        getLogger().info( "Simple Commands Enabled" );

        saveDefaultConfig();

        config = getConfig();

        getCommand( "site" ).setExecutor( new SiteCommand() );
        getCommand( "fly" ).setExecutor( new FlyCommand() );

    }

    @Override
    public void onDisable()
    {
        getLogger().info( "Simple Commands Disabled" );
    }


    public static FileConfiguration getPluginConfig()
    {
        return config;
    }
}
