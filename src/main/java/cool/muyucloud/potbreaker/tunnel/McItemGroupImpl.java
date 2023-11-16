package cool.muyucloud.potbreaker.tunnel;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class McItemGroupImpl extends McItemGroup {
    ItemGroup itemGroup;

    public static McItemGroup of(ItemGroup itemGroup) {
        McItemGroupImpl mcItemGroup = new McItemGroupImpl();
        mcItemGroup.itemGroup = itemGroup;
        return mcItemGroup;
    }

    @Override
    public Object get() {
        return itemGroup;
    }

    @Override
    public Boolean contains(McItemStack mcStack) {
        ItemStack stack = (ItemStack) mcStack.get();
        return itemGroup.contains(stack);
    }

    @Override
    public void initTunnel() {

    }
}
