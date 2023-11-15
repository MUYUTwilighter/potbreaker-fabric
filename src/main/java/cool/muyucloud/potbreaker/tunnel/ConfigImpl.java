package cool.muyucloud.potbreaker.tunnel;

import cool.muyucloud.tunnel.annotation.Tunnel;
import net.fabricmc.loader.api.FabricLoader;

@Tunnel
public class ConfigImpl extends Config {
    @Override
    public Object get() {
        return null;
    }

    @Override
    public void initTunnel() {
        CONFIG_PATH = FabricLoader.getInstance().getConfigDir().resolve(CONFIG_PATH);
        INSTANCE = new ConfigImpl();
        this.load();
    }
}
