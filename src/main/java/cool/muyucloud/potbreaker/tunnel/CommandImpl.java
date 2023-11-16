package cool.muyucloud.potbreaker.tunnel;

import cool.muyucloud.tunnel.annotation.Tunnel;

@Tunnel
public class CommandImpl extends Command {
    @Override
    public Object get() {
        return null;
    }

    @Override
    public void initTunnel() {
        register();
    }
}
