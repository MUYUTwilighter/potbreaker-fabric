package cool.muyucloud.potbreaker.tunnel;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import cool.muyucloud.tunnel.annotation.Tunnel;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;

@Tunnel
public class ServerLiteralArgImpl extends ServerLiteralArg {
    LiteralArgumentBuilder<ServerCommandSource> arg;

    public static ServerLiteralArg of(LiteralArgumentBuilder<ServerCommandSource> arg) {
        ServerLiteralArgImpl mcArg = new ServerLiteralArgImpl();
        mcArg.arg = arg;
        return mcArg;
    }

    @Override
    public ServerLiteralArg of(String name) {
        LiteralArgumentBuilder<ServerCommandSource> arg = CommandManager.literal(name);
        return of(arg);
    }

    @Override
    public ServerLiteralArg then(ServerLiteralArg mcArg) {
        LiteralArgumentBuilder<ServerCommandSource> arg = (LiteralArgumentBuilder<ServerCommandSource>) mcArg.get();
        this.arg = this.arg.then(arg);
        return this;
    }

    @Override
    public ServerLiteralArg execute(Runnable runnable) {
        this.arg.executes(context -> {
            runnable.run();
            return 1;
        });
        return this;
    }

    @Override
    public Object get() {
        return arg;
    }

    @Override
    public void register() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> dispatcher.register(this.arg));
    }

    @Override
    public void initTunnel() {
        SERVER_LITERAL_ARG = new ServerLiteralArgImpl();
    }
}
