package cool.muyucloud.potbreaker.tunnel;

import cool.muyucloud.tunnel.McTunnel;

public abstract class McItemUsageContext implements McTunnel {
    public static McItemUsageContext TUNNEL;

    public abstract McItemUsageContext of(McWorld mcWorld, McPlayerEntity mcPlayer, McHand mcHand, McItemStack mcStack, McBlockHitResult mcResult);
}
