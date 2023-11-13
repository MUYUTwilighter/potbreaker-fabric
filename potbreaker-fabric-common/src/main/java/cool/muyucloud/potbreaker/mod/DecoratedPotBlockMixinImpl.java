package cool.muyucloud.potbreaker.mod;

import cool.muyucloud.potbreaker.tunnel.*;

public class DecoratedPotBlockMixinImpl {
    public static void onBreak(McWorld world, McBlockPos pos, McPlayerEntity player) {
        McDecoratedPotBlockEntity be = (McDecoratedPotBlockEntity) world.getBlockEntity(pos);
        if (be == null || world.isClient()) {
            return;
        }
        McItemStack stack = be.getStack();
        McBlockHitResult result = McBlockHitResult.TUNNEL.of(player.getPos(), McDirection.UP, pos.down(), false);
        McItemUsageContext context = McItemUsageContext.TUNNEL.of(world, player, McHand.MAIN_HAND, stack, result);
        stack.useOnBlock(context);
    }
}
