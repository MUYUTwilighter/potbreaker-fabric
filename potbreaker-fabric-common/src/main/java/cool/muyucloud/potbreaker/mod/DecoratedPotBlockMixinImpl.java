package cool.muyucloud.potbreaker.mod;

import cool.muyucloud.potbreaker.tunnel.*;

import java.util.Set;

import static cool.muyucloud.potbreaker.tunnel.Config.CONFIG;
import static cool.muyucloud.potbreaker.tunnel.McIdentifier.IDENTIFIER;

public class DecoratedPotBlockMixinImpl {
    public static void onBreak(McWorld world, McBlockPos pos, McPlayerEntity player) {
        if (CONFIG.allowOnBreak()) {
            executeUse(world, pos, player);
        }
    }

    public static void onProjectileHit(McWorld world, McBlockHitResult hit, McProjectileEntity projectile) {
        if (CONFIG.allowOnProject()) {
            McEntity owner = projectile.getOwner();
            if (owner instanceof McPlayerEntity player) {
                executeUse(world, hit.getBlockPos(), player);
            }
        }
    }

    public static void executeUse(McWorld world, McBlockPos pos, McPlayerEntity player) {
        if (world.isClient()) {
            return;
        }
        if (CONFIG.requireRedstone()) {
            boolean receivingRedstonePower = world.isReceivingRedstonePower(pos);
            if (!receivingRedstonePower) {
                return;
            }
        }
        McDecoratedPotBlockEntity be = (McDecoratedPotBlockEntity) world.getBlockEntity(pos);
        if (be == null) {
            return;
        }
        McItemStack stack = be.getStack();
        if (!allowItemIn(stack)) {
            return;
        }
        player.setPos(player.getX(), player.getY() + 2, player.getZ());
        float pitch = player.getPitch();
        player.setPitch(90);
        for (int i = 0; i < stack.getCount() && i < CONFIG.getMaxUses(); ++i) {
            boolean placeSuccess = tryPlaceItem(world, pos, player, stack);
            if (placeSuccess) {
                continue;
            }
            tryUseItem(world, player, be, stack);
        }
        player.setPos(player.getX(), player.getY() - 2, player.getZ());
        player.setPitch(pitch);
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

    private static Boolean allowItemIn(McItemStack stack) {
        Set<String> whitelist = CONFIG.getWhitelist();
        if (whitelist == null) {
            return true;
        } else {
            McItem item = stack.getItem();
            for (String row : whitelist) {
                if (row.startsWith("#")) {
                    row = row.substring(1);
                    McIdentifier identifier = IDENTIFIER.tryParse(row);
                    if (identifier == null) {
                        continue;
                    }
                    McItemGroup itemGroup = (McItemGroup) McRegistry.ITEM_GROUP.get(identifier);
                    if (itemGroup == null) {
                        continue;
                    }
                    if (itemGroup.contains(stack)) {
                        return true;
                    }
                } else {
                    McIdentifier identifier = IDENTIFIER.tryParse(row);
                    if (identifier == null) {
                        continue;
                    }
                    McItem tmpItem = (McItem) McRegistry.ITEM.get(identifier);
                    if (item == null) {
                        continue;
                    }
                    if (item.get() == tmpItem.get()) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
