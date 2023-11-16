package cool.muyucloud.potbreaker.tunnel;

import cool.muyucloud.tunnel.McTunnel;

public abstract class McWorld implements McTunnel {
    public abstract Boolean isClient();

    public abstract McBlockEntity getBlockEntity(McBlockPos mcPos);

    public abstract Boolean isReceivingRedstonePower(McBlockPos mcPos);
}
