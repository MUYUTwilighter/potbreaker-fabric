package cool.muyucloud.potbreaker.tunnel;

import cool.muyucloud.tunnel.McTunnel;

public abstract class McBlockHitResult implements McTunnel {
    public static McBlockHitResult TUNNEL;

    public abstract McBlockHitResult of(McVec3d mcPos, McDirection mcSide, McBlockPos mcBlockPos, boolean insideBlock);
}
