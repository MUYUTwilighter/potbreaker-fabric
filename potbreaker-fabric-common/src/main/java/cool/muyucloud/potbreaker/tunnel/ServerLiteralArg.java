package cool.muyucloud.potbreaker.tunnel;

import cool.muyucloud.tunnel.McTunnel;

public abstract class ServerLiteralArg implements McTunnel {
    public static ServerLiteralArg SERVER_LITERAL_ARG;

    public abstract ServerLiteralArg of(String name);

    public abstract ServerLiteralArg then(ServerLiteralArg mcArg);

    public abstract ServerLiteralArg execute(Runnable runnable);

    public abstract void register();
}
