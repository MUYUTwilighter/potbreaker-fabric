package cool.muyucloud.potbreaker.tunnel;

import cool.muyucloud.tunnel.McTunnel;

public interface McBlockPos extends McTunnel {
    McBlockPos down();

    int getX();

    int getY();

    int getZ();
}
