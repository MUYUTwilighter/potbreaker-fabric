package cool.muyucloud.potbreaker;

import cool.muyucloud.tunnel.TunnelInitializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.mixin.dimension.EntityMixin;
import net.fabricmc.fabric.mixin.event.lifecycle.WorldMixin;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PotBreaker implements ModInitializer {
    public static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void onInitialize() {
        TunnelInitializer.init(PotBreaker.class);
    }
}
