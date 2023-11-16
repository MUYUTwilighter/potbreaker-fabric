package cool.muyucloud.potbreaker.tunnel;

import cool.muyucloud.tunnel.annotation.Tunnel;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

@Tunnel
public class McServerWorldImpl extends McServerWorld {
    ServerWorld serverWorld;

    public static McServerWorld of(ServerWorld serverWorld) {
        McServerWorldImpl mcServerWorld = new McServerWorldImpl();
        mcServerWorld.serverWorld = serverWorld;
        return mcServerWorld;
    }

    @Override
    public Boolean isClient() {
        return serverWorld.isClient;
    }

    @Override
    public McBlockEntity getBlockEntity(McBlockPos mcPos) {
        BlockPos pos = (BlockPos) mcPos.get();
        BlockEntity be = serverWorld.getBlockEntity(pos);
        return McBlockEntityImpl.of(be);
    }

    @Override
    public Boolean isReceivingRedstonePower(McBlockPos mcPos) {
        BlockPos pos = (BlockPos) mcPos.get();
        return serverWorld.isReceivingRedstonePower(pos);
    }

    @Override
    public Object get() {
        return serverWorld;
    }

    @Override
    public void initTunnel() {

    }
}
