package cool.muyucloud.potbreaker;

import cool.muyucloud.tunnel.TunnelInitializer;
import net.fabricmc.api.ModInitializer;

public class PotBreaker implements ModInitializer {
    @Override
    public void onInitialize() {
        TunnelInitializer.init(PotBreaker.class);
    }
}
