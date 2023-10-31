package io.github.itsk1mlot.candy.event

import io.github.itsk1mlot.candy.Main
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.inventory.ItemStack
import kotlin.random.Random

class BlockBreak: Listener {

    val random = Random(258388)
    val percent = Main.instance.config.getInt("percent")
    val percentFormat = "0.$percent".toDouble()
    val message = Main.instance.config.getString("message").toString()

    @EventHandler
    fun blockBreak(event: BlockBreakEvent) {
        if (event.block.type.isBlock) {
            if (random.nextDouble() <= percentFormat) {
                val count = random.nextInt(6)
                event.player.world.dropItemNaturally(event.block.location, ItemStack(Material.COOKIE, count))
                event.player.sendMessage(message)
            }
        }
    }
}