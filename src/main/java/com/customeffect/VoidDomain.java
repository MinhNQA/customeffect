package com.customeffect;

import net.advancedplugins.ae.api.AdvancedEffect;
import net.advancedplugins.ae.api.EffectActivationEvent;
import org.bukkit.*;
import org.bukkit.entity.*;

public class VoidDomain extends AdvancedEffect {

    public VoidDomain(JavaPlugin plugin) {
        super(plugin, "void_domain", "Void Domain", "Damages and shows breath", 1);
    }

    @Override
    public boolean executeEffect(ExecutionTask task, LivingEntity user, String[] args) {
        if (!(user instanceof Player)) return false;

        Location loc = user.getLocation();
        World world = loc.getWorld();

        for (Entity e : world.getNearbyEntities(loc, 2.5, 2.5, 2.5)) {
            if (e instanceof LivingEntity && !e.equals(user)) {
                ((LivingEntity) e).damage(4.0, user);
                world.spawnParticle(Particle.DRAGON_BREATH, e.getLocation().add(0, 1, 0), 30, 0.3, 0.3, 0.3, 0);
            }
        }

        return true;
    }
}
