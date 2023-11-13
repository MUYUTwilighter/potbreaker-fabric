package cool.muyucloud.potbreaker.tunnel;

import cool.muyucloud.tunnel.McTunnel;

public interface McItemStack extends McTunnel {
    void useOnBlock(McItemUsageContext context);
}
