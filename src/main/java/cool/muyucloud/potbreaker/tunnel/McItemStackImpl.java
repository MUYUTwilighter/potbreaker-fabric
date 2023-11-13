package cool.muyucloud.potbreaker.tunnel;

import cool.muyucloud.tunnel.annotation.Tunnel;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;

@Tunnel
public class McItemStackImpl implements McItemStack {
    private ItemStack itemStack;

    public static McItemStackImpl of(ItemStack itemStack) {
        McItemStackImpl mcItemStack = new McItemStackImpl();
        mcItemStack.itemStack = itemStack;
        return mcItemStack;
    }

    @Override
    public Object get() {
        return itemStack;
    }

    @Override
    public void initTunnel() {}

    @Override
    public void useOnBlock(McItemUsageContext mcContext) {
        ItemUsageContext context = (ItemUsageContext) mcContext.get();
        itemStack.useOnBlock(context);
    }
}
