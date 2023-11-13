package cool.muyucloud.potbreaker.tunnel;

import cool.muyucloud.tunnel.annotation.Tunnel;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.world.World;

@Tunnel
public class McItemUsageContextImpl extends McItemUsageContext {
    private ItemUsageContext itemUsageContext;

    public static McItemUsageContextImpl of(ItemUsageContext itemUsageContext) {
        McItemUsageContextImpl mcItemUsageContext = new McItemUsageContextImpl();
        mcItemUsageContext.itemUsageContext = itemUsageContext;
        return mcItemUsageContext;
    }

    @Override
    public McItemUsageContext of(McWorld mcWorld, McPlayerEntity mcPlayer, McHand mcHand, McItemStack mcStack, McBlockHitResult mcResult) {
        World world = (World) mcWorld.get();
        PlayerEntity player = (PlayerEntity) mcPlayer.get();
        Hand hand = (Hand) mcHand.get();
        ItemStack stack = (ItemStack) mcStack.get();
        BlockHitResult result = (BlockHitResult) mcResult.get();
        ItemUsageContext context = new ItemUsageContext(world, player, hand, stack, result);
        return of(context);
    }

    @Override
    public Object get() {
        return itemUsageContext;
    }

    @Override
    public void initTunnel() {
        TUNNEL = new McItemUsageContextImpl();
    }
}
