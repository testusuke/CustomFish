package net.testusuke.open.customfish

import net.testusuke.open.customfish.Main.Companion.enable
import net.testusuke.open.customfish.Main.Companion.prefix
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

/**
 * Created on 2020/07/02
 * Author testusuke
 */
object Command:CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if(sender !is Player || sender.hasPermission(Permission.GENERAL)) return false
        //  empty
        if(args.isEmpty()){
            sendHelp(sender)
            return true
        }
        when(args[0]){
            "help" -> sendHelp(sender)

            //  ADMIN COMMANDS
            //  enable
            "on" -> changeEnable(sender,true)
            "off" -> changeEnable(sender,false)
            //  fish data
            "reload" -> {
                if(args.size == 2){
                    when(args[1]){
                        "config" -> {

                        }
                        "fish" -> {

                        }
                        "all" -> {

                        }
                    }
                }
            }

            else -> sendHelp(sender)
        }
        return false
    }


    private fun changeEnable(sender: Player, mode: Boolean) {
        if (!sender.hasPermission(Permission.ADMIN)) {
            sender.sendMessage("${prefix}§cあなたには権限がありません。")
            return
        }
        if (enable == mode) {
            sender.sendMessage("${prefix}§cすでに§e${mode}§cになっています。")
        } else {
            enable = true
            sender.sendMessage("${prefix}§aプラグインが§e${mode}§aになりました。")
        }
    }

    private fun sendHelp(player: Player) {
        val msg = """
            §e===================================
            §e/cf [help] <- Helpの表示
            
            §c/cf on/off <- プラグインの有効/無効
            §c/cf reload <config,fish,all> <- データを再読み込みします。 
            §c/cf <-
            §c/cf <- 
            §c/cf <- 
            §d§lCreated by testusuke
            §e===================================
        """.trimIndent()
        player.sendMessage(msg)
    }

}