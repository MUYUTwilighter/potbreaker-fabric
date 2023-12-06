package cool.muyucloud.potbreaker.tunnel;

import cool.muyucloud.tunnel.McTunnel;

import java.util.Collection;

public abstract class Translator implements McTunnel {
    public static Translator TRANSLATOR;

    static final String LANG_DIR = "assets/pot_breaker/lang";

    public abstract void load(ClassLoader loader);

    public abstract String translate(String key);

    public abstract Collection<String> getLangs();
}
