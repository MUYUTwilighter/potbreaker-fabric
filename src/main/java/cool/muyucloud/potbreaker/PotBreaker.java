package cool.muyucloud.potbreaker;

import cool.muyucloud.tunnel.TunnelInitializer;
import net.fabricmc.api.ModInitializer;
import net.minecraft.text.TranslatableTextContent;

public class PotBreaker implements ModInitializer {
    @Override
    public void onInitialize() {
        Object
        TranslatableTextContent content = new TranslatableTextContent("", "", );
        TunnelInitializer.init(PotBreaker.class);
    }
}
