package cool.muyucloud.potbreaker.tunnel;

import cool.muyucloud.tunnel.annotation.Tunnel;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

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
    public void initTunnel() {
    }

    @Override
    public McActionResult useOnBlock(McItemUsageContext mcContext) {
        ItemUsageContext context = (ItemUsageContext) mcContext.get();
        ActionResult actionResult = itemStack.useOnBlock(context);
        return McActionResultImpl.of(actionResult);
    }

    @Override
    public McItemStack use(McWorld mcWorld, McPlayerEntity mcPlayer, McHand mcHand) {
        World world = (World) mcWorld.get();
        PlayerEntity player = (PlayerEntity) mcPlayer.get();
        Hand hand = (Hand) mcHand.get();
        itemStack.use(world, player, hand);
        ItemStack stackResult = itemStack.finishUsing(world, player);
        return McItemStackImpl.of(stackResult);
    }

    @Override
    public Integer getCount() {
        return itemStack.getCount();
    }

    @Override
    public McItem getItem() {
        Item item = itemStack.getItem();
        return McItemImpl.of(item);
    }
}
