package cool.muyucloud.potbreaker.tunnel;

import cool.muyucloud.tunnel.McTunnel;

public abstract class McIdentifier implements McTunnel {
    public static McIdentifier IDENTIFIER;

    public abstract McIdentifier tryParse(String id);
}
