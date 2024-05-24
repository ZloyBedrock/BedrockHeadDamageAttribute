package ru.bedrockdev.bedrockheaddamageattribute;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

public class Listener implements org.bukkit.event.Listener {

    @EventHandler
    public void onCrystalDamage(EntityDamageByEntityEvent e) {

        if (e.getDamager().getType() == EntityType.ENDER_CRYSTAL && e.getEntity() instanceof Player) {

            Player player = (Player) e.getEntity();
            ItemStack itemStack = player.getInventory().getItemInOffHand();
            if (itemStack.getItemMeta().hasAttributeModifiers() && itemStack.getType() == Material.PLAYER_HEAD) {

                int multiple = BedrockHeadDamageAttribute.getInstance().getConfig().getInt("damage_resistance_percent")/100;
                double damage = e.getDamage()*multiple;
                e.setDamage(damage);


            }

        }

    }

}
