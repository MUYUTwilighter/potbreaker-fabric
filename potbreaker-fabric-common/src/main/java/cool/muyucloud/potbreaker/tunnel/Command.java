package cool.muyucloud.potbreaker.tunnel;

import cool.muyucloud.tunnel.McTunnel;

import static cool.muyucloud.potbreaker.tunnel.Config.CONFIG;
import static cool.muyucloud.potbreaker.tunnel.ServerLiteralArg.SERVER_LITERAL_ARG;

public abstract class Command implements McTunnel {
    public static void register() {
        ServerLiteralArg root = SERVER_LITERAL_ARG.of("potbreaker");
        ServerLiteralArg load = SERVER_LITERAL_ARG.of("load");
        load.execute(() -> CONFIG.load());
        root.then(load);
        root.register();
    }
}
