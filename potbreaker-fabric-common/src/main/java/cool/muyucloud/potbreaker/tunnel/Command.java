package cool.muyucloud.potbreaker.tunnel;

import cool.muyucloud.tunnel.McTunnel;

import static cool.muyucloud.potbreaker.tunnel.Config.CONFIG;
import static cool.muyucloud.potbreaker.tunnel.McMutableText.MC_TEXT;
import static cool.muyucloud.potbreaker.tunnel.ServerLiteralArg.SERVER_LITERAL_ARG;
import static cool.muyucloud.potbreaker.tunnel.Translator.TRANSLATOR;

public abstract class Command implements McTunnel {
    public static void register() {
        ServerLiteralArg root = SERVER_LITERAL_ARG.of("potbreaker");
        ServerLiteralArg load = SERVER_LITERAL_ARG.of("load");
        load.execute(Command::executeLoad);
        root.then(load);
        root.register();
    }

    private static boolean executeLoad(ServerCommandContext context) {
        CONFIG.load();
        String content = TRANSLATOR.translate("potbreaker.command.potbreaker.load.success");
        McMutableText text = MC_TEXT.of(content);
        context.sendMessage(text);
        return true;
    }
}
