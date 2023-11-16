package cool.muyucloud.potbreaker.tunnel;

import cool.muyucloud.tunnel.annotation.Tunnel;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.DecoratedPotBlockEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@Tunnel
public class McWorldImpl extends McWorld {
    private World world;

    public static McWorld of(World world) {
        if (world instanceof ServerWorld serverWorld) {
            return McServerWorldImpl.of(serverWorld);
        } else {
            McWorldImpl mcWorld = new McWorldImpl();
            mcWorld.world = world;
            return mcWorld;
        }
    }

    @Override
    public Boolean isClient() {
        return world.isClient();
    }

    @Override
    public Object get() {
        return world;
    }

    @Override
    public void initTunnel() {}

    @Override
    public McBlockEntity getBlockEntity(McBlockPos mcPos) {
        BlockPos pos = (BlockPos) mcPos.get();
        BlockEntity be = world.getBlockEntity(pos);
        if (be instanceof DecoratedPotBlockEntity decoratedPotBe) {
            return McDecoratedPotBlockEntityImpl.of(decoratedPotBe);
        } else {
            return McBlockEntityImpl.of(be);
        }
    }

    @Override
    public Boolean isReceivingRedstonePower(McBlockPos mcPos) {
        BlockPos pos = (BlockPos) mcPos.get();
        return world.isReceivingRedstonePower(pos);
    }
}
