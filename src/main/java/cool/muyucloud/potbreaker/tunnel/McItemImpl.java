package cool.muyucloud.potbreaker.tunnel;

import net.minecraft.item.Item;

public class McItemImpl extends McItem {
    Item item;

    public static McItem of(Item item) {
        if (item == null) {
            return null;
        }
        McItemImpl mcItem = new McItemImpl();
        mcItem.item = item;
        return mcItem;
    }

    @Override
    public Object get() {
        return item;
    }

    @Override
    public void initTunnel() {

    }
}
