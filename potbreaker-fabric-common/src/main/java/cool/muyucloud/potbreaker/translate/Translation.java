package cool.muyucloud.potbreaker.translate;

import java.util.HashMap;

public class Translation {
    private final HashMap<String, String> map;

    public Translation(HashMap<String, String> map) {
        this.map = map;
    }

    public String translate(String key) {
        return this.map.get(key);
    }
}
