package cool.muyucloud.potbreaker.tunnel;

import com.mojang.brigadier.context.CommandContext;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.MutableText;

public class ServerCommandContextImpl extends ServerCommandContext {
    private CommandContext<ServerCommandSource> serverCommandContext;

    public static ServerCommandContext of(CommandContext<ServerCommandSource> serverCommandContext) {
        ServerCommandContextImpl mcServerCommandContext = new ServerCommandContextImpl();
        mcServerCommandContext.serverCommandContext = serverCommandContext;
        return mcServerCommandContext;
    }

    @Override
    public void sendMessage(McMutableText mcText) {
        MutableText text = (MutableText) mcText.get();
        serverCommandContext.getSource().sendMessage(text);
    }

    @Override
    public Object get() {
        return serverCommandContext;
    }

    @Override
    public void initTunnel() {
    }
}
