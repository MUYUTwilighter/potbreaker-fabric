package cool.muyucloud.potbreaker.tunnel;

import com.google.gson.Gson;
import cool.muyucloud.tunnel.annotation.Tunnel;
import net.fabricmc.loader.api.FabricLoader;

import java.io.*;
import java.nio.charset.StandardCharsets;

@Tunnel
public class ConfigImpl extends Config {
    @Override
    public Object get() {
        return null;
    }

    @Override
    public void initTunnel() {
        CONFIG_PATH = FabricLoader.getInstance().getConfigDir().resolve(CONFIG_PATH);
        INSTANCE = new ConfigImpl();
        this.load();
    }

    private void load() {
        Gson gson = new Gson();
        try {
            File file = CONFIG_PATH.toFile();
            if (file.exists()) {
                InputStream stream = new FileInputStream(file);
                InputStreamReader reader = new InputStreamReader(stream);
                INSTANCE = gson.fromJson(reader, ConfigImpl.class);
                stream.close();
            } else {
                boolean createResult = file.createNewFile();
                if (!createResult) {
                    return;
                }
                OutputStream stream = new FileOutputStream(file);
                byte[] json = gson.toJson(INSTANCE).getBytes(StandardCharsets.UTF_8);
                stream.write(json);
                stream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
