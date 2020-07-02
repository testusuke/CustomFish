package net.testusuke.open.customfish

import org.bukkit.generator.ChunkGenerator
import org.bukkit.plugin.java.JavaPlugin

/**
 * Created on 2020/07/02
 * Author testusuke
 */
class Main: JavaPlugin() {

    companion object{
        lateinit var plugin:Main
        var enable = false
        var prefix = "§e[§aCustom§bFish§e]§f"

    }

    override fun onEnable() {
        //  instance
        plugin = this
        //  Logger

        //  Command
        getCommand("cf")?.setExecutor(Command)
        //  EventListener
        val pm = server.pluginManager
        pm.registerEvents(FishingEvent,this)


    }

    override fun onDisable() {

    }
}