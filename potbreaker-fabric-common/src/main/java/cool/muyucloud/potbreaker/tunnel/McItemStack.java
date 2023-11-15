package cool.muyucloud.potbreaker.tunnel;

import cool.muyucloud.tunnel.McTunnel;

public interface McItemStack extends McTunnel {
    McActionResult useOnBlock(McItemUsageContext context);

    McItemStack use(McWorld mcWorld, McPlayerEntity mcPlayer, McHand mcHand);

    Integer getCount();
}
