package cool.muyucloud.potbreaker.mod;

import cool.muyucloud.potbreaker.tunnel.*;

public class DecoratedPotBlockMixinImpl {
    private static final Config CONFIG = Config.INSTANCE;

    public static void onBreak(McWorld world, McBlockPos pos, McPlayerEntity player) {
        McDecoratedPotBlockEntity be = (McDecoratedPotBlockEntity) world.getBlockEntity(pos);
        if (be == null || world.isClient()) {
            return;
        }
        McItemStack stack = be.getStack();
        for (int i = 0; i < stack.getCount() && i < CONFIG.getMaxExecutes(); ++i) {
            if (CONFIG.canPlace()) {
                boolean placeResult = tryPlaceItem(world, pos, player, stack);
                if (placeResult) {
                    continue;
                }
            }
            if (CONFIG.canUse()) {
                tryUseItem(world, player, be, stack);
            }
        }
    }

    private static void tryUseItem(McWorld world, McPlayerEntity player, McDecoratedPotBlockEntity be, McItemStack stack) {
        McItemStack playerStack = player.getMainHandStack();
        player.setMainHandStack(stack);
        McItemStack stackResult = stack.use(world, player, McHand.MAIN_HAND);
        be.setStack(stackResult);
        player.setMainHandStack(playerStack);
    }

    private static Boolean tryPlaceItem(McWorld world, McBlockPos pos, McPlayerEntity player, McItemStack stack) {
        McBlockHitResult result = McBlockHitResult.TUNNEL.of(player.getPos(), McDirection.UP, pos.down(), false);
        McItemUsageContext context = McItemUsageContext.TUNNEL.of(world, player, McHand.MAIN_HAND, stack, result);
        McActionResult actionResult = stack.useOnBlock(context);
        return actionResult.get() != McActionResult.FAIL.get() && actionResult.get() != McActionResult.PASS.get();
    }
}
