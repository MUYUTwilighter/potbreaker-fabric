package cool.muyucloud.potbreaker.tunnel;

import cool.muyucloud.tunnel.annotation.Tunnel;
import net.minecraft.util.math.BlockPos;

@Tunnel
public class McBlockPosImpl implements McBlockPos {
    private BlockPos blockPos;

    public static McBlockPosImpl of(BlockPos blockPos) {
        McBlockPosImpl mcBlockPos = new McBlockPosImpl();
        mcBlockPos.blockPos = blockPos;
        return mcBlockPos;
    }

    @Override
    public Object get() {
        return blockPos;
    }

    @Override
    public void initTunnel() {}

    @Override
    public McBlockPos down() {
        BlockPos pos = blockPos.down();
        return of(pos);
    }

    @Override
    public int getX() {
        return blockPos.getX();
    }

    @Override
    public int getY() {
        return blockPos.getY();
    }

    @Override
    public int getZ() {
        return blockPos.getZ();
    }
}
