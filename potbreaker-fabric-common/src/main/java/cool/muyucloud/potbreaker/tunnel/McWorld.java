package cool.muyucloud.potbreaker.tunnel;

import cool.muyucloud.tunnel.McTunnel;

public interface McWorld extends McTunnel {
    Boolean isClient();

    McBlockEntity getBlockEntity(McBlockPos mcPos);
}
