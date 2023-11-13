package cool.muyucloud.potbreaker.tunnel;

import cool.muyucloud.tunnel.annotation.Tunnel;
import net.minecraft.block.entity.DecoratedPotBlockEntity;
import net.minecraft.item.ItemStack;

@Tunnel
public class McDecoratedPotBlockEntityImpl implements McDecoratedPotBlockEntity {
    private DecoratedPotBlockEntity decoratedPotBlockEntity;

    public static McDecoratedPotBlockEntityImpl of(DecoratedPotBlockEntity be) {
        McDecoratedPotBlockEntityImpl mcBe = new McDecoratedPotBlockEntityImpl();
        mcBe.decoratedPotBlockEntity = be;
        return mcBe;
    }

    @Override
    public DecoratedPotBlockEntity get() {
        return decoratedPotBlockEntity;
    }

    @Override
    public void initTunnel() {}

    @Override
    public McItemStack getStack() {
        ItemStack itemStack = decoratedPotBlockEntity.getStack();
        return McItemStackImpl.of(itemStack);
    }
}
