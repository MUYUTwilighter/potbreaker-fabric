package cool.muyucloud.potbreaker.tunnel;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import cool.muyucloud.potbreaker.PotBreaker;
import cool.muyucloud.potbreaker.translate.Translation;
import cool.muyucloud.tunnel.annotation.Tunnel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.*;

import static cool.muyucloud.potbreaker.tunnel.Config.CONFIG;

@Tunnel
public class TranslatorImpl extends Translator {
    private HashMap<String, Translation> translations = new HashMap<>();

    @Override
    public void load(ClassLoader loader) {
        List<File> files = getLangFiles(loader);
        Gson gson = new Gson();
        for (File file : files) {
            FileReader reader;
            try {
                reader = new FileReader(file);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            HashMap<String, String> map = gson.fromJson(reader, new TypeToken<HashMap<String, String>>() {}.getType());
            Translation translation = new Translation(map);
            String langName = file.getName();
            this.translations.put(langName, translation);
        }
    }

    private static List<File> getLangFiles(ClassLoader loader) {
        try {
            Enumeration<URL> urlEnum = loader.getResources(LANG_DIR);
            while (urlEnum.hasMoreElements()) {
                String dirName = urlEnum.nextElement().getFile();
                File dir = new File(dirName);
                if (dir.isDirectory()) {
                    File[] files = dir.listFiles();
                    assert files != null;
                    return List.of(files);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return List.of();
    }

    @Override
    public Object get() {
        return null;
    }

    @Override
    public void initTunnel() {
        TRANSLATOR = new TranslatorImpl();
        TRANSLATOR.load(PotBreaker.class.getClassLoader());
    }

    @Override
    public String translate(String key) {
        String lang = CONFIG.getLang();
        Translation translation = translations.get(lang);
        if (translation == null) {
            return "No language named %s".formatted(lang);
        } else {
            return translation.translate(key);
        }
    }

    @Override
    public Collection<String> getLangs() {
        return translations.keySet().stream().toList();
    }
}
