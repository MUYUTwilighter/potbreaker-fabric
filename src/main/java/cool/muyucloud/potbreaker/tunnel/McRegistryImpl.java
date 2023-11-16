package cool.muyucloud.potbreaker.tunnel;

import cool.muyucloud.tunnel.McTunnel;
import cool.muyucloud.tunnel.annotation.Tunnel;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

@Tunnel
public class McRegistryImpl<T> extends McRegistry<T> {
    Registry<T> registry;

    public static <T> McRegistryImpl<T> of(Registry<T> registry) {
        McRegistryImpl<T> mcRegistry = new McRegistryImpl<>();
        mcRegistry.registry = registry;
        return mcRegistry;
    }

    @Override
    public Object get() {
        return null;
    }

    @Override
    public void initTunnel() {
        ITEM = of(Registries.ITEM);
        ITEM_GROUP = of(Registries.ITEM_GROUP);
    }

    @Nullable
    @Override
    public McTunnel get(McIdentifier mcId) {
        Identifier id = (Identifier) mcId.get();
        T t = registry.get(id);
        if (t instanceof Item item) {
            return McItemImpl.of(item);
        } else if (t instanceof ItemGroup itemGroup) {
            return McItemGroupImpl.of(itemGroup);
        }
        return null;
    }
}
