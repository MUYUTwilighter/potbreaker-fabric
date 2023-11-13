package cool.muyucloud.potbreaker.tunnel;

import cool.muyucloud.tunnel.annotation.Tunnel;
import net.minecraft.block.entity.BlockEntity;

@Tunnel
public class McBlockEntityImpl implements McBlockEntity {
    BlockEntity blockEntity;

    public static McBlockEntityImpl of(BlockEntity be) {
        McBlockEntityImpl mcBe = new McBlockEntityImpl();
        mcBe.blockEntity = be;
        return mcBe;
    }

    @Override
    public Object get() {
        return blockEntity;
    }

    @Override
    public void initTunnel() {}
}
