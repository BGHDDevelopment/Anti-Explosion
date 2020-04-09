package me.noodles.antiexplosion;

import org.bukkit.event.*;
import org.bukkit.event.entity.*;

public class Events implements Listener
{
    
    @EventHandler
    public void onExplosionPrimeEvent(final ExplosionPrimeEvent e) {
        e.setCancelled(true);
    }
    
    @EventHandler
    public void onEntityExplodeEvent(final EntityExplodeEvent e) {
        e.setCancelled(true);
    }
}
