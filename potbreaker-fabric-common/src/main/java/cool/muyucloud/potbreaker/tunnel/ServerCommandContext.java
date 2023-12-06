package cool.muyucloud.potbreaker.tunnel;

import cool.muyucloud.tunnel.McTunnel;

public abstract class ServerCommandContext implements McTunnel {
    public abstract void sendMessage(McMutableText mcText);
}
