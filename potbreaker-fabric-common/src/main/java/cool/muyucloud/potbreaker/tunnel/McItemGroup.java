package cool.muyucloud.potbreaker.tunnel;

import cool.muyucloud.tunnel.McTunnel;

public abstract class McItemGroup implements McTunnel {
    public abstract Boolean contains(McItemStack mcStack);
}
