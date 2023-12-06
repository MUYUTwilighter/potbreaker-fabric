package cool.muyucloud.potbreaker.tunnel;

import cool.muyucloud.tunnel.McTunnel;

import java.io.Serializable;
import java.nio.file.Path;
import java.util.HashSet;

public abstract class Config implements Serializable, McTunnel {
    public static Path CONFIG_PATH = Path.of("pot_breaker.json");
    public static Config CONFIG;

    private Boolean onBreak = true;
    private Boolean onProject = true;
    private Boolean redstone = true;
    private Integer maxUses = 1;
    private String lang = "en_us.json";
    private HashSet<String> whitelist = null;

    public Boolean allowOnBreak() {
        return onBreak;
    }

    public Boolean allowOnProject() {
        return onProject;
    }

    public Boolean requireRedstone() {
        return redstone;
    }

    public Integer getMaxUses() {
        return maxUses;
    }

    public HashSet<String> getWhitelist() {
        return whitelist;
    }

    public String getLang() {
        return lang;
    }

    public abstract void load();
}
