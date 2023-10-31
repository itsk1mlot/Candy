package io.github.itsk1mlot.candy

import io.github.itsk1mlot.candy.event.BlockBreak
import org.bukkit.plugin.java.JavaPlugin

class Main: JavaPlugin() {
    // MAIN INSTANCE
    companion object{
        lateinit var instance: Main
    }
    init {
        instance = this
    }

    override fun onEnable() {
        println("Candy가 활성화되었습니다.")
        saveDefaultConfig()
        server.pluginManager.registerEvents(BlockBreak(), this)
    }

    override fun onDisable() {
        println("Candy가 비활성화됩니다.")
    }
}