package cool.muyucloud.potbreaker.tunnel;

import cool.muyucloud.tunnel.annotation.Tunnel;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.DecoratedPotBlockEntity;

@Tunnel
public class McBlockEntityImpl implements McBlockEntity {
    BlockEntity blockEntity;

    public static McBlockEntity of(BlockEntity be) {
        if (be instanceof DecoratedPotBlockEntity decoratedPotBlockEntity) {
            return McDecoratedPotBlockEntityImpl.of(decoratedPotBlockEntity);
        } else {
            McBlockEntityImpl mcBe = new McBlockEntityImpl();
            mcBe.blockEntity = be;
            return mcBe;
        }
    }

    @Override
    public Object get() {
        return blockEntity;
    }

    @Override
    public void initTunnel() {}
}
