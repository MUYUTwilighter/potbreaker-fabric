package cool.muyucloud.potbreaker.tunnel;

import cool.muyucloud.tunnel.McTunnel;

public abstract class McRegistry<T> implements McTunnel {
    public static McRegistry<?> ITEM;
    public static McRegistry<?> ITEM_GROUP;

    public abstract Object get(McIdentifier identifier);
}
