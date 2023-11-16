package cool.muyucloud.potbreaker.tunnel;

import cool.muyucloud.tunnel.annotation.Tunnel;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;

@Tunnel
public class McBlockHitResultImpl extends McBlockHitResult {
    private BlockHitResult blockHitResult;

    public static McBlockHitResultImpl of(BlockHitResult blockHitResult) {
        McBlockHitResultImpl mcBlockHitResult = new McBlockHitResultImpl();
        mcBlockHitResult.blockHitResult = blockHitResult;
        return mcBlockHitResult;
    }

    @Override
    public McBlockHitResult of(McVec3d mcPos, McDirection mcSide, McBlockPos mcBlockPos, boolean insideBlock) {
        Vec3d pos = (Vec3d) mcPos.get();
        Direction side = (Direction) mcSide.get();
        BlockPos blockPos = (BlockPos) mcBlockPos.get();
        BlockHitResult blockHitResult = new BlockHitResult(pos, side, blockPos, insideBlock);
        return of(blockHitResult);
    }

    @Override
    public Object get() {
        return blockHitResult;
    }

    @Override
    public void initTunnel() {
        TUNNEL = new McBlockHitResultImpl();
    }

    @Override
    public McBlockPos getBlockPos() {
        BlockPos blockPos = blockHitResult.getBlockPos();
        return McBlockPosImpl.of(blockPos);
    }
}
