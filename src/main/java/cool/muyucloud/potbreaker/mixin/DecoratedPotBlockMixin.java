package cool.muyucloud.potbreaker.mixin;

import cool.muyucloud.potbreaker.mod.DecoratedPotBlockMixinImpl;
import cool.muyucloud.potbreaker.tunnel.*;
import net.fabricmc.fabric.api.entity.FakePlayer;
import net.minecraft.block.BlockState;
import net.minecraft.block.DecoratedPotBlock;
import net.minecraft.command.argument.ItemPredicateArgumentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.registry.Registries;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DecoratedPotBlock.class)
public class DecoratedPotBlockMixin {
    @Inject(
        method = "onBreak",
        at = @At(value = "INVOKE",
            target = "Lnet/minecraft/world/World;setBlockState(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;I)Z",
            shift = At.Shift.AFTER)
    )
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player, CallbackInfoReturnable<BlockState> cir) {
        McWorld mcWorld = McWorldImpl.of(world);
        McBlockPos mcPos = McBlockPosImpl.of(pos);
        McPlayerEntity mcPlayer = McPlayerEntityImpl.of(player);
        DecoratedPotBlockMixinImpl.onBreak(mcWorld, mcPos, mcPlayer);
    }

    @Inject(
        method = "onProjectileHit",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/world/World;setBlockState(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;I)Z",
            shift = At.Shift.AFTER
        )
    )
    public void onProjectileHit(World world, BlockState state, BlockHitResult hit, ProjectileEntity projectile, CallbackInfo ci) {
        McWorld mcWorld = McWorldImpl.of(world);
        McBlockHitResult mcHit = McBlockHitResultImpl.of(hit);
        McProjectileEntity mcProjectile = McProjectileEntityImpl.of(projectile);
        DecoratedPotBlockMixinImpl.onProjectileHit(mcWorld, mcHit, mcProjectile);
    }
}
