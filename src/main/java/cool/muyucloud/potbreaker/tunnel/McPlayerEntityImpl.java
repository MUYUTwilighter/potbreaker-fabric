package cool.muyucloud.potbreaker.tunnel;

import cool.muyucloud.tunnel.annotation.Tunnel;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;

@Tunnel
public class McPlayerEntityImpl extends McPlayerEntity {
    PlayerEntity playerEntity;

    public static McPlayerEntity of(PlayerEntity playerEntity) {
        McPlayerEntityImpl mcPlayerEntity = new McPlayerEntityImpl();
        mcPlayerEntity.playerEntity = playerEntity;
        return mcPlayerEntity;
    }

    @Override
    public Object get() {
        return playerEntity;
    }

    @Override
    public void initTunnel() {
    }

    @Override
    public McVec3d getPos() {
        Vec3d pos = playerEntity.getPos();
        return McVec3dImpl.of(pos);
    }

    @Override
    public McItemStack getMainHandStack() {
        ItemStack itemStack = playerEntity.getMainHandStack();
        return McItemStackImpl.of(itemStack);
    }

    @Override
    public void setMainHandStack(McItemStack mcItemStack) {
        ItemStack itemStack = (ItemStack) mcItemStack.get();
        playerEntity.setStackInHand(Hand.MAIN_HAND, itemStack);
    }

    @Override
    public double getX() {
        return playerEntity.getX();
    }

    @Override
    public double getY() {
        return playerEntity.getY();
    }

    @Override
    public double getZ() {
        return playerEntity.getZ();
    }

    @Override
    public void setPos(double x, double y, double z) {
        playerEntity.setPos(x, y, z);
    }

    @Override
    public float getPitch() {
        return playerEntity.getPitch();
    }

    @Override
    public void setPitch(float pitch) {
        playerEntity.setPitch(pitch);
    }
}
