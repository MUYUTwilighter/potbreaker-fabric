package cool.muyucloud.potbreaker.tunnel;

import cool.muyucloud.tunnel.McTunnel;

import java.util.function.Predicate;

public abstract class ServerLiteralArg implements McTunnel {
    public static ServerLiteralArg SERVER_LITERAL_ARG;

    public abstract ServerLiteralArg of(String name);

    public abstract ServerLiteralArg then(ServerLiteralArg mcArg);

    public abstract ServerLiteralArg execute(Predicate<ServerCommandContext> predicate);

    public abstract void register();
}
