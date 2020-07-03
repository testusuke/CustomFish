package net.testusuke.open.customfish

import org.bukkit.enchantments.Enchantment

/**
 * Created on 2020/07/02
 * Author testusuke
 */
data class FishData(
    val fishID:String,  //  識別
    var materialName:String,    //  Upperで保存
    var damageVault:Int, //  damage id. empty=0
    var modelID:Int?,    //  Custom model id
    var name:String,    //  Display name
    var lore:String?,    //  Lore [ @ ]でsplit
    var enchantmentList:MutableMap<Enchantment,Int>?    //  エンチャントとレベル empty=null
)