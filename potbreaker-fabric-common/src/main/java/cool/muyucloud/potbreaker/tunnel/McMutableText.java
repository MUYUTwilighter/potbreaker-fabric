package cool.muyucloud.potbreaker.tunnel;

import cool.muyucloud.tunnel.McTunnel;

public abstract class McMutableText implements McTunnel {
    public static McMutableText MC_TEXT;

    public abstract McMutableText of(String content);
}
