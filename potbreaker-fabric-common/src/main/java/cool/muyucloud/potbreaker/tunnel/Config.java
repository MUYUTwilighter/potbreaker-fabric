package cool.muyucloud.potbreaker.tunnel;

import com.google.gson.Gson;
import cool.muyucloud.tunnel.McTunnel;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.HashSet;

public abstract class Config implements Serializable, McTunnel {
    public static Path CONFIG_PATH = Path.of("pot_breaker.json");
    public static Config INSTANCE;

    private Boolean use = false;

    private Boolean place = true;
    private Integer maxExecutes = 1;
    private HashSet<String> whitelist = new HashSet<>();

    public Boolean canUse() {
        return use;
    }

    public Boolean canPlace() {
        return place;
    }

    public Integer getMaxExecutes() {
        return maxExecutes;
    }

    public HashSet<String> getWhitelist() {
        return whitelist;
    }
}
